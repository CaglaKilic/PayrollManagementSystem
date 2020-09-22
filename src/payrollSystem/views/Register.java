package payrollSystem.views;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Toolkit;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField textName;
	private JTextField textSurname;
	private JTextField textMail;
	private JTextField textUserName;
	private JPasswordField passwordField;
	private JPasswordField passwordFieldA;
	private JButton btnRegister;
	private JLabel labelID;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	public Register()
	{
		initComponents();
		createEvents();
	}

	private void initComponents() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Register.class.getResource("/payrollSystem/resources/money_64_.png")));
		setTitle("PAYROLL MANAGEMENT SYSTEM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.window);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JSeparator separator = new JSeparator();
		
		JLabel lblRegster = new JLabel("REGISTRATION FORM");
		lblRegster.setForeground(Color.BLACK);
		lblRegster.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 35));
		
		JSeparator separator_1 = new JSeparator();
		
		JLabel lblFrstName = new JLabel("FIRST NAME : ");
		lblFrstName.setForeground(Color.BLACK);
		lblFrstName.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		
		JLabel lblLastName = new JLabel("LAST NAME : ");
		lblLastName.setForeground(Color.BLACK);
		lblLastName.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		
		textName = new JTextField();
		textName.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 15));
		textName.setColumns(10);
		
		textSurname = new JTextField();
		textSurname.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 15));
		textSurname.setColumns(10);
		
		JLabel lblEmal = new JLabel("E-MAIL                           : ");
		lblEmal.setForeground(Color.BLACK);
		lblEmal.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		
		textMail = new JTextField();
		textMail.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 15));
		textMail.setColumns(10);
		
		JLabel lblUserName = new JLabel("USER NAME                  : ");
		lblUserName.setForeground(Color.BLACK);
		lblUserName.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		
		textUserName = new JTextField();
		textUserName.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 15));
		textUserName.setColumns(10);
		
		JLabel lblPassword = new JLabel("PASSWORD                  : ");
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		
		JLabel lblPasswordAgan = new JLabel("PASSWORD AGAIN   : ");
		lblPasswordAgan.setForeground(Color.BLACK);
		lblPasswordAgan.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		
		passwordField = new JPasswordField();
		
		passwordFieldA = new JPasswordField();
		
		btnRegister = new JButton("REGISTER");
		btnRegister.setForeground(Color.BLACK);
		
		btnRegister.setFont(new Font("Broadway", Font.PLAIN, 19));
		
		labelID = new JLabel("");
		labelID.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 15));
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Register.class.getResource("/payrollSystem/resources/resume_256.png")));
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Register.class.getResource("/payrollSystem/resources/account_128.png")));
		
		lblNewLabel = new JLabel("");
		
		lblNewLabel.setIcon(new ImageIcon(Register.class.getResource("/payrollSystem/resources/previous_64.png")));
		lblNewLabel.setToolTipText("BACK");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(separator, GroupLayout.DEFAULT_SIZE, 1336, Short.MAX_VALUE)
						.addComponent(separator_1, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 1336, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(456, Short.MAX_VALUE)
					.addComponent(lblRegster)
					.addGap(445))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(80)
					.addComponent(label)
					.addGap(4)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 177, Short.MAX_VALUE)
							.addComponent(btnRegister, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
							.addGap(422)
							.addComponent(lblNewLabel)
							.addGap(36))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(87)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblEmal, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
										.addComponent(lblUserName, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblPassword)
										.addComponent(lblPasswordAgan))
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
										.addComponent(passwordFieldA, GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
										.addComponent(textUserName, GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
										.addComponent(textMail, GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblFrstName, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textName, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
									.addGap(30)
									.addComponent(lblLastName, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textSurname, GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)))
							.addGap(128)
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
							.addGap(81))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 175, Short.MAX_VALUE)
							.addComponent(labelID, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
							.addGap(591))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(lblRegster, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(43)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 357, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(labelID, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
									.addGap(30)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblFrstName, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
										.addComponent(textName, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
										.addComponent(textSurname, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblLastName, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(textMail, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblEmal, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
									.addGap(27)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(textUserName, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblUserName, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
										.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
									.addGap(20)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(passwordFieldA, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblPasswordAgan, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
									.addGap(58))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(92)
									.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
									.addGap(81)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnRegister, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
									.addGap(57))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel, 0, 0, Short.MAX_VALUE)
									.addContainerGap())))))
		);
		contentPane.setLayout(gl_contentPane);
		
	}

	private void createEvents()
	{
		btnRegister.addActionListener(new ActionListener()
		{
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0)
			{
				if((textName.getText().equals("")) || textSurname.getText().equals("") || textMail.getText().equals("") || 
						textUserName.getText().equals("") || passwordField.getText().equals("") || passwordFieldA.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "ALL MUST BE FILLED");
				}
				else{
					String password = new String(passwordField.getPassword());
					String password1 = new String(passwordFieldA.getPassword());
					System.out.println(password + " " + password1);
					if(!(password).equals(password1))
					{
						JOptionPane.showMessageDialog(null, "Passwords are not matches!!!");
					}
					else{
				try {
					String userNameInput = textUserName.getText();
					Class.forName("org.h2.Driver");
					Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
					PreparedStatement st = connection.prepareStatement("select USERNAME from USER_INFO where USERNAME='"+userNameInput+"'");
			        ResultSet r1=st.executeQuery();
			        String usernameCounter;
			        if(r1.next())
			        {
			            usernameCounter = r1.getString("USERNAME");
			            if(usernameCounter.equals(userNameInput))
			            {
			                System.out.println(userNameInput);
			                JOptionPane.showMessageDialog(null, "..PLEASE TRY A NEW USERNAME..");
							textUserName.setText("");
			            }
			        }
			        else
			        {
							Class.forName("org.h2.Driver");
							Connection connection2 = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
			            	String insert_data = "insert into USER_INFO values(?,?,?,?,?,?)";
			            	PreparedStatement statement = connection2.prepareStatement(insert_data);
			            	statement.setString(1, labelID.getName());
			            	statement.setString(2, textName.getText());
			            	statement.setString(3, textSurname.getText());
			            	statement.setString(4, textMail.getText());
			            	statement.setString(5, textUserName.getText());
			            	statement.setString(6, passwordField.getText());
					
			            	int data_entered = statement.executeUpdate();
					
			            	if(data_entered>0)
			            	{
			            		JOptionPane.showMessageDialog(null, "SUCCESSFULLY REGISTERED!" + "\n \n Now You can LOGIN...");
						
			            		Login loginPage = new Login();
			            		loginPage.setVisible(true);
						
			            		dispose();
			            	}
			            	else
			            	{
			            		JOptionPane.showMessageDialog(null, "UNABLE TO INSERT DATA");
			            	} 
			        }
				} catch (ClassNotFoundException | SQLException e)
				{
					e.printStackTrace();
				}
					}
				}
			}
		});
		lblNewLabel.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				Login loginPage = new Login();
				loginPage.setVisible(true);
				
				dispose();
			}
		});
	}
}
