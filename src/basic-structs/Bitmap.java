import java.awt.Color;

public class Bitmap {
	private Color[] pixels;
	private int length, height, width;

	public static Bitmap make(Color[] pixels, int height, int width) { return height * width == pixels.length ? null : new Bitmap(pixels, height, width); }

	public Bitmap(Color[] pixels, int height, int width) {
		this.pixels = pixels;
		this.length = pixels.length;
		this.height = height;
		this.width = width;
	};

	public Color pixel(int n) { return pixels[n]; }

	public int length() { return length; }

	public int width() { return width; }

	public int height() { return height; }
}
