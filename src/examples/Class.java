import java.util.ArrayList;

public class Class
{
	private ArrayList<Student> students;
	
	public Class ()
	{
		students = new ArrayList<Student> ();
	}
	
	public void addStudent (Student s)
	{
		students.add (s);
	}
	
	public Student removeStudent (String name)
	{
		int j = 0;
		while (j < students.size () 
			   && !students.get (j).getName ().equals (name))
			j++;
		
		if (j == students.size ())
			return null;
			
		return students.remove (j);
	}
	
	public Student getStudentWithHighestGrade ()
	{
		int j;
		Student sHigh = null;
		
		if (students.size () > 0)
		{
			sHigh = students.get (0);
		
			for (j = 1; j < students.size (); j++)
				if (sHigh.getGrade () < students.get (j).getGrade ())
					sHigh = students.get (j);
		}
		return sHigh;	
	}
	
	public double getClassAverage ()
	{
		double sum = 0;
		double ave = -1;
		int j;
		
		for (j = 0; j < students.size (); j++)
			sum += students.get (j).getGrade ();
		
		if (students.size () > 0)
			ave = sum / students.size ();
		return ave;
			
	}
}











