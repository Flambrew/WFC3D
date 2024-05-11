package test;

import src.basic_structs.Camera;
import src.basic_structs.Scene;
import src.data.Resolution;
import src.data.Vector3;
import src.engine.Engine;

public class Client extends Engine {

    public Client(int framesPerSecond, Resolution res) {
        super(framesPerSecond, res);
        this.res = res;
    }

    private Resolution res;
    private Camera camera;

    public void init() {
        setScene(new Scene());
        camera = (Camera) new Vector3();
    }

    public void frameUpdate() {

    }

    public void fixedUpdate() {

    }
}