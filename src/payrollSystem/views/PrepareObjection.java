package payrollSystem.views;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Dimension;

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
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class PrepareObjection extends JFrame {

	private JPanel contentPane;
	private JTextField textID;
	private JTextField textDate;
	private JLabel lblName;
	private JLabel lblSurname;
	private JLabel lblDeduction;
	private JLabel lblNet;
	private JLabel lblExit;
	private JButton btnNewButton;
	private JLabel lblDeducton;
	private JLabel lblNet_1;
	private JScrollPane scrollPane;
	private JTextArea textMessageBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrepareObjection frame = new PrepareObjection();
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
	public PrepareObjection()
	{
		initComponents();
		createEvents();
		
		
		
		
	}

	private void initComponents()
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage(PreparePayroll.class.getResource("/payrollSystem/resources/money_64_.png")));
		setTitle("PREPARE OBJECTION");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 533, 554);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		setContentPane(contentPane);
		
		JLabel label = new JLabel("YOUR EMPLOYEE ID :");
		label.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		
		textID = new JTextField();
		textID.setFont(new Font("Segoe UI", Font.BOLD, 13));
		textID.setColumns(10);
		
		JLabel lblPayDate = new JLabel("PAY DATE :");
		lblPayDate.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		
		textDate = new JTextField();
		textDate.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		textDate.setColumns(10);
		
		lblName = new JLabel("");
		lblName.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		
		lblSurname = new JLabel("");
		lblSurname.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		
		lblDeduction = new JLabel("");
		lblDeduction.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		
		lblNet = new JLabel("");
		lblNet.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		
		btnNewButton = new JButton("");
		btnNewButton.setToolTipText("SEND");
		
		btnNewButton.setIcon(new ImageIcon(PrepareObjection.class.getResource("/payrollSystem/resources/send (2)_64.png")));
		
		lblExit = new JLabel("");
		
		lblExit.setIcon(new ImageIcon(PrepareObjection.class.getResource("/payrollSystem/resources/door_64.png")));
		
		lblDeducton = new JLabel("DEDUCTION");
		
		lblNet_1 = new JLabel("NET");
		
		scrollPane = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(33)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblSurname, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
							.addGap(48)
							.addComponent(lblDeduction, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(textID, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPayDate, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDeducton))))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNet, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
								.addComponent(textDate, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(36)
							.addComponent(lblNet_1)))
					.addContainerGap(64, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(103)
					.addComponent(lblExit)
					.addPreferredGap(ComponentPlacement.RELATED, 194, Short.MAX_VALUE)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
					.addGap(94))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(94, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 344, GroupLayout.PREFERRED_SIZE)
					.addGap(85))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(8)
							.addComponent(textID, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblPayDate, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
							.addComponent(textDate, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
					.addGap(16)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDeducton)
						.addComponent(lblNet_1))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNet, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDeduction, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSurname, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblName))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
					.addGap(80)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblExit)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(104, Short.MAX_VALUE))
		);
		
		textMessageBox = new JTextArea();
		
		textMessageBox.setLineWrap(true);
		scrollPane.setViewportView(textMessageBox);
		contentPane.setLayout(gl_contentPane);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/3-this.getSize().height/6);
		setUndecorated(true);
	}

	private void createEvents()
	{
		textMessageBox.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
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
						String query = "select NAME,SURNAME,DEDUCTION,NET from PAYROLL where ID =? and DATE=?";
						PreparedStatement statement = connection.prepareStatement(query);
						statement.setString(1, textID.getText());
						statement.setString(2, textDate.getText());
						ResultSet set = statement.executeQuery();
						while(set.next())
						{
							lblName.setText(set.getString("NAME"));
							lblSurname.setText(set.getString("SURNAME"));
							lblDeduction.setText(set.getString("DEDUCTION"));
							lblNet.setText(set.getString("NET"));
						}
					
					} catch (ClassNotFoundException | SQLException e1)
					{
						e1.printStackTrace();
					}
				}
			}
		});
		
		btnNewButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				if(textMessageBox.getText().equals("")||textID.getText().equals("")||textDate.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "..PLEASE FILL ALL OF THE BOX..");
				}
				else
				{
				try
				{
					Class.forName("org.h2.Driver");
					Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
					String query = "insert into PREPOBJECTION values(?,?,?,?,?,?,?)";
					PreparedStatement statement = connection.prepareStatement(query);
					
					statement.setString(1, textID.getText());
					statement.setString(2, lblName.getText());
					statement.setString(3, lblSurname.getText());
					statement.setString(4, textDate.getText());
					statement.setString(5, lblDeduction.getText());
					statement.setString(6, lblNet.getText());
					statement.setString(7, textMessageBox.getText());
					
					int data_entered = statement.executeUpdate();
					if(data_entered>0)
					{
						JOptionPane.showMessageDialog(null, "..SENT YOUR MESSAGE..");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "..DID NOT SEND YOUR MESSAGE..");
					}
					lblName.setText("");
					lblSurname.setText("");
					textID.setText("");
					textDate.setText("");
					lblDeduction.setText("");
					lblNet.setText("");
					textMessageBox.setText("");
					
				} catch (ClassNotFoundException | SQLException e)
				{
					e.printStackTrace();
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
	}
}
