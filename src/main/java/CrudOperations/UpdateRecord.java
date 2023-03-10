package CrudOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateRecord {
	public static void main(String[] args) {
		Scanner sc1 = new Scanner(System.in);
		 System.out.println("Enter product id");
		 int id = sc1.nextInt();
		 
		 System.out.println("Enter Updated Price ");
		 double updateprice = sc1.nextDouble();
		 
		 Connection con =null;
		 Statement stmt = null ;
		 
		 String query = "update Product_info set Product_price="+updateprice+" where Product_id ="+id+"";
		 
		 try {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja7","root","sql123");
			stmt=con.createStatement();
			int count = stmt.executeUpdate(query);
		
			System.out.println(count+ "Record Updated  Successfully");
			
			
			
			
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
