package producttest;

import java.sql.*;
import java.util.Scanner;


public class Login_App {

	public static void main(String[] args) {
		
		Scanner sc1 = new Scanner(System.in);
		System.out.println("Enter User Name");
		String user = sc1.next();
		
		System.out.println("Enter Password");
		String password = sc1.next();
		
	
		 Connection con = null ;
		 Statement stmt = null;
		 ResultSet rs = null;
		 
		 String query = " select user,password from login_info";
		 try {
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja7", "root", "sql123");
				stmt=con.createStatement();
				rs=stmt.executeQuery(query);
				boolean status =false;
				while(rs.next()) {
					String dbuser = rs.getString(1);
					String dbpass = rs.getString(2);
					if(dbuser.equals(user)&&dbpass.equals(password))
					{
						System.out.println("Login Success");
						status =true ; 
					}
					
				}
				if(status==false) {
					System.out.println("Invalid Username Or Password");
				}
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
		 
	}

}
