package accidentpackage;

import java.util.Stack;

public class myBST {

	private static class Node {
		Accident data;
		Node left, right;

		public Node(Accident value) {
			data = value;
			left = right = null;
		}
	}

	Node root;

	public myBST() {
		root = null;

	}

	/*
	 * Counts the number of reports in a binary search tree based on state and date
	 * using iterative.
	 * 
	 * @param tree
	 * 
	 * @param state
	 * 
	 * @param date
	 * 
	 * @return count
	 */
	public static int countReports(myBST tree, String state, String Start_Time) {
		int count = 0;
		Stack<myBST.Node> stack = new Stack<myBST.Node>();

		if (tree.root != null) {
			stack.push(tree.root);
		}

		while (stack != null) {
			myBST.Node current = stack.pop();

			if (current.data.getState().equals(state) && current.data.getStart_Time().equals(Start_Time)) {
				count++;
			}

			if (current.right != null) {
				stack.push(current.right);
			}
			if (current.left != null) {
				stack.push(current.left);
			}
		}

		return count;
	}

	/*
	 * Counts the number of reports in a binary search tree based on state and date
	 * using recursive.
	 * 
	 * @param root
	 * 
	 * @param state
	 * 
	 * @param date
	 * 
	 * @return the count of reports matching the state and date
	 */
	public static int countRec(myBST.Node root, String state, String Start_Time) {
		if (root == null) {
			return 0;
		}

		int compareDate = Start_Time.compareTo(root.data.getStart_Time());
		int compareState = state.compareTo(root.data.getState());

		if (compareState == 0 && compareDate <= 0) {

			return 1 + countRec(root.left, state, Start_Time) + countRec(root.right, state, Start_Time);

		} else if (compareState < 0) {

			return countRec(root.left, state, Start_Time);

		} else {

			return countRec(root.right, state, Start_Time);
		}
	}

}
