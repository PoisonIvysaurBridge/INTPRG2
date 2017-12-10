package EnrollmentSysMP;
// Lim, Ivana
// Tan, Nigel
//package EnrollmentSysMP;

import java.util.ArrayList;
import java.io.*;
public class Admin
{
	
	private String usrName,
				   password;
	private ArrayList<Course> courses;
	private ArrayList<Student> allStudents;
	
	private ArrayList<String> courseFileArr;
	// FOR WINDOWS
	String filePath = "C:\\Users\\Robin\\Dropbox\\DLSU\\CODE REPOSITORY\\Java\\INTPRG2\\src\\EnrollmentSysMP\\Files\\";
	// FOR MAC
	//String filePath = "Users//Robin//Dropbox//DLSU//CODE REPOSITORY//Java//INTPRG2//src//EnrollmentSysMP//Files";
	// constructor
	public Admin()
	{
		usrName = "admin";
		password = "DLSU";
		courses = new ArrayList<>();
		allStudents = new ArrayList<>();
	}
	// getters
	public ArrayList<Course> getCourses()
	{
		return courses;
	}
	public ArrayList<Student> getAllStudents()
	{
		return allStudents;
	}
	
	// other methods
	
	public void saveAllStudents()	// optional isEnrolled
	{
		BufferedWriter bw;
		File studentsFile = new File(filePath+"Students.txt");
		try{
			bw = new BufferedWriter(new FileWriter(studentsFile));
			int i;
                        
			for(i = 0; i < allStudents.size(); i++)
			{
				bw.write("ID=" + allStudents.get(i).getID());
				bw.newLine();
				bw.write("PW=" + allStudents.get(i).getPW());
				bw.newLine();
				bw.write("LN=" + allStudents.get(i).getLN());
				bw.newLine();
				bw.write("FN=" + allStudents.get(i).getFN());
				bw.newLine();
				bw.write("minUnits=" + allStudents.get(i).getMin());
				bw.newLine();
				bw.write("maxUnits=" + allStudents.get(i).getMax());
				bw.newLine();
				bw.write("isEnrolled=" + allStudents.get(i).isEnrolled());
				bw.newLine();
			}
                bw.flush();
                bw.close();
		}
		catch(Exception e)
		{
			System.out.println("(Admin: saveAllStudents method) "+e.toString());
		}
	}
	
	public void saveAllCourses()
	{
		BufferedWriter bw;
		File coursesFile = new File(filePath+"Courses.txt");
		try{
			bw = new BufferedWriter(new FileWriter(coursesFile));
			int i;
                        
			for(i = 0; i < courses.size(); i++)
			{
				bw.write("CODE=" + courses.get(i).getCode());
				bw.newLine();
				bw.write("NAME=" + courses.get(i).getName());
				bw.newLine();
				bw.write("UNITS=" + courses.get(i).getUnits()+"");
				bw.newLine();
			}
            bw.flush();
            bw.close();
		}
		catch(Exception e)
		{
			System.out.println("(Admin: saveAllCourses method) "+e.toString());
		}
	}
	
	public void saveAllSections()	// not yet done
	{
		BufferedWriter bw;
		File secitonsFile = new File(filePath+"Sections.txt");
		try{
			bw = new BufferedWriter(new FileWriter(secitonsFile));
			int i;
			for(i = 0; i < courses.size(); i++)
			{
				int j;
				for(j = 0; j < courses.get(i).getSections().size(); j++)
				{
					bw.write("course=" + courses.get(i).getSections().get(j).getCourse().getCode());
					bw.newLine();
					bw.write("name=" + courses.get(i).getSections().get(j).getName());
					bw.newLine();
					bw.write("faculty=" + courses.get(i).getSections().get(j).getFaculty());
					bw.newLine();
					bw.write("sched=" + courses.get(i).getSections().get(j).getSchedule());
					bw.newLine();
					bw.write("startTime=" + courses.get(i).getSections().get(j).getStartTime());
					bw.newLine();
					bw.write("endTime=" + courses.get(i).getSections().get(j).getEndTime());
					bw.newLine();
					bw.write("capacity=" + courses.get(i).getSections().get(j).getCapacity());
					bw.newLine();
				}
			}
			bw.flush();
			bw.close();
		}
		catch(Exception e)
		{
			System.out.println("(Admin: saveAllSections method) "+e/*+e.toString()*/);
		}
	}
	
