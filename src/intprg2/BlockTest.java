package intprg2;
// Ivana Lim #14    6-23-16
import java.util.Scanner;

public class BlockTest{
    public static void main(String[] args) {
        // ################ Test ##################
        Block S16A = new Block("S16A", 22);
        S16A.display();
        
        S16A.addStudent();
        S16A.display();
        
        S16A.addStudent(13);
        S16A.display();
        
        S16A.addStudent(3);
        S16A.display();
        
        S16A.addStudent(10);
        S16A.display();
        //##########################################
        
        Block[] Blocks = new Block[5];
        Blocks[0] = new Block("S11", 5);
        Blocks[1] = new Block("S12", 6);
        Blocks[2] = new Block("S13", 3);
        Blocks[3] = new Block("S14", 7);
        Blocks[4] = new Block("S15", 4);
        System.out.println("\n=========== Display Blocks =============");
        int i;
        for(i = 0; i < Blocks.length; i++){
            Blocks[i].display();
        }
        
        // ############ user input ##############
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter block name: ");
        String name = sc.nextLine();
        System.out.print("Enter no. of students to add: ");
        int x = sc.nextInt();
        // ########################################
        
        for(i = 0; i < Blocks.length; i++){
            if (Blocks[i].getName().equalsIgnoreCase(name))
            {
                Blocks[i].addStudent(x);
                i = Blocks.length;
            }
                
        }
        System.out.println("\n=========== Display Blocks =============");
        for(i = 0; i < Blocks.length; i++){
            Blocks[i].display();
        } 
        System.out.println("=========================================");
    }
}