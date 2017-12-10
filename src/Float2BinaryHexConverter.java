import java.util.Scanner;

public class Float2BinaryHexConverter {
	
	public String fractionToBinary(double n)
	{
		String result = "";
		while (n > 0)
		{
			double ones = n * 2;
			if (ones > 0)
			{
				result+="1";
				n = ones -1;
			}
			else
			{
				result+="0";
				n = ones;
			}
		}
		return "."+result;
	}
	
	public String wholeToBinary(String n)
	{
		int whole = Integer.parseInt(n.substring(0, n.indexOf('.')));
		return Integer.toBinaryString(whole);
	}
	
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		Float2BinaryHexConverter app = new Float2BinaryHexConverter();
		System.out.println("============================ INPUT (will transfer to GUI if possible) ============================");
		System.out.print("Please enter decimal mantissa: ");
		double mantissa = sc.nextDouble();
		sc.nextLine();
		System.out.print("Please enter exponent (base-10): ");
		int exp = sc.nextInt();
		
		int signBit = 0;
		if (mantissa < 0)
			signBit = 1;
		
		mantissa = mantissa*(Math.pow(10, exp));	// ex. 4.5 x 10 ^ 2 becomes 450.0
		String strMantissa = mantissa + "";
		
		
		System.out.println(Double.parseDouble(".045"));
		double fraction = Double.parseDouble(strMantissa.substring(strMantissa.indexOf('.'), strMantissa.length()));
		int binary = Integer.parseInt(app.wholeToBinary(strMantissa)+ app.fractionToBinary(fraction));
		System.out.println(binary);
	}
}
