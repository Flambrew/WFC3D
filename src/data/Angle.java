public class Angle {
	public enum Format {
		DEG, RAD;
	}

	private double degrees;

	/** Use Angle.DEG and Angle.RAD for format. */
	public static Angle make(double angle, Format format) {
		return format == Format.DEG || format == Format.RAD ? new Angle(angle, format) : null;
	}

	private Angle(double angle, Format format) {
		if (format == Format.DEG) {
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