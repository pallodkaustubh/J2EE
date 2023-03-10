package CrudOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//Adding the Records

public class JdbcDemo1 {

	public static void main(String[] args) {
		
		Connection con = null;
		Statement stmt=null;
		
		String query = "insert into Product_info values(2,'Mobile',55000.25)";
		
		
		//load and register the driver
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			
			//establish the Connection 
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja7","root","sql123");
			
		
			//create statement platform 
			stmt=con.createStatement();
			
			//execute sql query
			int count = stmt.executeUpdate(query);
			
			System.out.println("Record inserted Succesfully");
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
