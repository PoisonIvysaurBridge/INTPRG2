package intprg2;
public class Soldier
{
    private String strName;
    private int nStrength;
    private Weapon w;

    // Constructors
    public Soldier(String name, int strength)
    {
        strName = name;
        nStrength = strength;
    }

    // Accessors
    public String getName()
    {
        if (strName == null)
            return "no name";
        return strName;
    }
    public int getStrength()
    {
        return nStrength;
    }
    public Weapon getWeapon()
    {
        return w;
    }

    // other methods
    public void equip(Weapon weap)
    {
        if (w != null)
            unequip();	// to swtich weapons
        w = weap;   // only for one ewapon, if multiple weapons, use array instead of Weapon Obj
        nStrength += w.getAtkVal();
        
    }
    public void unequip()
    {
        if (w != null)
        {
            nStrength -= w.getAtkVal();
            w = null;
        }
        else
            System.out.println("There is no weapon to unequip.");
    }
    public void display()
    {
        System.out.println("Soldier: "+strName);
        System.out.println("Strength: "+nStrength);
        if (w!=null)
        {
            System.out.println("Weapon: "+w.getName());
            System.out.println("Attack Value: "+w.getAtkVal());
        }
        else
            System.out.println("Unarmed");
        
    }
    public static void main(String[] args) 
    {
        Soldier ivy = new Soldier("ivana", 999);
        Weapon weap1 = new Weapon("Bazooka",10000);
        Weapon weap2 = new Weapon("Katana",5000);
        ivy.display();
        ivy.equip(weap1);
        ivy.display();
        ivy.equip(weap2);
        System.out.println("Ivy's weapon: "+ivy.getWeapon().getName());
        System.out.println("Ivy's "+ivy.getWeapon().getName()+"'s attack value: "+ivy.getWeapon().getAtkVal());
        
    }
}