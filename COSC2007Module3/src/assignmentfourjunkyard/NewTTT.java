package assignmentfourjunkyard;

public class NewTTT <S extends Comparable<S>>{

	private class Node {
		private S small;
		private S large;
		Node left;
		Node middle;
		Node right;
		
		public Node() {
			small = null;
			large = null;
			left = null;
			middle = null;
			right = null;
		}
		
		public Node(S small, S large) {
			this.small = small;
			this.large = large;
			left = null;
			middle = null;
			right = null;
		}
		
		public Node(S small, S large, Node left, Node middle) {
			this.small = small;
			this.large = large;
			this.left = left;
			this.middle = middle;
		}

		public S getSmall() {
			return small;
		}

		public void setSmall(S small) {
			this.small = small;
		}

		public S getLarge() {
			return large;
		}

		public void setLarge(S large) {
			this.large = large;
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
		
		public boolean isLeaf() {
			return left == null && middle == null && right == null;
		}
		
		public boolean has2Children() {
			return right == null;
		}
		
		public boolean has3Children() {
			return right != null;
		}
		
		private boolean isNodeLeaf() {
			return left == null && middle == null && right == null;
		}
	}
	
	
	
	private Node root;
	public NewTTT() {
		root = new Node();
	}
	
	public boolean isEmpty(){
        if(root == null) 
        	return true;
        if(root.getSmall() == null) 
        	return true;
        return false;
	}
	
	private boolean complete;
	
	
	// TEST ONE
//	public boolean insert(String value) {
//         complete = false;
//         this.elements++;
//         //BASE CASE:when there is no root or no left Key in root
//         if(root == null || root.small == null) { 
//                 if(root == null) root = new Node();
//                 root.setSmall(value);
//                 complete = true; //Insertion Done Correctly
//         }
//         else //When root is not null neither the Left Key is null
//         {
//                 Node newRoot = insertR(root, value); // calling of insertR for newRoot 
//                 //Root assigned to NewRoot if not null
//                 if(newRoot != null) root = newRoot;
//         }
//         //If insertion is not done correctly,size is decremented to readjust size
//         if(!complete) 
//        	 this.elements--; 
//         return complete; //and False is returned for incorrect insertion otherwise true
//	 }
	 
	
	
	// TEST ONE
//	private Node split(Node current, String value){
//		Node newParent = null;
//    
//        //when the left key of the current node is greater than the values
//    
//        if (current.small.compareTo(value) > 0){
//        	Node left   = new Node(value, null);
//        	Node right  = new Node(current.large, null);
//	        newParent   = new Node(current.small, null, left, right);
//        } 
//        //when the left key of the current node is lesser than the values
//        else if (current.small.compareTo(value) < 0) {
//        	// The new element is greater than the current's left only
//        	if (current.large.compareTo(value) > 0) {
//
//        		Node left   = new Node(current.small, null);
//        		Node right  = new Node(current.large, null);
//	            newParent   = new Node(value, null, left, right);
//
//        	} else { //when the values is the largest from both the right and left keys
//        		Node left   = new Node(current.small, null);
//        		Node right  = new Node(value, null);
//	            newParent   = new Node(current.large, null, left, right);
//        	}
//        }
//        return newParent;
//    }
	
	 
	public boolean insert(S dvd) {
		complete = false;
		// Base Case - when the root is null
		if (root == null || root.getSmall() == null) {
			if (root == null) {
				root = new Node();
			}
			root.setSmall(dvd);
			complete = true;
		} else {
			Node root2 = insertHelper(root, dvd);
			
			if (root2 != null) {
				root = root2;
			}
		}
		
		return complete;
	}
	
