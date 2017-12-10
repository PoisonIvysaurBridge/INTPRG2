package examples;
public class Ipis
{
	private String name;
	private String color = "transparent";
	private double length;
	private int health = 5;
	private boolean bFly = false;		// can fly or not
	
	
	public String getName ()
	{
		return name;
	}
	
	public void setName (String newname)
	{
		if (name == null)
			name = newname;
	}
	
	public boolean canFly ()
	{
		return bFly;
	}
	
	public boolean isAlive ()
	{
		return health >= 1;
	}
	
	public void leaveAMark ()
	{
		System.out.println (name + "(" + health + ") was here!!!");
	}
	
	public void fly ()
	{
		if (bFly)
			System.out.println ("Up up and away!");
		else
			System.out.println ("...");
	}
	
	public void smashed (Ipis anotherIpis)
	{
		health--;
		anotherIpis.health++;
	}
	
	public void eat ()
	{
		health++;
	}
	
	public void evolve ()
	{
		if (name != null)
			name = name.substring (name.length() - 1) + name.substring (0, name.length ()-1);
		bFly = !bFly;
	}
	
}