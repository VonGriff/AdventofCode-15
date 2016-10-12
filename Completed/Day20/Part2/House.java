public class House {
	
	private int name;
	private int presents;

	public House(int name) {
		this.name = name;
		presents = 0;
	}

	public int getName() {
		return name;
	}

	public int getPresents() {
		return presents;
	}

	public void addPresents(int p) {
		presents += p;
	}
}