import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NumberKeyPad extends JFrame implements ActionListener
{
	private JTextField tf;
	private JButton btn, btn1, btn2, btn3, btn4, btn5, btn6, btn7,btn8,btn9,btn0,btnPeriod, btnC;
	String text = "";
	double value = 0.0;
	String temp = "";
	String op = "";
	public NumberKeyPad(String title)
	{
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		initScreen();
		
		setSize(400, 200);
		setVisible(true);
	}
	
	public void initScreen()
	{
		JPanel pnl = new JPanel();
		pnl.setLayout(new GridLayout(4,4));
		add(pnl);
		
		tf = new JTextField(20);
		tf.setHorizontalAlignment(JTextField.RIGHT);
		add(tf, BorderLayout.NORTH);
		btn = new JButton("=");
		add(btn, BorderLayout.SOUTH);
		//JButton btn6;
		btn7 = new JButton("7");
		btn7.addActionListener(this);
		pnl.add(btn7);
		
		btn8 = new JButton("8");
		btn8.addActionListener(this);
		pnl.add(btn8);
		
		btn9 = new JButton("9");
		btn9.addActionListener(this);
		pnl.add(btn9);
		
		btn = new JButton("/");
		btn.addActionListener(this);
		pnl.add(btn);
		
		btn4 = new JButton("4");
		btn4.addActionListener(this);
		pnl.add(btn4);
		
		btn5 = new JButton("5");
		btn5.addActionListener(this);
		pnl.add(btn5);
		
		btn6 = new JButton("6");
		btn6.addActionListener(this);
		pnl.add(btn6);
		
		btn = new JButton("X");
		btn.addActionListener(this);
		pnl.add(btn);
		
		btn1 = new JButton("1");
		btn1.addActionListener(this);
		pnl.add(btn1);
		
		btn2 = new JButton("2");
		btn2.addActionListener(this);
		pnl.add(btn2);
		
		btn3 = new JButton("3");
		btn3.addActionListener(this);
		pnl.add(btn3);
		
		btn = new JButton("-");
		btn.addActionListener(this);
		pnl.add(btn);
		
		btn0 = new JButton("0");
		btn0.addActionListener(this);
		pnl.add(btn0);
		
		btnPeriod = new JButton(".");
		btnPeriod.addActionListener(this);
		pnl.add(btnPeriod);
		
		btnC = new JButton("C");
		btnC.addActionListener(this);
		pnl.add(btnC);
		
		btn = new JButton("+");
		btn.addActionListener(this);
		pnl.add(btn);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		JButton btn = (JButton) e.getSource();
		
		if (e.getActionCommand().equals("C"))
		{
			tf.setText("");
		}
		
		else if (e.getActionCommand().equals("="))
		{
			double nTemp = Double.parseDouble(temp.substring(0,));
			double nText = Double.parseDouble(text);
			value = calculate(nTemp, nText, op);
			}
			tf.setText(""+ value);
		}
		else
		{
			text = tf.getText() + btn.getText();
			tf.setText(text);
			
		}
		
	}
	public double calculate(double op1, double op2, String sign){
        double result=0;
        if (sign == "+")
                result = op1+op2;
        else if (sign == "-")
                result = op1-op2;
        else if (sign == "X")
                result = op1*op2;
        else if (sign == "/" && op2!=0)
                result = op1/ op2;
        return result;
}
	public static void main(String [] args)
	{
		NumberKeyPad app = new NumberKeyPad("Number Keypad Application");
	}
}
