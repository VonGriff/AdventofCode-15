public class Recipe {

	private int teaspoons = 0;
	
	public void main(String[] args) {
		Ingredient sprinkles = new Ingredient(2,0,-2,0,3);
		Ingredient butterscotch = new Ingredient(0,5,-3,0,3);
		Ingredient chocolate = new Ingredient(0,0,5,-1,8);
		Ingredient candy = new Ingredient(0,-1,0,5,8);
		
		Ingredient[] ing = {sprinkles,butterscotch,chocolate,candy};

		// Sätter mängden Sprinkles till 100
		for (int i = 0; i < 100; i++) {
			ing[0].add();
		}


	}

	// Kontrollerar att endast 100 teskedar används
	public boolean max(Ingredient[] ing) {
		int count = 0;
		for (Ingredient in: ing) {
			count += in.amount();
		}
		if (count == 100) {
			return true;
		}
		return false;
	}
}