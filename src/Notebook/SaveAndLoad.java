import java.io.*;
import java.util.*;
public class SaveAndLoad {
    
    public void Writer(ArrayList<Course> courses){
        File f = new File("Course.txt");
        BufferedWriter bw;
        
        try{
            bw = new BufferedWriter(new FileWriter(f));
            
            for(Course c : courses){
                bw.write("Course=" + c.getCode());
                bw.newLine();
                bw.write("Name=" + c.getName());
                bw.newLine();
                bw.write("Units=" + Double.toString(c.getUnits()));
                bw.newLine();
            }
            bw.flush();
            bw.close();
            
        }catch(Exception e){
            System.out.println("(SaveAndLoad:Writer): " + e.toString());
        }
        
        
    }
    
    public ArrayList<Course> Reader(){
        File f = new File("Course.txt");
        
        BufferedReader br;
        String line;
        ArrayList<Course> courses = new ArrayList<>();
        Course c = null;
        
        String code = null;
        String name = null;
        double units = -1;
        try{
            br = new BufferedReader(new FileReader(f));
            while((line = br.readLine()) != null){
                if(line.substring(0, line.indexOf('=')).equalsIgnoreCase("Course")){
                    code = line.substring(line.indexOf('=') + 1);
                }
                if(line.substring(0, line.indexOf('=')).equalsIgnoreCase("Name")){
                    name = line.substring(line.indexOf('=') + 1);
                }
                if(line.substring(0, line.indexOf('=')).equalsIgnoreCase("Units")){
                    units = Double.parseDouble(line.substring(line.indexOf ('=') + 1));
                }
                
                if(units != -1){
                    if(code != null && name != null)
                        c = new Course(code, name, units);
                    else
                        c = new Course(code, units);
                    code = null;
                    name = null;
                    units = -1;
                    courses.add(c);
                }
            }
            br.close();
            
        }catch(Exception e)
        {
            System.out.println("(SaveAndLoad:Reader): " + e.toString());
        }
        return courses;
    }
    public static void main(String[] args) {
        
    }
    
}
