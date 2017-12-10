package examples;
// Ivana Lim #14
public class Date{
    private int nYr,
                nMonth,
                nDay;
    // Constructors
    public Date(int year, int month, int day){
        nDay = day;
        nMonth = month;
        nYr = year;
    }
    public Date(int month, int day){
      /*  nDay = day;
        nMonth = month;
        nYr = 2016;*/
    	this(month, day, 2016);
    }
    public Date(){
       /* nDay = 21;
        nMonth = 6;
        nYr = 2016;*/
    	this(6, 21, 2016);
    }
    
    // mutators
    public void setDay(int day){
        if (day >=1 && day <= 30)
            nDay = day;
    }
    public void setMonth(int month){
        if (month >=1 && month <= 12)
            nMonth = month;
    }
    public void setMonth(String strMo){
        strMo = strMo.toLowerCase();
        switch(strMo){
            case "january":     nMonth = 1; break;
            case "february":    nMonth = 2; break;
            case "march":       nMonth = 3; break;
            case "april":       nMonth = 4; break;
            case "may":         nMonth = 5; break;
            case "june":        nMonth = 6; break;
            case "july":        nMonth = 7; break;
            case "august":      nMonth = 8; break;
            case "september":   nMonth = 9; break;
            case "october":     nMonth = 10; break;
            case "november":    nMonth = 11; break;
            case "december":    nMonth = 12; break;
        }
    }
    public void setYear(int year){
        nYr = year;
    }
    
    // accessors
    public int getDay(){
        return nDay;
    }
    public int getMonth(){
        return nMonth;
    }
    public int getYear(){
        return nYr;
    }
    
    // other methods
    public boolean isValidDay(){
        if (nDay >=1 && nDay <=30 && nMonth >=1 && nMonth <=12)
            return true;
        return false;
    }
    public boolean isLeapYr(){
        if (nYr % 4 == 0 && nYr % 100 != 0 || nYr % 400 == 0)
            return true;
        return false;
    }
    public boolean isBefore(Date d)
    {
    	return this.getYear()<d.getYear() && this.getMonth() < d.getMonth() && this.getDay() < d.getDay();
    }
}