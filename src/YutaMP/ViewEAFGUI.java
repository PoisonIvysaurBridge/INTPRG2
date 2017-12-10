//Inoue, Yuta   Salva, Trisha
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class ViewEAFGUI extends JFrame implements ActionListener{
    
    private EnrollmentSystem es;
    private JButton collapse;
    private JLabel lblName, lblID, lblUnits;
    private JTextField txtName, txtID, txtUnits;
    private JTable eaf;
    
    public ViewEAFGUI(EnrollmentSystem es){
        super("Machine Project");
        
        this.es = es;
        this.collapse = new JButton("OK");
        collapse.addActionListener(this);
        this.lblName = new JLabel("NAME: ");
        this.lblID = new JLabel("ID NUMBER: ");
        this.lblUnits = new JLabel("TOTAL UNITS: ");
        this.txtName = new JTextField(es.getCurrentStudent().getFullName());
        txtName.setEditable(false);
        txtName.setOpaque(false);
        this.txtID = new JTextField(es.getCurrentStudent().getUserName());
        txtID.setEditable(false);
        txtID.setOpaque(false);
        this.txtUnits = new JTextField(Double.toString(es.getCurrentStudent().getTotalUnitsEnrolled()));
        txtUnits.setEditable(false);
        txtUnits.setOpaque(false);
        
        
        String[] columnName = {"CODE", "COURSE NAME", "SECTION", "TEACHER", "SCHEDULE", "UNITS"};
        Object[][] rowData = new Object[es.getCurrentStudent().getEnrolls().size()][6];
        Section check = null;
        for(int i = 0; i < rowData.length; i++){
            rowData[i][0] = es.getCurrentStudent().getEnrolls().get(i).getCourse().getCode();
            rowData[i][1] = es.getCurrentStudent().getEnrolls().get(i).getCourse().getName();
            rowData[i][2] = es.getCurrentStudent().getEnrolls().get(i).getSectionName();
            rowData[i][3] = es.getCurrentStudent().getEnrolls().get(i).getFaculty();
            rowData[i][4] = es.getCurrentStudent().getEnrolls().get(i).getWholeSchedule();
            rowData[i][5] = es.getCurrentStudent().getEnrolls().get(i).getCourse().getUnits();
        }
        
        this.eaf = new JTable(rowData, columnName);
        eaf.setEnabled(false);
        
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initScreen();
        setSize(900,150);
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
        setUndecorated(true);
        setVisible(false);
    }
    
    public void initScreen(){
        JPanel p = new JPanel(new GridBagLayout());
        JPanel p2 = new JPanel(new GridBagLayout());
        JScrollPane scroll = new JScrollPane(eaf, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        GridBagConstraints con = new GridBagConstraints();
        con.anchor = GridBagConstraints.WEST;
        con.insets = new Insets(10, 10, 10, 10);
        con.gridx = 0;
        con.gridy = 0;
        p.add(lblName, con);
        con.anchor = GridBagConstraints.EAST;
        con.gridx = 1;
        p.add(txtName, con);
        
        con.anchor = GridBagConstraints.WEST;
        con.gridx = 0;
        con.gridy = 1;
        p.add(lblID, con);
        con.anchor = GridBagConstraints.EAST;
        con.gridx = 1;
        p.add(txtID, con);
        
        
        con.anchor = GridBagConstraints.CENTER;
        con.gridwidth = 0;
        con.gridx = 0;
        con.gridy = 2;
        
        //p2.add(scroll);
        p.add(scroll, con);
        
        
        con.gridwidth = 1;
        con.anchor = GridBagConstraints.EAST;
        con.gridx = 0;
        con.gridy = 0;
        p2.add(lblUnits, con);
        con.anchor = GridBagConstraints.WEST;
        con.gridx = 1;
        p2.add(txtUnits, con);
        con.anchor = GridBagConstraints.CENTER;
        con.gridwidth = 0;
        con.gridx = 0;
        con.gridy = 1;
        p2.add(collapse, con);
        
        add(p, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
        add(p2, BorderLayout.SOUTH);
        setBackground(new Color(127,191,127));
        p.setBackground(new Color(127,191,127));
        p2.setBackground(new Color(127,191,127));
        /*
        JPanel p = new JPanel(new GridBagLayout());
        JPanel p2 = new JPanel(new GridBagLayout());
        JPanel p3 = new JPanel(new GridBagLayout());
        JPanel whole = new JPanel(new BorderLayout());
        GridBagConstraints con = new GridBagConstraints();
        con.anchor = GridBagConstraints.EAST;
        con.insets = new Insets(10, 10, 10 ,10);
        con.gridx = 0;
        con.gridy = 0;
        this.setLayout(new BorderLayout());
        JScrollPane scroll = new JScrollPane(eaf, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        con.gridx = 0;
        con.gridy = 0;
        p.add(lblName, con);
        con.anchor = GridBagConstraints.WEST;
        con.gridx = 1;
        p.add(txtName, con);
        
        con.gridx = 0;
        con.gridy = 1;
        con.anchor = GridBagConstraints.EAST;
        p.add(lblID, con);
        con.anchor = GridBagConstraints.WEST;
        con.gridx = 1;
        p.add(txtID, con);
        
        con.gridx = 0;
        con.gridy = 0;
        con.anchor = GridBagConstraints.EAST;
        p2.add(lblUnits, con);
        con.gridx = 1;
        con.anchor = GridBagConstraints.WEST;
        p2.add(txtUnits, con);
        
        
        
        eaf.getColumnModel().getColumn(1).setPreferredWidth(300);
        eaf.getColumnModel().getColumn(1).setWidth(300);
        eaf.getColumnModel().getColumn(3).setPreferredWidth(100);
        eaf.getColumnModel().getColumn(3).setWidth(100);
        eaf.getColumnModel().getColumn(4).setPreferredWidth(100);
        eaf.getColumnModel().getColumn(4).setWidth(100);
        
        con.gridx = 0;
        con.gridy = 0;
        p3.add(collapse, con);
        
        whole.add(p, BorderLayout.NORTH);
        whole.add(scroll, BorderLayout.CENTER);
        whole.add(p3, BorderLayout.SOUTH);
        
        add(whole);
        */
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand().equals("OK")){
            this.dispose();
        }
    }
}
