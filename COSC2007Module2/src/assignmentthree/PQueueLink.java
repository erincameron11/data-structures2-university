package assignmentthree;

public class PQueueLink implements PriorityQueue {

	/** Inner Node Class */
	public class Node {
		private int priority;
		private Node next;
		
		Node(int priority) {
			this.priority = priority;
			next = null;
		}
	}
	
	
	// Initialize variable for the root node
	Node root;
	
	
	/** Method to check whether the PQ is empty or not 
	 * @return boolean whether the queue is empty or not */
	@Override
	public boolean isEmpty() {
		return root == null;
	}

	
	/** Method to return the size of the PQ 
	 * @return integer size of the items in the queue */
	@Override
	public int size() {
		Node temp = root;
		
		int count = 1;  // Starting at 1 to account for zero indexing
		while (temp.next != null) {
			temp = temp.next;
			count++;
		}
		return count;
	}

	
	/** Method for inserting an item into the queue 
	 * @param accepts a priority value integer */
	@Override
	public void insert(int x) {
		
		Node newNode = new Node(x);
		Node temp = root;
		
		// If the list is empty
		if (root == null) {
			root = newNode;
		}
		
		// If the value of the new node is less than the current head of the queue
		else if (temp.priority > x) {
			newNode.next = temp;
		    temp = newNode;
		    root = temp;
		
		} else {
			// Traverse the list until you find the correct place to put the new node
			 while (temp.next != null && temp.next.priority < x) {
				 temp = temp.next;
			 }
			 
			 newNode.next = temp.next;
			 temp.next = newNode;
			 temp = root;
		}	
	}

	
	/** Method to delete the highest priority node (lowest integer value) 
	 * @return integer value of deleted item */
	@Override
	public int delete() throws EmptyPQException {
		
		if (!isEmpty()) {
			// Store the current root to return at the end of the delete method
			Node temp = root;
			
			// Change the reference of the root to the next item (essentially this deletes the node by dereferencing it)
			root = root.next;  
		    
			// Return the priority of the deleted node
		    return temp.priority;  
		} else {
			throw new EmptyPQException("EmptyPQException: Priority Queue is empty.");
		}
	}

	
	/** Method to make the PQ empty */
	@Override
	public void makeEmpty() {
		root = null;  // Just change the reference of root to do this
	}
	
	
	/** Method to print the queue */
	public void print() {
		Node temp = root;

		if (!isEmpty()) {

		    while(temp.next != null){
		    	System.out.print(temp.priority + " ");
		        temp = temp.next;
		    }
		    System.out.println(temp.priority);
		
		} else {
			System.out.println("Print function: Priority Queue is empty.");
		}
	}


}
