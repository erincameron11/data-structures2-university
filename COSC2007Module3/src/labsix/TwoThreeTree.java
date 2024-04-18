// https://indispensablepc.wordpress.com/2017/03/27/2-3-tree-insertion-algorithm-in-java/
package labsix;

public class TwoThreeTree {
	
	/** Inner Node Class */
	public class Node {
		private Integer data1;  // First and second data items
		private Integer data2;
		
		private Node left;  // Reference variables for left, right and mid
		private Node mid;
		private Node right;
		
		// Constructor for initializing data1 with data
		Node(Integer data1) {
			this.data1 = data1;
			data2 = null;
			left = mid = right = null;
		}
		
		// Constructor for initializing data1 and data2 with data
		Node(Integer data1, Integer data2) {
			this.data1 = data1;
			this.data2 = data2;
			left = mid = right = null;
		}
	}
	
	// Initialize variables for class
	Node node;
	Integer itemOne;
	Integer itemTwo;
	
	TwoThreeTree left;
	TwoThreeTree right;
	TwoThreeTree mid;
	
	
	/** Method to insert an item into the 2-3 tree recursively */
	public void insert(Node node, Integer element) {
	    
		Integer parent = (element - 1) / 2;

	    // If the node we are looking at is a leaf
	    if ((left == null) && (mid == null) && (right == null)) {
	       
	    	// If the node we are looking at only has ONE data item filled
	    	// and data2 is empty (null)
	    	if (node.data2 == null) {
	    		// Check the contents of the element and proceed accordingly
	    		// depending on the comparison values
	            if (itemOne.compareTo(element) <= 0) {    
	                this.itemTwo = element;
	            } else {            
	                this.itemTwo = itemOne;
	                this.itemOne = element;
	            }
	            
	        // Else, the node has a data2 item (is NOT null), and we must split the node data
	        } else {               
	            split(element);
	            
	            // Move the element upward if the parent is not null
	            // When we split we move the middle item upwards of the node
	            if (parent != null) {   
	                this.moveUp(this);
	            }
	        }
	        return;
	    }

	    // If the node is not a leaf, we continue on
	    if (itemOne > element) {     
	        left.insert(node, element);
	    
	    // If the second item is null then we just insert the element into this place
	    } else if (itemTwo == null) {    
	        right.insert(node, element);
	    
	    // Else we determine if we should insert in the mid or right location
	    } else {             
	        if (itemTwo.compareTo(element) > 0) {   
	            mid.insert(node, element);
	        } else {        
	            right.insert(node, element);
	        }
	    }
	}
	
	
	public void split(Integer element) {
		
	}

	public void moveUp(TwoThreeTree i) {
		
	}
	
	
	/** Main Method */
	public static void main(String[] args) {
		

	}

}
