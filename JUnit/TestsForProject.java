package JUnit;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import DB.DeleteRecords;
import DB.InsertRecords;
import DB.SelectRecords;
import DB.UpdateRecords;
import utilitys.Employee;
import utilitys.Food;
import utilitys.Product;

class TestsForProject {
	
	InsertRecords insertRecords = new InsertRecords();
	DeleteRecords deleteRecords = new DeleteRecords();
	SelectRecords selectRecords = new SelectRecords();
	UpdateRecords updateRecords = new UpdateRecords();
	
	@Test
	public void addEmployeeTest() {  // Test if employee was added
		
		
		Employee emp = new Employee();
		
		emp.setFirstName("FirstNameTest");
		emp.setLastName("LastNameTest");
		emp.setId("11111");
		emp.setPassword("11111");
		emp.setManager(false);
		
		insertRecords.insertEmployee(emp.getId(), emp.getFirstName(), emp.getLastName(), emp.getPassword(), emp.isManager());
		
		assertTrue(selectRecords.selectEmployee(emp.getId(),emp.getPassword()));
	}
	

		@Test
		public void deleteEmployeeTest() { // Test if employee was deleted
			
			
			Employee emp = new Employee();
			
			emp.setFirstName("FirstNameTest");
			emp.setLastName("LastNameTest");
			emp.setId("11111");
			emp.setPassword("11111");
			emp.setManager(false);
			
			deleteRecords.deleteEmployee(emp.getId());
			
			assertFalse(selectRecords.selectEmployee(emp.getId(),emp.getPassword()));
		}
		
		@Test
		public void changeItemQuantityTest(){ // Test if quantity was changed
			
			int itemQuantity;
			
			itemQuantity = selectRecords.selectProductQuantity("1");
			
			
			updateRecords.updateProductQuantity("1", itemQuantity+1);
			
			assertEquals(itemQuantity+1, selectRecords.selectProductQuantity("1"));
			
		}
		
		@Test
		public void changeEmpPassTest(){  // Test if password was changed
			
			String empPass;
			
			updateRecords.updateEmpPass("308341858", "123456");
			
			empPass = selectRecords.selectEmployeePassword("308341858");
			
			assertEquals("123456", empPass);
			
		}
		
}
