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

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class MainPageAdmin extends JFrame {
	private JPanel contentPane;
	private JLabel lblupdateUser;
	private JLabel label_4;
	private JLabel lblPrepareInfo;
	private JLabel lblBankingSyst;
	private JLabel lblMessageBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				
				try {
					
					MainPageAdmin frame = new MainPageAdmin();
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
	public MainPageAdmin()
	{
		initComponents();
		createEvents();
		
	}

	private void initComponents() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainPageAdmin.class.getResource("/payrollSystem/resources/money_64_.png")));
		setTitle("PAYROLL MANAGEMENT SYSTEM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.window);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JSeparator separator = new JSeparator();
		
		JLabel lblPayrollManagementSystem = new JLabel("PAYROLL MANAGEMENT SYSTEM");
		lblPayrollManagementSystem.setForeground(Color.BLACK);
		lblPayrollManagementSystem.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 35));
		
		JSeparator separator_1 = new JSeparator();
		
		lblupdateUser = new JLabel("");
		lblupdateUser.setToolTipText("UPDATE USER");

		lblupdateUser.setIcon(new ImageIcon(MainPageAdmin.class.getResource("/payrollSystem/resources/updatee_128.png")));
		
		lblPrepareInfo = new JLabel("");
		
		lblPrepareInfo.setToolTipText("PREPARE INFORMATION");
		lblPrepareInfo.setIcon(new ImageIcon(MainPageAdmin.class.getResource("/payrollSystem/resources/info_128.png")));
		
		lblMessageBox = new JLabel("");
		
		lblMessageBox.setToolTipText("MESSAGE BOX");
		lblMessageBox.setIcon(new ImageIcon(MainPageAdmin.class.getResource("/payrollSystem/resources/message_128.png")));
		
		lblBankingSyst = new JLabel("");
		
		lblBankingSyst.setToolTipText("BANKING SYSTEM");
		lblBankingSyst.setIcon(new ImageIcon(MainPageAdmin.class.getResource("/payrollSystem/resources/online-banking_128.png")));
		
		label_4 = new JLabel("");
		
		label_4.setIcon(new ImageIcon(MainPageAdmin.class.getResource("/payrollSystem/resources/log-out_256.png")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 1336, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(11, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(329, Short.MAX_VALUE)
					.addComponent(lblPayrollManagementSystem)
					.addGap(319))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 1336, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(11, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(229)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblMessageBox)
						.addComponent(lblupdateUser))
					.addGap(199)
					.addComponent(label_4)
					.addPreferredGap(ComponentPlacement.RELATED, 211, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblPrepareInfo)
						.addComponent(lblBankingSyst, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
					.addGap(206))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblPayrollManagementSystem, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(96)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblupdateUser, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPrepareInfo, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblMessageBox)
								.addComponent(lblBankingSyst, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE))
							.addGap(81))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(133)
							.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		contentPane.setLayout(gl_contentPane);
		
	}

	private void createEvents() {
		lblupdateUser.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent arg0)
			{
				UpdateUser updatePage = new UpdateUser();
				updatePage.setVisible(true);
			}
		});
		label_4.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent arg0)
			{
				int p = JOptionPane.showConfirmDialog(null, "DO YOU REALLY WANT TO EXIT", "Exit", JOptionPane.YES_NO_OPTION);
				if(p == 0)
				{
				System.exit(1);
				}
			}
		});
		lblPrepareInfo.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				PrepareInformation prepare = new PrepareInformation();
				prepare.setVisible(true);
			}
		});
		lblBankingSyst.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				BankingSystemAdmin transaction = new BankingSystemAdmin();
				transaction.setVisible(true);
			}
		});
		lblMessageBox.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				MessageBox readMessages = new MessageBox();
				readMessages.setVisible(true);
			}
		});
		
	}
}
