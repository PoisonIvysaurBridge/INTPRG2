package intprg2;

public class Boy
{
	private int sugarLvl;
	private String strName;
	
	// Constructors
	public Boy(String name)
	{
		strName = name;
		sugarLvl = 50;
	}
	// accessors
	public String getName()
	{
		return strName;
	}
	
	public int getSugarLevel()
	{
		return sugarLvl;
	}
	
	// other methods
	public void eatFruit(Fruit f)
	{
		sugarLvl = sugarLvl + f.getSugarLevel();
	}
	
	public void display()
	{
		System.out.println("Name of Boy: "+strName);
		System.out.println("Sugar Level of Boy: "+sugarLvl);
	}
}