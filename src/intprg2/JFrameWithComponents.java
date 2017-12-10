package intprg2;
import javax.swing.*;
import java.awt.*;
public class JFrameWithComponents extends JFrame
{
	JLabel label = new JLabel("Enter your name");
	JTextField field = new JTextField(12);
	JButton button = new JButton("OK");
	
	public JFrameWithComponents()
	{
		super("Frame With Components");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		button.setToolTipText("Click me!");
		add(label);
		add(field);
		add(button);
	}
	
	public static void main(String [] args)
	{
		JFrameWithComponents aFrame = new JFrameWithComponents();
		aFrame.setSize(350,100);
		aFrame.setVisible(true);
	}
}
