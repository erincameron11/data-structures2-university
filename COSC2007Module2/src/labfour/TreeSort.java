package labfour;

public class TreeSort {

	Node root;
	
	/** Inner Node class */
	public class Node {
		int key;
		Node left, right;
		
		// Constructor
		Node(int data) {
			key = data;
			this.left = null;
			this.right = null;
		}
	}
	
	
	// Constructor for an empty BST
	public TreeSort() {
		root = null;
	}
	
	
	/** Method to call the recursive insert method */
	public void insertCaller(int key) {
		root = insert(root, key);
	}
	
	
	/** Method to insert a node */
	public Node insert(Node root, int key) {
		// Base Case - if the tree is empty
		if (root == null) {
			root = new Node(key);
			return root;
		}
		
		if (key > root.key) {  // Then the value is greater than and you traverse the right side of tree
			root.right = insert(root.right, key);
		} else if (key < root.key) {  // Then the value is less than and you traverse the left side of tree
			root.left = insert(root.left, key);
		}
		return root;
	}
	
	
	/** Method to display elements inorder - (LEFT - ROOT - RIGHT) */
	public void inOrder(Node root) {
		// Recursively call left and right with root data in the middle
		if (root != null) {  // If the tree isn't empty
			inOrder(root.left);
			System.out.print(root.key + " ");
			inOrder(root.right);
		}
	}	
	
	
	/** Main Method */
	public static void main(String[] args) {
		// Create a BST object empty tree
		TreeSort ts = new TreeSort();
		
		// Create array of elements to insert
		int[] array = {45, 10, 7, 90, 12, 50, 13, 39, 57};
		
		// Insert elements into the BST
		for (int i = 0; i < array.length; i++) {
			ts.insertCaller(array[i]);
		}
		
		// Display elements in increasing order
		System.out.println("Tree-sorted array elements inOrder: ");
		ts.inOrder(ts.root);
		
	}
}
