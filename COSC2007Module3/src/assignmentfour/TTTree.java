package assignmentfour;

import java.util.Scanner;

public class TTTree {

	/** Inner Node Class */
	private class Node {
		private String small;
		private String large;
		private Node left;
		private Node middle;
		private Node right;

		// No-arg constructor to initialize all values to null
		private Node() {
			left = null;
			middle = null;
			right = null;
			small = null;
			large = null;
		}

		// 2-arg constructor to initialize the small and large values
		private Node(String small, String large) {
			this.small = small;
			this.large = large;
			left = null;
			middle = null;
			right = null;
		}

		// 3-arg constructor used to initialize a 1-item node
		private Node(String small, Node left, Node middle) {
			this.small = small;
			this.left = left;
			this.middle = middle;
		}

		// Setter for small dvd item
		private void setSmall(String dvd) {
			this.small = dvd;
		}

		// Getter for small dvd item
		private String getSmall() {
			return small;
		}

		// Setter for large dvd item
		private void setLarge(String dvd) {
			this.large = dvd;
		}

		// Getter for large dvd item
		private String getLarge() {
			return large;
		}

		// Setter for left child
		private void setLeft(Node node) {
			this.left = node;
		}

		// Getter for left child
		private Node getLeft() {
			return left;
		}

		// Setter for middle child
		private void setMiddle(Node node) {
			this.middle = node;
		}

		// Getter for middle child
		private Node getMiddle() {
			return middle;
		}

		// Setter for right child
		private void setRight(Node node) {
			this.right = node;
		}

		// Getter for right child
		private Node getRight() {
			return right;
		}

		/**
		 * Method to check whether a node is a leaf or not
		 * @return returns a boolean value
		 */
		private boolean isLeaf() {
			return ((left == null) && (middle == null) && (right == null));
		}

		/**
		 * Method to check whether a node has 2 children or not
		 * @return returns a boolean value
		 */
		private boolean has2Children() {
			return (getLarge() == null);
		}

		/**
		 * Method to check whether a node has 3 children or not
		 * @return returns a boolean value
		 */
		private boolean has3Children() {
			return (getLarge() != null);
		}

	}

	// Initialize variables
	private Node root;

	
	/**
	 * Method to check if the 2-3 tree is empty or not
	 * @return returns a boolean value
	 */
	public boolean isEmpty() {
		if (root == null) {
			return true;
		} else {
			return false;
		}
	}

	
	/**
	 * Method to check whether a dvd title already exists in the tree
	 * @param node
	 * @param dvd
	 * @return
	 */
	public boolean alreadyExists(Node node, String dvd) {
		return (node.getSmall().compareTo(dvd) == 0 || (node.has3Children() && node.getLarge().compareTo(dvd) == 0));
	}

	
	/**
	 * Method to check whether to branch right
	 * @param node
	 * @param dvd
	 * @return
	 */
	public static boolean goRight(Node node, String dvd) {
		return (node.getLarge().compareTo(dvd) < 0);
	}

	
	/**
	 * Method to check whether to branch left
	 * @param node
	 * @param dvd
	 * @return
	 */
	public static boolean goLeft(Node node, String dvd) {
		return (node.getSmall().compareTo(dvd) > 0);
	}

	
	/**
	 * Method to check whether to branch to the middle
	 * @param node
	 * @param dvd
	 * @return
	 */
	public static boolean goMiddle(Node node, String dvd) {
		return (node.getLarge().compareTo(dvd) > 0);
	}

	
	/**
	 * Method to call the recursive insert method
	 * @param accepts a string with a DVD title
	 */
	public void insertHelper(String dvd) {

		// Base Case - stops the recursion if the root is null or the small element in the root is missing (no data items)
		if (isEmpty()) {
			// Since isEmpty() also checks if the small item is empty, check if root is null
			if (root == null) {
				root = new Node();
			}
			root.setSmall(dvd);

		// Else, insert the root and value into the tree
		} else {
			Node root2 = insert(root, dvd);

			if (root2 != null) {
				root = root2;
			}
		}
	}
	

