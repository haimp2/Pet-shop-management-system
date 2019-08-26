package DB;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;

public class DeleteRecords {
	
	private UpdateRecords updateRecords = new UpdateRecords();
	 /**
     * Connect to the test.db database
     *
     * @return the Connection object
     */
	 private Connection connect() {  
	        // SQLite connection string  
	        String url = "jdbc:sqlite:src/DB/PetShopDB.db";  
	        Connection conn = null;  
	        try {  
	            conn = DriverManager.getConnection(url);  
	        } catch (SQLException e) {  
	            System.out.println(e.getMessage());  
	        }  
	        return conn;  
	    }  
 
    /**
     * Delete a warehouse specified by the id
     *
     * @param id
     */
    public void deleteEmployee(String id) {
        String sql = "DELETE FROM employee WHERE id = ?";
 
        try  {
        	
        	Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
 
            // set the corresponding @param
            pstmt.setString(1, id);
            // execute the delete statement
            pstmt.executeUpdate();
            pstmt.close();
 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void deleteProduct(String id) {
    	String sql;
    	
    	if (updateRecords.isRecordExist(id, "Food")) {
    		
    		sql = "DELETE FROM Food WHERE id = ?";
    	}
    	
    	else if(updateRecords.isRecordExist(id, "Snack")) {
    		
    		sql = "DELETE FROM Snack WHERE id = ?";		
    	}
    	
    	else {
    		
    		sql = "DELETE FROM Accessories WHERE id = ?";	
    	}

 
        try  {
        	
        	Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
 
            // set the corresponding @param
            pstmt.setString(1, id);
            // execute the delete statement
            pstmt.executeUpdate();
 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
