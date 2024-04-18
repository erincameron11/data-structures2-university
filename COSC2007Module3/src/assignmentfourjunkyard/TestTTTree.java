package assignmentfourjunkyard;

/** External Node23 Class */
class Node23 {
	private String small;
	private String large;
	Node23 temp;
	Node23 left;
	Node23 middle;
	Node23 right;
	Node23 parent;
	
	// No-arg constructor sets everything to null
	public Node23() {
		left = middle = right = null;
	}
	
	// 2-arg Constructor that sets 1 data value in the Node23, and sets this Node23's parent to the current Node23
	public Node23(String small) {
//		this.parent = parent;
		this.small = small;
//		this.parent = parent;
	}
	
	// 2-arg Constructor that sets both data values in the Node23
	public Node23(String small, String large, Node23 parent) {
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
	public Node23 getParent() {
		return parent;
	}
	
	// Setter for parent
	public void setParent(Node23 parent) {
		this.parent = parent;
	}

	// Getter for temp
	public Node23 getTemp() {
		return temp;
	}

	// Setter for temp
	public void setTemp(Node23 temp) {
		this.temp = temp;
	}

	public Node23 getLeft() {
		return left;
	}

	public void setLeft(Node23 left) {
		this.left = left;
	}

	public Node23 getMiddle() {
		return middle;
	}

	public void setMiddle(Node23 middle) {
		this.middle = middle;
	}

	public Node23 getRight() {
		return right;
	}

	public void setRight(Node23 right) {
		this.right = right;
	}
	
//	public boolean isLeaf(Node23 Node23) {
//		if (Node23.left == null && Node23.right == null && Node23.middle == null) {
//			return true;
//		} else {
//			return false;
//		}
//	}
	
	
	
}

public class TestTTTree {
	
