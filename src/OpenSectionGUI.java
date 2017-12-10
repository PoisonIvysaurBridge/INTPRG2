/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package projectswag;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class OpenSectionGUI extends JFrame implements ActionListener {
    private JLabel lblEnterSection, lblEnterCourse, lblEnterFac, lblSelectDays, lblEnterSched, lblEnterCap, lblEnterStart, lblEnterEnd;
    private JTextField tfEnterSection, tfEnterCourse, tfEnterFac, tfEnterSched1, tfEnterSched2, tfEnterCap, tfEnterStart, tfEnterEnd;
    private JButton btnOpen, btnCancel, btnOne, btnTwo;
    private JPanel p1,p2,p3,p4,p5;
    public OpenSectionGUI(){
        super("Open Section");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initscreen();
        setSize(600,600);
        setResizable(false);
        setVisible(true);
    }
    public void initscreen(){
        JPanel p1 = new JPanel ();
        JPanel p2 = new JPanel ();
        JPanel p3 = new JPanel ();
        JPanel p5 = new JPanel ();
        p1.setLayout(new BorderLayout());
        p2.setLayout(new GridLayout(0,1,0,20));
        lblEnterSection = new JLabel ("Enter Section:");
        lblEnterCourse = new JLabel ("Enter Course:");
        lblEnterFac = new JLabel ("Enter Faculty:");
        lblSelectDays = new JLabel ("Select number of days:");
        lblEnterSched = new JLabel ("Enter Class Days:");
        lblEnterCap = new JLabel ("Enter Section Capacity:");
        lblEnterStart = new JLabel ("Enter Start Time:");
        lblEnterEnd = new JLabel ("Enter End Time:");
        tfEnterSection = new JTextField (7);
        tfEnterCourse = new JTextField (3);
        tfEnterFac = new JTextField (7);
        tfEnterSched1 = new JTextField (7);
        tfEnterSched2 = new JTextField (7);
        tfEnterCap = new JTextField (7);
        tfEnterStart = new JTextField (7);
        tfEnterEnd = new JTextField (7);
        btnOpen = new JButton ("Open!");
        btnCancel = new JButton ("Cancel");
        btnOne = new JButton ("One Day");
        btnTwo = new JButton ("Two Days");
        add(p1, BorderLayout.WEST);
        p2.add(lblEnterCourse);
        p2.add(tfEnterCourse);
        p2.add(lblEnterSection);
        p2.add(tfEnterSection);
        p2.add(lblEnterFac);
        p2.add(tfEnterFac);
        p2.add(lblSelectDays);
        p3.add(btnOne);
        p3.add(btnTwo);
        p2.add(p3);
        p5.add(btnOpen);
        p5.add(btnCancel);
        p2.add(p5);
        p1.add(p2);
        btnOne.addActionListener(this);
        btnTwo.addActionListener(this);
        btnCancel.addActionListener(this);
          
    }
    
    public void actionPerformed (ActionEvent e){
        if (e.getActionCommand().equals("One Day")){
            p4 = new JPanel ();
            p4.setLayout(new BorderLayout());
            p4.add(lblEnterSched);
            p4.setVisible(true);
            add(p4, BorderLayout.EAST);
            
        }
        
        else if (e.getActionCommand().equals("Cancel")){
            this.dispose();
           // AdminSelectOptionsGUI a = new AdminSelectOptionsGUI();
        }
    }
    public static void main(String[] args) {
        OpenSectionGUI a = new OpenSectionGUI();
    }
}
