package IcoMP;
import java.util.*;
public class Section
{
    private Course course;
    private String name;
    private String faculty;
    private int capacity;
    private String day;
    private int startTime;
    private int endTime;
    private ArrayList <StudentAccount> students;
    
    public Section (Course newCourse, String newName, String newFaculty, int newCapacity, String newDay, int newStartTime, int newEndTime)
    {
        course = newCourse;
        name = newName;
        faculty = newFaculty;
        capacity = newCapacity;
        day = newDay;
        startTime = newStartTime;
        endTime = newEndTime;
        students = new ArrayList <> ();
    }
    
    public void addStudent (StudentAccount newStudent)
    {
        int Ctr;
        for (Ctr = 0; Ctr < students.size() && students.get(Ctr) != newStudent; Ctr ++);
        if (Ctr == students.size())
            students.add(newStudent);
        else
            System.out.println("Student is already listed in this section!");
    }
    
    public Course getCourse ()
    {
        return course;
    }
    
    public String getName ()
    {
        return name;
    }
    
    public String getFaculty ()
    {
        return faculty;
    }
    
    public int getCapacity ()
    {
        return capacity;
    }
    
    public String getDay ()
    {
        return day;
    }
    
    public int getStartTime ()
    {
        return startTime;
    }
    
    public int getEndTime ()
    {
        return endTime;
    }
    
    public ArrayList <StudentAccount> getStudents ()
    {
        return students;
    }
}