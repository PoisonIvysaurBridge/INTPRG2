package intprg2;
// Ivana Lim #14
import java.util.Scanner;
public class June7{
    
    int input(String[] list, int nameCtr)
    {   
        Scanner sc = new Scanner (System.in);
        boolean cont = true;
        while(cont)
        {
            if (nameCtr-1 < list.length)
            {
                System.out.print("Name "+nameCtr+": ");
                String name = sc.nextLine().trim();
                if (nameCtr-1 < list.length && !name.equalsIgnoreCase("end"))
                {	
                    list[nameCtr-1] = name;
                    nameCtr++;
                }
                else
                    cont = false;
            }
            else
                cont = false;
        }
        System.out.println("");
        return nameCtr;
    }
    void display(String[] array)
    {   
        for(int i = 0; i < array.length; i++)
        {
            if(array[i]!= null)
                System.out.println(array[i]);
        }
        System.out.println("");
    }
    void sort(String[] array)
    {   System.out.println("Sorted names: ");
        
        for (int i = 0; i < array.length-1; i++)
        {
            for(int j = 0; j < array.length-1; j++)
            {
                if (array[j+1]!= null && array[j].compareTo(array[j+1]) < 0)
                {
                    String temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        display(array);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        June7 app = new June7();
        System.out.println("======================= Configuration: <Default> =======================");
        System.out.print("Enter data size: ");
        int arrSize = sc.nextInt();
        String[] list = new String[arrSize];
        int nNameCtr = 1;
        
        System.out.println("Input");
        nNameCtr = app.input(list, nNameCtr);
        if (nNameCtr-1 == list.length)
            System.out.println("Array full.\n");
	System.out.println("Entered names: ");
        app.display(list);
        app.sort(list);
        
        System.out.println("Next round of input");
        app.input(list, nNameCtr);
        if (nNameCtr-1 == list.length)
            System.out.println("Array full.\n");
        System.out.println("Entered names: ");
        app.display(list);
        app.sort(list);
       
        System.out.println("Process completed.");
    }
}