import javax.swing.*;

public class ExceptionDemo {
	public static void main(String [] lalala)
	{
		int num = 0, denom = 0, result;
		String inputStr;
		try
		{
			inputStr = JOptionPane.showInputDialog(null, "Enter a number ot be divided");
			num = Integer.parseInt(inputStr);
			inputStr = JOptionPane.showInputDialog(null,"enter a number to divide into the first number");
			denom = Integer.parseInt(inputStr);
			result = num / denom;
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, ""+e);
			result = 0;
		}
		JOptionPane.showMessageDialog(null, num + " / "+denom +"\n result is "+result);
	}
}
