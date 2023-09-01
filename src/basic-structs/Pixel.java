/** 
 * Pixels should be stored as 32-bit ARGB integers
 * Alpha should represent transparency, not opacity
 */
public class Pixel {
	private Pixel() {}

	public static int alpha(int argb) { return (rgb >> 24) & 0xFF; }
	public static int red(int rgb) { return (rgb >> 16) & 0xFF; }
	public static int green(int rgb) { return (rgb >> 8) & 0xFF; }
	public static int blue(int rgb) { return (rgb) & 0xFF; }

	public static int rgb(int red, int green, int blue) { return ((red & 0xFF) << 16) | ((green & 0xFF) << 8) | (blue & 0xFF); }
}
