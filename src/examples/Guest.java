public class Guest
{
	private String name;
	private String nationality;
	
	public Guest (String hisname, String hisnationality)
	{
		name = hisname;
		nationality = hisnationality;
	}
	
	public String getName ()
	{
		return name;
	}
	
	public String getNationality ()
	{
		return nationality;
	}

}