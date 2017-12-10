package examples;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JAction extends JFrame implements ActionListener
{
	JLabel label = new JLabel("Enter your name");
	JTextField field = new JTextField(12);
	JButton button = new JButton("Ok");
	
	public JAction()
	{
		super("Action");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		initScreen();
		setSize(400,100);
		setVisible(true);
	}
	public void initScreen()
	{
		button.addActionListener(this);
		field.addActionListener(this);
		add(label);
		add(field);
		add(button);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		label.setText("Thank you");
		button.setText("DONE");
	}
	public static void main(String [] args)
	{
		JAction app = new JAction();
	}
}
