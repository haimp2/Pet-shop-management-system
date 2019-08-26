package model;
import java.util.ArrayList;

import DB.SelectRecords;
import utilitys.Employee;

public class LoginModel {
	
		private SelectRecords selectRec = new SelectRecords();
		
		public int Authorization(String id, String password, Employee emp) {
			
			return selectRec.searchEmployee(id, password, emp);

		}
		
	    

}
