package accidentpack;

import java.io.IOException;
import java.util.Scanner;

public class Program5 {

	public static void main(String[] args) throws IOException {

		String filePath = null;
		if (args.length > 0) {
             filePath = args[0]; // Get the file path from the first argument
        } else {
            System.out.println("No file path provided.");
        }

		  // Example binaryTree for you to use to test your methods
        reportTree binaryTree = new reportTree();
        
        Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the state (e.g., IL): ");
		String state = scanner.nextLine();
		System.out.println("Enter the date (e.g., 2022-09-08): ");
		String date = scanner.nextLine();
		
		long StartReadFile = System.currentTimeMillis();
//        enter file path 
        Report.ReadCSVFile(filePath, binaryTree, state);
		long endReadFile = System.currentTimeMillis();
		double countReadFile = endReadFile - StartReadFile;
        
		long StartCountTime = System.currentTimeMillis();
        int countResult = binaryTree.numReportOnAfterDate(date);
		long StopCountTime = System.currentTimeMillis();
		double countElapsedTime = (StopCountTime - StartCountTime)+countReadFile ;
		
		System.out.println("\n");
		System.out.println(countResult + " reports are available for " + state + " on and after the date " + date);
		System.out.println(countElapsedTime + " seconds to calculate this using children count fields");
		
		System.out.println("\n");
		// Measure the time to calculate using recursive method
		long recursiveStartTime = System.currentTimeMillis();
		int recursiveResult = binaryTree.numReportOnAfterDateRec(date);
		long recursiveStopTime = System.currentTimeMillis();
		double recursiveElapsedTime = (recursiveStopTime - recursiveStartTime)+countReadFile;

		System.out.println(recursiveResult + " reports are available for " + state);
		System.out.println(recursiveElapsedTime + " seconds to calculate this using recursive method");

  
	}

}