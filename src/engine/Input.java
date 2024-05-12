package src.engine;

import java.awt.event.KeyEvent;
import java.util.HashSet;

public class Input {

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
}
