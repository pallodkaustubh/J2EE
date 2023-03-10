package callableStatement;

//ADDITION 


import java.sql.*;
import java.util.Scanner;

public class CallableDemo1_Adiition {

	public static void main(String[] args) {
		
		Scanner sc1 = new Scanner(System.in);
		System.out.println("Enter No 1");
		int no1=sc1.nextInt();
		System.out.println("Enter No 2");
		int no2 = sc1.nextInt();
		
		Connection con = null; 
		CallableStatement cstmt = null;
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja7", "root", "sql123");
		    
			
			//creating platform for CallableStatement
			cstmt = con.prepareCall("{?=call addnumbers(?,?)}");
			
			//set input to 2nd and 3rd placeholder
			
			cstmt.setInt(2, no1);
			cstmt.setInt(3, no2);
			
			//store output in first placeholder
			cstmt.registerOutParameter(1,Types.INTEGER);
			cstmt.execute();
			
			
			System.out.println("Addition is " +cstmt.getInt(1));
		
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}

}
