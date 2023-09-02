public class Bitmap {
	private int[] pixels;
	private int length, height, width;

	public static Bitmap make(int[] pixels, int height, int width) { return height * width == pixels.length ? null : new Bitmap(pixels, height, width); }

	public Bitmap(int[] pixels, int height, int width) {
		this.pixels = pixels;
		this.length = pixels.length;
		this.height = height;
		this.width = width;
	};

	public int pixel(int n) { return pixels[n]; }

	public int length() { return length; }

	public int width() { return width; }

	public int height() { return height; }
}
