public interface Enrollment {
    boolean RegisterStudentAccount(Student s);
    boolean addCourse(Course c);
    boolean openSection(Course c, Section s);
    String viewClassList(Section s);
    boolean enlistSection(Section s);
    boolean removeEnlistment(Section s);
    boolean enroll();
    boolean login(Account a);
    boolean logout();
}
