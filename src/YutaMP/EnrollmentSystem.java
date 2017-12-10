//Inoue, Yuta   Salva, Trisha
import java.util.ArrayList;
import java.util.Vector;
import java.io.*;
public class EnrollmentSystem implements Enrollment{
    
    private Admin admin;
    private Student currentAccount;
    private ArrayList<Student> students;
    private ArrayList<Course> courses;
    private ArrayList<Section> sections;
    
    public EnrollmentSystem(){
        this.admin = new Admin();
        this.students = new ArrayList<>();
        students = this.studentListReader();//load
        this.courses = new ArrayList<>();
        courses = this.coursesListReader();//load
        this.sections = new ArrayList<>();
        sections = sectionsReader();//load
        this.readUpdates(sections, courses);
        this.currentAccount = null;
    }
    
    @Override
    public boolean RegisterStudentAccount(Student student){
        if(admin.getIsLogin()){
            if(!student.isLegitUnits())
                return false;
            if(students.size() > 0){
                for(Student y : students){
                    if(student.isEqual(y)){
                        return false;
                    }
                }
            }
            if(/*!student.getUserName().matches("\\d+$") ||*/ !student.isLegitUnits())
                return false;
            students.add(student);
            this.studentListWriter();//save
            return true;
        }
        else
            return false;
    }
    
    @Override
    public boolean addCourse(Course course){
        if(admin.getIsLogin()){
            //Course course = new Course(code, name, units);
            if(course.isSeven()){
                if(courses.isEmpty()){
                    courses.add(course);
                    this.coursesListWriter();
                    return true;
                }
                else{
                    for(Course c : courses){
                        if(c.isNotUnique(course)){//true if not unique
                            return false;
                        }
                    }
                    courses.add(course);
                    this.coursesListWriter();
                    return true;
                }
            }
            else 
                return false;
        }
        return false;
    }
    
    @Override
    public boolean openSection(Course course, Section section){
        if(admin.getIsLogin()){
            if(!section.isThreeChar())
                return false;
            if(!section.isValidTime())
                return false;
            if(sections.isEmpty()){
                section.setCourse(course);
                sections.add(section);
                this.sectionWriter();
                return true;
            }
            for(Section s : sections){
                if(s.getSectionName() .equals(section.getSectionName()) && s.getCourse() .getCode() .equals(course.getCode())/*s.getSectionName().equals(section.getSectionName()) && s.getCourse() .equals(course.getName())*/){
                    return false;
                }
            }
            section.setCourse(course);
            sections.add(section);
            this.sectionWriter();
            return true;
        }
        else
            return false;
    }
    
    @Override
    public String viewClassList(Section section){
        if(admin.getIsLogin()){
            String info = "Student List: \n";
            for(Student y : section.getStudents())
                info = info + y.getFullName() + "\n";
            info = info + "Total Number of slots: " + section.getCapacity() + "\n";
            info = info + "Remaining Slots: " + (section.getCapacity() - section.getStudents().size());
            return info;
        }
        return "Nothing";
    }
    
    @Override
    public boolean enlistSection(Section section){
        if(currentAccount == null)
            return false;
        if(currentAccount.getIsLogin() && !currentAccount.getIsEnrolled()){//If logged in and if not yet enrolled
            if(!sections.contains(section)){
                return false; 
            }
            if(section.isFull()){
                return false;
            }
            for(Section s : currentAccount.getEnlists()){
                if(s.getCourse().equals(section.getCourse())){
                    return false;//The student is not enlisted yet in another section for the same course code
                }
            }
            for(Section s : currentAccount.getEnlists()){
                if(!s.isNonConflic(section)){
                    return false;
                }
            }
            currentAccount.getEnlists().add(section);
            return true;
        }
        
        return false;
    }
    
    @Override
    public boolean removeEnlistment(Section section){
        if(currentAccount == null)
            return false;
        if(currentAccount.getIsLogin() && !currentAccount.getIsEnrolled()){
            if(sections.contains(section) && currentAccount.getEnlists().contains(section)){
                currentAccount.getEnlists().remove(section);
                return true;
            }
        }
        return false;
    }
    
