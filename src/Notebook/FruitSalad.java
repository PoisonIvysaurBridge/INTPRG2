// Ivana Lim #6 S15A

import java.util.ArrayList;

public class FruitSalad
{
	private ArrayList <Ingredient> ingredients;
	//private double totalCalories;
	
	public FruitSalad(ArrayList <Ingredient> ingredients)
	{
		this.ingredients = ingredients;
		//totalCalories = 0;
	}
	
	public double getTotalCalories()
	{
		double totalCalories = 0;
		int i;
		for(i = 0; i < ingredients.size(); i++)
		{
			totalCalories += (ingredients.get(i).getFruit().getCaloriesPerGram())* (ingredients.get(i).getGrams());
		}
		return totalCalories;
	}
	
	public void displayFruits()
	{
		int i;
		for(i = 0; i < ingredients.size(); i++)
		{
			System.out.println(ingredients.get(i).getFruit().getName());
		}
	}
}