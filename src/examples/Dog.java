package examples;
public class Dog
{
	private String name;
	private double weight;
	private int health = 10;
	private boolean alive = true;
	
	public String getName ()
	{
		return name;
	}
	
	public boolean setName (String newname)
	{
		if (name == null)
		{
			name = newname;
			return true;
		}

		return false;
	}
	
	public double getWeight ()
	{
		return weight;
	}
	
	public void setWeight (double newwt)
	{
	}
	
	public void bark ()
	{
		System.out.println ("My name is " + name + " (" + health + ")");
	}
	
	public void bite (Dog opponent)
	{
		opponent.health--;
		health++;
	}
}