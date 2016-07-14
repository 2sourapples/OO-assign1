package movies;
//-----You don't need these------
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class for the driver
 * @author Mark Gomez
 * @author Anastasia Wright
 *
 */

public class main {
	public static void main(String[] args){
		boolean go = true;
		
		String title;
		
		int sku;
		int total;
		
		double price;
		
		Scanner in = new Scanner(System.in);
		
		Inventory manager = new Inventory();
		manager.deSerial();

		do{
			System.out.println("1. Add movie to inventory using Title, SKU, and Total inventory");
			System.out.println("2. Remove movie from inventory using SKU ");
			System.out.println("3. Find movie using SKU or Title");
			System.out.println("4. List all movies with  Title, SKU, and Inventory number ");
			System.out.println("5. Quit");
			int num = in.nextInt();


			switch(num){
			case 1: System.out.println("Please enter SKU: ");
					sku = in.nextInt();
					
					System.out.println("Please enter Quantity: ");
					total = in.nextInt();
					
					System.out.println("Please enter Price: ");
					price = in.nextDouble();
					
					in.nextLine();
					
					System.out.println("Please enter Title: ");
					title = in.nextLine();
					
					manager.addMovie(title, sku, total, price);
					break;

			case 2: System.out.println("Please enter sku");
					sku = in.nextInt();
					manager.removeMovie(sku);
					break;

			case 3: System.out.println("Please enter SKU");
					sku = in.nextInt();
					manager.showMovie(sku);
					break;

			case 4: System.out.println("Printing all movies");
					manager.showInventory();
					break;

			case 5: go = false;
			manager.serial();
			System.out.println("Thank you, come again!");
			break;
			}

		}while(go);
	}
}