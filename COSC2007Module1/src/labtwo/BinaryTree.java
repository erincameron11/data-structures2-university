package labtwo;

public class BinaryTree {

	Node root;
	
	/** Create a new inner class to construct nodes on the tree */
	static class Node {
		int data;
		Node left, right;
		
		// Constructor
		Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	
	
	/** Method to recursively insert nodes based on the level order */
	public Node insertLvlOrder(int[] array, Node root, int i) {
		
		// Base Case
		if (i < array.length) {
			Node temp = new Node(array[i]);
			root = temp;
			
			// Insert the left child
			root.left = insertLvlOrder(array, root.left, 2 * i + 1);
			
			// Insert the right child
			root.right = insertLvlOrder(array, root.right, 2 * i + 2);
		}
		return root;
	}
	
	
	/** Method to print the data out in in-order format (LEFT - ROOT - RIGHT) */
	public void inOrder(Node root) {
		
		// Recursively call left and right with root data in the middle
		if (root != null) {  // If the tree isn't empty
			inOrder(root.left);
			System.out.print(root.data + " ");
			inOrder(root.right);
		}
		
	}
	
	
	/** Method to print the data out in pre-order format (ROOT - LEFT - RIGHT) */
	public void preOrder(Node root) {
		
		// Recursively call the root, then left, then right
		if (root != null) {  // If the tree isn't empty
			System.out.print(root.data + " ");
			preOrder(root.left);
			preOrder(root.right);
		}
		
	}
	
	
	/** Method to print the data out in post-order format (LEFT - RIGHT - ROOT) */
	public void postOrder(Node root) {
		
		// Recursively call the left, then root, then right
		if (root != null) {  // If the tree isn't empty
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(root.data + " ");
		}
		
	}
	
	
	
	
	
	private static final int COUNT = 5;
	static void print2DUtil(Node root, int space)
	{
	    // Base case
	    if (root == null)
	        return;
	 
	    // Increase distance between levels
	    space += COUNT;
	 
	    // Process right child first
	    print2DUtil(root.right, space);
	 
	    // Print current node after space
	    // count
	    System.out.print("\n");
	    for (int i = COUNT; i < space; i++)
	        System.out.print(" ");
	    System.out.print(root.data + "\n");
	 
	    // Process left child
	    print2DUtil(root.left, space);
	}
	 
	// Wrapper over print2DUtil()
	static void print2D(Node root)
	{
	    // Pass initial space count as 0
	    print2DUtil(root, 0);
	}
	
	
	
	
	
	
	
	/** Main Method to run the program */
	public static void main(String[] args) {
		
		// Create an object of BinaryTree
		BinaryTree tree = new BinaryTree();
		
		// Create an array as the test data to re-arrange
//		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
//		int[] array = {8, 11, 17, 15, 18, 22};
		int[] array = {8, 11, 15, 17, 18, 22};
		
		tree.root = tree.insertLvlOrder(array, tree.root, 0);
		
		// Display in-order
		System.out.print("InOrder: ");
		tree.inOrder(tree.root);
		System.out.println();
		
		// Display pre-order
		System.out.print("PreOrder: ");
		tree.preOrder(tree.root);
		System.out.println();
		
		// Display post-order
		System.out.print("PostOrder: ");
		tree.postOrder(tree.root);
		
		
//		tree.print2D(tree.root);
	}

}
