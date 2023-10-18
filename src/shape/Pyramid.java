package shape;

public class Pyramid extends Shape {
	
	private double side;
	
	public Pyramid(double height, double side) {
		super(height);
		this.side = side;
	}
	
	@Override
	public double getVolume() {
	    return 1 / 3 * (side * side * getHeight());
	}
	
	@Override
	public double getBaseArea() {
	    return side * side;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + ", height = " + super.getHeight() + ", radius = " + this.side;
	}
}
