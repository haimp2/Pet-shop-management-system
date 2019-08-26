package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.ManageCatalogModel;
import utilitys.AddItemFactory;
import utilitys.SingletonFrameManager;
import view.ManageCatalogView;

public class ManageCatalogController {
	
	private ManageCatalogView view;
	private ManageCatalogModel model;
	
	private SingletonFrameManager frameManager = SingletonFrameManager.getInstance();	
	
	private String id, name, type;
	private int amount;
	private double price;
	
	private AddItemFactory itemFactory = new AddItemFactory();
	
	private void updateItemData() {
		this.id = this.view.getPidTextField();
		this.name = this.view.getProductNameTextField();
		this.type = this.view.getProductTypeComboBox();
		this.amount = this.view.getAmountTextField();
		this.price = this.view.getPriceTextField();
	}

	
	public ManageCatalogController(ManageCatalogView view, ManageCatalogModel model) {
		
		this.view = view;
		this.model = model;
		
		
		this.view.addLoadProductsListener(new LoadProductsListener());
		this.view.addAddProductListener(new AddProductListener());
		this.view.addUpadteProductListener(new UpadteProductListener());
		this.view.addDeleteProductListener(new DeleteProductListener());
		this.view.addClearListener(new ClearListener());
		this.view.addBackListener(new BackListener());
	}
	
	class LoadProductsListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			try {
					view.setTabel(model.productToTable());
			} catch (NumberFormatException ex) {
				
			}
		}
	}
	
	class AddProductListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			try {
					updateItemData();
					itemFactory.addItemToDb(type, id, name, amount, price);
					view.displayMessage("Product added!");
					view.setTabel(model.productToTable());
			} catch (NumberFormatException ex) {
				
			}
		}
	}
	
	class UpadteProductListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			try {
					updateItemData();
					model.updateProduct(id, name, amount, price);
					view.displayMessage("Product updated!");
					view.setTabel(model.productToTable());
					
			} catch (NumberFormatException ex) {
				
			}
		}
	}
	
	class DeleteProductListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			try {
					updateItemData();
					model.deleteProduct(id);
					view.displayMessage("Product deleted!");
					view.setTabel(model.productToTable());
				
			} catch (NumberFormatException ex) {
				
			}
		}
	}
	
	class ClearListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			try {
					view.clearTabel();
				
			} catch (NumberFormatException ex) {
				
			}
		}
	}
	
	class BackListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			try {
					frameManager.lunchAdminPage("     Main Menu");
					view.dispose();
				
			} catch (NumberFormatException ex) {
				
			}
		}
	}

}
