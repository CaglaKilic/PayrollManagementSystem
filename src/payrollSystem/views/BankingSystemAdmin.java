package payrollSystem.views;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class BankingSystemAdmin extends JFrame {

	private JPanel contentPane;
	private JTextField textDate;
	private JCheckBox chckbxConfirm;
	private JButton btnTransaction;
	private JLabel lblExit;
	private JButton buttonLoad;
	private JScrollPane scrollPane;
	private JTable tablePayrolls;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BankingSystemAdmin frame = new BankingSystemAdmin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BankingSystemAdmin() 
	{
		initComponents();
		createEvents();
	}
	

	private void initComponents()
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage(PreparePayroll.class.getResource("/payrollSystem/resources/money_64_.png")));
		setTitle("BANKING SYSTEM");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 533, 554);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.window);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		textDate = new JTextField();
		textDate.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		textDate.setColumns(10);
		
		JLabel lblPayDate = new JLabel("PAY DATE :");
		lblPayDate.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		
		buttonLoad = new JButton("LOAD PAYROLLS");
		
		buttonLoad.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		
		chckbxConfirm = new JCheckBox("CONFIRM PAYROLL DOCUMENT");
		chckbxConfirm.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		
		btnTransaction = new JButton("");
		
		btnTransaction.setToolTipText("TRANSACTION");
		btnTransaction.setIcon(new ImageIcon(BankingSystemAdmin.class.getResource("/payrollSystem/resources/transaction_64.png")));
		
		lblExit = new JLabel("");
		
		lblExit.setIcon(new ImageIcon(BankingSystemAdmin.class.getResource("/payrollSystem/resources/log-out_128.png")));
		
		scrollPane = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(23, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(chckbxConfirm)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(buttonLoad, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
										.addGap(134)
										.addComponent(lblPayDate, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
										.addGap(10)
										.addComponent(textDate, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))))
							.addGap(44))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblExit)
							.addGap(93)
							.addComponent(btnTransaction, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
							.addGap(140))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(21)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(25)
							.addComponent(buttonLoad, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(8)
							.addComponent(textDate, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblPayDate, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addComponent(chckbxConfirm)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblExit, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnTransaction, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(122, Short.MAX_VALUE))
		);
		
		tablePayrolls = new JTable();
		scrollPane.setViewportView(tablePayrolls);
		contentPane.setLayout(gl_contentPane);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/3-this.getSize().height/6);
		setUndecorated(true);
	}
	private void createEvents()
	{
		
		buttonLoad.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String query = "Select NAME,SURNAME,GROSS,DEDUCTION,NET From PAYROLL where DATE=?";
				try
				{
					Class.forName("org.h2.Driver");
					Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
					PreparedStatement statement = connection.prepareStatement(query);
					statement.setString(1, textDate.getText());
					ResultSet set = statement.executeQuery();
					tablePayrolls.setModel(DbUtils.resultSetToTableModel(set));
					
				} catch (ClassNotFoundException | SQLException e1)
				{
					e1.printStackTrace();
				}
			}
		});
		btnTransaction.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(chckbxConfirm.isSelected()) 
				{
					if(textDate.getText().equals(""))
					{
						JOptionPane.showMessageDialog(null, "PLEASE ENTER THE PAY DATE");
					}
					else 
					{
						JOptionPane.showMessageDialog(null, "TRANSACTION IS SUCCESSFUL");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "PLEASE CHECK THE BOX");
				}
				textDate.setText("");
				chckbxConfirm.setSelected(false);
			}
		});
		lblExit.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				dispose();
			}
		});
	}
}
