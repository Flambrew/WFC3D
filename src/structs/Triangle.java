package src.structs;

import java.awt.Color;
import java.awt.Graphics;

import src.data.Renderable;
import src.data.Resolution;
import src.data.Vector3;

public class Triangle implements Renderable {
	public Vector3 a, b, c;

	public Triangle(final Vector3 a, final Vector3 b, final Vector3 c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	private int col = (int) (Math.random() * 128) + 64;
	private Color color = new Color(col, col, col);

	public void paint(final Graphics g, final Camera cam, final Resolution res) {
		Vector3 a = this.a.sub(cam.transform).rotate(cam.rotation.negate());
		Vector3 b = this.b.sub(cam.transform).rotate(cam.rotation.negate());
		Vector3 c = this.c.sub(cam.transform).rotate(cam.rotation.negate());

		if (a.z < cam.zSelf && b.z < cam.zSelf
				|| a.z < cam.zSelf && c.z < cam.zSelf
				|| b.z < cam.zSelf && c.z < cam.zSelf)
			return;

		if ((b.sub(a)).crossProd(b.sub(c)).norm().z > 0)
			return;

		Vector3 shiftToPos = new Vector3(1, 1, 0);
		Vector3 scaleToFit = new Vector3(0.5 * res.x, 0.5 * res.y, 1);
		a = a.screenProject(cam, res).add(shiftToPos).dotProd(scaleToFit);
		b = b.screenProject(cam, res).add(shiftToPos).dotProd(scaleToFit);
		c = c.screenProject(cam, res).add(shiftToPos).dotProd(scaleToFit);

		g.setColor(color);
		g.fillPolygon(new int[] { (int) a.x, (int) b.x, (int) c.x },
				new int[] { (int) a.y, (int) b.y, (int) c.y }, 3);
	}

	public double dist(final Vector3 from) {
		return from.dist(new Vector3((a.x + b.x + c.x) / 3, (a.y + b.y + c.y) / 3, (a.z + b.z + c.z) / 3));
	}
}