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
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.CardLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class ManageCatalogView extends JFrame {

	private JPanel contentPane;
	private JTextField pidTextField;
	private JTextField productNameTextField;
	private JTextField amountTextField;
	private JTextField priceTextField;
	private JButton btnLoadProducts;
	private JTable table;
	private JButton btnAdd;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JComboBox productTypeComboBox;
	private JButton btnBack;
	private JButton btnClear;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageCatalogView frame = new ManageCatalogView();
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
	public ManageCatalogView() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 857, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel ManageCatalogPanel = new JPanel();
		ManageCatalogPanel.setBackground(Color.WHITE);
		contentPane.add(ManageCatalogPanel, "name_602108842234399");
		ManageCatalogPanel.setLayout(null);
		
		JPanel ManageCatalogTopPanel = new JPanel();
		ManageCatalogTopPanel.setLayout(null);
		ManageCatalogTopPanel.setBackground(Color.DARK_GRAY);
		ManageCatalogTopPanel.setBounds(0, 0, 833, 118);
		ManageCatalogPanel.add(ManageCatalogTopPanel);
		
		JLabel lblManageCatalog_1 = new JLabel("Manage Catalog");
		lblManageCatalog_1.setForeground(Color.WHITE);
		lblManageCatalog_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblManageCatalog_1.setBounds(297, 28, 240, 63);
		ManageCatalogTopPanel.add(lblManageCatalog_1);
		
		btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnBack.setBounds(10, 11, 89, 23);
		ManageCatalogTopPanel.add(btnBack);
		
		JLabel ManageCatalogLogo = new JLabel("");
		ManageCatalogLogo.setIcon(new ImageIcon(ManageCatalogView.class.getResource("/resources/New Logo.png")));
		ManageCatalogLogo.setBounds(626, 388, 174, 59);
		ManageCatalogPanel.add(ManageCatalogLogo);
		
		pidTextField = new JTextField();
		pidTextField.setBackground(SystemColor.control);
		pidTextField.setBounds(10, 142, 150, 38);
		ManageCatalogPanel.add(pidTextField);
		pidTextField.setColumns(10);
		
		productNameTextField = new JTextField();
		productNameTextField.setColumns(10);
		productNameTextField.setBackground(SystemColor.menu);
		productNameTextField.setBounds(10, 209, 150, 38);
		ManageCatalogPanel.add(productNameTextField);
		
		amountTextField = new JTextField();
		amountTextField.setColumns(10);
		amountTextField.setBackground(SystemColor.menu);
		amountTextField.setBounds(10, 273, 150, 38);
		ManageCatalogPanel.add(amountTextField);
		
		priceTextField = new JTextField();
		priceTextField.setColumns(10);
		priceTextField.setBackground(SystemColor.menu);
		priceTextField.setBounds(10, 339, 150, 38);
		ManageCatalogPanel.add(priceTextField);
		
		JLabel lblProductId = new JLabel("Product ID:");
		lblProductId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblProductId.setBounds(10, 117, 132, 26);
		ManageCatalogPanel.add(lblProductId);
		
		JLabel lblProductName = new JLabel("Product Name:");
		lblProductName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblProductName.setBounds(10, 186, 132, 26);
		ManageCatalogPanel.add(lblProductName);
		
		JLabel lblAmount = new JLabel("Amount:");
		lblAmount.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAmount.setBounds(10, 251, 132, 26);
		ManageCatalogPanel.add(lblAmount);
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPrice.setBounds(10, 313, 132, 26);
		ManageCatalogPanel.add(lblPrice);
		
		btnLoadProducts = new JButton("Load Products:");
		btnLoadProducts.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLoadProducts.setBackground(SystemColor.control);
		btnLoadProducts.setBounds(477, 409, 139, 38);
		ManageCatalogPanel.add(btnLoadProducts);
		
		btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAdd.setBounds(238, 409, 91, 38);
		ManageCatalogPanel.add(btnAdd);
		
		btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnUpdate.setBounds(10, 409, 91, 38);
		ManageCatalogPanel.add(btnUpdate);
		
		btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnDelete.setBounds(125, 409, 91, 38);
		ManageCatalogPanel.add(btnDelete);
		
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setBounds(321, 129, 490, 245);
		ManageCatalogPanel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setBackground(SystemColor.control);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int row = table.getSelectedRow();
				String pid=(table.getModel().getValueAt(row, 0)).toString();
				pidTextField.setText(pid);
				String pname=(table.getModel().getValueAt(row, 1)).toString();
				productNameTextField.setText(pname);
				String amount=(table.getModel().getValueAt(row, 2)).toString();
				amountTextField.setText(amount);
				String price=(table.getModel().getValueAt(row, 3)).toString();
				priceTextField.setText(price);
			}
		});
		
		productTypeComboBox =new JComboBox();
		productTypeComboBox.setFont(new Font("Tahoma", Font.BOLD, 13));
		productTypeComboBox.setBackground(SystemColor.control);
		productTypeComboBox.setBounds(170, 209, 126, 38);
		ManageCatalogPanel.add(productTypeComboBox);
		
		productTypeComboBox.addItem("Food");
		productTypeComboBox.addItem("Snack");
		productTypeComboBox.addItem("Accessories");
		
		
		JLabel lblTypeonlyFor = new JLabel("Type:");
		lblTypeonlyFor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTypeonlyFor.setBounds(170, 186, 64, 26);
		ManageCatalogPanel.add(lblTypeonlyFor);
		
		JLabel lblonlyForAddind = new JLabel(" (only for addind items)");
		lblonlyForAddind.setBounds(170, 173, 139, 20);
		ManageCatalogPanel.add(lblonlyForAddind);
		
		btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnClear.setBounds(357, 409, 91, 38);
		ManageCatalogPanel.add(btnClear);
	}
	
	//Listeners
	
			public void addLoadProductsListener(ActionListener listenForCalcButton){
		        
				btnLoadProducts.addActionListener(listenForCalcButton);         
				
				    }
			
