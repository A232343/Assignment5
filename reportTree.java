package accidentpack;

/**
 * The {@code reportTree} class represents a binary search tree specifically for storing {@code Report} objects.
 * It provides functionalities to add new reports to the tree and print the contents of the tree in reverse order
 * (from the greatest to the smallest based on the start time of the reports).
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
        
//        public int getNumLeftChildren() {
//			return numLeftChildren;
//		}
//
//		public int getNumRightChildren() {
//			return numRightChildren;
//		}
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
     * Prints the reports in the tree in reverse order (from greatest to smallest based on the start time).
     */
    public void print() {
    	reverseInOrderRec(root);
    }
    
    /**
     * Helper method to recursively perform reverse in-order traversal of the tree and print the reports.
     * 
     * @param node The current node in the traversal.
     */
    private void reverseInOrderRec(Node node) {
        if (node != null) {
        	reverseInOrderRec(node.right); // Visit right child
            System.out.println(node.data + " "); // Print node's data
            reverseInOrderRec(node.left); // Visit left child

        }
    }
    
    
    public void printLeftChildern() {
    	System.out.println(root.numLeftChildren);
    }
    public void printRightChildern() {
    	System.out.println(root.numRightChildren);
    }
 
     
}

