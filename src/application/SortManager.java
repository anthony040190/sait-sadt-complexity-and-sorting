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
	private String fileName;
	private char compareType;
	private char sortType;
	Shape[] shapes;
	

	public SortManager(String[] args) 
	{
		if(args[0].toLowerCase().startsWith("-f")) 
		{
			setFileName(args[0].substring(2));
		} 
		else if(args[1].toLowerCase().startsWith("-f")) 
		{ 
			setFileName(args[1].substring(2)); 
		} 
		else if(args[2].toLowerCase().startsWith("-f")) 
		{
			setFileName(args[2].substring(3)); 
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

	    if (compareType == 'H' || compareType == 'h') {
	        System.out.println("First sorted value: " + shapes[0].getHeight() + " meters");
	    } else if (compareType == 'A' || compareType == 'a') {
	        System.out.println("First sorted value: " + shapes[0].getBaseArea() + " square meters");
	    } else if (compareType == 'V' || compareType == 'v') {
	        System.out.println("First sorted value: " + shapes[0].getVolume() + " cubic meters");
	    }

	    int interval = 1000;
	    for (int i = interval; i < shapes.length; i += interval) {
	        System.out.println("Value at index " + i);
	        if (compareType == 'H' || compareType == 'h') {
	            System.out.println("Height: " + shapes[i].getHeight() + " meters");
	        } else if (compareType == 'A' || compareType == 'a') {
	            System.out.println("Base Area: " + shapes[i].getBaseArea() + " square meters");
	        } else if (compareType == 'V' || compareType == 'v') {
	            if (shapes[i] instanceof Pyramid) {
	                System.out.println("Volume: " + ((Pyramid) shapes[i]).getVolume() + " cubic meters");
	            } else if (shapes[i] instanceof Cone) {
	                System.out.println("Volume: " + ((Cone) shapes[i]).getVolume() + " cubic meters");
	            } else if (shapes[i] instanceof Cylinder) {
	                System.out.println("Volume: " + ((Cylinder) shapes[i]).getVolume() + " cubic meters");
	            } else if (shapes[i] instanceof SquarePrism) {
	                System.out.println("Volume: " + ((SquarePrism) shapes[i]).getVolume() + " cubic meters");
	            } else if (shapes[i] instanceof PentagonalPrism) {
	                System.out.println("Volume: " + ((PentagonalPrism) shapes[i]).getVolume() + " cubic meters");
	            } else if (shapes[i] instanceof OctagonalPrism) {
	                System.out.println("Volume: " + ((OctagonalPrism) shapes[i]).getVolume() + " cubic meters");
	            } else if (shapes[i] instanceof TriangularPrism) {
	                System.out.println("Volume: " + ((TriangularPrism) shapes[i]).getVolume() + " cubic meters");
	            }
	        }
	    }

	    if (compareType == 'H' || compareType == 'h') {
	        System.out.println("Last sorted value: " + shapes[shapes.length - 1].getHeight() + " meters");
	    } else if (compareType == 'A' || compareType == 'a') {
	        System.out.println("Last sorted value: " + shapes[shapes.length - 1].getBaseArea() + " square meters");
	    } else if (compareType == 'V' || compareType == 'v') {
	        System.out.println("Last sorted value: " + shapes[shapes.length - 1].getVolume() + " cubic meters");
	    }
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

	private void fillShapeArray() {
		String filePath = "res/" + getFileName();
		
		int indexCounter = 0;
		
		File textFile = new File(filePath);
		
		try {
			Scanner sc = new Scanner(textFile);

			while (sc.hasNextLine()) {

				String data = sc.nextLine();
				String[] splittedData = data.split(" ");

				int heightCounter = 2;
				int secondDataCounter = 3;
				shapes = new Shape[Integer.parseInt(splittedData[0])];
				for (int i = 1; i < splittedData.length; i += 3) {

					String shapeName = splittedData[i];
					double height = Double.parseDouble(splittedData[heightCounter]);
					double secondData = Double.parseDouble(splittedData[secondDataCounter]);

					switch (shapeName) {
					case "Cone":
//							shapesList.add(new Cone(height, secondData));
						shapes[indexCounter] = new Cone(height, secondData);
						break;
					case "Cylinder":
//							shapesList.add(new Cylinder(height, secondData));
						shapes[indexCounter] = new Cylinder(height, secondData);
						break;
					case "Pyramid":
//							shapesList.add(new Pyramid(height, secondData));
						shapes[indexCounter] = new Pyramid(height, secondData);
						break;
					case "OctagonalPrism":
//							shapesList.add(new OctagonalPrism(height, secondData));
						shapes[indexCounter] = new OctagonalPrism(height, secondData);
						break;
					case "PentagonalPrism":
//							shapesList.add(new PentagonalPrism(height, secondData));
						shapes[indexCounter] = new PentagonalPrism(height, secondData);
						break;
					case "SquarePrism":
//							shapesList.add(new SquarePrism(height, secondData));
						shapes[indexCounter] = new SquarePrism(height, secondData);
						break;
					case "TriangularPrism":
//							shapesList.add(new TriangularPrism(height, secondData));
						shapes[indexCounter] = new TriangularPrism(height, secondData);
						break;
					default:
						System.out.println("################################# EMPTY #########################################");
						break;
					}
					

					heightCounter += 3;
					secondDataCounter += 3;
					indexCounter++;
				}
			}

			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}
