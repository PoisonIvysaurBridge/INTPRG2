package intprg2;

import java.util.Scanner;

public class StudentInfoObject
{
    public static void main(String[] args) {
        StudentInfo app = new StudentInfo();
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter Student name: ");
        app.setName(sc.nextLine());
        
        sc.nextLine();
        System.out.print("Enter ID no.: ");
        app.setIDno(sc.nextInt());
        
        System.out.println("Enter course: ");
        app.setCourse(sc.nextLine());
        
        System.out.println("Student name: "+app.getName());
        System.out.println("Student ID no: "+app.getIDno());
        System.out.println("Student course: "+app.getCourse());
    }
}