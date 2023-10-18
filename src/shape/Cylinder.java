package shape;

public class Cylinder extends Shape {

	private double radius;
	
	public Cylinder(double height, double radius) {
	    super(height);
	    this.radius = radius;
	}
	
	@Override
	public double getVolume() {
	    return Math.PI * radius * radius * getHeight();
	}
	
	@Override
	public double getBaseArea() {
	    return Math.PI * radius * radius;
	}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + ", height = " + super.getHeight() + ", radius = " + this.radius;
	}
}
