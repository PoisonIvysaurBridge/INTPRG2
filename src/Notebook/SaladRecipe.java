// Ivana Lim #6 S15A

import java.util.ArrayList;

public class SaladRecipe
{
	private ArrayList<Ingredient> ingredients;
	
	public SaladRecipe()
	{
		ingredients = new ArrayList<>();
	}
	
	public void addIngredient(Fruit f, double nGrams)
	{
		ingredients.add(new Ingredient(f, nGrams));
	}
	
	public void removeAll()
	{
		ingredients.clear();
	}
	
	public FruitSalad make()
	{
		FruitSalad yum = new FruitSalad(ingredients);
		return yum;
	}
}