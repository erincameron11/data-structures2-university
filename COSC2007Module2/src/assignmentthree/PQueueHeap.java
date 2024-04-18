package assignmentthree;

public class PQueueHeap implements PriorityQueue {

	private static int MAX_HEAP = 10000;
	private static int[] heap;
	private static int size;
	
	// Constructor
	public PQueueHeap() {
		heap = new int[MAX_HEAP];
		size = -1;
	}
	
	
	/** Method to check whether the PQ is empty or not 
	 * @return boolean whether the queue is empty or not */
	@Override
	public boolean isEmpty() {
		return size < 0;  // Account for when the queue is set to -1
	}

	
	/** Method to return the size of the PQ 
	 * @return integer size of the items in the queue */
	@Override
	public int size() {
		return size;
	}

	
	/** Method for inserting an item into the queue 
	 * @param accepts a priority value integer */
	@Override
	public void insert(int x) {
		size++;
		heap[size] = x;
		
		// Make sure to move the element up to appropriate place in the queue
		moveUp(size);
	}
	
	
	/** Method to calculate the parent of an element */
	public static int parent(int element) {
		return ((element - 1) / 2);
	}
	
	
	/** Method for shifting elements upward in the heap */
	public static void moveUp(int element) {
		
		// Loop through the heap
		while (element > 0 && heap[parent(element)] > heap[element]) {
//			swap(parent, element);
			int temp = heap[parent(element)];
			heap[parent(element)] = heap[element];
			heap[element] = temp;
			
			element = parent(element);
		}
	}
	
	
	/** Method for shifting elements down the heap */
	public static void moveDown(int element) {
			
		int index = element;
		int left = ((2 * element) + 1);
		int right = ((2 * element) + 2);
		
		// Check the left child
		if (left <= size && heap[left] > heap[index]) {
			index = left;
		}
		
		// Check the right child
		if (right <= size && heap[right] > heap[index]) {
			index = right;
		}
		
		if (element != index) {
			// Swap the element and the index value
			int temp = heap[element];
			heap[element] = heap[index];
			heap[index] = temp;
			
			moveDown(index);
		}
	}
	

	/** Method to delete the highest priority node (lowest integer value) 
	 * @return integer value of deleted item */
	@Override
	public int delete() throws EmptyPQException {
		
		if (!isEmpty()) {
			int removed = heap[0];  // Save the value of heap[0] to return later
			
			heap[0] = heap[0] + 1;
			moveUp(0);
			
			heap[0] = heap[size];  // Replace the root with the last leaf in the array
			size--;  // Decrease the size to "remove" the element from the heap
			moveDown(0);
			
			return removed;
		
		} else {
			throw new EmptyPQException("EmptyPQException: Priority Queue is empty.");
		}
	}
	
	
	/** Method to print the queue */
	public void print() {
		int i = 0;
		while (i <= size) {
			System.out.print(heap[i] + " ");
			i++;
		}
	}

	
	/** Method to empty the heap */
	@Override
	public void makeEmpty() {
		heap = new int[MAX_HEAP];
		size = -1;
	}

}
