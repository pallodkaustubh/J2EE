package producttest;


import java.sql.*;

public class ProductDemo {
	static Connection con = null ;
	static Statement stmt = null;
	 ResultSet rs = null;
	
	static {
   	 
    	
    	try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja7", "root", "sql123");
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
    }
	
	public void maxPrice() {
		String query = "select * from Product_info where product_price = (select Max(product_price) from Product_info)";
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
	
	
	
	public void minPrice() {
		String query = "select * from Product_info where product_price = (select Min(product_price) from Product_info)";
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
