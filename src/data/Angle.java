public class Angle {
	public static final int DEG = 0, RAD = 1;
	private double degrees;

	/** Use Angle.DEG and Angle.RAD for format. */
	public static Angle make(double angle, int format) {
		return format == DEG || format == RAD ? new Angle(angle, format) : null;
	}

	private Angle(double angle, int format) {
		if (format == DEG) {
			degrees = angle;
		} else {
			degrees = Math.toDegrees(angle);
		}
	}

	public double deg() { return degrees; }

	public double rad() { return Math.toRadians(degrees); }

	public void deg(double angle) { degrees = angle; }

	public void rad(double angle) { degrees = Math.toDegrees(angle); }
}