	// TEST ONE
//	 private Node insertR(Node current, String element) {
//		 Node newParent = null;
//         // We aren't in the deepest level yet
//         if(!current.isNodeLeaf()) {
//        	 Node childPushedUp = null;
//                
//             if (current.small.compareTo(element) == 0 || (current.has3Children() && current.large.compareTo(element) == 0)) {
//                      // Already exists
//                 
//             } else if (current.small.compareTo(element) > 0) { // The new element is smaller than the left element of the current node
//             	childPushedUp = insertR(current.left, element);
//             		// Case childPushedUp != null --> the element has been added on a 3-node (there were 2 values)
//             		if (childPushedUp != null) { // A new node comes from the left branch
//             			// The new element, in this case, is always less than the current.small
//             			if (current.has2Children()) {
//             				current.large = current.small;  // shift the current left element to the right
//             				current.small = childPushedUp.small;
//             				current.right = current.middle;
//                            	current.middle = childPushedUp.middle;
//                            	current.left = childPushedUp.left;
//             			} else { // In this case we have a new split, so the current element in the left will go up
//                             // copy the right part of the subtree
//             				Node rightSubtreeCopy = new Node(current.large, null, current.middle, current.right);
//                            	// Now we create the new "structure", pasting the right part
//                            	newParent = new Node(current.small, null, childPushedUp, rightSubtreeCopy);
//             			}
//             		}
//                 
//             // Case: the pushed up element is bigger than the left element and less than the right element
//             } else if (current.has2Children() || (current.has3Children() && current.large.compareTo(element) > 0)) {
//                         childPushedUp = insertR(current.middle, element);
//                         if (childPushedUp != null) { // A new split
//                                 // The right element is empty, so we can set the pushed up element in the left and the existing left element into the right
//                                 if (current.has2Children()) {
//                                         current.large = childPushedUp.small;
//                                         current.right = childPushedUp.middle;
//                                         current.middle = childPushedUp.left;
//                                 }
//                                 else { // Another case where we have to split again
//                                	 Node left = new Node(current.small, null, current.left, childPushedUp.left);
//                                	 Node mid = new Node(current.large, null, childPushedUp.middle, current.right);
//                                     newParent = new Node(childPushedUp.small, null, left, mid);
//                                 }
//                         }
//                         // The new element is greater than the right element
//             } else if (current.has3Children() && current.large.compareTo(element) < 0) {
//                         childPushedUp = insertR(current.right, element);
//                         if (childPushedUp != null) { // Split and the right element is pushed up
//                        	 Node leftCopy   = new Node(current.small, null, current.left, current.middle);
//                             newParent       = new Node(current.large, null, leftCopy, childPushedUp);
//                         }
//                 }
//         
//         
//         } else { // in the deepest level
//                 complete = true;
//                 // when the element already exists
//                 if (current.small.compareTo(element) == 0 || (current.has3Children() && current.large.compareTo(element) == 0)) {
//                         complete = false;
//                 }
//                 else if (current.has2Children()) { // a simple case: there is no right element
//                         // if the current left element is bigger than the new one --> we shift the left element to the right
//                         if (current.small.compareTo(element) > 0) {
//                                 current.large    = current.small;
//                                 current.small     = element;
//                         }
//                         // if the new element is bigger, we add it in the right key directly
//                         else if (current.small.compareTo(element) < 0) current.large = element;
//                 }
//                 // Case 3-node: there are 2 values in the node and we want to add another one. We have to split the node
//                 else newParent = split(current, element);
//         }
//         return newParent;
// }
	
	public Node insertHelper(Node node, S dvd) {
		Node parent = null;
//		complete = true;
		
		if (!node.isLeaf()) {
			Node pushUp = null;
			
			if (node.getSmall().compareTo(dvd) == 0 || node.has3Children() && node.getLarge().compareTo(dvd) == 0) {
				// Do nothing because the element already exists in the tree
			}
			
			else if (node.getSmall().compareTo(dvd) > 0) {
				pushUp = insertHelper(node.getLeft(), dvd);
				
				if (pushUp != null) {
					
					if (node.has2Children()) {
						node.setLarge(node.getSmall());
						node.setSmall(pushUp.getSmall());
						node.setRight(node.getMiddle());
						node.setMiddle(pushUp.getMiddle());
						node.setLeft(pushUp.getLeft());
					} else {
						Node rightSubtree = new Node(node.getLarge(), null, node.getMiddle(), node.getRight());
						parent = new Node(node.getSmall(), null, pushUp, rightSubtree);
					}
				}
				
			} else if (node.has2Children() || (node.has3Children() && node.getLarge().compareTo(dvd) > 0)) {
				pushUp = insertHelper(node.getMiddle(), dvd);
				
				if (pushUp != null) {
					
					if (node.has2Children()) {
						node.setLarge(pushUp.getSmall());
						node.setRight(pushUp.getMiddle());
						node.setMiddle(pushUp.getLeft());
					} else {
						Node left = new Node(node.getSmall(), null, node.getLeft(), pushUp.getLeft());
						Node mid = new Node(node.getLarge(), null, pushUp.getMiddle(), node.getRight());
						parent = new Node(pushUp.getSmall(), null, left, mid);
					}
				}
			} else if (node.has3Children() && node.getLarge().compareTo(dvd) < 0) {
				pushUp = insertHelper(node.getRight(), dvd);
				
				if (pushUp != null) {
					Node leftCopy = new Node(node.getSmall(), null, node.getLeft(), node.getMiddle());
					parent = new Node(node.getLarge(), null, leftCopy, pushUp);
				}
			}
		
		
		} else {
			
			if (node.getSmall().compareTo(dvd) == 0 || (node.has3Children() && node.getLarge().compareTo(dvd) == 0)) {
				complete = false;
				
			} else if (node.has2Children()) {
				
				if (node.getSmall().compareTo(dvd) > 0) {
					node.setLarge(node.getSmall());
					node.setSmall(dvd);
				} else if (node.getSmall().compareTo(dvd) < 0) {
					node.setLarge(dvd);
				}
			} else {
				parent = split(node, dvd);
			}
		}
		return parent;
	}
	
	
	private Node split(Node current, S value) {
        Node newParent = null;
        
        if (current.getSmall().compareTo(value) > 0){
	        Node left   = new Node(value, null);
	        Node right  = new Node(current.getLarge(), null);
	        newParent   = new Node(current.getSmall(), null, left, right);
        } 
        //when the left key of the current node is lesser than the values
        else if (current.getSmall().compareTo(value) < 0) {
        	// The new element is greater than the current's left only
        	if (current.getLarge().compareTo(value) > 0) {

	            Node left   = new Node(current.getSmall(), null);
	            Node right  = new Node(current.getLarge(), null);
	            newParent   = new Node(value, null, left, right);

        	} else { //when the values is the largest from both the right and left keys
	            Node left   = new Node(current.getSmall(), null);
	            Node right  = new Node(value, null);
	            newParent   = new Node(current.getLarge(), null, left, right);
        	}
        }
        return newParent;
	}


	
//	private void inOrderRec(Node current) {
//        if(current != null) {
//                //when the current node is at the leaf
//                if(current.isLeaf()){
//                        //Displays the left key
//                        System.out.print(current.getSmall().toString()+" ");
//                        //if right key exists then displays it too
//                        if(current.getLarge() != null) System.out.print(current.getLarge().toString()+" ");
//                }
//                else {//if the current node is not at leaf
//                        //traverse to the left child
//                        inOrderRec(current.getLeft());
//                        //Displays the left Key of current after recursive callings
//                        System.out.print(current.getSmall().toString()+" ");
//                        //recursive call for the Middle Child
//                        inOrderRec(current.getMiddle());
//                        //if right key exists
//                        if(current.getLarge() != null) {
//                               //when  node is not at leaf,Displays the right key
//                                if(!current.isLeaf()) 
//                                    System.out.print(current.getLarge().toString()+" ");
//                                inOrderRec(current.getRight());
//                        }
//                }
//        }
//	}
	
	
	  public void preOrderDisplay() {
		    if (!isEmpty()){
		        System.out.println("Pre Order Display of the 2-3 Tree:");
		        preOrderRec(root);
		    }
		    else System.out.println("The tree is empty.");
		}
	  
