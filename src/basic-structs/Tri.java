public class Tri {
	private Vector3 a, b, c;

	public Tri(Vector3 a, Vector3 b, Vector3 c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public void a(Vector3 a) {
		if (a != null)
			this.a = a;
	}

	public void b(Vector3 b) {
		if (b != null)
			this.b = b;
	}

	public void c(Vector3 c) {
		if (c != null)
			this.c = c;
	}

	public Vector3 a() { return a; }

	public Vector3 b() { return b; }

	public Vector3 c() { return c; }
}