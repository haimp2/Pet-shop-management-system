package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginView extends JFrame {

	private JPanel contentPane;
	private JTextField UserNameTextField;
	private JPasswordField passwordField;
	private JButton btnSignIn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView frame = new LoginView();
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
	public LoginView() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 857, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel LogInPanel = new JPanel();
		LogInPanel.setBackground(Color.WHITE);
		contentPane.add(LogInPanel, "name_601503960252093");
		LogInPanel.setLayout(null);
		
		JPanel LogInSidePanel = new JPanel();
		LogInSidePanel.setBackground(Color.DARK_GRAY);
		LogInSidePanel.setBounds(0, 0, 243, 483);
		LogInPanel.add(LogInSidePanel);
		LogInSidePanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(LoginView.class.getResource("/resources/1492460623Minisoft-icon-17.png")));
		lblNewLabel.setBounds(0, 264, 243, 166);
		LogInSidePanel.add(lblNewLabel);
		
		JLabel lblPetShop = new JLabel("Pet Shop");
		lblPetShop.setForeground(Color.WHITE);
		lblPetShop.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPetShop.setBounds(81, 28, 84, 22);
		LogInSidePanel.add(lblPetShop);
		
		JLabel lblManagementSystem = new JLabel("Management System");
		lblManagementSystem.setForeground(Color.WHITE);
		lblManagementSystem.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblManagementSystem.setBounds(42, 48, 165, 30);
		LogInSidePanel.add(lblManagementSystem);
		
		JLabel LogInLogo = new JLabel("");
		LogInLogo.setIcon(new ImageIcon(LoginView.class.getResource("/resources/New Logo.png")));
		LogInLogo.setBounds(626, 388, 174, 59);
		LogInPanel.add(LogInLogo);
		
		UserNameTextField = new JTextField();
		UserNameTextField.setBackground(SystemColor.control);
		UserNameTextField.setBounds(276, 221, 202, 38);
		LogInPanel.add(UserNameTextField);
		UserNameTextField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(SystemColor.control);
		passwordField.setBounds(276, 297, 200, 38);
		LogInPanel.add(passwordField);
		
		JLabel lblUserName = new JLabel("Employee ID:");
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUserName.setBounds(276, 195, 72, 15);
		LogInPanel.add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPassword.setBounds(276, 270, 73, 16);
		LogInPanel.add(lblPassword);
		
		btnSignIn = new JButton("Sign In");
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});


		btnSignIn.setBackground(SystemColor.controlShadow);
		btnSignIn.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSignIn.setBounds(392, 374, 167, 43);
		LogInPanel.add(btnSignIn);
		
		JLabel LogInIcon = new JLabel("");
		LogInIcon.setIcon(new ImageIcon(LoginView.class.getResource("/resources/users-icon.png")));
		LogInIcon.setBounds(466, 41, 89, 104);
		LogInPanel.add(LogInIcon);
		

	}
	
	
	//Listeners
	
	public void addSignInListener(ActionListener listenForCalcButton){
        
		btnSignIn.addActionListener(listenForCalcButton);         
		
		    }
	public void displayErrorMessage(String errorMessage){
		         
		        JOptionPane.showMessageDialog(this, errorMessage);
		
		    }
	
	//Getters
	
	public String getUserNameTextField() {
		
		return UserNameTextField.getText();
	}
	
	public String GetpasswordField() {
		
		char [] pass = passwordField.getPassword();
		
		StringBuilder sb = new StringBuilder();
		for (Character ch: pass) {
			sb.append(ch);
		}

		String string = sb.toString();
		
		return string;
	}
	
	//methods:
	
	public boolean isFieldsOk() {
		return (UserNameTextField.getText().isEmpty()||passwordField.getText().isEmpty());
	}
	
	//Massage Dialog:
	public void displayMessage(String Message){
		         
	    JOptionPane.showMessageDialog(this,Message);
		
		    }
	
	
	
}
