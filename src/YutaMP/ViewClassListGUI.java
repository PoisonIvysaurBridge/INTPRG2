//Inoue, Yuta   Salva, Trisha
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
public class ViewClassListGUI extends JFrame implements ActionListener{
    
    private EnrollmentSystem es;
    private JLabel lblCourse;
    private JComboBox courseBox;
    private JLabel lblSection;
    private JComboBox sectionBox;
    private JButton select;
    private JTextArea txtInformation;

    public ViewClassListGUI(EnrollmentSystem es) {
        super("Machine Project");
        
        this.es = es;
        lblCourse = new JLabel("Course: ");
        this.courseBox = new JComboBox<>(es.getCoursesVector());
        lblSection = new JLabel("Section: ");
        this.sectionBox = new JComboBox<>(es.getSectionsVector());
        txtInformation = new JTextArea();
        txtInformation.setEditable(false);
        txtInformation.setOpaque(false);
        select = new JButton("Select");
        select.addActionListener(this);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initScreen();
        setSize(500,350);
        setVisible(false);
    }
    
    public void initScreen(){
        JPanel p = new JPanel(new GridBagLayout());
        JPanel p2 = new JPanel(new GridBagLayout());
        JPanel whole= new JPanel(new BorderLayout());
        GridBagConstraints con = new GridBagConstraints();
        con.anchor = GridBagConstraints.WEST;
        con.insets = new Insets(10, 10, 10, 10);
        
        con.gridx = 0;
        con.gridy = 0;
        p.add(lblSection, con);
        con.gridx = 1;
        p.add(sectionBox, con);
        
        con.gridx = 2;
        p.add(select, con);
        whole.add(p, BorderLayout.NORTH);
        
        con.gridx = 0;
        con.gridy = 0;
        p2.add(txtInformation, con);
        whole.add(p2, BorderLayout.CENTER);
        whole.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "View Class List Panel"));
        p2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Information"));
        this.setBackground(new Color(127,191,127));
        p.setBackground(new Color(127,191,127));
        whole.setBackground(new Color(127,191,127));
        
        add(whole);
    }
     @Override
    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand().equals("Select")){
            Section s = (Section)sectionBox.getSelectedItem();
            String info = es.viewClassList(s);
            txtInformation.setText(info);
        }
        
        
    }
    
}


