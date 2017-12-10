import java.util.*;

public class Notebook
{
	private ArrayList<Page> pages;
	private int curPage;
	
	public Notebook (int noOfPages)
	{
		int j;
		Page p;
		
		pages = new ArrayList<Page> ();
		for (j = 0; j < noOfPages; j++)
		{
			p = new Page (j+1);
			pages.add (p);
		}
		
		curPage = 1;
	}
	
	public Page getCurrentPage ()
	{
		return pages.get (curPage - 1);
	}
	
	public void writeOnPage (String content)	
	{
		Page p = getCurrentPage ();
		p.setContent (content);
	}
	
	public String getPageContent ()
	{
		Page p = getCurrentPage ();
		return p.getContent ();
	}
	
	public void nextPage ()
	{
		if (curPage < pages.size ())
			curPage++;
	}

	public void prevPage ()
	{
		if (curPage > 1)
			curPage--;
	}

	public boolean isLastPage ()
	{
		return curPage == pages.size ();
	}
	
	public void display ()
	{
		int j;
		int temp = curPage;
		curPage = 0;
		while (!isLastPage ())
		{	
			nextPage ();
			System.out.println (getCurrentPage ().getPageNumber () + ":\t" + getPageContent ());
		}
		curPage = temp;
	}	
}