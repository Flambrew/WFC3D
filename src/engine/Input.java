package src.engine;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.HashSet;

public class Input {

    private Window window;

    private final HashSet<Integer> inBuf = new HashSet<Integer>();
    private final HashSet<Integer> outBuf = new HashSet<Integer>();

    public final HashSet<Integer> pressed = new HashSet<Integer>();
    public final HashSet<Integer> held = new HashSet<Integer>();
    public final HashSet<Integer> released = new HashSet<Integer>();

    public void pressed(final KeyEvent k) {
        inBuf.add(k.getKeyCode());
    }

    public void released(final KeyEvent k) {
        outBuf.add(k.getKeyCode());
    }

    public void update() {
        pressed.clear();
        released.clear();

        for (Integer k : inBuf) {
            if (!held.contains(k)) {
                pressed.add(k);
                held.add(k);
            }
        }

        for (Integer k : outBuf) {
            released.add(k);
            held.remove(k);
        }
        
        inBuf.clear();
        outBuf.clear();
    }

    public void setWindow(final Window window) {
        if (this.window == null)
            this.window = window;
    }

    public Point mousePos() {
        if (window == null) return null;
        Point winpos = window.getLocationOnScreen();
        Point mousepos = MouseInfo.getPointerInfo().getLocation();
        return new Point(mousepos.x - winpos.x - (window.resolution.x / 2), mousepos.y - winpos.y - (window.resolution.y / 2));
    }

    public void centerMouse() {
        try {
            Robot robot = new Robot();
            Point winpos = window.getLocationOnScreen();
            robot.mouseMove(winpos.x + window.resolution.x / 2, winpos.y + window.resolution.y / 2);
        } catch (Exception e) {}
    }
}
