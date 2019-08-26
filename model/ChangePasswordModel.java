package model;

import java.util.ArrayList;

import DB.SelectRecords;
import DB.UpdateRecords;
import utilitys.Employee;

public class ChangePasswordModel {
	
	private UpdateRecords update = new UpdateRecords();
	private SelectRecords selectRec = new SelectRecords();
	
	private boolean Authorization(String id, String password) {
	
		
		return selectRec.selectEmployee(id, password);
	}
	
	public int changePass (String id, String oldPass, String newPass) {
		
		if(Authorization(id, oldPass)) {
			update.updateEmpPass(id, newPass);
			return 1;
		}
		
		else return 0;
	}

}
