public class Present {

	private int l, w, h;

	public Present(int l, int w, int h) {
		this.l = l;
		this.w = w;
		this.h = h;
	}

	public int getArea() {
		return 2*(l*w + l*h + w*h) + getSmallArea();
	}

	public int getLength() {
		return smallSides() + l*w*h;
	}

	private int getSmallArea() {
		int small = l*w;

		if (l*h < small)
			small = l*h;
		if (w*h < small)
			small = w*h;

		return small;
	}

	private int smallSides() {
		if (h >= w && h >= l)
			return w*2 + l*2;
		else if (w >= h && w >= l)
			return h*2 + l*2;
		else
			return h*2 + w*2;
	}
}