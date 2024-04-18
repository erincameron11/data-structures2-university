package labfive;

public class PriorityQueue {

	// Initialize class-wide variables
	public static int[] heap = new int[50];
	public static int size = -1;
	
	
	public PriorityQueue() {
		heap = new int[50];
		size = -1;
	}
	
	
	/** Method to calculate the parent element */
	public static int parent(int i) {
		return (i - 1) / 2;
	}


	/** Method to calculate the right child element */
	public static int lChild(int i) {
		return (2 * i) + 1;
	}
	
	
	/** Method to calculate the right child element */
	public static int rChild(int i) {
		return (2 * i) + 2;
	}
	
	// Added for final exam
	public static boolean pqIsEmpty() {
		return size == -1;
	}
	
	/** Method for swapping elements in the heap */
	public static void swap(int element, int swapper) {
		int temp = heap[element];
		heap[element] = heap[swapper];
		heap[swapper] = temp;
	}
	
	
	/** Method for shifting elements up in the heap */
	public static void shiftUp(int element) {
		
		// Loop through the heap
		while (element > 0 && heap[parent(element)] < heap[element]) {
			swap(parent(element), element);
			element = parent(element);
		}
	}
	
	
	/** Method for shifting elements up in the heap */
	public static void shiftDown(int element) {
			
		int maxIndex = element;
		int left = lChild(element);
		int right = rChild(element);
		
		// Check the left child
		if (left <= size && heap[left] > heap[maxIndex]) {
			maxIndex = left;
		}
		
		// Check the right child
		if (right <= size && heap[right] > heap[maxIndex]) {
			maxIndex = right;
		}
		
		// If the element does not equal the index
		if (element != maxIndex) {
			swap(element, maxIndex);
			shiftDown(maxIndex);
		}
	}
	
	
	/** Method to insert an element into the heap */
	public static void insert(int element) {
		size++;
		heap[size] = element;
		
		// Make sure to shift up
		shiftUp(size);
	}
	
	
	/** Method to remove an element from the heap */
	public static void remove(int element) {
		heap[element] = getMax() + 1;
		shiftUp(element);
		extractMax();
	}
	
	
	/** Method to extract the maximum priority value from the heap */
	public static int extractMax() {
		int result = heap[0];
		heap[0] = heap[size];  // Replace the root with the last leaf in array
		size--;
		shiftDown(0);  // Shift down to correct placement in heap
		return result;
	}
	
	
	/** Method to get the maximum value from the heap - returns index 0 */
	public static int getMax() {
		return heap[0];  // Because the largest element is always at index 0
	}
	
	
	/** Method to change the priority of an element in the heap */
	public static void changePriority(int index, int priority) {
		// Change the value of the priority at that index
		int indexOld = heap[index];  // Store the value of the old priority
		heap[index] = priority;
		
		if (priority > indexOld) {
			shiftUp(index);  // move the element upwards in the PQ
		} else {
			shiftDown(index);
		}
	}
	
	
	/** Method to print out the PQ */
	public static void print() {
		int i = 0;
		while (i <= size) {
			System.out.print(heap[i] + " ");
			i++;
		}
	}
	
	
	/** Method to return the size of the PQ */
	public static int size() {
		return size;
	}
	
	
	/** Main Method */
	public static void main(String[] args) {

		// Insert values into the heap
		insert(45);
		insert(20);
		insert(14);
		insert(12);
		insert(31);
		insert(7);
		insert(11);
		insert(13);
		insert(7);
		
		// Display the queue
		System.out.print("Priority Queue: ");
		print();
		
		// Display the maximum priority value
		System.out.println("\nMaximum priority: " + extractMax());
		
		// Display the heap after getting the max value
		System.out.print("After extracting maximum: ");
		print();
		
		// Change index 2 priority and display heap
		System.out.print("\nAfter changing index 2's priority: ");
		changePriority(2, 49);
		print();
		
		// Remove index 3 element and then display the heap
		System.out.print("\nAfter removing element at index 3: ");
		remove(3);
		print();
		
	}

}
