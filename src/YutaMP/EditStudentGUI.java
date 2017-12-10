//Inoue, Yuta   Salva, Trisha
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class EditStudentGUI extends JFrame implements ActionListener{
    
    private EnrollmentSystem es;
    private JComboBox<Student> studentCombo;
    private JLabel lblUsername, lblFirstName, lblLastName;
    private JTextField txtUsername, txtFirstName, txtLastName;
    private JTextArea txtInfromation;
    private JButton edit;
    private JButton select;
    
    public EditStudentGUI(EnrollmentSystem es){
        super("Machine Project");
        
        this.es = es;
        lblUsername = new JLabel("Username: ");
        this.studentCombo = new JComboBox<>(es.getStudentsVector());
        lblFirstName = new JLabel("First Name: ");
        lblLastName = new JLabel("Last Name: ");
        txtUsername = new JTextField();
        txtUsername.setColumns(20);
        txtFirstName = new JTextField();
        txtFirstName.setColumns(20);
        txtLastName = new JTextField();
        txtLastName.setColumns(20);
        txtInfromation = new JTextArea();
        txtInfromation.setEditable(false);
        txtInfromation.setOpaque(false);
        edit = new JButton("Edit Student");
        edit.addActionListener(this);
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
        JPanel p3 = new JPanel(new GridBagLayout());
        JPanel whole= new JPanel(new BorderLayout());
        GridBagConstraints con = new GridBagConstraints();
        con.anchor = GridBagConstraints.WEST;
        con.insets = new Insets(10, 10, 10, 10);
        
        con.gridx = 0;
        con.gridy = 0;
        p.add(lblUsername, con);
        con.gridx = 1;
        p.add(studentCombo, con);
        con.gridx = 2;
        p.add(select, con);
        whole.add(p, BorderLayout.NORTH);
        
        con.gridx = 0;
        con.gridy = 0;
        p2.add(txtInfromation, con);
        whole.add(p2, BorderLayout.CENTER);
        p2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Information Panel"));
        
        
        con.gridx = 0;
        con.gridy = 0;
        p3.add(lblFirstName, con);
        
        con.gridx = 1;
        p3.add(txtFirstName, con);
        
        con.gridx = 0;
        con.gridy = 1;
        p3.add(lblLastName, con);
        
        con.gridx = 1;
        p3.add(txtLastName, con);
        
        p3.add(edit, con);
        whole.add(p3, BorderLayout.SOUTH);
        
        con.gridx = 0;
        con.gridy = 2;
        con.gridwidth = 3;
        con.anchor = GridBagConstraints.CENTER;
        p3.add(edit, con);
        
        whole.add(p3, BorderLayout.SOUTH);
        whole.add(p2, BorderLayout.CENTER);
        
        whole.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Edit Student Panel"));
        this.setBackground(new Color(127,191,127));
        whole.setBackground(new Color(127,191,127));
        p.setBackground(new Color(127,191,127));
        p3.setBackground(new Color(127,191,127));
        
        add(whole);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        String firstName, lastName;
        if(e.getActionCommand().equals("Select")){
            Student check = (Student)studentCombo.getSelectedItem();
            String info = "Student Name: " + check.getFullName() + "\n"
                          + "Minimum Units: " + check.getMin() + "\n"
                          + "Maximum Units: " + check.getMax();
            txtInfromation.setText(info);
        }
        if(e.getActionCommand().equals(edit.getText())){
            if(txtFirstName.getText().isEmpty() || txtLastName.getText().isEmpty()){
                ErrorMSG er = new ErrorMSG(es);
                er.setVisible(true);
                er.dispose();
            }
            else if(!txtFirstName.getText().matches("[A-Za-z]*$") || !txtLastName.getText().matches("[A-Za-z]*$")){
                ErrorMSG er = new ErrorMSG(es);
                er.setVisible(true);
                er.dispose();
            }
            else{
                Student student = (Student)studentCombo.getSelectedItem();
                firstName = txtFirstName.getText();
                lastName = txtLastName.getText();
                student.setFirstName(firstName);
                student.setLastName(lastName);
                es.studentListWriter();
                this.txtFirstName.setText("");this.txtLastName.setText("");this.txtInfromation.setText("");
                SuccessMSG msg = new SuccessMSG(es);
                msg.setVisible(true);
                msg.dispose();
            }
        }
        
    }
}
