package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import java.awt.Color;

public class AdminView extends JFrame {

	private JPanel contentPane;
	private JLabel lblWelcom;
	private JPanel AdminTopPanel;
	private JButton btnManageCatalogIcon;
	private JButton btnManageEmployeeIcon;
	private JButton btnChangePassIcon;
	private JButton btnSignOut;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminView frame = new AdminView();
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
	public AdminView() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 857, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		
		JPanel AdminPanel = new JPanel();
		AdminPanel.setBackground(Color.WHITE);
		contentPane.add(AdminPanel, "name_509081136117147");
		AdminPanel.setLayout(null);
		
		AdminTopPanel = new JPanel();
		AdminTopPanel.setBounds(0, 0, 833, 118);
		AdminTopPanel.setBackground(Color.DARK_GRAY);
		AdminPanel.add(AdminTopPanel);
		AdminTopPanel.setLayout(null);
		
		btnSignOut = new JButton("Sign Out");
		btnSignOut.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSignOut.setBounds(10, 11, 114, 25);
		AdminTopPanel.add(btnSignOut);
		
		
		JLabel AdminPageLogo = new JLabel("");
		AdminPageLogo.setBounds(626, 388, 174, 59);
		AdminPageLogo.setIcon(new ImageIcon(AdminView.class.getResource("/resources/New Logo.png")));
		AdminPanel.add(AdminPageLogo);
		
		btnManageCatalogIcon = new JButton("");
		btnManageCatalogIcon.setBounds(103, 220, 128, 146);
		btnManageCatalogIcon.setIcon(new ImageIcon(AdminView.class.getResource("/resources/Manage_Catalog.png")));
		AdminPanel.add(btnManageCatalogIcon);
		
		btnManageEmployeeIcon = new JButton("");
		btnManageEmployeeIcon.setBounds(335, 220, 128, 146);
		btnManageEmployeeIcon.setIcon(new ImageIcon(AdminView.class.getResource("/resources/EMP_MNG.png")));
		AdminPanel.add(btnManageEmployeeIcon);
		
		btnChangePassIcon = new JButton("");
		btnChangePassIcon.setBounds(578, 220, 128, 146);
		btnChangePassIcon.setIcon(new ImageIcon(AdminView.class.getResource("/resources/Manage_Account.png")));
		AdminPanel.add(btnChangePassIcon);
		
		JLabel lblManageCatalog = new JLabel("Manage Catalog");
		lblManageCatalog.setBounds(103, 193, 101, 24);
		lblManageCatalog.setFont(new Font("Tahoma", Font.PLAIN, 13));
		AdminPanel.add(lblManageCatalog);
		
		JLabel lblManageEmployees = new JLabel("Manage Employees");
		lblManageEmployees.setBounds(335, 195, 128, 22);
		lblManageEmployees.setFont(new Font("Tahoma", Font.PLAIN, 13));
		AdminPanel.add(lblManageEmployees);
		
		JLabel lblChangePassword = new JLabel("Change Password");
		lblChangePassword.setBounds(578, 195, 111, 22);
		lblChangePassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		AdminPanel.add(lblChangePassword);
		
	}
	
	public void setName(String name) {
		lblWelcom = new JLabel(name);
		lblWelcom.setForeground(Color.WHITE);
		lblWelcom.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblWelcom.setBounds(283, 27, 479, 63);
		AdminTopPanel.add(lblWelcom);
	}



//Listeners

public void addManageCatalogIconListener(ActionListener listenForCalcButton){
    
	btnManageCatalogIcon.addActionListener(listenForCalcButton);         
	
	    }

public void addManageEmployeeIconListener(ActionListener listenForCalcButton){
    
	btnManageEmployeeIcon.addActionListener(listenForCalcButton);         
	
	    }

public void addChangePassIconListener(ActionListener listenForCalcButton){

	btnChangePassIcon.addActionListener(listenForCalcButton);         

	}

public void addSignOutListener(ActionListener listenForCalcButton){

	btnSignOut.addActionListener(listenForCalcButton);         

	}
}
