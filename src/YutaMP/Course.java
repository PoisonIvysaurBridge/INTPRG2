//Inoue, Yuta   Salva, Trisha
import java.io.*;
import java.util.ArrayList;
public class Course {
    
    private String courseCode;
    private String courseName;
    private double courseUnit;
    
    public Course(String code, String name, double units){
        code = code.toUpperCase();
        this.courseCode = code;
        this.courseName = name;
        this.courseUnit = units;
    }
    
    public Course(String code, double units){
        code = code.toUpperCase();
        this.courseCode = code;
        this.courseUnit = units;
        this.courseName = "UNKNOWN";
    }
    
    public String getCode(){return courseCode;}
    public String getName(){return courseName;}
    public double getUnits(){return courseUnit;}
    
    public boolean isSeven(){//returns true if code is 7
        return courseCode.matches("[\\w-]{7}$");
    }
    
    public boolean isNotUnique(Course c){//returns true if not unique
        return this.courseCode.equals(c.courseCode);
    }
    
    @Override
    public String toString(){
        return this.courseCode;
    }
    
}
