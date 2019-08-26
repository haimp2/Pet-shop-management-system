package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JTextField;

public class ChangePasswordView extends JFrame {

	private JPanel contentPane;
	private JTextField userIdField;
	private JPasswordField oldPassField;
	private JPasswordField newPassField;
	private JButton btnConfirm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangePasswordView frame = new ChangePasswordView();
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
	public ChangePasswordView() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 857, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel ChangePasswordPanel = new JPanel();
		ChangePasswordPanel.setBackground(Color.WHITE);
		contentPane.add(ChangePasswordPanel, "name_602502702478268");
		ChangePasswordPanel.setLayout(null);
		
		JPanel ChangePassTopPanel = new JPanel();
		ChangePassTopPanel.setLayout(null);
		ChangePassTopPanel.setBackground(Color.DARK_GRAY);
		ChangePassTopPanel.setBounds(0, 0, 833, 118);
		ChangePasswordPanel.add(ChangePassTopPanel);
		
		JLabel lblChangePassword_2 = new JLabel("Change Password");
		lblChangePassword_2.setForeground(Color.WHITE);
		lblChangePassword_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblChangePassword_2.setBounds(283, 27, 251, 63);
		ChangePassTopPanel.add(lblChangePassword_2);
		
		JLabel ChangePassPageLogo = new JLabel("");
		ChangePassPageLogo.setIcon(new ImageIcon(ChangePasswordView.class.getResource("/resources/New Logo.png")));
		ChangePassPageLogo.setBounds(626, 388, 174, 59);
		ChangePasswordPanel.add(ChangePassPageLogo);
		
		userIdField = new JTextField();
		userIdField.setBackground(SystemColor.menu);
		userIdField.setBounds(287, 181, 226, 38);
		ChangePasswordPanel.add(userIdField);
		
		oldPassField = new JPasswordField();
		oldPassField.setBackground(SystemColor.menu);
		oldPassField.setBounds(287, 250, 226, 38);
		ChangePasswordPanel.add(oldPassField);
		
		newPassField = new JPasswordField();
		newPassField.setBackground(SystemColor.menu);
		newPassField.setBounds(287, 321, 226, 38);
		ChangePasswordPanel.add(newPassField);
		
		btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnConfirm.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnConfirm.setBackground(SystemColor.controlShadow);
		btnConfirm.setBounds(321, 385, 167, 43);
		ChangePasswordPanel.add(btnConfirm);
		
		JLabel lblEnterUserID = new JLabel("Enter User ID:");
		lblEnterUserID.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEnterUserID.setBounds(287, 156, 126, 24);
		ChangePasswordPanel.add(lblEnterUserID);
		
		JLabel lblEnterOldPassword = new JLabel("Enter Old Password:");
		lblEnterOldPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEnterOldPassword.setBounds(287, 226, 126, 24);
		ChangePasswordPanel.add(lblEnterOldPassword);
		
		JLabel lblEnterNewPass = new JLabel("Enter New Password:");
		lblEnterNewPass.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEnterNewPass.setBounds(287, 295, 179, 24);
		ChangePasswordPanel.add(lblEnterNewPass);

	}
	
	//Getters and Setters

	public String getUserIdField() {
		return userIdField.getText();
		}

	public void setPasswordField(JPasswordField passwordField) {
		this.userIdField = passwordField;
	}

	public String getOldPasswordField() {
		char [] pass = oldPassField.getPassword();
		
		StringBuilder sb = new StringBuilder();
		for (Character ch: pass) {
			sb.append(ch);
		}

		String string = sb.toString();
		
		return string;
	}

	public void setPasswordField_1(JPasswordField passwordField_1) {
		this.oldPassField = passwordField_1;
	}

	public String getNewPasswordField() {
		char [] pass = newPassField.getPassword();
		
		StringBuilder sb = new StringBuilder();
		for (Character ch: pass) {
			sb.append(ch);
		}

		String string = sb.toString();
		
		return string;
	}

	public void setPasswordField_2(JPasswordField passwordField_2) {
		this.newPassField = passwordField_2;
	}



	//Listeners

	public void addConfirmListener(ActionListener listenForCalcButton){
      
		btnConfirm.addActionListener(listenForCalcButton);         
		
		    }
	public void displayErrorMessage(String errorMessage){
		         
		        JOptionPane.showMessageDialog(this, errorMessage);
		
		    }
	
	//Massage Dialog:
		public void displayMessage(String Message){
			         
		    JOptionPane.showMessageDialog(this,Message);
			
			    }
}
