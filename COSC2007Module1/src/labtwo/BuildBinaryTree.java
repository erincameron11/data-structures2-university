package labtwo;

public class BuildBinaryTree {

	Node root;
	static int preOrderIndex = 0;
	
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
	
	
	/** Method to build a binary tree - returns a Node - count starts at 0 */
	public Node buildTree(int[] inArray, int[] preArray, int start, int finish) {
		
		// Base Case - when the start is greater than the finish
		if (start > finish) {
			return null;
		}
		
		// Pick an element from pre-order array and increment the index value
		int index = preArray[preOrderIndex];
		preOrderIndex++;
		
		// Create a new node
		Node temp = new Node(index);
		
		// If there is nothing in the array, just return the temp node
		if (start == finish) {
			return temp;
		}
		
		// Find the picked element's index in inArray and assign to a variable
		int inIndex = 0;
		for (int i = start; i <= finish; i++) {
            if (inArray[i] == temp.data)
                inIndex = i;  // This will locate the element each recursive call
        }
		
		// Recursively call the left and right subtree's of the binary tree
		// The inIndex - 1 will traverse in the left direction of the array
		// The inIndex + 1 will traverse in the right direction of the array
		temp.left = buildTree(inArray, preArray, start, inIndex - 1);
		temp.right = buildTree(inArray, preArray, inIndex + 1, finish);

		return temp;
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
	
	
	/** Main Method */
	public static void main(String[] args) {
		
		int[] preArray = {1, 2, 4, 8, 9, 5, 10, 11, 3, 6, 12, 13, 7, 14, 15};
		int[] inArray = {8, 4, 9, 2, 10, 5, 11, 1, 12, 6, 13, 3, 14, 7, 15};
		
		BuildBinaryTree tree = new BuildBinaryTree();
		Node root = tree.buildTree(inArray, preArray, 0, inArray.length - 1);

		// Display the tree in post-order format
        System.out.println("The tree has been constructed, and Post-Order it is: ");
        tree.postOrder(root);
		
	}

}
