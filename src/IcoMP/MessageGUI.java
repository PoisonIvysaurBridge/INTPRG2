package IcoMP;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class MessageGUI extends JFrame implements ActionListener
{
    private JButton ok;
    private JTextField inputUsername;
    private JPasswordField inputPassword;
    
    public MessageGUI (String superName, String message)
    {
        super (superName);
        error (message);
        setSize (265,100);
        setResizable(false);
        setDefaultCloseOperation (DISPOSE_ON_CLOSE);
        setVisible (true);
    }
    
    public void error (String newMessage)
    {
        JPanel p1 = new JPanel ();
        add(p1, BorderLayout.NORTH);
        JLabel message = new JLabel (newMessage);
        p1.add(message);
        JPanel p2 = new JPanel ();
        add(p2, BorderLayout.SOUTH);
        ok = new JButton ("OK");
        ok.addActionListener(this);
        p2.add(ok, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed (ActionEvent e)
    {
        if (e.getActionCommand().equals("OK"))
        {
            this.dispose();
        }
    }
    public static void main(String [] args)
    {
    	MessageGUI app = new MessageGUI("lala","hahaHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH");
    }
}