package IcoMP;
import java.util.*;
public class StudentAccount
{
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private double minUnits;
    private double maxUnits;
    private boolean enrolled;
    private ArrayList <Section> enlistments;
    
    public StudentAccount (String newUsername, String newPassword, String newFirstName, String newLastName, double newMinUnits, double newMaxUnits)
    {
        username = newUsername;
        password = newPassword;
        firstName = newFirstName;
        lastName = newLastName;
        minUnits = newMinUnits;
        maxUnits = newMaxUnits;
        enrolled = false;
        enlistments = new ArrayList <> ();
    }
    
    public void enlistSection (Section newSection)
    {
        if (!(enrolled))
        {
            if (enlistments.size() < newSection.getCapacity())
            {
                int Ctr;
                for (Ctr = 0; Ctr < enlistments.size() && enlistments.get(Ctr).getCourse() != newSection.getCourse(); Ctr ++);
                if (Ctr == enlistments.size())
                {
                    if (!(enlistments.contains(newSection)))
                    {
                        for (Ctr = 0; Ctr < enlistments.size(); Ctr ++)
                        {
                            if (enlistments.get(Ctr).getDay().equals(newSection.getDay()))
                            {
                                if ((newSection.getStartTime() <= enlistments.get(Ctr).getEndTime()
                                    && newSection.getStartTime() >= enlistments.get(Ctr).getStartTime())
                                    || (newSection.getEndTime() >= enlistments.get(Ctr).getStartTime()
                                    && newSection.getEndTime() <= enlistments.get(Ctr).getEndTime()))
                                {
                                    break;
                                }
                            }
                        }
                        if (Ctr == enlistments.size())
                        {
                            enlistments.add(newSection);
                            newSection.addStudent(this);
                        }
                        else
                            System.out.println("There's conflict in schedule!");
                    }
                    else
                        System.out.println("Section was already enlisted!");
                }
                else
                    System.out.println("You're already enlisted in this course!");
            }
            else
                System.out.println("Section is full!");
        }
    }
    
    public void removeEnlistment (Section newSection)
    {
        int Ctr;
        for (Ctr = 0; Ctr < enlistments.size() && enlistments.get(Ctr) != newSection; Ctr ++);
        if (Ctr != enlistments.size())
            enlistments.remove(newSection);
        else
            System.out.println("This section is not in the list!");
    }
    
    public void enroll ()
    {
        if (!(enrolled))
        {
            int Ctr;
            double totalUnits = 0;
            for (Ctr = 0; Ctr < enlistments.size(); Ctr ++)
            {
                totalUnits += enlistments.get(Ctr).getCourse().getUnits();
            }
            if (totalUnits >= minUnits && totalUnits <= maxUnits)
            {
                enrolled = true;
            }
            else
                System.out.println("Lacks/Exceeds number of units!");
        }
        else
            System.out.println("Students is already enrolled!");
    }
    
    public String getUsername ()
    {
        return username;
    }
    
    public String getPassword ()
    {
        return password;
    }
    
    public String getFirstName()
    {
        return firstName;
    }
    
    public String getLastName ()
    {
        return lastName;
    }
    
    public void setFirstName (String newFirstName)
    {
        firstName = newFirstName;
    }
    
    public void setLastName (String newLastName)
    {
        lastName = newLastName;
    }
    
    public double getMinUnits ()
    {
        return minUnits;
    }
    
    public double getMaxUnits ()
    {
        return maxUnits;
    }
    
    public boolean ifEnrolled ()
    {
        return enrolled;
    }
    
    public ArrayList <Section> getEnlistments ()
    {
        return enlistments;
    }
}