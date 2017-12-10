package intprg2;

import java.util.ArrayList;
public class Class
{
	private ArrayList<Student> students;
	
	public Class()
	{
		students = new ArrayList<> ();
	}
	
	public void addStudent(Student s)
	{
		students.add(s);
	}
	
	public Student removeStudent(String name)
	{
		int i;
		for(i = 0; i < students.size() && !students.get(i).getName().equalsIgnoreCase(name); i++);
		if (i == students.size())
			return null;
		return students.remove(i);
	}
	
	public Student getHighest()
	{
		
		if (students.size() <= 0)
			return null;
		int i;
		Student highest = students.get(0);
		for(i = 0; i< students.size(); i++)
		{
			if (students.get(i).getGrade() > highest.getGrade())
			{
				highest = students.get(i);
			}
		}
		return highest;
	}
	
	public double getAve()
	{
		if (students.size() <= 0)
			return -1;
		int i;
		double total = 0;
		for (i = 0; i < students.size(); i++)
		{
			total+=students.get(i).getGrade();
		}
		return total/(students.size());
		
	}
	
}