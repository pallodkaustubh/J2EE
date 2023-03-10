package producttest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class signup {

	
	public void Signup() {
		Scanner sc1 = new Scanner(System.in);
		System.out.println("Enter user id");
		int id = sc1.nextInt();
		
		System.out.println("Enter User Name");
		String user = sc1.next();
		
		System.out.println("Enter Password");
		int password = sc1.nextInt();
		

		 Connection con = null ;
		 Statement stmt = null;
		 ResultSet rs = null;
		 
		 String query = "insert into login_info values("+id+",'"+user+"',"+password+")";
		 try {
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja7", "root", "sql123");
				stmt=con.createStatement();
				int count = stmt.executeUpdate(query);
				System.out.println("SIGN UP SUCCESSFULL");
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
		} 
}
