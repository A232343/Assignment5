package accidentpack;

import java.io.IOException;

public class Program5 {

    public static void main(String[] args) throws IOException {
        // Example binaryTree for you to use to test your methods
        reportTree binaryTree = new reportTree();
        
//        enter file path 
        Report.ReadCSVFile("  ", binaryTree);
        //print the binaryTree in reverse Order /  largest to smallest.
        binaryTree.print();

    }
    
}
