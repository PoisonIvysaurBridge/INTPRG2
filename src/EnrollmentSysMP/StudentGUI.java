package EnrollmentSysMP;
// Lim, Ivana
// Tan, Nigel
//package EnrollmentSysMP;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentGUI extends JFrame implements ActionListener
{
	private Student student;
	private Admin admin;
	private JPanel pnlBody;
	private JComboBox cbCourses,
					  cbSections;
	private JButton btnEnlistChooseCourse;
	
	public StudentGUI(Student student, Admin admin)
	{
		super("Student Account");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		mainMenu();
		setSize(750, 500);
        setBounds(300,100,750,500);
        setVisible(true);
        this.student = student;
        this.admin = admin;
	}
	
	public void mainMenu()
	{
		JPanel pnlMainWest = new JPanel();
		add(pnlMainWest,BorderLayout.NORTH);
		
		JPanel pnlOptions = new JPanel(new GridLayout(1,1,5,5));
		pnlMainWest.add(pnlOptions);
		
		JButton btn = new JButton("Enlist Section");
		btn.addActionListener(this);
		pnlOptions.add(btn);
		
		btn = new JButton("Remove Enlistment");
		btn.addActionListener(this);
		pnlOptions.add(btn);
		
		btn = new JButton("Enroll");
		btn.addActionListener(this);
		pnlOptions.add(btn);
		
		btn = new JButton("View EAF");
		btn.addActionListener(this);
		pnlOptions.add(btn);
		
		pnlBody = new JPanel();
		pnlBody.setVisible(false);
		//JLabel lbl = new JLabel("this is a test label");
		//pnlBody.add(lbl);
		add(pnlBody,BorderLayout.CENTER);
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getActionCommand().equals("Enlist Section"))
		{
			pnlBody.removeAll();
			JPanel pnlOne = new JPanel();
			
			JPanel pnlTwo = new JPanel(new GridLayout(0, 3, 10, 10));
			JLabel lbl = new JLabel("Course ");
			pnlTwo.add(lbl);
			
			//  Combo Box Items ############################################
			String [] strCourses = new String[admin.getCourses().size()];
			for (int i = 0; i < strCourses.length; i++) {strCourses[i] = admin.getCourses().get(i).getCode();}
			cbCourses = new JComboBox(strCourses);
			cbCourses.setPreferredSize(new Dimension(150,25));
			pnlTwo.add(cbCourses);
			//##############################################################
			
			btnEnlistChooseCourse = new JButton("Select Course");
			btnEnlistChooseCourse.addActionListener(this);
			pnlTwo.add(btnEnlistChooseCourse);
			
			pnlOne.add(pnlTwo);
			pnlBody.add(pnlOne);
			pnlBody.updateUI();
			pnlBody.setVisible(true);
			add(pnlBody,BorderLayout.CENTER);
		}
		else if (e.getActionCommand().equals("Select Course"))	// inside Enlist Section
		{
			if (cbCourses.getSelectedItem() == null)
			{
				InfoDialog info = new InfoDialog("Enlist Section", "No Course to select.");
			}
			else
			{
				btnEnlistChooseCourse.setEnabled(false);
				JPanel pnlTwo = new JPanel(new GridLayout(0, 3, 10, 10));
				JLabel lbl = new JLabel("Section");
				pnlTwo.add(lbl);
				
				// Combo ########################################################################################
				String strCourse = cbCourses.getSelectedItem().toString();
				int i = 0;
				for (i = 0; i < admin.getCourses().size() && !admin.getCourses().get(i).getCode().equals(strCourse); i++);
				
				String [] strSections = new String[admin.getCourses().get(i).getSections().size()];
				
				for(int j = 0; j < strSections.length; j++)
				{
					strSections[j] = admin.getCourses().get(i).getSections().get(j).getName();
				}//########################################################################################
				
				cbSections = new JComboBox(strSections);
				cbSections.setPreferredSize(new Dimension(150,25));
				pnlTwo.add(cbSections);
				
				JButton btnEnlist = new JButton("Enlist!");
				btnEnlist.addActionListener(this);
				pnlTwo.add(btnEnlist);
				
				pnlBody.add(pnlTwo);
				pnlBody.updateUI();
				
			}
		}
		else if (e.getActionCommand().equals("Enlist!"))	// inside Enlist Section
		{
			
			if (cbSections.getSelectedItem() == null)
			{
				InfoDialog info = new InfoDialog("Remove Enlistment", "No Section to select");
			}
			else
			{
				String strSection = cbSections.getSelectedItem().toString();
				String strCourse = cbCourses.getSelectedItem().toString();
				Section s = null;
				int i;
				for(i = 0; i < admin.getCourses().size(); i++)
				{
					if (admin.getCourses().get(i).getCode().equals(strCourse))
					{
						int j;
						for(j = 0; j < admin.getCourses().get(i).getSections().size(); j++)
						{
							if ( admin.getCourses().get(i).getSections().get(j).getName().equals(strSection))
								s = admin.getCourses().get(i).getSections().get(j);
						}
					}
					
					
				}
				//Section s = (Section)cbSections.getSelectedItem();
				student.enlistSection(s);
			}
			
		}
		else if (e.getActionCommand().equals("Remove Enlistment"))
		{
			pnlBody.removeAll();
			JPanel pnlOne = new JPanel();
			pnlBody.add(pnlOne);
			
			JLabel lbl = new JLabel("Course ");
			pnlOne.add(lbl);
			
			//  Combo Box Items ############################################
			String [] strCourses = new String[student.getEnlistedSections().size()];
			for (int i = 0; i < strCourses.length; i++) {strCourses[i] = student.getEnlistedSections().get(i).getCourse().getCode();}
			cbCourses = new JComboBox(strCourses);
			cbCourses.setPreferredSize(new Dimension(150,25));
			pnlOne.add(cbCourses);
			//##############################################################
			
			JButton btn = new JButton("Remove course enlistment");
			btn.addActionListener(this);
			pnlOne.add(btn);
			
			if (strCourses.equals(""))
				btn.setEnabled(false);
			
			pnlBody.add(pnlOne);
			pnlBody.setVisible(true);
			pnlBody.updateUI();
		}
		else if(e.getActionCommand().equals("Remove course enlistment"))	// Inside Remove Enlistment
		{
			
			if (cbCourses.getSelectedItem() == null)
			{
				InfoDialog info = new InfoDialog("Remove Enlistment", "No Course to select");
			}
			else
			{
				String strCourse = cbCourses.getSelectedItem().toString();
				Course c = null;
				int i;
				for(i = 0; i < student.getEnlistedSections().size(); i++)
				{
					if (student.getEnlistedSections().get(i).getCourse().getCode().equals(strCourse))
					{
						c = student.getEnlistedSections().get(i).getCourse();
					}
				}
				student.removeEnlistment(c);
				pnlBody.updateUI();
			}
			
		}
		else if (e.getActionCommand().equals("Enroll"))
		{
			pnlBody.removeAll();
			JPanel pnlOne = new JPanel();
			pnlBody.add(pnlOne);
			
			JLabel lbl = new JLabel("Courses enlisted ");
			pnlOne.add(lbl);
			
			//  Combo Box Items ############################################
			String [] strCourses = new String[student.getEnlistedSections().size()];
			for (int i = 0; i < strCourses.length; i++) {strCourses[i] = student.getEnlistedSections().get(i).getCourse().getCode();}
			cbCourses = new JComboBox(strCourses);
			cbCourses.setPreferredSize(new Dimension(150,25));
			pnlOne.add(cbCourses);
			//##############################################################
			
			JButton btn = new JButton("Enroll!");
			if (strCourses.equals(""))
				btn.setEnabled(false);
			btn.addActionListener(this);
			pnlOne.add(btn);
			
			pnlBody.add(pnlOne);
			pnlBody.setVisible(true);
			pnlBody.updateUI();
			pnlBody.updateUI();
		}
		else if(e.getActionCommand().equals("Enroll!"))
		{
			student.enroll();
			if (student.isEnrolled())
				admin.saveEnrolledStudents();
			pnlBody.updateUI();
		}
		else if (e.getActionCommand().equals("View EAF"))
		{
	        if (student.isEnrolled())
	        {
				pnlBody.removeAll();
				student.viewEAF();
				
				JPanel pnl = new JPanel(new BorderLayout());
				
				String str = "NAME: " + student.getLN().toUpperCase() + ", " + student.getFN().toUpperCase();
				str += "\nID NUMBER: " + student.getID();
				
				JTextArea area = new JTextArea(str);
				area.setOpaque(false);
				area.setEditable(false);
				
				pnl.add(area, BorderLayout.NORTH);
				
	            String[] columnNames = { "CODE", "COURSE NAME", "SECTION", "TEACHER", "SCHEDULE", "UNITS" };
				
	            JTable table = new JTable(student.data, columnNames);
	            JScrollPane sp = new JScrollPane(table);
	            
	            table.getColumnModel().getColumn(0).setPreferredWidth(125);
	            table.getColumnModel().getColumn(1).setPreferredWidth(240);
	            table.getColumnModel().getColumn(4).setPreferredWidth(90);
	            
	            table.setEnabled(false);
	            table.setOpaque(false);
	            sp.setPreferredSize(new Dimension(700, 200));
	            
	            sp.setOpaque(false);
	            sp.getViewport().setOpaque(false);
	
	            pnl.add(sp);
	            
	            JLabel lbl = new JLabel("TOTAL UNITS: " + student.units);
	            lbl.setHorizontalAlignment(JLabel.RIGHT);
	            
	            pnl.add(lbl, BorderLayout.SOUTH);
	            
	            pnlBody.add(pnl);
	            pnlBody.setVisible(true);
				pnlBody.updateUI();
            }
            else
            {
                InfoDialog info = new InfoDialog("View EAF", "Student has not enrolled yet.");
            }
		}
		
	}
	
