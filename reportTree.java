package accidentpack;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Stack;


/**
 * The {@code reportTree} class represents a binary search tree specifically for storing {@code Report} objects.
 * It provides functionalities to add new reports to the tree and print the contents of the tree in order
 * (from the smallest to greatest based on the start time of the reports).
 * @author Abdullahi Abdullahi
 */
public class reportTree {
	
	/**
     * Represents a node in the binary search tree.
     */
    private static class Node {
        Report data; // The data contained in the node
        Node left, right; // The left and right children of the node
        int numLeftChildren = 0;
		int numRightChildren = 0;

        
        
        /**
         * Constructs a new Node with the given Report.
         * 
         * @param value The {@code Report} object to store in this node.
         */
        public Node(Report value) {
            data = value;
            left = right = null;
           
        }

        
    }
    Node root; // The root of the binary search tree
    
    
    /**
     * Constructs an empty {@code reportTree}.
     */
    public reportTree() {
        root = null;
    }
    
    
    /**
     * Adds a new {@code Report} to the binary search tree.
     * 
     * @param value The {@code Report} object to be added to the tree.
     */
    public void add(Report value) {
        root = insert(root, value);
    }
    
    /**
     * Helper method to recursively insert a new report into the binary search tree.
     * 
     * @param root The root node of the subtree in which to insert the new report.
     * @param value The {@code Report} object to be inserted.
     * @return The new root of the subtree.
     */
    private Node insert(Node root, Report value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }
   
        if (copareReport(value, root.data) < 0) {
            root.left = insert(root.left, value);
            root.numLeftChildren++;
            
        } else if (copareReport(value, root.data) > 0) {
            root.right = insert(root.right, value);
            root.numRightChildren++;
        }
        else {
        	root.right = insert(root.right, value);
            root.numRightChildren++;

        }

        return root;
    }
    
    
    /**
     * Compares two {@code Report} objects based on their start time.
     * 
     * @param o1 The first {@code Report} object.
     * @param o2 The second {@code Report} object.
     * @return A negative integer, zero, or a positive integer as the first {@code Report} 
     *         is less than, equal to, or greater than the second.
     */
    private int copareReport(Report o1, Report o2) {
    	int result = o1.getStartTime().compareTo(o2.getStartTime());
		return result;
    }
    

    /**
     * Non-recursive method to perform in-order traversal of the tree and get the number of reports/accidents on and after that date..
     */
    public int numReportOnAfterDate(String inDate) {
        LocalDate date = LocalDate.parse(inDate);

    	int Count = 0;
        Stack<Node> stack = new Stack<>();
        Node current = root;

        while (current != null || !stack.isEmpty()) {
            // Reach the leftmost node of the current Node
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            // Current must be null at this point, so we process the node at the top of the stack
            current = stack.pop();
            LocalDate compareDate = current.data.getStartTime().toLocalDate();
            if(compareDate.compareTo(date)>=0) {
            	Count++;
            }
            // We have visited the node and its left subtree, now it's time to visit its right subtree
            current = current.right;
        }
		return Count;
    }
    
    
    /**
     * Method to perform in-order traversal of the tree and get the number of reports/accidents on and after that date Recursively.
     * 
     * @param inDate The date to compare the reports against.
     * @return The count of reports on and after the specified date.
     */
    public int numReportOnAfterDateRec(String inDate) {
        LocalDate date = LocalDate.parse(inDate);
        return HnumReportOnAfterDateRec(root, date);
    }

    /**
     * Recursive helper method to perform in-order traversal of the tree and count reports.
     * 
     * @param node The current node in the traversal.
     * @param date The date to compare each report's date against.
     * @return The count of reports on and after the specified date.
     */
    private int HnumReportOnAfterDateRec(Node node, LocalDate date) {
        if (node == null) {
            return 0;
        }

        int count = 0;
        LocalDate compareDate = node.data.getStartTime().toLocalDate();

        // Count in left subtree
        count += HnumReportOnAfterDateRec(node.left, date);

        // Check current node
        if (compareDate.compareTo(date) >= 0) {
            count++;
        }

        // Count in right subtree
        count += HnumReportOnAfterDateRec(node.right, date);

        return count;
    }



 
     
}

