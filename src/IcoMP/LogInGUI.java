package IcoMP;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class LogInGUI extends JFrame implements ActionListener
{
    private JButton logIn;
    private JTextField inputUsername;
    private JPasswordField inputPassword;
    private AdministratorAccount admin;
    
    public LogInGUI (AdministratorAccount copyAdmin)
    {
        super ("EnLos University");
        logIn ();
        setSize (300,200);
        setResizable(false);
        setDefaultCloseOperation (EXIT_ON_CLOSE);
        setVisible (true);
        admin = copyAdmin;
    }
    
    public void logIn ()
    {
        JPanel p1 = new JPanel ();
        JPanel p1a = new JPanel ();
        p1a.setLayout (new GridLayout (2,1));
        JLabel systemName = new JLabel ("EnLos System");
        add(p1a,BorderLayout.NORTH);
        p1.add(systemName);
        p1a.add(p1);
        JPanel p2 = new JPanel ();
        JPanel p2a = new JPanel(new GridLayout (0,1));
        JLabel username = new JLabel ("Username: ");
        inputUsername = new JTextField (15);
        JLabel password = new JLabel ("Password: ");
        inputPassword = new JPasswordField (15);
        add(p2a, BorderLayout.CENTER);
        p2.add(username);
        p2.add(inputUsername);
        p2a.add(p2);
        p2.add(password);
        p2.add(inputPassword);
        p2a.add(p2);
        JPanel p3 = new JPanel ();
        JPanel p3a = new JPanel(new FlowLayout());
        logIn = new JButton ("LOGIN");
        logIn.addActionListener(this);
        add(p3a, BorderLayout.SOUTH);
        p3.add(logIn);
        p3a.add(p3);
    }

    @Override
    public void actionPerformed (ActionEvent e)
    {
        if (e.getActionCommand().equals("LOGIN"))
        {
            String password = new String (inputPassword.getPassword());
            if (inputUsername.getText().equals("admin") && password.equals("DLSU"))
            {
                this.dispose();
                AdminGUI adminApp = new AdminGUI (admin);
            }
            else
            {
                MessageGUI alert = new MessageGUI ("Error", "Invalid Username/Password!");;
            }
        }
    }
}