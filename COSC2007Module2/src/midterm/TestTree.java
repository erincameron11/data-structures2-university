package midterm;

public class TestTree {


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
	public TestTree() {
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

	/** Method to print the data out in pre-order format (ROOT - LEFT - RIGHT) */
	public void preOrder(Node root) {
		
		// Recursively call the root, then left, then right
		if (root != null) {  // If the tree isn't empty
			System.out.print(root.key + " ");
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
			System.out.print(root.key + " ");
		}
		
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
	    System.out.print(root.key + "\n");
	 
	    // Process left child
	    print2DUtil(root.left, space);
	}
	 
	// Wrapper over print2DUtil()
	static void print2D(Node root)
	{
	    // Pass initial space count as 0
	    print2DUtil(root, 0);
	}
	
	
	
//	public String traversePreOrder(Node root) {
//
//	    if (root == null) {
//	        return "";
//	    }
//
//	    StringBuilder sb = new StringBuilder();
//	    sb.append(root.key);
//
//	    String pointerRight = "└──";
//	    String pointerLeft = (root.right != null) ? "├──" : "└──";
//
//	    traverseNodes(sb, "", pointerLeft, root.left, root.right != null);
//	    traverseNodes(sb, "", pointerRight, root.right, false);
//
//	    return sb.toString();
//	}
//	
//	
//	public void traverseNodes(StringBuilder sb, String padding, String pointer, Node node, 
//			  boolean hasRightSibling) {
//			    if (node != null) {
//			        sb.append("\n");
//			        sb.append(padding);
//			        sb.append(pointer);
//			        sb.append(node.key);
//
//			        StringBuilder paddingBuilder = new StringBuilder(padding);
//			        if (hasRightSibling) {
//			            paddingBuilder.append("│  ");
//			        } else {
//			            paddingBuilder.append("   ");
//			        }
//
//			        String paddingForBoth = paddingBuilder.toString();
//			        String pointerRight = "└──";
//			        String pointerLeft = (node.right != null) ? "├──" : "└──";
//
//			        traverseNodes(sb, paddingForBoth, pointerLeft, node.left, node.right != null);
//			        traverseNodes(sb, paddingForBoth, pointerRight, node.right, false);
//			    }
//			}
	
	
	
	/** Main Method */
	public static void main(String[] args) {
		// Create a BST object empty tree
		TestTree tree = new TestTree();
		
		// Create array of elements to insert
//		int[] array = {15, 10, 8, 12, 20, 16, 25};  // Pre-Order
//		int[] array = {8, 10, 12, 15, 16, 20, 25};  // In-Order
//		int[] array = {8, 12, 10, 16, 25, 20, 15};  // Post-Order
		
		
//		int[] array = {8, 15, 11, 17, 18, 22};
		
//		int[] array = {8, 10, 6, 25, 12, 16, 23};
		
		int[] array = {25, 15, 10, 4, 12, 22, 50, 35, 70};
		
		// Insert elements into the BST
		for (int i = 0; i < array.length; i++) {
			tree.insertCaller(array[i]);
		}
		
		// Display
//		tree.print2D(tree.root);
		System.out.print("Pre-Order: ");
		tree.preOrder(tree.root);
		System.out.print("\nIn-Order: ");
		tree.inOrder(tree.root);
		System.out.print("\nPost-Order: ");
		tree.postOrder(tree.root);
		
		
		tree.print2D(tree.root);
		
//		System.out.println();
//		
//		tree.delete(tree.root, 8);
//		
//		tree.print2D(tree.root);
	}
	
}
