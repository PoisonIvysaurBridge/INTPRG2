package intprg2;
// Ivana Lim #14
import java.util.*;
public class Jun2
{
    public static void main(String[] args) 
    {
        Jun2 app = new Jun2();
        Scanner sc = new Scanner (System.in);
        String strFname_Lname = app.getNameID();
        
//##################################################### PART 2 ###############################################################       
        //how many in each grading activity
        int nHO = 2;    int ctrHO = 0;
        int nFinals = 1;    
        int nProject = 1;   
        int nSW = 5;    int ctrSW = 0;
        // initialize the scores #######################################################################
        double[] HOscores = new double [nHO]; // Hands On
        double FEscore = -1; // Finals
        double projScore = -1; // Project
        double[] SWscores = new double [nSW]; // Seat Works
        app.reset(HOscores);  // Resets all elements in the HOscores array to -1
        app.reset(SWscores);  // Resets all elements in the SWscores array to -1
        //##############################################################################################
        int nOption = 0;
        do{
            System.out.println("------------- MENU ------------");
            System.out.println("1. Input\n2. Show\n3. Compute\n4. Configure\n5. Reset\n6. Exit");
            System.out.print("Please enter option(1-6): ");
            nOption = sc.nextInt();
            switch(nOption)
            {
       /*Input*/case 1: System.out.println("\n============================== INPUT GRADEES ==============================");
                        System.out.println("-------- Please choose which score will be entered --------");
                        System.out.println("1. Hands On Exams\n2. Final Exam\n3. Project\n4. Seatworks");
                        System.out.print("Please enter choice: ");
                        int nChoice = sc.nextInt();
                        switch (nChoice)
                        {
                            case 1: if (ctrHO == nHO)
                                        System.out.println("There are already sufficient grade inputs.");
                                    else
                                    {   System.out.print("Please enter score: ");
                                        HOscores[ctrHO] = sc.nextDouble();//put condition if puno na ctr
                                        ctrHO++;
                                    }
                                    break;
                            case 2: if (FEscore != -1)
                                        System.out.println("There are already sufficient grade inputs.");
                                    else
                                    {   System.out.print("Please enter score: ");
                                        FEscore = sc.nextDouble();//put condition if puno na
                                    }
                                    break;
                            case 3: if (projScore != -1)
                                    System.out.println("There are already sufficient grade inputs.");
                                    else
                                    {   System.out.print("Please enter score: ");
                                        projScore = sc.nextDouble();//put condition if puno na
                                    }
                                    break;
                            case 4: if (ctrSW == nSW)
                                    System.out.println("There are already sufficient grade inputs.");
                                    else
                                    {   System.out.print("Please enter score: ");
                                        SWscores[ctrSW] = sc.nextDouble();//put condition if puno na
                                        ctrSW++;
                                    }
                                    break;
                            default: System.out.println("Invalid option.");
                        }
                        System.out.println("===========================================================================");
                        break;
        /*Show*/case 2: System.out.println("\n================= SHOW GRADEES ================="); 
                        System.out.println("Hands On Exams:");      app.showGrades(HOscores);
                        System.out.print("Final Exam: ");           app.showGrades(FEscore);
                        System.out.print("Project: ");              app.showGrades(projScore);
                        System.out.println("Seatworks:");           app.showGrades(SWscores);
                        System.out.println("=================================================");
                        break;
     /*Compute*/case 3: System.out.println("\n================= COMPUTE GRADEES ================="); 
                        //boolean finalsNlngBa = app.finalsNlngBa(scores, ctr1, ctr2, ctr3, ctr4);
                        if (ctrHO == HOscores.length && FEscore == -1 && projScore != -1 && ctrSW == SWscores.length)
                        {
                            double dHOgrade = app.getAverage(HOscores);
                            double dSWgrade = app.getAverage(SWscores);
                            double preFinalGrade = dHOgrade*0.3 + projScore*0.4 + dSWgrade*0.1;
                            System.out.print("Only Final Exam score is missing. \nInitial Grade is: "+preFinalGrade
                                    +"\nPlease input your intended grade: ");
                            double intendedGrade = sc.nextDouble();
                            double whatToGetInFinals = (intendedGrade - preFinalGrade)/20 * 100;
                            System.out.printf("What you should get in the final exam to get a grade of "
                                    +intendedGrade+": %.2f",whatToGetInFinals+"\n");
                        }
                        else if (ctrHO == HOscores.length && FEscore != -1 && 
                                projScore != -1 && ctrSW == SWscores.length)
                        {   
                            double dHOgrade = app.getAverage(HOscores);
                            double dSWgrade = app.getAverage(SWscores);
                            double TotalGrade = dHOgrade*0.3 + FEscore*0.2 + projScore*0.4 + dSWgrade*0.1;
                            System.out.printf("Final Grade: %.2f",TotalGrade);
                            System.out.println("Equivalent GPE: "+app.getGPE(TotalGrade));
                        }
                        else
                            System.out.println("ERROR: there are still missing entries.");
                        System.out.println("===================================================");
                        break;
   /*Configure*/case 4: System.out.println("\n================= CONFIGURE SETTINGS ================="); 
                        System.out.println("-------- Please choose which score will be configured --------");
                        System.out.println("1. Hands On\n2. Seatworks");
                        System.out.print("Please enter choice: ");
                        int nConfigure = sc.nextInt();
                        switch(nConfigure)
                        {
                            case 1: System.out.print("How many Hands-On activity do your want to configure?: ");
                                    nHO = sc.nextInt();
                                    HOscores = Arrays.copyOf(HOscores,nHO);
                                    app.make0toNega1(HOscores);
                                    break;
                            case 2: System.out.print("How many Seatwork activity do your want to configure?: ");
                                    nSW = sc.nextInt();
                                    SWscores = Arrays.copyOf(SWscores, nSW);
                                    app.make0toNega1(SWscores);
                                    break;
                        }
                        System.out.println("========================================================");
                        break;
       /*Reset*/case 5: System.out.println("\n SCORES RESET!"); 
                        app.reset(HOscores);
                        app.reset(SWscores);
                        FEscore = -1;
                        projScore = -1;
                        break;
        /*Exit*/case 6: System.out.println("Goodbye "+strFname_Lname+"!"); break;
                default: System.out.println("Invalid option.");  
            }
        }while(nOption!=6);
        
    }
    String getNameID()
    {
        Scanner sc = new Scanner (System.in);
        System.out.print("enter name: ");
        String name = sc.nextLine();
        System.out.print("enter ID no.: ");
        int ID = sc.nextInt();
        
        String First = "";
        String Last = "";
        String Batch = "";
        Last = name.substring(0,name.indexOf(","));
        First = name.substring(name.indexOf(",")+1);
        First = First.trim();
        Last = Last.trim();
        int year = ID / 100000 + 4 + 1900;
        if (year > 99)
            Batch = "Catch "+(year/1000)+"T"+ (year%1000);
        else
            Batch = "Catch "+year;
        
        System.out.println("First name is: "+First);        
        System.out.println("Last name is: "+Last);
        System.out.println("Batch is: "+Batch);
        String strFname_Lname = First+"_"+Last;
        return strFname_Lname;
    }
    void showGrades(double[] arrScores)    // shows grades stored in arrays
    {   for (int i = 0; i < arrScores.length; i++){
            if (arrScores[i] == -1)
                System.out.println("\t["+(i+1)+"] \t\t--");
            else
                System.out.println("\t["+(i+1)+"] \t\t"+arrScores[i]);
        }
    }
    void showGrades(double varScore)   // shows grades stored in variables
    {
        if (varScore == -1)
            System.out.println("\t\t--");
        else
            System.out.println("\t\t"+varScore);
    }
    void reset(double[] scores)
    {
        for (int i = 0; i < scores.length; i++)
            scores[i] = -1;
    }
    void make0toNega1(double[] scores)
    {
        for (int i = 0; i < scores.length; i++)
        {   if (scores[i] == 0)
                scores[i] = -1;
        }
    }
    double getAverage(double[] activity)
    {
        double ave = 0;
        for (int i = 0; i < activity.length; i++)
            ave += activity[i];
        ave = ave/ activity.length;
        return ave;
    }
    double getGPE(double TotalGrade)
    {
        double GPE = 0;
        if (TotalGrade >= 94)
            GPE = 4;
        else if (TotalGrade >= 89)
            GPE = 3.5;
        else if (TotalGrade >= 83)
            GPE = 3;
        else if (TotalGrade >= 78)
            GPE = 2.5;
        else if (TotalGrade >= 72)
            GPE = 2;
        else if (TotalGrade >= 66)
            GPE = 1.5;
        else if (TotalGrade >= 60)
            GPE = 1;
        return GPE;
    }
}