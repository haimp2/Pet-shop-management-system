package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.CardLayout;
import javax.swing.JTable;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

public class ManageEmployeeView extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnLoadEmp;
	private JButton btnAddNewEmployee;
	private JButton btnDeleteEmployee;
	private JTextField idTextField;
	private JTextField firstNameTextField;
	private JTextField lastNameTextField;
	private JTextField passwordTextField;
	private JCheckBox chckbxIsManager;
	private JLabel lblId;
	private JLabel lblFirstName;
	private JLabel lblLastName;
	private JLabel lblPassword;
	private JButton btnBack;
	private JButton btnClear;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageEmployeeView frame = new ManageEmployeeView();
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
	public ManageEmployeeView() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 857, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel ManageEmployeesPanel = new JPanel();
		ManageEmployeesPanel.setBackground(Color.WHITE);
		contentPane.add(ManageEmployeesPanel, "name_602316128121996");
		ManageEmployeesPanel.setLayout(null);
		
		JPanel ManegeEmployeesTopPanel = new JPanel();
		ManegeEmployeesTopPanel.setLayout(null);
		ManegeEmployeesTopPanel.setBackground(Color.DARK_GRAY);
		ManegeEmployeesTopPanel.setBounds(0, 0, 833, 118);
		ManageEmployeesPanel.add(ManegeEmployeesTopPanel);
		
		JLabel lblManageEmployees_1 = new JLabel("Manage Employees");
		lblManageEmployees_1.setForeground(Color.WHITE);
		lblManageEmployees_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblManageEmployees_1.setBounds(283, 27, 272, 63);
		ManegeEmployeesTopPanel.add(lblManageEmployees_1);
		
		btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnBack.setBounds(10, 11, 89, 23);
		ManegeEmployeesTopPanel.add(btnBack);
		
		JLabel ManageEmoloyeesLogo = new JLabel("");
		ManageEmoloyeesLogo.setIcon(new ImageIcon(ManageEmployeeView.class.getResource("/resources/New Logo.png")));
		ManageEmoloyeesLogo.setHorizontalAlignment(SwingConstants.LEFT);
		ManageEmoloyeesLogo.setBounds(649, 402, 174, 59);
		ManageEmployeesPanel.add(ManageEmoloyeesLogo);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(92, 139, 498, 246);
		ManageEmployeesPanel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setBackground(SystemColor.control);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int row = table.getSelectedRow();
				String id=(table.getModel().getValueAt(row, 0)).toString();
				idTextField.setText(id);
				String firstName=(table.getModel().getValueAt(row, 1)).toString();
				firstNameTextField.setText(firstName);
				String lastName=(table.getModel().getValueAt(row, 2)).toString();
				lastNameTextField.setText(lastName);
				String password=(table.getModel().getValueAt(row, 3)).toString();
				passwordTextField.setText(password);
				boolean isManager=((table.getModel().getValueAt(row, 4).toString()).equals("1"));
				chckbxIsManager.setSelected(isManager);
			}
		});
					
	
		
		btnLoadEmp = new JButton("Load Employees ");
		btnLoadEmp.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLoadEmp.setBounds(407, 402, 163, 45);
		ManageEmployeesPanel.add(btnLoadEmp);
		
		btnAddNewEmployee = new JButton("Add New Employee");
		btnAddNewEmployee.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAddNewEmployee.setBounds(220, 402, 168, 45);
		ManageEmployeesPanel.add(btnAddNewEmployee);
		
		btnDeleteEmployee = new JButton("Delete Employee");
		btnDeleteEmployee.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnDeleteEmployee.setBounds(32, 402, 163, 45);
		ManageEmployeesPanel.add(btnDeleteEmployee);
		
		idTextField = new JTextField();
		idTextField.setBackground(SystemColor.control);
		idTextField.setBounds(600, 139, 157, 45);
		ManageEmployeesPanel.add(idTextField);
		idTextField.setColumns(10);
		
		firstNameTextField = new JTextField();
		firstNameTextField.setColumns(10);
		firstNameTextField.setBackground(SystemColor.menu);
		firstNameTextField.setBounds(600, 196, 157, 45);
		ManageEmployeesPanel.add(firstNameTextField);
		
		lastNameTextField = new JTextField();
		lastNameTextField.setColumns(10);
		lastNameTextField.setBackground(SystemColor.menu);
		lastNameTextField.setBounds(600, 262, 157, 45);
		ManageEmployeesPanel.add(lastNameTextField);
		
		passwordTextField = new JTextField();
		passwordTextField.setColumns(10);
		passwordTextField.setBackground(SystemColor.menu);
		passwordTextField.setBounds(600, 324, 157, 45);
		ManageEmployeesPanel.add(passwordTextField);
		
		chckbxIsManager = new JCheckBox("Is Manager");
		chckbxIsManager.setFont(new Font("Tahoma", Font.BOLD, 13));
		chckbxIsManager.setBounds(600, 376, 157, 32);
		ManageEmployeesPanel.add(chckbxIsManager);
		
		lblId = new JLabel("ID:");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblId.setBounds(600, 124, 49, 14);
		ManageEmployeesPanel.add(lblId);
		
		lblFirstName = new JLabel("First Name:");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFirstName.setBounds(600, 183, 84, 14);
		ManageEmployeesPanel.add(lblFirstName);
		
		lblLastName = new JLabel("Last Name:");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLastName.setBounds(600, 248, 84, 14);
		ManageEmployeesPanel.add(lblLastName);
		
		lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPassword.setBounds(600, 307, 84, 14);
		ManageEmployeesPanel.add(lblPassword);
		
		btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnClear.setBounds(10, 139, 72, 45);
		ManageEmployeesPanel.add(btnClear);
	}
	
	
	//Getters and Setters:
	
		public String getPasswordTextField() {
			return passwordTextField.getText();
		}

		public String getLastNameTextField() {
			return lastNameTextField.getText();
		}

		public String getFirstNameTextField() {
			return firstNameTextField.getText();
		}

		public String getIdTextField() {
			return idTextField.getText();
		}
		
		public boolean getIsManager() {
			
			return chckbxIsManager.isSelected();
			
		}
		
	
	//methods
	
	public void setTabel(ResultSet rs) {
		
		this.table.setModel(DbUtils.resultSetToTableModel(rs));
	}
	
	public void clearTabel() {
		
		idTextField.setText("");
		firstNameTextField.setText("");
		lastNameTextField.setText("");
		passwordTextField.setText("");
		chckbxIsManager.setSelected(false);
		
	}
	
	
	//Listeners
	
		public void addLoadEmployeeListener(ActionListener listenForCalcButton){
	        
			btnLoadEmp.addActionListener(listenForCalcButton);         
			
			    }
		
		public void addBackListener(ActionListener listenForCalcButton){
		    
			btnBack.addActionListener(listenForCalcButton);         

		    }

		public void addClearListener(ActionListener listenForCalcButton){
		    
			btnClear.addActionListener(listenForCalcButton);         

		    }
		
public void addAddNewEmployeeListener(ActionListener listenForCalcButton){
	        
			btnAddNewEmployee.addActionListener(listenForCalcButton);         
			
			    }

public void addDeleteEmployeeListener(ActionListener listenForCalcButton){
    
	btnDeleteEmployee.addActionListener(listenForCalcButton);         
		
	   }
		
		//Massage Dialog:
		public void displayMessage(String Message){
			         
		    JOptionPane.showMessageDialog(this,Message);
			
			    }
		
}