    @Override
    public boolean enroll(){
        if(currentAccount == null)
            return false;
        if(currentAccount.getIsLogin() && !currentAccount.getIsEnrolled()){
            if(currentAccount.isEnrollReady()){
                for(Section s : currentAccount.getEnlists()){
                    currentAccount.getEnrolls().add(s);
                    
                }
                for(Section s : currentAccount.getEnrolls()){
                    s.getStudents().add(currentAccount);
                }
                currentAccount.getEnlists().clear();
                currentAccount.setIsEnrolled();
                this.enrolledWriter();
                this.updateEnroll();
                return true;
            }
        }
        return false;
    }
    
    public boolean viewEAF(){
        if(currentAccount.getIsLogin() && currentAccount.getIsEnrolled()){
            System.out.println("---------------------------------------------");
            System.out.println("Name: " + currentAccount.getFullName());
            System.out.println("ID: " + currentAccount.getUserName());
            String FORMAT = "%-10s %-30s %-10s %-30s %-20s %-5s";
            String s;
            s = String.format(FORMAT, "CODE", "COURSE", "SECTION", "TEACHER", "SCHEDULE", "UNITS");
            System.out.println(s);
            
            for(Section a : currentAccount.getEnrolls()){
                s = String.format(FORMAT, a.getCourse().getCode(), a.getCourse().getName(), a.getSectionName(), a.getFaculty(), a.getWholeSchedule(), Double.toString(a.getCourse().getUnits()));
                System.out.println(s);
            }
            System.out.println("TOTAL UNITS: " + currentAccount.getTotalUnitsEnrolled());
            System.out.println("---------------------------------------------");
        }
        return true;
    }
    
    @Override
    public boolean login(Account dummy){
 /*       if(admin.getIsLogin())
            return false;//Will not login if Admin is still logged in
        for(Student s : students)
            if(s.getIsLogin())
                return false;//Will not login if any Student is still Logged in
 */       //Account user = new Account(userName, password);
        if(dummy.equal(admin)){
            admin.setIsLogin(true);
            return true;
        }
        else{
            for(Student s : students){
                if(s.equal(dummy)){
                    s.setIsLogin(true);
                    this.currentAccount = s;
                    return true;
                }
            }
        }
        return false;
    }
    
    @Override
    public boolean logout(){
        admin.setIsLogin(false);
        for(Student s : students){
            if(s.getIsLogin())
                s.setIsLogin(false);
        }
        if(currentAccount != null)
            currentAccount.clear();
        this.currentAccount = null;
        return true;
    }
    
    public Vector getCoursesVector(){return new Vector(courses);}
    public Vector getSectionsVector(){return new Vector(sections);}
    public Vector getStudentsVector(){return new Vector(students);}
    public ArrayList<Student> getStudents(){return students;}
    public Admin getAdmin(){return admin;}
    public ArrayList<Course> getCourses(){return courses;}
    public ArrayList<Section> getSections(){return sections;}
    public Student getCurrentStudent(){return currentAccount;}
    
    public void studentListWriter(){
        File f = new File("StudentList.txt");
        File f2 = new File("a.txt");
        BufferedWriter bw;//for student list
        BufferedReader br;//for paasword
        //BufferedWriter bw2;//for password
        
        String line;
        String password = "";
        
        try{
            
            bw = new BufferedWriter(new FileWriter(f));
            //bw2 = new BufferedWriter(new FileWriter(f2));
            
            for(int i = 0; i < students.size(); i++){
                br = new BufferedReader(new FileReader(f2));
                students.get(i).passwordWriter();
                password = br.readLine();
                
                bw.write("Username=" + students.get(i).getUserName());
                bw.newLine();
                bw.write("Password=" + password);
                bw.newLine();
                bw.write("First Name=" + students.get(i).getFirst());
                bw.newLine();
                bw.write("Last Name=" + students.get(i).getLast());
                bw.newLine();
                bw.write("Minimum Units=" + Double.toString(students.get(i).getMin()));
                bw.newLine();
                bw.write("Maximum Units=" + Double.toString(students.get(i).getMax()));
                bw.newLine();
                
                
            }//for loop
            bw.flush();
            bw.close();
        }catch(Exception e){
            System.out.println("(Enrollment System:studentListWriter)" + e.toString() + f2.getAbsolutePath());
        }//try catch
    }
    
