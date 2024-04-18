package labthree;

public class BinarySearchTree {

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
	public BinarySearchTree() {
		root = null;
	}
	
	
	/** Method to delete a node */
	public Node delete(Node root, int key) {
		// Base Case - if the tree is empty just return the root
		if (root == null) {
			return root;
		}
		
		// Check the key against each node value, until the correct one is found
		if (key > root.key) {  // Then the value is greater than and you traverse the right side of tree
			root.right = delete(root.right, key);
		} else if (key < root.key) {  // Then the value is less than and you traverse the left side of tree
			root.left = delete(root.left, key);
		} else {
			
			// Handle the case where a node has only one child
			if (root.left == null) {
				return root.right;
			} else if (root.right == null) {
				return root.left;
			}
			
			// Handle the case where a node has two children
			root.key = minVal(root.right);
			
			root.right = delete(root.right, root.key);
		}
		return root;
	}
	
	
	public int minVal(Node root) {
		int minVal = root.key;
		while (root.left != null) {
			minVal = root.left.key;
			root = root.left;
		}
		return minVal;
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
	
	
	/** Method to search for a node */
	public boolean search(Node root, int key) {
		
		// Base Case - when the key is found, or if the root is null
		if (root == null) {
			return false;
		} else if (root.key == key) {
			return true;
		}
		
		if (root.key > key) {
			return search(root.left, key);
		}
		return search(root.right, key);	
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
	
	
	
	// Added for final exam
	public static int countNumLeaves(Node root) {
		if (root == null) {
			return 0;
		}
		
		if (root.left == null && root.right == null) {
			return 1;
		} else {
			return countNumLeaves(root.left) + countNumLeaves(root.right);
		}
	}
	
	
	// Added for final exam
	public static Node findSuccessor(Node currentNode) {
		
		// Base case - if the root is null, there is no successor
		if (currentNode == null) {
			return null;
		}
		
		currentNode = currentNode.right;
		
		while (currentNode.left != null) {
			currentNode = currentNode.left;
		}
		return currentNode;
	}
	
	
	// Added for final exam
	static int count = 0;
	public static int checkOddNode(Node root) {
		if (root == null) {
			return 0;
		} else {
	    	checkOddNode(root.left);
	 
	        // if node is odd then print it
	        if (root.key % 2 == 1)
	            count++;
	 
	        checkOddNode(root.right);
	    }
		
		return count;
		
		
	}
	
	/** Main Method */
	public static void main(String[] args) {
		// Create a BST object empty tree
		BinarySearchTree bst = new BinarySearchTree();
		
		// Insert elements
		bst.insertCaller(3);
		bst.insertCaller(8);
		bst.insertCaller(1);
		bst.insertCaller(4);
		bst.insertCaller(6);
		bst.insertCaller(2);
		bst.insertCaller(10);
		bst.insertCaller(9);
		bst.insertCaller(20);
		bst.insertCaller(25);
		bst.insertCaller(15);
		bst.insertCaller(16);
		
		// Display elements in increasing order
		bst.inOrder(bst.root);
		
		// Search for node value 4
		System.out.println("\n\nSearching for the value 4... The value exists: " + bst.search(bst.root, 4));
		bst.search(bst.root, 4);
		
		// Delete node 2 (no children)
		System.out.println("\nDelete node 2 (leaf node): ");
		bst.delete(bst.root, 2);
		bst.inOrder(bst.root);
		
		// Delete node 4 (one child)
		System.out.println("\n\nDelete node 4 (one child): ");
		bst.delete(bst.root, 4);
		bst.inOrder(bst.root);
		
		// Delete node 10 (two children)
		System.out.println("\n\nDelete node 10 (two children): ");
		bst.delete(bst.root, 10);
		bst.inOrder(bst.root);

//		System.out.println("\n" + bst.countNumLeaves(bst.root));
//		System.out.println(bst.findSuccessor(bst.root.right).key);
		System.out.println(bst.checkOddNode(bst.root));
	}

}
