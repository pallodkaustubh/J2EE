package producttest;

import java.util.Scanner;

public class MainLoginApp {

	public static void main(String[] args) {
		
			{
				login l1 = new login();
				signup sg = new signup();
				
				Scanner sc1 = new Scanner(System.in);
				System.out.println("1:LOGIN\n2:SIGN UP");
				
				int choice = sc1.nextInt();
				
				if(choice==1)
				{
					l1.Login();
					l1.Operations();
					
				}
				
				if(choice==2) 
				{
					sg.Signup();
					
				}
			}
	}
}
			
