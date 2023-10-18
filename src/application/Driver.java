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
		 
//		 String[] fileNames = {"res/polyfor1.txt", "res/polyfor3.txt", "res/polyfor5.txt"};
		 String[] fileNames = {"res/polyfor1.txt"};
		 
		 for(String fileName : fileNames) {
			 
			 File textFile = new File(fileName);
			 
			 try {
				Scanner sc = new Scanner(textFile);
				
				while(sc.hasNextLine()) {
					
					String data = sc.nextLine();
					String[] splittedData = data.split(" ");
					int numberOfData = Integer.parseInt(splittedData[0]);
					
					
					System.out.println(numberOfData);
					
				}
				
				
				
				
				
				sc.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		 
	 }

}