    public ArrayList<Student> studentListReader(){
        File f = new File("StudentList.txt");
        BufferedReader br;
        String line;
        ArrayList<Student> students = new ArrayList<>();
        Student s = null;
        
        String username = null;
        String password = null;
        String firstName = null;
        String lastName = null;
        double minUnits = -1;
        double maxUnits = -1;
        
        try{
            br = new BufferedReader(new FileReader(f));
            while((line = br.readLine()) != null){
                if(line.substring(0, line.indexOf('=')).equalsIgnoreCase("Username"))
                    username = line.substring(line.indexOf('=') + 1);
                if(line.substring(0, line.indexOf('=')).equalsIgnoreCase("Password"))
                    password = line.substring(line.indexOf('=') + 1);
                if(line.substring(0, line.indexOf('=')).equalsIgnoreCase("First name"))
                    firstName = line.substring(line.indexOf('=') + 1);
                if(line.substring(0, line.indexOf('=')).equalsIgnoreCase("Last Name"))
                    lastName = line.substring(line.indexOf('=') + 1);
                if(line.substring(0, line.indexOf('=')).equalsIgnoreCase("Minimum Units")){
                    minUnits = Double.parseDouble(line.substring(line.indexOf ('=') + 1));
                }
                if(line.substring(0, line.indexOf('=')).equalsIgnoreCase("Maximum Units")){
                    maxUnits = Double.parseDouble(line.substring(line.indexOf ('=') + 1));
                }
                
                if(maxUnits >= 0){
                    s = new Student(username, password, lastName, firstName, minUnits, maxUnits);
                    username = null;
                    password = null;
                    firstName = null;
                    lastName = null;
                    minUnits = -1;
                    maxUnits = -1;
                    students.add(s);
                }
            }//while
            br.close();
            
        }catch(Exception e){
            System.out.println("(EnrollmentSystem:studentReader)" + e.toString());
        }
        return students;
    }
    
    public void coursesListWriter(){
        File f = new File("CourseList.txt");
        BufferedWriter bw;
        
        try{
            bw = new BufferedWriter(new FileWriter(f));
            
            for(Course c : courses){
                bw.write("Course Code=" + c.getCode());
                bw.newLine();
                bw.write("Course Name=" + c.getName());
                bw.newLine();
                bw.write("Course Units=" + Double.toString(c.getUnits()));
                bw.newLine();
            }
            bw.flush();
            bw.close();
            
        }catch(Exception e){
            System.out.println("(EnrollmentSystem:courseListWriter): " + e.toString());
        }
    }
    
    public ArrayList<Course> coursesListReader(){
        File f = new File("CourseList.txt");
        
        BufferedReader br;
        String line;
        ArrayList<Course> courses = new ArrayList<>();
        Course c = null;
        String code = null;
        double units = -1;
        String name = null;
        try{
            br = new BufferedReader(new FileReader(f));
            while((line = br.readLine()) != null){
                if(line.substring(0, line.indexOf('=')).equalsIgnoreCase("Course Code")){
                    code = line.substring(line.indexOf('=') + 1);
                }
                if(line.substring(0, line.indexOf('=')).equalsIgnoreCase("Course Name")){
                    name = line.substring(line.indexOf('=') + 1);
                }
                if(line.substring(0, line.indexOf('=')).equalsIgnoreCase("Course Units")){
                    units = Double.parseDouble(line.substring(line.indexOf ('=') + 1));
                }
                
                if(units != -1){
                    c = new Course(code, name, units);
                    code = null;
                    name = null;
                    units = -1;
                    courses.add(c);
                }
            }
            br.close();
            
        }catch(Exception e)
        {
            System.out.println("(EnrollmentSystem:courseListReader): " + e.toString());
        }
        return courses;
    }
    
