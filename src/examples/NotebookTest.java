package examples;
public class NotebookTest
{
	public static void main (String[] args)
	{
		Notebook nbk = new Notebook (5);
		int j;
		
		nbk.nextPage ();
		/* display nbk */
		nbk.display ();
		
		nbk.writeOnPage ("hello");

		nbk.prevPage ();
		nbk.writeOnPage ("bye");
		nbk.nextPage ();
		nbk.nextPage ();
		nbk.nextPage ();
		nbk.writeOnPage ("hello again");
		/* display nbk */
		nbk.display ();
	}
}