	public void saveEnrolledStudents()
	{
		BufferedWriter bw;
		File enrolledStudentsFile = new File(filePath+"Enrolled Students.txt");
		try{
			bw = new BufferedWriter(new FileWriter(enrolledStudentsFile));
			int i;
			for(i = 0; i < courses.size(); i++)
			{
				int j;
				for(j = 0; j < courses.get(i).getSections().size(); j++)
				{
					bw.write("course=" + courses.get(i).getSections().get(j).getCourse().getCode());// can we just do courses.get(i).getCode()? XD overthinking
					bw.newLine();
					bw.write("section=" + courses.get(i).getSections().get(j).getName());
					bw.newLine();
					bw.write("students=");
					bw.newLine();
					int k;
					for(k = 0; k < courses.get(i).getSections().get(j).getStudents().size(); k++)
					{
						bw.write(courses.get(i).getSections().get(j).getStudents().get(k).getID());
						bw.newLine();
					}
					
				}
			}
			bw.flush();
			bw.close();
		}
		catch(Exception e)
		{
			System.out.println("(Admin: saveAllSections method) "+e/*+e.toString()*/);
		}
	}
	
	public void loadAllStudents()	// optional isEnrolled
	{
		BufferedReader br;
		File sectionsFile = new File(filePath+"Students.txt");
        String ID = "", PW = "", LN = "", FN = "", minUnits = "", maxUnits = "", isEnrolled = "";
                
        try
        {
            String line;
            br = new BufferedReader (new FileReader (sectionsFile));
        
            while ((line = br.readLine()) != null)
                switch (line.substring (0, line.indexOf("=")))
                {
                    case "ID": ID = line.substring (line.indexOf ("=") + 1); break;
                    case "PW": PW = line.substring (line.indexOf ("=") + 1); break;
                    case "LN": LN = line.substring (line.indexOf ("=") + 1); break;
                    case "FN": FN = line.substring (line.indexOf ("=") + 1); break;
                    case "minUnits": minUnits = line.substring (line.indexOf ("=") + 1); break;
                    case "maxUnits": maxUnits = line.substring (line.indexOf ("=") + 1);  break;
                    case "isEnrolled": isEnrolled = line.substring (line.indexOf ("=") + 1); 
                    Student s = new Student(ID, PW, LN, FN, Double.parseDouble(minUnits), Double.parseDouble(maxUnits));
                    s.setIsEnrolled(Boolean.parseBoolean(isEnrolled));
                    allStudents.add(s);
                                  break;
                }
                    /*if (line.substring (0, line.indexOf("=")).equals ("CODE"))
                            System.out.println (line.substring (line.indexOf ("=") + 1));*/
            br.close ();
        }
        catch(Exception e)
        {
        	System.out.println("(Admin: loadAllStudents method) "+e.toString());
        }
	}
	
	public void loadAllCourses()
	{
		BufferedReader br;
		File sectionsFile = new File(filePath+"Courses.txt");
        String code = "", name = "", units = "";
        
        try
        {
            String line;
            br = new BufferedReader (new FileReader (sectionsFile));
        
            while ((line = br.readLine()) != null)
                switch (line.substring (0, line.indexOf("=")))
                {
                    case "CODE": code = line.substring (line.indexOf ("=") + 1); break;
                    case "NAME": name = line.substring (line.indexOf ("=") + 1); break;
                    case "UNITS": units = line.substring (line.indexOf ("=") + 1); 
                                  courses.add(new Course(code, name, Double.parseDouble(units)));
                                  break;
                }
                    /*if (line.substring (0, line.indexOf("=")).equals ("CODE"))
                            System.out.println (line.substring (line.indexOf ("=") + 1));*/
            br.close ();
        }
        catch(Exception e)
        {
        	System.out.println("(Admin: loadAllCourses method) "+e.toString());
        }
                
	}
	
