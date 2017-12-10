//Inoue, Yuta   Salva, Trisha
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class SuccessEnrollMSG extends JFrame implements ActionListener{

    private EnrollmentSystem es;
    private JLabel error;
    private JButton ok;
    
    public SuccessEnrollMSG(EnrollmentSystem es){
        
        this.es = es;
        JOptionPane.showMessageDialog(this, "Student Enrolled!!", "Machine Project", JOptionPane.INFORMATION_MESSAGE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.ok = new JButton("OK");
        ok.addActionListener(this);
        
    }
    
    public void initScreen(){
        JPanel p = new JPanel(new GridBagLayout());
        GridBagConstraints con = new GridBagConstraints();
        con.insets = new Insets(10, 10, 10, 10);
        
        con.gridx = 0;
        con.gridy = 0;
        p.add(error, con);
        con.gridx = 1;
        p.add(ok, con);
        
        add(p);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand().equals("OK")){
            this.setVisible(false);
            MainMenuBar menu = new MainMenuBar(es);
            menu.setVisible(true);
            this.dispose();
        }
    }
    
}
