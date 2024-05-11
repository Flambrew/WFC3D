package src.data;

public class Angle {

	public double deg;

	public static Angle make(final double angle) {
		return new Angle(angle, true);
	}

	public static Angle makeRad(final double angle) {
		return new Angle(angle, false);
	}

	private Angle(final double angle, final boolean deg) {
		this.deg = deg 
			? angle
			: Math.toDegrees(angle);
	}

	public double rad() {
		return Math.toRadians(deg);
	}

	public void rad(final double angle) {
		deg = Math.toDegrees(angle);
	}
}