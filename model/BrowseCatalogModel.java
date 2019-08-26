package model;

import java.sql.ResultSet;

import DB.SelectRecords;

public class BrowseCatalogModel {
	
	private SelectRecords records = new SelectRecords();
	
	public ResultSet productToTable() {
		
		return records.selectProduct();
		
	}

}
