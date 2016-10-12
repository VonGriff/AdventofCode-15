public class Elf {
	
	private int name;
	private int deliverCapacity;
	private int lastVisit; //Senast besökta hus
	private int housesDelivered;

	public Elf(int name) {
		this.name = name;
		deliverCapacity = name * 11;
		lastVisit = 0;
		housesDelivered = 0;
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

	public void addDelivery() {
		housesDelivered++;
	}

	public boolean willDeliver() {
		if (housesDelivered >= 50) {
			return false;
		}
		return true;
	}
}