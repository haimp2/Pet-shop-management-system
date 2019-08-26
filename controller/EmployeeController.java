package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.AdminController.addChangePassIconListener;
import controller.AdminController.addManageCatalogIconListener;
import controller.AdminController.addManageEmployeeIconListener;
import model.EmployeeModel;
import utilitys.SingletonFrameManager;
import view.EmployeeView;

public class EmployeeController {

	EmployeeView view;
	EmployeeModel model;
	private SingletonFrameManager frameManager = SingletonFrameManager.getInstance();
	
	public EmployeeController(EmployeeView view, EmployeeModel model) {

		this.view = view;
		this.model = model;
		
		this.view.addSignOutListener(new addSignOutListener());
		this.view.addChangeEmpPassIconListener(new addChangeEmpPassIconListener());
		this.view.addBrowsCatalogIconListener(new addBrowsCatalogIconListener());
	}
	
	
	class addChangeEmpPassIconListener implements ActionListener {

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
	
	class addBrowsCatalogIconListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			try {
					frameManager.lunchBrowseCatalogPage();
					view.dispose();
			} catch (NumberFormatException ex) {
				
			}
		}
	}
}
