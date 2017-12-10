package examples;

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
	public /*Homework*/ void finishHomework(Homework hw)
	{
		homeworks.remove(hw);
		/*
		int i;
		for(i=0; i < homeworks.size(); i++)
		{
			if (homeworks.get(i).getTItle().equalsIgnoreCase(hw.getTItle()))
			{
				return homeworks.remove(i);
			}
		}
		return null;*/
	}
	public Homework getPriority()
	{
		if (homeworks.size() == 0)
			return null;
		Homework near = homeworks.get(0);
		int i;
		for(i = 0; i < homeworks.size(); i++)
		{
			if(homeworks.get(i).getDeadline().isBefore(near.getDeadline()))
			{
				near = homeworks.get(i);
			}
		}
		return near;
	}
	
	public static void main(String [] args)
	{
		Student ivy = new Student("ivana lim");
		Date archosProbSet2dead = new Date(7,11);
		Date archosProbSet3dead = new Date(7,13);
		Date archosMPdead= new Date(7, 25);
		Homework archosPS2 = new Homework("Archos probset2",archosProbSet2dead);
		Homework archosPS3 = new Homework("Archos probset2",archosProbSet3dead);
		Homework archosMP = new Homework("Archos MP", archosMPdead);
		ivy.addHomework(archosMP);
		ivy.addHomework(archosPS3);
		ivy.addHomework(archosPS2);
		ivy.finishHomework(archosMP);
		for(Homework hw: ivy.homeworks)
		{
			System.out.println(hw.getTItle());
		}
	}
}