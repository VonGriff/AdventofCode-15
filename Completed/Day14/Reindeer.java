public class Reindeer {

	private int currentPos = 0;
	private int time = 0;
	private int points = 0;

	private int flyTime;
	private int restTime;
	private int flyDist;

	private boolean resting = false;

	public Reindeer(int flyDist, int flyTime, int restTime) {
		this.flyDist = flyDist;
		this.flyTime = flyTime;
		this.restTime = restTime;
	}

	// Renen utför en move för en sekund
	public void move() {
		// Om renen inte vilar, inkrementera positionen och tiden
		if (!resting) {
			currentPos += flyDist;
			// Har vi flugit tillräckligt är det dags att vila
			if (++time == flyTime) {
				time = 0;
				resting = true;
			}
		}
		// Annars ser vi om vi vilat tillräckligt länge
		else {
			if (++time == restTime) {
				resting = false;
				time = 0;
			}
		}
		return;
	}

	public int getPos() {
		return currentPos;
	}

	public int getPoints() {
		return points;
	}

	public void addPoint() {
		points++;
		return;
	}
}