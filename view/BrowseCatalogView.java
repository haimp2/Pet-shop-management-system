package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.CardLayout;
import javax.swing.JTable;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JSplitPane;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BrowseCatalogView extends JFrame {

	private JPanel contentPane;
	private JButton btnLoadProducts;
	private JTable table;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BrowseCatalogView frame = new BrowseCatalogView();
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
	public BrowseCatalogView() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 857, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel BrowseCatalogPanel = new JPanel();
		BrowseCatalogPanel.setBackground(Color.WHITE);
		contentPane.add(BrowseCatalogPanel, "name_602249923729379");
		BrowseCatalogPanel.setLayout(null);
		
		JPanel BrowseCatalogTopPanel = new JPanel();
		BrowseCatalogTopPanel.setLayout(null);
		BrowseCatalogTopPanel.setBackground(Color.DARK_GRAY);
		BrowseCatalogTopPanel.setBounds(0, 0, 833, 118);
		BrowseCatalogPanel.add(BrowseCatalogTopPanel);
		
		JLabel lblBrocatalog = new JLabel("Browse Catalog");
		lblBrocatalog.setForeground(Color.WHITE);
		lblBrocatalog.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblBrocatalog.setBounds(283, 27, 240, 63);
		BrowseCatalogTopPanel.add(lblBrocatalog);
		
		btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnBack.setBounds(10, 11, 105, 23);
		BrowseCatalogTopPanel.add(btnBack);
		
		JLabel BrowseCatalogLogo = new JLabel("");
		BrowseCatalogLogo.setIcon(new ImageIcon(BrowseCatalogView.class.getResource("/resources/New Logo.png")));
		BrowseCatalogLogo.setBounds(626, 388, 174, 59);
		BrowseCatalogPanel.add(BrowseCatalogLogo);
		
		btnLoadProducts = new JButton("Load Products");
		btnLoadProducts.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLoadProducts.setBounds(339, 388, 136, 53);
		BrowseCatalogPanel.add(btnLoadProducts);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		scrollPane.setBounds(120, 142, 555, 235);
		BrowseCatalogPanel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setBackground(SystemColor.control);
	}
	
	//Listeners
	
		public void addLoadProductsListener(ActionListener listenForCalcButton){
	        
			btnLoadProducts.addActionListener(listenForCalcButton);  
		}
			
			public void addBackListener(ActionListener listenForCalcButton){
		        
				btnBack.addActionListener(listenForCalcButton);         
      
					
			
			    }
		
		//methods
		
		public void setTabel(ResultSet rs) {
			
			this.table.setModel(DbUtils.resultSetToTableModel(rs));
		}
		
		
		
}
