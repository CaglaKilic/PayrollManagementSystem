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

import java.awt.Color;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class PrepareInformation extends JFrame {

	private JPanel contentPane;
	private JRadioButton rdbtnMarried;
	private JTextField textPhone;
	private JTextField txtPayDate;
	private JTextField txtIDNo;
	private JTextField textName;
	private JTextField textSurname;
	private JTextField textDyeri;
	private JTextField textBirthDay;
	@SuppressWarnings("rawtypes")
	private JComboBox cBoxEducation;
	@SuppressWarnings("rawtypes")
	private JComboBox cBoxCaption;
	private JLabel lblTarih;
	private JButton btnSave;
	private JLabel label;
	private JRadioButton rdbtnSingle;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel lblTarih2;
	private JScrollPane scrollPane;
	private JTextArea textAddress;
	private JTextField txtEmpID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrepareInformation frame = new PrepareInformation();
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
	public PrepareInformation()
	{
		initComponents();
		createEvents();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initComponents() 
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage(PrepareInformation.class.getResource("/payrollSystem/resources/money_64_.png")));
		setTitle("PREPARE INFORMATION");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 574, 554);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblIdentfcatonNumber = new JLabel("IDENTIFICATION NUMBER :");
		lblIdentfcatonNumber.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblIdentfcatonNumber.setForeground(Color.BLACK);
		
		JLabel lblName = new JLabel("NAME :");
		lblName.setForeground(Color.BLACK);
		lblName.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		
		JLabel lblSurname = new JLabel("SURNAME :");
		lblSurname.setForeground(Color.BLACK);
		lblSurname.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		
		JLabel lblPlaceOfBrth = new JLabel("PLACE OF BIRTH :");
		lblPlaceOfBrth.setForeground(Color.BLACK);
		lblPlaceOfBrth.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		
		JLabel lblDateOfBrth = new JLabel("DATE OF BIRTH :");
		lblDateOfBrth.setForeground(Color.BLACK);
		lblDateOfBrth.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		
		rdbtnMarried = new JRadioButton("MARRIED");
		
		buttonGroup.add(rdbtnMarried);
		rdbtnMarried.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		
		rdbtnSingle = new JRadioButton("SINGLE");
		
		buttonGroup.add(rdbtnSingle);
		rdbtnSingle.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		
		JLabel lblEducatonStatus = new JLabel("EDUCATIONAL STATUS");
		lblEducatonStatus.setForeground(Color.BLACK);
		lblEducatonStatus.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		
		JLabel lblCapton = new JLabel("CAPTION");
		lblCapton.setForeground(Color.BLACK);
		lblCapton.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		
		cBoxEducation = new JComboBox();
		cBoxEducation.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		cBoxEducation.addItem("[Select Any]");
		cBoxEducation.addItem("Primary School");
		cBoxEducation.addItem("Junior High School");
		cBoxEducation.addItem("High School");
		cBoxEducation.addItem("University");
		
		cBoxCaption = new JComboBox();
		cBoxCaption.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		cBoxCaption.setModel(new DefaultComboBoxModel(new String[] {"[Select Any]", "Operations Officer", "Customer Relations Officer", "SME Customer Relations Officer", "Commercial Customer Relationship Officer"}));
		
		JLabel lblAddress = new JLabel("ADDRESS :");
		lblAddress.setForeground(Color.BLACK);
		lblAddress.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		
		JLabel lblTelephoneNumber = new JLabel("TELEPHONE NUMBER :");
		lblTelephoneNumber.setForeground(Color.BLACK);
		lblTelephoneNumber.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		
		textPhone = new JTextField();
		textPhone.setForeground(Color.BLACK);
		textPhone.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		textPhone.setColumns(10);
		
		JLabel lblPayDate = new JLabel("INITIATE DATE :");
		lblPayDate.setForeground(Color.BLACK);
		lblPayDate.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		
		JLabel lblEmployeeId = new JLabel("EMPLOYEE ID :");
		lblEmployeeId.setForeground(Color.BLACK);
		lblEmployeeId.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		
		txtPayDate = new JTextField();
		
		txtPayDate.setForeground(Color.BLACK);
		txtPayDate.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		txtPayDate.setColumns(10);
		
		txtIDNo = new JTextField();
		txtIDNo.setForeground(Color.BLACK);
		txtIDNo.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		txtIDNo.setColumns(10);
		
		textName = new JTextField();
		textName.setForeground(Color.BLACK);
		textName.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		textName.setColumns(10);
		
		textSurname = new JTextField();
		textSurname.setForeground(Color.BLACK);
		textSurname.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		textSurname.setColumns(10);
		
		textDyeri = new JTextField();
		textDyeri.setForeground(Color.BLACK);
		textDyeri.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		textDyeri.setColumns(10);
		
		textBirthDay = new JTextField();
		
		textBirthDay.setForeground(Color.BLACK);
		textBirthDay.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		textBirthDay.setColumns(10);
		
		JSeparator separator = new JSeparator();
		
		lblTarih = new JLabel("DD/MM/YYYY");
		lblTarih.setVisible(false);
		lblTarih.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblTarih.setForeground(SystemColor.textHighlight);
		
		btnSave = new JButton("");
		
		btnSave.setIcon(new ImageIcon(PrepareInformation.class.getResource("/payrollSystem/resources/disk_64.png")));
		btnSave.setToolTipText("SAVE");
		
		label = new JLabel("");
		
		label.setIcon(new ImageIcon(PrepareInformation.class.getResource("/payrollSystem/resources/log-out_128.png")));
		
		lblTarih2 = new JLabel("DD/MM/YYYY");
		lblTarih2.setVisible(false);
		lblTarih2.setForeground(SystemColor.textHighlight);
		lblTarih2.setFont(new Font("Segoe UI", Font.BOLD, 13));
		
		scrollPane = new JScrollPane();
		
		txtEmpID = new JTextField();
		
		txtEmpID.setForeground(Color.BLACK);
		txtEmpID.setFont(new Font("Segoe UI", Font.BOLD, 13));
		txtEmpID.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(141)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
							.addGap(109)
							.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(36)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_contentPane.createSequentialGroup()
													.addComponent(rdbtnMarried)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(rdbtnSingle))
												.addGroup(gl_contentPane.createSequentialGroup()
													.addPreferredGap(ComponentPlacement.RELATED)
													.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
														.addComponent(lblTelephoneNumber, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
														.addComponent(lblAddress, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
														.addComponent(lblPayDate, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))))
											.addGap(18)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)
												.addGroup(gl_contentPane.createSequentialGroup()
													.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
														.addComponent(txtPayDate)
														.addComponent(textPhone, GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE))
													.addGap(5)
													.addComponent(lblTarih2, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE))
												.addGroup(gl_contentPane.createSequentialGroup()
													.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
														.addComponent(lblEducatonStatus)
														.addComponent(cBoxEducation, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE))
													.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
														.addGroup(gl_contentPane.createSequentialGroup()
															.addGap(48)
															.addComponent(cBoxCaption, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE))
														.addGroup(gl_contentPane.createSequentialGroup()
															.addGap(78)
															.addComponent(lblCapton, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))))))
										.addComponent(lblEmployeeId, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED, 52, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(lblPlaceOfBrth)
												.addComponent(lblDateOfBrth))
											.addGap(66)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(textDyeri, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
												.addComponent(textBirthDay, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(lblIdentfcatonNumber)
												.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
												.addComponent(txtEmpID, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
												.addComponent(textName)
												.addComponent(txtIDNo))))
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblSurname)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(textSurname, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
										.addComponent(lblTarih))
									.addGap(31))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(separator, GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(14)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEmployeeId, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtEmpID, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addGap(13)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSurname, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(textSurname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIdentfcatonNumber)
						.addComponent(txtIDNo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textDyeri, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPlaceOfBrth, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textBirthDay, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDateOfBrth, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTarih, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(rdbtnMarried)
							.addComponent(rdbtnSingle))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblEducatonStatus, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCapton, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
							.addGap(6)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(cBoxEducation, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(cBoxCaption, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(18)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 7, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(11)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addComponent(lblAddress, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)))
					.addGap(14)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTelephoneNumber, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(textPhone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(14)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtPayDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPayDate, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTarih2, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnSave)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
					.addGap(14))
		);
		
		textAddress = new JTextArea();
		textAddress.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		textAddress.setLineWrap(true);
		scrollPane.setViewportView(textAddress);
		contentPane.setLayout(gl_contentPane);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/3-this.getSize().height/6);
		setUndecorated(true);
		
	}

	private void createEvents()
	{
		rdbtnMarried.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				if(rdbtnMarried.isSelected()) 
				{
					rdbtnSingle.setSelected(false);
				}
			}
		});
		rdbtnSingle.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(rdbtnSingle.isSelected())
					rdbtnMarried.setSelected(false);
			}
		});
		btnSave.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				if(((textName.getText().equals("")) || textSurname.getText().equals("") || txtIDNo.getText().equals("") || 
						textDyeri.getText().equals("") || textBirthDay.getText().equals("") || textAddress.getText().equals("") 
						|| textPhone.getText().equals("") || txtPayDate.getText().equals("")) && (!(rdbtnMarried.isSelected()) || !(rdbtnSingle.isSelected())))
				{
					JOptionPane.showMessageDialog(null, "..OPSS.. ALL MUST BE FILLED..");
				}
				else
				{
				try
				{
					String maritalStatus = "";
					if(rdbtnMarried.isSelected())
						maritalStatus = "Married";
					else if(rdbtnSingle.isSelected()) 
					{
						maritalStatus = "Single";
					}
					
					Class.forName("org.h2.Driver");
					Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
					String insert_data = "insert into DETAIL_INFO values(?,?,?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement statement = connection.prepareStatement(insert_data);
					
					statement.setString(1, txtIDNo.getText());
					statement.setString(2, txtEmpID.getText());
					statement.setString(3, textName.getText());
					statement.setString(4, textSurname.getText());
					statement.setString(5, textDyeri.getText());
					statement.setString(6, textBirthDay.getText());
					statement.setString(7, textAddress.getText());
					statement.setString(8, textPhone.getText());
					statement.setString(9, maritalStatus);
					statement.setString(10, cBoxEducation.getSelectedItem().toString());
					statement.setString(11, cBoxCaption.getSelectedItem().toString());
					statement.setString(12, txtPayDate.getText());
					
					int data_entered = statement.executeUpdate();
					if(data_entered>0)
					{
						JOptionPane.showMessageDialog(null, "..PERSONAL INFORMATIONS SAVED..");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "..PERSONAL INFORMATIONS DID NOT SAVE..");
					}
					textName.setText("");
					textSurname.setText("");
					txtIDNo.setText("");
					textDyeri.setText("");
					textBirthDay.setText("");
					textAddress.setText("");
					textPhone.setText("");
					cBoxEducation.setSelectedIndex(-1);
					cBoxCaption.setSelectedIndex(-1);;
					txtPayDate.setText("");
					txtEmpID.setText("");
				}
				catch (ClassNotFoundException | SQLException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
			}
		});
		textBirthDay.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent arg0)
			{
				lblTarih.setVisible(true);
			}
		});
		txtPayDate.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent arg0)
			{
				lblTarih2.setVisible(true);
			}
		});
		label.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				dispose();
			}
		});
		txtEmpID.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseReleased(MouseEvent arg0)
			{
				if(txtEmpID.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "..PLEASE ENTER YOUR EMPLOYEE ID AND DATE..");
				}
				else
				{
					try
					{
						Class.forName("org.h2.Driver");
						Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
						String userID = txtEmpID.getText();
						String query = "select * from USER_INFO where ID =?";
						PreparedStatement statement = connection.prepareStatement(query);
						statement.setString(1, userID);
					
						ResultSet set = statement.executeQuery();
						while(set.next())
						{
							textName.setText(set.getString("NAME"));
							textSurname.setText(set.getString("SURNAME"));
						}
					
					} catch (ClassNotFoundException | SQLException e)
					{
						e.printStackTrace();
					}
				}
			}
		});
	}
}
