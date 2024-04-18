package assignmentfourjunkyard;

import java.util.Scanner;

/** External Node Class */
class Node {
	private String small;
	private String large;
	Node temp;
	Node left;
	Node middle;
	Node right;
	Node parent;
	
	// No-arg constructor sets everything to null
	public Node() {
		left = middle = right = null;
	}
	
	// 2-arg Constructor that sets 1 data value in the node, and sets this node's parent to the current node
	public Node(String small) {
//		this.parent = parent;
		this.small = small;
//		this.parent = parent;
	}
	
	// 2-arg Constructor that sets both data values in the node
	public Node(String small, String large, Node parent) {
		this.small = small;
		this.large = large;
//		this.parent = parent;
	}
	
	// Getter for small
	public String getSmall() {
		return small;
	}
	
	// Setter for small
	public void setSmall(String small) {
		this.small = small;
	}
	
	// Getter for large
	public String getLarge() {
		return large;
	}
	
	// Setter for large
	public void setLarge(String large) {
		this.large = large;
	}
	
	// Getter for parent
	public Node getParent() {
		return parent;
	}
	
	// Setter for parent
	public void setParent(Node parent) {
		this.parent = parent;
	}

	// Getter for temp
	public Node getTemp() {
		return temp;
	}

	// Setter for temp
	public void setTemp(Node temp) {
		this.temp = temp;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getMiddle() {
		return middle;
	}

	public void setMiddle(Node middle) {
		this.middle = middle;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}
	
	public boolean isLeaf(Node node) {
		return (node.left == null && node.right == null && node.middle == null);
	}
	
	
	
}




public class TTTree {
	
	// Initialize a Node root variable
	Node root;
	
//	public boolean isEmpty() {
//		return (root.left == null && root.middle == null && root.right == null);
//	}
	
	/** Method to traverse the tree in sorted search-key order (LEFT - ROOT - RIGHT)
	 * @param accepts a Node root value */
	public static void inOrder(Node node) {
		// If the tree node is a leaf
		if (node.getRight() == null && node.getMiddle() == null && node.getLeft() == null) {
			
			// If both data items exist, print both
			if (node.getSmall() != null && node.getLarge() != null) {
				System.out.print(node.getSmall() + ", " + node.getLarge() + ", ");
			// Else, print only the small data item
			} else {
				System.out.print(node.getSmall() + ", ");
			}
		
		// Else if the root has two data items (neither are null) - recursively call the method
		} else if (node.getSmall() != null && node.getLarge() != null) {
			inOrder(node.getLeft());
			inOrder(node.getMiddle());
			inOrder(node.getRight());
		
		// Else, there is only one data item present - recursively call the method
		} else {
			inOrder(node.getLeft());
			inOrder(node.getMiddle());
		}	
	}
	
	
	// ---------------------NEED TO FIX
	/** Method to traverse the tree in pre-Order format (ROOT - LEFT - RIGHT)
	 * @param accepts a Node root value */
	public static void preOrder(Node node) {
		// If the tree node is a leaf
		if (node.getRight() == null && node.getMiddle() == null && node.getLeft() == null) {
			
			// If both data items exist, print both
			if (node.getSmall() != null && node.getLarge() != null) {
				System.out.print(node.getSmall() + ", " + node.getLarge() + ", ");
			// Else, print only the small data item
			} else {
				System.out.print(node.getSmall() + ", ");
			}
		
		// Else if the root has two data items (neither are null) - recursively call the method
		} else if (node.getSmall() != null && node.getLarge() != null) {
			inOrder(node.getLeft());
			inOrder(node.getMiddle());
			inOrder(node.getRight());
		
		// Else, there is only one data item present - recursively call the method
		} else {
			inOrder(node.getLeft());
			inOrder(node.getMiddle());
		}	
	}
	
	
	/** Method to insert a new item into the 2-3 tree 
	 * @param accepts a Node root and a String value for a dvd title */
	public static void insert(Node node, String dvd) {
		
		// locate the leaf node where the dvd string exists 
		// add the dvd to the leafnode
			// if the node already has 2 data items put it in the temp location
				// if temp location is full (3 data items present), then we need to split
			// if the node has 1 data item just place it in this node (in the correct spot)
		
		
		// If the node is a leaf node
		if (node.left == null && node.middle == null && node.right == null) {
			
			// If both data elements are present, split the node
			if (node.getSmall() != null && node.getLarge() != null) {
				split(node, dvd);
				
	            if (node.getParent() != null) {   
//	                this.moveUp(this);
	            }
				
			// Else, just place the data string into the large data position
			} else {
				
				// If the string parameter is less than or equal to the small element's string value
				if (compareStrings(dvd, node.getSmall()) <= 0) {    
	                node.setLarge(dvd);
	            
				// Else put the dvd string into the smaller data item, and switch the current small item into the larger position
				} else {  
					String temp = node.getLarge();
					node.setLarge(node.getSmall());
	                node.setSmall(temp);
	            }
				
			}
		}
		
		split(node, dvd);
		
		// CHANGE THIS - if the node is the root
//		if (node == node) {
//			Node parent = new Node();
//		} else {
//			
//		}
		
		
		// If the node is not a leaf, we continue on
	    if (compareStrings(node.getSmall(), dvd) == 1) {     
	        insert(node.left, dvd);
	    
	    // If the large item is null then we just insert the string into this place
	    } else if (node.getLarge() == null) {    
	        insert(node.right, dvd);
	    
	    // Else we determine if we should insert in the mid or right location
	    } else {             
	        if (compareStrings(node.getLarge(), dvd) == 1) {   
	            insert(node.middle, dvd);
	        } else {        
	            insert(node.right, dvd);
	        }
	    }	
	}
	
	
	
	
	public boolean inserted = false;
	
