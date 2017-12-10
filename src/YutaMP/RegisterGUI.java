//Inoue, Yuta   Salva, Trisha
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RegisterGUI extends JFrame implements ActionListener{
    
    private EnrollmentSystem es;
    private JLabel lblUser, lblPassword, lblFirst, lblLast, lblMin, lblMax;
    private JTextField txtUser, txtFirst, txtLast, txtMin, txtMax;
    private JPasswordField txtPassword;
    private JButton register;
    private String username, password, firstName, lastName;
    private double minUnits, maxUnits;
    private JMenuItem editItem;
    
    public RegisterGUI(EnrollmentSystem es, JMenuItem edit){
        super("Machine Project");
        
        editItem = edit;
        
        this.es = es;
        this.lblUser = new JLabel("Username: ");
        this.lblPassword = new JLabel("Password: ");
        this.lblFirst = new JLabel("First Name: ");
        this.lblLast = new JLabel("Last Name: ");
        this.lblMin = new JLabel("Minimum Units: ");
        this.lblMax = new JLabel("Maximum Units: ");
        this.txtUser = new JTextField();
        txtUser.setColumns(20);
        this.txtPassword = new JPasswordField();
        txtPassword.setColumns(20);
        this.txtFirst = new JTextField();
        txtFirst.setColumns(20);
        this.txtLast = new JTextField();
        txtLast.setColumns(20);
        this.txtMin = new JTextField();
        txtMin.setColumns(5);
        this.txtMax = new JTextField();
        txtMax.setColumns(5);
        this.register = new JButton("Register Student!!");
        register.addActionListener(this);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initScreen();
        setSize(700,350);
        setBounds(500, 500, 500, 500);
        setVisible(false);
    }
    
    public void initScreen(){
        JPanel p = new JPanel(new GridBagLayout());
        
        GridBagConstraints con = new GridBagConstraints();
        con.anchor = GridBagConstraints.WEST;
        con.insets = new Insets(10, 10, 10, 10);
        
        con.gridx = 0;
        con.gridy = 0;
        p.add(this.lblUser, con);
        
        con.gridx = 1;
        p.add(this.txtUser, con);
        
        con.gridx = 0;
        con.gridy = 1;
        p.add(this.lblPassword, con);
        
        con.gridx = 1;
        p.add(this.txtPassword, con);
        
        con.gridx = 0;
        con.gridy = 2;
        p.add(this.lblFirst, con);
        
        con.gridx = 1;
        p.add(this.txtFirst, con);
        
        con.gridx = 0;
        con.gridy = 3;
        p.add(this.lblLast, con);
        
        con.gridx = 1;
        p.add(this.txtLast, con);
        
        con.gridx = 0;
        con.gridy = 4;
        p.add(this.lblMin, con);
        
        con.gridx = 1;
        p.add(this.txtMin, con);
        
        con.gridx = 0;
        con.gridy = 5;
        p.add(this.lblMax, con);
        
        con.gridx = 1;
        p.add(this.txtMax, con);
        
        con.gridx = 0;
        con.gridy = 6;
        con.gridwidth = 2;
        con.anchor = GridBagConstraints.CENTER;
        p.add(register, con);
        
        p.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Student Register Panel"));
        p.setBackground(new Color(127,191,127));
        add(p);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        JButton b;
        Student s = null;
        if(e.getActionCommand().equals(register.getText())){
            if(txtUser.getText().isEmpty() || txtPassword.getText().isEmpty() || txtFirst.getText().isEmpty() || txtLast.getText().isEmpty() || txtMax.getText().isEmpty() || txtMin.getText().isEmpty()){
                ErrorMSG er = new ErrorMSG(es);
                er.setVisible(true);
                er.dispose();
            }
            if(!txtFirst.getText().matches("[A-Za-z]*$") || !txtLast.getText().matches("[A-Za-z]*$") || !txtMin.getText().matches("[0-9]*$") || !txtMax.getText().matches("[0-9]*$")){
                ErrorMSG er = new ErrorMSG(es);
                er.setVisible(true);
                er.dispose();
            }
            else{    
                b = (JButton)e.getSource();
                this.username = txtUser.getText();
                this.password = txtPassword.getText();
                this.firstName = txtFirst.getText();
                this.lastName = txtLast.getText();
                this.maxUnits = Double.parseDouble(txtMax.getText());
                this.minUnits = Double.parseDouble(txtMin.getText());
                s = new Student(username, password, lastName, firstName, minUnits, maxUnits);
                if(es.RegisterStudentAccount(s)){
                    username = ""; password = ""; firstName = ""; lastName = ""; maxUnits = 0; minUnits = 0;
                    txtUser.setText("");txtPassword.setText("");txtFirst.setText("");txtLast.setText("");txtMax.setText("");txtMin.setText("");
                    SuccessMSG su = new SuccessMSG(es);
                    su.setVisible(true);
                    su.dispose();
                    editItem.setEnabled(true);
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
