package Notebook;

// Ivana Lim #6 S15A

import java.text.*;
import java.io.*;

public class Page
{
	private String content;
	private int number;
	private String title;
	
	/**
	 * Creates a Page object with the assigned page number.  The title of the page 
	 * and the content of this page is initially null.
	 *
	 * @param  pagenumber  the page number to be assigned to this instance
	 */
	public Page (int pagenumber)
	{
		this.number = pagenumber;
		content = null;
		title = null;
	}
	
	/**
	 * Sets the content on this Page instance
	 *
	 * @param  newcontent  content of the page
	 */
	public void setContent (String newcontent)
	{
		content = newcontent;
	}
	
	/**
	 * Sets the title of this Page instance
	 *
	 * @param  newtitle  title of the page
	 */
	public void setTitle (String newtitle)
	{
		title = newtitle;
	}
	
	/**
	 * Returns the content of this page.
	 *
	 * @return      the content
	 */
	public String getContent ()
	{
		return content;
	}
	
	/**
	 * Returns the title of this page.
	 *
	 * @return      the title
	 */
	public String getTitle ()
	{
		return title;
	}
	
	/**
	 * Returns the page number assigned to this Page instance. 
	 *
	 * @return      the page number
	 */
	public int getPageNumber ()
	{
		return number;
	}
	/**
	 * Returns the page number and title of this page.
	 *
	 * @return      formatted String with the title and content of this page
	 */
	public String toString ()
	{
		String temp = "no title";
		
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMinimumIntegerDigits (3);
		
		if (title != null)
			temp = title;
		return "Page " + number + " - " + temp;
	}
	
	/**
	 * Saves the content of this page into the file.
	 *
	 * @param f	file object to write
	 */
	public void saveToFile (File f)
	{
		
		BufferedWriter bw;
		try
		{
			bw = new BufferedWriter(new FileWriter(f));
			bw.write("Page Title: "+ this.getTitle());
			bw.newLine();
			bw.newLine();
			bw.write("Page Content: " + this.getContent());
			bw.newLine();
			
			bw.flush();
			bw.close();
		}
		catch(Exception e)
		{
			System.out.println("Notebook class: saveToFile() "+e);
		}
	}
}