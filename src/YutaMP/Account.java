//Inoue, Yuta   Salva, Trisha
public class Account {
    
    private String userName;
    private String password;
    private boolean isLogin;
    
    public Account(String userName, String password){
        this.userName = userName;
        this.password = password;
        this.isLogin = false;
    }
    
    public String getUserName(){return userName;}
    public boolean getIsLogin(){return isLogin;}
    public void setIsLogin(boolean b){
        this.isLogin = b;
    }
    public boolean equal(Account a){
        return this.userName.equals(a.userName) && this.password.equals(a.password);
    }
    
}
