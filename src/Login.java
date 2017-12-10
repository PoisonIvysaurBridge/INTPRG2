import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener{
    
    private JLabel labelUsername;
    private JLabel labelPassword;
    private JTextField textUsername;
    private JPasswordField textPassword;
    private JButton login;
    private String username;
    private String password;
    
    public Login(){
        super("Login");
        
        this.labelUsername = new JLabel("Username: ");
        this.labelPassword = new JLabel("Password: ");
        this.textUsername = new JTextField("Enter username",20);
        this.textPassword = new JPasswordField("Enter password",20);
        //textPassword.setEchoChar('*');
        this.login = new JButton("Login");
        login.addActionListener(this);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initScreen();
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
        p.add(this.labelUsername, con);
        
        con.gridx = 1;
        p.add(textUsername, con);
        
        con.gridx = 0;
        con.gridy = 1;     
        p.add(labelPassword, con);
         
        con.gridx = 1;
        p.add(textPassword, con);
        
        con.gridx = 0;
        con.gridy = 2;
        con.gridwidth = 2;
        con.anchor = GridBagConstraints.CENTER;
        p.add(login, con);
        
        p.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Login Panel"));
        
        add(p);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        JButton b;
        if(e.getActionCommand().equals(login.getText())){
            b = (JButton)e.getSource();
            this.username = textUsername.getText();
            this.password = textPassword.getText();
        }
    }
    
    public static void main(String[] args) {
        Login a = new Login();
    }
    
    /*
    private JLabel labelUsername = new JLabel("Enter username: ");
    private JLabel labelPassword = new JLabel("Enter password: ");
    private JTextField textUsername = new JTextField(20);
    private JPasswordField fieldPassword = new JPasswordField(20);
    private JButton buttonLogin = new JButton("Login");
     
    public Login() {
        super("JPanel Demo Program");
         
        // create a new panel with GridBagLayout manager
        JPanel newPanel = new JPanel(new GridBagLayout());
         
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);
         
        // add components to the panel
        constraints.gridx = 0;
        constraints.gridy = 0;     
        newPanel.add(labelUsername, constraints);
 
        constraints.gridx = 1;
        newPanel.add(textUsername, constraints);
         
        constraints.gridx = 0;
        constraints.gridy = 1;     
        newPanel.add(labelPassword, constraints);
         
        constraints.gridx = 1;
        newPanel.add(fieldPassword, constraints);
         
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        newPanel.add(buttonLogin, constraints);
         
        // set border for the panel
        newPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Login Panel"));
         
        // add the panel to this frame
        add(newPanel);
         
        pack();
        setLocationRelativeTo(null);
    }
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
         
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
    */
}