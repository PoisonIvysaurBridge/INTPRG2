package IcoMP;
public class Course
{
    private String name;
    private String courseCode;
    private double units;
    
    public Course (String newname, String newCourseCode, double newUnits)
    {
        name = newname;
        courseCode = newCourseCode;
        units = newUnits;
    }
    
    public String getName ()
    {
        return name;
    }
    
    public String getCourseCode ()
    {
        return courseCode;
    }
    
    public double getUnits ()
    {
        return units;
    }
}