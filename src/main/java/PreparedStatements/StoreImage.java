package PreparedStatements;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;

public class StoreImage {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		FileInputStream fin = null ;
		
		
		String query = "insert into course_info(course_name,course_image) values(?,?)";
		
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja7", "root", "sql123");
			pstmt = con.prepareStatement(query);
			
			
			pstmt.setString(1, "java");
			fin = new FileInputStream("C:\\Users\\kaustubh pallod\\Downloads\\java.png");
			pstmt.setBinaryStream(2, fin);
			pstmt.executeUpdate();
			
			

			pstmt.setString(1, "sql");
			fin = new FileInputStream("C:\\Users\\kaustubh pallod\\Downloads\\sql.png");
			pstmt.setBinaryStream(2, fin);
			pstmt.executeUpdate();
			
			
			
			
			
			System.out.println("Data Inserted Succesfully");
			
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
