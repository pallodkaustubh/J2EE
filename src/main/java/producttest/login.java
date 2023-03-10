package producttest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class login {
	static Connection con = null ;
	static Statement stmt = null;
    static ResultSet rs = null;
	Scanner sc1 = new Scanner(System.in);
	public void Login() {
		 
	System.out.println("Enter User Name");
	String user = sc1.next();
	
	System.out.println("Enter Password");
	int password = sc1.nextInt();
	

	
	 
	 String query = " select user,password from login_info";
	 try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja7", "root", "sql123");
			stmt=con.createStatement(); 
			rs=stmt.executeQuery(query);
			boolean status =false;
			while(rs.next()) {
				String dbuser = rs.getString(1);
				int dbpass = rs.getInt(2);
				if(dbuser.equals(user)&&dbpass==(password))
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
	
	public void Operations() {
		System.out.println("Enter YOUR CHOICE");
		System.out.println("1:DISPLAY PROD\n2:ADD PRODUCT");
		int choice = sc1.nextInt();
		if(choice==1) {
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
		if(choice==2) {

			System.out.println("Enter Prod id");
			int id = sc1.nextInt();
			
			System.out.println("Enter  Prod name");
			String name = sc1.next();
			
			System.out.println("Enter prod price");
			double price = sc1.nextDouble();
			
			String query = "insert into Product_info values("+id+",'"+name+"',"+price+")";
		    try {
				stmt = con.createStatement();
				
			
		    
				int count = stmt.executeUpdate(query);
				System.out.println(count +  "Product inserted");
		    }	catch (SQLException e1) {
					
					e1.printStackTrace();
				}
		}
	}

	 

}
