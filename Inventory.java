package assign2;

import java.io.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Comparator;
import java.util.Collections;

/**
 * A class for inventory
 * @author Anastasia Wright
 * @author Mark Gomez
 *
 */

public class Inventory implements Serializable
{
   private ArrayList<Item> list = new ArrayList<>(0);
   
   //public Inventory(){    
   //}
   
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
   public void addMovie (String title, int sku, int quantity, double price, int upc)
   {
      if (quantity < 0 || price < 0.0 || Objects.equals(title, ""))
         System.out.println("Error: Invalid input");
      else if (upc < 0)
    	  System.out.println("Error: Invalid input with UPC");
      else if (uniqueSku(sku))
      {
         Movie dvd = new Movie(title, sku, quantity, price, upc);
         list.add(dvd);
         
         System.out.println("Successfully added movie!");
         if (list.isEmpty()){
            System.out.println("List is empty");
         }
      }
      else System.out.println("Error: The SKU entered already exists");
   }
   
   //////NEEDS COMMENTS
   public void addBook (String title, int sku, int quantity, double price, int isbn, String author)
   {
	   if(quantity < 0 || price < 0.0 || Objects.equals(title, "") || isbn < 0)
		   System.out.println("Book Input not valid" + quantity + price + title + isbn);
	   else if (uniqueSku(sku))
	   {
		   Book book = new Book(title, sku, quantity, price, isbn, author);
		   list.add(book);
		   System.out.println("Book added!");
	   }
	   else System.out.println("The SKU entered already exists");
   }
   
   //ADD COMMENTS
   public void addToy(String title, int sku, int quantity, double price, double weight)
   {
	    if(quantity < 0 || price < 0.0 || weight <= 0.0 || Objects.equals(title, ""))
   			System.out.println("Invalid input");
	    else if(uniqueSku(sku))
	    {
	    	Toy toy = new Toy(title, sku, quantity, price, weight);
	    	list.add(toy);
	    	System.out.println("Toy added!");
	    }
	    else System.out.println("The SKU entered already exists");
   
   }
   
   
   
   /**
    * Removes an item
    * Makes sure the SKU number is in inventory before removal
    * @param sku
    */
   //searches with given SKU -- if found it is removed from inventory
   public void removeMovie (int sku)
   {
      int found = searchInventory(sku);
      if(found == -1)
         System.out.println("Error: No item found with requested SKU");
      else
      {
         list.remove(found);
         System.out.println("Item Removed!");
      }
   }
   
   /**
    * Shows an item based on the SKU number given
    * if the sku number is found in the inventory, the item info is displayed
    * @param sku
    */
   public void showItem (int sku)
   {
      int found = searchInventory(sku);
      if(found == -1)
         System.out.println("Error: No item found");
      else System.out.println(list.get(found).toStringSpecific());
   }
   
   /**
    * Shows the entire list of items in the inventory
    * either says there is no items in inventory or 
    * displays all items by line
    */
   public void showInventory()
   {
	  Collections.sort(list, new Comparator<Item>()
	  {
		  public int compare(Item i1, Item i2)
		  {
			  return i1.getSku() - i2.getSku();
		  }
	  });
	  
      if(list.isEmpty())
         System.out.println("Inventory is empty.");
      else
      {
         for(Item m: list)
            System.out.println(m.toStringGeneric());
      }
      System.out.println();
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
   
   public void transaction(int sku, int quantitySold, double shipping)
   {
	   int i = searchInventory(sku), quantityAvail = 0;
	   double price = 0, commission = 0, ship = 0, profit = 0;
	   if(i == 1){
		   for(i = 0; i < list.size(); i++){
			   if(list.get(i).getSku() == sku ){
				   quantityAvail = list.get(i).getQuantity();
				   price = list.get(i).totalPrice(quantitySold);
				   commission = list.get(i).findTotalCommission(quantitySold);
				   ship = list.get(i).totalCredit(quantitySold);
				   profit = price + ship - (commission + shipping); 
				   break;
			   }
			   
		   }
		   
		   if(quantityAvail < quantitySold)
		   {
			   System.out.println("Quantity requested exceeds quantity available");
		   }
		   else 
		   {
			   System.out.println("Total Price: " + price);
			   System.out.println("Commission: " + commission);
			   System.out.println("Shipping: " + ship);
			   System.out.println("Profit: " + profit);  
		   }  
	   }else
	   {
		   System.out.println("Item with sku " + sku + "not found.");
	   }
	   
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
         list = (ArrayList<Item>) ois.readObject();
         ois.close();
         fis.close();
      }catch(IOException ioe){
         list = new ArrayList<Item>(0);
         return;
      }catch(ClassNotFoundException c){
         System.out.println("Class not found");
         c.printStackTrace();
         return;
      }
   }
}