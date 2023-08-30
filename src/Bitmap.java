public class Bitmap {
	private int[] pixels;
	private int width;

	public static Bitmap make(int[] pixels, int width) { return pixels.length % width != 0 ? null : new Bitmap(pixels, width); }
	public Bitmap(int[] pixels, int width) { this.pixels = pixels; this.width = width; };

	public int pixel(int n) { return pixels[n]; }
	public int width() { return width; }
	public int height() { return pixels.length / width; }
	public int length() { return pixels.length; }
}
