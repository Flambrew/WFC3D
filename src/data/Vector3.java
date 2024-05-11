package src.data;

public class Vector3 {
	public static final Vector3 X = new Vector3(1, 0, 0), Y = new Vector3(0, 1, 0), Z = new Vector3(0, 0, 1);

	public int x, y, z;

	public Vector3() {}

	public Vector3(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
}