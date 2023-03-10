package Transcation;

import java.sql.*;
import java.util.Scanner;

public class DeleteProduct {

	public static void main(String[] args) {
		 Scanner sc1 = new Scanner(System.in);
		 System.out.println("Enter Product Id To be Deleted");
		 int id = sc1.nextInt();
		 
		 
		 Connection con = null;
		 PreparedStatement pstmt = null; 
		 
		 String query = "delete from product_info where product_id = ?";
		 
		 try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja7","root","sql123");
			
			con.setAutoCommit(false);
			
			
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1, id);
			
			int count =pstmt.executeUpdate();
			
			System.out.println("Want To Undo ??");
			System.out.println("1:YES");
			System.out.println("2:No");
			int choice = sc1.nextInt();
			
			if(choice==1)
			{
				con.rollback();
				System.out.println("Transcation RollBack");
			}
			else if(choice==2) 
			{
				con.commit();
				System.out.println(count+" RECORD DELETED SUCCESSFULLY");
			}
			
		 } catch (SQLException e) {
			
			e.printStackTrace();
		}
		 

	}

}
