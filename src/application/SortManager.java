package application;

import shape.Shape;

public class SortManager {
	
	private String fileName;
	private char compareType;
	private char sortType;
	private Shape[] shapes;
	
	public SortManager(String[] args) {
		if(args[0].toLowerCase().startsWith("-f")) {
			fileName = args[0].substring(2);
		}
		else if(args[1].toLowerCase().startsWith("-f")) {
			fileName = args[1].substring(2);
		}
		else if(args[2].toLowerCase().startsWith("-f")) {
			fileName = args[2].substring(3);
		}
		if (args[0].toLowerCase().startsWith("-t")) {
			compareType = args[0].substring(2).charAt(0);
		}
		
		fillShapeArray();
		sortShapes();
	}

	private void sortShapes() {
		if(sortType == )
		
	}

	private void fillShapeArray() {
		// TODO Auto-generated method stub
		
	}

}
