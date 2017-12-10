package intprg2;

public class Page {
	private int pNumber;
	private String content;
	
	public Page(int n)
	{
		pNumber = n;
		content = "";
	}
	
	public int getpNumber() {
		return pNumber;
	}
	public String getContent() {
		return content;
	}
	
	public void write(String notes)
	{
		content += (notes +" ");
	}
	
	public void display()
	{
		System.out.println("************************************************\nPage "+pNumber+"\n");
		System.out.println(getContent());
		System.out.println("************************************************");
	}
}
