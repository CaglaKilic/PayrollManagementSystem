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
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class MainPage extends JFrame {

	private JPanel contentPane;
	private JLabel Search;
	private JLabel SeePayroll;
	private JLabel lblExit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage frame = new MainPage();
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
	public MainPage()
	{
		initComponents();
		createEvents();
	}

	private void initComponents()
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainPageAdmin.class.getResource("/payrollSystem/resources/money_64_.png")));
		setTitle("PAYROLL MANAGEMENT SYSTEM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.window);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JSeparator separator = new JSeparator();
		
		JLabel lblPayrollSystem = new JLabel("PAYROLL SYSTEM");
		lblPayrollSystem.setForeground(Color.BLACK);
		lblPayrollSystem.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 35));
		
		JSeparator separator_1 = new JSeparator();
		
		Search = new JLabel("");
		
		Search.setToolTipText("SEARCH PAYROLLS");
		Search.setIcon(new ImageIcon(MainPage.class.getResource("/payrollSystem/resources/magnifying-glass_256.png")));
		
		SeePayroll = new JLabel("");
		
		SeePayroll.setToolTipText("SEE PAYROLL");
		SeePayroll.setIcon(new ImageIcon(MainPage.class.getResource("/payrollSystem/resources/invoice_256.png")));
		
		lblExit = new JLabel("");
		lblExit.setIcon(new ImageIcon(MainPage.class.getResource("/payrollSystem/resources/door_128.png")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(separator, GroupLayout.DEFAULT_SIZE, 1336, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 1336, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(lblPayrollSystem)
							.addGap(479))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(65)
							.addComponent(SeePayroll, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE)
							.addGap(301)
							.addComponent(lblExit)
							.addPreferredGap(ComponentPlacement.RELATED, 268, Short.MAX_VALUE)
							.addComponent(Search, GroupLayout.PREFERRED_SIZE, 277, GroupLayout.PREFERRED_SIZE)
							.addGap(42))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblPayrollSystem, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
					.addGap(25)
					.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(204)
							.addComponent(lblExit, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(140)
							.addComponent(Search, GroupLayout.PREFERRED_SIZE, 266, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(131)
							.addComponent(SeePayroll, GroupLayout.PREFERRED_SIZE, 283, GroupLayout.PREFERRED_SIZE)))
					.addGap(135))
		);
		contentPane.setLayout(gl_contentPane);
		
	}

	private void createEvents()
	{
		SeePayroll.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				SeePayroll see = new SeePayroll();
				see.setVisible(true);
			}
		});
		Search.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				SearchPayrolls search = new SearchPayrolls();
				search.setVisible(true);
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
	}

}
