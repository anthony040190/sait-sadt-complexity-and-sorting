package shape;

public class PentagonalPrism extends Shape{
	
	private double side;
	
	public PentagonalPrism(double height, double side) {
		super(height);
		this.side = side;
	}
	
	@Override
	public double getVolume() {
		return getBaseArea() * getHeight();
	}
	
	@Override
	public double getBaseArea() {
		return (5 * side * side) / (4 * Math.tan(54));
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + ", height = " + super.getHeight() + ", radius = " + this.side;
	}
}
