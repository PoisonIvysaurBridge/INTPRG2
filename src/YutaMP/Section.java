//Inoue, Yuta   Salva, Trisha
import java.util.ArrayList;
import java.io.*;
public class Section {
    
    private String sectionName;
    private String faculty;
    private String schedule;
    private String startTime;
    private String endTime;
    private int capacity;
    private ArrayList<Student> students;
    private Course course;
    
    public Section(String name, String faculty, String schedule, String start, String end, int capacity){
        this.sectionName = name;
        this.faculty = faculty;
        this.schedule = schedule;
        this.startTime = start;
        this.endTime = end;
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }
    
    public String getSchedule(){return schedule;}
    public String getStartTime(){return startTime;}
    public String getEndTime(){return endTime;}
    public String getSectionName(){return sectionName;}
    public String getFaculty(){return faculty;}
    public int getCapacity(){return capacity;}
    public ArrayList<Student> getStudents(){return students;}
    public Course getCourse(){return course;}
    public String getWholeSchedule(){return schedule + " " + startTime + "-" + endTime;}
    public void setCourse(Course c){this.course = c;}
    public boolean isFull(){return capacity == students.size();}
    public boolean isValidSchedule(){return schedule.equals("MW") || schedule.equals("TH");}
    public boolean isValidTime(){return startTime.matches("^([0-9]|0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$") && endTime.matches("^([0-9]|0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$") 
                                        && (!startTime.equals(endTime) && (this.toMin(startTime) <= this.toMin(endTime)));}
    
    public boolean isNonConflic(Section s){//returns false if there is a conflic in schedule and used for enlisting

        int start = toMin(startTime);
        int end = toMin(endTime);
        int otherStart = toMin(s.startTime);
        int otherEnd = toMin(s.endTime);
        if(start >= end || otherStart >= otherEnd){
            return false;
        }//ex) start 7:30 end 6:00
        
        //think it over again
        if(this.schedule .equals(s.schedule)){//MW or TH
            if(start == otherStart || end == otherEnd || (end >= otherStart && start <= otherStart)
                || (start <= otherEnd && end >= otherEnd) || (end >= otherEnd && otherStart >= start) 
                || (otherEnd >= end && start >= otherStart) )
                return false; 
        }
        return true;
    }
    
    public boolean isUnique(Section s){return !(this.sectionName .equals(s.sectionName));}
    
    public boolean isThreeChar(){return sectionName.matches("\\w{3}");}
    
    public String getInfo(){
        String FORMAT = "%-10s %-2s %-30s";
        String s, a;
        s = String.format(FORMAT, "Code",":", course.getCode());
        s = s + "\n" + String.format(FORMAT, "Course", ":", course.getName());
        s = s + "\n" + String.format(FORMAT, "Section",":", sectionName);
        s = s + "\n" + String.format(FORMAT, "Teacher",":", faculty);
        s = s + "\n" + String.format(FORMAT, "Schedule",":", getWholeSchedule());
        s = s + "\n" + String.format(FORMAT, "Units",":", course.getUnits());
        s = s + "\nRemaining: " + (capacity - students.size());
        return s;
    }
    
    @Override
    public String toString(){return this.sectionName + "(" + course.getCode() + ")";}
    
    private int toMin(String time){
        int min = 0;
        int index = time.indexOf(":");
        int hh = Integer.parseInt(time.substring(0, index));
        int mm = Integer.parseInt(time.substring(index + 1));
        min = (hh * 60) + mm;
        return min;
    }
    
    private String toHHMM(int min){
        String hhmm = "";
        int hh = min / 60;
        int mm = min % 60;
        hhmm = hh + ":" + mm;
        if(mm == 0)
            hhmm = hh + ":" + "00";
        return hhmm;
    }
     
}
