package accidentpack;

import java.io.IOException;
import java.util.Scanner;

public class Program5 {

	public static void main(String[] args) throws IOException {

		  // Example binaryTree for you to use to test your methods
        reportTree binaryTree = new reportTree();
        
        Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the state (e.g., IL): ");
		String state = scanner.nextLine();
		System.out.println("Enter the date (e.g., 2022-09-08): ");
		String date = scanner.nextLine();
//        enter file path 
        Report.ReadCSVFile("C:/Users/Abdul/Downloads/accidents.csv", binaryTree, state);
        
		long StartCountTime = System.currentTimeMillis();
        int countResult = binaryTree.numReportOnAfterDate(date);
		long StopCountTime = System.currentTimeMillis();
		double countElapsedTime = StopCountTime - StartCountTime;
		
		System.out.println("\n");
		System.out.println(countResult + " reports are available for " + state + " on and after the date " + date);
		System.out.println(countElapsedTime + " seconds to calculate this using children count fields");
		
		System.out.println("\n");
		// Measure the time to calculate using recursive method
		long recursiveStartTime = System.currentTimeMillis();
		int recursiveResult = binaryTree.numReportOnAfterDateRec(date);
		long recursiveStopTime = System.currentTimeMillis();
		double recursiveElapsedTime = recursiveStopTime - recursiveStartTime;

		System.out.println(recursiveResult + " reports are available for " + state);
		System.out.println(recursiveElapsedTime + " seconds to calculate this using recursive method");

  
	}

}