	public void loadAllSections()
	{
		BufferedReader br;
		File sectionsFile = new File(filePath+"Sections.txt");
        String course = "", name = "", faculty = "", sched = "", startTime = "", endTime = "", capacity = "";
                
        try
        {
            String line;
            br = new BufferedReader (new FileReader (sectionsFile));
        
            while ((line = br.readLine()) != null)
                switch (line.substring (0, line.indexOf("=")))
                {
                    case "course": course = line.substring (line.indexOf ("=") + 1); break;
                    case "name": name = line.substring (line.indexOf ("=") + 1); break;
                    case "faculty": faculty = line.substring (line.indexOf ("=") + 1); break;
                    case "sched": sched = line.substring (line.indexOf ("=") + 1); break;
                    case "startTime": startTime = line.substring (line.indexOf ("=") + 1); break;
                    case "endTime": endTime = line.substring (line.indexOf ("=") + 1); break;
                    case "capacity": capacity = line.substring (line.indexOf ("=") + 1); 
                    
                    Course c = null;
                    int i;
                    for(i = 0; i < courses.size(); i++)
                    {
                    	if (courses.get(i).getCode().equals(course))
                    	{
                    		c = courses.get(i);
                    		Section s = new Section(c, name, faculty, sched, Integer.parseInt(startTime), Integer.parseInt(endTime), Integer.parseInt(capacity));
                    		c.addSection(s);
                    		i = courses.size();
                    	}
                    }
                    break;
                }
                    /*if (line.substring (0, line.indexOf("=")).equals ("CODE"))
                            System.out.println (line.substring (line.indexOf ("=") + 1));*/
            br.close ();
        }
        catch(Exception e)
        {
        	System.out.println("(Admin: loadAllSections method) "+e.toString());
        }
	}
	
	public void loadEnrolledStudents()
	{
		BufferedReader br;
		File sectionsFile = new File(filePath+"Enrolled Students.txt");
        String course = "", section = "";
        ArrayList<String> strStudentID = new ArrayList<>();
        try
        {
            String line;
            br = new BufferedReader (new FileReader (sectionsFile));
        
            while ((line = br.readLine()) != null)
            {
                switch (line.substring (0, line.indexOf("=")))
                {
                    case "course": course = line.substring (line.indexOf ("=") + 1); break;
                    case "section": section = line.substring (line.indexOf ("=") + 1); break;
                    case "students":    
                    			while ((line = br.readLine()) != null && !(line).contains("course"))
			                    {
			                    	strStudentID.add(line);
			                    }
                    Course c = null;
                    int i;
                    for(i = 0; i < courses.size(); i++)
                    {
                    	if (courses.get(i).getCode().equals(course))
                    	{
                    		c = courses.get(i);
                    		int j;
                    		for(j = 0; j < c.getSections().size(); j++)
                    		{
                    			if(c.getSections().get(j).getName().equals(section))
                    			{
                    				Section s = c.getSections().get(j);
                                                c.addSection(s);
                    				int k;
                    				for(k = 0; k < allStudents.size(); k++)
                    				{
                    					int m;
                    					for(m = 0; m < strStudentID.size(); m++)
                    					{
                    						if(allStudents.get(k).getID().equals(strStudentID.get(m)))
                    						{
                    							String ID = allStudents.get(k).getID();
                    							String PW = allStudents.get(k).getPW();
                    							String LN = allStudents.get(k).getLN();
                    							String FN = allStudents.get(k).getFN();
                    							double minUnits = allStudents.get(k).getMin();
                    							double maxUnits = allStudents.get(k).getMin();
                    							Student stud = new Student(ID, PW, LN, FN, minUnits, maxUnits);
                    							s.addStudent(stud);
                                                allStudents.get(k).addSection(s);
                    						}
                    					}
                    					
                    				}
                    			}
                    		}
                                if (line != null && line.contains("course"))
                                    course = line.substring(line.indexOf("=") + 1);
                                strStudentID.clear();
                    		i = courses.size();
                    	}
                    }
                    break;
                }
                    //if (line.substring (0, line.indexOf("=")).equals ("CODE"))
            }               //System.out.println (line.substring (line.indexOf ("=") + 1));*/
            br.close ();
        }
        catch(Exception e)
        {
        	System.out.println("(Admin: loadEnrolledSections method) "+e.toString());
        }
	}
	
