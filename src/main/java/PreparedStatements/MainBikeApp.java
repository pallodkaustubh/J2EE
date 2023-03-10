package PreparedStatements;

import java.util.Scanner;

public class MainBikeApp {

	public static void main(String[] args) {
		BikeOperations b1 = new BikeOperations();
		
		Scanner sc1 = new Scanner(System.in);
		
		System.out.println("Enter Your Choice");
		System.out.println("1:ADD Bike ");
		System.out.println("2:Get bike by Model ");
		System.out.println("3:Get bike by Company ");
		System.out.println("4:Get All Bikes ");
		
		int choice = sc1.nextInt();
		
		if(choice == 1)
		{	
			
	    	
			System.out.println("Enter Bike model");
	    	String model = sc1.next();
	    	
	    	System.out.println("Enter Bike Company");
	    	String company = sc1.next();
	    	
	    	System.out.println("Enter Bike Price");
	    	double price = sc1.nextDouble();
	    	
	    	
	    	b1.addBike(model,company, price);
	    	
		}
		
		else if(choice == 2)
		{
			System.out.println("Enter Bike Model");
	    	String model = sc1.next();
	    	b1.getBikebyModel(model);
		}
		
		else if(choice == 3)
		{
			System.out.println("Enter Bike Company");
	    	String company=sc1.next();
	         b1.getBikebyCompany(company);
		}
		
		else if(choice == 4)
		{
			b1.getallbikes();
		}
		

	}

}
