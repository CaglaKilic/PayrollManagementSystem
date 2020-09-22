package payrollSystem.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class Login extends JFrame {
	
	private JPanel contentPane;
	private JTextField textUserName;
	private JButton btnLogn;
	private JButton buttonRegister;
	private JPasswordField passwordField;
	private JLabel lblChange;
	private JLabel labelID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login()
	{
		initComponents();
		createEvents();
	}

	private void initComponents()
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/payrollSystem/resources/money_64_.png")));
		setTitle("PAYROLL MANAGEMENT SYSTEM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.window);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JSeparator separator = new JSeparator();
		
		JLabel lblLogn = new JLabel("LOGIN");
		lblLogn.setForeground(Color.BLACK);
		lblLogn.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 35));
		
		JSeparator separator_1 = new JSeparator();
		
		JLabel lblUserName = new JLabel("USER NAME  :");
		lblUserName.setForeground(Color.BLACK);
		lblUserName.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		
		textUserName = new JTextField();
		
		textUserName.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 15));
		textUserName.setColumns(10);
		
		JLabel lblPassword = new JLabel("PASSWORD  :");
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		
		btnLogn = new JButton("LOGIN");

		
		btnLogn.setFont(new Font("Broadway", Font.PLAIN, 17));
		
		JSeparator separator_2 = new JSeparator();
		
		JLabel lblPleaseClckOn = new JLabel("PLEASE CLICK ON THE BUTTON");
		lblPleaseClckOn.setForeground(Color.BLACK);
		lblPleaseClckOn.setFont(new Font("Arial Unicode MS", Font.PLAIN, 26));
		
		JLabel lblIfYouAre = new JLabel("IF YOU ARE NOT ALREADY REGISTER");
		lblIfYouAre.setForeground(Color.BLACK);
		lblIfYouAre.setFont(new Font("Arial Unicode MS", Font.PLAIN, 26));
		
		buttonRegister = new JButton("REGISTER");
		
		buttonRegister.setIcon(new ImageIcon(Login.class.getResource("/payrollSystem/resources/click_64.png")));
		buttonRegister.setForeground(Color.BLACK);
		buttonRegister.setFont(new Font("Broadway", Font.PLAIN, 19));
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Login.class.getResource("/payrollSystem/resources/warning_128.png")));
		
		passwordField = new JPasswordField();
		
		JLabel lblIWantTo = new JLabel("I want to");
		lblIWantTo.setFont(new Font("Segoe UI", Font.BOLD, 15));
		
		lblChange = new JLabel("CHANGE");
		
		lblChange.setForeground(UIManager.getColor("MenuItem.selectionBackground"));
		lblChange.setFont(new Font("Segoe UI", Font.BOLD, 15));
		
		JLabel lblPassword_1 = new JLabel("password.");
		lblPassword_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		
		labelID = new JLabel("");
		labelID.setFont(new Font("Segoe UI", Font.BOLD, 20));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(609, Short.MAX_VALUE)
					.addComponent(lblLogn, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
					.addGap(598))
				.addComponent(separator_1, GroupLayout.DEFAULT_SIZE, 1356, Short.MAX_VALUE)
				.addComponent(separator, GroupLayout.DEFAULT_SIZE, 1356, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(separator_2, GroupLayout.DEFAULT_SIZE, 1346, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(154)
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.RELATED, 161, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblIfYouAre)
							.addGap(54))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblPleaseClckOn)
							.addGap(87)))
					.addGap(79)
					.addComponent(buttonRegister, GroupLayout.PREFERRED_SIZE, 251, GroupLayout.PREFERRED_SIZE)
					.addGap(55))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(62)
					.addComponent(labelID, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addComponent(lblUserName, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(textUserName, GroupLayout.PREFERRED_SIZE, 253, GroupLayout.PREFERRED_SIZE)
					.addGap(53)
					.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(passwordField, 253, 253, 253)
					.addGap(42)
					.addComponent(btnLogn, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(197, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(1001, Short.MAX_VALUE)
					.addComponent(lblIWantTo)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblChange)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblPassword_1)
					.addGap(147))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblLogn, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(59)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textUserName, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
								.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblUserName, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnLogn, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
							.addGap(44)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblChange)
								.addComponent(lblIWantTo, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPassword_1)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(70)
							.addComponent(labelID, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(separator_2, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(100)
							.addComponent(lblIfYouAre, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
							.addGap(57)
							.addComponent(lblPleaseClckOn, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(51)
							.addComponent(buttonRegister, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(31)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 263, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		
	}

	private void createEvents()
	{
		btnLogn.addActionListener(new ActionListener()
		{
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0)
			{
				try {
					Class.forName("org.h2.Driver");
					Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
					
					String userNameInput = textUserName.getText();
					String passwordInput = passwordField.getText();
					
					String query = "select * from USER_INFO where USERNAME =? and PASSWORD=?";
					PreparedStatement statement = connection.prepareStatement(query);
					statement.setString(1, userNameInput);
					statement.setString(2, passwordInput);
					
					ResultSet set = statement.executeQuery();
					if(set.next()) {
						if(userNameInput.equals("admin"))
						{
						JOptionPane.showMessageDialog(null, "LOGIN SUCCESSFUL");
						
						MainPageAdmin mainPage = new MainPageAdmin();
						
						mainPage.setVisible(true);
						}
						else if(userNameInput.equals("assistant"))
						{
							JOptionPane.showMessageDialog(null, "LOGIN SUCCESSFUL");
							
							MainPageAssistant mainPage = new MainPageAssistant();
							
							mainPage.setVisible(true);
						}
						else
						{
							JOptionPane.showMessageDialog(null, "LOGIN SUCCESSFUL");
							
							MainPage mainPage = new MainPage();
							
							mainPage.setVisible(true);
						}
					}
					else 
					{
						JOptionPane.showMessageDialog(null, "Ýnvalid");
					}
				} catch (ClassNotFoundException | SQLException e)
				{
					e.printStackTrace();
				}
			}
		});
			
		buttonRegister.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Register registerPage= new Register();
				registerPage.setVisible(true);
			}
		});
		lblChange.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent arg0)
			{
				PasswordChanges change= new PasswordChanges();
				change.setVisible(true);
			}
		});
		textUserName.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent arg0)
			{
				try
				{
					Class.forName("org.h2.Driver");
					Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
					String userNameInput = textUserName.getText();
					String query = "select * from USER_INFO where USERNAME=?";
					PreparedStatement statement = connection.prepareStatement(query);
					statement.setString(1, userNameInput);
					ResultSet set = statement.executeQuery();
					while(set.next())
					{
						labelID.setText(set.getString("ID"));
					
					}
					
					
				} catch (ClassNotFoundException | SQLException e)
				{
					e.printStackTrace();
				}
			}
		});
	}
}
