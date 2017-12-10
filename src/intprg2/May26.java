package intprg2;
// Ivana Lim #14
import java.util.Scanner;

public class May26{
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        System.out.print("enter name: ");
        String name = sc.nextLine();
        System.out.print("enter ID no.: ");
        int ID = sc.nextInt();
        
        
        String First = "";
        String Last = "";
        String Batch = "";
        
        /*
        String cur = "";
        for (int i =0; i<name.length(); i++){
            if (name.charAt(i)==','){
                Last = cur;
                cur = "";
            }
            cur+= name.charAt(i);
        }
        if (cur.charAt(1)==' '){
            First = cur.substring(2);
        }
        else{
            First = cur.substring(1);
        }
        */
        Last = name.substring(0,name.indexOf(","));
        First = name.substring(name.indexOf(",")+1);
        First = First.trim();
        Last = Last.trim();
        int year = ID / 100000 + 4;
        if (year > 99){
            Batch = "Catch "+(year/100+1)+"T"+ (year%100);
        }
        else{
            Batch = "Catch "+year;
        }
        
        System.out.println("First name is: "+First);        
        System.out.println("Last name is: "+Last);
        System.out.println("Batch is: "+Batch);
        
        int option = 0;
        do{
            System.out.println("------------- MENU ------------");
            System.out.println("1. Input\n2. Show\n3. Compute\n4. Configure\n5. Reset\n6. Exit");
            System.out.println("Please enter option(1-6)");
            option = sc.nextInt();
            switch(option){
                case 1: System.out.println("Hi "+First+"_"+Last+", input grades."); break;
                case 2: System.out.println("Hi "+First+"_"+Last+", display grades entered."); break;
                case 3: System.out.println("Hi "+First+"_"+Last+", compute final grade, GPE or final exam score."); break;
                case 4: System.out.println("Hi "+First+"_"+Last+", change settings."); break;
                case 5: System.out.println("Hi "+First+"_"+Last+", clear entries."); break;
                case 6: System.out.println("Goodbye "+First+"_"+Last+"!"); break;
                default: System.out.println("Invalid option.");  
            }
        }while(option!=6);
        
        
       sc.close(); 
}
}