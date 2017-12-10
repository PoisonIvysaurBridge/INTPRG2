package examples;
public class IpisTest
{
	public static void main (String[] args)
	{
		Ipis one = new Ipis ();
		Ipis two = new Ipis ();
		
		Ipis[] insects;
		
		insects = new Ipis[3];
	
		
		insects[0] = new Ipis ();
		insects[0].leaveAMark ();
			
		one.setName ("caca");
		one.leaveAMark ();
		one.evolve ();
		one.leaveAMark ();
		
		insects[1] = one;
		insects[1] = null;
		
		two.setName ("newIpis");
		two.leaveAMark ();
		
		if (one.canFly ())
		{
			two.smashed (one);
		}
		else
		{
			one.smashed (two);
		}
		one.leaveAMark ();
		two.leaveAMark ();
	}
}