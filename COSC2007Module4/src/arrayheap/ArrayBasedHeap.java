package arrayheap;

public class ArrayBasedHeap {
	private int MAX_HEAP = 100;
	private String[] items; // array of heap items private 
	int size;

	
	public ArrayBasedHeap() {
		items = new String[MAX_HEAP];
		size = 0;
	}

	
	public boolean heapIsEmpty() {
		return size == 0; 
	}
	
	
	public void heapInsert(String newItem) throws HeapException {
	// Method: Inserts the new item after the last item in the heap and trickles it up to
	// its proper position. The heap is full when it contains MAX_HEAP items. 
	
		if (size >= MAX_HEAP)
			throw new HeapException("HeapException: Heap full");
		
		items[size] = newItem; // place the new item at the end of the heap // trickle new item up to its proper position
		int place = size;
		int parent = (place - 1)/2;
		
		while ( (parent >= 0) && (items[place].compareTo (items[parent]) )>0) { // swap items[place] and items[parent]
			String temp = items[parent];
			items[parent] = items[place];
			items[place] = temp; place = parent;
			parent = (place - 1)/2; 
		} // end while
		++size;
	} // end heapInsert
	
	
	public String heapDelete() {
		// delete the item in the root of a heap
		String rootItem = null;
		
		if (!heapIsEmpty()) {
			rootItem = items[0]; items[0] = items[--size]; heapRebuild(0);
		}
		return rootItem; 
	}
	
	
	protected void heapRebuild(int root) { // if the root is not a leaf and the root's search key is less than the larger
		// of the search keys in the root's children
		int child = 2 * root + 1; // index of root's left child, if any 
		
		if ( child < size ) { // root is not a leaf, so it has a left child at child
			int rightChild = child + 1; // index of right child, if any // if root has a right child, find larger child
		
			if ((rightChild < size) && (items[rightChild].compareTo(items[child])) > 0)
				child = rightChild; // index of larger child
		
			// if the root's value is smaller than the value in the larger child, swap values 
			if ( items[root].compareTo( items[child])<0 ) {
				String temp = items[root];
				items[root] = items[child];
				items[child] = temp;
				// transform the new subtree into a heap 
				heapRebuild(child);
			}
		}
		// if root is a leaf, do nothing 
	}
	
	
	public void print() {
		System.out.print("TablePrint: ");
		for (int i = 0; i < size; i++) {
			System.out.print(items[i] + ", ");
		}
	}
	
	
	public static void main(String[] args) throws HeapException {
		ArrayBasedHeap ahb = new ArrayBasedHeap();
		
		System.out.println("Is the table empty? " + ahb.heapIsEmpty());
		
		ahb.heapInsert("Toronto");
		ahb.heapInsert("Vancouver");
		ahb.heapInsert("Halifax");
		ahb.heapInsert("Montreal");
		ahb.heapInsert("Quebec City");
		ahb.heapInsert("Saskatoon");
		ahb.heapInsert("Regina");
		ahb.heapInsert("Selkirk");
		
		System.out.println();
		ahb.print();
		
		System.out.println("\n\nDeleting an item: " + ahb.heapDelete());
		
		System.out.println();
		ahb.print();
		
	}
}





















//package arrayheap;
//
//public class ArrayBasedHeap {
//	private int MAX_HEAP = 100;
//	private KeyedItem[] items; // array of heap items private 
//	int size;
//
//	public ArrayBasedHeap() {
//		items = new KeyedItem[MAX_HEAP];
//		size = 0;
//	}
//
//	public boolean heapIsEmpty() {
//		return size == 0; 
//	}
//	
//	public void heapInsert(KeyedItem newItem) throws HeapException {
//	// Method: Inserts the new item after the last item in the heap and trickles it up to
//	// its proper position. The heap is full when it contains MAX_HEAP items. 
//	
//		if (size >= MAX_HEAP)
//			throw new HeapException("HeapException: Heap full");
//		
//		items[size] = newItem; // place the new item at the end of the heap // trickle new item up to its proper position
//		int place = size;
//		int parent = (place - 1)/2;
//		
//		while ( (parent >= 0) && (items[place].getKey().compareTo (items[parent].getKey()) )>0) { // swap items[place] and items[parent]
//			KeyedItem temp = items[parent];
//			items[parent] = items[place];
//			items[place] = temp; place = parent;
//			parent = (place - 1)/2; 
//		} // end while
//		++size;
//	} // end heapInsert
//	
//	public KeyedItem heapDelete() {
//		// delete the item in the root of a heap
//		KeyedItem rootItem = null;
//		
//		if (!heapIsEmpty()) {
//			rootItem = items[0]; items[0] = items[--size]; heapRebuild(0);
//		}
//		return rootItem; 
//	}
//	
//	protected void heapRebuild(int root) { // if the root is not a leaf and the root's search key is less than the larger
//		// of the search keys in the root's children
//		int child = 2 * root + 1; // index of root's left child, if any 
//		
//		if ( child < size ) { // root is not a leaf, so it has a left child at child
//			int rightChild = child + 1; // index of right child, if any // if root has a right child, find larger child
//		
//			if ((rightChild < size) && (items[rightChild].getKey().compareTo(items[child].getKey())) > 0)
//				child = rightChild; // index of larger child
//		
//			// if the root's value is smaller than the value in the larger child, swap values 
//			if ( items[root].getKey().compareTo( items[child].getKey())<0 ) {
//				KeyedItem temp = items[root];
//				items[root] = items[child];
//				items[child] = temp;
//				// transform the new subtree into a heap 
//				heapRebuild(child);
//			}
//		}
//		// if root is a leaf, do nothing 
//	}
//	
//	public static void main(String[] args) throws HeapException {
//		ArrayBasedHeap ahb = new ArrayBasedHeap();
//		
//		ahb.heapInsert("Toronto");
//	}
//}