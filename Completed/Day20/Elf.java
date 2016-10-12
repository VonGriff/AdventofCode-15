public class Elf {
	
	private int name;
	private int deliverCapacity;
	private int lastVisit; //Senast besökta hus

	public Elf(int name) {
		this.name = name;
		deliverCapacity = name * 10;
		lastVisit = 0;
	}

	public int getName() {
		return name;
	}

	public int getDeliverCapacity() {
		return deliverCapacity;
	}

	public int getLastVisit() {
		return lastVisit;
	}

	public int nextVisit() {
		return lastVisit + name;
	}

	public int addNextVisit() {
		return lastVisit += name;
	}
}