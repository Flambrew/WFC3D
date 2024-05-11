public class Angle {

	public double deg;

	public static Angle make(double angle) {
		return new Angle(angle, true);
	}

	public static Angle makeRad(double angle) {
		return new Angle(angle, false);
	}

	private Angle(double angle, boolean deg) {
		this.deg = deg 
			? angle
			: Math.toDegrees(angle);
	}

	public double rad() {
		return Math.toRadians(deg);
	}

	public void rad(double angle) {
		deg = Math.toDegrees(angle);
	}
}