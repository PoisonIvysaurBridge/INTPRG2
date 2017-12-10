package examples;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUIS15 extends JFrame implements ActionListener
{
	private JButton btnOk;
	
	public GUIS15 (String title)
	{
		super (title);
		
		initScreen ();
		setSize (300, 500);
		setDefaultCloseOperation (EXIT_ON_CLOSE);
		setVisible (true);
	}
	
	public void initScreen ()
	{
//		setLayout (new FlowLayout ());
		JLabel lblName = new JLabel ("Name: ");
//		add (lblName);
		
		JTextField tfName = new JTextField (15);
//		add (tfName);
		
		JPanel p1 = new JPanel ();
		p1.setLayout (new FlowLayout ());
		p1.add (lblName);
		p1.add (tfName);
		add (p1, BorderLayout.NORTH);
		
		btnOk = new JButton ("Okay!");
		btnOk.addActionListener (this);
		btnOk.setToolTipText("Click Ok if done");
		p1 = new JPanel ();
		p1.setLayout (new FlowLayout ());
		p1.add (btnOk);
		add (p1, BorderLayout.CENTER);
		
		JButton btnCancel = new JButton ("Cancel");
		btnCancel.addActionListener (this);
		p1.add (btnCancel);
	}
	
	public void actionPerformed(ActionEvent e) //Invoked when an action occurs.
	{
		if (e.getActionCommand ().equals ("Okay!"))
		{
			btnOk.setText ("Exit!");
		}
		else if (e.getActionCommand ().equals ("Exit!"))
		{
			btnOk.setText ("Okay!");
		}
		else if (e.getActionCommand ().equals ("Cancel"))
		{
			btnOk.setText ("Hi!");
		}
	}

	
	public static void main (String[] args)
	{
		GUIS15 app = new GUIS15 ("GUI for S15");
	}
	
}