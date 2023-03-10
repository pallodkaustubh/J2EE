package producttest;

import java.util.Scanner;

public class MainApp1 {
	public static void main(String[] args) {
		ProductDemo pd = new ProductDemo();
		
		Scanner sc1 = new Scanner(System.in);
		System.out.println("Enter Your Choice");
		System.out.println("1:Display Product With Max Price\n2:Display Product With Min Price");
		int choice = sc1.nextInt();
		
		if(choice==1)
		{
			pd.maxPrice();
			
		}
		else if (choice==2) {
			pd.minPrice();
		}
	}
}
