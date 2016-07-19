package assign2;


public class Toy extends Item
{
	private double weight;
	
	public Toy(String title, int sku, int quantity, double price, double weight)
	{
		this.title = title;
		this.sku = sku;
		this.quantity = quantity;
		this.price = price;
		this.weight = weight;
		
		this.type = "Toy";
		//has to deal with weight. 16 oz in one pound
		this.credit = 4.49 + 0.50*(Math.ceil(weight/16.0));
		this.commission = 0.15;
	}
	
	public String toStringSpecific()
	   {
	      return String.format("\nTitle:   " + title + "\nSKU:   " + sku + "\nQuantity:   " + quantity
	                           + "\nPrice:  " + price + "\nWeight:  " + weight);
	   }
	
	
	
	
}