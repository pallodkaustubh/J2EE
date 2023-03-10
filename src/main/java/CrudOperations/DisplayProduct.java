package CrudOperations;

import java.sql.*;

import java.sql.Statement;

public class DisplayProduct {

	public static void main(String[] args) {
		 Connection con =null;
		 Statement stmt = null ;
		 ResultSet rs = null;
		 
		 String query = "select * from Product_info ";
		 
		 try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja7","root","sql123");
			stmt=con.createStatement();
			rs = stmt.executeQuery(query);
		
			System.out.println("ID\t\tName\t\tPrice");
			System.out.println("========================================================");
			
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				double price = rs.getDouble(3);
				
				
				System.out.println(id+"\t\t"+name+"\t\t"+price);
			}
			
			
			
			
		 } catch (SQLException e) {
				
				e.printStackTrace();
			}
		 finally {
				if (con!=null) {
					try {
						con.close();
					} catch (SQLException e) {
						
						e.printStackTrace();
					}
					}
				if (stmt!=null) {
					try {
						stmt.close();
					} catch (SQLException e) {
					
						e.printStackTrace();
					}
				}
			 }

	}

}
