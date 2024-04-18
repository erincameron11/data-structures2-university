package assignmentthree;

public class TestPQ {

	public static void main(String[] args) throws EmptyPQException {
		
		// Create instances of both heap and link PQs
		PQueueLink link = new PQueueLink();
		PQueueHeap heap = new PQueueHeap();
		
		// Generate 10,000 integers and fill the array with these numbers
		int[] array = new int[10000];
		
		for (int i = 0; i < array.length; i++) {
			array[i] = (int)(Math.random() * 10000);
		}
		
		
		// HEAP ADD-------------------------------------------------------------
		
		// Time at the beginning of the addition into the heap
		long startHeap = System.currentTimeMillis();
		
		// Add elements into the heap PQ
		for (int i = 0; i < array.length; i++) {
			heap.insert(array[i]);
		}
		
		long timePassedHeap = System.currentTimeMillis() - startHeap;

		
		
		// LINK ADD-------------------------------------------------------------
		
		// Time at the beginning of the addition into the linked list PQ
		long startLink = System.currentTimeMillis();
		
		// Add elements into the link PQ
		for (int i = 0; i < array.length; i++) {
			link.insert(array[i]);
		}
	
		long timePassedLink = System.currentTimeMillis() - startLink;
	
		// Display Addition of integers results
		System.out.println("The total time for the heap insert of 10,000 integers: " + timePassedHeap + "ms");
		System.out.println("The total time for the link insert of 10,000 integers: " + timePassedLink + "ms");
				
				
		
		// HEAP PRINT-------------------------------------------------------------
			
		// Display heap and link by printing each value - time these print operations to display later
		System.out.print("\nHeap Priority Queue: ");
		long startHeapPrint = System.currentTimeMillis();
		heap.print();
		long timePassedHeapPrint = System.currentTimeMillis() - startHeapPrint;
		
		
		// LINK PRINT-------------------------------------------------------------
		
		System.out.print("\nLink Priority Queue: ");
		long startLinkPrint = System.currentTimeMillis();
		link.print();
		long timePassedLinkPrint = System.currentTimeMillis() - startLinkPrint;
		
		// Display results for print
		System.out.println("\nThe total time for heap to print: " + timePassedHeapPrint + "ms");
		System.out.println("The total time for link to print: " + timePassedLinkPrint + "ms");
		
		
		
		// HEAP DELETE -------------------------------------------------------------
		// Time at the beginning of the deletion from the heap PQ
		long startHeapDel = System.currentTimeMillis();
						
		// Delete 5 highest priority items from the heap PQ
		for (int i = 0; i < 50; i++) {
			heap.delete();
		}

		long timePassedHeapDel = System.currentTimeMillis() - startHeapDel;
		
		
		// LINK DELETE -------------------------------------------------------------
		
		// Time at the beginning of the deletion from the linked list PQ
		long startLinkDel = System.currentTimeMillis();
				
		// Delete 5 highest priority items from the link PQ
		for (int i = 0; i < 50; i++) {
			link.delete();
		}

		long timePassedLinkDel = System.currentTimeMillis() - startLinkDel;
		
		// Display results for delete
		System.out.println("\nThe total time for heap to delete 50 items: " + timePassedHeapDel + "ms");
		System.out.println("The total time for link to delete 50 itesm: " + timePassedLinkDel + "ms");

	}

}
