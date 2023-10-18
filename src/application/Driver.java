package application;

import shape.Cone;
import shape.Cylinder;
import shape.Pyramid;
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
		 
		 ArrayList<Shape> shapesList = new ArrayList<>();
		 
		 for(String fileName : fileNames) {
			 
			 File textFile = new File(fileName);
			 
			 try {
				Scanner sc = new Scanner(textFile);
				
				while(sc.hasNextLine()) {
					
					String data = sc.nextLine();
					String[] splittedData = data.split(" ");
					int numberOfData = Integer.parseInt(splittedData[0]);
					
					System.out.println(Arrays.toString(splittedData));
					
					int heightCounter = 2;
					int secondDataCounter = 3;
					for(int i = 1; i < splittedData.length; i += 3) {
//						System.out.println(splittedData[i]);
						
						String shapeName = splittedData[i];
						double height = Double.parseDouble(splittedData[heightCounter]);
						double secondData = Double.parseDouble(splittedData[secondDataCounter]);
						
						switch(shapeName) {
							case "Cone":
								shapesList.add(new Cone(height, secondData));
								break;
							case "Cylinder":
								shapesList.add(new Cylinder(height, secondData));
								break;
							case "Pyramid":
								shapesList.add(new Pyramid(height, secondData));
								break;
							case "OctagonalPrism":
								shapesList.add(new OctagonalPrism(height, secondData));
								break;
							case "PentagonalPrism":
								shapesList.add(new PentagonalPrism(height, secondData));
								break;
							case "SquarePrism":
								shapesList.add(new SquarePrism(height, secondData));
								break;
							case "TriangularPrism":
								shapesList.add(new TriangularPrism(height, secondData));
								break;
						}
												
						heightCounter += 3;
						secondDataCounter += 3;
					}
				}
				
				
				
				for(Shape shape : shapesList)
					System.out.println(shape.toString());
				
				sc.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		 
	 }

}