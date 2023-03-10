package CrudOperations;

//Delete the records

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo2 {

	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		
		
		String query="delete from Product_info where product_id<=2";
		//1.Loading the driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		//2.Creating connection
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja7", "root", "sql123");
			
		//3.creating statement platform
			
			stmt=con.createStatement();
		
		//4. execute sql Query	
			int count = stmt.executeUpdate(query);
			
			System.out.println("Record Deleted Succesfully");
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
		 
			e.printStackTrace();
		}

	}

}
