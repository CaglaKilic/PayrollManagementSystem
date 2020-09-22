package payrollSystem.views;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

@SuppressWarnings("serial")
public class PreparePayroll extends JFrame {

	private JPanel contentPane;
	private JTextField textEmpID;
	private JTextField textName;
	private JTextField textSurname;
	private JTextField textGross;
	private JTextField textDeduct;
	private JButton buttonSave;
	private JLabel lblDate;
	private JTextField textDate;
	private JLabel label;
	private JLabel Net;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PreparePayroll frame = new PreparePayroll();
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
	public PreparePayroll()
	{
		initComponents();
		createEvetns();
	}

	private void initComponents()
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage(PreparePayroll.class.getResource("/payrollSystem/resources/money_64_.png")));
		setTitle("PREPARE PAYROLL");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 605, 554);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.window);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblEmployeeId = new JLabel("EMPLOYEE ID        :");
		lblEmployeeId.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		
		JLabel lblEmployeeName = new JLabel("EMPLOYEE NAME  :");
		lblEmployeeName.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		
		JLabel lblEmployeeSurname = new JLabel("EMPLOYEE SURNAME  :");
		lblEmployeeSurname.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		
		JLabel lblAnnualGross = new JLabel("TOTAL REVENUE      :");
		lblAnnualGross.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		
		JSeparator separator = new JSeparator();
		
		JLabel lblBonusesPremumOvertme = new JLabel("TOTAL DEDUCTION  :");
		lblBonusesPremumOvertme.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		
		JLabel lblNet = new JLabel("NET       :");
		lblNet.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		
		textEmpID = new JTextField();
		textEmpID.setForeground(Color.BLACK);
		
		textEmpID.setFont(new Font("Segoe UI", Font.BOLD, 13));
		textEmpID.setColumns(10);
		
		textName = new JTextField();
		textName.setForeground(Color.BLACK);
		textName.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		textName.setColumns(10);
		
		textSurname = new JTextField();
		textSurname.setForeground(Color.BLACK);
		textSurname.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		textSurname.setColumns(10);
		
		textGross = new JTextField();
		textGross.setForeground(Color.BLACK);
		textGross.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		textGross.setColumns(10);
		
		textDeduct = new JTextField();
		textDeduct.setForeground(Color.BLACK);
		textDeduct.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		textDeduct.setColumns(10);
		
		buttonSave = new JButton("");
		
		buttonSave.setIcon(new ImageIcon(PreparePayroll.class.getResource("/payrollSystem/resources/collaboration_64.png")));
		buttonSave.setToolTipText("SAVE");
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(PreparePayroll.class.getResource("/payrollSystem/resources/log-out_128.png")));
		
		lblDate = new JLabel("PAY DATE     :");
		lblDate.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		
		textDate = new JTextField();
		textDate.setForeground(Color.BLACK);
		textDate.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		textDate.setColumns(10);
		
		Net = new JLabel("0.0");
		Net.setForeground(SystemColor.textHighlight);
		Net.setFont(new Font("Segoe UI", Font.BOLD, 15));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(separator, GroupLayout.DEFAULT_SIZE, 575, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(30)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblAnnualGross)
											.addGap(18)
											.addComponent(textGross, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblBonusesPremumOvertme)
											.addGap(18)
											.addComponent(textDeduct, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)))
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
											.addComponent(lblNet)
											.addGap(23))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(48)
											.addComponent(lblDate)
											.addPreferredGap(ComponentPlacement.RELATED)))
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(Net, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
										.addComponent(textDate, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE))
									.addGap(38)))
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
							.addGap(86)
							.addComponent(buttonSave)
							.addGap(169))))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(40)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblEmployeeName)
						.addComponent(lblEmployeeId))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(textEmpID, 0, 0, Short.MAX_VALUE)
						.addComponent(textName, GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
					.addGap(33)
					.addComponent(lblEmployeeSurname)
					.addGap(18)
					.addComponent(textSurname, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(50, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(121, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEmployeeId, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(textEmpID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(15)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(textName, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblEmployeeSurname, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
							.addComponent(textSurname, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblEmployeeName, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textGross, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAnnualGross, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
						.addComponent(textDate, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDate, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBonusesPremumOvertme, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
						.addComponent(textDeduct, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(Net, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNet, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
					.addGap(57)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
						.addComponent(buttonSave, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
					.addGap(61))
		);
		contentPane.setLayout(gl_contentPane);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/3-this.getSize().height/6);
		setUndecorated(true);
		
	}

	private void createEvetns()
	{
		textEmpID.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseReleased(MouseEvent arg0)
			{
				if(textEmpID.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "..PLEASE ENTER YOUR EMPLOYEE ID AND DATE..");
				}
				else
				{
					try
					{
						Class.forName("org.h2.Driver");
						Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
						String userID = textEmpID.getText();
					
						String query = "select * from DETAIL_INFO where ID =?";
						PreparedStatement statement = connection.prepareStatement(query);
						statement.setString(1, userID);
					
						ResultSet set = statement.executeQuery();
						while(set.next())
						{
							textName.setText(set.getString("NAME"));
							textSurname.setText(set.getString("SURNAME"));
						}
					
					} catch (ClassNotFoundException | SQLException e1)
					{
						e1.printStackTrace();
					}
				}
			}
		});
		buttonSave.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				if(((textName.getText().equals("")) || textSurname.getText().equals("") || textEmpID.getText().equals("") || 
						textGross.getText().equals("") || textDate.getText().equals("") 
						|| textDeduct.getText().equals("")))
				{
					JOptionPane.showMessageDialog(null, "..OPSS.. ALL MUST BE FILLED..");
				}
				else
				{
					double gross = (Double.parseDouble((String)textGross.getText()));
					double deduct = (Double.parseDouble((String) textDeduct.getText()));
					double total = (double)gross - (double)deduct;
					Net.setText(String.valueOf(total));
				try
				{
					
					Class.forName("org.h2.Driver");
					Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
					String insert_data = "insert into PAYROLL values(?,?,?,?,?,?,?)";
					PreparedStatement statement = connection.prepareStatement(insert_data);
					
					statement.setString(1, textEmpID.getText());
					statement.setString(2, textName.getText());
					statement.setString(3, textSurname.getText());
					statement.setString(4, textDate.getText());
					statement.setString(5, textGross.getText());
					statement.setString(6, textDeduct.getText());
					statement.setString(7, Net.getText());
					
					int data_entered = statement.executeUpdate();
					if(data_entered>0)
					{
						JOptionPane.showMessageDialog(null, "..PAYROLL SAVED..");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "..PAYROLL DID NOT SAVE..");
					}
					textName.setText("");
					textSurname.setText("");
					textEmpID.setText("");
					textDate.setText("");
					textGross.setText("");
					textDeduct.setText("");
					Net.setText("0.0");
				}
				catch (ClassNotFoundException | SQLException e)
				{
					
					e.printStackTrace();
				}
				}
			}
		});
		label.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent arg0)
			{
				dispose();
			}
		});
	}
}
