package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import shape.Cone;
import shape.Cylinder;
import shape.OctagonalPrism;
import shape.PentagonalPrism;
import shape.Pyramid;
import shape.Shape;
import shape.SquarePrism;
import shape.TriangularPrism;
import utility.BaseAreaComparator;
import utility.Sorts;
import utility.VolumeComparator;

public class SortManager 
{
	private String fileName;
	private char compareType;
	private char sortType;
	private Shape[] shapes;

	public SortManager(String[] args) 
	{
		 if(args[0].toLowerCase().startsWith("-f")) 
		  { 
			  fileName = args[0].substring(2);
		  } 
		  else if(args[1].toLowerCase().startsWith("-f")) 
		  { 
			  fileName = args[1].substring(2); 
		  } 
		  else if(args[2].toLowerCase().startsWith("-f")) 
		  {
			  fileName = args[2].substring(3); 
		  } 
		  if(args[0].toLowerCase().startsWith("-t"))
		  { 
			  compareType = args[0].substring(2).charAt(0); 
		  } 
		  //..........
		  
			 
		fillShapeArray();
		sortShapes();
		printSortedShapes();

	}

	private void printSortedShapes() {
		// TODO Auto-generated method stub

	}

	private void sortShapes() {
		if (sortType == 'B' || sortType == 'b') {
			if (compareType == 'H' || compareType == 'h') {
				Sorts.bubbleSort(shapes);
			} else if (compareType == 'A' || compareType == 'a') {
				Sorts.bubbleSort(shapes, new BaseAreaComparator());
			} else if (compareType == 'V' || compareType == 'v') {
				Sorts.bubbleSort(shapes, new VolumeComparator());
			}
		}

	}

	private void fillShapeArray() {
		String[] fileNames = { "res/polyfor1.txt", "res/polyfor3.txt", "res/polyfor5.txt" };

		ArrayList<Shape> shapesList = new ArrayList<>();

		for (String fileName : fileNames) {

			File textFile = new File(fileName);

			try {
				Scanner sc = new Scanner(textFile);

				while (sc.hasNextLine()) {

					String data = sc.nextLine();
					String[] splittedData = data.split(" ");

					int heightCounter = 2;
					int secondDataCounter = 3;
					for (int i = 1; i < splittedData.length; i += 3) {

						String shapeName = splittedData[i];
						double height = Double.parseDouble(splittedData[heightCounter]);
						double secondData = Double.parseDouble(splittedData[secondDataCounter]);

						switch (shapeName) {
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

					for (Shape shape : shapesList)
						System.out.println(shape.toString());
				}

				sc.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}

	}

}