/*	public static void main(String [] args)
	{
		//Student student = new Student("114",);
		Admin admin = new Admin();
		admin.addCourse("INTPRG2", "OBJECT-BASED PROGRAMMING IN JAVA", 3);
		admin.addCourse("ARCHOS1", "COMPUTER ARCHITECTURE", 3);
		Course intprg2 = admin.getCourses().get(0);
		Course archos = admin.getCourses().get(1);
		admin.openSection(intprg2, "S15", "ms shirley", "TH", 1100, 1230, 20);
		admin.openSection(intprg2, "S16", "ms shirley", "TH", 915, 1045, 20);
		admin.openSection(archos, "S15", "sir roger", "TH", 1100, 1230, 20);
		admin.openSection(archos, "S16", "sir roger", "TH", 915, 1045, 20);
		
		admin.registerStudent("11407530", "lalala", "Lim", "IVana", 3, 18);
		admin.registerStudent("11500000", "lalala", "Tan", "Nigel", 12, 18);
		admin.registerStudent("11500001", "lalala", "Inoue", "Yuta", 12, 18);
		
		Student ivy = admin.getAllStudents().get(0);
		Student nigel = admin.getAllStudents().get(1);
		Student yuta = admin.getAllStudents().get(2);
		StudentGUI app = new StudentGUI(ivy,admin);
				
	}*/
}
