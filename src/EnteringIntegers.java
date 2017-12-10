import java.util.Scanner;

public class EnteringIntegers {
	public static void main(String [] args)
	{
		int [] numberList = {0,0,0,0,0,0};
		Scanner input = new Scanner(System.in);
		for (int x = 0; x < numberList.length; ++x)
		{
			boolean errCheck = false;
			try
			{
				System.out.print("Enter an integer >> ");
				numberList[x] = input.nextInt();
				errCheck = false;
			}
			catch (Exception e)
			{
				errCheck = true;
				System.out.println("Exception occured");
			}
			input.nextLine();
		}
		System.out.print("The numbers are: ");
		for(int x : numberList)
		{
			System.out.print(x + " ");
		}
		System.out.println();
	}
}
