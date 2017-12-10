import java.util.*;
import java.io.*;
public class AdministratorAccount
{
    private String username;
    private String password;
    private ArrayList <StudentAccount> studentAccounts;
    private ArrayList <Course> courses;
    private ArrayList <Section> sections;
    
    private ArrayList <String> studentsFileData;
    private ArrayList <String> coursesFileData;
    private ArrayList <String> sectionsFileData;
    
    public AdministratorAccount ()
    {
        username = "admin";
        password = "DLSU";
        studentAccounts = new ArrayList <> ();
        courses = new ArrayList <> ();
        sections = new ArrayList <> ();
    }
    
    public void registerStudentAccount (StudentAccount newStudent)
    {
        int Ctr;
        for (Ctr = 0; Ctr < studentAccounts.size() && !(studentAccounts.get(Ctr).getUsername().equals(newStudent.getUsername())); Ctr ++);
        if (Ctr == studentAccounts.size())
        {
            studentAccounts.add(newStudent);
            saveStudents();
            MessageGUI alert = new MessageGUI ("EnLos System", "Student Account Registered!");
        }
        else
        {
            MessageGUI alert = new MessageGUI ("Error", "ID number already exists!");
        }
    }
    
    public void editStudentAccount (StudentAccount student, String newFirstName, String newLastName)
    {
        studentAccounts.get(studentAccounts.indexOf(student)).setFirstName(newFirstName);
        studentAccounts.get(studentAccounts.indexOf(student)).setLastName(newLastName);
        MessageGUI alert = new MessageGUI ("EnLos System", "Changes Saved!");
        saveStudents();
    }
    
    public void addCourse (Course newCourse)
    {
        int Ctr;
        for (Ctr = 0; Ctr < courses.size() && !(courses.get(Ctr).getCourseCode().equals(newCourse.getCourseCode())); Ctr ++);
        if (Ctr == courses.size())
        {
            courses.add(newCourse);
            saveCourses();
            MessageGUI alert = new MessageGUI ("EnLos System", "Course Added!");
        }
        else
        {
            MessageGUI alert = new MessageGUI ("Error", "Course code already exists!");
        }
    }
    
    public void openSection (Section newSection)
    {
        int Ctr;
        for (Ctr = 0; Ctr < sections.size() && !(newSection.getCourse() == sections.get(Ctr).getCourse() && newSection.getName().equals(sections.get(Ctr).getName())); Ctr ++);
        if (Ctr == sections.size())
        {
            sections.add(newSection);
            saveSections();
            MessageGUI alert = new MessageGUI ("EnLos System", "Section Opened!");
        }
        else
        {
            MessageGUI alert = new MessageGUI ("Error", "Section name already exists in this course!");
        }
    }
    
    public ArrayList <StudentAccount> getStudentAccounts ()
    {
        return studentAccounts;
    }
    
    public ArrayList <Course> getCourses ()
    {
        return courses;
    }
    
    public ArrayList <Section> getSections ()
    {
        return sections;
    }
    
    public void loadCourses ()
    {
        File coursesFile = new File("Z:\\INTPRG2\\MP\\Files\\Courses.txt");
        BufferedReader br;
        int ctr = 1;
        String reader;
        coursesFileData = new ArrayList <> ();
        try
        {
            br = new BufferedReader (new FileReader (coursesFile));
            reader = br.readLine();
            while (reader != null)
            {
                coursesFileData.add(reader);
                reader = br.readLine();
                if (ctr % 3 == 0)
                {
                    courses.add(new Course(coursesFileData.get(ctr-3),
                            coursesFileData.get(ctr-2),
                            Double.parseDouble(coursesFileData.get(ctr-1))));
                }
                ctr += 1;
            }
            br.close();
        }
        catch (Exception exception)
        {
            System.out.println ("(AdministratorAccount: loadCourses) " + exception.toString () + " " + coursesFile.getAbsolutePath ());
        }
    }
    
    public void saveCourses ()
    {
        File coursesFile = new File("Z:\\INTPRG2\\MP\\Files\\Courses.txt");
        BufferedWriter bw;
        try
        {
            bw = new BufferedWriter (new FileWriter (coursesFile));
            int Ctr;
            for (Ctr = 0; Ctr < courses.size(); Ctr ++)
            {
                bw.write (courses.get(Ctr).getName());
                bw.newLine ();
                bw.write (courses.get(Ctr).getCourseCode());
                bw.newLine ();
                bw.write (Double.toString (courses.get(Ctr).getUnits()));
                bw.newLine ();
            }
            bw.close ();
        }
        catch (Exception exception)
        {
            System.out.println ("(AdministratorAccount: saveCourses) " + exception.toString () + " " + coursesFile.getAbsolutePath ());
        }
    }
    
