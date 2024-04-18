// https://www.geeksforgeeks.org/avl-tree-set-2-deletion/
package labeight;

/** External Node Class */
class Node {
	int key;
	int height;
    Node left;
    Node right;
 
    Node(int key) {
        this.key = key;
        height = 1;  // Set the height to 1 since we are adding one node
    }
}


public class AVLTreeDelete {
	
	// Initialize a Node variable
	public static Node root;
	
	
	/** Method to return the height of a node 
	 * @param accepts a root node 
	 * @return an integer value of the height of the tree/subtree */
	public static int getHeight(Node root) {
		
		// If the root is empty, then the height is zero, otherwise just return the height data element of the node
		if (root == null) {
			return 0;
		} else {
			return root.height;
		}
	}
	
	
	/** Method to calculate the balance factor of a given subtree/tree 
	 * @param accepts a node 
	 * @return an integer result for the balance factor */
	public static int getBalance(Node node) {
		if (node == null) {
			return 0;
		} else {
			int left = getHeight(node.left);
			int right = getHeight(node.right);
			return (left - right);
		}
	}
	
	
	/** Method to determine the maximum value of 2 integers 
	 * @param accepts two integer values to compare */
    public static int max(int first, int second) {
    	// If, else, to return the greater of the two integer elements provided
    	if (first > second) {
    		return first;
    	} else {
    		return second;
    	}
    }
	
    
    /** Method to insert a node into the tree 
     * Re-balances the tree as necessary */
	public static Node insert(Node node, int key) {
		
		// If the node to be inserted is null, create a new node
		if (node == null) {
			Node temp = new Node(key);
			return temp;
		} 
		
		// Determine where to insert the new key
		// Right insert
		if (key > node.key) {
			node.right = insert(node.right, key);
		
		// Left insert
		} else if (key < node.key) {
			node.left = insert(node.left, key);
		
		// For duplicate keys, just return the node, since we don't want duplicates
		} else if (key == node.key) {
			return node;
		}
		
		// Increase the height of the node inserted
		int ht = max(getHeight(node.left), getHeight(node.right)) + 1;  // Increase it by 1
		node.height = ht;
		
		// Determine if the tree is balanced or not, and progress accordingly
		// Case 1: LEFT RIGHT
		if (getBalance(node) > 1 && key > node.left.key) {
			node.left = rotateLeft(node.left);
			return rotateRight(node);
		}
		
		// Case 2: RIGHT LEFT
		if (getBalance(node) < -1 && key < node.right.key) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }
		
		// Case 3: LEFT LEFT
        if (getBalance(node) > 1 && key < node.left.key) {
            return rotateRight(node);
        }
		
        // Case 4: RIGHT RIGHT
        if (getBalance(node) < -1 && key > node.right.key) {
            return rotateLeft(node);
        }
		
