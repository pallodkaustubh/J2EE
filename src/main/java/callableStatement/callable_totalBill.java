package callableStatement;

import java.sql.*;
import java.util.Scanner;

public class callable_totalBill {

	public static void main(String[] args) {
		
		
		Connection con = null;
		CallableStatement cstmt = null;
		

		Scanner sc1 = new Scanner(System.in);
		System.out.println("Enter Price");
		double price=sc1.nextDouble();
		System.out.println("Enter Quantity");
		int quantity = sc1.nextInt();
		
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja7", "root", "sql123");

			//creating platform for CallableStatement
			
			cstmt = con.prepareCall("{?=call totalbill(?,?)}");
			
			//set input to 2nd and 3rd placeholder
			
			cstmt.setDouble(2, price);
			cstmt.setInt(3,quantity);
			
			//store output in first placeholder
			
			cstmt.registerOutParameter(1, Types.DOUBLE);
			cstmt.execute();
			
			System.out.println("Total Bill Amount is "+cstmt.getDouble(1));
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		

	}

}
