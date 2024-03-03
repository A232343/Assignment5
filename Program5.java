package accidentpackage;

import java.io.IOException;
import java.util.Scanner;

public class Program5 {

	public static void main(String[] args) throws IOException {

		myBST binaryTree = new myBST();

		String fillPath = args[0];

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the state (e.g., IL): ");
		String state = scanner.nextLine();
		System.out.println("Enter the date (e.g., 2022-09-08): ");
		String date = scanner.nextLine();

		String stateObj = String.valueOf(state);
		String dateObj = String.valueOf(date);

		// Measure the time to calculate using children count fields
		long StartCountTime = System.currentTimeMillis();
		int countResult = binaryTree.countReports(binaryTree, state, date);
		long StopCountTime = System.currentTimeMillis();
		double countElapsedTime = StopCountTime - StartCountTime;

		System.out.println(countResult + " reports are available for " + state + " on and after the date " + date);
		System.out.println(countElapsedTime + " seconds to calculate this using children count fields");

		// Measure the time to calculate using recursive method
		long recursiveStartTime = System.currentTimeMillis();
		int recursiveResult = binaryTree.countRec(binaryTree.root, state, date);
		long recursiveStopTime = System.currentTimeMillis();
		double recursiveElapsedTime = recursiveStopTime - recursiveStartTime;

		System.out.println(recursiveResult + " reports are available for " + state + " on and after the date " + date);
		System.out.println(recursiveElapsedTime + " seconds to calculate this using recursive method");

	}

}