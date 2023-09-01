public class Mesh {
	private Voxel[] voxels;
	private int length, depth, height, width;

	public static Mesh make(Voxel[] voxels, int depth, int height, int width) { 
		return depth * height * width != voxels.length
		      	? null
		       	: new Mesh(voxels, depth, height, width); 
	}

	private Mesh(Voxel[] voxels, int depth, int height, int width) {
	       	this.voxels = voxels;
	       	this.length = voxels.length;
	       	this.depth = depth;
	       	this.height = height;
	       	this.width = width;
       	}
}
