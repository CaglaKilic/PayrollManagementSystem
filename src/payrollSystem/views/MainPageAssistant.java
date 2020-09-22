package payrollSystem.views;

import java.awt.EventQueue;
import java.awt.SystemColor;

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
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class MainPageAssistant extends JFrame {

	private JPanel contentPane;
	private JLabel lblPrePayroll;
	private JLabel lblBankingSys;
	private JLabel lblExit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPageAssistant frame = new MainPageAssistant();
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
	public MainPageAssistant()
	{
		initComponents();
		createEvents();
	}

	private void initComponents()
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainPageAssistant.class.getResource("/payrollSystem/resources/money_64_.png")));
		setTitle("PAYROLL MANAGEMENT SYSTEM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(SystemColor.window);
		setContentPane(contentPane);
		
		JSeparator separator = new JSeparator();
		
		JLabel label = new JLabel("PAYROLL MANAGEMENT SYSTEM");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 35));
		
		JSeparator separator_1 = new JSeparator();
		
		lblPrePayroll = new JLabel("");
		
		lblPrePayroll.setToolTipText("PREPARE PAYROLL");
		lblPrePayroll.setIcon(new ImageIcon(MainPageAssistant.class.getResource("/payrollSystem/resources/envelope_256.png")));
		
		lblBankingSys = new JLabel("");
		
		lblBankingSys.setToolTipText("BANKING SYSTEM");
		lblBankingSys.setIcon(new ImageIcon(MainPageAssistant.class.getResource("/payrollSystem/resources/messages_256.png")));
		
		lblExit = new JLabel("");
		
		lblExit.setIcon(new ImageIcon(MainPageAssistant.class.getResource("/payrollSystem/resources/log-out_256.png")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(11, Short.MAX_VALUE)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 1336, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(334, Short.MAX_VALUE)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 709, GroupLayout.PREFERRED_SIZE)
					.addGap(314))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 1336, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(11, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(95)
					.addComponent(lblPrePayroll, GroupLayout.PREFERRED_SIZE, 237, GroupLayout.PREFERRED_SIZE)
					.addGap(223)
					.addComponent(lblExit)
					.addPreferredGap(ComponentPlacement.RELATED, 239, Short.MAX_VALUE)
					.addComponent(lblBankingSys, GroupLayout.PREFERRED_SIZE, 232, GroupLayout.PREFERRED_SIZE)
					.addGap(75))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(100)
							.addComponent(lblBankingSys, GroupLayout.PREFERRED_SIZE, 284, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(100)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblPrePayroll, GroupLayout.PREFERRED_SIZE, 274, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblExit))))
					.addContainerGap(174, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
	}

	private void createEvents() 
	{
		lblPrePayroll.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent arg0)
			{
				PreparePayroll prepare = new PreparePayroll();
				prepare.setVisible(true);
			}
		});
		lblExit.addMouseListener(new MouseAdapter()
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
		lblBankingSys.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				BankingSystem initiateBankingSys = new BankingSystem();
				initiateBankingSys.setVisible(true);
			}
		});
	}
}
