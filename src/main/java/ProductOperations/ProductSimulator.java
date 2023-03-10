package ProductOperations;

import java.sql.*;

import com.mysql.cj.protocol.Resultset;

public class ProductSimulator {
	static Connection con = null ;
	static Statement stmt = null;
 
	
	    static {
	    	 
	    	
	    	try {
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja7", "root", "sql123");
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
	    }
	    
		public void addProd(int id ,String name , double price){
			String query = "insert into Product_info values("+id+",'"+name+"',"+price+")";
		    try {
				stmt = con.createStatement();
		
				int count = stmt.executeUpdate(query);
				System.out.println(count +  "Product inserted");
		    } catch (SQLException e) {
				
				e.printStackTrace();
			}
		    
		}
		
		public void deleteProd(int id) {
			String query="delete from Product_info where product_id="+id+"";
			
			try {
				stmt = con.createStatement();
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
		    try {
				int count = stmt.executeUpdate(query);
				System.out.println(count + "Product Deleted");
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
	     public void displayProd(){
	    	 ResultSet rs = null;
	    	 
			String query = "select * From Product_info";
			try {
				stmt=con.createStatement();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			try {
				rs=stmt.executeQuery(query);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		
			System.out.println("ID\t\tName\t\tPrice");
			System.out.println("========================================================");
			
			try {
				while(rs.next()) {
					int id = rs.getInt(1);
					String name = rs.getString(2);
					double price = rs.getDouble(3);
					
					
					System.out.println(id+"\t\t"+name+"\t\t"+price);
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			
			
			
		 } 
		}

	

