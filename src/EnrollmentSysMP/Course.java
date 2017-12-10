package EnrollmentSysMP;
// Lim, Ivana
// Tan, Nigel
//package EnrollmentSysMP;
import java.util.ArrayList;
import java.util.Vector;

public class Course 
{
    private String name, 
    			   code;
    private double    units;
    private ArrayList<Section> sections;
    
    public Course(String code, String name, double nUnits)
    {
        sections = new ArrayList<>();
        this.name = name;
        this.code = code;
        units = nUnits;
    }
    // getters
    public String getName()
    {
        return name;
    }
    
    public String getCode()
    {
        return code;
    }
    
    public double getUnits()
    {
        return units;
    }
    
    public ArrayList<Section> getSections()
    {
        return sections;
    }
    
    // other methods
    public void addSection(Section sect)
    {
    	boolean check = true;
    	int i;
        for(i = 0; i < sections.size(); i++)
        {
        	if (sect.getName().equals(sections.get(i).getName()))
        	{
        		InfoDialog info = new InfoDialog("Open Section", "There course already has "+sect.getName());
        		check = false;
        		return;
        	}
        }
    	sections.add(sect);
    	InfoDialog info = new InfoDialog ("Open Section","Successful! Section Opened!");
    }
    
    
}
