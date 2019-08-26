package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.ManageCatalogController.BackListener;
import controller.ManageCatalogController.ClearListener;
import model.ManageEmployeeModel;
import utilitys.SingletonFrameManager;
import view.ManageEmployeeView;

public class ManageEmployeeController {
	
	private ManageEmployeeModel model = new ManageEmployeeModel();
	private ManageEmployeeView view = new ManageEmployeeView();
	
	private SingletonFrameManager frameManager = SingletonFrameManager.getInstance();
	
	public ManageEmployeeController( ManageEmployeeModel model, ManageEmployeeView view){
		
		this.view = view;
		this.model = model;
		this.view.addLoadEmployeeListener(new LoadEmployeeListener());
		this.view.addAddNewEmployeeListener(new AddEmployeeListener());
		this.view.addDeleteEmployeeListener(new DeleteEmployeeListener());
		this.view.addClearListener(new ManagerClearListener());
		this.view.addBackListener(new ManagerBackListener());
	}

	
	class LoadEmployeeListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			try {
					view.setTabel(model.productToTable());
			} catch (NumberFormatException ex) {
				
			}
		}
	}
	
	class AddEmployeeListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
		String id, firstName, lastName, password;
		boolean isManager;
		
		id = view.getIdTextField();
		firstName = view.getFirstNameTextField();
		lastName = view.getLastNameTextField();
		password = view.getPasswordTextField();
		isManager = view.getIsManager();
		
		model.addEmployee(id, firstName, lastName, password, isManager);
		
		view.displayMessage("Employee Has Been Added!");
		
		view.setTabel(model.productToTable());
	
		}
	}

	class DeleteEmployeeListener implements ActionListener {
	
	public void actionPerformed(ActionEvent e) {
		
		String id;
		
		id = view.getIdTextField();
		
		model.deleteEmployee(id);
		
		view.displayMessage("Employee Has Been Deleted!");
		
		view.setTabel(model.productToTable());
	}
	
	}
	class ManagerClearListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			try {
					view.clearTabel();
				
			} catch (NumberFormatException ex) {
				
			}
		}
	}
	
	class ManagerBackListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			try {
					frameManager.lunchAdminPage("");
					view.dispose();
				
			} catch (NumberFormatException ex) {
				
			}
		}
	}


	
}
