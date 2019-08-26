package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;  

public class UpdateRecords {
	
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
     * Update data of a employee specified by the id
     */
	 
    public void updateEmpPass(String id, String password) {
        String sql = "UPDATE employee SET password = ? WHERE id = ?";
 
        try 
        {
        	Connection conn = this.connect();  
            PreparedStatement pstmt = conn.prepareStatement(sql); 
            // set the corresponding @param
            pstmt.setString(1, password);
            pstmt.setString(2, id);
            
            // update
            pstmt.executeUpdate();
            pstmt.closeOnCompletion();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    
    public boolean isRecordExist(String id, String table) {
    	
    	 String sql = "SELECT * FROM " + table + " where id = " + id;

         try 
         {
        	 Connection conn = this.connect();
             Statement stmt  = conn.createStatement(); 
             ResultSet rs    = stmt.executeQuery(sql);
        
             boolean isEmpty = !rs.isBeforeFirst();
             rs.close();
             stmt.close();
             
             if(isEmpty) { 
            	    return false; 
            	    
            	} 
         } catch (SQLException e) {
             System.out.println(e.getMessage());
         }
         return true;
     }
    	
    
    
    public void updateProduct(String id, String name, int amount, double price ) {
    	
    	String sql;
    	
    	if (isRecordExist(id, "Food")) {
    		
    		sql = "UPDATE Food SET "
            		+ "name = ?, amount = ?, price = ? WHERE id = ?";
    	}
    	
    	else if(isRecordExist(id, "Snack")) {
    		
    		sql = "UPDATE Snack SET "
            		+ "name = ?, amount = ?, price = ? WHERE id = ?";		
    	}
    	
    	else {
    		
    		sql = "UPDATE Accessories SET "
            		+ "name = ?, amount = ?, price = ? WHERE id = ?";	
    	}

        try 
        {
        	Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql); 
            // set the corresponding @param
            pstmt.setString(1, name);
            pstmt.setInt(2, amount);
            pstmt.setDouble(3, price);
            pstmt.setString(4, id);
            
            // update
            pstmt.executeUpdate();
            pstmt.closeOnCompletion();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

public void updateProductQuantity(String id,int amount) {
    	
    	String sql;
    	
    	if (isRecordExist(id, "Food")) {
    		
    		sql = "UPDATE Food SET "
            		+ "amount = ? WHERE id = ?";
    	}
    	
    	else if(isRecordExist(id, "Snack")) {
    		
    		sql = "UPDATE Snack SET "
    				+ "amount = ? WHERE id = ?";	
    	}
    	
    	else {
    		
    		sql = "UPDATE Accessories SET "
    				+ "amount = ? WHERE id = ?";	
    	}

        try 
        {
        	Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql); 
            // set the corresponding @param
            pstmt.setInt(1, amount);
            pstmt.setString(2, id);
            
            // update
            pstmt.executeUpdate();
            pstmt.closeOnCompletion();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
