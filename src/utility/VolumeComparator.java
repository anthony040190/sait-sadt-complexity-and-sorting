package utility;

import java.util.Comparator;

import shape.Shape;

public class VolumeComparator implements Comparator<Shape> {

    @Override
    public int compare(Shape shape1, Shape shape2) 
    {
    	if(shape1.getVolume() > shape2.getVolume())
    	{
    		return 1;
    	}
    	else if(shape1.getVolume() < shape2.getVolume())
    	{
    		return -1;
    	}
    	return 0;
    }
}

