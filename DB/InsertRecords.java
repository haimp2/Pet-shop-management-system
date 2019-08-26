package DB;

import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.SQLException;  
   
public class InsertRecords {  
   
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
   
  
    public void insertEmployee(String id, String firstName, String lastName, String password, boolean isManager) {  
        String sql = "INSERT INTO employee(id, first_name, last_name, password, IsManager) VALUES(?,?,?,?,?)";  
   
        try{  
            Connection conn = this.connect();  
            PreparedStatement pstmt = conn.prepareStatement(sql);  
            pstmt.setString(1, id);  
            pstmt.setString(2, firstName); 
            pstmt.setString(3, lastName);  
            pstmt.setString(4, password); 
            pstmt.setBoolean(5, isManager);  
            pstmt.executeUpdate();  
        	pstmt.close();
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
    }  


public void insertProduct(String type, String id, String name, int amount, double price) {  
    String sql = "INSERT INTO ?(id, name, amount, price) VALUES(?,?,?,?)";  

    try{  
        Connection conn = this.connect();  
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, type);
        pstmt.setString(2, name);
        pstmt.setInt(3, amount);
        pstmt.setDouble(4, price);
        pstmt.setString(5, id); 
        pstmt.executeUpdate();  
    } catch (SQLException e) {  
        System.out.println(e.getMessage());  
    }  
}  
}