    public void sectionWriter(){
        File f = new File("Section.txt");
        BufferedWriter bw;//for this sectionWriter
        
        try{
            bw = new BufferedWriter(new FileWriter(f));
            
            for(Section s : sections){
                bw.write("Course Code=" + s.getCourse().getCode());
                bw.newLine();
                bw.write("Course Name=" + s.getCourse().getName());
                bw.newLine();
                bw.write("Course Units=" + Double.toString(s.getCourse().getUnits()));
                bw.newLine();
                bw.write("Section Name=" + s.getSectionName());
                bw.newLine();
                bw.write("Faculty=" + s.getFaculty());
                bw.newLine();
                bw.write("Schedule=" + s.getSchedule());
                bw.newLine();
                bw.write("Start Time=" + s.getStartTime());
                bw.newLine();
                bw.write("End Time=" + s.getEndTime());
                bw.newLine();
                bw.write("Capacity=" + Integer.toString(s.getCapacity()));
                bw.newLine();
            }
            bw.flush();
            bw.close();
            
        }catch(Exception e){
            System.out.println("(EnrollmentSystem:sectionWriter): " + e.toString());
        }
    }
    
    public ArrayList<Section> sectionsReader(){
        File f = new File("Section.txt");
        
        BufferedReader br;
        String line;
        ArrayList<Section> sections = new ArrayList<>();
        Section s = null;
        Course c = null;
        
        String courseCode = null;
        String courseName = null;
        double units = -1;
        String name = null;
        String faculty = null;
        String schedule = null;
        String start = null;
        String end = null;
        int capacity = -1;
        
        try{
            br = new BufferedReader(new FileReader(f));
            while((line = br.readLine()) != null){
                if(line.substring(0, line.indexOf('=')).equalsIgnoreCase("Course Code")){
                    courseCode = line.substring(line.indexOf('=') + 1);
                }
                if(line.substring(0, line.indexOf('=')).equalsIgnoreCase("Course Name")){
                    courseName = line.substring(line.indexOf('=') + 1);
                }
                if(line.substring(0, line.indexOf('=')).equalsIgnoreCase("Course Units")){
                    units = Double.parseDouble(line.substring(line.indexOf('=') + 1));
                }
                if(line.substring(0, line.indexOf('=')).equalsIgnoreCase("Section Name")){
                    name = line.substring(line.indexOf('=') + 1);
                }
                if(line.substring(0, line.indexOf('=')).equalsIgnoreCase("Faculty")){
                    faculty = line.substring(line.indexOf('=') + 1);
                }
                if(line.substring(0, line.indexOf('=')).equalsIgnoreCase("Schedule")){
                    schedule = line.substring(line.indexOf('=') + 1);
                }
                if(line.substring(0, line.indexOf('=')).equalsIgnoreCase("Start Time")){
                    start = line.substring(line.indexOf('=') + 1);
                }
                if(line.substring(0, line.indexOf('=')).equalsIgnoreCase("End Time")){
                    end = line.substring(line.indexOf('=') + 1);
                }
                if(line.substring(0, line.indexOf('=')).equalsIgnoreCase("Capacity")){
                    capacity = Integer.parseInt(line.substring(line.indexOf ('=') + 1));
                }
                if(capacity >= 0){
                    s = new Section(name, faculty, schedule, start, end, capacity);
                    c = new Course(courseCode, courseName, units);
                    s.setCourse(c);
                    courseCode = null;
                    courseName = null;
                    units = -1;
                    name = null;
                    faculty = null;
                    schedule = null;
                    start = null;
                    end = null;
                    capacity = -1;
                    sections.add(s);
                }
            }
            br.close();
            
            }catch(Exception e)
        {
            System.out.println("(EnrollmentSystem:sectionReader): " + e.toString());
        }
        return sections;
    }
    
