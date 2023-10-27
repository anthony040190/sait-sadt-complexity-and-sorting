package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
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
	private String fileName = "";
	private char compareType;
	private char sortType;
	private Shape[] shapes;
	Shape[] shapesList;
	

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
		  else if (args[1].toLowerCase().startsWith("-t")) 
		  {
	          compareType = args[1].substring(2).charAt(0);
	      }
		  else if (args[2].toLowerCase().startsWith("-t")) 
		  {
	          compareType = args[2].substring(2).charAt(0);
	      }
		  
	      if (args[0].toLowerCase().startsWith("-s")) 
	      {
	          sortType = args[0].substring(2).charAt(0);
	      }
	      else if (args[1].toLowerCase().startsWith("-s")) 
	      {
	          sortType = args[1].substring(2).charAt(0);
	      }
	      else if (args[2].toLowerCase().startsWith("-s")) 
	      {
	          sortType = args[2].substring(2).charAt(0);
	      }		  
			 
		fillShapeArray();
		sortShapes();
		printSortedShapes();

	}

	private void printSortedShapes() {
	    long startTime = System.nanoTime();
	    sortShapes();
	    long endTime = System.nanoTime();
	    long duration = (endTime - startTime) / 1000000; // milliseconds

	    System.out.println("Time taken to sort: " + duration + " milliseconds");

	    System.out.println("First sorted value: " + shapes[0]);
	    System.out.println("Last sorted value: " + shapes[shapes.length - 1]);

	    int interval = Math.max(1, shapes.length / 1000);
	    for (int i = 0; i < shapes.length; i += interval) {
	        System.out.println("Value at index " + i + ": " + shapes[i]);
	    }

	}

	private void sortShapes() {
		if (sortType == 'B' || sortType == 'b') {
			if (compareType == 'H' || compareType == 'h') {
				Sorts.bubbleSort(shapesList);
			} else if (compareType == 'A' || compareType == 'a') {
				Sorts.bubbleSort(shapesList, new BaseAreaComparator());
			} else if (compareType == 'V' || compareType == 'v') {
				Sorts.bubbleSort(shapesList, new VolumeComparator());
			}
		}
		if (sortType == 'I' || sortType == 'i') {
			if (compareType == 'H' || compareType == 'h') {
				Sorts.insertionSort(shapes);
			} else if (compareType == 'A' || compareType == 'a') {
				Sorts.insertionSort(shapes, new BaseAreaComparator());
			} else if (compareType == 'V' || compareType == 'v') {
				Sorts.insertionSort(shapes, new VolumeComparator());
			}
		}
		if (sortType == 'S' || sortType == 's') {
			if (compareType == 'H' || compareType == 'h') {
				Sorts.selectionSort(shapes);
			} else if (compareType == 'A' || compareType == 'a') {
				Sorts.selectionSort(shapes, new BaseAreaComparator());
			} else if (compareType == 'V' || compareType == 'v') {
				Sorts.selectionSort(shapes, new VolumeComparator());
			}
		}
		if (sortType == 'M' || sortType == 'm') {
			if (compareType == 'H' || compareType == 'h') {
				Sorts.mergeSort(shapes);
			} else if (compareType == 'A' || compareType == 'a') {
				Sorts.mergeSort(shapes, new BaseAreaComparator());
			} else if (compareType == 'V' || compareType == 'v') {
				Sorts.mergeSort(shapes, new VolumeComparator());
			}
		}
		if (sortType == 'Q' || sortType == 'q') {
			if (compareType == 'H' || compareType == 'h') {
				Sorts.quickSort(shapes);
			} else if (compareType == 'A' || compareType == 'a') {
				Sorts.quickSort(shapes, new BaseAreaComparator());
			} else if (compareType == 'V' || compareType == 'v') {
				Sorts.quickSort(shapes, new VolumeComparator());
			}
		}
		if (sortType == 'H' || sortType == 'h') {
			if (compareType == 'H' || compareType == 'h') {
				Sorts.heapSort(shapes);
			} else if (compareType == 'A' || compareType == 'a') {
				Sorts.heapSort(shapes, new BaseAreaComparator());
			} else if (compareType == 'V' || compareType == 'v') {
				Sorts.heapSort(shapes, new VolumeComparator());
			}
		}

	}
	
	private int getTotalData() {
		
		String[] fileNames = { "res/polyfor1.txt", "res/polyfor3.txt", "res/polyfor5.txt" };
		int totalData = 0;
		for (String fileName : fileNames) {

			File textFile = new File(fileName);

			try {
				Scanner sc = new Scanner(textFile);

				while (sc.hasNextLine()) {

					String data = sc.nextLine();
					String[] splittedData = data.split(" ");
					
					totalData += Integer.parseInt(splittedData[0]);
					
				}
				 
				sc.close();
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		return totalData;
	}

	private void fillShapeArray() {
		String[] fileNames = { "res/polyfor1.txt", "res/polyfor3.txt", "res/polyfor5.txt" };
//		ArrayList<Shape> shapesList = new ArrayList<>();

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
//							shapesList.add(new Cone(height, secondData));
							shapesList = new Cone(height, secondData);
							break;
						case "Cylinder":
//							shapesList.add(new Cylinder(height, secondData));
							shapesList = new Cylinder(height, secondData);
							break;
						case "Pyramid":
//							shapesList.add(new Pyramid(height, secondData));
							shapesList = new Pyramid(height, secondData);
							break;
						case "OctagonalPrism":
//							shapesList.add(new OctagonalPrism(height, secondData));
							shapesList = new OctagonalPrism(height, secondData);
							break;
						case "PentagonalPrism":
//							shapesList.add(new PentagonalPrism(height, secondData));
							shapesList = new PentagonalPrism(height, secondData);
							break;
						case "SquarePrism":
//							shapesList.add(new SquarePrism(height, secondData));
							shapesList = new SquarePrism(height, secondData);
							break;
						case "TriangularPrism":
//							shapesList.add(new TriangularPrism(height, secondData));
							shapesList = new TriangularPrism(height, secondData);
							break;
						}

						heightCounter += 3;
						secondDataCounter += 3;
					}

//					for (Shape shape : shapesList)
//						System.out.println(shape.toString());
				}

				sc.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}

	}

}
