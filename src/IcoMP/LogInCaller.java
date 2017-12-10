package IcoMP;
public class LogInCaller
{
    public static void main(String[] args)
    {
        AdministratorAccount admin = new AdministratorAccount ();
        LogInGUI logInApp = new LogInGUI (admin);
    }
}
