package producttest;

import java.sql.*;
import java.sql.DriverManager;

import java.util.Scanner;

public class MainApp2 {
	public static void main (String[] args) {
		 Connection con = null ;
		 Statement stmt = null;
		 ResultSet rs = null;
    Scanner sc1 = new Scanner(System.in);
    System.out.println("Enter Lower Price ");
    int lower = sc1.nextInt();
    
    
    System.out.println("Enter higher Price");
    int higher = sc1.nextInt();
    
    String query = "select * from Product_info where product_price IN ("+lower+","+higher+")";
    try {
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja7", "root", "sql123");
	} catch (SQLException e) {
	
		e.printStackTrace();
	}
	try {
		stmt=con.createStatement();
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	try {
		rs=stmt.executeQuery(query);
	} catch (SQLException e) {
		
		e.printStackTrace();
	}

	System.out.println("ID\t\tName\t\tPrice");
	System.out.println("========================================================");
	
	try {
		while(rs.next()) {
			int id = rs.getInt(1);
			String name = rs.getString(2);
			double price = rs.getDouble(3);
			
			
			System.out.println(id+"\t\t"+name+"\t\t"+price);
		}
	} catch (SQLException e) {
		
		e.printStackTrace();
	
    
 }
}
}
