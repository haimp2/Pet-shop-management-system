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

public class EmployeeView extends JFrame {

	private JPanel contentPane;
	private JLabel label;
	private JPanel EmployeeTopPanel;
	private JButton btnSignOut;
	private JButton BrowsCatalogIcon;
	private JButton ChangeEmpPassIcon;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeView frame = new EmployeeView();
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
	public EmployeeView() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 857, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel EmployeePanel = new JPanel();
		EmployeePanel.setBackground(Color.WHITE);
		contentPane.add(EmployeePanel, "name_509672541243406");
		EmployeePanel.setLayout(null);
		
		EmployeeTopPanel = new JPanel();
		EmployeeTopPanel.setLayout(null);
		EmployeeTopPanel.setBackground(Color.DARK_GRAY);
		EmployeeTopPanel.setBounds(0, 0, 833, 118);
		EmployeePanel.add(EmployeeTopPanel);
		
		btnSignOut = new JButton("Sign Out");
		btnSignOut.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSignOut.setBounds(10, 11, 114, 25);
		EmployeeTopPanel.add(btnSignOut);
		
		
		JLabel EmployeePageLogo = new JLabel("");
		EmployeePageLogo.setIcon(new ImageIcon(EmployeeView.class.getResource("/resources/New Logo.png")));
		EmployeePageLogo.setBounds(626, 388, 174, 59);
		EmployeePanel.add(EmployeePageLogo);
		
		ChangeEmpPassIcon = new JButton("");
		ChangeEmpPassIcon.setIcon(new ImageIcon(EmployeeView.class.getResource("/resources/Manage_Account.png")));
		ChangeEmpPassIcon.setBounds(448, 218, 128, 146);
		EmployeePanel.add(ChangeEmpPassIcon);
		
		BrowsCatalogIcon = new JButton("");
		BrowsCatalogIcon.setIcon(new ImageIcon(EmployeeView.class.getResource("/resources/search icon 2.png")));
		BrowsCatalogIcon.setBounds(212, 218, 128, 146);
		EmployeePanel.add(BrowsCatalogIcon);
		
		JLabel lblBrowseCatalog = new JLabel("Browse Catalog");
		lblBrowseCatalog.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblBrowseCatalog.setBounds(212, 193, 102, 22);
		EmployeePanel.add(lblBrowseCatalog);
		
		JLabel lblChangePassword_1 = new JLabel("Change Password");
		lblChangePassword_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblChangePassword_1.setBounds(448, 193, 112, 22);
		EmployeePanel.add(lblChangePassword_1);
	}
	
	public void setName(String name) {

		label = new JLabel(name);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.PLAIN, 30));
		label.setBounds(283, 27, 479, 63);
		EmployeeTopPanel.add(label);
	}
	
	//Listeners

	public void addSignOutListener(ActionListener listenForCalcButton){
	    
		btnSignOut.addActionListener(listenForCalcButton);         
		
		    }

	public void addBrowsCatalogIconListener(ActionListener listenForCalcButton){
	    
		BrowsCatalogIcon.addActionListener(listenForCalcButton);         
		
		    }

	public void addChangeEmpPassIconListener(ActionListener listenForCalcButton){

		ChangeEmpPassIcon.addActionListener(listenForCalcButton);         

		}


}
