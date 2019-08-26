package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.BrowseCatalogModel;
import utilitys.Employee;
import utilitys.SingletonFrameManager;
import view.AdminView;
import view.BrowseCatalogView;
import view.EmployeeView;

public class BrowseCatalogController {
	
	private BrowseCatalogView view;
	private BrowseCatalogModel model;
	
	private SingletonFrameManager frameManager = SingletonFrameManager.getInstance();
	
	public BrowseCatalogController(BrowseCatalogView view, BrowseCatalogModel model) {
		
		this.view = view;
		this.model = model;
		this.view.addLoadProductsListener(new LoadProductsListener());
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
	
	class BackListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			try {
					frameManager.lunchEmployeePage("     Main Menu");
					view.dispose();
			} catch (NumberFormatException ex) {
				
			}
		}
	}
}

