package intprg2;
public class Person
{
    private String strName,
                   strGender;
    private Person spouse;
            
    // constructors
    Person(String name, String gender)
    {
        strName = name;
        strGender = gender;
        spouse = null;
    }
    
    // accessors
    public String getName()
    {
        if (strName == null)
            return "no name";
        return strName;
    }
    public String getGender()
    {
        return strGender;
    }
    public Person getSpouse()
    {
        return spouse;
    }
    
    // other methods
    public void marries(Person p)
    {
        if (spouse == null && p.spouse == null && !strGender.equalsIgnoreCase(p.strGender))
        {
            this.spouse = p;
            p.spouse = this.spouse;
        }
    }
    public void display()
    {
        System.out.print(this.strName+"'s spouse is: ");
        if (spouse == null)
            System.out.println("--");
        else
            System.out.println(spouse);
        
    }
    public static void main(String[] args) {
        Person girl = new Person("robin","Female");
        Person boy = new Person ("zoro", "Male");
        girl.display();
        boy.display();
        System.out.println("");
        girl.marries(boy);
        girl.display();
        boy.display();
    }
}