	public void registerStudent(String ID, String pw, String LN, String FN, double minUnits, double maxUnits)
	{
		if(!ID.matches("[0-9]{8}"))
		{
			InfoDialog info = new InfoDialog ("Register Student","ID number should only have 8 digits");
		}
		else if(minUnits > 0 && maxUnits > 0 && minUnits <= maxUnits)
		{
			if (allStudents.size() == 0)
			{
				allStudents.add(new Student(ID, pw, LN, FN, minUnits, maxUnits));
				InfoDialog info = new InfoDialog("Register Student","Successful Registration!");
			}
			else
			{
				int i;
				boolean check = true;
				for(i = 0; i < allStudents.size(); i++)
				{
					if (allStudents.get(i).getID().equals(ID))
						check = false;
				}
				if (check)
				{
					allStudents.add(new Student(ID, pw, LN, FN, minUnits, maxUnits));
					InfoDialog info = new InfoDialog("Register Student","Successful Registration!");
				}
				else
				{
					InfoDialog info = new InfoDialog ("Register Student","The student is already in the list.");
				}
			}
		}
		else
		{
			InfoDialog info = new InfoDialog ("Register Student","invalid unit inputs");
		}
			
	}
	
	public void editStudent(String ID, String LN, String FN)
	{	boolean check = false;
		int i;
		for(i = 0; i < allStudents.size(); i++)
		{
			if (allStudents.get(i).getID().equalsIgnoreCase(ID))
			{
				allStudents.get(i).setFirstName(FN);
				allStudents.get(i).setLastName(LN);
				check = true;
			}
		}
		if(check)
		{
			InfoDialog info = new InfoDialog ("Edit Student","Successful!");
		}
		else
		{
			InfoDialog info = new InfoDialog ("Edit Student","Could not find student with ID no."+ID+".");
		}
	}
	
	public void addCourse(String code, String name, double nUnits)
	{
		if (code.matches("[A-Z[0-9]]{7}"))
		{	int i;
			boolean check = true;
			for(i = 0; i < courses.size(); i++)
			{
				if (courses.get(i).getCode().equals(code))
				{
					InfoDialog info = new InfoDialog ("Add Course","The course code already exists.");
					check = false;
					return;
				}
			}
			if(check)
			{
				courses.add(new Course( code,  name,  nUnits));
				InfoDialog info = new InfoDialog ("Add Course","Successful! Course Added!");
			}
		}
		else
		{
			InfoDialog info = new InfoDialog ("Add Course","Invalid course code input.");
		}
    }
	
	public void openSection(Course course, String name, String faculty, String schedule, 
            int startTime, int endTime, int nCapacity)
	{
		if(name.matches("[A-Z][0-9]{2}"))
		{
			int i;
			for(i = 0; i < courses.size(); i++)
			{
				if(courses.get(i).getCode().equals(course.getCode()))
				{
					courses.get(i).addSection(new Section(courses.get(i),  name,  faculty,  schedule, 
				             startTime,  endTime,  nCapacity));
					
				}
			}
		}
		else
		{
			InfoDialog info = new InfoDialog ("Add Course","Invalid section format.");
		}
	}
	
	public void viewClassList(Course course, Section section)
	{	
		int i;
		for(i = 0; i < courses.size(); i++)
		{	Course c = courses.get(i);
			String courseCode = c.getCode();
			if(courseCode.equals(course.getCode()))
			{
				int j;
				for(j = 0; j < c.getSections().size(); j++)
				{	Section s = c.getSections().get(j);
					String sectName = c.getSections().get(j).getName();
					if (sectName.equals(section.getName()))
					{
						section.viewEnrolledStudents();
					}
					
				}
			}
			
		}
	}
        
    /*public static void main(String[] args) {
        Admin a = new Admin();
        
        a.addCourse("INTPRG2", "Nigel", 3);
        a.saveAllCourses();
    }*/
}
