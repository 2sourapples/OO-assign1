package assign2;
import java.io.Serializable;

/**
 * Class Movie
 * @author Anastasia Wright
 * @author Mark Gomez
 *
 */
public class Movie extends Item implements Serializable
{
	int upc; //added for assign2
	
   /**
    *
    * @param title
    * @param sku
    * @param quantity
    * @param price
    * for each movie
    */
   public Movie(String title, int sku, int quantity, double price, int upc)
   {
      this.title = title;
      this.sku = sku;
      this.quantity = quantity;
      this.price = price;
      this.upc = upc;
      
      this.type = "Movie: ";
      this.credit = 2.98;
      this.commission = 0.12;
   }
   
   /**
    * puts all the info from a movie into one string for output
    * @return string of each title, price, quantity, and sku that each movie has
    */
   //so when you output it doesn't just show random info
   public String toStringSpecific()
   {
      return String.format("\nTitle:   " + Title + "\nSKU:   " + SKU + "\nQuantity:   " + Quantity
                           + "\nPrice:  " + Price + "\nUPC:   " + upc);
   }
   
   /**
    * returns the SKU number of the desired movie
    * @return the SKU number of the wanted movie
    */
   public int getSku(){
      return SKU;
   }
   
   String Title;
   int SKU;
   int Quantity;
   double Price;
}