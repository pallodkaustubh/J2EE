package ProductOperations;

import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) {
		ProductSimulator ps = new ProductSimulator();
		
		Scanner sc1 = new Scanner(System.in);
		System.out.println("Select Your Choice");
		System.out.println("1:Add Product");
		System.out.println("2:Delete Product");
		System.out.println("3:Display Products");
		
		int choice = sc1.nextInt();
		if(choice==1)
		{
			System.out.println("Enter Prod id");
			int id = sc1.nextInt();
			
			System.out.println("Enter  Prod name");
			String name = sc1.next();
			
			System.out.println("Enter prod price");
			double price = sc1.nextDouble();
			
			ps.addProd(id, name, price);
		}
		else if(choice==2) {
			System.out.println("Enter id of Product to be Deleted");
			int id = sc1.nextInt();
			ps.deleteProd(id);
		}
		else if(choice==3) {
			ps.displayProd();
			
		}

	}

}
