package payrollSystem.views;

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
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JScrollPane;
import java.awt.Color;

@SuppressWarnings("serial")
public class SearchPayrolls extends JFrame {

	private JPanel contentPane;
	private JTextField textID;
	private JLabel lblSearch;
	private JLabel lblExit;
	private JTable tablePayrolls;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchPayrolls frame = new SearchPayrolls();
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
	public SearchPayrolls()
	{
		initComponents();
		createEvents();
		
	}

	private void initComponents()
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage(PreparePayroll.class.getResource("/payrollSystem/resources/money_64_.png")));
		setTitle("SEARCH PAYROLL");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 533, 554);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.window);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("YOUR EMPLOYEE ID :");
		label.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		
		textID = new JTextField();
		textID.setForeground(Color.BLACK);
		textID.setFont(new Font("Segoe UI", Font.BOLD, 13));
		textID.setColumns(10);
		
		lblSearch = new JLabel("");
		
		lblSearch.setIcon(new ImageIcon(SearchPayrolls.class.getResource("/payrollSystem/resources/loading_64.png")));
		lblSearch.setToolTipText("LOAD DATA");
		
		lblExit = new JLabel("");
		
		lblExit.setIcon(new ImageIcon(SearchPayrolls.class.getResource("/payrollSystem/resources/door_64.png")));
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(78)
					.addComponent(lblSearch)
					.addPreferredGap(ComponentPlacement.RELATED, 246, Short.MAX_VALUE)
					.addComponent(lblExit, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
					.addGap(69))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(158, Short.MAX_VALUE)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(textID, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
					.addGap(133))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(44, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 445, GroupLayout.PREFERRED_SIZE)
					.addGap(34))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(34)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(8)
							.addComponent(textID, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
					.addGap(36)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblExit, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSearch))
					.addGap(41)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 283, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(45, Short.MAX_VALUE))
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
		lblSearch.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				String query = "Select DATE,GROSS,DEDUCTION,NET From PAYROLL where ID=?";
				if(textID.getText().equals(""))
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
						ResultSet set = statement.executeQuery();
						tablePayrolls.setModel(DbUtils.resultSetToTableModel(set));

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
			public void mouseClicked(MouseEvent e)
			{
				dispose();
			}
		});
	}

}
