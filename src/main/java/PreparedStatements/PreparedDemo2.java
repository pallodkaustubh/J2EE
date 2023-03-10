package PreparedStatements;

import java.sql.*;


public class PreparedDemo2 {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		
		String query = "delete from product_info where product_id = ? ";
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja7","root","sql123");
			pstmt = con.prepareStatement(query);
			
			
			pstmt.setInt(1, 9);
		
			int count1 = pstmt.executeUpdate();
			
		
			pstmt.setInt(1, 7);
			
			int count2 = pstmt.executeUpdate();
			
			
			System.out.println(count1+count2+" "+"Products Deleted");		
			
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

}
