import java.util.Scanner;

public class ForEachLoopTest {
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		int[] numberList = new int[5];
		for(int i : numberList){
		 i = sc.nextInt();
		 sc.nextLine();
		}
		for(int i : numberList){
		 System.out.print(i + " ");
		}
	}
}
