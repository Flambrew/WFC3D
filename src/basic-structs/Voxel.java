public class Voxel {
	public final int TOP = 0, NORTH = 1, EAST = 2, SOUTH = 3, WEST = 4, BOTTOM = 5;

	private Bitmap[] sides = new Bitmap[6];

	public static Voxel make(Bitmap[] sides) { 
		return sides.length != 6 ? null : new Voxel(sides); 
	}
	
	private Voxel(Bitmap[] sides) { this.sides = sides; }
}
