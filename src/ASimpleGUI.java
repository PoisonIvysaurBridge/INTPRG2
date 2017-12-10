import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class ASimpleGUI extends JFrame implements ActionListener
{
	private JLabel lbl;
	
	public ASimpleGUI(String title)
	{
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		initScreen();
		setSize(400, 200);
		setBounds(500, 200, 500, 200);
		setVisible(true);
		
	}
	
	public void initScreen()
	{
		JPanel panel = new JPanel(new BorderLayout());
		add(panel);
		/*
		JLabel lblTitle = new JLabel("Name: ");
		panel.add(lblTitle,BorderLayout.WEST);
		
		JTextField tfName = new JTextField(15);
		tfName.setColumns(20);
		tfName.setHorizontalAlignment(JTextField.LEFT);
		panel.add(tfName,BorderLayout.NORTH);
		
		JButton btnOK = new JButton("OK");
		btnOK.addActionListener(this);  
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(this);  
		add(btnOK);
		add(btnCancel);
		*/
		
		JButton btn;
		btn = new JButton("Left");
		btn.addActionListener(this);
		panel.add(btn, BorderLayout.WEST);
		
		btn = new JButton("Right");
		btn.addActionListener(this);
		panel.add(btn, BorderLayout.EAST);
		
		btn = new JButton("Center");
		btn.addActionListener(this);
		panel.add(btn, BorderLayout.CENTER);
		
		lbl = new JLabel();
		panel.add(lbl, BorderLayout.SOUTH);
	}
	
	public void actionPerformed(ActionEvent e)
	{	
		JButton btn = (JButton) e.getSource();/*
		if(e.getActionCommand().equals("OK"))
		{
			btn = (JButton) e.getSource();
			btn.setText("Done");
		}
		
		else if(e.getActionCommand().equals("Done"))
		{
			btn = (JButton) e.getSource();
			btn.setText("OK");
		}
		*/
		if (e.getActionCommand().equals("Left"))
		{
			lbl.setText(btn.getText());
			lbl.setHorizontalAlignment(JLabel.LEFT);
		}
		else if(e.getActionCommand().equals("Center"))
		{
			lbl.setText(btn.getText());
			lbl.setHorizontalAlignment(JLabel.CENTER);
		}
		else if(e.getActionCommand().equals("Right"))
		{
			lbl.setText(btn.getText());
			lbl.setHorizontalAlignment(JLabel.RIGHT);
		}
	}
	public static void main(String [] args)
	{
		ASimpleGUI app = new ASimpleGUI("Title Bar"); 
	}
}
