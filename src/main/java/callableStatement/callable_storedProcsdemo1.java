package callableStatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

//add bike details accepted by user using stored procedures 



public class callable_storedProcsdemo1 {

	public static void main(String[] args) {
		
		
		Scanner sc1 = new Scanner(System.in);
		
		System.out.println("Enter Bike Model");
		String model =sc1.next();
		
		System.out.println("Enter Bike Company");
		String company =sc1.next();
		
		System.out.println("Enter Bike Price");
		Double price =sc1.nextDouble();
		
		
		Connection con = null; 
		CallableStatement cstmt = null;
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja7", "root", "sql123");
		    
			
			//creating platform for CallableStatement
			
			cstmt = con.prepareCall("{call bikeoperations(?,?,?)}");
			
		
			
			
			cstmt.setString(1,model);
			cstmt.setString(2,company);
			cstmt.setDouble(3,price);
			
		
			
			
			cstmt.execute();
			
			
			System.out.println("Bike Details Inserted Succesfully");
		
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}

}
