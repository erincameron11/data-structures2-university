package demoarraybinarytree;

public class BinaryTreeArrayBased {

	/** Inner Node Class */
	public class TreeNode {  // Node in the tree
		private Object item;  // Data item in the tree
		private int leftChild;  // Index to the left child
		private int rightChild;  // Index to the right child
		
		TreeNode(int data) {
			item = data;
		}
		
	}
	
	// Initialize variables
	protected final int MAX_NODES = 100;
	protected TreeNode tree [];
	protected int root;  // Index of root
	protected int free;  // index of next unused array location
	
	// Constructor
	BinaryTreeArrayBased() {
		
	}
	
	// Methods
	// If parent index = i, the relationship between parent and children:
		// Left child index 2 * i + 1
		// Right child index 2 + i + 2
		// To find parent = i - 1 / 2
	
	
	/** Main Method */
	public static void main(String[] args) {
		

	}

}
