package src.structs;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Comparator;

import src.data.Renderable;
import src.data.Resolution;

public class Scene extends ArrayList<Renderable> {
    public void paint(final Graphics g, final Camera cam, final Resolution res) {
        ArrayList<Triangle> tris = new ArrayList<Triangle>();
        for (int i = 0; i < size(); i++) {
            if (get(i) instanceof Mesh) tris.addAll((Mesh) get(i));
            else tris.add((Triangle) get(i));
        }
 
        tris.sort(Comparator.comparingDouble(tri -> -tri.dist(cam.transform)));

        for (int i = 0; i < tris.size(); i++) {
            tris.get(i).paint(g, cam, res);
        }
    }
}