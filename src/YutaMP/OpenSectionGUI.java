//Inoue, Yuta   Salva, Trisha
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class OpenSectionGUI extends JFrame implements ActionListener{
    
    private EnrollmentSystem es;
    private String[] hh, mm;
    private JComboBox<Course> courseOption;//<Course>
    private JLabel lblSecName, lblFaculty, lblSched, lblStart, lblEnd, lblCaps;
    private JTextField txtSecName, txtFaculty, txtSched, txtStart, txtEnd, txtCaps;
    private JComboBox<String> scheduleBox, hourBox1, minBox1, hourBox2, minBox2;
    private JButton select, open;
    private JMenuItem viewItem;
    
    public OpenSectionGUI(EnrollmentSystem es, JMenuItem viewItem){
        super("Machine Project");
        
        this.viewItem = viewItem;
        this.es = es;
        this.hh = new String[23];
        for(int i = 0; i < 23; i++){
            hh[i] = Integer.toString(i + 1);
        }
        this.mm = new String[60];
        for(int i = 0; i < 60; i++){
            if(i < 10)
                mm[i] = "0" + Integer.toString(i);
            else{
                mm[i] = Integer.toString(i);
            }
        }
        this.hourBox1 = new JComboBox<>(hh);
        this.minBox1 = new JComboBox<>(mm);
        this.hourBox2 = new JComboBox<>(hh);
        this.minBox2 = new JComboBox<>(mm);
        this.courseOption = new JComboBox<>(es.getCoursesVector());
        this.lblSecName = new JLabel("Section Name: ");
        this.lblFaculty = new JLabel("Faculty: ");
        this.lblSched = new JLabel("Schedule: ");
        this.lblStart = new JLabel("Start Time: ");
        this.lblEnd = new JLabel("End Time: ");
        this.lblCaps = new JLabel("Capacity: ");
        this.txtSecName = new JTextField();
        txtSecName.setColumns(20);
        this.txtFaculty = new JTextField();
        txtFaculty.setColumns(20);
        this.scheduleBox = new JComboBox<>();
        scheduleBox.addItem("MW");
        scheduleBox.addItem("TH");
        this.txtSched = new JTextField();
        txtSched.setColumns(6);
        this.txtCaps = new JTextField();
        txtCaps.setColumns(6);
        this.open = new JButton("Open Section");
        open.addActionListener(this);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new GridBagLayout());
        initScreen();
        setSize(500,450);
        setVisible(false);
    }
    
    public void initScreen(){
        JPanel p = new JPanel(new GridBagLayout());
        JPanel p2 = new JPanel(new FlowLayout());
        JPanel p3 = new JPanel(new FlowLayout());
        GridBagConstraints con = new GridBagConstraints();
        con.insets = new Insets(10, 10, 10, 10);
        con.anchor = GridBagConstraints.EAST;
        con.gridx = 0;
        con.gridy = 0;
        p.add(new JLabel("Course: "), con);
        con.gridx = 1;
        con.anchor = GridBagConstraints.WEST;
        p.add(courseOption, con);
        
        con.gridx = 0;
        con.gridy = 1;
        con.anchor = GridBagConstraints.EAST;
        p.add(lblSecName, con);
        con.gridx = 1;
        p.add(txtSecName, con);
        
        con.gridx = 0;
        con.gridy = 2;
        p.add(lblFaculty, con);
        con.gridx = 1;
        p.add(txtFaculty, con);
        
        con.gridx = 0;
        con.gridy = 3;
        p.add(lblSched, con);
        con.gridx = 1;
        con.anchor = GridBagConstraints.WEST;
        p.add(scheduleBox, con);
        
        con.gridx = 0;
        con.gridy = 4;
        con.anchor = GridBagConstraints.EAST;
        p.add(lblStart, con);
        p2.add(hourBox1);
        p2.add(new JLabel(":"));
        p2.add(minBox1);
        con.gridx = 1;
        con.anchor = GridBagConstraints.WEST;
        p.add(p2,con);
        
        
        con.gridx = 0;
        con.gridy = 5;
        con.anchor = GridBagConstraints.EAST;
        p.add(lblEnd, con);
        p3.add(hourBox2);
        p3.add(new JLabel(":"));
        p3.add(minBox2);
        con.gridx = 1;
        con.anchor = GridBagConstraints.WEST;
        p.add(p3,con);
          
        
        con.anchor = GridBagConstraints.EAST;
        con.gridx = 0;
        con.gridy = 6;
        p.add(lblCaps, con);
        con.gridx = 1;
        con.anchor = GridBagConstraints.WEST;
        p.add(txtCaps, con);
        
        con.gridx = 0;
        con.gridy = 7;
        con.gridwidth = 6;
        con.anchor = GridBagConstraints.CENTER;
        p.add(open, con);
        
        p.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Open Section Panel"));
        p.setBackground(new Color(127,191,127));
        p2.setBackground(new Color(127,191,127));
        p3.setBackground(new Color(127,191,127));
        
        add(p);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        Section s;
        Course c;
        String name, faculty, schedule, start, end;
        int caps;
        if(e.getActionCommand().equals("Open Section")){
            if(txtSecName.getText().isEmpty() || txtFaculty.getText().isEmpty() || txtCaps.getText().isEmpty()){    
                ErrorMSG er = new ErrorMSG(es);
                er.setVisible(true);
                er.dispose();
            }
            if(!txtCaps.getText().matches("[0-9]+$")/* || !txtFaculty.getText().matches("[A-Za-z]+$")*/){
                ErrorMSG er = new ErrorMSG(es);
                er.setVisible(true);
                er.dispose();
            }
                
            else{
                name = txtSecName.getText();
                faculty = txtFaculty.getText();
                schedule = scheduleBox.getSelectedItem().toString();
                start = hourBox1.getSelectedItem().toString() + ":" + minBox1.getSelectedItem().toString();
                end = hourBox2.getSelectedItem().toString() + ":" + minBox2.getSelectedItem().toString();
                caps = Integer.parseInt(txtCaps.getText());
                c = (Course)courseOption.getSelectedItem();
                s = new Section(name, faculty, schedule, start, end, caps);
                
                if(es.openSection(c, s)){
                    txtSecName.setText("");txtFaculty.setText("");txtSched.setText("");txtCaps.setText("");
                    hourBox1.setSelectedIndex(0);
                    hourBox2.setSelectedIndex(0);
                    minBox1.setSelectedIndex(0);
                    minBox2.setSelectedIndex(0);
                    SuccessMSG su = new SuccessMSG(es);
                    su.setVisible(true);
                    su.dispose();
                    viewItem.setEnabled(true);
                }
                else{
                    ErrorMSG er = new ErrorMSG(es);
                    er.setVisible(true);
                    er.dispose();
                }
            }
        }
    }
}
