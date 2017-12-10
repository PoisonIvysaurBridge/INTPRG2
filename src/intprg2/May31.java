package intprg2;
// Ivana Lim #14
import java.util.*;
public class May31
{
    public static void main(String[] args) 
    {
        May31 app = new May31();
        Scanner sc = new Scanner (System.in);
        String strFname_Lname = app.getNameID();
        
//##################################################### PART 2 ###############################################################       
        //how many in each grading activity
        int nHO = 2;    int ctr1 = 0;
        int nFinals = 1;    int ctr2 = 0;
        int nProject = 1;   int ctr3 = 0;
        int nSW = 5;    int ctr4 = 0;
        
        // initialize the scores #######################################################################
        double [][] scores = new double [4][];
        scores[0] = new double [nHO]; // Hands On
        scores[1] = new double [nFinals]; // Finals
        scores[2] = new double [nProject]; // Project
        scores[3] = new double [nSW]; // Seat Works
        app.reset(scores);  // Resets all elements in the scores array to -1
        String strHOscores = "";
        String strFinalscores = "";
        String strProjscores = "";
        String strSWscores = "";
        //##############################################################################################
        int nOption = 0;
        do{
            System.out.println("------------- MENU ------------");
            System.out.println("1. Input\n2. Show\n3. Compute\n4. Configure\n5. Reset\n6. Exit");
            System.out.print("Please enter option(1-6): ");
            nOption = sc.nextInt();
            switch(nOption)
            {
       /*Input*/case 1: System.out.println("Hi "+strFname_Lname+", input grades.");
                        System.out.println("-------- Please choose which score will be entered --------");
                        System.out.println("1. Hands On\n2. Final Exam\n3. Project\n4. Seatworks");
                        System.out.print("Please enter choice: ");
                        int nChoice = sc.nextInt();
                        switch (nChoice)
                        {
                            case 1: if (ctr1 == nHO)
                                        System.out.println("There are already sufficient grade inputs.");
                                    else
                                    {   System.out.print("Please enter score: ");
                                        scores[0][ctr1] = sc.nextDouble();//put condition if puno na ctr
                                        strHOscores+= scores[0][ctr1]+" ";
                                        ctr1++;
                                    }
                                    break;
                            case 2: if (ctr2 == nFinals)
                                        System.out.println("There are already sufficient grade inputs.");
                                    else
                                    {   System.out.print("Please enter score: ");
                                        scores[1][ctr2] = sc.nextDouble();//put condition if puno na
                                        strFinalscores+= scores[1][ctr2]+" ";
                                        ctr2++;
                                    }
                                    break;
                            case 3: if (ctr3 == nProject)
                                    System.out.println("There are already sufficient grade inputs.");
                                    else
                                    {   System.out.print("Please enter score: ");
                                        scores[2][ctr3] = sc.nextDouble();//put condition if puno na
                                        strProjscores+= scores[2][ctr3]+" ";
                                        ctr3++;
                                    }
                                    break;
                            case 4: if (ctr4 == nSW)
                                    System.out.println("There are already sufficient grade inputs.");
                                    else
                                    {   System.out.print("Please enter score: ");
                                        scores[3][ctr4] = sc.nextDouble();//put condition if puno na
                                        strSWscores+= scores[3][ctr4]+" ";
                                        ctr4++;
                                    }
                                    break;
                            default: System.out.println("Invalid option.");
                        }
                        break;
        /*Show*/case 2: System.out.println("Hi "+strFname_Lname+", display grades entered."); 
                        app.showGrades(strHOscores, strFinalscores, strProjscores, strSWscores);
                        break;
     /*Compute*/case 3: System.out.println("Hi "+strFname_Lname+", compute final grade, GPE or final exam score."); 
                        //boolean finalsNlngBa = app.finalsNlngBa(scores, ctr1, ctr2, ctr3, ctr4);
                        if (ctr1 == scores[0].length && ctr2 == 0 && ctr3 == scores[2].length && ctr4 == scores[3].length)
                        {
                            double dHOgrade = app.getAverage(scores, 0);
                            double dProjgrade = app.getAverage(scores, 2);
                            double dSWgrade = app.getAverage(scores, 3);
                            double preFinalGrade = dHOgrade*0.3 + dProjgrade*0.4 + dSWgrade*0.1;
                            
                            System.out.print("Only Final Exam score is missing. \nInitial Grade is: "+preFinalGrade+"\nPlease input your intended grade: ");
                            double intendedGrade = sc.nextDouble();
                            double whatToGetInFinals = (intendedGrade - preFinalGrade)/20 * 100;
                            System.out.printf("What you should get in the final exam to get a grade of "+intendedGrade+": %.2f",whatToGetInFinals+"\n");
                        }
                        else if (ctr1 == scores[0].length && ctr2 == scores[1].length && 
                                ctr3 == scores[2].length && ctr4 == scores[3].length)
                        {
                            double dHOgrade = app.getAverage(scores, 0);
                            double dProjgrade = app.getAverage(scores, 2);
                            double dSWgrade = app.getAverage(scores, 3);
                            double TotalGrade = dHOgrade*0.3 + scores[1][0]*0.2 + dProjgrade*0.4 + dSWgrade*0.1;
                            System.out.println("Final Grade: "+TotalGrade);
                            System.out.println("Equivalent GPE: "+app.getGPE(TotalGrade));
                        }
                        else
                            System.out.println("ERROR: there are still missing entries.");
                        break;
   /*Configure*/case 4: System.out.println("Hi "+strFname_Lname+", change settings."); 
                        System.out.println("-------- Please choose which score will be configured --------");
                        System.out.println("1. Hands On\n2. Final Exam\n3. Project\n4. Seatworks");
                        System.out.print("Please enter choice: ");
                        int nConfigure = sc.nextInt();
                        switch(nConfigure)
                        {
                            case 1: System.out.print("How many Hands-On activity do your want to configure?: ");
                                    nHO = sc.nextInt();
                                    break;
                            case 2: System.out.print("How many Final Exam Activity do your want to configure?: ");
                                    nFinals = sc.nextInt();
                                    break;
                            case 3: System.out.print("How many Project activity do your want to configure?: ");
                                    nProject = sc.nextInt();
                                    break;
                            case 4: System.out.print("How many Seatwork activity do your want to configure?: ");
                                    nSW = sc.nextInt();
                                    break;
                        }
                        break;
       /*Reset*/case 5: System.out.println("Hi "+strFname_Lname+", clear entries."); 
                        app.reset(scores);
                        strHOscores = "";
                        strFinalscores = "";
                        strProjscores = "";
                        strSWscores = "";
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
    void showGrades(String strHOscores, String strFinalscores, String strProjscores, String strSWscores)
    {
        if (strHOscores.equals("")) strHOscores = "N/A";
        if (strFinalscores.equals("")) strFinalscores = "N/A";
        if (strProjscores.equals("")) strProjscores = "N/A";
        if (strSWscores.equals("")) strSWscores = "N/A";
        System.out.println("Recorded Hands On scores: "+strHOscores);
        System.out.println("Recorded Final score: "+strFinalscores);
        System.out.println("Recorded Project score: "+strProjscores);
        System.out.println("Recorded Seatwork scores: "+strSWscores);
    }
    void reset(double [][] scores)
    {
        for (int i = 0; i < scores.length; i++)
            for (int j =0; j < scores[i].length; j++)
                scores[i][j] = -1;
    }
    double getAverage(double[][] activity, int row)
    {
        double ave = 0;
        for (int i = 0; i < activity[row].length; i++)
            ave += activity[row][i];
        ave = ave/ activity[row].length;
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