	// Initialize a Node23 root variable
	Node23 root;
	
	
	/** Method to traverse the tree in sorted search-key order (LEFT - ROOT - RIGHT)
	 * @param accepts a Node23 root value */
	public static void inOrder(Node23 Node23) {
		// If the tree Node23 is a leaf
		if (Node23.getRight() == null && Node23.getMiddle() == null && Node23.getLeft() == null) {
			
			// If both data items exist, print both
			if (Node23.getSmall() != null && Node23.getLarge() != null) {
				System.out.print(Node23.getSmall() + ", " + Node23.getLarge() + ", ");
			// Else, print only the small data item
			} else {
				System.out.print(Node23.getSmall() + ", ");
			}
		
		// Else if the root has two data items (neither are null) - recursively call the method
		} else if (Node23.getSmall() != null && Node23.getLarge() != null) {
			inOrder(Node23.getLeft());
			inOrder(Node23.getMiddle());
			inOrder(Node23.getRight());
		
		// Else, there is only one data item present - recursively call the method
		} else {
			inOrder(Node23.getLeft());
			inOrder(Node23.getMiddle());
		}	
	}
	
	
	// ---------------------NEED TO FIX
	/** Method to traverse the tree in pre-Order format (ROOT - LEFT - RIGHT)
	 * @param accepts a Node23 root value */
	public static void preOrder(Node23 Node23) {
		// If the tree Node23 is a leaf
		if (Node23.getRight() == null && Node23.getMiddle() == null && Node23.getLeft() == null) {
			
			// If both data items exist, print both
			if (Node23.getSmall() != null && Node23.getLarge() != null) {
				System.out.print(Node23.getSmall() + ", " + Node23.getLarge() + ", ");
			// Else, print only the small data item
			} else {
				System.out.print(Node23.getSmall() + ", ");
			}
		
		// Else if the root has two data items (neither are null) - recursively call the method
		} else if (Node23.getSmall() != null && Node23.getLarge() != null) {
			inOrder(Node23.getLeft());
			inOrder(Node23.getMiddle());
			inOrder(Node23.getRight());
		
		// Else, there is only one data item present - recursively call the method
		} else {
			inOrder(Node23.getLeft());
			inOrder(Node23.getMiddle());
		}	
	}
	
	
	public boolean inserted = false;
	// TESTINGGGGGGG
	public void insert3(Node23 currentNode23, String dvd) {
		
		// If first node in tree
		if (root == null) {
			root = new Node23(dvd);
			root.setParent(null);
		}
		
		if ((currentNode23.getLeft() == null) && (currentNode23.getMiddle() == null) && (currentNode23.getRight() == null)) {
			
//		}
		
		// If we reached the correct leaf node to insert at
//		if (currentNode23 == null) {
			// Create a new node with the dvd value in it
			currentNode23 = new Node23(dvd);
			currentNode23.setParent(currentNode23);
		
		} else {
			// No large item means only 0 or 2 children
			if(currentNode23.getLarge() == null) {
				if(compareStrings(currentNode23.getSmall(), dvd) == 1) {
					insert3(currentNode23.getLeft(), dvd);
				} else if (compareStrings(currentNode23.getSmall(), dvd) == -1) {
					insert3(currentNode23.getMiddle(), dvd);
				}
			}
			// There is a large item means 3 children
			else {
				if (compareStrings(currentNode23.getSmall(), dvd) == 1) {
					insert3(currentNode23.getLeft(), dvd);
				} else if (compareStrings(currentNode23.getSmall(),dvd) == -1 && compareStrings(currentNode23.getLarge(), dvd) == 1) {
					insert3(currentNode23.getMiddle(), dvd);
				} else {
					insert3(currentNode23.getRight(), dvd);
				}
			}

			if(!inserted) {
				// Found leaf Node23: currentNode23
				// Large Item doesn't exist
				if (currentNode23.getLarge() == null) {
					if(compareStrings(currentNode23.getSmall(), dvd) == 1) {
						currentNode23.setLarge(currentNode23.getSmall());
						currentNode23.setSmall(dvd);
					} else if(compareStrings(currentNode23.getSmall(), dvd) == -1) {
						currentNode23.setLarge(dvd);
					}
				} // both small and large Node23s exist: so 3 items in Node23: split
				else {
					System.out.println("split");
					split(currentNode23, dvd);
				}
				inserted = true;
			}
		}
	}
	
	
	/** Method to split the Node23 when 3 data items exist
	 * @param accepts a Node23 to split
	 */
	public static void split(Node23 Node23, String dvd) {
		System.out.println("split");
		// If parent is null - if the Node23 is the root
		if (Node23.getParent() == null) {
			
			// LEFT
			if (compareStrings(Node23.getSmall(), dvd) == 1) {
				Node23 left = new Node23();
				left.setParent(Node23);
				left.setSmall(dvd);
				
				// If left child is not null
				if (Node23.getLeft() != null) {
					Node23.setLeft(left);
				}
				
				left.setLeft(Node23.getLeft());
				
				// If middle child is not null
				if (Node23.getMiddle() != null) {
					Node23.getMiddle().setParent(left);
				}
				
				left.setMiddle(Node23.getMiddle());
				Node23.setLeft(left);
				
				Node23 right = new Node23();
				right.setParent(Node23);
				right.setSmall(Node23.getLarge());
				
				// If right child is not null
				if (Node23.getRight() != null) {
					Node23.getRight().setParent(right);
				}
				
				right.setLeft(Node23.getRight());
				
				// If temp child is not null
				if (Node23.getTemp() != null) {
					Node23.getTemp().setParent(right);
				}
				
				right.setMiddle(Node23.getTemp());
				Node23.setMiddle(right);
				
				Node23.setRight(null);
				Node23.setTemp(null);
				Node23.setLarge(null);
				
				
			// MIDDLE
			} else if (compareStrings(Node23.getSmall(), dvd) == -1 && compareStrings(Node23.getLarge(), dvd) == 1) {
				Node23 left = new Node23();
				left.setParent(Node23);
				left.setSmall(Node23.getSmall());
				
				// If left child is not null
				if (Node23.getLeft() != null) {
					Node23.getLeft().setParent(left);
				}
				
				left.setLeft(Node23.getLeft());
				
				// If middle child is not null
				if (Node23.getMiddle() != null) {
					Node23.getMiddle().setParent(left);
				}
				
				left.setMiddle(Node23.getMiddle());
				Node23.setLeft(left);
				Node23.setSmall(dvd);
				
				Node23 right = new Node23();
				right.setParent(Node23);
				right.setSmall(Node23.getLarge());
				
				// If right child is not null
				if (Node23.getRight() != null) {
					Node23.getRight().setParent(right);
				}
				
				
				
				// TESTINGGGGGGGGGGGGGG
				right.setLeft(Node23.getRight());
				
				if(Node23.getTemp() != null)
					Node23.getTemp().setParent(right);
				
				right.setMiddle(Node23.getTemp());
				Node23.setTemp(null);
				Node23.setMiddle(right);

				Node23.setLarge(null);
				Node23.setRight(null);
			
			} else if (compareStrings(Node23.getLarge(), dvd) == -1) {
				Node23 left = new Node23();
				left.setParent(Node23);
				left.setSmall(Node23.getSmall());
				if(Node23.getLeft() != null)
					Node23.getLeft().setParent(left);
				left.setLeft(Node23.getLeft());
				if(Node23.getMiddle() != null)
					Node23.getMiddle().setParent(left);
				left.setMiddle(Node23.getMiddle());
				Node23.setLeft(left);

				Node23.setSmall(Node23.getLarge());
				Node23.setLarge(null);


				Node23 right = new Node23();
				right.setParent(Node23);
				right.setSmall(dvd);
				if(Node23.getRight() != null)
					Node23.getRight().setParent(right);
				right.setLeft(Node23.getRight());
				if(Node23.getTemp() != null)
					Node23.getTemp().setParent(right);
				right.setMiddle(Node23.getTemp());
				Node23.setTemp(null);
				Node23.setMiddle(right);

				Node23.setRight(null);

			}

		// current is non root Node23 and its parent has no large item
		} else if(Node23.getParent().getLarge() == null) {
			if(compareStrings(Node23.getSmall(), dvd) == 1) {
				Node23 rightmost = new Node23();
				rightmost.setParent(Node23.getParent());
				rightmost.setSmall(Node23.getLarge());
				rightmost.setLeft(Node23.getRight());
				Node23.setRight(null);
				rightmost.setMiddle(Node23.getTemp());
				Node23.setTemp(null);
				Node23.getParent().setRight(rightmost);

				Node23.setLarge(null);
				Node23.getParent().setLarge(Node23.getSmall());
				Node23.setSmall(dvd);

			} else if(compareStrings(Node23.getSmall(), dvd) == -1 && compareStrings(Node23.getLarge(), dvd) == 1) {
				Node23 rightmost = new Node23();
				rightmost.setParent(Node23.getParent());
				rightmost.setSmall(Node23.getLarge());
				rightmost.setLeft(Node23.getRight());
				Node23.setRight(null);
				rightmost.setMiddle(Node23.getTemp());
				Node23.setTemp(null);
				Node23.getParent().setRight(rightmost);

				Node23.setLarge(null);
				Node23.getParent().setLarge(dvd);

			} else if(compareStrings(Node23.getLarge(), dvd) == -1) {
				Node23 rightmost = new Node23();
				rightmost.setParent(Node23.getParent());
				rightmost.setSmall(dvd);
				rightmost.setLeft(Node23.getRight());
				Node23.setRight(null);
				rightmost.setMiddle(Node23.getTemp());
				Node23.setTemp(null);
				Node23.getParent().setRight(rightmost);

				Node23.getParent().setLarge(Node23.getLarge());
				Node23.setLarge(null);
			}
		// the parent Node23 has both small and large items
		} else {
			String newDVD = null;
			if(compareStrings(Node23.getSmall(), dvd) == 1) {
				Node23 temp = new Node23();
				temp.setParent(Node23.getParent());
				temp.setSmall(Node23.getLarge());
				temp.setLeft(Node23.getRight());
				Node23.setRight(null);
				temp.setMiddle(Node23.getTemp());
				Node23.setTemp(null);
				Node23.getParent().setTemp(temp);

				Node23.setLarge(null);

				newDVD = Node23.getSmall();
				Node23.setSmall(dvd);

			} else if(compareStrings(Node23.getSmall(), dvd) == -1 && compareStrings(Node23.getLarge(), dvd) == 1) {
				Node23 temp = new Node23();
				temp.setParent(Node23.getParent());
				temp.setSmall(Node23.getLarge());
				temp.setLeft(Node23.getRight());
				Node23.setRight(null);
				temp.setMiddle(Node23.getTemp());
				Node23.setTemp(null);
				Node23.getParent().setTemp(temp);

				Node23.setLarge(null);

				newDVD = dvd;

			} else if(compareStrings(Node23.getLarge(), dvd) == -1) {
				Node23 temp = new Node23();
				temp.setParent(Node23.getParent());
				temp.setSmall(dvd);
				temp.setLeft(Node23.getRight());
				Node23.setRight(null);
				temp.setMiddle(Node23.getTemp());
				Node23.setTemp(null);
				Node23.getParent().setTemp(temp);


				newDVD = Node23.getLarge();
				Node23.setLarge(null);
			}
			
			//recursive call
			split(Node23.getParent(), newDVD);
		}
		
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
	
	public static void print(Node23 node) {
		System.out.println(node.getSmall() + ", " + node.getLarge() + ", " + node.getLeft() + ", " + node.getMiddle() + ", " + node.getRight() + ", " + node.getParent());
	}
	
	
	/** Main Method */
	public static void main(String[] args) {
		
		TestTTTree tree = new TestTTTree();
		
		tree.insert3(tree.root, "z");
		tree.insert3(tree.root, "k");
		tree.insert3(tree.root, "r");
		tree.insert3(tree.root, "a");
		tree.insert3(tree.root, "l");
		tree.insert3(tree.root, "t");
		tree.insert3(tree.root, "y");
		tree.insert3(tree.root, "s");
		tree.insert3(tree.root, "e");
//		System.out.print("In-Order: ");
//		tree.inOrder(tree.root);
//		System.out.print("\nPre-Order: ");
//		tree.preOrder(tree.root);
//		tree.print(tree.root);
		tree.inOrder(tree.root);
		
		
		
	}
	
}








