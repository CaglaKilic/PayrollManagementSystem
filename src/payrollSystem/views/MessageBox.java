package payrollSystem.views;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class MessageBox extends JFrame {

	private JPanel contentPane;
	private JTable tableObjections;
	private JButton btnRead;
	private JLabel lblExit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MessageBox frame = new MessageBox();
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
	public MessageBox() 
	{
		initComponents();
		createEvents();
	}

	private void initComponents()
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage(PrepareInformation.class.getResource("/payrollSystem/resources/money_64_.png")));
		setTitle("MESSAGE BOX");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 533, 554);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.window);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		
		btnRead = new JButton("");
		
		btnRead.setToolTipText("READ MESSAGES");
		btnRead.setIcon(new ImageIcon(MessageBox.class.getResource("/payrollSystem/resources/email_64.png")));
		
		lblExit = new JLabel("");
		
		lblExit.setIcon(new ImageIcon(MessageBox.class.getResource("/payrollSystem/resources/log-out_128.png")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(lblExit, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
							.addGap(104)
							.addComponent(btnRead, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
							.addGap(136))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(20)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE)
					.addGap(56)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnRead, 0, 0, Short.MAX_VALUE)
						.addComponent(lblExit, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(108, Short.MAX_VALUE))
		);
		
		tableObjections = new JTable();
		scrollPane.setViewportView(tableObjections);
		contentPane.setLayout(gl_contentPane);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/3-this.getSize().height/6);
		setUndecorated(true);
		
	}

	private void createEvents()
	{
		btnRead.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String query = "Select ID,OBJECTION From PREPOBJECTION";
				try
				{
					Class.forName("org.h2.Driver");
					Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
					PreparedStatement statement = connection.prepareStatement(query);
					ResultSet set = statement.executeQuery();
					tableObjections.setModel(DbUtils.resultSetToTableModel(set));
					
					
				} catch (ClassNotFoundException | SQLException e1) 
				{
					e1.printStackTrace();
				}
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
