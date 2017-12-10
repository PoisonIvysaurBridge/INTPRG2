import java.util.ArrayList;
public class Student {
	private ArrayList <Homework> homeworks;
	private String strName;
	
	public Student(String name){
		strName = name;
		homeworks = new ArrayList<>();
	}
	public String getName()
	{
		return strName;
	}
	public void addHomework(Homework hw)
	{
		homeworks.add(hw);
	}
	public void finishHomework(Homework hw)
	{
		homeworks.remove(hw)
	}
	public Homework getPriority()
	{
		int i;
		for(i = 0; i < homeworks.size(); i++)
		{
			int temp = 
		}
		return
	}
}
