//Inoue, Yuta   Salva, Trisha
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class MainMenuBar extends JFrame implements ActionListener{
    
    private EnrollmentSystem es;
    private JMenuBar menu;
    private JMenu adminMenu, studentMenu;
    private JLabel accountName;
    private JMenuItem registerItem, editItem, addItem, openItem, viewItem, logoutItem, logoutItem2;
    private JMenuItem enlistItem, removeItem, enrollItem, eafItem;
    private JPanel registerPanel, editPanel, addPanel, openPanel, viewPanel, enlistPanel, removePanel, enrollPanel, viewEAFPanel, curPanel;
    
    public MainMenuBar(EnrollmentSystem es) {
        super("Machine Project");
        
        this.es = es;
        this.menu = new JMenuBar();
        this.curPanel = new JPanel(new BorderLayout());
        this.adminMenu = new JMenu("Admin");
        this.studentMenu = new JMenu("Student");
        this.registerItem = new JMenuItem("Register Student Account");
        registerItem.addActionListener(this);
        this.editItem = new JMenuItem("Edit Student Account");
        editItem.addActionListener(this);
        this.addItem = new JMenuItem("Add Course");
        addItem.addActionListener(this);
        this.openItem = new JMenuItem("Open Section");
        openItem.addActionListener(this);
        this.viewItem = new JMenuItem("View Class List");
        viewItem.addActionListener(this);
        this.enlistItem = new JMenuItem("Enlist In Section");
        enlistItem.addActionListener(this);
        this.removeItem = new JMenuItem("Remove Enlistment");
        removeItem.addActionListener(this);
        this.enrollItem = new JMenuItem("Enroll");
        enrollItem.addActionListener(this);
        this.eafItem = new JMenuItem("View EAF");
        eafItem.addActionListener(this);
        this.logoutItem = new JMenuItem("Logout");
        logoutItem.addActionListener(this);
        this.logoutItem2 = new JMenuItem("Logout");
        logoutItem2.addActionListener(this);
        adminMenu.add(registerItem);
        adminMenu.add(editItem);
        adminMenu.add(addItem);
        adminMenu.add(openItem);
        adminMenu.add(viewItem);
        adminMenu.add(logoutItem);
        studentMenu.add(enlistItem);
        studentMenu.add(removeItem);
        studentMenu.add(enrollItem);
        studentMenu.add(eafItem);
        studentMenu.add(logoutItem2);
        menu.add(adminMenu);
        menu.add(studentMenu);
        if(es.getAdmin().getIsLogin()){
            this.accountName = new JLabel("ADMIN");
            menu.add(accountName);
        }
        else if(es.getCurrentStudent().getIsLogin()){
            this.accountName = new JLabel(es.getCurrentStudent().getUserName());
            menu.add(accountName);
        }
        
        setDefaultCloseOperation (EXIT_ON_CLOSE);
        initScreen();
        setBounds(500, 500, 500, 500);
        setSize(280,95);
        setVisible (false);
    }
    
    public void initScreen(){
        JPanel p = new JPanel(new BorderLayout());
        
        //construct components
        p.add(menu);
        add(p,BorderLayout.NORTH);
        
        if(es.getAdmin().getIsLogin()){
            adminMenu.setEnabled(true);
            studentMenu.setEnabled(false);
            if(es.getStudents().isEmpty())
                editItem.setEnabled(false);
            else
                editItem.setEnabled(true);
            
            if(es.getCourses().isEmpty())
                openItem.setEnabled(false);
            else
                openItem.setEnabled(true);
            
            if(es.getSections().isEmpty())
                viewItem.setEnabled(false);
            else
                viewItem.setEnabled(true);
           
        }
        else if(es.getCurrentStudent().getIsLogin()){
            adminMenu.setEnabled(false);
            studentMenu.setEnabled(true);
            if(es.getCurrentStudent().getIsEnrolled()){
                enlistItem.setEnabled(false);
                removeItem.setEnabled(false);
                enrollItem.setEnabled(false);
                eafItem.setEnabled(true);
            }
            else{
                if(es.getCurrentStudent().getEnlists().isEmpty())
                    removeItem.setEnabled(false);
                else
                    removeItem.setEnabled(true);
                
                enlistItem.setEnabled(true);
                enrollItem.setEnabled(true);
                eafItem.setEnabled(false);
            }
        }

        //add components
        p.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Menu Panel"));
        p.setBackground(new Color(127,191,127));
        
        add(curPanel,BorderLayout.CENTER);

    }

    public JPanel makeRegister(){
        JPanel returnable = new JPanel(new FlowLayout());
        RegisterGUI reg = new RegisterGUI(es, editItem);
        reg.setVisible(false);
        returnable.add(reg.getContentPane());
        return returnable;
    }
    
    public JPanel makeEdit(){
        JPanel returnable = new JPanel(new FlowLayout());
        EditStudentGUI edit = new EditStudentGUI(es);
        edit.setVisible(false);
        returnable.add(edit.getContentPane());
        return returnable;
    }
    
    public JPanel makeAddCourse(){
        JPanel returnable = new JPanel(new FlowLayout());
        AddCourseGUI edit = new AddCourseGUI(es, openItem);
        edit.setVisible(false);
        returnable.add(edit.getContentPane());
        return returnable;
    }
    
    public JPanel makeOpen(){
        JPanel returnable = new JPanel(new FlowLayout());
        OpenSectionGUI open = new OpenSectionGUI(es, viewItem);
        open.setVisible(false);
        returnable.add(open.getContentPane());
        return returnable;
    }
    
    public JPanel makeEnlist(){
        JPanel returnable = new JPanel(new FlowLayout());
        EnlistGUI enlist = new EnlistGUI(es, removeItem);
        enlist.setVisible(false);
        returnable.add(enlist.getContentPane());
        return returnable;
    }
    
    public JPanel makeRemove(){
        JPanel returnable = new JPanel(new FlowLayout());
        RemoveEnlistGUI remove = new RemoveEnlistGUI(es, removeItem);
        remove.setVisible(false);
        returnable.add(remove.getContentPane());
        return returnable;
    }
    
    public JPanel makeViewClassList(){
        JPanel returnable = new JPanel(new FlowLayout());
        ViewClassListGUI viewClassList = new ViewClassListGUI(es);
        viewClassList.setVisible(false);
        returnable.add(viewClassList.getContentPane());
        return returnable;
    }
    
    public JPanel makeEnroll(){
        JPanel returnable = new JPanel(new FlowLayout());
        EnrollGUI en = new EnrollGUI(es, eafItem,  enlistItem, enrollItem, removeItem);
        en.setVisible(false);
        returnable.add(en.getContentPane());
        return returnable;
    }
    
    public JPanel makeViewEAF(){
        JPanel returnable = new JPanel(new FlowLayout());
        ViewEAFGUI eaf = new ViewEAFGUI(es);
        eaf.setVisible(false);
        returnable.add(eaf.getContentPane());
        return returnable;
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand().equals("Register Student Account")){
            curPanel.setVisible(false);
            registerPanel = makeRegister();
            curPanel = registerPanel;
            this.setSize(400,400);
            add(curPanel,BorderLayout.WEST);
        }
        if(e.getActionCommand().equals("Edit Student Account")){
            curPanel.setVisible(false);
            editPanel = makeEdit();
            curPanel = editPanel;
            this.setSize(370,400);
            add(curPanel,BorderLayout.WEST);
        }
        if(e.getActionCommand().equals("Add Course")){
            curPanel.setVisible(false);
            addPanel = makeAddCourse();
            curPanel = addPanel;
            this.setSize(445,300);
            add(curPanel,BorderLayout.WEST);
        }
        if(e.getActionCommand().equals("Open Section")){
            curPanel.setVisible(false);
            openPanel = makeOpen();
            curPanel = openPanel;
            this.setSize(390,480);
            add(curPanel,BorderLayout.WEST);
        }
        if(e.getActionCommand().equals("View Class List")){
            curPanel.setVisible(false);
            viewPanel = makeViewClassList();
            curPanel = viewPanel;
            this.setSize(340,300);
            add(curPanel,BorderLayout.WEST);
        }
        if(e.getActionCommand().equals("Enlist In Section")){
            curPanel.setVisible(false);
            enlistPanel = makeEnlist();
            curPanel = enlistPanel;
            this.setSize(360,360);
            add(curPanel,BorderLayout.WEST);
        }
        if(e.getActionCommand().equals("Remove Enlistment")){
            curPanel.setVisible(false);
            removePanel = makeRemove();
            curPanel = removePanel;
            this.setSize(360,360);
            add(curPanel,BorderLayout.WEST);
        }
        if(e.getActionCommand().equals("Enroll")){
            curPanel.setVisible(false);
            enrollPanel = makeEnroll();
            curPanel = enrollPanel;
            this.setSize(200,200);
            add(curPanel,BorderLayout.CENTER);
        }
        if(e.getActionCommand().equals("View EAF")){
            ViewEAFGUI eaf = new ViewEAFGUI(es);
            eaf.setVisible(true);
        }
        if(e.getActionCommand().equals("Logout")){
            LoginGUI login = new LoginGUI(es);
            es.logout();
            this.dispose();
        }
    }
    
}
