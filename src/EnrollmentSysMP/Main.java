package EnrollmentSysMP;
//package EnrollmentSysMP;

public class Main 
{
	public static void main(String[] args) 
    {
        Admin admin = new Admin();
        admin.loadAllStudents();
        admin.loadAllCourses();
        admin.loadAllSections();
        admin.loadEnrolledStudents();
    	LoginPage adminApp = new LoginPage(admin);
        //EnrollmentSysTest oop = new EnrollmentSysTest(); 
    }
}
