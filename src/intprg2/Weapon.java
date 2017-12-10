package intprg2;
public class Weapon
{
    private String strName;
    private int nAtkVal;

    // Constructors
    public Weapon(String name, int atkVal)
    {
        strName = name;
        nAtkVal = atkVal;
    }
    
    // accessors
    public String getName()
    {
        return strName;
    }
    public int getAtkVal()
    {
        return nAtkVal;
    }
    
    
}