    public void loadStudents()
    {
        File studentsFile = new File("Z:\\INTPRG2\\MP\\Files\\Students.txt");
        BufferedReader br;
        int ctr = 1;
        String reader;
        studentsFileData = new ArrayList <> ();
        try
        {
            br = new BufferedReader (new FileReader (studentsFile));
            reader = br.readLine();
            while (reader != null)
            {
                studentsFileData.add(reader);
                reader = br.readLine();
                if (ctr % 6 == 0)
                {
                    studentAccounts.add(new StudentAccount(studentsFileData.get(ctr-6),
                            studentsFileData.get(ctr-5),
                            studentsFileData.get(ctr-4),
                            studentsFileData.get(ctr-3),
                            Double.parseDouble(studentsFileData.get(ctr-2)),
                            Double.parseDouble(studentsFileData.get(ctr-1))));
                }
                ctr += 1;
            }
            br.close();
        }
        catch (Exception exception)
        {
            System.out.println ("(AdministratorAccount: saveCourses) " + exception.toString () + " " + studentsFile.getAbsolutePath ());
        }
    }
    
    public void saveStudents()
    {
        File studentsFile = new File("Z:\\INTPRG2\\MP\\Files\\Students.txt");
        BufferedWriter bw;
        try
        {
            bw = new BufferedWriter (new FileWriter (studentsFile));
            int Ctr;
            for (Ctr = 0; Ctr < studentAccounts.size(); Ctr ++)
            {
                bw.write (studentAccounts.get(Ctr).getUsername());
                bw.newLine ();
                bw.write (studentAccounts.get(Ctr).getPassword());
                bw.newLine ();
                bw.write (studentAccounts.get(Ctr).getFirstName());
                bw.newLine ();
                bw.write (studentAccounts.get(Ctr).getLastName());
                bw.newLine ();
                bw.write (Double.toString (studentAccounts.get(Ctr).getMinUnits()));
                bw.newLine ();
                bw.write (Double.toString (studentAccounts.get(Ctr).getMaxUnits()));
                bw.newLine ();
            }
            bw.close ();
        }
        catch (Exception exception)
        {
            System.out.println ("(AdministratorAccount: saveCourses) " + exception.toString () + " " + studentsFile.getAbsolutePath ());
        }
    }
    
    public void loadSections()
    {
        File sectionsFile = new File("Z:\\INTPRG2\\MP\\Files\\Sections.txt");
        BufferedReader br;
        int ctr = 1;
        String reader;
        sectionsFileData = new ArrayList <> ();
        try
        {
            br = new BufferedReader (new FileReader (sectionsFile));
            reader = br.readLine();
            while (reader != null)
            {
                sectionsFileData.add(reader);
                reader = br.readLine();
                if (ctr % 7 == 0)
                {
                    int ctr2;
                    for (ctr2 = 0; ctr2 < courses.size() && !(courses.get(ctr2).getCourseCode().equals(sectionsFileData.get(ctr-7))); ctr2++);
                    if (ctr2 != courses.size())
                    {
                    sections.add(new Section(courses.get(ctr2),
                            sectionsFileData.get(ctr-6),
                            sectionsFileData.get(ctr-5),
                            Integer.parseInt(sectionsFileData.get(ctr-4)),
                            sectionsFileData.get(ctr-3),
                            Integer.parseInt(sectionsFileData.get(ctr-2)),
                            Integer.parseInt(sectionsFileData.get(ctr-1))));
                    }
                }
                ctr += 1;
            }
            br.close();
        }
        catch (Exception exception)
        {
            System.out.println ("(AdministratorAccount: saveCourses) " + exception.toString () + " " + sectionsFile.getAbsolutePath ());
        }
    }
    
    public void saveSections()
    {
        File sectionsFile = new File("Z:\\INTPRG2\\MP\\Files\\Sections.txt");
        BufferedWriter bw;
        try
        {
            bw = new BufferedWriter (new FileWriter (sectionsFile));
            int Ctr;
            for (Ctr = 0; Ctr < sections.size(); Ctr ++)
            {
                bw.write (sections.get(Ctr).getCourse().getCourseCode());
                bw.newLine ();
                bw.write (sections.get(Ctr).getName());
                bw.newLine ();
                bw.write (sections.get(Ctr).getFaculty());
                bw.newLine ();
                bw.write (Integer.toString (sections.get(Ctr).getCapacity()));
                bw.newLine ();
                bw.write (sections.get(Ctr).getDay());
                bw.newLine ();
                bw.write (Integer.toString (sections.get(Ctr).getStartTime()));
                bw.newLine ();
                bw.write (Integer.toString (sections.get(Ctr).getEndTime()));
                bw.newLine ();
            }
            bw.close ();
        }
        catch (Exception exception)
        {
            System.out.println ("(AdministratorAccount: saveCourses) " + exception.toString () + " " + sectionsFile.getAbsolutePath ());
        }
    }
}