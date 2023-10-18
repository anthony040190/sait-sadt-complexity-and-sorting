package shape;

public class TrianglarPrism extends Shape {

	private double side;
	
	public TrianglarPrism(double height, double side) {
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
}
