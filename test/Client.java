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

    private Resolution res;
    private Camera camera;
    private Scene scene;

    public Client(int framesPerSecond, Resolution res) {
        super(framesPerSecond, res);
        this.res = res;
    }

    public void init() {
        setCamera(camera = new Camera());
        setScene(scene = new Scene());

        scene.add(cube());
    }

    public void frameUpdate() {
    }

    public void fixedUpdate() {
        movement();
        rotation();
    }

    /* -----=====----- Random Crap -----=====----- */

    private Vector3 bodyAcceleration = new Vector3();
    private double walk = 1, back = .6, strafe = .8, lift = .7;
    public void movement() {
        if (input.held.contains(KeyEvent.VK_A)) bodyAcceleration.x -= strafe;
        if (input.held.contains(KeyEvent.VK_D)) bodyAcceleration.x += strafe;
        if (input.held.contains(KeyEvent.VK_S)) bodyAcceleration.z -= back;
        if (input.held.contains(KeyEvent.VK_W)) bodyAcceleration.z += walk;
        if (input.held.contains(KeyEvent.VK_SPACE)) bodyAcceleration.y -= lift;
        if (input.held.contains(KeyEvent.VK_CONTROL)) bodyAcceleration.y += lift;

        if (!bodyAcceleration.zero()) {
            camera.transform.assign(camera.transform.add(bodyAcceleration.clamp(100).scale(0.01)));
            bodyAcceleration.assign(bodyAcceleration.scale(0.95));
        }
    }

    private double camAcceleration = 0;
    public void rotation() {
        camAcceleration -= input.mousePos().x;
        input.centerMouse();

        if (Math.abs(camAcceleration) >= 0.001) {
            camera.rotation.add(camAcceleration * 0.01);
            camAcceleration *= 0.90;
        }
    }

    public Mesh cube() {
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

        return cube;
    }
}