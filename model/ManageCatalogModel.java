package model;

import java.sql.ResultSet;

import DB.DeleteRecords;
import DB.SelectRecords;
import DB.UpdateRecords;

public class ManageCatalogModel {
	
private SelectRecords records = new SelectRecords();
private UpdateRecords updateRecords = new UpdateRecords();
private DeleteRecords deleteRecords = new DeleteRecords();
	
	public ResultSet productToTable() {
		
		return records.selectProduct();
		
	}
	
	public void updateProduct(String pid, String name, int amount, double price) {
		
		updateRecords.updateProduct(pid, name, amount, price);
		
	}
	
	public void addProduct(String pid, String name, String amount, double price) {
		
		
		
	}
	
	public void deleteProduct(String pid) {
		
		deleteRecords.deleteProduct(pid);
			
	}

	
	

}
