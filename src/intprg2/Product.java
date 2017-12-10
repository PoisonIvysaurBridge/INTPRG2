package intprg2;

public class Product
{
	private String strName;
	private double dPrice;
	
	// constuctors
	public Product(String name, double price)
	{
		strName = name;
		dPrice = price;
	}
	
	// getters
	public String getName()
	{
		return strName;
	}
	
	public double getPrice()
	{
		return dPrice;
	}
	
}