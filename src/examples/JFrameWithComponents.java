package examples;
import javax.swing.*;
import java.awt.*;
public class JFrameWithComponents extends JFrame
{
	JLabel label = new JLabel("Enter your name");
	JTextField field = new JTextField(12);
	JButton button = new JButton("Ok");
	
	public JFrameWithComponents()
	{
		super("Frame with Components");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		initScreen();
		setSize(400,100);
		setVisible(true);
	}
	public void initScreen()
	{
		add(label);
		add(field);
		add(button);
	}
	public static void main(String [] args)
	{
		JFrameWithComponents app = new JFrameWithComponents();
	}
}
