package utilitys;

import controller.AdminController;
import controller.BrowseCatalogController;
import controller.ChangePasswordController;
import controller.EmployeeController;
import controller.LoginController;
import controller.ManageCatalogController;
import controller.ManageEmployeeController;
import model.AdminModel;
import model.BrowseCatalogModel;
import model.ChangePasswordModel;
import model.EmployeeModel;
import model.LoginModel;
import model.ManageCatalogModel;
import model.ManageEmployeeModel;
import view.AdminView;
import view.BrowseCatalogView;
import view.ChangePasswordView;
import view.EmployeeView;
import view.LoginView;
import view.ManageCatalogView;
import view.ManageEmployeeView;

public class SingletonFrameManager {
	
	private static SingletonFrameManager obj = null;
	
	private SingletonFrameManager() {} 
	
	public static SingletonFrameManager getInstance()  // Make an instance of FM
    { 
        if (obj==null) 
            obj = new SingletonFrameManager(); 
        return obj; 
    } 
	
	
	public void lunchAdminPage(String userName) {  //Move to Admin Page
		
		AdminView adminView = new AdminView();
		AdminModel adminModel = new AdminModel();
		adminView.setName(userName);
		adminView.setVisible(true);
		AdminController adminController = new AdminController(adminView, adminModel);
		
	}
	
	
public void lunchBrowseCatalogPage() {  //Move to Browse Catalog Page
		
	BrowseCatalogView catalogView = new BrowseCatalogView();
	BrowseCatalogModel catalogModel = new BrowseCatalogModel();
	catalogView.setVisible(true);
	BrowseCatalogController browseController = new BrowseCatalogController(catalogView, catalogModel);
	
	}

public void lunchChangePasswordPage() {  //Move to Change Password Page
	
	ChangePasswordModel changePassModel = new ChangePasswordModel();
	ChangePasswordView changePassView = new ChangePasswordView();
	changePassView.setVisible(true);
	ChangePasswordController changePassController = new ChangePasswordController(changePassView, changePassModel);
	
}

public void lunchEmployeePage(String userNmae) {  //Move to Employee Page
	
	EmployeeView employeeView = new EmployeeView();	
	EmployeeModel employeeModel = new EmployeeModel();
	employeeView.setName(userNmae);
	employeeView.setVisible(true);
	EmployeeController employeeController = new EmployeeController(employeeView,employeeModel);
}
	

public void lunchLoginPage() {  //Move to Log In Page Page
	
	LoginModel loginModel = new LoginModel();	
	LoginView loginView = new LoginView();
	loginView.setVisible(true);
	LoginController loginController = new LoginController(loginView,loginModel);
}

public void lunchManageCatalogPage() {
	
	ManageCatalogModel manageCatalogModel = new ManageCatalogModel();	
	ManageCatalogView manageCatalogView = new ManageCatalogView();
	manageCatalogView.setVisible(true);
	ManageCatalogController manageCatalogController = new ManageCatalogController(manageCatalogView,manageCatalogModel);

	
}

public void lunchManageEmployeePage() {  //Move to Manage Employee Page
	
	ManageEmployeeModel manageEmployeeModel = new ManageEmployeeModel();	
	ManageEmployeeView manageEmployeeView = new ManageEmployeeView();
	manageEmployeeView.setVisible(true);
	ManageEmployeeController manageEmployeeController = new ManageEmployeeController(manageEmployeeModel,manageEmployeeView);
	
	
}

}
