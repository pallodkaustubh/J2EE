package PreparedStatements;

import java.sql.*;
import java.util.Scanner;


public class BikeOperations {
	static Connection con = null ;
	static ResultSet rs = null;
	static PreparedStatement stmt = null;
	Scanner sc1 = new Scanner(System.in);

static {
	
	try {
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja7", "root", "sql123");
	} catch (SQLException e) {
	
		e.printStackTrace();
	
     }
  }


   public void addBike(String model, String company , double price) {
	   String query = "insert into bike_info(model,company,price) values(?,?,?)";
	    try {
	    	
	    	
		stmt=con.prepareStatement(query);
			
			stmt.setString(1,model);
			stmt.setString(2,company);
			stmt.setDouble(3,price);
			
			stmt.executeUpdate();

			System.out.println("" +  "Bike Details inserted");
		 
	    } catch (SQLException e) {
			
			e.printStackTrace();
		}
    }
   
   public void getBikebyModel(String model) {
	   
		String query = "select * From bike_info where model=?";
		try {
			stmt=con.prepareStatement(query);
			
			stmt.setString(1,model);
			rs=stmt.executeQuery();
	
	
		System.out.println("Model\t\tCompany\t\tPrice");
		System.out.println("========================================================");
		
		
			while(rs.next()) {
				
				
				String Model = rs.getString(2);
				String company = rs.getString(3);
				double price = rs.getDouble(4);
				
				
				System.out.println(model+"\t\t"+company+"\t\t"+price);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
   }
   
   public void getBikebyCompany(String company) {
	    
	   String query = "select * from bike_info where company=?";
		try {
			stmt=con.prepareStatement(query);
			
			stmt.setString(1,company);
			rs=stmt.executeQuery();
	
	

			System.out.println("Id\t\tModel\t\tCompany\t\tPrice");
			System.out.println("========================================================");
			
		
		
			while(rs.next()) {
				
				int id = rs.getInt(1);
				String model = rs.getString(2);
				String Company = rs.getString(3);
				double price = rs.getDouble(4);
				
				System.out.println(id+"\t\t"+model+"\t\t"+company+"\t\t"+price);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		
  }
		
   
   public void getallbikes() {
		
	   String query = "select * from bike_info";
		try {
			stmt=con.prepareStatement(query);
			
			rs=stmt.executeQuery();
	
	
		System.out.println("Id\t\tModel\t\tCompany\t\tPrice");
		System.out.println("========================================================");
		
		
			while(rs.next()) {
				int id = rs.getInt(1);
				String model = rs.getString(2);
				String company = rs.getString(3);
				double price = rs.getDouble(4);
				
				
				System.out.println(id+"\t\t"+model+"\t\t"+company+"\t\t"+price);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	   
   }
   
   
}
