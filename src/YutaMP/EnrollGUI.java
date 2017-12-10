//Inoue, Yuta   Salva, Trisha
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class EnrollGUI extends JFrame implements ActionListener{
    
    private EnrollmentSystem es;
    private JButton ok;
    private JMenuItem eafItem, enlistItem, enrollItem, removeItem;
    
    public EnrollGUI(EnrollmentSystem es, JMenuItem eafItem, JMenuItem enlistItem, JMenuItem enrollItem, JMenuItem removeItem ){
        super("Machine Project");
        
        this.eafItem = eafItem;
        this.enlistItem = enlistItem;
        this.enrollItem = enrollItem;
        this.removeItem = removeItem;
        this.es = es;
        this.ok = new JButton("Enroll!!");
        ok.addActionListener(this);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initScreen();
        setSize(300,200);
        setVisible(false);
    }
    
    public void initScreen(){
        JPanel p = new JPanel(new GridBagLayout());
        GridBagConstraints con = new GridBagConstraints();
        con.insets = new Insets(10, 10, 10, 10);
        
        con.gridx = 0;
        con.gridy = 0;
        p.add(ok, con);
        
        p.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Enroll Panel"));
        add(p);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand().equals("Enroll!!")){
            if(es.enroll()){
                SuccessMSG su = new SuccessMSG(es);
                su.setVisible(true);
                su.dispose();
                eafItem.setEnabled(true);
                enlistItem.setEnabled(false);
                enrollItem.setEnabled(false);
                removeItem.setEnabled(false);
                ok.setEnabled(false);
            }
            else{
                ErrorMSG er = new ErrorMSG(es);
                er.setVisible(true);
                er.dispose();
            }
        }
    }
}
