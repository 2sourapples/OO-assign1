package assign2;

public class Book extends Item
{
	//only book has isbn and author
	private int isbn;
	private String author;
	
	
	public Book(String title, int sku, int quantity, double price, int isbn, String author)
	{
		this.title = title; 
		this.sku = sku;
		this.quantity = quantity;
		this.price = price;
		this.isbn = isbn;
		this.author = author;
		
		this.type = "Book";
		this.credit = 3.99;
		this.commission = 0.15;
	}
	
	public String toStringSpecific()
	   {
	      return String.format("\nTitle:   " + title + "\nSKU:   " + sku + "\nQuantity:   " + quantity
	                           + "\nPrice:  " + price + "\nISBN:   " + isbn + "\nAuthor:   " + author);
	   }
	
	
}