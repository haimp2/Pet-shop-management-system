package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.ManageCatalogController.AddProductListener;
import controller.ManageCatalogController.LoadProductsListener;
import controller.ManageCatalogController.UpadteProductListener;
import model.AdminModel;
import utilitys.SingletonFrameManager;
import view.AdminView;

public class AdminController {
	
	private AdminView view;
	private AdminModel model;
	private SingletonFrameManager frameManager = SingletonFrameManager.getInstance();
	
	public AdminController(AdminView view, AdminModel model) {
		
		this.view = view;
		this.model = model;
		
		this.view.addManageCatalogIconListener(new addManageCatalogIconListener());
		this.view.addManageEmployeeIconListener(new addManageEmployeeIconListener());
		this.view.addChangePassIconListener(new addChangePassIconListener());
		this.view.addSignOutListener(new addSignOutListener());
	}
	
	
	class addManageCatalogIconListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			try {
					frameManager.lunchManageCatalogPage();
					view.dispose();
			} catch (NumberFormatException ex) {
				
			}
		}
	}
	
	class addManageEmployeeIconListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			try {
				frameManager.lunchManageEmployeePage();
				view.dispose();
			} catch (NumberFormatException ex) {
				
			}
		}
	}
	
	class addChangePassIconListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			try {
					frameManager.lunchChangePasswordPage();
					view.dispose();
			} catch (NumberFormatException ex) {
				
			}
		}
	}
	
	class addSignOutListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			try {
					frameManager.lunchLoginPage();
					view.dispose();
			} catch (NumberFormatException ex) {
				
			}
		}
	}

}
