package payrollSystem.views;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.Color;

@SuppressWarnings("serial")
public class BankingSystem extends JFrame {

	private JPanel contentPane;
	private JButton btnSend;
	private JButton btnLoadPayrolls;
	private JLabel lblPayDate;
	private JTextField textDate;
	private JScrollPane scrollPane;
	private JTable tablePayrolls;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BankingSystem frame = new BankingSystem();
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
	public BankingSystem()
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
		
		btnSend = new JButton("");
		
		btnSend.setIcon(new ImageIcon(BankingSystem.class.getResource("/payrollSystem/resources/information_64.png")));
		btnSend.setToolTipText("SEND TO ADMIN");
		
		btnLoadPayrolls = new JButton("LOAD PAYROLLS");
		
		btnLoadPayrolls.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		
		lblPayDate = new JLabel("PAY DATE :");
		lblPayDate.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		
		textDate = new JTextField();
		textDate.setForeground(Color.BLACK);
		textDate.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		textDate.setColumns(10);
		
		scrollPane = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnLoadPayrolls)
							.addPreferredGap(ComponentPlacement.RELATED, 136, Short.MAX_VALUE)
							.addComponent(lblPayDate, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textDate, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)))
					.addGap(37))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(230, Short.MAX_VALUE)
					.addComponent(btnSend, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
					.addGap(220))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(8)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnLoadPayrolls, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textDate, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPayDate, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
							.addGap(9)))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 249, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
					.addComponent(btnSend)
					.addGap(71))
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
		btnLoadPayrolls.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if(textDate.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "..PLEASE ENTER PAY DATE..");
				}
				else
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
			}
		});
		btnSend.addActionListener(new ActionListener()
		{
			
			public void actionPerformed(ActionEvent e)
			{
				if(textDate.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "..PLEASE ENTER PAY DATE..");
				}
				else
				{
					int p = JOptionPane.showConfirmDialog(null, "SEND TO ADMIN?", "Send Message", JOptionPane.YES_NO_OPTION);
					if(p == 0)
				{
					JOptionPane.showMessageDialog(null, ".....SENT.....");
				}
				}
				dispose();
			}
		});
	}

}
