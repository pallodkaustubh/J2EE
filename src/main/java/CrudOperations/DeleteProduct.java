package CrudOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteProduct {

	public static void main(String[] args) {
		Scanner sc1 = new Scanner(System.in);
		 System.out.println("Enter product id");
		 int id = sc1.nextInt();
		 
		 
		 Connection con =null;
		 Statement stmt = null ;
		 
		 String query = "delete from Product_info where product_id="+id+"";
		 
		 try {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja7","root","sql123");
			stmt=con.createStatement();
			int count = stmt.executeUpdate(query);
			if(count>0) {
			System.out.println(count+"Record deleted  Successfully");
			}
			else {
				System.out.println("Product id does not Exists");
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
