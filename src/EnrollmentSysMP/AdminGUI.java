package EnrollmentSysMP;
// Lim, Ivana
// Tan, Nigel
//package EnrollmentSysMP;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminGUI extends JFrame implements ActionListener
{
	private Admin admin;
	private JPanel pnlBody;
	private JComboBox cbCourses,
					  cbSections,
					  cbStudentIDs,
                      startHrs,
                      startMins,
                      endHrs,
                      endMins;
	private JTextField tfID,		// register student account text field vars
					   tfPW,
					   tfLN,
					   tfFN,
					   tfMin,
					   tfMax,
					   //tfEditID,	// edit student account vars
					   tfEditLN,
					   tfEditFN,
					   tfCourseCode,// add course vars
					   tfCouseName,
					   tfCourseUnits,
					   tfSectionName,	// open Section vars
					   tfFaculty,
					   tfDay,
					   tfCapacity;	
	private String tfStartTime, tfEndTime;
	private JButton btn,	// register student
					btnRegister,
					btnEdit,
					btnAddCourse,
					btnOpenSec,
					btnViewCourse,
					btnViewSection;
	private String hrs[] = new String[24];
    private String mins[] = new String[60];
    
	public AdminGUI(Admin admin)
	{
		super("Administrator Account");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		mainMenu();
		setSize(750, 500);
        setBounds(300,100,750,500);
		setVisible(true);
		this.admin = admin;
	}
	
	public void mainMenu()		// can still be changed to a combo box
	{
		JPanel pnlMainWest = new JPanel();
		add(pnlMainWest,BorderLayout.WEST);
		
		JPanel pnlOptions = new JPanel(new GridLayout(0,1,0,5));
		pnlMainWest.add(pnlOptions);
		
		JLabel lbl = new JLabel("Menu Options");
		lbl.setHorizontalAlignment(JLabel.CENTER);
		lbl.setFont(new Font("Impact", Font.PLAIN,20));
		pnlOptions.add(lbl);
		
		JButton btn = new JButton("Register Student");
		btn.addActionListener(this);
		pnlOptions.add(btn);
		
		btn = new JButton("Edit Student");
		btn.addActionListener(this);
		pnlOptions.add(btn);
		
		btn = new JButton("Add Course");
		btn.addActionListener(this);
		pnlOptions.add(btn);
		
		btn = new JButton("Open Section");
		btn.addActionListener(this);
		pnlOptions.add(btn);
		
		btn = new JButton("View Class List");
		btn.addActionListener(this);
		pnlOptions.add(btn);
		
		pnlBody = new JPanel();
		lbl = new JLabel("Welcome to AnimoSys 2.0!");
		lbl.setFont(new Font("Impact", Font.BOLD,36));
		pnlBody.add(lbl,BorderLayout.NORTH);
		lbl = new JLabel("ANIMO");
		lbl.setFont(new Font("Goudy Stout", Font.BOLD, 90));
		pnlBody.add(lbl,BorderLayout.CENTER);
		lbl = new JLabel("DLSU!!!");
		lbl.setFont(new Font("Algerian", Font.BOLD, 150));
		pnlBody.add(lbl,BorderLayout.SOUTH);
		pnlBody.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Home", 0, 0, new Font("Jokerman", Font.BOLD,20), Color.black));
		//pnlBody.setVisible(false);
		add(pnlBody,BorderLayout.CENTER);
	}
	
	public void registerStudentAccountPanel()	// register student account
	{
	    JPanel pnl;
	    JButton btn;
	    JLabel lbl;
	    JTextField tf;
	    GridBagConstraints c;
            
	    pnl = new JPanel(new GridBagLayout());
	    c = new GridBagConstraints();
	    
	    lbl = new JLabel("ID Number");
	    c.insets = new Insets(10, 10, 0, 0);
	    c.gridx = 0;
	    c.gridy = 0;
	    pnl.add(lbl, c);
	    
	    tfID = new JTextField(15);
	    c.insets = new Insets(10, 10, 0, 0);
	    c.gridx = 1;
	    c.gridy = 0;
	    pnl.add(tfID, c);
	    
	    lbl = new JLabel("Password");
	    c.insets = new Insets(10, 10, 0, 0);
	    c.gridx = 0;
	    c.gridy = 1;
	    pnl.add(lbl, c);
	    
	    tfPW = new JPasswordField(15);
	    c.insets = new Insets(10, 10, 0, 0);
	    c.gridx = 1;
	    c.gridy = 1;
	    pnl.add(tfPW, c);
	    
	    lbl = new JLabel("Last Name");
	    c.insets = new Insets(10, 10, 0, 0);
	    c.gridx = 0;
	    c.gridy = 2;
	    pnl.add(lbl, c);
	    
	    tfLN = new JTextField(15);
	    c.insets = new Insets(10, 10, 0, 0);
	    c.gridx = 1;
	    c.gridy = 2;
	    pnl.add(tfLN, c);
	    
	    lbl = new JLabel("First Name");
	    c.insets = new Insets(10, 10, 0, 0);
	    c.gridx = 0;
	    c.gridy = 3;
	    pnl.add(lbl, c);
	    
	    tfFN = new JTextField(15);
	    c.insets = new Insets(10, 10, 0, 0);
	    c.gridx = 1;
	    c.gridy = 3;
	    pnl.add(tfFN, c);
	    
	    lbl = new JLabel("Minimum Units");
	    c.insets = new Insets(10, 10, 0, 0);
	    c.gridx = 0;
	    c.gridy = 4;
	    pnl.add(lbl, c);
	    
	    tfMin = new JTextField(15);
	    c.insets = new Insets(10, 10, 0, 0);
	    c.gridx = 1;
	    c.gridy = 4;
	    pnl.add(tfMin, c);
	    
	    lbl = new JLabel("Maximum Units");
	    c.insets = new Insets(10, 10, 0, 0);
	    c.gridx = 0;
	    c.gridy = 5;
	    pnl.add(lbl, c);
	    
	    tfMax = new JTextField(15);
	    c.insets = new Insets(10, 10, 0, 0);
	    c.gridx = 1;
	    c.gridy = 5;
	    pnl.add(tfMax, c);
	    
	    btnRegister = new JButton("Register Student!");
	    btnRegister.addActionListener(this);
	    c.gridx = 1;
	    c.gridy = 6;
	    pnl.add(btnRegister, c);
	    
	    pnlBody.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Register Student Account", 0, 0, new Font("Jokerman", Font.BOLD,20), Color.black));
	    pnlBody.add(pnl);
	 }
	
	public void editStudentAccountPanel()	// edit student account
    {
        JPanel pnl;
        JButton btn;
        JLabel lbl;
        //JTextField tf;
        GridBagConstraints c;
        
        pnl = new JPanel(new GridBagLayout());
        c = new GridBagConstraints();
        /*
        lbl = new JLabel("Enter ID Number");
        c.insets = new Insets(10, 10, 0, 0);
        c.gridx = 0;
        c.gridy = 0;
        pnl.add(lbl, c);
        
        tfEditID = new JTextField(15);
        c.insets = new Insets(10, 10, 0, 0);
        c.gridx = 1;
        c.gridy = 0;
        pnl.add(tfEditID, c);
        */
        //admin.getVectorStudents()
        // COMBO BOX #######################################################################
        String [] IDnos = new String [admin.getAllStudents().size()];
        int i;
        for (i = 0; i < IDnos.length; i ++)
        {
            IDnos [i] = admin.getAllStudents().get(i).getID();
        }
        
        cbStudentIDs = new JComboBox(IDnos);
        // ##################################################################################
        JPanel cbpane = new JPanel();
        cbpane.add(cbStudentIDs);
        cbpane.setOpaque(false);
        cbStudentIDs.setPreferredSize(new Dimension(150, 35));
        cbStudentIDs.addActionListener(this);
        
        c.gridx = 1;
        c.gridy = 0;
        pnl.add(cbpane, c);
        
        lbl = new JLabel("New Last Name");
        c.insets = new Insets(10, 10, 0, 0);
        c.gridx = 0;
        c.gridy = 1;
        pnl.add(lbl, c);
        
        tfEditLN = new JTextField(15);
        c.insets = new Insets(10, 10, 0, 0);
        c.gridx = 1;
        c.gridy = 1;
        pnl.add(tfEditLN, c);
        
        lbl = new JLabel("New First Name");
        c.insets = new Insets(10, 10, 0, 0);
        c.gridx = 0;
        c.gridy = 2;
        pnl.add(lbl, c);
        
        tfEditFN = new JTextField(15);
        c.insets = new Insets(10, 10, 0, 0);
        c.gridx = 1;
        c.gridy = 2;
        pnl.add(tfEditFN, c);
        
        btnEdit = new JButton("Edit Student Account!");
        btnEdit.addActionListener(this);
        c.gridx = 1;
        c.gridy = 3;
        pnl.add(btnEdit, c);
        
        pnlBody.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Edit Student Account", 0, 0, new Font("Jokerman", Font.BOLD,20), Color.black));
	    pnlBody.add(pnl);
    }
	
	public void addCoursePanel()	// add course
    {
        JPanel pnl;
        JButton btn;
        JLabel lbl;
        //JTextField tf;
        GridBagConstraints c;
        
        pnl = new JPanel(new GridBagLayout());
        c = new GridBagConstraints();
        
        lbl = new JLabel("Course Code");
        c.insets = new Insets(10, 10, 0, 0);
        c.gridx = 0;
        c.gridy = 0;
        pnl.add(lbl, c);
        
        tfCourseCode = new JTextField(15);
        c.insets = new Insets(10, 10, 0, 0);
        c.gridx = 1;
        c.gridy = 0;
        pnl.add(tfCourseCode, c);
        
        lbl = new JLabel("Course Name");
        c.insets = new Insets(10, 10, 0, 0);
        c.gridx = 0;
        c.gridy = 1;
        pnl.add(lbl, c);
        
        tfCouseName = new JTextField(25);
        c.insets = new Insets(10, 10, 0, 0);
        c.gridx = 1;
        c.gridy = 1;
        pnl.add(tfCouseName, c);
        
        lbl = new JLabel("Number of Units");
        c.insets = new Insets(10, 10, 0, 0);
        c.gridx = 0;
        c.gridy = 2;
        pnl.add(lbl, c);
        
        tfCourseUnits = new JTextField(15);
        c.insets = new Insets(10, 10, 0, 0);
        c.gridx = 1;
        c.gridy = 2;
        pnl.add(tfCourseUnits, c);
        
        btnAddCourse = new JButton("Add Course!");
        btnAddCourse.addActionListener(this);
        c.insets = new Insets(10, 10, 0, 0);
        c.gridx = 1;
        c.gridy = 3;
        pnl.add(btnAddCourse, c);
        
        pnlBody.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Add a Course", 0, 0, new Font("Jokerman", Font.BOLD,20), Color.black));
	    pnlBody.add(pnl);
    }
	
	public void openSectionPanel()	// open section
    {
        for (int i = 0; i < hrs.length; i ++)
        {
            hrs[i] = "" + (i);
        }   
        
        for (int i = 0; i < mins.length; i ++)
        {
            mins[i] = "" + i;
        }     
        
        JPanel pnl;
        JButton btn;
        JLabel lbl;
        //JTextField tf;
        GridBagConstraints c;
        
        pnl = new JPanel(new GridBagLayout());
        c = new GridBagConstraints();
        
        lbl = new JLabel("Course");
        c.insets = new Insets(10, 10, 0, 0);
        c.gridx = 0;
        c.gridy = 0;
        pnl.add(lbl, c);
        
        // Combo box ###################################################################
        String [] strCourses = new String[admin.getCourses().size()];
		for (int i = 0; i < strCourses.length; i++) 
		{
			strCourses[i] = admin.getCourses().get(i).getCode();
		}
        cbCourses = new JComboBox(strCourses);
        //##############################################################################
        JPanel cbpane = new JPanel();
        cbpane.add(cbCourses);
        cbpane.setOpaque(false);
        cbCourses.setPreferredSize(new Dimension(150, 35));
        
        c.gridx = 1;
        c.gridy = 0;
        pnl.add(cbpane, c);
        
        lbl = new JLabel("Section Name");
        c.insets = new Insets(10, 10, 0, 0);
        c.gridx = 0;
        c.gridy = 1;
        pnl.add(lbl, c);
        
        tfSectionName = new JTextField(15);
        c.insets = new Insets(10, 10, 0, 0);
        c.gridx = 1;
        c.gridy = 1;
        pnl.add(tfSectionName, c);
        
        lbl = new JLabel("Faculty");
        c.insets = new Insets(10, 10, 0, 0);
        c.gridx = 0;
        c.gridy = 2;
        pnl.add(lbl, c);
        
        tfFaculty = new JTextField(15);
        c.insets = new Insets(10, 10, 0, 0);
        c.gridx = 1;
        c.gridy = 2;
        pnl.add(tfFaculty, c);
        
        lbl = new JLabel("Class Schedule");
        c.insets = new Insets(10, 10, 0, 0);
        c.gridx = 0;
        c.gridy = 3;
        pnl.add(lbl, c);
        
        tfDay = new JTextField(15);
        c.insets = new Insets(10, 10, 0, 0);
        c.gridx = 1;
        c.gridy = 3;
        pnl.add(tfDay, c);
        
        lbl = new JLabel("Hrs");
        c.insets = new Insets(10, 0, 0, 0);
        c.gridx = 1;
        c.gridy = 4;
        pnl.add(lbl, c);
        
        lbl = new JLabel("Mins");
        c.insets = new Insets(10, 10, 0, 0);
        c.gridx = 2;
        c.gridy = 4;
        pnl.add(lbl, c);
        
        lbl = new JLabel("Start Time");
        c.insets = new Insets(10, 10, 0, 0);
        c.gridx = 0;
        c.gridy = 5;
        pnl.add(lbl, c);
        
        startHrs = new JComboBox(hrs);
        //fStartTime = new JTextField(15);
        c.insets = new Insets(10, 10, 0, 0);
        c.gridx = 1;
        c.gridy = 5;
        pnl.add(startHrs, c);
        
        startMins = new JComboBox(mins);
        c.gridx = 2;
        c.gridy = 5;
        pnl.add(startMins, c);
        
        lbl = new JLabel("End Time");
        c.insets = new Insets(10, 10, 0, 0);
        c.gridx = 0;
        c.gridy = 6;
        pnl.add(lbl, c);
        
        endHrs = new JComboBox(hrs);
        //tfEndTime = new JTextField(15);
        c.insets = new Insets(10, 10, 0, 0);
        c.gridx = 1;
        c.gridy = 6;
        pnl.add(endHrs, c);
        
        endMins = new JComboBox(mins);
        c.gridx = 2;
        c.gridy = 6;
        pnl.add(endMins, c);
        
        lbl = new JLabel("Capacity");
        c.insets = new Insets(10, 10, 0, 0);
        c.gridx = 0;
        c.gridy = 7;
        pnl.add(lbl, c);
        
        tfCapacity = new JTextField(15);
        c.insets = new Insets(10, 10, 0, 0);
        c.gridx = 1;
        c.gridy = 7;
        pnl.add(tfCapacity, c);
        
        btnOpenSec = new JButton("Open Section!");
        btnOpenSec.addActionListener(this);
        c.gridx = 1;
        c.gridy = 8;
        pnl.add(btnOpenSec, c);
     
        pnlBody.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Open a Section", 0, 0, new Font("Jokerman", Font.BOLD,20), Color.black));
	    pnlBody.add(pnl);
    }
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getActionCommand().equals("Register Student"))
		{
			pnlBody.removeAll();
			
			registerStudentAccountPanel();
			
			pnlBody.updateUI();
			pnlBody.setVisible(true);
			
			add(pnlBody,BorderLayout.CENTER);
		}
		else if (e.getActionCommand().equals("Register Student!"))	// inside Register Student Account
		{
			try{
				if (tfID.getText().equals("") || tfPW.getText().equals("") || tfLN.getText().equals("") 
						|| tfFN.getText().equals("") || tfMin.getText().equals("") || tfMax.getText().equals(""))
				{
					InfoDialog info = new InfoDialog("Add Course", "Incomplete inputs.");
				}
				else
				{
					double minUnits = Double.parseDouble(tfMin.getText());
		    		double maxUnits = Double.parseDouble(tfMax.getText());
		    		admin.registerStudent(tfID.getText(), tfPW.getText(), tfLN.getText(), tfFN.getText(), minUnits, maxUnits);
		    		pnlBody.updateUI();
				}
			}
			catch(Exception exc)
			{
				InfoDialog info = new InfoDialog("Add Course", "Invalid inputs.");
			}
		}
		else if (e.getActionCommand().equals("Edit Student"))
		{
			pnlBody.removeAll();
			
			editStudentAccountPanel();
                        
			pnlBody.updateUI();
			pnlBody.setVisible(true);
			add(pnlBody,BorderLayout.CENTER);
		}
		else if(e.getActionCommand().equals("Edit Student Account!"))	// Edit Student! button
		{
			try{
				String s = cbStudentIDs.getSelectedItem().toString();
				if(s.equals("") || tfEditLN.getText().equals("") || tfEditFN.getText().equals(""))
				{
					InfoDialog info = new InfoDialog("Add Course", "Incomplete inputs.");
				}
				else
					admin.editStudent(s, tfEditLN.getText(), tfEditFN.getText());
			}
			catch(Exception exc)
			{
				InfoDialog info = new InfoDialog("Add Course", "Invalid inputs.");
			}
		}
		else if (e.getActionCommand().equals("Add Course"))
		{
			pnlBody.removeAll();
			
			addCoursePanel();
                        
			pnlBody.updateUI();
			pnlBody.setVisible(true);
			add(pnlBody,BorderLayout.CENTER);
		}
		else if(e.getActionCommand().equals("Add Course!"))
		{
			try{
				if (tfCourseCode.getText().equals("") || tfCouseName.getText().equals("") || tfCourseUnits.getText().equals(""))
				{
					InfoDialog info = new InfoDialog("Add Course", "Incomplete inputs.");
				}
				else
				{
					double courseUnits = Double.parseDouble(tfCourseUnits.getText());
		    		admin.addCourse(tfCourseCode.getText(), tfCouseName.getText(), courseUnits);
				}
			}
			catch(Exception exc)
			{
				InfoDialog info = new InfoDialog("Add Course", "Invalid inputs.");
			}
			
		}
		else if (e.getActionCommand().equals("Open Section"))
		{
			pnlBody.removeAll();
			
			openSectionPanel();
                        
			pnlBody.updateUI();
			pnlBody.setVisible(true);
			add(pnlBody,BorderLayout.CENTER);
		}
		
		else if(e.getActionCommand().equals("Open Section!"))
		{
			try{
				String strCourse = cbCourses.getSelectedItem().toString();
				if(strCourse.equals("") || tfSectionName.getText().equals("") || tfFaculty.getText().equals("") || tfDay.getText().equals("")
						|| tfCapacity.getText().equals(""))
				{
					InfoDialog info = new InfoDialog("Add Course", "Incomplete inputs.");
				}
				else
				{
					Course c = null;
					int i;
					for(i = 0; i < admin.getCourses().size(); i++)
					{
						if (admin.getCourses().get(i).getCode().equals(strCourse))
						{
							c = admin.getCourses().get(i);
						}
					}
					
	                tfStartTime = startHrs.getSelectedItem().toString() + startMins.getSelectedItem().toString();
	                tfEndTime = endHrs.getSelectedItem().toString() + endMins.getSelectedItem().toString();
					int startTime = Integer.parseInt(tfStartTime);
					if(Integer.parseInt(startMins.getSelectedItem().toString()) == 0)
					{
						startTime *= 10;
					}
						
		    		int endTime = Integer.parseInt(tfEndTime);
		    		if(Integer.parseInt(endMins.getSelectedItem().toString()) == 0)
		    		{
		    			endTime *= 10;
		    		}
						
		    		int nCapacity = Integer.parseInt(tfCapacity.getText());
		    		admin.openSection(c, tfSectionName.getText(), tfFaculty.getText(), tfDay.getText(), startTime, endTime, nCapacity);
					pnlBody.updateUI();
				}
			}
			catch(Exception exc)
			{
				InfoDialog info = new InfoDialog("Add Course", "Invalid inputs.");
			}
			
		}
		else if (e.getActionCommand().equals("View Class List"))
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
			
			btnViewCourse = new JButton("Select Course");
			btnViewCourse.addActionListener(this);
			pnlTwo.add(btnViewCourse);
			
			pnlOne.add(pnlTwo);
			pnlBody.add(pnlOne);
			pnlBody.updateUI();
			pnlBody.setVisible(true);
			add(pnlBody,BorderLayout.CENTER);
			
			pnlBody.updateUI();
			pnlBody.setVisible(true);
            pnlBody.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "View Class List", 0, 0, new Font("Jokerman", Font.BOLD,20), Color.black));
			add(pnlBody,BorderLayout.CENTER);
                        
		}
		
		else if (e.getActionCommand().equals("Select Course"))	// inside Enlist Section
		{
			if (cbCourses.getSelectedItem() == null)
			{
				InfoDialog info = new InfoDialog("View Class List", "No Course Selected.");
			}
			else
			{
				btnViewCourse.setEnabled(false);
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
				
				btnViewSection = new JButton("Select Section");
				btnViewSection.addActionListener(this);
				pnlTwo.add(btnViewSection);
				
				pnlBody.add(pnlTwo);
				pnlBody.updateUI();
				
			}
		}
		
		else if(e.getActionCommand().equals("Select Section"))
		{
			if (cbSections.getSelectedItem() == null)
			{
				InfoDialog info = new InfoDialog("View Class List", "No Section Selected.");
			}
			else
			{
				btnViewSection.setEnabled(false);
				JPanel pnlTwo = new JPanel(new GridLayout(5, 3, 10, 10));
				JLabel lbl = new JLabel("Students");
				pnlTwo.add(lbl);
				
				// Combo ########################################################################################
				String strSection = cbSections.getSelectedItem().toString();
				String[] strStudents = null;
				Section s = null;
				int i = 0;
				for (i = 0; i < admin.getCourses().size(); i++)
				{
					if (cbCourses.getSelectedItem().toString().equals(admin.getCourses().get(i).getCode()))
					{
						int j;
						for(j = 0; j < admin.getCourses().get(i).getSections().size(); j++)
						{
							if (strSection.equals(admin.getCourses().get(i).getSections().get(j).getName()))
							{
								s = admin.getCourses().get(i).getSections().get(j);
								strStudents = new String[admin.getCourses().get(i).getSections().get(j).getStudents().size()];
								for(int k = 0; k < strStudents.length; k++)
									strStudents[k] = admin.getCourses().get(i).getSections().get(j).getStudents().get(k).getID();
							}
						}
					}
					
				}
				//########################################################################################
				
				cbStudentIDs = new JComboBox(strStudents);
				cbStudentIDs.setPreferredSize(new Dimension(150,25));
				pnlTwo.add(cbStudentIDs);
				
				lbl = new JLabel("Total number of slots (Capacity): ");
				pnlTwo.add(lbl);
				
				JTextField tf = new JTextField(s.getCapacity()+"", 5);
				tf.setEditable(false);
				pnlTwo.add(tf);
				
				lbl = new JLabel("Number of slots remaining: ");
				pnlTwo.add(lbl);
				
				tf = new JTextField(s.getCapacity()-s.getStudents().size()+"", 5);
				tf.setEditable(false);
				pnlTwo.add(tf);
				
				pnlBody.add(pnlTwo);
				pnlBody.updateUI();
			}
		}
	}
	/*public static void main(String [] args)
	{
		Admin admin = new Admin();
		AdminGUI app = new AdminGUI(admin);
	}*/
}
