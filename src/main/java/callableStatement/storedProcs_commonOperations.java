package callableStatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class storedProcs_commonOperations {

	public static void main(String[] args) {
          
		
		Scanner sc1 = new Scanner(System.in);
		
		System.out.println("Enter Bike Model");
		String model =sc1.next();
		
		System.out.println("Enter Bike Company");
		String company =sc1.next();
		
		System.out.println("Enter Bike Price");
		Double price =sc1.nextDouble();
		
		System.out.println("Enter Product ID");
		int pid =sc1.nextInt();
		
		System.out.println("Enter Updated Employee Salary");
		Double upsalary =sc1.nextDouble();
		
		System.out.println("Enter Employee ID Whose Salary is To be Updated");
		int eid =sc1.nextInt();
		
		
		Connection con = null; 
		CallableStatement cstmt = null;
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja7", "root", "sql123");
		    
			
			//creating platform for CallableStatement
			
			cstmt = con.prepareCall("{call commonoperations(?,?,?,?,?,?)}");
			
			cstmt.setString(1,model);
			cstmt.setString(2,company);
			cstmt.setDouble(3,price);
			cstmt.setInt(4,pid);
			cstmt.setDouble(5,upsalary);
			cstmt.setInt(6,eid);
		
			cstmt.execute();
			
			System.out.println("Process Executed Succesfully");
		
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}


	}

}