	public void insert2(Node node, String dvd) {

		// If the tree is empty, create a node and put dvd string into the node
		if (root == null) {
			root = new Node(dvd);
			root.setParent(null);
		}
		
		// If we reached the correct leaf node to insert at
		if (node == null) {
			// Create a new node with the dvd value in it
			node = new Node(dvd);
			node.setParent(node);
			
		} else {
			// If only 1 data item present
			if (node.getLarge() == null) {
				// If node's small item is greater than dvd string
				if (compareStrings(node.getSmall(), dvd) == 1) {
					insert2(node.left, dvd);
					
				// Else if node's small item is less than dvd string
				} else if (compareStrings(node.getSmall(), dvd) == -1) {
					insert2(node.middle, dvd);
				}
				
			// 2 data items present	
			} else {
				
				// If node's small item is greater than dvd string
				if (compareStrings(node.getSmall(), dvd) == 1) {
					insert2(node.left, dvd);
				
				// Else if node's small item is less than dvd string
				} else if (compareStrings(node.getSmall(), dvd) == -1) {
					insert2(node.middle, dvd);
				
				// Else we just insert right
				} else {
					insert2(node.right, dvd);
				}
				
			}
			
			if (!inserted) {
				if (node.getLarge() == null) {
					
					// If node's small item is greater than dvd string, insert in the small position 
					// and move the current small position to the large position
					if (compareStrings(node.getSmall(), dvd) == 1) {
						node.setLarge(node.getSmall());
						node.setSmall(dvd);
						
					// Else if the small item is less than the dvd string insert in the large position
					} else if (compareStrings(node.getSmall(), dvd) == -1) {
						node.setLarge(dvd);
					}
				
				} else {
					split(node, dvd);
				}
				
				inserted = true;
				
			}
			
		}
		
	}
	
	
	
	
	
	
	
	
	
