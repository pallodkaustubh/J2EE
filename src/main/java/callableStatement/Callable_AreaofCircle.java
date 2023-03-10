package callableStatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class Callable_AreaofCircle {

	public static void main(String[] args) {
		Scanner sc1 = new Scanner(System.in);
		System.out.println("Enter Radius");
		double rad =sc1.nextDouble();
		
		
		Connection con = null; 
		CallableStatement cstmt = null;
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja7", "root", "sql123");
		    
			
			//creating platform for CallableStatement
			
			cstmt = con.prepareCall("{?=call areaofcircle(?)}");
			
			//set input to 2nd and 3rd placeholder
			
			cstmt.setDouble(2, rad);
			
			//store output in first placeholder
			
			cstmt.registerOutParameter(1, Types.DOUBLE);
			cstmt.execute();
			
			
			System.out.println("Area Of circle Is  " +cstmt.getDouble(1));
		
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}


	}

}