	/**
	 * Method to recursively insert a node with a DVD title
	 * @param accepts a string with a DVD title
	 */
	private Node insert(Node node, String dvd) {
		Node newNode = null;

		// Base Case - for the recursion - if we have traversed to the leaf node for insertion there are 3 cases
		if (node.isLeaf()) {

			// CASE 1: DUPLICATE If the item already exists in the tree, do nothing
			if (alreadyExists(node, dvd)) {
				// Do nothing

				// CASE 2: If there is only 1 data item present before insertion
			} else if (node.has2Children()) {
				// Determine what data slot to place the dvd title
				if (goLeft(node, dvd)) {
					node.setLarge(node.getSmall());
					node.setSmall(dvd);
				} else if (!goLeft(node, dvd)) {
					node.setLarge(dvd);
				}

				// CASE 3: If there are 2 data items present and we need to insert another, split
			} else if (node.has3Children()) {
				newNode = split(node, dvd);
			}

			// RECURSIVE PART: If we have not yet reached the leaf node to insert at, recurse!
		} else {
			Node moveUp = null;

			// LEFT -- The dvd title is smaller than the current small item
			if (goLeft(node, dvd)) {
				moveUp = insert(node.getLeft(), dvd);
				if (moveUp != null && node.has2Children()) {
					node.setLarge(node.getSmall());
					node.setSmall(moveUp.getSmall());
					node.setRight(node.getMiddle());
					node.setMiddle(moveUp.getMiddle());
					node.setLeft(moveUp.getLeft());

				}

				// MIDDLE: The dvd title is greater than the small data item, but smaller than the large data item
			} else if (node.has2Children() || (node.has3Children() && goMiddle(node, dvd))) {
				moveUp = insert(node.getMiddle(), dvd);
				if (moveUp != null && node.has2Children()) {
					node.setLarge(moveUp.getSmall());
					node.setRight(moveUp.getMiddle());
					node.setMiddle(moveUp.getLeft());
				} else if (moveUp != null & !node.has2Children()) {
					Node left = new Node(node.getSmall(), node.getLeft(), moveUp.getLeft());
					Node mid = new Node(node.getLarge(), moveUp.getMiddle(), node.getRight());
					newNode = new Node(moveUp.getSmall(), left, mid);
				}

				// RIGHT: The dvd title is greater than the large data item
			} else if (node.has3Children() && goRight(node, dvd)) {
				moveUp = insert(node.getRight(), dvd);
				if (moveUp != null) { // Split and the right element is pushed up
					Node left = new Node(node.getSmall(), node.getLeft(), node.getMiddle());
					newNode = new Node(node.getLarge(), left, moveUp);
				}
			}
		}
		return newNode;
	}
	

