package IcoMP;
import java.util.*;
import java.io.*;

public class FileManagement
{
    public void saveCourses (ArrayList addCourses)
    {
        ArrayList <Course> courses;
        courses = addCourses;
        File courseFile = new File ("C:\\Users\\11530022\\Documents\\Course File\\courseFile.ec");
        BufferedWriter bw;
        try
        {
            bw = new BufferedWriter (new FileWriter (courseFile));
            int Ctr;
            for (Ctr = 0; Ctr < courses.size(); Ctr ++)
            {
                bw.write (courses.get(Ctr).getName());
                bw.newLine ();
                bw.write (courses.get(Ctr).getCourseCode());
                bw.newLine ();
                bw.write (Double.toString (courses.get(Ctr).getUnits()));
                bw.newLine ();
                bw.write ("------------------------------------------------------");
                bw.newLine ();
            }
            bw.close ();
        }
        catch (Exception exception)
        {
            System.out.println ("(FileManagement: saveCourses) " + exception.toString ());
        }
    }
    
    public void loadCourses (String fileName)
    {
        File courseFile = new File ("C:\\Users\\11530022\\Documents\\Course File\\" + fileName);
        BufferedReader br;
        String line;
        try
        {
            br = new BufferedReader (new FileReader (courseFile));
            int Ctr;
            while ((line = br.readLine ()) != null)
            {
                if (!(line.equals("------------------------------------------------------")))
                    System.out.println(line);
            }
            br.close ();
        }
        catch (Exception exception)
        {
            System.out.println ("(FileManagement: loadCourses) " + exception.toString ());
        }
    }
    
    public static void main(String[] args)
    {
        FileManagement callMethod = new FileManagement ();
        callMethod.loadCourses ("courseFile.txt");
    }
}