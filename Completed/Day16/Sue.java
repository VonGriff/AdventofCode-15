public class Sue {
	private String name;
			int children,
				cats,
				samoyeds,
				pomeranians,
				akitas,
				vizslas,
				goldfish,
				trees,
				cars,
				perfumes;

	public Sue(String name){
		this.name = name;
		children = -1;
		cats = -1;
		samoyeds = -1;
		pomeranians = -1;
		akitas = -1;
		vizslas = -1;
		goldfish = -1;
		trees = -1;
		cars = -1;
		perfumes = -1;
	}

	public Sue(String name, int chi, int cat, int sam, int pom, int aki, int viz, int gol, int tre, int car, int per) {
		this.name = name;
		children = chi;
		cats = cat;
		samoyeds = sam;
		pomeranians = pom;
		akitas = aki;
		vizslas = viz;
		goldfish = gol;
		trees = tre;
		cars = car;
		perfumes = per;
	}

	public String getName() {
		return name;
	}

	public void addChild(int c) {
		children = c;
	}

	public int getChild() {
		return children;
	}

	public void addCat(int c) {
		cats = c;
	}

	public int getCat() {
		return cats;
	}

	public void addSamoyed(int s) {
		samoyeds = s;
	}

	public int getSamoyed() {
		return samoyeds;
	}

	public void addPomeranian(int p) {
		pomeranians = p;
	}

	public int getPomeranian() {
		return pomeranians;
	}

	public void addAkita(int a) {
		akitas = a;
	}

	public int getAkita() {
		return akitas;
	}

	public void addVizsla(int v) {
		vizslas = v;
	}

	public int getVizsla() {
		return vizslas;
	}

	public void addFish(int f) {
		goldfish = f;
	}

	public int getFish() {
		return goldfish;
	}

	public void addTree(int t) {
		trees = t;
	}

	public int getTree() {
		return trees;
	}

	public void addCar(int c) {
		cars = c;
	}

	public int getCar() {
		return cars;
	}

	public void addPerfume(int p) {
		perfumes = p;
	}

	public int getPerfume() {
		return perfumes;
	}
}