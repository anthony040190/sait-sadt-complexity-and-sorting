package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import shape.*;

public class ShapeManager {

    private void fillShapeList() {
    	
        List<Shape> shapes = new ArrayList<>();

        String[] fileNames = {"res/polyfor1.txt", "res/polyfor3.txt", "res/polyfor5.txt"}; 

        for (String fileName : fileNames) {
            try {
                File file = new File(fileName);
                Scanner scanner = new Scanner(file);

                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] parts = line.split(" "); 
                    String shapeType = parts[0];
                    double height = Double.parseDouble(parts[1]);

                    if (shapeType.equals("Cylinder")) {
                        double radius = Double.parseDouble(parts[2]);
                        shapes.add(new Cylinder(height, radius));
                    } else if (shapeType.equals("Cone")) {
                        double radius = Double.parseDouble(parts[2]);
                        shapes.add(new Cone(height, radius));
                    } else if (shapeType.equals("Pyramid")) {
                        double side = Double.parseDouble(parts[2]);
                        shapes.add(new Pyramid(height, side));
                    } else if (shapeType.equals("PentagonalPrism")) {
                        double side = Double.parseDouble(parts[2]);
                        shapes.add(new Pyramid(height, side));
                    } else if (shapeType.equals("TriangularPrism")) {
                        double side = Double.parseDouble(parts[2]);
                        shapes.add(new Pyramid(height, side));
                    } else if (shapeType.equals("OctagonalPrism")) {
                        double side = Double.parseDouble(parts[2]);
                        shapes.add(new Pyramid(height, side));
                    } else if (shapeType.equals("SquarePrism")) {
                        double side = Double.parseDouble(parts[2]);
                        shapes.add(new Pyramid(height, side));
                    }
                scanner.close();
                }
                
                } catch (FileNotFoundException e) {
                System.out.println("File not found: " + fileName);
                e.printStackTrace();
            }
        }
    }
}

