import java.util.*;

public class Room
{
	private int number;
	private ArrayList<Guest> guests;
	
	public Room (int n)
	{
		number = n;
		guests = new ArrayList<Guest> ();
	}
	
	public boolean addGuest (Guest g)
	{
		if (guests.size () < 2)
		{
			guests.add (g);
			return true;
		}
		return false;
	}
	
	public ArrayList<Guest> getGuests ()
	{
		return guests;
	}
}