package assign2;
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

		String title = "";
		String please = "Please enter the ";

		int sku = 0;
		int total = 0;

		double price = 0;

		Scanner in = new Scanner(System.in);

		Inventory manager = new Inventory();
		manager.deSerial();

		do{
			System.out.println("1. Add item to inventory, you will "
					                                + "select item type later");
			System.out.println("2. Remove product from inventory using SKU ");
			System.out.println("3. Find product using SKU");
			System.out.println("4. List all items sorted by sku ");
			System.out.println("5. Quit");
			int num = in.nextInt();


			switch(num){
			case 1: System.out.println(please + "product type: M, B, T");
			char choice = in.next().charAt(0);
			int special;
			switch(choice){
			case 'm':
			case 'M': System.out.println(please + "upc: "); 
					  special = in.nextInt();	
					  //getStuff(sku, price,title, total, in);
						System.out.println("Please enter SKU: ");
						sku = in.nextInt();

						System.out.println("Please enter Quantity: ");
						total = in.nextInt();

						System.out.println("Please enter Price: ");
						price = in.nextDouble();

						in.nextLine();

						System.out.println("Please enter Title: ");
						title = in.nextLine();
					  manager.addMovie(title, sku, total, price, special);
					  break;
			case 'b':
			case 'B': System.out.println(please + "isbn: "); 
					  special = in.nextInt();
					  in.nextLine();
					  System.out.println("Enter the author of the book");
					  String author = in.nextLine();
					  //getStuff(sku, price,title, total, in);
						System.out.println("Please enter SKU: ");
						sku = in.nextInt();

						System.out.println("Please enter Quantity: ");
						total = in.nextInt();

						System.out.println("Please enter Price: ");
						price = in.nextDouble();

						in.nextLine();

						System.out.println("Please enter Title: ");
						title = in.nextLine();
					  
					  manager.addBook(title, sku, total, price, special, author);
					  break;
			case 't':
			case 'T': System.out.println(please + "weight: "); 
		     		   special = in.nextInt(); 
					   //getStuff(sku, price,title, total, in);
					   manager.addToy(title, sku, total, price, special);
					   
						System.out.println("Please enter SKU: ");
						sku = in.nextInt();

						System.out.println("Please enter Quantity: ");
						total = in.nextInt();

						System.out.println("Please enter Price: ");
						price = in.nextDouble();

						in.nextLine();

						System.out.println("Please enter Title: ");
						title = in.nextLine();
					   break;
					   
			default: System.out.println("Sorry, incorrect input");
					 break;

			}
			
			//getStuff(sku, price,title, total, in);
			

			//manager.addMovie(title, sku, total, price);
			break;

			case 2: System.out.println("Please enter sku");
			sku = in.nextInt();
			manager.removeMovie(sku);
			break;

			case 3: System.out.println("Please enter SKU");
			sku = in.nextInt();
			manager.showItem(sku);
			break;

			case 4: System.out.println("Printing all movies");
			manager.showInventory();
			break;

			case 5: go = false;
			manager.serial();
			System.out.println("Thank you, come again!");
			break;
			
			//case 5: 
			
			default: System.out.println("Sorry, incorrect input detected");
			}

		}while(go);

		in.close();
	}
	
/*static void getStuff(int sku, double price, String title, int total, 
																Scanner in ){
		System.out.println("Please enter SKU: ");
		sku = in.nextInt();

		System.out.println("Please enter Quantity: ");
		total = in.nextInt();

		System.out.println("Please enter Price: ");
		price = in.nextDouble();

		in.nextLine();

		System.out.println("Please enter Title: ");
		title = in.nextLine();
	}*/
}