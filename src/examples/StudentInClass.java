package examples;

public class StudentInClass
{
	private String name;
	private double grade;
	
	public StudentInClass (String n, double g)
	{
		name = n;
		grade = g;
	}
	
	public String getName ()
	{
		return name;
	}
	
	public double getGrade ()
	{
		return grade;
	}
}