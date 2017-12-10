//Inoue, Yuta   Salva, Trisha
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class RemoveEnlistGUI extends JFrame implements ActionListener{
    
    private EnrollmentSystem es;
    private JLabel lblSection;
    private JComboBox<Section> sectionList;
    private JTextArea txtInformation;
    private JButton bRemove, bSelecct;
    private JMenuItem removeItem;
    
    public RemoveEnlistGUI(EnrollmentSystem es, JMenuItem removeItem){
        super("Machine Project");
        
        this.removeItem = removeItem;
        this.es = es;
        this.lblSection = new JLabel("Section: ");
        this.sectionList = new JComboBox<>(es.getCurrentStudent().getEnlistedSectionsVector());
        this.txtInformation = new JTextArea();
        txtInformation.setOpaque(false);
        txtInformation.setEditable(false);
        this.bRemove = new JButton("Remove Enlistment!");
        bRemove.addActionListener(this);
        this.bSelecct = new JButton("Select!");
        bSelecct.addActionListener(this);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initScreen();
        setSize(400,350);
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
        p.add(sectionList, con);
        con.gridx = 2;
        p.add(bSelecct, con);
        
        whole.add(p, BorderLayout.NORTH);
        
        //information about the Section selected
        con.gridx = 0;
        con.gridy = 1;
        p2.add(txtInformation, con);
        whole.add(p2, BorderLayout.CENTER);
        p2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Infromation Panel"));
        
        whole.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Remove Enlistment Panel"));
        
        con.gridx = 0;
        con.gridy = 0;
        p3.add(bRemove, con);
        
        whole.add(p3, BorderLayout.SOUTH);
        whole.setBackground(new Color(127,191,127));
        p.setBackground(new Color(127,191,127));
        p3.setBackground(new Color(127,191,127));
        add(whole);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand().equals("Select!")){
            Section s = (Section)sectionList.getSelectedItem();
            txtInformation.setText(s.getInfo());
        }
        if(e.getActionCommand().equals("Remove Enlistment!")){
            Course c;
            Section s;
            s = (Section)sectionList.getSelectedItem();
            if(es.removeEnlistment(s)){
                this.txtInformation.setText("");
                SuccessMSG su = new SuccessMSG(es);
                su.setVisible(true);
                su.dispose();
                if(es.getCurrentStudent().getEnlists().isEmpty()){
                    removeItem.setEnabled(false);
                }
                else
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
