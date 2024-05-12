package test;

import java.awt.event.KeyEvent;

import src.data.Resolution;
import src.data.Vector3;
import src.engine.Engine;
import src.structs.Camera;
import src.structs.Mesh;
import src.structs.Scene;
import src.structs.Triangle;

public class Client extends Engine {

    public Client(int framesPerSecond, Resolution res) {
        super(framesPerSecond, res);
        this.res = res;
    }

    private Resolution res;
    private Camera camera;
    private Scene scene;

    public void init() {
        setCamera(camera = new Camera());
        setScene(scene = new Scene());

        addcube();
    }

    public void frameUpdate() {

    }

    public void fixedUpdate() {
        if (input.held.contains(KeyEvent.VK_A)) {
            camera.transform.x -= .1; // TODO: actually write this well
        }
        if (input.held.contains(KeyEvent.VK_D)) {
            camera.transform.x += .1; // TODO: actually write this well
        }
        if (input.held.contains(KeyEvent.VK_S)) {
            camera.transform.z -= .1; // TODO: actually write this well
        }
        if (input.held.contains(KeyEvent.VK_W)) {
            camera.transform.z += .1; // TODO: actually write this well
        }
        if (input.held.contains(KeyEvent.VK_SPACE)) {
            camera.transform.y -= .1; // TODO: actually write this well
        }
        if (input.held.contains(KeyEvent.VK_CONTROL)) {
            camera.transform.y += .1; // TODO: actually write this well
        }
    }

    /* ----- Random Crap ----- */

    void addcube() {
        Mesh cube = new Mesh();

        Vector3 a = new Vector3(-1, -1, 5);
        Vector3 b = new Vector3(-1, 1, 5);
        Vector3 c = new Vector3(1, 1, 5);
        Vector3 d = new Vector3(1, -1, 5);
        Vector3 e = new Vector3(-1, -1, 7);
        Vector3 f = new Vector3(-1, 1, 7);
        Vector3 g = new Vector3(1, 1, 7);
        Vector3 h = new Vector3(1, -1, 7);
        
        cube.add(new Triangle(a, c, b));
        cube.add(new Triangle(a, d, c));

        cube.add(new Triangle(d, h, g));
        cube.add(new Triangle(d, g, c));

        cube.add(new Triangle(h, e, f));
        cube.add(new Triangle(h, f, g));

        cube.add(new Triangle(e, a, b));
        cube.add(new Triangle(e, b, f));

        cube.add(new Triangle(b, c, g));
        cube.add(new Triangle(b, g, f));

        cube.add(new Triangle(e, h, d));
        cube.add(new Triangle(e, d, a));

        scene.add(cube);
    }
}