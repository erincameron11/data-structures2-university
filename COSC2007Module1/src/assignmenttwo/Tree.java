/** 
 * Java Class to accept filenames until sentinel value entered, read in data, and create a BST from characters' ASCII value in the file
 * Has the ability to insert, delete, search, find max value, find min value, find height of specified node, and print in various formats
 * */

package assignmenttwo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Tree {
	
	/** Inner Node class */
	public class TreeNode {
		private int key;
		private int count;
		private TreeNode left, right;
		
		// 1-arg Constructor
		TreeNode(int ch) {
			// Make sure the character is in lowercase format
			key = java.lang.Character.toLowerCase(ch);
			count = 1;
			left = null;
			right = null;
		}
	}
	
	// Create a root treenode
	TreeNode root;
	
	
	/** Method to read the text file into the program to insert values in the BST */
	public void readFile(Tree tree, TreeNode root, String fileName) {
		// Try with resources to read the file
		try (Scanner input = new Scanner(new File(fileName))) {
			while (input.hasNext()) {
				// Convert each key to lowercase before storing in BST
				// Then convert to integer ASCII value
				char ch = input.next().charAt(0);
				ch = java.lang.Character.toLowerCase(ch);
				
				tree.insertCaller((int)ch);
			}
		} 
		catch (FileNotFoundException ex) {
	    	System.out.println("File not found.");
		}  
	}
	
	
	/** Method to call the recursive insert method */
	public void insertCaller(int key) {
		root = insert(root, key);
	}
	
	
	/** ------ Method for inserting into the BST ------ 
	 * Insert based on ASCII value of lowercase character
	 * When item added for first time, count is increased to 1
	 * When inserting duplicate characters, just increase the count
	 */
	public TreeNode insert(TreeNode root, int key) {
		
		// Base Case - if the tree is empty
		if (root == null) {
			root = new TreeNode(key);
			return root;
		}
		
		// If the key is already in the tree, just increase the count
		if (key == root.key) {
			root.count++;
		}
		
		if (key > root.key) {  // Then the value is greater than and you traverse the right side of tree
			root.right = insert(root.right, key);
		} else if (key < root.key) {  // Then the value is less than and you traverse the left side of tree
			root.left = insert(root.left, key);
		}
		
		return root;
	}
	
	
	/** ------ Method for searching the BST ------
	 * Recursive function that looks for specified character and returns a pointer node, or null if not found
	 */
	public TreeNode search(TreeNode root, int key) {
		// Base Case - when the key is found, or if the root is null
		if (root == null) {
			return root;
		} else if (root.key == key) {
			return root;
		}
		
		if (root.key > key) {
			return search(root.left, key);
		}
		return search(root.right, key);
	}
	
	
	/** ------ Method to find the minimum value in the BST ------
	 * Search based on the ASCII value of lowercase characters
	 * Returns the smallest character in the BST
	 */
	public TreeNode findMin(TreeNode root) {
		TreeNode temp = root;
		 
		// Base Case - when the next leftmost item in the BST is null
		if (temp.left == null) {
			return temp;
		}
		return findMin(temp.left);	
	}
	
	
	/** ------ Method to find the maximum value in the BST ------
	 * Search based on the ASCII value of lowercase characters
	 * Returns the largest character in the BST
	 */
	public TreeNode findMax(TreeNode root) {
		TreeNode temp = root;
		 
		// Base Case - when the next rightmost item in the BST is null
		if (temp.right == null) {
			return temp;
		}
		return findMax(temp.right);
	}
	
	
	/** ------ Method to find the height of a specified subtree ------
	 * Computes and returns the maximum height of a particular subtree recursively
	 * Use a pointer node as the root to calculate the height
	 * Start is the character node to begin at
	 */	
	public int height(TreeNode pointer){
        // Base Case - when the pointer is null, the height is 0
        if (pointer == null) {
            return 0;
        }

        // Recursive call to either the left or right side of the tree
       if (height(pointer.left) >= height(pointer.right)) {
    	   return height(pointer.left) + 1;
      
       } else {
    	   return height(pointer.right) + 1;
       }  
	}
	
	
	
	/** ------ Method to remove a specified node from the tree ------
	 * If removing a node with count > 1, just decrement the count
	 */
	public TreeNode remove(TreeNode root, int key) {
		// Base Case - if the tree is empty just return the root
		if (root == null) {
			return root;
		}
		
		// If the root.key is the key (if the value is found in the tree and the count is greater than 1)
		// just decrement the count of the node instead of removing the node altogether
		if (root.key == key && root.count > 1) {
			root.count--;
			return root;
		}
				
		// Check the key against each node value, until the correct one is found
		if (key > root.key) {  // Then the value is greater than and you traverse the right side of tree
			root.right = remove(root.right, key);
		} else if (key < root.key) {  // Then the value is less than and you traverse the left side of tree
			root.left = remove(root.left, key);
		} else {
					
		// Handle the case where a node has only one child
		if (root.left == null) {
			return root.right;
		} else if (root.right == null) {
			return root.left;
		}
					
		// Handle the case where a node has two children
		root.key = minVal(root.right);
					
		root.right = remove(root.right, root.key);
		}
		return root;
	}
	
	
	/** Method to calculate the minimum value of a root node */
	public int minVal(TreeNode root) {
		int minVal = root.key;
		while (root.left != null) {
			minVal = root.left.key;
			root = root.left;
		}
		return minVal;
	}
	
	
	
	/** ------ Method to print the BST ------
	 * Recursively print: inOrder, preOrder, postOrder BST
	 * Print in the format character(count): c(2)
	 */
	public void print(Tree tree) {
		System.out.print("In-Order: ");
		tree.inOrder(tree.root);
		System.out.print("\nPre-Order: ");
		tree.preOrder(tree.root);
		System.out.print("\nPost-Order: ");
		tree.postOrder(tree.root);
	}
	
	
	/** Method to print the data out in in-order format (LEFT - ROOT - RIGHT) */
	public void inOrder(TreeNode root) {
		// Recursively call left and right with root data in the middle
		if (root != null) {  // If the tree isn't empty
			inOrder(root.left);
			System.out.print((char)root.key);
			System.out.print("(" + root.count + ") ");
			inOrder(root.right);
		}
	}
	
	
	/** Method to print the data out in pre-order format (ROOT - LEFT - RIGHT) */
	public void preOrder(TreeNode root) {
		// Recursively call the root, then left, then right
		if (root != null) {  // If the tree isn't empty
			System.out.print((char)root.key);
			System.out.print("(" + root.count + ") ");
			preOrder(root.left);
			preOrder(root.right);
		}	
	}
	
	/** Method to print the data out in post-order format (LEFT - RIGHT - ROOT) */
	public void postOrder(TreeNode root) {
		// Recursively call the left, then root, then right
		if (root != null) {  // If the tree isn't empty
			postOrder(root.left);
			postOrder(root.right);
			System.out.print((char)root.key);
			System.out.print("(" + root.count + ") ");
		}
	}
	
	
	/** Main Method */
	public static void main(String[] args) {
		// Create a Scanner
		Scanner input = new Scanner(System.in);
		
		// Create a BST object
		Tree tree = new Tree();
		
		// Prompt the user for the name of a file
		int sentinel = -1;
		String next = "";
		System.out.println("Enter a file name with correct file path, or 'q' to stop: ");  // MUST have file in src/ folder, or enter correct path
		
        while (sentinel != 0) {
            next = input.next();
            
            // If the sentinel value is entered, stop processing information from files
            if (next.length() == 1 && next.charAt(0) == (int)'q') {
            	sentinel = 0;
            } else {
            	// Open the file on disk and process into the BST (insert)
            	tree.readFile(tree, tree.root, "src/" + next);
            }
        }
		
		// Print the BST out
		tree.print(tree);
		
		// Print the minimum and maximum character
		TreeNode min = tree.findMin(tree.root);
		System.out.println("\n\nThe minimum character is: " + (char)min.key);
		TreeNode max = tree.findMax(tree.root);
		System.out.println("The maximum character is: " + (char)max.key);
		
	
		// Prompt the user for a character to search
		System.out.println("\nEnter a character to search for in the BST: ");
		String str = input.next();
		char ch = str.charAt(0);  // Convert the string into a character value
		
		// Search for that character
		if (tree.search(tree.root, (int)ch) == null) {
			System.out.println("The character '" + ch + "' is not in the BST.");
		} else {
			System.out.println("The character '" + ch + "' is in the BST");
			tree.search(tree.root, (int)ch);
		}

		// Print out the height of a specified node
        System.out.println("\nEnter a node character to check the height of: ");
        char heightChar = input.next().charAt(0);
        System.out.println("\nThe height of node '" + heightChar + "' is: " + tree.height(tree.search(tree.root, (int)heightChar)));
		
		// Prompt the user for a value to remove from the BST
		System.out.println("\nEnter a character to remove from the BST: ");
		String rem = input.next();
		char remove = rem.charAt(0);  // Convert the string into a character value
		tree.remove(tree.root, (int)remove);
		System.out.println();  // Formatting
		
		// Print the BST
		tree.print(tree);
        
		// Close the input
		input.close();
		
	}
	
	
}
