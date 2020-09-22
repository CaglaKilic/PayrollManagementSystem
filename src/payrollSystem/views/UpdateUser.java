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
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class UpdateUser extends JFrame {

	private JPanel contentPane;
	private JTextField textName;
	private JTextField textSurname;
	private JTextField textMail;
	private JTextField textUserName;
	private JButton btnAdd;
	private JButton btnDelete;
	private JButton button;
	private JLabel label;
	private JLabel lblPassword;
	private JPasswordField passwordField;
	private JTextField textID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateUser frame = new UpdateUser();
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
	public UpdateUser()
	{
		initComponents();
		createEvents();
	}

	private void initComponents() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(UpdateUser.class.getResource("/payrollSystem/resources/updatee_128.png")));
		setTitle("UPDATE USER");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 499, 547);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.window);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblFrstName = new JLabel("FIRST NAME  : ");
		lblFrstName.setForeground(Color.BLACK);
		lblFrstName.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		
		JLabel lblId = new JLabel("ID                   : ");
		lblId.setForeground(Color.BLACK);
		lblId.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		
		JLabel lblLastName = new JLabel("LAST NAME   : ");
		lblLastName.setForeground(Color.BLACK);
		lblLastName.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		
		JLabel lblEmal = new JLabel("E-MAIL          : ");
		lblEmal.setForeground(Color.BLACK);
		lblEmal.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		
		JLabel lblUserName = new JLabel("USER NAME  : ");
		lblUserName.setForeground(Color.BLACK);
		lblUserName.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		
		textName = new JTextField();
		textName.setForeground(Color.BLACK);
		textName.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		textName.setColumns(10);
		
		textSurname = new JTextField();
		textSurname.setForeground(Color.BLACK);
		textSurname.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		textSurname.setColumns(10);
		
		textMail = new JTextField();
		textMail.setForeground(Color.BLACK);
		textMail.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		textMail.setColumns(10);
		
		textUserName = new JTextField();
		
		textUserName.setForeground(Color.BLACK);
		textUserName.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		textUserName.setColumns(10);
		
		btnAdd = new JButton("");
		btnAdd.setToolTipText("ADD USER");
		
		btnAdd.setIcon(new ImageIcon(UpdateUser.class.getResource("/payrollSystem/resources/addd_64.png")));
		
		btnDelete = new JButton("");
		btnDelete.setToolTipText("DELETE USER");
		
		btnDelete.setIcon(new ImageIcon(UpdateUser.class.getResource("/payrollSystem/resources/userDelete_64.png")));
		
		button = new JButton("");
		button.setToolTipText("UPDATE USER");
		
		button.setIcon(new ImageIcon(UpdateUser.class.getResource("/payrollSystem/resources/update_button_64.png")));
		
		label = new JLabel("");
		
		label.setIcon(new ImageIcon(UpdateUser.class.getResource("/payrollSystem/resources/log-out_128.png")));
		
		lblPassword = new JLabel("PASSWORD  : ");
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		passwordField.setEditable(false);
		
		textID = new JTextField();
		textID.setForeground(Color.BLACK);
		textID.setFont(new Font("Segoe UI", Font.BOLD, 13));
		
		textID.setToolTipText("WHEN YOU ADD USER, PLEASE LEAVE BLANK");
		textID.setColumns(10);
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(226, Short.MAX_VALUE)
					.addComponent(label)
					.addGap(199))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(42)
					.addComponent(btnAdd)
					.addGap(56)
					.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addGap(32))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(72)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
							.addGap(26)
							.addComponent(passwordField, 157, 157, 157))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
									.addComponent(lblEmal, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblUserName))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addComponent(lblLastName, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
									.addGroup(Alignment.LEADING, gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblId)
										.addComponent(lblFrstName))))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
									.addComponent(textSurname, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
									.addComponent(textUserName)
									.addComponent(textMail, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
									.addComponent(textID)
									.addComponent(textName, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)))))
					.addContainerGap(134, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(25, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(textID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblId, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFrstName, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(textName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(21)
							.addComponent(textSurname, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblLastName, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))
					.addGap(21)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEmal, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(textMail, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUserName, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(textUserName, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(21)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAdd)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
					.addGap(37)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
					.addGap(24))
		);
		contentPane.setLayout(gl_contentPane);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/3-this.getSize().height/6);
		setUndecorated(true);
		
	}

	private void createEvents()
	{
		
		btnAdd.addActionListener(new ActionListener()
		{
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0)
			{
				
				if((textName.getText().equals("")) || textSurname.getText().equals("") || textMail.getText().equals("") || 
						textUserName.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "ALL MUST BE FILLED");
				}
				else
				{
				try
				{
					
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
					
			        	statement.setString(1, textID.getName());
			        	statement.setString(2, textName.getText());
			        	statement.setString(3, textSurname.getText());
			        	statement.setString(4, textMail.getText());
			        	statement.setString(5, userNameInput);
			        	statement.setString(6, passwordField.getText());
			        	int data_entered = statement.executeUpdate();
			        	if(data_entered>0)
			        	{
			        		JOptionPane.showMessageDialog(null, "..USER SAVED..");
			        	}
			        	else
			        	{
						JOptionPane.showMessageDialog(null, "..USER DID NOT SAVE..");
			        	}
			        }
			        
					textName.setText("");
					textSurname.setText("");
					textMail.setText("");
					textUserName.setText("");
					passwordField.setText("");
				}
				catch (ClassNotFoundException | SQLException e)
				{
					e.printStackTrace();
				}
				}
			}
		});
		textID.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseReleased(MouseEvent arg0)
			{
				if(textID.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "..PLEASE ENTER EMPLOYEE ID..");
				}
				else
				{
					try
					{
						Class.forName("org.h2.Driver");
						Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
						String userID = textID.getText();
					
						String query = "select * from USER_INFO where ID =?";
						PreparedStatement statement = connection.prepareStatement(query);
						statement.setString(1, userID);
					
						ResultSet set = statement.executeQuery();
						while(set.next())
						{
							textName.setText(set.getString("NAME"));
							textSurname.setText(set.getString("SURNAME"));
							textMail.setText(set.getString("EMAIL"));
							textUserName.setText(set.getString("USERNAME"));
							passwordField.setText(set.getString("PASSWORD"));
						
						}
					
					} catch (ClassNotFoundException | SQLException e)
					{
						e.printStackTrace();
					}
				}
			}
		});
		btnDelete.addActionListener(new ActionListener()
		{
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e)
			{
				if((textName.getText().equals("")) || textSurname.getText().equals("") || textMail.getText().equals("") || 
						textUserName.getText().equals("") || passwordField.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "..PLEASE ENTER DATA TO DELETE..");
				}
				else {
				int p = JOptionPane.showConfirmDialog(null, "DO YOU REALLY WANT TO DELETE", "Delete", JOptionPane.YES_NO_OPTION);
				if(p==0) {
				
				String sql3 = "delete from PREPOBJECTION where ID=?";
				String sql2 = "delete from PAYROLL where ID=?";
				String sql1 = "delete from DETAIL_INFO where ID=?";
				String sql = "delete from USER_INFO where ID=?";
				
				try { 
					Class.forName("org.h2.Driver");
					Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
					
					PreparedStatement pst3 = connection.prepareStatement(sql3);
					PreparedStatement pst2 = connection.prepareStatement(sql2);
					PreparedStatement pst1 = connection.prepareStatement(sql1);
					PreparedStatement pst = connection.prepareStatement(sql);
					
					pst3.setString(1, textID.getText());
					pst2.setString(1, textID.getText());
					pst1.setString(1, textID.getText());
					pst.setString(1, textID.getText());
					
					pst3.executeUpdate();
					pst2.executeUpdate();
					pst1.executeUpdate();
					pst.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "DELETED");
					
				} catch (SQLException | ClassNotFoundException e1) {
					JOptionPane.showMessageDialog(null, e1);
					e1.printStackTrace();
				}
				}
				textID.setText("");
				textName.setText("");
				textSurname.setText("");
				textMail.setText("");
				textUserName.setText("");
				passwordField.setText("");
			}
			}
		});
		button.addActionListener(new ActionListener()
		{
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e)
			{
				if( textID.getText().equals("") || (textName.getText().equals("")) || textSurname.getText().equals("") || textMail.getText().equals("") || 
						textUserName.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "ALL MUST BE FILLED");
				}
				else
				{
				try
				{
					Class.forName("org.h2.Driver");
					Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
					String update_data = "UPDATE USER_INFO SET NAME=?, SURNAME=?, EMAIL=?, USERNAME=?, PASSWORD=? WHERE ID=?";
					PreparedStatement statement = connection.prepareStatement(update_data);
					statement.setString(1, textName.getText());
					statement.setString(2, textSurname.getText());
					statement.setString(3, textMail.getText());
					statement.setString(4, textUserName.getText());
					statement.setString(5, passwordField.getText());
					statement.setString(6, textID.getText());
					
					statement.executeUpdate();
						JOptionPane.showMessageDialog(null, "UPDATED SUCCESSFULLY");
				} catch (ClassNotFoundException | SQLException e1)
				{
					JOptionPane.showMessageDialog(null, e1);
					e1.printStackTrace();
				}
				}
				textID.setText("");
				textName.setText("");
				textSurname.setText("");
				textMail.setText("");
				textUserName.setText("");
				passwordField.setText("");
				
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
