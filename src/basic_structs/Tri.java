package src.basic_structs;

import src.data.Resolution;
import src.data.Vector3;

public class Tri {
	public Vector3 a, b, c;

	public Tri(final Vector3 a, final Vector3 b, final Vector3 c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public void paint(final Camera cam, final Resolution res) {

	}
}