package application;

import shape.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Driver {
	
	 public static void main(String[] args) {
		 
		 String[] fileNames = {"res/polyfor1.txt", "res/polyfor3.txt", "res/polyfor5.txt"};

		 List<Shape> shapes = new ArrayList<>();
		 List<Cone> cone = new ArrayList<>();
		 
		 for(String fileName : fileNames) {
			 
			 File textFile = new File(fileName);
			 
			 try {
				Scanner sc = new Scanner(textFile);
				
				while(sc.hasNextLine()) {
					
					String data = sc.nextLine();
					String[] splittedData = data.split(" ");
					int numberOfData = Integer.parseInt(splittedData[0]);
					String shapeType = splittedData[1];
	                double height = Double.parseDouble(splittedData[2]);
					
                    if (shapeType.equals("Cylinder")) {
                        double radius = Double.parseDouble(splittedData[3]);
                        shapes.add(new Cylinder(height, radius));
                    } else if (shapeType.equals("Cone")) {
                        double radius = Double.parseDouble(splittedData[3]);
                        shapes.add(new Cone(height, radius));
                    } else if (shapeType.equals("Pyramid")) {
                        double side = Double.parseDouble(splittedData[3]);
                        shapes.add(new Pyramid(height, side));
                    } else if (shapeType.equals("PentagonalPrism")) {
                        double side = Double.parseDouble(splittedData[3]);
                        shapes.add(new Pyramid(height, side));
                    } else if (shapeType.equals("TriangularPrism")) {
                        double side = Double.parseDouble(splittedData[3]);
                        shapes.add(new Pyramid(height, side));
                    } else if (shapeType.equals("OctagonalPrism")) {
                        double side = Double.parseDouble(splittedData[3]);
                        shapes.add(new Pyramid(height, side));
                    } else if (shapeType.equals("SquarePrism")) {
                        double side = Double.parseDouble(splittedData[3]);
                        shapes.add(new Pyramid(height, side));
                    }
  					
				
				}

				
				System.out.println(cone);
				
				
				
				sc.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		 
	 }

}