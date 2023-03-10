package PreparedStatements;

import java.sql.*;

public class PreparedDemo1 {
	public static void main (String[] args) {
	
	Connection con = null;
	PreparedStatement pstmt = null;
	
	
	String query = "insert into product_info values(?,?,?)";
	
	try {
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja7","root","sql123");
		pstmt = con.prepareStatement(query);
		
		
		pstmt.setInt(1, 9);
		pstmt.setString(2, "Lcd_Projectors");
		pstmt.setDouble(3, 30000);
		int count1 = pstmt.executeUpdate();
		
		
		pstmt.setInt(1, 7);
		pstmt.setString(2, "SmartWatch");
		pstmt.setDouble(3, 2799);
		int count2 = pstmt.executeUpdate();
		
		
		System.out.println(count1+count2+" "+"Products inserted");		
		
		
		
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	
	}
	
 }


