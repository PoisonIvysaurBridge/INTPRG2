//Inoue Trisha, Salva Trisha
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class EnlistGUI extends JFrame implements ActionListener{
    
    private EnrollmentSystem es;
    private JLabel lblSection;
    private JTextArea txtInfromation;
    private JComboBox<Section> sectionBox; 
    private JButton bEnlist, bSelect;
    private JMenuItem removeItem;
    
    public EnlistGUI(EnrollmentSystem es, JMenuItem removeItem){
        super("Machine Project");
        
        this.removeItem = removeItem;
        this.es = es;
        this.lblSection = new JLabel("Section: ");
        this.sectionBox = new JComboBox<>(es.getSectionsVector());
        this.txtInfromation = new JTextArea();
        txtInfromation.setEditable(false);
        txtInfromation.setOpaque(false);
        this.bEnlist = new JButton("Enlsit Section!");
        bEnlist.addActionListener(this);
        this.bSelect = new JButton("Select!");
        bSelect.addActionListener(this);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initScreen();
        setSize(700,350);
        setVisible(false);
    }
    
    public void initScreen(){
        JPanel p = new JPanel(new GridBagLayout());
        JPanel p2 = new JPanel(new GridBagLayout());
        JPanel p3 = new JPanel(new GridBagLayout());
        JPanel whole = new JPanel(new BorderLayout());
        GridBagConstraints con = new GridBagConstraints();
        con.anchor = GridBagConstraints.WEST;
        con.insets = new Insets(10, 10, 10, 10);
        
        con.gridx = 0;
        con.gridy = 0;
        p.add(lblSection, con);
        con.gridx = 1;
        p.add(sectionBox, con);
        con.gridx = 2;
        p.add(bSelect, con);
        whole.add(p, BorderLayout.NORTH);
        
        con.gridx = 0;
        con.gridy = 0;
        p2.add(txtInfromation, con);
        p3.add(bEnlist, con);
        whole.add(p3, BorderLayout.SOUTH);
        whole.add(p2, BorderLayout.CENTER);
        
        p2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Information Panel"));
        whole.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Enlistment Panel"));
        whole.setBackground(new Color(127,191,127));
        p.setBackground(new Color(127,191,127));
        p3.setBackground(new Color(127,191,127));
        add(whole);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        Course c;
        Section s;
        if(e.getActionCommand().equals("Select!")){
            s = (Section)sectionBox.getSelectedItem();
            this.txtInfromation.setText(s.getInfo());
        }
        if(e.getActionCommand().equals("Enlsit Section!")){
            s = (Section)sectionBox.getSelectedItem();
            if(es.enlistSection(s)){
                this.txtInfromation.setText("");
                SuccessMSG su = new SuccessMSG(es);
                su.setVisible(true);
                su.dispose();
                removeItem.setEnabled(true);
            }
            else{
                ErrorMSG er = new ErrorMSG(es);
                er.setVisible(true);
                er.dispose();
            }
        }
    }
}
