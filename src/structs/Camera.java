package src.structs;

import src.data.Angle;
import src.data.Vector3;

public class Camera {
    public final Vector3 transform = new Vector3();
    public final Angle rotation = Angle.make(0);
    public final Angle fov = Angle.make(90);
    public final double zSelf = 0.1;
    public final double zMax = 1000;

    //TODO: write camera class
}
