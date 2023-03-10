package callableStatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class callable_discount {

	public static void main(String[] args) {
		Scanner sc1 = new Scanner(System.in);
		System.out.println("Enter Bill Amt");
		int billamt =sc1.nextInt();
		System.out.println("Enter Customer type\n1:regular\t2:premium");
		String ctype =sc1.next();
		
		
		Connection con = null; 
		CallableStatement cstmt = null;
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja7", "root", "sql123");
		    
			
			//creating platform for CallableStatement
			
			cstmt = con.prepareCall("{?=call discount(?,?)}");
			
			//set input to 2nd and 3rd  placeholder
			
			cstmt.setInt(2,billamt);
			cstmt.setString(3,ctype);
			
			//store output in first placeholder
			
			cstmt.registerOutParameter(1, Types.DOUBLE);
			cstmt.execute();
			
			
			System.out.println("Bill Amount After Discount   " +cstmt.getDouble(1));
		
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}

}
