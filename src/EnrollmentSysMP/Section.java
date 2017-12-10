package EnrollmentSysMP;
// Lim, Ivana
// Tan, Nigel
//package EnrollmentSysMP;
import java.util.ArrayList;

public class Section 
{
    private String name, 
    			   faculty, 
    			   schedule;
    private int    startTime, 
    			   endTime, 
    			   capacity;
    private Course course;
    private ArrayList<Student> students;
    
    // constructor
    public Section(Course course, String name, String faculty, String schedule, 
            int startTime, int endTime, int nCapacity)
    {
        students = new ArrayList<>();
        this.name = name; // should checking be included?
        this.faculty = faculty;
        this.schedule = schedule;
        this.startTime = startTime;
        this.endTime = endTime;
        capacity = nCapacity;
        this.course = course;
    }
    
    // getters
    public String getName()
    {
        return name;
    }
    
    public String getFaculty()
    {
        return faculty;
    }
    
    public String getSchedule()
    {
        return schedule;
    }
    
    public int getStartTime()
    {
        return startTime;
    }
    
    public int getEndTime()
    {
        return endTime;
    }
   
    public int getCapacity()
    {
    	return capacity;
    }
    
    public Course getCourse()
    {
    	return course;
    }
    
    // other methods
    public void addStudent(Student student)
    {
    	boolean check = true;
    	if (students.size()== 0)
        {
        	students.add(student);
        }
        else
        {	
        	int i;
            for(i = 0; i < students.size(); i++)
            {
            	if (student.getID().equals(students.get(i).getID()))
            		check = false;
            }
        	if(check)
        	{
        		students.add(student);
        	}
        		
        	else
        		System.out.println("student is already enlisted in this section.");
        }
    	
    }
    
    public Student removeStudent(Student student)
    {
        int i;
        for (i = 0; i < students.size(); i++)
        {
        	if (students.get(i).getID().equals(student.getID()))
        	{
        		return students.get(i);
        	}
        }
        return null;
    }
    
    public ArrayList<Student> getStudents()
    {
        return students;
    }
    
    public boolean isConflict(Section s)
    {/*
    	boolean check = false;
    	if (!this.getSchedule().equals(s.getSchedule())
    		&& (this.getStartTime() < s.getStartTime() && this.getEndTime() < s.getStartTime()
    			|| this.getStartTime() > s.getStartTime() && this.getStartTime() > s.getEndTime()))
    		check = true;
    	return check;
    	*/
    	boolean check = false;
    	if(this.getSchedule().equals(s.getSchedule()))
    	{
    		if ((s.getStartTime() <= this.getEndTime() && s.getStartTime() >= this.getStartTime()
    	    		|| s.getEndTime() >= this.getStartTime() && s.getEndTime() <= this.getEndTime()))
    	    		check = true;
    	}
    	
    	return check;
    	
    }
    
    public void viewEnrolledStudents()
    {
    	System.out.println("\nCOURSE CODE: " + this.getCourse().getCode());
    	System.out.println("SECTION: " + this.getName());
    	System.out.println("List of Enrolled Students:");
    	int k;
		for(k = 0; k < students.size(); k++)
		{
			System.out.println(students.get(k).getID());
		}
		System.out.println("List of students enrolled: "+students.size());
		System.out.println("Total number of slots: "+ this.getCapacity());
		System.out.println("number of slots remaining: "+(this.getCapacity() - students.size()));
    }
}
