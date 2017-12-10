public class Guest
{
	private String name,
				   nationality;
				   
	// constuctor
	public Guest(String strName, String natl)
	{
		name = strName;
		nationality = natl;
	}
	
	// getters
	public String getName()
	{
		return name;
	}
	
	public String getNatl()
	{
		return nationality;
	}
}