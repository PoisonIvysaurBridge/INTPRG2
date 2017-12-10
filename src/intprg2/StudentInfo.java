package intprg2;
// Ivana Lim #14            6-16-16
public class StudentInfo
{
    private String name;
    private int IDno;
    private String course;
    
    // constructor methods
    public StudentInfo()
    {
        
    }
    public StudentInfo(int newIDno)
    {
        IDno = newIDno;
    }
    public StudentInfo(String newCourse)
    {
        course = newCourse;
    }
    public StudentInfo(String newName, int newIDno)
    {
        name = newName;
        IDno = newIDno;
    }
    public StudentInfo(String newName, int newIDno, String course)
    {
        name = newName;
        IDno = newIDno;
    }
    // accessor methods
    public String getName()
    {
        if (name== null)
            return "No name";
        return name;
    }
    public int getIDno()
    {
        return IDno;
    }
    public String getCourse()
    {
        if (course == null)
            return "No course";
        return course;
    }
    
    // mutator methods
    public void setName(String newName)
    {
        if(name == null)
            name = newName;
    }
    public void setIDno(int newIDno)
    {
        if (IDno == 0)
            IDno = newIDno;
    }
    public void setCourse(String newCourse)
    {
        course = newCourse;
    }
    
    // other methods
    public void display()
    {
        System.out.println("Student name: "+getName());
        System.out.println("Student ID no: "+getIDno());
        System.out.println("Student course: "+getCourse());
    }
    
}