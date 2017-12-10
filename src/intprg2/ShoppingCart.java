package intprg2;

import java.util.ArrayList;
public class ShoppingCart
{
	private ArrayList <Product> products = new ArrayList<> ();
	
	public void add (Product p)
	{
		products.add(p);
	}
	public Product remove (String name)
	{
		int i;
		for(i = 0; i < products.size() && !products.get(i).getName().equals(name); i++);
		if (i == products.size())
			return null;
		return products.remove(i);
	}
	public void display()
	{
		int i;
		for(i = 0; i < products.size(); i++)
		{
			System.out.println("Name: "+products.get(i).getName());
		}
	}
	public static void main(String args[]) {
    	Product one = new Product("Guyabano", 29);
    	Product two = new Product("papaya", 67);
    	ShoppingCart cart = new ShoppingCart();
    	cart.add(one);
    	cart.add(two);
    	cart.display();
    	cart.remove(one.getName());
    	cart.display();
    }
}