package assign2;

//decimal needed
import java.text.DecimalFormat;

import java.io.Serializable;

abstract class Item implements Serializable 
{
	int quantity;
	int sku;
	double price, credit, commission;
	String title, type;
	
	//sets for a given item
	public void setQuantity(int qty)
	{
		this.quantity = qty;
	}
	
	//gets quantity
	public int getQuantity()
	{
	   return this.quantity;	
	}
	
	public int getSku()
	{
		return this.sku;
	}
	
	public double totalPrice(int itemsSold)
	{
		return (this.price * itemsSold);
	}
	
	
	public double totalCredit(int itemsSold)
	{
		return (this.credit * itemsSold);
	}
	
	
	public double findTotalCommission(int itemsSold)
	{
		return this.commission * this.price * itemsSold;
	}
	
	
	public String toStringGeneric() {
        DecimalFormat money = new DecimalFormat("$0.00");
        return String.format("%-7s %-7s %-7s %-7s %s", this.type,
                this.sku, this.quantity, money.format(this.price),
                this.title);
    }
	
	//this lets each item show their unique feature (ie. books has author & isbn)
	abstract public String toStringSpecific();
	
}