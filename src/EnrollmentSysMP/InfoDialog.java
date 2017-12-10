package EnrollmentSysMP;
//package EnrollmentSysMP;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InfoDialog extends JFrame implements ActionListener
{
	private JButton btnOK;
	
	public InfoDialog(String title, String info)
	{
		super(title);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		initScreen(info);
		setSize(250, 150);
		setBounds(500,300,400,150);
		setVisible(true);
	}
	
	public void initScreen(String info)
	{
		
		JLabel lbl = new JLabel(info);
		lbl.setHorizontalAlignment(JLabel.CENTER);
		
		JPanel pnl1 = new JPanel(new FlowLayout());
		pnl1.add(lbl);
		add(pnl1, BorderLayout.CENTER);
		
		JPanel pnl2 = new JPanel(new FlowLayout());
		btnOK = new JButton("OK");
		btnOK.addActionListener(this);
		
		pnl2.add(btnOK);
		add(pnl2,BorderLayout.SOUTH);
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getActionCommand().equals("OK"))
		{
			this.dispose();
		}
	}
	/*public static void main(String [] args)
	{
		InfoDialog app = new InfoDialog("Register Student", "SAMPLE MSG LONG");
	}*/
}
