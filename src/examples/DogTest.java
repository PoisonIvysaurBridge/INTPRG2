package examples;
public class DogTest
{
	public static void main (String[] args)
	{
		Dog a = new Dog ();
		Dog b = new Dog ();
		Dog c = new Dog ();
		
		a.setName ("Puppy");
		b.setName ("Doggie");
		c.setName ("Askal");
		a.bark ();
		b.bark ();
		
		if (a.getName ().equals ("Doggie"))
			a.bite (b);
		else
		{
			b.bite (a);
			c.bite (a);
		}
		
		a.bark ();
		b.bark ();
		c.bark ();
	}
}