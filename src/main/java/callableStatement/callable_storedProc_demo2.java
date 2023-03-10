package callableStatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class callable_storedProc_demo2 {
	public static void main(String[] args) {
	//product operations
		
		
		Scanner sc1 = new Scanner(System.in);
		
		
		System.out.println("Enter Product Id");
		int id =sc1.nextInt();
		System.out.println("Enter Product Name");
		String pname =sc1.next();
		
		
		System.out.println("Enter Product Price");
		Double price =sc1.nextDouble();
		
		System.out.println("Enter Product Id to be Deleted");
		int pid = sc1.nextInt();
		
		
		
		Connection con = null; 
		CallableStatement cstmt = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja7", "root", "sql123");
		    
			
			//creating platform for CallableStatement
			
			cstmt = con.prepareCall("{call productoperations(?,?,?,?)}");
			
			
			
			
			cstmt.setInt(1,id);
			cstmt.setString(2,pname);
			cstmt.setDouble(3,price);
			cstmt.setInt(4,pid);
			
			cstmt.execute();
	
			System.out.println("Opeartions performed Sucessfully");
			
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}

}