public void addAddProductListener(ActionListener listenForCalcButton){
		        
				btnAdd.addActionListener(listenForCalcButton);         
				
				    }

public void addUpadteProductListener(ActionListener listenForCalcButton){
    
	btnUpdate.addActionListener(listenForCalcButton);         
	
	    }

public void addDeleteProductListener(ActionListener listenForCalcButton){
    
	btnDelete.addActionListener(listenForCalcButton);         
	
	    }

public void addBackListener(ActionListener listenForCalcButton){
    
	btnBack.addActionListener(listenForCalcButton);         

    }

public void addClearListener(ActionListener listenForCalcButton){
    
	btnClear.addActionListener(listenForCalcButton);         

    }
			
			
			
			//methods
			
public void setTabel(ResultSet rs) {
	
	this.table.setModel(DbUtils.resultSetToTableModel(rs));
}

public void clearTabel() {
	
	pidTextField.setText("");
	productNameTextField.setText("");
	amountTextField.setText("");
	priceTextField.setText("");
	
}

			
			//Setters and Getters:

			public String getPidTextField() {
				return pidTextField.getText();
			}

			public String getProductNameTextField() {
				return productNameTextField.getText();
			}

			public int getAmountTextField() {
				try {
					return Integer.parseInt(amountTextField.getText());
					}
					catch (NumberFormatException e)
					{
						return 0;
					}

			}

			public double getPriceTextField() {
				
				try {
					return Double.parseDouble(priceTextField.getText());
					}
					catch (NumberFormatException e)
					{
						return 0;
					}
			}

			public String getProductTypeComboBox() {
				return productTypeComboBox.getSelectedItem().toString();	
			}
			
			
			//Massage Dialog:
			public void displayMessage(String Message){
				         
			    JOptionPane.showMessageDialog(this,Message);
				
				    }
			
			
}
