//Inoue, Yuta   Salva, Trisha
import java.util.*;
import java.io.*;
public class Student extends Account {
    
    private String firstName;
    private String hidden;
    private String lastName;
    private boolean isEnrolled;
    private double minUnit;
    private double maxUnit;
    private ArrayList<Section> enlists;
    private ArrayList<Section> enrolls;
    
    
    public Student(String userName, String password, String lastName, String firstName, double minUnit, double maxUnit){
        super(userName, password);
        this.hidden = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isEnrolled = false;//not enrolled from the start
        this.minUnit = minUnit;
        this.maxUnit = maxUnit;
        this.enlists = new ArrayList<>();
        this.enrolls = new ArrayList<>();
    }
    
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    
    public void setIsEnrolled(){
        this.isEnrolled = true;
    }
    
    public boolean isEqual(Student s){//return true if equal, else not equal
        String myID = this.getUserName();
        String otherID = s.getUserName();
        return myID.equals(otherID);
    }
    
    public boolean getIsEnrolled(){return isEnrolled;}
    public ArrayList<Section> getEnlists(){return enlists;}
    public ArrayList<Section> getEnrolls(){return enrolls;}
    public String getFullName(){return lastName + "," + firstName;}
    public String getFirst(){return firstName;}
    public String getLast(){return lastName;}
    public double getMin(){return minUnit;}
    public double getMax(){return maxUnit;}
    public void clear(){
        enlists.clear();
    }
    
    public boolean isLegitUnits(){
        return minUnit <= maxUnit && minUnit >= 0 && maxUnit >= 0;
    }
    
    public double getTotalUnitsEnlisted(){
        double total = 0;
        for(Section s : enlists){
            total += s.getCourse().getUnits();
        }
        return total;
    }
    
    public double getTotalUnitsEnrolled(){
        double total = 0;
        
        for(Section s : enrolls){
            total += (s.getCourse() != null ? s.getCourse ().getUnits() : 0);
        }
        return total;
    }
    
    public boolean isEnrollReady(){
        return getTotalUnitsEnlisted() >= minUnit && getTotalUnitsEnlisted() <= maxUnit;
    }
    
    @Override
    public String toString(){return this.getUserName();}
    public Vector getEnrolledVector(){return new Vector(enrolls);}
    public Vector getEnlistedSectionsVector(){return new Vector(enlists);}
    public Vector getEnlistedCourseVector(){
        ArrayList<Course> courses = new ArrayList<>();
        for(Section check : enlists){
            courses.add(check.getCourse());
        }
        return new Vector(courses);
    }
    
    public void passwordWriter(){
        File f = new File("a.txt");
        BufferedWriter bw;
        
        try{
            
            bw = new BufferedWriter(new FileWriter(f));
            bw.write(hidden);
            bw.newLine();
            bw.flush();
            bw.close();
        }catch(Exception e){
            System.out.println("(Student:passwordWriter)" + e.toString());
        }
    }
}
