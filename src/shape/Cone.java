package shape;

public class Cone extends Shape{
	
	private double radius;
	
	public Cone(double height, double radius) {
		super(height);
		this.radius = radius;
	}
	
	@Override
    public double getVolume() {
        return 1 / 3 * (Math.PI * radius * radius * getHeight());
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
