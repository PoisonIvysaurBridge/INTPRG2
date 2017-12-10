package intprg2;
public class Fruit
{
	private int sugarLvl;
	private String strName;
	
	// Constructors
	public Fruit(String name, int level)
	{
		strName = name;
		sugarLvl = level;
	}
	
	// Accessors
	
	// Mutators
	public String getName()
	{
		return strName;
	}
	
	public int getSugarLevel()
	{
		return sugarLvl;
	}
	
	// Other Methods
	public void display()
	{
		System.out.println("Name of Fruit: "+strName);
		System.out.println("Sugar Level of Fruit: "+sugarLvl);
	}
}