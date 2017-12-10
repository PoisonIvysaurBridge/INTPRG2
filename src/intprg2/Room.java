public class Room
{
	private int rmNo;
	private ArrayList<Guest> guests;
	
	// constructor
	public Room(int rm, int size)	// max size is 2
	{
		rmNo = rm;
		guests = new Guest[size];
	}
	
	// getters
	public int getRmNo()
	{
		return rmNo;
	}
	
	// other methods
	public boolean addGuest(Guest g)
	{
		if(guest.size() < 2)
		{
			guests.add(g);
			return true;
		}
		return false;
	}
	
	public ArrayList<Guest> getGuests()
	{
		return guests;
	}
	
	public void display()
	{
		
	}
}