		    private void preOrderRec(Node current) {
		        if(current != null) {
		            //Displays the Left Key of the current node
		            System.out.print(current.getSmall().toString() + ", ");
		            preOrderRec(current.left);
		            preOrderRec(current.middle);
		            //When right key also exists
		            if (current.getLarge() != null) {
		                //Displays the right Key of the current node
		                System.out.print(current.getLarge().toString() + ", ");
		                preOrderRec(current.right);
		            }
		        }
		} 
		    
//		    public static void inOrder(Node node) {
//				// If the tree node is a leaf
//				if (node.getRight() == null && node.getMiddle() == null && node.getLeft() == null) {
//					
//					// If both data items exist, print both
//					if (node.getSmall() != null && node.getLarge() != null) {
//						System.out.print(node.getSmall() + ", " + node.getLarge() + ", ");
//					// Else, print only the small data item
//					} else {
//						System.out.print(node.getSmall() + ", ");
//					}
//				
//				// Else if the root has two data items (neither are null) - recursively call the method
//				} else if (node.getSmall() != null && node.getLarge() != null) {
//					inOrder(node.getLeft());
//					inOrder(node.getMiddle());
//					inOrder(node.getRight());
//				
//				// Else, there is only one data item present - recursively call the method
//				} else {
//					inOrder(node.getLeft());
//					inOrder(node.getMiddle());
//				}	
//			}   
		    
		    
		    
	public void test(Node node, S dvd) {
		System.out.println(root.getSmall() + " " + root.getSmall().compareTo(dvd));
	}

	public static void main(String[] args) {
		NewTTT tree = new NewTTT();
		
//		tree.insert(tree.root, "h");
//		tree.insert(tree.root, "d");
//		tree.insert(tree.root, "a");
//		tree.insert(tree.root, "s");
//		tree.insert(tree.root, "t");
//		tree.insert(tree.root, "u");

		tree.insert("h");
		tree.insert("d");
		tree.insert("a");
		tree.insert("s");
		tree.insert("t");
		tree.insert("u");
		tree.insert("i");
		
//		tree.insert(4);
//		tree.insert(7);
//		tree.insert(8);
//		tree.insert(6);
//		tree.insert(2);
//		tree.insert(9);
//		tree.insert(10);
		
		tree.preOrderDisplay();
//		tree.inOrder(tree.root);
//		tree.test(tree.root, "t");
		
	}
	

}
