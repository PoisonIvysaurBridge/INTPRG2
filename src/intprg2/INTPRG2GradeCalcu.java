package intprg2;
// Ivana Lim #14
import java.util.*;
public class INTPRG2GradeCalcu
{
    public static void main(String[] args) 
    {
        INTPRG2GradeCalcu app = new INTPRG2GradeCalcu();
        Scanner sc = new Scanner (System.in);
        String strFname_Lname = app.getNameID();
        
//##################################################### PART 2 ###############################################################       
        //how many in each grading activity
        int nHO = 2;    int ctr1 = 0;
        int nFinals = 1;    int ctr2 = 0;
        int nProject = 1;   int ctr3 = 0;
        int nSW = 5;    int ctr4 = 0;
        
        // initialize the scores #######################################################################
        ArrayList arHandsOns = new ArrayList(nHO); // Hands On
        ArrayList arFinalExams = new ArrayList(nFinals); // Finals
        ArrayList arProjects = new ArrayList(nProject); // Project
        ArrayList arSeatworks = new ArrayList(nSW); // Seat Works
        app.reset(arHandsOns, arFinalExams, arProjects, arSeatworks);  // Resets all elements in the scores array to -1
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
                                        arHandsOns.add(sc.nextDouble());//put condition if puno na ctr
                                        strHOscores+= arHandsOns.get(ctr1)+" ";
                                        ctr1++;
                                    }
                                    break;
                            case 2: if (ctr2 == nFinals)
                                        System.out.println("There are already sufficient grade inputs.");
                                    else
                                    {   System.out.print("Please enter score: ");
                                        arFinalExams.add(sc.nextDouble());//put condition if puno na
                                        strFinalscores+= arFinalExams.get(ctr2)+" ";
                                        ctr2++;
                                    }
                                    break;
                            case 3: if (ctr3 == nProject)
                                    System.out.println("There are already sufficient grade inputs.");
                                    else
                                    {   System.out.print("Please enter score: ");
                                        arProjects.add(sc.nextDouble());//put condition if puno na
                                        strProjscores+= arProjects.get(ctr3)+" ";
                                        ctr3++;
                                    }
                                    break;
                            case 4: if (ctr4 == nSW)
                                    System.out.println("There are already sufficient grade inputs.");
                                    else
                                    {   System.out.print("Please enter score: ");
                                        arSeatworks.add(sc.nextDouble());//put condition if puno na
                                        strSWscores+= arSeatworks.get(ctr4)+" ";
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
                        if (ctr1 == nHO && ctr2 == 0 && ctr3 == nProject && ctr4 == nSW)
                        {
                            double dHOgrade = app.getAverage(arHandsOns);
                            double dProjgrade = app.getAverage(arProjects);
                            double dSWgrade = app.getAverage(arSeatworks);
                            double preFinalGrade = dHOgrade*0.3 + dProjgrade*0.4 + dSWgrade*0.1;
                            
                            System.out.print("Only Final Exam score is missing. \nInitial Grade is: "+preFinalGrade+"\nPlease input your intended grade: ");
                            double intendedGrade = sc.nextDouble();
                            double whatToGetInFinals = (intendedGrade - preFinalGrade)/20 * 100;
                            System.out.println("What you should get in the final exam to get a grade of "+intendedGrade+": %.2f"+whatToGetInFinals+"\n");
                        }
                        else if (ctr1 == nHO && ctr2 == nFinals && 
                                ctr3 == nProject && ctr4 == nSW)
                        {
                            double dHOgrade = app.getAverage(arHandsOns);
                            double dProjgrade = app.getAverage(arProjects);
                            double dSWgrade = app.getAverage(arSeatworks);
                            double TotalGrade = dHOgrade*0.3 + (double)arFinalExams.get(0)*0.2 + dProjgrade*0.4 + dSWgrade*0.1;
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
                        app.reset(arHandsOns, arFinalExams, arProjects, arSeatworks);  // Resets all elements in the scores array to -1
                        strHOscores = "";       ctr1 = 0;
                        strFinalscores = "";    ctr2 = 0;
                        strProjscores = "";     ctr3 = 0;
                        strSWscores = "";       ctr4 = 0;
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
    void reset(ArrayList arHandsOns, ArrayList arFinalExams, ArrayList arProjects, ArrayList arSeatworks)
    {
        //arHandsOns, arFinalExams, arProjects, arSeatworks
        arHandsOns.clear();
        arFinalExams.clear();
        arProjects.clear();
        arSeatworks.clear();
    }
    double getAverage(ArrayList array)
    {
        double ave = 0;
        for (int i = 0; i < array.size(); i++)
            ave += (double)array.get(i);
        ave = ave/ array.size();
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