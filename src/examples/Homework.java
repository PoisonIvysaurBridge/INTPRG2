package examples;


public class Homework {
	private String title;
	private Date deadline;
	
	public Homework(String strTitle, Date nDead)
	{
		title = strTitle;
		deadline = nDead;
	}
	public String getTItle()
	{
		return title;
	}
	public Date getDeadline()
	{
		return deadline;
	}
}
