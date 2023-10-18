package application;

import java.util.Comparator;

import shape.Shape;

public class HeightCompare implements Comparator<Shape> {

    @Override
    public int compare(Shape shape1, Shape shape2) {
        return shape1.compareTo(shape2);
    }
}

