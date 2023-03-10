package callableStatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class callable_CustomerType {

	public static void main(String[] args) {
		Scanner sc1 = new Scanner(System.in);
		System.out.println("Enter Credit Limit");
		int climit =sc1.nextInt();
		
		
		Connection con = null; 
		CallableStatement cstmt = null;
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja7", "root", "sql123");
		    
			
			//creating platform for CallableStatement
			
			cstmt = con.prepareCall("{?=call customerType(?)}");
			
			//set input to 2nd  placeholder
			
			cstmt.setInt(2, climit);
			
			//store output in first placeholder
			
			cstmt.registerOutParameter(1, Types.VARCHAR);
			cstmt.execute();
			
			
			System.out.println("Customer Type is " +cstmt.getString(1));
		
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}

}
