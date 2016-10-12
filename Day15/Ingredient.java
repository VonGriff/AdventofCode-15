public class Ingredient {
	
	private int capacity,
				durability,
				flavour,
				texture,
				calories,
				amount = 0;

	public Ingredient(int cap, int dur, int fla, int tex, int cal) {
		capacity = cap;
		durability = dur;
		flavour = fla;
		texture = tex;
		calories = cal;
	}

	public void add() {
		if (amount < 100) {
			amount++;
		}
	}

	public void sub() {
		if (amount > 0) {
			amount--;
		}
	}

	public int amount() {
		return amount;
	}

	public int getCap() {
		int num = amount * capacity;
		if (num > 0) {
			return num;
		}
		return 0;
	}

	public int getDur() {
		int num = amount * durability;
		if (num > 0) {
			return amount * durability;
		}
		return 0;
	}

	public int getFla() {
		int num = amount * flavour;
		if (num > 0) {
			return amount * flavour;
		}
		return 0;
	}

	public int getTex() {
		int num = amount * texture;
		if (num > 0) {
			return amount * texture;
		}
		return 0;
	}

	public int getCal() {
		int num = amount * calories;
		if (num > 0) {
			return amount * calories;
		}
		return 0;
	}
}