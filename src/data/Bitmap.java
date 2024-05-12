package src.data;

import java.awt.Color;

public class Bitmap {

	//TODO: place origin at bitmap center

	public final int length, height, width;
	private final Color[] pixels;

	/** return null if invalid */
	public static Bitmap make(final Color[] pixels, final int height, final int width) {
		return height * width == pixels.length
				? new Bitmap(pixels, height, width)
				: null;
	}

	private Bitmap(final Color[] pixels, final int height, final int width) {
		this.pixels = pixels;
		this.length = pixels.length;
		this.height = height;
		this.width = width;
	};

	/** return null if invalid */
	public Color pixel(final int n) {
		return n < pixels.length
				? pixels[n]
				: null;
	}

	/** return null if invalid */
	public Color pixel(final int x, final int y) {
		return pixel(y * width + x);
	}
}
