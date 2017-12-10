package EnrollmentSysMP;
// Lim, Ivana
// Tan, Nigel
//package EnrollmentSysMP;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.border.BevelBorder;

//import EnrollmentSysMP.StudentGUI;
import sun.audio.*;

public class LoginPage extends JFrame implements ActionListener
{
    StudentGUI studentApp;
    AdminGUI adminApp;
    Student student;
    Admin admin;
    JPanel pnl, jp, pane;
    JTextField username;
    JPasswordField password;
    JLabel lbl, lbl1, lbl2, lbl3;
    //ImageIcon icon = new ImageIcon("src/Chess/_yin_yang___zekrom_and_reshiram_by_hibiyoruchihiyro-d56hr85.png");
    JButton butn, btn;
    GridBagConstraints c = new GridBagConstraints();
    GridBagConstraints d = new GridBagConstraints();
    String ko, ok;
    
    public LoginPage(Admin admin)
    {
        super ("ANIMOSYS 2.0");
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        build();
        setSize(750, 500);
        setBounds(300,100,750,500);
        setVisible(true);
        this.admin = admin;
    }
    
    public void build()
    {
        pnl = new JPanel(new GridBagLayout());
        jp = new JPanel(new GridBagLayout());
        pane = new JPanel();
        
        JTextArea area = new JTextArea();
        pane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), ""));
        
        String str = "ENROLLMENT SYSTEM MP\n"
                + "TO....................: SHIRLEY CHU\n"
                + "FROM..............: NIGEL TAN, IVANA LIM\n"
                + "COURSE........: INTPRG2 S15A\n"
                + "WELCOM TO ANIMOSYS 2.0!!!!!!!!!!!!!!";
        area.setText(str);
        
        Font font = new Font("Serif", Font.BOLD, 15);
        area.setFont(font);
        
        pane.setBackground(Color.GREEN);
        area.setOpaque(false);
        area.setEditable(false);
        
        pane.add(area);
        d.gridx = 0;
        d.gridy = 0;
        pnl.add(pane, d);
        /*
        //butn = new JButton(icon);
        //btn.setOpaque(false);
        //butn.setContentAreaFilled(false);
        //butn.setBorderPainted(false);
        c.insets = new Insets(20, 20, 0, 20);
        c.gridx = 0;
        c.gridy = 0;
        jp.add(butn, c);
        butn.addActionListener(this);
        */
        JPanel forlbl = new JPanel();
        lbl = new JLabel("                                                                          ");
        c.gridx = 0;
        c.gridy = 1;
        forlbl.add(lbl);
        forlbl.setBackground(Color.GREEN.darker());
        jp.add(forlbl, c);
        
        jp.setBackground(Color.WHITE);
        
        
        lbl1 = new JLabel("USERNAME");
        lbl1.setHorizontalAlignment(JLabel.RIGHT);
        c.gridx = 0;
        c.gridy = 3;
        jp.add(lbl1, c);
        
        username = new JTextField(15);
        c.insets = new Insets(10, 10, 0, 0);
        c.gridx = 0;
        c.gridy = 4;
        jp.add(username, c);
        
        lbl2 = new JLabel("PASSWORD");
        c.gridx = 0;
        c.gridy = 5;
        jp.add(lbl2, c);
        
        password = new JPasswordField(15);
        c.insets = new Insets(10, 10, 0, 0);
        c.gridx = 0;
        c.gridy = 6;
        jp.add(password, c);
        
        btn = new JButton("LOGIN");
        btn.addActionListener(this);
        c.insets = new Insets(10, 10, 0, 0);
        c.gridx = 0;
        c.gridy = 7;
        jp.add(btn, c);
        
        jp.setBorder(BorderFactory.createSoftBevelBorder(BevelBorder.RAISED, Color.GRAY, Color.DARK_GRAY));
        pnl.setBackground(Color.GREEN);
        
        d.gridx = 0;
        d.gridy = 1;
        d.insets = new Insets(20, 20, 0, 20);
        pnl.add(jp, d);
        add(pnl);
        
        lbl3 = new JLabel();
        
        JRootPane rp = SwingUtilities.getRootPane(btn);
        rp.setDefaultButton(btn);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getActionCommand().equals("LOGIN") && (username.getText()).equals("admin")) 	// for admin
        {
        	if (username.getText().equals("admin") && (ok = password.getText()).equals("DLSU"))
			{
				btn = (JButton) e.getSource();
	            btn.setText("LOGOUT");
	            
	            adminApp = new AdminGUI(admin);
	            
                //System.out.println(admin.getCourses().get(0).getCode());
	            lbl3.setText("You have successfully logged in");
	            c.gridx = 0;
	            c.gridy = 2;
	            jp.add(lbl3, c);
			}
			else
			{
				InfoDialog info = new InfoDialog("AnimoSys 2.0", "Username and Password do not match.");
			}
            
        }
        else if (e.getActionCommand().equals("LOGOUT") && (username.getText()).equals("admin"))		// for admin
        {
            admin.saveAllCourses();
            admin.saveAllSections();
            admin.saveAllStudents();
            //admin.getAllStudents().clear();
            adminApp.dispose();
            btn = (JButton) e.getSource();
            btn.setText("LOGIN");
            lbl3.setText("You have successfully logged out");
            c.gridx = 0;
            c.gridy = 2;
            jp.add(lbl3, c);
        }
        else if (e.getActionCommand().equals("LOGIN"))	// for students
        {
            String user = username.getText(),
            		pw = password.getText();
            boolean wrongLogin = true;
            for(int i = 0; i < admin.getAllStudents().size(); i++)
            {
            	if(admin.getAllStudents().get(i).getID().equals(user) && admin.getAllStudents().get(i).getPW().equals(pw))
            	{
            		btn = (JButton) e.getSource();
                    btn.setText("LOGOUT");
                    
                    studentApp = new StudentGUI(admin.getAllStudents().get(i),admin);
                    lbl3.setText("You have successfully logged in");
                    c.gridx = 0;
                    c.gridy = 2;
                    jp.add(lbl3, c);
                    wrongLogin = false;
                    i = admin.getAllStudents().size();
            	}
            }
            if(wrongLogin)
            {
            	InfoDialog info = new InfoDialog("AnimoSys 2.0", "Username and Password do not match.");	// for students
            }
        	
        }
        else if (e.getActionCommand().equals("LOGOUT"))
        {
            admin.saveAllStudents();
            studentApp.dispose();
            btn = (JButton) e.getSource();
            btn.setText("LOGIN");
            lbl3.setText("You have successfully logged out");
            c.gridx = 0;
            c.gridy = 2;
            jp.add(lbl3, c);
        }
    }
}
