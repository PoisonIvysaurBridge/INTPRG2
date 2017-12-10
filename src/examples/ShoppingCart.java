import java.util.*;
public class ShoppingCart
{
	private ArrayList<Product> products;
	
	public ShoppingCart ()
	{
		products = new ArrayList<Product> ();
	}
	
	public void add (Product p)
	{
		products.add (p);
	}
	
	public void add (String n, double pr)
	{
		Product p = new Product (n, pr);
		products.add (p);
	}
	
	public void remove (String n)
	{
		int j;
		Product p;
		
		j = 0;
		while (j < products.size () 
			   && !products.get (j).getName ().equals (n))
			j++;
	
		
		if (j < products.size ())
			p = products.remove (j);
	}
	
	public void display ()
	{
		int j;
		
		for (j = 0; j < products.size (); j++)
			products.get (j).display ();
	}
}









