package intprg2;
// Ivana Lim #14    6-23-16
public class Block{
    private String strName;
    private int nSize;
    private int nCapacity;
    
    public Block(){
        
    }
    public Block(String name, int capacity){
        nSize = 0;
        strName = name;
        nCapacity = capacity;
    }
    
    // accessors
    public String getName(){
        if (strName == null)
            return "no name";
        return strName;
    }
    public int getSize(){
        return nSize;
    }
    public int getCapacity(){
        return nCapacity;
    }

    // mutators
    public void setName(String name){
        strName = name;
    }
    public void setSize(int size){
        nSize = size;
    }
    public void setCapacity(int capacity){
        nCapacity = capacity;
    }
   
    // other methods
    public void display(){
        System.out.print ("Block Name: \t\t");
        if (strName == null)
            System.out.println ("--");
        else
            System.out.println (strName);

        System.out.print ("\tCapacity: \t");
        if (nCapacity == 0)
            System.out.println ("--");
        else
            System.out.println (nCapacity);

        System.out.println("\tSize: \t\t"+nSize);
        
        System.out.println("\tFree Slots: \t"+(nCapacity - nSize));
    }
   
    public void addStudent(){
        if (nSize < nCapacity)
            nSize++;
    }
    public void addStudent(int x){
        if (nSize + x<= nCapacity)
            nSize += x;
        else
            System.out.println("Not enough slots");
    }
}