    public void updateEnroll(){
        File f = new File("Update.txt");
        BufferedWriter bw;//for this sectionWriter
        
        try{
            bw = new BufferedWriter(new FileWriter(f));
            bw.write("Cut");
            bw.newLine();
            for(Section s : sections){
                
                bw.write("Course Code=" + s.getCourse().getCode());
                bw.newLine();
                bw.write("Course Name=" + s.getCourse().getName());
                bw.newLine();
                bw.write("Course Units=" + Double.toString(s.getCourse().getUnits()));
                bw.newLine();
                bw.write("Section Name=" + s.getSectionName());
                bw.newLine();
                bw.write("Faculty=" + s.getFaculty());
                bw.newLine();
                bw.write("Schedule=" + s.getSchedule());
                bw.newLine();
                bw.write("Start Time=" + s.getStartTime());
                bw.newLine();
                bw.write("End Time=" + s.getEndTime());
                bw.newLine();
                bw.write("Capacity=" + Integer.toString(s.getCapacity()));
                bw.newLine();
                for(Student a : s.getStudents()){
                    bw.write("Student=" + a.getUserName());
                    bw.newLine();
                }
                bw.write("Cut");
                bw.newLine();
            }
            bw.flush();
            bw.close();
            
        }catch(Exception e){
            System.out.println("(EnrollmentSystem:updateEnroll): " + e.toString());
        }
    }
    
    public void readUpdates(ArrayList<Section> sections, ArrayList<Course> courses){
        File f = new File("Update.txt");
        
        BufferedReader br;
        String line;
        Section s = null;
        Student student = null;
        Course c = null;
        
        String courseCode = null;
        String courseName = null;
        String userName = null;
        double units = -1;
        String sectionName = null;
        String faculty = null;
        String schedule = null;
        String start = null;
        String end = null;
        int capacity = -1;
        int sectionIndex = 0;
        
        try{
            br = new BufferedReader(new FileReader(f));
            
            while((line = br.readLine()) != null){
                if(line.equals("Cut")){
                    courseCode = null;
                    courseName = null;
                    userName = null;
                    units = -1;
                    sectionName = null;
                    faculty = null;
                    schedule = null;
                    start = null;
                    end = null;
                    capacity = -1;
                }
                else{
                    if(line.substring(0, line.indexOf('=')).equalsIgnoreCase("Course Code")){
                        courseCode = line.substring(line.indexOf('=') + 1);
                    }
                    if(line.substring(0, line.indexOf('=')).equalsIgnoreCase("Course Name")){
                        courseName = line.substring(line.indexOf('=') + 1);
                    }
                    if(line.substring(0, line.indexOf('=')).equalsIgnoreCase("Course Units")){
                        units = Double.parseDouble(line.substring(line.indexOf('=') + 1));
                    }
                    if(line.substring(0, line.indexOf('=')).equalsIgnoreCase("Section Name")){
                        sectionName = line.substring(line.indexOf('=') + 1);
                    }
                    if(line.substring(0, line.indexOf('=')).equalsIgnoreCase("Faculty")){
                        faculty = line.substring(line.indexOf('=') + 1);
                    }
                    if(line.substring(0, line.indexOf('=')).equalsIgnoreCase("Schedule")){
                        schedule = line.substring(line.indexOf('=') + 1);
                    }
                    if(line.substring(0, line.indexOf('=')).equalsIgnoreCase("Start Time")){
                        start = line.substring(line.indexOf('=') + 1);
                    }
                    if(line.substring(0, line.indexOf('=')).equalsIgnoreCase("End Time")){
                        end = line.substring(line.indexOf('=') + 1);
                    }
                    if(line.substring(0, line.indexOf('=')).equalsIgnoreCase("Capacity")){
                        capacity = Integer.parseInt(line.substring(line.indexOf('=') + 1));
                        /*
                        s = new Section(sectionName, faculty, schedule, start, end, capacity);
                        c = new Course(courseCode, courseName, units);
                        */
                        for(Section find : sections){
                            if(find.getSectionName().equals(sectionName))
                                s = find;
                        }
                        for(Course find : courses){
                            if(find.getCode().equals(courseCode))
                                c = find;
                        }
                        s.setCourse(c);
                    }
                    if(line.substring(0, line.indexOf('=')).equalsIgnoreCase("Student")){
                        userName = line.substring(line.indexOf('=') + 1);
                        for(Student find : students){
                            if(find.getUserName().equalsIgnoreCase(userName))
                                student = find;
                        }
                        student.getEnrolls().add(s);
                        s.getStudents().add(student);
                        student.setIsEnrolled();
                    }
                    
                }
            }//while
            
            br.close();
            
            }catch(Exception e)
        {
            System.out.println("(EnrollmentSystem:readUpdates): " + e.toString());
        }
    }
    
