package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.ChangePasswordModel;
import utilitys.Employee;
import utilitys.SingletonFrameManager;
import view.ChangePasswordView;

public class ChangePasswordController {
	
	private ChangePasswordView view;
	private ChangePasswordModel model;
	private SingletonFrameManager frameManager = SingletonFrameManager.getInstance();
	
	public ChangePasswordController(ChangePasswordView view, ChangePasswordModel model) {
		
		this.view = view;
		this.model = model;
		this.view.addConfirmListener(new ConfirmListener());
	}
		
	
	class ConfirmListener implements ActionListener {
		

		public void actionPerformed(ActionEvent e) {
		
		
			String id, oldPassword, newPass;

		try {

			id = view.getUserIdField();
			oldPassword = view.getOldPasswordField();
			newPass = view.getNewPasswordField();
			int res;
			
			Employee emp = new Employee();

			res = model.changePass(id, oldPassword, newPass);
			switch (res) {
			case 0:
				view.displayErrorMessage("Worng UserName Or Password!");
				break;
				
			case 1:
				view.displayErrorMessage("Password Has Changed!");
				frameManager.lunchLoginPage();
				view.dispose();
				break;
		
			}

		} catch (NumberFormatException ex) {
		}
		}
	}
}
		



