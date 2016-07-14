package movies;
import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

/**
 * A class for inventory
 * @author Anastasia Wright
 * @author Mark Gomez
 *
 */

public class Inventory 
{
	private ArrayList<Movie> list = new ArrayList<Movie>(0);
	
	public Inventory(){
		
	}

/**
 * Adds a movie to the ArrayList
 * checks to make sure quantity, price and title are valid --if not error message given
 * if the ArrayList is empty a message is given
 * makes sure the SKU number is unique
 * @param title
 * @param sku
 * @param quantity
 * @param price
 */
	public void addMovie (String title, int sku, int quantity, double price)
	{
		if (quantity < 0 || price < 0.0 || Objects.equals(title, ""))
			System.out.println("Error: Invalid input");
		else if (uniqueSku(sku))
		{
			Movie dvd = new Movie(title, sku, quantity, price);
			list.add(dvd);
			
			System.out.println("Successfully added movie!");
			if (list.isEmpty()){
				System.out.println("List is empty");
			}
		}
		else System.out.println("Error: The SKU entered already exists");
	}

	/**
	 * Removes a movie
	 * Makes sure the SKU number is in inventory before removal
	 * @param sku
	 */
	//searches with given SKU -- if found it is removed from inventory
	public void removeMovie (int sku)
	{
		int found = searchInventory(sku);
		if(found == -1)
			System.out.println("Error: No movie found with requested SKU");
		else
		{
			list.remove(found);
			System.out.println("Movie Removed!");
		}
	}

	/**
	 * Shows a movie based on the SKU number given
	 * if the sku number is found in the inventory, the movie info is displayed
	 * @param sku
	 */
	public void showMovie (int sku)
	{
		int found = searchInventory(sku);
		if(found == -1)
			System.out.println("Error: No item found");
		else System.out.println(list.get(found).toStringSpecific());
	}

	/**
	 * Shows the entire list of movies in the inventory
	 */
	public void showInventory()
	{
		if(list.isEmpty())
			System.out.println("Inventory is empty.");
		else
		{
			for(Movie m: list)
				System.out.println(m.toStringSpecific());
		}
	}

	/**
	 * Searches the inventory for a movie based on a SKU number
	 * @param sku
	 * @return <CODE>true</CODE> if the SKU is found
	 * @return <CODE>false</CODE> if the SKU is not found
	 */
	public int searchInventory (int sku)
	{
		for (int i = 0; i < list.size(); i++)
		{
			if (list.get(i).getSku() == sku)
			{
				return i;
			}
		}
		return -1; //-1 if not found
	}

	/**
	 * Checks uniqueness of the inputed SKU against SKUs stored in the inventory 
	 * @param sku
	 * @return <CODE>false</CODE> if the SKU is not unique
	 */
	public boolean uniqueSku (int sku)
	{
		int unique = searchInventory(sku);
		return unique == -1;
	}

	public void serial(){

		try{
			FileOutputStream fos= new FileOutputStream("inventoryFile");
			ObjectOutputStream oos= new ObjectOutputStream(fos);
			oos.writeObject(list);
			oos.close();
			fos.close();
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
	}

		public void deSerial(){
			try
			{
				FileInputStream fis = new FileInputStream("inventoryFile");
				ObjectInputStream ois = new ObjectInputStream(fis);
				list = (ArrayList<Movie>) ois.readObject();
				ois.close();
				fis.close();
			}catch(IOException ioe){
				ioe.printStackTrace();
				return;
			}catch(ClassNotFoundException c){
				System.out.println("Class not found");
				c.printStackTrace();
				return;
			}   }
	{

	{
	}
	}
}