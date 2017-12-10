public class Page
{
	private int number;
	private String content;
	
	public Page (int pageno)
	{
		number = pageno;
		content = "";
	}
	
	public String getContent ()
	{
		return content;
	}
	
	public int getPageNumber ()
	{
		return number;
	}
	
	public void setContent (String content)
	{
		this.content = content;
		
	}
}