	/**
	 * Method to split a node to the left, middle, or right
	 * @param accepts a node
	 * @param accepts a string with dvd title
	 * @return returns a Node
	 */
	private Node split(Node node, String dvd) {

		// CASE LEFT: If the small data item is greater than the new dvd title
		if (goLeft(node, dvd)) {
			Node lChild = new Node(dvd, null);
			Node rChild = new Node(node.getLarge(), null);
			Node newNode = new Node(node.getSmall(), lChild, rChild);
			node = newNode;

		// CASE MIDDLE: Else If the small data item is less than the new dvd title, and the large item is greater than the new dvd title
		} else if (goMiddle(node, dvd) && node.getSmall().compareTo(dvd) < 0) {
			Node lChild = new Node(node.getSmall(), null);
			Node rChild = new Node(node.getLarge(), null);
			Node newNode = new Node(dvd, lChild, rChild);
			node = newNode;
			
		// CASE RIGHT: Else if the new dvd title is greater than both data items
		} else if (goRight(node, dvd)) {
			Node lChild = new Node(node.getSmall(), null);
			Node rChild = new Node(dvd, null);
			Node newNode = new Node(node.getLarge(), lChild, rChild);
			node = newNode;
		}
		// Return the node with the correct split
		return node;
	}
	
	
	/**
	 * Method searches for a specified String dvd title
	 * @param accepts a String value for a dvd title
	 * @return returns a pointer to a Node if the item exists, or null if it does not exist in the 2-3 tree
	 */
	public Node search(Node node, String dvd) {
		if (node != null) {
			// Base Case - if the node data == the dvd string return the node
			if (node.getSmall() == dvd || node.getLarge() == dvd) {
				return node;

			// Base Case - Else if the node is a leaf return null - failure case
			} else if (node.getLeft() == null && node.getMiddle() == null && node.getRight() == null) {
				return null;
			}

			// Search subtrees
			// If the node has two data items
			if (node.getSmall() != null && node.getLarge() != null) {

				// If the specified string is less than the smaller search key of the root node
				if (goLeft(node, dvd)) {
					search(node.getLeft(), dvd);

				// Else if the specified string is less than the larger search key of the root node
				} else if (goMiddle(node, dvd)) {
					search(node.getMiddle(), dvd);

				// Else search the right branch of the node
				} else if (goRight(node, dvd)) {
					search(node.getRight(), dvd);
				}

			// If the node has one data item - search either left or middle children
			} else {
				if (node.getSmall().compareTo(dvd) > 0) {
					search(node.getLeft(), dvd);
				} else {
					search(node.getMiddle(), dvd);
				}
			}
		}
		return node;
	}
	
	
	/**
	 * Method to traverse the 2-3 tree in sorted search-key order (LEFT - ROOT - RIGHT)
	 * @param accepts a Node root value
	 */
	private void inOrder(Node node) {
		if (!isEmpty() && node != null) {

			// Base Case - If node is a leaf node print small and large values (if it exists)
			if (node.isLeaf()) {
				System.out.print(node.getSmall() + ", ");
				if (node.getLarge() != null) {
					System.out.print(node.getLarge() + ", ");
				}

			// Recurse if the node isn't a leaf yet (LEFT - ROOT - RIGHT)
			} else {
				inOrder(node.getLeft());
				System.out.print(node.getSmall() + ", ");
				inOrder(node.getMiddle());

				if (node.getLarge() != null) {
					System.out.print(node.getLarge() + ", ");
				}
				inOrder(node.getRight());

			}
		}
	}
	

	/**
	 * Method to traverse the tree in pre-Order format (ROOT - LEFT - RIGHT)
	 * @param accepts a Node root value
	 */
	private void preOrder(Node node) {
		if (!isEmpty()) {
			if (node != null) {
				System.out.print(node.getSmall() + ", ");
				preOrder(node.getLeft());
				preOrder(node.getMiddle());

				// If there is a large value then print it, and recurse down the right branch only if the large value exists
				if (node.getLarge() != null) {
					System.out.print(node.getLarge() + ", ");
					preOrder(node.getRight());
				}
			}
		}
	}

	
	/** Main Method */
	public static void main(String[] args) {
		// Create a Scanner
		Scanner input = new Scanner(System.in);

		TTTree tree = new TTTree();

		// Prompt the user to enter DVD titles and input them into the tree
		System.out.println("Enter DVD titles to add to the 2-3 tree. Separate each title by pressing 'ENTER'. When finished, press 'q' and 'ENTER': ");
		int sentinel = -1;

		while (sentinel != 0) {
			String next = input.nextLine();

			// If the sentinel value is entered, stop processing information
			if (next.length() == 1 && next.charAt(0) == (int) 'q') {
				sentinel = 0;
			} else {
				// Insert each sentence into the 2-3 tree
				tree.insertHelper(next);
			}
		}

		// Prompt the user to search for a DVD
		System.out.println("Enter a DVD title you want to search for: ");
		String userDVD = input.nextLine();
		Node test = tree.search(tree.root, userDVD);
		System.out.println("Searching for '" + userDVD + "' in the database. The node position is: " + test + "\n");

		// Display all DVDs in the 2-3 tree
		System.out.print("Pre-Order: ");
		tree.preOrder(tree.root);
		System.out.print("\nIn-Order: ");
		tree.inOrder(tree.root);

		// Close the input
		input.close();
	}
}