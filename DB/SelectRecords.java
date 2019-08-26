package DB;

import java.sql.DriverManager;  
import java.sql.Connection;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.sql.Statement;
import java.util.ArrayList;


import utilitys.Employee;
import utilitys.Product;

   
public class SelectRecords {  
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
   
  
    public boolean selectEmployee(String id, String password){  
    	 String sql = "SELECT * FROM employee where id = " + id + " AND password = " + password;  

         
         try {  
             Connection conn = this.connect();  
             Statement stmt  = conn.createStatement();  
             ResultSet rs    = stmt.executeQuery(sql);  

             boolean isEmpty = !rs.isBeforeFirst();
             
             if (isEmpty) {
            	 rs.close();
            	 return false;
             }
             
             else {
            	 rs.close();
            	 return true;
             }
              

        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
        
        return false;
    }
    
    public String selectEmployeePassword(String id){  
   	 String sql = "SELECT * FROM employee where id = " + id;  

        
        try {  
            Connection conn = this.connect();  
            Statement stmt  = conn.createStatement();  
            ResultSet rs    = stmt.executeQuery(sql);  

         
            String empPass = "" +rs.getString("Password");
            
            rs.close();
            stmt.close();
            
            return empPass;
             

       } catch (SQLException e) {  
           System.out.println(e.getMessage());  
       }  
       
       return "";
   }
    
    public int searchEmployee(String id, String password, Employee emp){  
    	
        String sql = "SELECT * FROM employee where id = " + id + " AND password = " + password;  

        
        try {  
            Connection conn = this.connect();  
            Statement stmt  = conn.createStatement();  
            ResultSet rs    = stmt.executeQuery(sql);  
            

            boolean isEmpty = !rs.isBeforeFirst();
            
            if (isEmpty) {
            	stmt.close();
            	rs.close();
            	return 0;
            }
            
            rs.next();
            
            emp.setFirstName(rs.getString("First_name"));
            emp.setLastName(rs.getString("Last_name"));
            
            if(rs.getBoolean("IsManager")) {
            	rs.close();
            	stmt.close();
            	return 1;
            }
            
            
            else {
            	rs.close();
            	stmt.close();
            	return 2;
            }
            
            

        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }
		return 0;  

    }
    
    
    public ResultSet selectProduct(){  
        String sql = "SELECT * FROM Snack UNION SELECT * FROM Accessories UNION SELECT * FROM Food";  

        
        try {  
            Connection conn = this.connect();  
            Statement stmt  = conn.createStatement();  
            ResultSet rs    = stmt.executeQuery(sql);  

            return rs;

        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }
		return null;  

    }
    
    public ResultSet selectEmployeeForAdmin(){  
        String sql = "SELECT * FROM employee";  

        
        try {  
            Connection conn = this.connect();  
            Statement stmt  = conn.createStatement();  
            ResultSet rs    = stmt.executeQuery(sql);  
         	
            return rs;

        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }
		return null;  

    }
    
    
    public int selectProductQuantity(String id){  
        String sql = "SELECT * FROM Snack UNION SELECT * FROM Accessories UNION SELECT * FROM Food"
        		+ " WHERE ID = "+id;  

        
        try {  
            Connection conn = this.connect();  
            Statement stmt  = conn.createStatement();  
            ResultSet rs    = stmt.executeQuery(sql);  
            
            int result = rs.getInt("Amount");
         	rs.close();
        	stmt.close();
            return result;

        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }
		return 0;  

    }
    
      
}