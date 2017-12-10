// Ivana Lim #6 S15A

public class Fruit
{
	private String name;
	private double calories;
	
	// constructor
	public Fruit(String name, double calories)
	{
		this.name = name;
		this.calories = calories;
	}
	
	// getters
	public String getName()
	{
		return this.name;
	}
	
	// setters
	public double getCaloriesPerGram()
	{
		return this.calories;
	}
}