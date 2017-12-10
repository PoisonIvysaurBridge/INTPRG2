package EnrollmentSysMP;
// Lim, Ivana
// Tan, Nigel
//package EnrollmentSysMP;

import java.util.ArrayList;

public class Student
{
	private String usrIDno,
				   password,
				   firstName,
				   lastName;
	private double minUnits,
				   maxUnits;
	private boolean isEnrolled;
	private ArrayList<Section> enlistedSections;
	String data[][];
        float units;
	// constructors
	public Student(String ID, String PW, String LN, String FN, double minUnits, double maxUnits)
	{
		usrIDno = ID;
		password = PW;
		firstName = FN;
		lastName = LN;
		isEnrolled = false;
		this.minUnits = minUnits;
		this.maxUnits = maxUnits;
		enlistedSections = new ArrayList<>();
	}
	
	// getters
	public String getID()
	{
		return usrIDno;
	}
	
	public String getPW()
	{
		return password;
	}
	
	public String getFN() 
	{
		return firstName;
	}
	
	public String getLN() 
	{
		return lastName;
	}
	public double getMin()
	{
		return minUnits;
	}
	public double getMax()
	{
		return maxUnits;
	}
	public ArrayList<Section> getEnlistedSections()
	{
		return enlistedSections;
	}
	// setters
	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}

	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
	}

	public void setMaxUnits(int maxUnits) 
	{
		this.maxUnits = maxUnits;
	}
	
	public void setMinUnits(int minUnits) 
	{
		this.minUnits = minUnits;
	}
	public void setIsEnrolled(boolean flag)
    {
        isEnrolled = flag;
    }
    public boolean isEnrolled()
    {
        return isEnrolled;
    }
    
    public void addSection(Section s)
    {
        enlistedSections.add(s);
    }
    
	// other methods
	public void enlistSection(Section section) // still lacks checking of schedule conflicts DONE
	{
		if (isEnrolled == false && section.getCapacity() != section.getStudents().size()) //checks if capacity is full or student is enrolled
		{
			boolean check = true;
			int i;
			for(i = 0; i < enlistedSections.size(); i++)
			{
				if (section.getCourse().getCode().equalsIgnoreCase(enlistedSections.get(i).getCourse().getCode())) // checks if duplicate course
				{
					InfoDialog info = new InfoDialog ("Enslist Section","Unsuccessful enlistment: The student has has duplicate courses.");
					check = false;
					return ;
				}
			}
			
			for (i = 0; i < enlistedSections.size(); i++) // checks for schedule conflicts
			{
				if (section.isConflict(enlistedSections.get(i)))
				{
					InfoDialog info = new InfoDialog ("Enslist Section","Unsuccessful enlistment: The student has conflicts in schedule.");
					check = false;
					return;
				}
			}
			if (check)
			{
				enlistedSections.add(section);
				//section.addStudent(this);
				InfoDialog info = new InfoDialog ("Enslist Section","Successful enlistment: "+section.getCourse().getCode() + " "+section.getName());
			}
		}
		else
		{
			InfoDialog info = new InfoDialog ("Enslist Section","Unsuccessful enlistment: Student is already enrolled or the section is closed.");
		}
	}
	
	public Section removeEnlistment(Course course)
	{
		if (isEnrolled == false)
		{
			int i;
			for(i = 0; i < enlistedSections.size(); i++)
			{
				if(course.getCode().equals(enlistedSections.get(i).getCourse().getCode()))
				{
					InfoDialog info = new InfoDialog ("Remove Enslistment","Successful! Enlistment removed: "+
							enlistedSections.get(i).getCourse().getCode()+" "+enlistedSections.get(i).getName());
					enlistedSections.get(i).removeStudent(this);
					return enlistedSections.remove(i);
				}
			}
		}
		InfoDialog info = new InfoDialog("Remove Enslistment","Unsuccessful.");
		return null;
	}
	
	public void enroll()
	{
		
		if(this.isEnrolled == false)
		{
			int totalUnits =0;
			for(int i = 0; i < enlistedSections.size(); i++)
			{
				totalUnits += enlistedSections.get(i).getCourse().getUnits();
			}
			
			if (totalUnits >= this.minUnits && totalUnits <= this.maxUnits)
			{
				isEnrolled = true;
				for(int i = 0; i < enlistedSections.size(); i++)
				{
					enlistedSections.get(i).addStudent(this);
				}
				InfoDialog info = new InfoDialog("Enroll", "Successful");
			}
			else if(totalUnits < minUnits)
			{
				InfoDialog info = new InfoDialog("Enroll", "Unsuccessful: Student has not reach the minimum number of units.");
			}
			else if(totalUnits > maxUnits)
			{
				InfoDialog info = new InfoDialog("Enroll", "Unsuccessful: Student has overload units. Please remove some of the enlisted classes.");
			}
		}
		else
		{
			InfoDialog info = new InfoDialog("Enroll", "Unsuccessful: Student has already enrolled.");
		}
		
	}
        
	public void viewEAF()
	{
            units = 0;
            data = new String[enlistedSections.size()][6];
            
            int i, j;
            
            for (i = 0; i < enlistedSections.size(); i ++)
            {
                for (j = 0; j < data[i].length; j ++)
                {
                    switch (j)
                    {
                        case 0: data[i][j] = enlistedSections.get(i).getCourse().getCode(); break;
                        case 1: data[i][j] = enlistedSections.get(i).getCourse().getName(); break;
                        case 2: data[i][j] = enlistedSections.get(i).getName(); break;
                        case 3: data[i][j] = enlistedSections.get(i).getFaculty(); break;
                        case 4: data[i][j] = enlistedSections.get(i).getSchedule() + " " +
                                             enlistedSections.get(i).getStartTime() + "-" + 
                                             enlistedSections.get(i).getEndTime(); break;
                        case 5: data[i][j] = "" + enlistedSections.get(i).getCourse().getUnits(); 
                                units += enlistedSections.get(i).getCourse().getUnits();
                                break;
                    }
                }
            }
	}

}
