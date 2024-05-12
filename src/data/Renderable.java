package src.data;

import java.awt.Graphics;

import src.structs.Camera;

public interface Renderable {
    public void paint(final Graphics g, final Camera cam, final Resolution res);
}
