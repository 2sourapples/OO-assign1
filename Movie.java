package movies;
import java.io.Serializable;

 /**
  * Class Movie
  * @author Anastasia Wright
  * @author Mark Gomez
  *
  */
public class Movie implements Serializable
{
	/**
	 * 
	 * @param title
	 * @param sku
	 * @param quantity
	 * @param price 
	 * for each movie
	 */
   public Movie(String title, int sku, int quantity, double price)
   {
      this.Title = title;
      this.SKU = sku;
      this.Quantity = quantity;
      this.Price = price;
   }
   
   /**
    * puts all the info from a movie into one string for output
    * @return string of each title, price, quantity, and sku that each movie has
    */
   //so when you output it doesn't just show random info
   public String toStringSpecific()
   {
      return String.format("\nTitle:   " + Title + "\nSKU:   " + SKU + "\nQuantity:   " + Quantity
                           + "\nPrice:  " + Price);
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