	// TESTINGGGGGGG
	public void insert3(Node currentNode, String dvd) {
		
		if (currentNode == null) {
			Node newNode = new Node(dvd);
			root = currentNode = newNode;
			root.setSmall(dvd);
		} else {
			// No large item means only 0 or 2 children
			if(currentNode.getLarge() == null) {
				if(compareStrings(currentNode.getSmall(), dvd) == 1) {
					insert3(currentNode.getLeft(), dvd);
				} else if (compareStrings(currentNode.getSmall(), dvd) == -1) {
					insert3(currentNode.getMiddle(), dvd);
				}
			}
			// There is a large item means 3 children
			else {
				if (compareStrings(currentNode.getSmall(), dvd) == 1) {
					insert3(currentNode.getLeft(), dvd);
				} else if (compareStrings(currentNode.getSmall(),dvd) == -1 && compareStrings(currentNode.getLarge(), dvd) == 1) {
					insert3(currentNode.getMiddle(), dvd);
				} else {
					insert3(currentNode.getRight(), dvd);
				}
			}

			if(!inserted) {
				// Found leaf node: currentNode
				// Large Item doesn't exist
				if (currentNode.getLarge() == null) {
					if(compareStrings(currentNode.getSmall(), dvd) == 1) {
						currentNode.setLarge(currentNode.getSmall());
						currentNode.setSmall(dvd);
					} else if(compareStrings(currentNode.getSmall(), dvd) == -1) {
						currentNode.setLarge(dvd);
					}
				} // both small and large nodes exist: so 3 items in node: split
				else {
					split(currentNode, dvd);
				}
				inserted = true;
			}
		}
	}
	
	
	
