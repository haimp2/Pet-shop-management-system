package model;

import java.sql.ResultSet;

import DB.DeleteRecords;
import DB.InsertRecords;
import DB.SelectRecords;

public class ManageEmployeeModel {

private SelectRecords records = new SelectRecords();
private InsertRecords insert = new InsertRecords();
private DeleteRecords deleteRecords = new DeleteRecords();
	
	public ResultSet productToTable() {
		
		return records.selectEmployeeForAdmin();
	}
	
public void addEmployee(String id, String firstName, String lastName, String password, boolean isManager) {
		
		insert.insertEmployee(id, firstName, lastName, password, isManager);
	}

public void deleteEmployee(String id) {
	deleteRecords.deleteEmployee(id);
}
}