    public void enrolledWriter(){
        File f = new File("Enrolled.txt");
        BufferedWriter bw;
        int i = 0;
        int j = 0;
        try{
            bw = new BufferedWriter(new FileWriter(f));
            for(Section ch : sections){
                j = 0;
                bw.write("Course Code=" + ch.getCourse().getCode());
                bw.newLine();
                bw.write("Section=" + ch.getSectionName());
                bw.newLine();
                if(ch.getStudents().isEmpty()){
                    bw.write("Student=none");
                    bw.newLine();
                }
                else{
                    for(Student s : ch.getStudents()){
                        bw.write("Student=" + s.getUserName());
                        bw.newLine();
                        j++;
                    }
                }
                bw.write("Cut");
                bw.newLine();
                i++;
            }
            bw.flush();
            bw.close();
        }catch(Exception e){
            System.out.println("(EnrollmentSystem:enrollWriter)" + e.toString());
        }
    }
    
    public void enrolledReader(ArrayList<Section> sections){
        File f = new File("Enrolled.txt");
        BufferedReader br;
        
        Section section = null;
        Course course = null;
        Student student = null;
        
        String line;
        String secStr = null;
        String studStr = null;
        String corsStr = null;
        
        try{
            br = new BufferedReader(new FileReader(f));
            while((line = br.readLine()) != null){
                if(line.equals("Cut")){
                    sections.add(section);
                    System.out.println(sections);
                    student = null;
                    course = null;
                    section = null;
                    studStr = null;
                    secStr = null;
                    corsStr = null;
                }
                else if(line.substring(0, line.indexOf('=')).equalsIgnoreCase("Course Code")){
                    corsStr = line.substring(line.indexOf('=') + 1);
                }
                else if(line.substring(0, line.indexOf('=')).equalsIgnoreCase("Section")){
                    secStr = line.substring(line.indexOf('=') + 1);
                }
                else if(line.substring(0, line.indexOf('=')).equalsIgnoreCase("Student")){
                    studStr = line.substring(line.indexOf('=') + 1);
                }
                
                if(secStr != null && studStr != null && corsStr != null){
                    for(Course find : courses){
                        if(corsStr.equals(find.getCode()))
                        course = find;
                    }
                    for(Section find : this.sections){
                        if(find.getCourse().getCode().equals(corsStr) && find.getSectionName().equals(secStr)){
                            section = find;
                            section.setCourse(course);
                        }
                    }
                    if(!studStr.equals("none")){
                        for(Student find : students){
                            if(studStr.equals(find.getUserName()))
                                student= find;
                        }
                        section.getStudents().add(student);
                        student.setIsEnrolled();
                        // ensure course-sec is not yet in student's list
                        student.getEnrolls().add(section);
                        student = null;
                    }
                    
                }
                
            }//while
            br.close();
        }catch(Exception e){
            System.out.println("(EnrollmentSystem:enrollmentReader)" + e.toString());
        }
    }
    
    @Override
    public String toString(){return "Machine Project\nInoue, Yuta\nSalva, Trisha";}
    
}
