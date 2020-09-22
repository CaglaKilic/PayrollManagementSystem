package payrollSystem.views;

import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class PasswordChanges extends JFrame {

	private JPanel contentPane;
	private JTextField textuserName;
	private JPasswordField oldPass;
	private JPasswordField newPass;
	private JPasswordField newPassA;
	private JButton btnChange;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PasswordChanges frame = new PasswordChanges();
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
	public PasswordChanges()
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
		
		JLabel lblUpdatePassword = new JLabel("UPDATE PASSWORD");
		lblUpdatePassword.setForeground(Color.BLACK);
		lblUpdatePassword.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 35));
		
		JSeparator separator_1 = new JSeparator();
		
		JLabel lblYourUserName = new JLabel("YOUR USER NAME                :");
		lblYourUserName.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		
		JLabel lblOldPassword = new JLabel("OLD PASSWORD                   :");
		lblOldPassword.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		
		JLabel lblNewPassword = new JLabel("NEW PASSWORD                  :");
		lblNewPassword.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		
		JLabel lblNewPasswordAgan = new JLabel("NEW PASSWORD AGAIN    :");
		lblNewPasswordAgan.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		
		textuserName = new JTextField();
		textuserName.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		textuserName.setColumns(10);
		
		oldPass = new JPasswordField();
		oldPass.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		
		newPass = new JPasswordField();
		newPass.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		
		newPassA = new JPasswordField();
		newPassA.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		
		btnChange = new JButton("CHANGE");
		
		btnChange.setFont(new Font("Showcard Gothic", Font.PLAIN, 15));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(separator, GroupLayout.PREFERRED_SIZE, 1356, GroupLayout.PREFERRED_SIZE)
						.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 1356, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(475, Short.MAX_VALUE)
					.addComponent(lblUpdatePassword)
					.addGap(459))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(402)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblNewPassword, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblNewPasswordAgan, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblOldPassword, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblYourUserName, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
							.addComponent(oldPass)
							.addComponent(textuserName, GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(newPassA, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)
							.addGap(137)
							.addComponent(btnChange, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE))
						.addComponent(newPass, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE))
					.addGap(187))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblUpdatePassword, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(106)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblYourUserName, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
								.addComponent(textuserName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(41)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblOldPassword, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
								.addComponent(oldPass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(47)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewPassword, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
								.addComponent(newPass, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
							.addGap(41)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewPasswordAgan, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
								.addComponent(newPassA, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
							.addContainerGap(120, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnChange, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
							.addGap(107))))
		);
		contentPane.setLayout(gl_contentPane);
		
	}

	private void createEvents()
	{
		btnChange.addActionListener(new ActionListener()
		{
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0)
			{
				if((textuserName.getText().equals("")) && oldPass.getText().equals("") &&
						newPass.getText().equals("") && newPassA.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "ALL MUST BE FILLED");
				}
				else
				{
					String password = new String(newPass.getPassword());
					String password1 = new String(newPassA.getPassword());
					System.out.println(password + " " + password1);
					if(!(password).equals(password1))
					{
						JOptionPane.showMessageDialog(null, "Passwords are not matches!!!");
					}
					else{
						try
						{
							Class.forName("org.h2.Driver");
							Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
							String update_data = "UPDATE USER_INFO SET PASSWORD=? WHERE USERNAME=?";
							PreparedStatement statement = connection.prepareStatement(update_data);
							statement.setString(1, newPass.getText());
							statement.setString(2,textuserName.getText());
							statement.executeUpdate();
							JOptionPane.showMessageDialog(null, "UPDATED SUCCESSFULLY");
							dispose();
						
						} catch (ClassNotFoundException | SQLException e)
						{
							e.printStackTrace();
						}
					}
				}
			}
		});	
	}
}
