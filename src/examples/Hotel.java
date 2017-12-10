import java.util.*;

public class Hotel
{
	private String name;
	private ArrayList<Room> rooms;
	
	public Hotel (String n, int r)
	{
		name = n;
		rooms = new ArrayList <Room> ();
		
		int j;
		for (j = 0; j < r; j++)
			rooms.add (new Room (j+1));
	}
	
	public boolean acceptGuest (int roomno, Guest g)
	{
		if (roomno > 0 && roomno <= rooms.size ())
		{
			return rooms.get (roomno - 1).addGuest (g);
		}
		return false;
	}
	
	public void displayGuestsOfRoom (int roomno)
	{
		ArrayList<Guest> guests;
		int j;
		
		System.out.println ("Guests of Room " + roomno);
		if (roomno > 0 && roomno <= rooms.size ())
		{
			guests = rooms.get (roomno - 1).getGuests ();
			for (j = 0; j < guests.size (); j++)
				System.out.println ("Guest " + (j + 1) + ":  "
									+ guests.get(j).getName () 
									+ "  ["
									+ guests.get(j).getNationality ()
									+ "]");
									
		}
		else
			System.out.println ("Error");
	}
}