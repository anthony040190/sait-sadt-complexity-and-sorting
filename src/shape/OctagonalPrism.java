package shape;

public class OctagonalPrism extends Shape {

	private double side;
	
	public OctagonalPrism(double height, double side) {
		super(height);
		this.side = side;
	}
	
	@Override
	public double getVolume() {
		return getBaseArea() * getHeight() / 4;
	}
	
	@Override
	public double getBaseArea() {
		return 2 * (1 + Math.sqrt(2)) * side * side;
	}
}
