package src.data;

import src.structs.Camera;

public class Vector3 {
	public static final Vector3 X = new Vector3(1, 0, 0), Y = new Vector3(0, 1, 0), Z = new Vector3(0, 0, 1);

	public double x, y, z;

	public Vector3() {}

	public Vector3(final double x, final double y, final double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public void assign(final Vector3 vec) {
		x = vec.x;
		y = vec.y;
		z = vec.z;
	}

	public Vector3 add(final Vector3 vec) {
		return new Vector3(x + vec.x, y + vec.y, z + vec.z);
	}

	public Vector3 sub(final Vector3 vec) {
		return new Vector3(x - vec.x, y - vec.y, z - vec.z);
	}

	public double len() {
		return Math.sqrt(x * x + y * y + z * z);
	}

	public boolean one() {
		return Math.abs(x - 1) < 0.001 && Math.abs(y - 1) < 0.001 && Math.abs(z - 1) < 0.001;
	}

	public boolean zero() {
		return Math.abs(x) < 0.001 && Math.abs(y) < 0.001 && Math.abs(z) < 0.001;
	}

	public Vector3 norm() {
		double len = len();
		return new Vector3(x / len, y / len, z / len);
	}

	public double dist(final Vector3 vec) {
		return Math.sqrt((x - vec.x) * (x - vec.x) + (y - vec.y) * (y - vec.y) + (z - vec.z) * (z - vec.z));
	}

	public Vector3 scale(final double val) {
		return new Vector3(x * val, y * val, z * val);
	}

	public Vector3 clamp(final double val) {
		if (len() < val) 
			return new Vector3(x, y, z);
		double clampLen = len() / val;
		return new Vector3(x / clampLen, y / clampLen, z / clampLen);
	}

	public Vector3 rotate(final Angle angle) {
		return new Vector3(x * Math.cos(angle.rad()) - z * Math.sin(angle.rad()), y, x * Math.sin(angle.rad()) + z * Math.cos(angle.rad()));
	}

	public Vector3 dotProd(final Vector3 vec) {
		return new Vector3(x * vec.x, y * vec.y, z * vec.z);
	}

	public Vector3 crossProd(final Vector3 vec) {
		return new Vector3(y * vec.z - x * vec.y, z * vec.x - x * vec.z, x * vec.y - y * vec.x);
	}

	public Vector3 matrixTransform(final double[][] mat) {
		double w = x * mat[0][3] + y * mat[1][3] + z * mat[2][3] + mat[3][3];
		w = w == 0 ? 1 : w;
		Vector3 out = new Vector3(
			(x * mat[0][0] + y * mat[1][0] + z * mat[2][0] + mat[3][0]) / w,
			(x * mat[0][1] + y * mat[1][1] + z * mat[2][1] + mat[3][1]) / w,
			(x * mat[0][2] + y * mat[1][2] + z * mat[2][2] + mat[3][2]) / w
		);
		return out;
	}

	public Vector3 screenProject(final Camera cam, final Resolution res) {
		double zSelf = cam.zSelf, zMax = cam.zMax;
		double aspectRatio = res.aspectRatio();
		double fovTan = 1 / Math.tan(cam.fov.rad() / 2);

		double[][] projectionMatrix = new double[][] {
			{aspectRatio * fovTan, 0, 0, 0},
			{0, fovTan, 0, 0},
			{0, 0, zMax / (zMax - zSelf), 1},
			{0, 0, (-zMax - zSelf) / (zMax - zSelf), 0}
		};

		return matrixTransform(projectionMatrix);
	}

	public String toString() {
		return String.format("[%.3f, %.3f, %.3f]", x, y, z);
	}
}