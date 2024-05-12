package src.structs;

import java.awt.Graphics;
import java.util.ArrayList;

import src.data.Renderable;
import src.data.Resolution;

public class Mesh extends ArrayList<Triangle> implements Renderable {
    public void paint(Graphics g, Camera cam, Resolution res) {
        for (int i = 0; i < size(); i++) {
            get(i).paint(g, cam, res);
        }
    }
}
