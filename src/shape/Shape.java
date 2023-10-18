package shape;

public abstract class Shape implements Comparable<Shape>
{

	private double height;
	
	public Shape(double height) 
	{
		this.height = height;
	}
	
	public double getHeight() 
	{
		return height;
	}

	public void setHeight(double height) 
	{
		this.height = height;
	}

	public abstract double getVolume();
	
	public abstract double getBaseArea();
	
	@Override
	public int compareTo(Shape that) 
	{
		if (this.height < that.height)
		{
			return -1;
		}
		if (this.height < that.height)
		{
			return 1;
		}
		return 0;
		}
	}
