package intprg2;

public class Seat 
{
	private int seatNo;
	private boolean isAvailable;
	
	public Seat(int seatNo)
	{
		this.seatNo = seatNo;
		isAvailable = true;
	}
	
	public void setAvailability(boolean b)
	{
		isAvailable = b;
	}
	
}
