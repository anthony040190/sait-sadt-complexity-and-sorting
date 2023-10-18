package shape;

public class TriangularPrism extends Shape {

	private double side;
	
	public TriangularPrism(double height, double side) {
		super(height);
		this.side = side;
	}
	
	@Override
	public double getVolume() {
		return getBaseArea() * getHeight();
	}
	
	@Override
	public double getBaseArea() {
		return (Math.sqrt(3) / 4) * side * side;
	}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + ", height = " + super.getHeight() + ", radius = " + this.side;
	}
}
