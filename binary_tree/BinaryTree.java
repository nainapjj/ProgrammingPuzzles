import java.util.Scanner;
import java.util.ArrayList;

public class BinaryTree {
    public static void main(String args[]) {
        // Grab a Scanner to parse user input
        Scanner userInput = new Scanner(System.in);

        // Create an empty BTree
        BTree tree = new BTree();

        int input = 0;
        while (input != -1) {
            System.out.print("Enter positive value: ");
            input = userInput.nextInt();

            if (input != -1) {
                tree.insert(input);
            }
        }

        // Finally output the tree in-order
        tree.inOrderOutput();
    }

}

class BTreeNode {
    public int value;
    public BTreeNode left;
    public BTreeNode right;

    public BTreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

class BTree {
    BTreeNode root;

    public BTree() {
        this.root = null;
    }

    public void insert(int value) {
        // Simply call the recursive helper function
        root = this.insertRecursive(root, value);
    }

    private BTreeNode insertRecursive(BTreeNode node, int value) {
        if (node == null) {
            return new BTreeNode(value);
        } else {
            // Check which path to go down.
            if (value > node.value) {
                node.right = this.insertRecursive(node.right, value);
            } else {
                node.left = this.insertRecursive(node.left, value);
            }

            return node;
        }
    }

    public void inOrderOutput() {
        this.inOrderOutputRecursive(root);
    }

    private void inOrderOutputRecursive(BTreeNode node) {
        if (node == null) return;

        inOrderOutputRecursive(node.left);
        System.out.println(node.value);
        inOrderOutputRecursive(node.right);
    }

    public void treeOutput() {

    }

    /*private ArrayList<Integer> getNodesAtLevel(int level) {
        while (level )
    }*/
}