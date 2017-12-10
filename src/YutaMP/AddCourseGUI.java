//Inoue, Yuta   Salva, Trisha
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class AddCourseGUI extends JFrame implements ActionListener{
    
    private EnrollmentSystem es;
    private JLabel lblCode,lblName,lblUnits;
    private JComboBox unitBox;
    private JTextField txtCode,txtUnits;
    private JTextField txtName;
    private JButton addCourse;
    private JMenuItem openItem;
    
    public AddCourseGUI(EnrollmentSystem es, JMenuItem openItem){
        
        super("Machine Project");
        
        this.openItem = openItem;
        this.es = es;
        this.lblCode = new JLabel("Course Code: ");
        this.lblName = new JLabel("Course Name: ");
        this.lblUnits = new JLabel("Course Units: ");
        this.txtCode = new JTextField(25);
        String[] units = {"0.5", "1.0", "1.5", "2.0", "2.5", "3.0", "3.5", "4.0"};
        this.unitBox = new JComboBox(units);
        this.txtName = new JTextField(25);
        this.addCourse = new JButton("Add Course");
        addCourse.addActionListener(this);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initScreen();
        setSize(500,500);
        setVisible(false);
        
    }
    
    public void initScreen(){
        JPanel p = new JPanel(new GridBagLayout());
        
        GridBagConstraints con = new GridBagConstraints();
        con.anchor = GridBagConstraints.WEST;
        con.insets = new Insets(10, 10, 10, 10);
        
        con.gridx = 0;
        con.gridy = 0;
        p.add(this.lblCode, con);
        
        con.gridx = 1;
        p.add(txtCode, con);
        
        con.gridx = 0;
        con.gridy = 1;     
        p.add(lblName, con);
         
        con.gridx = 1;
        p.add(txtName, con);
        
        con.gridx = 0;
        con.gridy = 2;
        p.add(this.lblUnits, con);
        
        con.gridx = 1;
        p.add(unitBox, con);
        
        con.gridx = 0;
        con.gridy = 3;
        con.gridwidth = 2;
        con.anchor = GridBagConstraints.CENTER;
        p.add(addCourse, con);
        
        p.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Add Course Panel"));
        p.setBackground(new Color(127,191,127));
        add(p);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand().equals("Add Course")){
            if(txtCode.getText().isEmpty() || txtName.getText().isEmpty()){
                ErrorMSG er = new ErrorMSG(es);
                er.setVisible(true);
                er.dispose();
            }
            else{
                String code = txtCode.getText();
                String name = txtName.getText();
                double units = Double.parseDouble(unitBox.getSelectedItem().toString());
                Course c = new Course(code, name, units);
                if(es.addCourse(c)){
                    txtCode.setText("");txtName.setText("");unitBox.setSelectedIndex(0);
                    es.sectionWriter();
                    SuccessMSG su = new SuccessMSG(es);
                    su.setVisible(true);
                    su.dispose();
                    openItem.setEnabled(true);
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