		return node;
	}
    
    
	/** Method to rotate the tree right */
	public static Node rotateRight(Node node) {
		// Store the left and right subtrees of the current node
		Node tempL = node.left;
		Node tempR = tempL.right;
		
		// Rotate the nodes
		tempL.right = node;
		node.left = tempR;
		
		node.height = max(getHeight(node.left), getHeight(node.right)) + 1;
		tempL.height = max(getHeight(tempL.left), getHeight(tempL.right)) + 1;
		
		
		return tempL;
	}
	
	
	/** Method to rotate the tree left */
	public static Node rotateLeft(Node node) {
		// Store the left and right subtrees of the current node
		Node tempR = node.right;
		Node tempL = tempR.left;
		
		// Rotate the nodes
		tempR.left = node;
		node.right = tempL;
		
		node.height = max(getHeight(node.left), getHeight(node.right)) + 1;
		tempR.height = max(getHeight(tempR.left), getHeight(tempR.right)) + 1;
		
		
		return tempR;
	}
	
	
	/** Method to delete a node from the tree */
	public static Node delete(Node node, int key) {
		
		// If empty
		if (root == null) {
			return root;
		}
		
		
		// Locate the node to be deleted
		// If less than the key value specified check left subtree
		if (node.key > key) {
			node.left = delete(node.left, key);
		
		// If more than the key value specified, check right subtree
		} else if (node.key < key) {
			node.right = delete(node.right, key);
			
		// If equal to the key value, then we have located the node to delete
		} else {
			// Case 1: Deletion with No children, or only 1 child
			if (node.left == null || node.right == null) {
				Node temp;
				
				if (node.left == null) {
					temp = node.right;
					node = temp;  // Make the node the temp
				} else {
					temp = node.left;
					node = temp;  // Make the node the temp
				}
				
				// No children
				// If we go through the above two if/else and temp is still null, then...
				if (temp == null) {
					temp = node;
					node = null;  // Delete the node by setting to null
				}
				
			// Case 2: Deletion with Two children
			} else {
				// Locate the inorder successor
				Node curr = node;
		        while (curr.left != null) {
		        	curr = curr.left;
		        }
				node.key = curr.key;
				node.right = delete(node.right, curr.key);  // Delete the inorder successor
			}
			
		}
		
		// If the tree originally had only 1 node, then the tree is now empty
		if (node == null) {
			return node;
		}
		
		// After, update the height and check balance factor again
		node.height = max(getHeight(node.right), getHeight(node.left)) + 1;
		
		// CASE 1: Left Left
		if (getBalance(root.left) >= 0 && getBalance(node) > 1) {
			return rotateRight(node);
		}
		
		// CASE 2: Left Right
		if (getBalance(node.left) < 0 && getBalance(node) > 1) {
			node.left = rotateLeft(node.left);
			return rotateRight(node);
		}
		
		// CASE 3: Right Right
		if (getBalance(node.right) <= 0 && getBalance(node) < -1) {
			return rotateLeft(node);
		}
		
		// CASE 4: Right Left
		if (getBalance(node.right) > 0 && getBalance(node) < -1) {
			node.right = rotateRight(node.right);
			return rotateLeft(node);
		}
		
		return node;
	}
	
	
	
    
    /** Method to print the data out in pre-order format (ROOT - LEFT - RIGHT) 
     * @param accepts a node root element */
	public static void preOrder(Node root) {
		// Recursively call the root, then left, then right
		if (root != null) {  // If the tree isn't empty
			System.out.print(root.key + " ");
			preOrder(root.left);
			preOrder(root.right);
		}
	}
	
	
	/** Method to print the data out in in-order format (LEFT - ROOT - RIGHT) 
	 * @param accepts a node root element */
	public static void inOrder(Node root) {
		// Recursively call left and right with root data in the middle
		if (root != null) {  // If the tree isn't empty
			inOrder(root.left);
			System.out.print(root.key + " ");
			inOrder(root.right);
		}
	}
	
	
	/** Method to print the data out in post-order format (LEFT - RIGHT - ROOT) 
	 *  @param accepts a node root element */
	public static void postOrder(Node root) {
		// Recursively call the left, then root, then right
		if (root != null) {  // If the tree isn't empty
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(root.key + " ");
		}
	}
	
	
	/** Main Method */
	public static void main(String[] args) {
		
		AVLTreeDelete.root = AVLTreeDelete.insert(AVLTreeDelete.root, 10);
		AVLTreeDelete.root = AVLTreeDelete.insert(AVLTreeDelete.root, 20);
		AVLTreeDelete.root = AVLTreeDelete.insert(AVLTreeDelete.root, 30);
		AVLTreeDelete.root = AVLTreeDelete.insert(AVLTreeDelete.root, 40);
		AVLTreeDelete.root = AVLTreeDelete.insert(AVLTreeDelete.root, 50);
		AVLTreeDelete.root = AVLTreeDelete.insert(AVLTreeDelete.root, 25);
		
		System.out.print("AVL Tree pre-order: ");
		AVLTreeDelete.preOrder(AVLTreeDelete.root);

		System.out.print("\nAVL Tree in-order: ");
		AVLTreeDelete.inOrder(AVLTreeDelete.root);
		
		System.out.print("\nAVL Tree post-order: ");
		AVLTreeDelete.postOrder(AVLTreeDelete.root);
		
		System.out.print("\n\nAVL Tree pre-order AFTER deletion of node 40 is: ");
		AVLTreeDelete.delete(root, 40);
		AVLTreeDelete.preOrder(AVLTreeDelete.root);
		
	}

}