	/** Method to split the node when 3 data items exist
	 * @param accepts a node to split
	 */
	public static void split(Node node, String dvd) {
		System.out.println("split");
		// If parent is null - if the node is the root
		if (node.getParent() == null) {
			
			// LEFT
			if (compareStrings(node.getSmall(), dvd) == 1) {
				Node left = new Node();
				left.setParent(node);
				left.setSmall(dvd);
				
				// If left child is not null
				if (node.getLeft() != null) {
					node.setLeft(left);
				}
				
				left.setLeft(node.getLeft());
				
				// If middle child is not null
				if (node.getMiddle() != null) {
					node.getMiddle().setParent(left);
				}
				
				left.setMiddle(node.getMiddle());
				node.setLeft(left);
				
				Node right = new Node();
				right.setParent(node);
				right.setSmall(node.getLarge());
				
				// If right child is not null
				if (node.getRight() != null) {
					node.getRight().setParent(right);
				}
				
				right.setLeft(node.getRight());
				
				// If temp child is not null
				if (node.getTemp() != null) {
					node.getTemp().setParent(right);
				}
				
				right.setMiddle(node.getTemp());
				node.setMiddle(right);
				
				node.setRight(null);
				node.setTemp(null);
				node.setLarge(null);
				
				
			// MIDDLE
			} else if (compareStrings(node.getSmall(), dvd) == -1 && compareStrings(node.getLarge(), dvd) == 1) {
				Node left = new Node();
				left.setParent(node);
				left.setSmall(node.getSmall());
				
				// If left child is not null
				if (node.getLeft() != null) {
					node.getLeft().setParent(left);
				}
				
				left.setLeft(node.getLeft());
				
				// If middle child is not null
				if (node.getMiddle() != null) {
					node.getMiddle().setParent(left);
				}
				
				left.setMiddle(node.getMiddle());
				node.setLeft(left);
				node.setSmall(dvd);
				
				Node right = new Node();
				right.setParent(node);
				right.setSmall(node.getLarge());
				
				// If right child is not null
				if (node.getRight() != null) {
					node.getRight().setParent(right);
				}
				
				
				
				// TESTINGGGGGGGGGGGGGG
				right.setLeft(node.getRight());
				
				if(node.getTemp() != null)
					node.getTemp().setParent(right);
				
				right.setMiddle(node.getTemp());
				node.setTemp(null);
				node.setMiddle(right);

				node.setLarge(null);
				node.setRight(null);
			
			} else if (compareStrings(node.getLarge(), dvd) == -1) {
				Node left = new Node();
				left.setParent(node);
				left.setSmall(node.getSmall());
				if(node.getLeft() != null)
					node.getLeft().setParent(left);
				left.setLeft(node.getLeft());
				if(node.getMiddle() != null)
					node.getMiddle().setParent(left);
				left.setMiddle(node.getMiddle());
				node.setLeft(left);

				node.setSmall(node.getLarge());
				node.setLarge(null);


				Node right = new Node();
				right.setParent(node);
				right.setSmall(dvd);
				if(node.getRight() != null)
					node.getRight().setParent(right);
				right.setLeft(node.getRight());
				if(node.getTemp() != null)
					node.getTemp().setParent(right);
				right.setMiddle(node.getTemp());
				node.setTemp(null);
				node.setMiddle(right);

				node.setRight(null);

			}

		// current is non root node and its parent has no large item
		} else if(node.getParent().getLarge() == null) {
			if(compareStrings(node.getSmall(), dvd) == 1) {
				Node rightmost = new Node();
				rightmost.setParent(node.getParent());
				rightmost.setSmall(node.getLarge());
				rightmost.setLeft(node.getRight());
				node.setRight(null);
				rightmost.setMiddle(node.getTemp());
				node.setTemp(null);
				node.getParent().setRight(rightmost);

				node.setLarge(null);
				node.getParent().setLarge(node.getSmall());
				node.setSmall(dvd);

			} else if(compareStrings(node.getSmall(), dvd) == -1 && compareStrings(node.getLarge(), dvd) == 1) {
				Node rightmost = new Node();
				rightmost.setParent(node.getParent());
				rightmost.setSmall(node.getLarge());
				rightmost.setLeft(node.getRight());
				node.setRight(null);
				rightmost.setMiddle(node.getTemp());
				node.setTemp(null);
				node.getParent().setRight(rightmost);

				node.setLarge(null);
				node.getParent().setLarge(dvd);

			} else if(compareStrings(node.getLarge(), dvd) == -1) {
				Node rightmost = new Node();
				rightmost.setParent(node.getParent());
				rightmost.setSmall(dvd);
				rightmost.setLeft(node.getRight());
				node.setRight(null);
				rightmost.setMiddle(node.getTemp());
				node.setTemp(null);
				node.getParent().setRight(rightmost);

				node.getParent().setLarge(node.getLarge());
				node.setLarge(null);
			}
		// the parent node has both small and large items
		} else {
			String newDVD = null;
			if(compareStrings(node.getSmall(), dvd) == 1) {
				Node temp = new Node();
				temp.setParent(node.getParent());
				temp.setSmall(node.getLarge());
				temp.setLeft(node.getRight());
				node.setRight(null);
				temp.setMiddle(node.getTemp());
				node.setTemp(null);
				node.getParent().setTemp(temp);

				node.setLarge(null);

				newDVD = node.getSmall();
				node.setSmall(dvd);

			} else if(compareStrings(node.getSmall(), dvd) == -1 && compareStrings(node.getLarge(), dvd) == 1) {
				Node temp = new Node();
				temp.setParent(node.getParent());
				temp.setSmall(node.getLarge());
				temp.setLeft(node.getRight());
				node.setRight(null);
				temp.setMiddle(node.getTemp());
				node.setTemp(null);
				node.getParent().setTemp(temp);

				node.setLarge(null);

				newDVD = dvd;

			} else if(compareStrings(node.getLarge(), dvd) == -1) {
				Node temp = new Node();
				temp.setParent(node.getParent());
				temp.setSmall(dvd);
				temp.setLeft(node.getRight());
				node.setRight(null);
				temp.setMiddle(node.getTemp());
				node.setTemp(null);
				node.getParent().setTemp(temp);


				newDVD = node.getLarge();
				node.setLarge(null);
			}
			
			//recursive call
			split(node.getParent(), newDVD);
		}
		
	}
	
	
	//---------------------OPTIONAL
	/** Method to remove an item from the 2-3 tree 
	 * @param accepts a String for a dvd name to remove */
	public static void remove(String dvd) {
		
	}
	
	
	/** Method searches for a specified String dvd title 
	 * @param accepts a String value for a dvd title 
	 * @return returns a pointer to a Node if the item exists, or null if it does not exist in the 2-3 tree */
	public static Node search(Node node, String dvd) {
		
		// Base Case - if the node data == the dvd string return the node
		if (node.getSmall() == dvd || node.getLarge() == dvd) {
			return node;
			
		// Base Case - Else if the node is a leaf return null - failure case
		} else if (node.left == null && node.middle == null && node.right == null) {
			return null;
		
		// Search subtrees 
		// If the node has two data items
		} else if (node.getSmall() != null && node.getLarge() != null) {
			
			// If the specified string is less than the smaller search key of the root node
			if (compareStrings(dvd, node.getSmall()) == -1) {
				return search(node.left, dvd);
				
			// Else if the specified string is less than the larger search key of the root node
			} else if (compareStrings(dvd, node.getLarge()) == -1) {
				return search(node.middle, dvd);
				
			// Else search the right branch of the node
			} else {
				return search(node.right, dvd);
			}
		
		// If the node has one data item
		} else {
			
			if (compareStrings(dvd, node.getSmall()) == -1) {
				search(node.right, dvd);
			} else {
				search(node.right, dvd);
			}	
		}
		return node;
	}
	
	
	/** Method to compare the values of two strings 
	 * Compares based on alphabetical ASCII values 
	 * @param accepts two string values to compare 
	 * @return returns an integer value:
	 * 			zero value 		= strings are equal
	 * 			positive value 	= string1 > string2
	 * 			negative value 	= string1 < string2 */
	public static int compareStrings(String string1, String string2) {
		// Find the minimum length between the two strings
		int minVal = Math.min(string1.length(), string2.length());
		
		for (int i = 0; i < minVal; i++) {
			// Transform each character into ASCII value
			int str1 = (int)string1.charAt(i);
			int str2 = (int)string2.charAt(i);
			
			// If the two values aren't the same
			if (str1 != str2) {
				
				// If string 1 is greater
				if (str1 > str2) {
					return 1;
					
				// If string 2 is greater
				} else if (str1 < str2) {
					return -1;
				}
			}
		}
		// If the strings are equal
		return 0;
	}
	
	
	/** Main Method */
	public static void main(String[] args) {
		// Create a Scanner
		Scanner input = new Scanner(System.in);
		
		TTTree tree = new TTTree();
		
//		// Prompt the user to enter DVD titles and input them into the tree
//		System.out.println("Enter DVD titles to add to the 2-3 tree. Separate each title by pressing 'ENTER'. When finished, press 'q' and 'ENTER': ");
//		int sentinel = -1;
//		String next = "";
//		
//		while (sentinel != 0) { 
//			next = input.nextLine();
//			
//			// If the sentinel value is entered, stop processing information
//            if (next.length() == 1 && next.charAt(0) == (int)'q') {
//            	sentinel = 0;
//            } else {
//            	// Insert each sentence into the 2-3 tree
//            	tree.insert(tree.root, next);
//            }
//            
//		}
//		
//		// Prompt the user to search for a DVD
//		System.out.println("Enter a DVD title you want to search for: ");
//		String userDVD = input.nextLine();
//		Node temp = tree.search(tree.root, userDVD);
//		String exists = " does not exist ";
//		
//		if (temp != null) {
//			exists = " exists ";
//		}
//		
//		// Display whether it exists or not in the database
//		System.out.println("The DVD " + userDVD + exists + " in our database.");
//		
//		// Display the reference to the node if it exists
//		if (exists == " exists ") {
//			System.out.println("The reference to the node where the DVD exists is: " + temp);
//		}
//		
//		
//		// Display all DVDs in the 2-3 tree
//		tree.inOrder(tree.root);
//		tree.preOrder(tree.root);
		
		
		
		// TESTING
		tree.insert2(tree.root, "z");
		tree.insert2(tree.root, "k");
		tree.insert2(tree.root, "r");
		tree.insert2(tree.root, "a");
		tree.insert2(tree.root, "l");
		tree.insert2(tree.root, "t");
		tree.insert2(tree.root, "y");
		tree.insert2(tree.root, "s");
		tree.insert2(tree.root, "e");
		System.out.print("In-Order: ");
		tree.inOrder(tree.root);
		System.out.print("\nPre-Order: ");
		tree.preOrder(tree.root);
		
		String searchVal = "e";
		Node search = tree.search(tree.root, searchVal);
		if (search == null) {
			System.out.println("The DVD '" + searchVal + "' does not exist");
		} else if (search.getLarge() == searchVal) {
			System.out.println("The search for the DVD '" + searchVal + "' returns: " + search.getLarge() + " at node " + search);
		} else if (search.getSmall() == searchVal) {
			System.out.println("The search for the DVD '" + searchVal + "' returns: " + search.getSmall() + " at node " + search);
		}
		
		
	}
	
}








