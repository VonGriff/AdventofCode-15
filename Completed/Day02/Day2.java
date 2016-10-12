import java.io.RandomAccessFile;

public class Day2 {
	
	public static void main(String[] args) throws java.io.IOException {
		RandomAccessFile raf = new RandomAccessFile("input.txt", "r");
		String line;
		int area = 0;

		while ((line = raf.readLine()) != null) {
			String[] att = line.split("x");
			area += getDim(Integer.parseInt(att[0]),
					Integer.parseInt(att[1]),Integer.parseInt(att[2]));
		}
		System.out.println(area);
	}

	private static int getDim(int h,int l,int w) {
		return 2*h*l + 2*h*w + 2*l*w + smallest(h,l,w);
	}
	
	private static int smallest(int h,int l,int w) {
		int hw = h*w;
		int hl = h*l;
		int wl = w*l;
		if (hw < hl)
			if (hw < wl)
				return hw;
			else
				return wl;
		else if (hl < wl)
			return hl;
		else
			return wl;
	}
}