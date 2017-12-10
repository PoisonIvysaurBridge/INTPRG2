package Notebook;

// Ivana Lim #6 S15A

import java.util.*;
import java.io.*;

public class Notebook
{
	private ArrayList<Page> pages;
	private int curPage;
	//File f = new File("Z:\\FE\\Files.txt");
	
	/**
	 * Creates a Notebook object with the specified number of pages.  Each 
	 * page in the notebook is intially empty and page numbers are numbered 
	 * from 1, 2, 3,..., numberofpages.  The current page is initialize to 
	 * page 1.
	 *
	 * @param  numberofpages  the number of Page objects for this notebook
	 * @see         Page
	 */
	public Notebook (int numberofpages)
	{
		int j;
		
		pages = new ArrayList<Page> ();
		for (j = 0; j < numberofpages; j++)
			pages.add (new Page(j + 1));
		
		curPage = 0;
	}
	
	/**
	 * Returns the number of the current page of the notebook
	 *
	 * @return      number of the current page
	 */
	public int getPageNumber ()
	{
		return curPage;
	}
	
	
	/**
	 * Returns the content of the current page of the notebook
	 *
	 * @return      content of the current page
	 */
	public String getPageContent ()
	{
		return pages.get (curPage).getContent ();
	}
	
	/** Returns the number of pages in the notebook
	 *
	 * @return		number of pages
	 */
	public int getCapacity ()
	{
		return pages.size ();
	}

	/** Returns the title of the current page in the notebook
	 *
	 * @return		title of page
	 */
	public String getPageTitle ()
	{
		return pages.get (curPage).getTitle ();
	}

	/**
	 * Sets the content of the current page to the specified content
	 *
	 * @param  newcontent  the specified content for the current page
	 */
	public void setPageContent (String newcontent)
	{
		pages.get (curPage).setContent (newcontent);
	}
	
	/**
	 * Sets the title of the current page to the specified content
	 *
	 * @param  newcontent  the specified title for the current page
	 */
	public void setPageTitle (String title)
	{
		pages.get (curPage).setTitle (title);
	}
	

	/**
	 * Sets the page number to the specified page
	 *
	 * @param  pagenumber  the specified page
	 */
	public void setPageNumber (int pagenumber)
	{
		curPage = pagenumber;
	}
	
	
	/**
	 * Saves the current page title and content in a file
	 *
	 * @param  f	file object to write
	 */
	public void saveToFile (File f)
	{
	//	int i;
	//	for(i = 0; i < pages.size(); i++)
	//	{
			pages.get(curPage).saveToFile(f);
	//	}
	}
	 
	/**
	 * Moves to the next page of the notebook
	 *
	 */
	public void nextPage ()
	{
		if (curPage < pages.size ())
			curPage++;
	}
	
	/**
	 * Moves the page of the notebook to the previous page.
	 */
	public void previousPage ()
	{
		if (curPage > 0)
			curPage--;
	}
	
	/**
	 * Returns a vector object containing the pages of the notebook.
	 *
	 * @return      pages of the notebook
	 */
	public Vector<Page> getPages ()
	{
		return new Vector (pages);
	}
	
}