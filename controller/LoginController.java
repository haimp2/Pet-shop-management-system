package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.LoginModel;
import utilitys.Employee;
import utilitys.SingletonFrameManager;
import view.AdminView;
import view.EmployeeView;
import view.LoginView;

public class LoginController {

	private LoginView logInView;
	private LoginModel logInModel;
	private SingletonFrameManager frameManager = SingletonFrameManager.getInstance();
	
	public LoginController(LoginView logInView, LoginModel logInModel) {

		this.logInModel = logInModel;
		this.logInView = logInView;
		this.logInView.addSignInListener(new SignInListener());

	}

	class SignInListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			String id, passWord;

			try {

				id = logInView.getUserNameTextField();
				passWord = logInView.GetpasswordField();

				int res;
				
				Employee emp = new Employee();
				
				if(logInView.isFieldsOk()) {
					logInView.displayErrorMessage("Please Enter Both ID And Password");
				}
				
				else {

				res = logInModel.Authorization(id, passWord, emp);
				switch (res) {
				case 0:
					
					logInView.displayErrorMessage("Worng UserName Or Password!");
					break;
					
				case 1:
					frameManager.lunchAdminPage("Welcom " + emp.getFirstName() +" "+ emp.getLastName());
					logInView.dispose();
					break;
				case 2:
					frameManager.lunchEmployeePage("Welcom " + emp.getFirstName() +" "+ emp.getLastName());
					logInView.dispose();
					break;
					}
				}

			} catch (NumberFormatException ex) {
			}
		}
	}

}
