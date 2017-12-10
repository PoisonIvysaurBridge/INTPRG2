//Inoue, Yuta   Salva, Trisha
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class LoginGUI extends JFrame implements ActionListener{
    
    private EnrollmentSystem es;
    private Account account;
    private JLabel lblUsername, lblPassword;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton login;
    private String username, password;
    
    public LoginGUI(EnrollmentSystem es){
        super("Machine Project");
        
        this.es = es;
        this.lblUsername = new JLabel("Username: ");
        this.lblPassword = new JLabel("Password: ");
        this.txtUsername = new JTextField(20);
        this.txtPassword = new JPasswordField(20);
        this.login = new JButton("Login");
        login.addActionListener(this);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initScreen();
        setBounds(500, 500, 500, 500);
        setSize(400,200);
        setVisible(true);
        
    }
    
    public void initScreen(){
        JPanel p = new JPanel(new GridBagLayout());
        GridBagConstraints con = new GridBagConstraints();
        con.anchor = GridBagConstraints.WEST;
        con.insets = new Insets(10, 10, 10, 10);
        
        con.gridx = 0;
        con.gridy = 0;
        p.add(this.lblUsername, con);
        
        con.gridx = 1;
        p.add(txtUsername, con);
        
        con.gridx = 0;
        con.gridy = 1;     
        p.add(lblPassword, con);
         
        con.gridx = 1;
        p.add(txtPassword, con);
        
        con.gridx = 0;
        con.gridy = 2;
        con.gridwidth = 2;
        con.anchor = GridBagConstraints.CENTER;
        p.add(login, con);
        
        p.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Login Panel"));
        p.setBackground(new Color(127,191,127));
        
        add(p);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        Account a = null;
        if(e.getActionCommand().equals(login.getText())){
            this.username = txtUsername.getText();
            this.password = txtPassword.getText();
            a = new Account(username, password);
            this.account = new Account(username, password);
            if(es.login(a)){
                MainMenuBar menu = new MainMenuBar(es);
                menu.setVisible(true);
                this.dispose();
            }
            else{
                ErrorLoginMSG error = new ErrorLoginMSG(es);
                error.setVisible(true);
                error.dispose();
            }
        }
    }
    
    public static void main(String[] args) {
        EnrollmentSystem es = new EnrollmentSystem();
        LoginGUI a = new LoginGUI(es);
    }
}