package payrollSystem.views;

import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

import java.awt.Dimension;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class SeePayroll extends JFrame {

	private JPanel contentPane;
	private JTextField textID;
	private JTextField textDate;
	private JLabel lblExit;
	private JButton btnSeePayroll;
	private JButton btnPreObject;
	private JScrollPane scrollPane;
	private JTable tablePayroll;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeePayroll frame = new SeePayroll();
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
	public SeePayroll()
	{
		initComponents();
		createEvents();
	
		
	}

	private void initComponents()
	{	
		setIconImage(Toolkit.getDefaultToolkit().getImage(PreparePayroll.class.getResource("/payrollSystem/resources/money_64_.png")));
		setTitle("SEE PAYROLL");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 533, 554);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.window);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblYourEmployeeId = new JLabel("YOUR EMPLOYEE ID :");
		lblYourEmployeeId.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		
		textID = new JTextField();
		textID.setFont(new Font("Segoe UI", Font.BOLD, 13));
		textID.setColumns(10);
		
		JLabel lblDate = new JLabel("PAY DATE :");
		lblDate.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		
		textDate = new JTextField();
		textDate.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		textDate.setColumns(10);
		
		btnSeePayroll = new JButton("");
		

		
		btnSeePayroll.setToolTipText("SEE PAYROLL");
		btnSeePayroll.setIcon(new ImageIcon(SeePayroll.class.getResource("/payrollSystem/resources/click_64.png")));
		
		btnPreObject = new JButton("");
		
		btnPreObject.setToolTipText("PREPARE OBJECTION");
		btnPreObject.setIcon(new ImageIcon(SeePayroll.class.getResource("/payrollSystem/resources/taxes_64.png")));
		
		lblExit = new JLabel("");
		
		lblExit.setIcon(new ImageIcon(SeePayroll.class.getResource("/payrollSystem/resources/door_64.png")));
		
		scrollPane = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(45)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnSeePayroll, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblYourEmployeeId))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textID, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblDate))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(65)
							.addComponent(lblExit)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
							.addComponent(btnPreObject, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
							.addGap(42))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textDate, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(47, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 439, GroupLayout.PREFERRED_SIZE)
					.addGap(37))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(33)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblYourEmployeeId, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
						.addComponent(textID, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDate, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
						.addComponent(textDate, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblExit, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnSeePayroll, 0, 0, Short.MAX_VALUE)
						.addComponent(btnPreObject, GroupLayout.PREFERRED_SIZE, 65, Short.MAX_VALUE))
					.addGap(40)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(176, Short.MAX_VALUE))
		);
		
		tablePayroll = new JTable();
		scrollPane.setViewportView(tablePayroll);
		contentPane.setLayout(gl_contentPane);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/3-this.getSize().height/6);
		setUndecorated(true);
	}

	private void createEvents()
	{
		btnSeePayroll.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String query = "Select NAME,SURNAME,GROSS,DEDUCTION,NET From PAYROLL where ID=? and DATE=?";
				if(textID.getText().equals("")&&textDate.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "..PLEASE ENTER YOUR EMPLOYEE ID AND DATE..");
				}
				else
				{
					try
					{
						Class.forName("org.h2.Driver");
						Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
						PreparedStatement statement = connection.prepareStatement(query);
						statement.setString(1, textID.getText());
						statement.setString(2, textDate.getText());
						ResultSet set = statement.executeQuery();
						tablePayroll.setModel(DbUtils.resultSetToTableModel(set));

					} catch (ClassNotFoundException | SQLException e1)
					{
						e1.printStackTrace();
					}
				}
			}
		});
		lblExit.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent arg0)
			{
				dispose();
			}
		});
		btnPreObject.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				PrepareObjection prepare = new PrepareObjection();
				prepare.setVisible(true);
			}
		});
	}

}
