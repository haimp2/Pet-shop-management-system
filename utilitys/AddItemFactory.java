package utilitys;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddItemFactory {
	

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
	
	
	public void addItemToDb(String type,String id, String name, int amount, double price){
		
		if (type.equals("Food")) {    //If the item is Food
			
			 String sql = "INSERT INTO Food(id, name, amount, price) VALUES(?,?,?,?)";  

			    try{  
			        Connection conn = this.connect();  
			        PreparedStatement pstmt = conn.prepareStatement(sql);
			        pstmt.setString(1, id);
			        pstmt.setString(4, name); 
			        pstmt.setInt(2, amount);
			        pstmt.setDouble(3, price);
			        pstmt.executeUpdate();  
			    } catch (SQLException e) {  
			        System.out.println(e.getMessage());  
			    }  
			  
		}
		else if(type.equals("Snack")) {   //If the item is Snack
			
			 String sql = "INSERT INTO Snack(id, name, amount, price) VALUES(?,?,?,?)";  

			    try{  
			        Connection conn = this.connect();  
			        PreparedStatement pstmt = conn.prepareStatement(sql);
			        pstmt.setString(1, id);
			        pstmt.setString(2, name); 
			        pstmt.setInt(3, amount);
			        pstmt.setDouble(4, price);
			        pstmt.executeUpdate();  
			    } catch (SQLException e) {  
			        System.out.println(e.getMessage());  
			    }  
			
		}
		
		else if(type.equals("Accessories")) { //If the item is Accessories
			
			String sql = "INSERT INTO Accessories(id, name, amount, price) VALUES(?,?,?,?)";  

		    try{  
		        Connection conn = this.connect();  
		        PreparedStatement pstmt = conn.prepareStatement(sql);
		        pstmt.setString(1, id);
		        pstmt.setString(4, name); 
		        pstmt.setInt(2, amount);
		        pstmt.setDouble(3, price);
		        pstmt.executeUpdate();  
		    } catch (SQLException e) {  
		        System.out.println(e.getMessage());  
		    }  
		}
	}

}
