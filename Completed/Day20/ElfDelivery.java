import java.util.ArrayList;

public class ElfDelivery {

	private static ArrayList<House> houses = new ArrayList<House>();
	private static ArrayList<Elf> elves = new ArrayList<Elf>();
	private static final int INPUT = 34000000;


	public static void main(String[] args) {
		houses.add(new House(1));
		elves.add(new Elf(1));

		int maxPresents = 0;

		while (maxPresents < INPUT) {
			// System.out.println("Ding");
			createElves();
			createHouses();
			visit();
			maxPresents = presents(INPUT);
			System.out.println(maxPresents);
		}
		for (House h: houses) {
			if (h.getPresents() > INPUT) {
				System.out.println("Lowest house number is: " + h.getName());
				break;
			}
		}
	}

	// Skapar fler nissar som kan besöka hus
	private static void createElves() {
		//TODO
		int cap = elves.size();
		for (int i = 0; i < cap; i++) {
			elves.add(new Elf(elves.size()+1));
		}
		// for (int i = 0; i < 100; i++) {
		// 	elves.add(new Elf(elves.size()+1));
		// }
		return;
	}

	// Skapar fler hus som nissar kan besöka
	private static void createHouses() {
		//TODO
		int cap = houses.size();
		for (int i = 0; i < cap; i++) {
			houses.add(new House(houses.size()+1));
		}
		// for (int i = 0; i < 100; i++) {
		// 	houses.add(new House(houses.size()+1));
		// }
		return;
	}

	// Får nissar att besöka hus
	private static void visit() {
		//TODO
		// int totalElves = elves.size();

		// elves.stream()
		// 	 .filter(elf -> elf.nextVisit() > totalElves)
		// 	 .forEach(elf -> houses.get(elf.addNextVisit() - 1)
		// 	 				 .addPresents(elf.getDeliverCapacity());

		for (Elf e: elves) {
			while (e.nextVisit() < elves.size()) {
				houses.get(e.addNextVisit()-1).addPresents(e.getDeliverCapacity());
			}
			// if (e.nextVisit() > elves.size()) {
			// 	// Fortsätter ifall en nisse försöker besöka ett hus som inte finns
			// 	// Antal hus = antalet nissar
			// 	continue;
			// }
			// houses.get(e.addNextVisit()-1).addPresents(e.getDeliverCapacity());
		}
		return;
	}

	// Hittar högsta antalet presenter, ska senare hitta första huset med presenter > INPUT
	private static int presents(int input) {
		int max = 0;
		for (House h: houses) {
			if (max < h.getPresents()) {
				max = h.getPresents();
			}
			if (max >= input) {
				break;
			}
		}
		return max;
	}
}