package shape;

public class SquarePrism extends Shape{
	
	private double side;
	
	public SquarePrism(double height, double side) {
		super(height);
		this.side = side;
	}
	
	@Override
	public double getVolume() {
		return 	side * side * getHeight();	
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
