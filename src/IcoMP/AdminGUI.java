package IcoMP;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class AdminGUI extends JFrame implements ActionListener
{
    private JButton registerStudentAccount;
    private JButton editStudentAccount;
    private JButton addCourse;
    private JButton openSection;
    private JButton viewClassList;
    private JButton logOut;
    private JPanel reg1;
    private JButton click;
    private JButton chooseCourse;
    private JButton viewClass;
    private JTextField inputID;
    private JTextField inputPassword;
    private JTextField inputFN;
    private JTextField inputLN;
    private JTextField inputMinU;
    private JTextField inputMaxU;
    private JTextField inputNewFN;
    private JTextField inputNewLN;
    private JTextField inputCourseName;
    private JTextField inputCourseCode;
    private JTextField inputUnits;
    private JTextField inputSectionName;
    private JTextField inputFaculty;
    private JTextField inputCapacity;
    private JTextField inputDay;
    private JTextField inputSTime;
    private JTextField inputETime;
    private JComboBox IDNumber;
    private JComboBox CourseCode;
    private JComboBox SectionName;
    private AdministratorAccount admin;
    
    public AdminGUI (AdministratorAccount copyAdmin)
    {
        super ("EnLos University - Administrator Account");
        chooseOption ();
        setSize (650,230);
        setResizable(false);
        setDefaultCloseOperation (EXIT_ON_CLOSE);
        setVisible (true);
        admin = copyAdmin;
    }
    
    public void chooseOption ()
    {
        JPanel p1 = new JPanel ();
        add(p1,BorderLayout.WEST);
        JPanel p2 = new JPanel ();
        p1.add(p2, BorderLayout.CENTER);
        JPanel p1a = new JPanel ();
        p1a.setLayout (new GridLayout (0,1,0,5));
        registerStudentAccount = new JButton ("Register Student Account");
        registerStudentAccount.addActionListener(this);
        editStudentAccount = new JButton ("Edit Student Account");
        editStudentAccount.addActionListener(this);
        addCourse = new JButton ("Add Course");
        addCourse.addActionListener(this);
        openSection = new JButton ("Open Section");
        openSection.addActionListener(this);
        viewClassList = new JButton ("View Class List");
        viewClassList.addActionListener(this);
        logOut = new JButton ("LOGOUT");
        logOut.addActionListener(this);
        p2.add(p1a);
        p1a.add(registerStudentAccount);
        p1a.add(editStudentAccount);
        p1a.add(addCourse);
        p1a.add(openSection);
        p1a.add(viewClassList);
        p1a.add(logOut);
        reg1 = new JPanel ();
        reg1.setVisible(false);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getActionCommand().equals("Register Student Account"))
        {
            reg1.removeAll();
            add(reg1, BorderLayout.CENTER);
            JPanel reg2 = new JPanel ();
            reg1.add(reg2);
            JPanel reg1a = new JPanel (new GridLayout (0,1,0,5));
            JLabel id = new JLabel ("ID Number:");
            inputID = new JTextField (15);
            JLabel password = new JLabel ("Password:");
            inputPassword = new JTextField (15);
            JLabel firstName = new JLabel ("First Name:");
            inputFN = new JTextField (15);
            JLabel lastName = new JLabel ("Last Name:");
            inputLN = new JTextField (15);
            JLabel minUnits = new JLabel ("Min. Units:");
            inputMinU = new JTextField (15);
            JLabel maxUnits = new JLabel ("Max. Units:");
            inputMaxU= new JTextField (15);
            reg2.add(reg1a);
            reg1a.add(id);
            reg1a.add(inputID);
            reg1a.add(password);
            reg1a.add(inputPassword);
            reg1a.add(firstName);
            reg1a.add(inputFN);
            reg1a.add(lastName);
            reg1a.add(inputLN);
            reg1a.add(minUnits);
            reg1a.add(inputMinU);
            reg1a.add(maxUnits);
            reg1a.add(inputMaxU);
            JPanel reg1b = new JPanel (new GridLayout (1,1));
            click = new JButton ("Register Student");
            click.addActionListener(this);
            reg1.add(reg1b);
            reg1b.add(click);
            reg1.updateUI ();
            reg1.setVisible(true);
        }
        else  if (e.getActionCommand().equals("Register Student"))
        {
            if (inputID.getText().equals("") || inputPassword.getText().equals("") || inputFN.getText().equals("") || inputLN.getText().equals("") || inputMinU.getText().equals("") || inputMaxU.getText().equals(""))
            {
                MessageGUI alert = new MessageGUI ("Error", "Fill out everything!");
            }
            else if (Double.parseDouble(inputMaxU.getText()) < Double.parseDouble(inputMinU.getText()))
            {
                MessageGUI alert = new MessageGUI ("Error", "Max. Units should be greater than Min. Units!");
            }
            else
            {
                StudentAccount newStudent = new StudentAccount (inputID.getText(),inputPassword.getText(),inputFN.getText(),inputLN.getText(),Double.parseDouble(inputMinU.getText()),Double.parseDouble(inputMaxU.getText()));
                admin.registerStudentAccount(newStudent);
            }
        }
        else if (e.getActionCommand().equals("Edit Student Account"))
        {
            String [] studentIDNumber = new String [admin.getStudentAccounts().size()];
            int Ctr;
            for (Ctr = 0; Ctr < studentIDNumber.length; Ctr ++)
            {
                studentIDNumber [Ctr] = admin.getStudentAccounts().get(Ctr).getUsername();
            }
            reg1.removeAll();
            add(reg1, BorderLayout.CENTER);
            JPanel reg2 = new JPanel ();
            reg1.add(reg2);
            JPanel reg1a = new JPanel (new GridLayout (0,2,5,5));
            JLabel studentID = new JLabel ("Student's ID Number:");
            IDNumber = new JComboBox (studentIDNumber);
            IDNumber.setPreferredSize (new Dimension (100,20));
            JLabel newFN = new JLabel ("New First Name:");
            inputNewFN = new JTextField (15);
            JLabel newLN = new JLabel ("New Last Name:");
            inputNewLN = new JTextField (15);
            reg2.add(reg1a);
            reg1a.add(studentID);
            reg1a.add(IDNumber);
            reg1a.add(newFN);
            reg1a.add(inputNewFN);
            reg1a.add(newLN);
            reg1a.add(inputNewLN);
            JPanel reg1b = new JPanel (new GridLayout (1,1));
            click = new JButton ("Save Changes");
            click.addActionListener(this);
            reg1.add(reg1b);
            reg1b.add(click);
            reg1.updateUI ();
            reg1.setVisible(true);
        }
        else  if (e.getActionCommand().equals("Save Changes"))
        {
            if (IDNumber.getSelectedItem() == null)
            {
                MessageGUI alert = new MessageGUI ("Error", "No students in the list!");
            }
            else if (inputNewFN.getText().equals("") || inputNewLN.getText().equals(""))
            {
                MessageGUI alert = new MessageGUI ("Error", "Fill out everything!");
            }
            else
            {
                String text = IDNumber.getSelectedItem().toString();
                int Ctr;
                for (Ctr = 0; Ctr < admin.getStudentAccounts().size() && !(admin.getStudentAccounts().contains(text)); Ctr ++);
                admin.editStudentAccount(admin.getStudentAccounts().get(Ctr-1),inputNewFN.getText(), inputNewLN.getText());
            }
        }
        else if (e.getActionCommand().equals("Add Course"))
        {
            reg1.removeAll();
            add(reg1, BorderLayout.CENTER);
            JPanel reg2 = new JPanel ();
            reg1.add(reg2);
            JPanel reg1a = new JPanel (new GridLayout (0,2,5,5));
            JLabel courseName = new JLabel ("Course Name:");
            inputCourseName = new JTextField (15);
            JLabel courseCode = new JLabel ("Course Code:");
            inputCourseCode = new JTextField (15);
            JLabel units = new JLabel ("Units:");
            inputUnits = new JTextField (15);
            reg2.add(reg1a);
            reg1a.add(courseName);
            reg1a.add(inputCourseName);
            reg1a.add(courseCode);
            reg1a.add(inputCourseCode);
            reg1a.add(units);
            reg1a.add(inputUnits);
            JPanel reg1b = new JPanel (new GridLayout (1,1));
            click = new JButton ("Create Course");
            click.addActionListener(this);
            reg1.add(reg1b);
            reg1b.add(click);
            reg1.updateUI ();
            reg1.setVisible(true);
        }
        else if (e.getActionCommand().equals("Create Course"))
        {
            if (inputCourseName.getText().equals("") || inputCourseCode.getText().equals("") || inputUnits.getText().equals(""))
            {
                MessageGUI alert = new MessageGUI ("Error", "Fill out everything!");
            }
            else if (inputCourseCode.getText().length() != 7)
            {
                MessageGUI alert = new MessageGUI ("Error", "Course code must have 7 characters only!");
            }
            else
            {
                Course newCourse = new Course (inputCourseName.getText(),inputCourseCode.getText().toUpperCase(),Double.parseDouble(inputUnits.getText()));
                admin.addCourse(newCourse);
            }
        }
        else if (e.getActionCommand().equals("Open Section"))
        {
            String [] courseCodes = new String [admin.getCourses().size()];
            int Ctr;
            for (Ctr = 0; Ctr < courseCodes.length; Ctr ++)
            {
                courseCodes [Ctr] = admin.getCourses().get(Ctr).getCourseCode();
            }
            reg1.removeAll();
            add(reg1, BorderLayout.CENTER);
            JPanel reg2 = new JPanel ();
            reg1.add(reg2);
            
            JPanel reg1a = new JPanel (new GridLayout (0,2,5,5));
            JLabel courseCode = new JLabel ("Course Code:");
            CourseCode = new JComboBox (courseCodes);
            CourseCode.setPreferredSize (new Dimension (100,20));
            JLabel sectionName = new JLabel ("Section Name:");
            inputSectionName = new JTextField (15);
            JLabel faculty = new JLabel ("Faculty:");
            inputFaculty = new JTextField (15);
            JLabel capacity = new JLabel ("Capacity:");
            inputCapacity= new JTextField (15);
            JLabel day = new JLabel ("Day:");
            inputDay = new JTextField (15);
            reg2.add(reg1a);
            reg1a.add(courseCode);
            reg1a.add(CourseCode);
            reg1a.add(sectionName);
            reg1a.add(inputSectionName);
            reg1a.add(faculty);
            reg1a.add(inputFaculty);
            reg1a.add(capacity);
            reg1a.add(inputCapacity);
            reg1a.add(day);
            reg1a.add(inputDay);
            JPanel reg1c = new JPanel (new GridLayout (1,2,5,0));
            JLabel startTime = new JLabel ("Start Time:");
            inputSTime = new JTextField (9);
            JLabel endTime = new JLabel ("End Time:");
            inputETime = new JTextField (9);
            reg1.add(reg1c);
            reg1c.add(startTime);
            reg1c.add(inputSTime);
            reg1c.add(endTime);
            reg1c.add(inputETime);
            JPanel reg1b = new JPanel (new GridLayout (1,1));
            click = new JButton ("Create Section");
            click.addActionListener(this);
            reg1.add(reg1b);
            reg1b.add(click);
            reg1.updateUI ();
            reg1.setVisible(true);
        }
        else if (e.getActionCommand().equals("Create Section"))
        {
            if (CourseCode.getSelectedItem() == null)
            {
                MessageGUI alert = new MessageGUI ("Error", "No available courses!");
            }
            else if (inputSectionName.getText().equals("") || inputFaculty.getText().equals("") || inputCapacity.getText().equals("") || inputDay.getText().equals("") || inputSTime.getText().equals("") || inputETime.getText().equals(""))
            {
                MessageGUI alert = new MessageGUI ("Error", "Fill out everything!");
            }
            else if (inputSectionName.getText().length() != 3)
            {
                MessageGUI alert = new MessageGUI ("Error", "Course code must have 3 characters only!");
            }
            else if (!(inputDay.getText().toUpperCase().equals("MW")) && !(inputDay.getText().toUpperCase().equals("TH")))
            {
                MessageGUI alert = new MessageGUI ("Error", "Invalid Day!");
            }
            else if (Integer.parseInt(inputETime.getText()) < Integer.parseInt(inputSTime.getText()))
            {
                MessageGUI alert = new MessageGUI ("Error", "End Time should be greater than Start Time!");
            }
            else
            {
                String text = CourseCode.getSelectedItem().toString();
                int Ctr;
                for (Ctr = 0; Ctr < admin.getCourses().size() && !(admin.getCourses().get(Ctr).getCourseCode().equals(text.toUpperCase())); Ctr ++);
                Section newSection = new Section (admin.getCourses().get(Ctr),inputSectionName.getText().toUpperCase(),inputFaculty.getText(),Integer.parseInt(inputCapacity.getText()),inputDay.getText(),Integer.parseInt(inputSTime.getText()),Integer.parseInt(inputETime.getText()));
                admin.openSection(newSection);
            }
        }
        else if (e.getActionCommand().equals("View Class List"))
        {
            String [] courseCodes = new String [admin.getCourses().size()];
            int Ctr;
            for (Ctr = 0; Ctr < courseCodes.length; Ctr ++)
            {
                courseCodes [Ctr] = admin.getCourses().get(Ctr).getCourseCode();
            }
            reg1.removeAll();
            add(reg1, BorderLayout.CENTER);
            JPanel reg2 = new JPanel ();
            reg1.add(reg2);
            JPanel reg1a = new JPanel (new GridLayout (0,3,10,0));
            JLabel courseCode = new JLabel ("Course Code:");
            CourseCode = new JComboBox (courseCodes);
            CourseCode.setPreferredSize (new Dimension (130,20));
            chooseCourse = new JButton ("Choose Course");
            chooseCourse.addActionListener(this);
            reg2.add(reg1a);
            reg1a.add(courseCode);
            reg1a.add(CourseCode);
            reg1a.add(chooseCourse);
            reg1.updateUI ();
            reg1.setVisible(true);
        }
        else if (e.getActionCommand().equals("Choose Course"))
        {
            if (CourseCode.getSelectedItem() != null)
            {
                chooseCourse.setEnabled(false);
                String text = CourseCode.getSelectedItem().toString();
                int Ctr, Ctr2 = 0, Ctr3 = 0;
                for (Ctr = 0; Ctr < admin.getSections().size(); Ctr ++)
                {
                    if (admin.getSections().get(Ctr).getCourse().getCourseCode().equals(text))
                    {
                        Ctr2 ++;
                    }
                }
                String [] sectionNames = new String [Ctr2];
                for (Ctr = 0; Ctr < admin.getSections().size(); Ctr ++)
                {
                    if (admin.getSections().get(Ctr).getCourse().getCourseCode().equals(text))
                    {
                        sectionNames [Ctr3] = admin.getSections().get(Ctr).getName();
                        Ctr3 ++;
                    }
                }
                JPanel view3 = new JPanel (new GridLayout (0,3,10,0));
                JLabel sectionName = new JLabel ("Section Name:");
                SectionName = new JComboBox (sectionNames);
                SectionName.setPreferredSize (new Dimension (130,20));
                viewClass = new JButton ("View Section");
                viewClass.addActionListener(this);
                //reg1.add(view3);
                view3.add(sectionName);
                view3.add(SectionName);
                view3.add(viewClass);
                reg1.updateUI ();
            }
            else
            {
                MessageGUI alert = new MessageGUI ("Error", "No available courses!");
            }
        }
        else if (e.getActionCommand().equals("View Section"))
        {
            viewClass.setEnabled(false);
            if (SectionName.getSelectedItem() != null)
            {
                String section = SectionName.getSelectedItem().toString();
                int Ctr;
                for (Ctr = 0; Ctr < admin.getSections().size() && !(admin.getSections().get(Ctr).getName().equals(section)); Ctr ++);
                ArrayList <StudentAccount> listStudents = admin.getSections().get(Ctr).getStudents();
                String name;
                String [] students = new String [listStudents.size()];
                JPanel reg3 = new JPanel ();
                reg1.add (reg3, BorderLayout.SOUTH);
                JPanel classList = new JPanel (new GridLayout (0,2,0,10));
                JLabel studentNames = new JLabel ("Students:");
                JComboBox StudentList = new JComboBox (students);
                StudentList.setPreferredSize (new Dimension (200,20));
                StudentList.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
                JLabel sectionCapacity = new JLabel ("Capcity:     " + admin.getSections().get(Ctr).getCapacity());
                JLabel remainingSlots = new JLabel ("Remaining slots:     " + (admin.getSections().get(Ctr).getCapacity() - listStudents.size()));
                reg3.add(classList);
                classList.add(studentNames);
                classList.add(StudentList);
                classList.add(sectionCapacity);
                classList.add(remainingSlots);
                reg1.updateUI ();
            }
            else
            {
                MessageGUI alert = new MessageGUI ("Error", "No available sections!");
            }
        }
        else if (e.getActionCommand().equals("LOGOUT"))
        {
            this.dispose();
            LogInGUI logInApp = new LogInGUI (admin);
        }
    }
    public static void main (String [] args)
    {
    	AdministratorAccount admin = new AdministratorAccount();
    	AdminGUI app = new AdminGUI(admin);
    }
}