package demoheaparray;

public class Heap {

	private int MAX_HEAP =100;
	private KeyedItem[] items; // array of heap items 
	private int size; // number of heap items

	public Heap() {
		items = new KeyedItem[MAX_HEAP]; 
		size = 0;
	}

	public boolean heapIsEmpty() {
		return size == 0; 
	}

	public void heapInsert(KeyedItem newItem) throws HeapException {
		// Method: Inserts the new item after the last item in the heap and trickles it up to
		// its proper position. The heap is full when it contains MAX_HEAP items.
		
		if (size >= MAX_HEAP)
			throw new HeapException("HeapException: Heap full");
		
		items[size] = newItem;
		int place = size;
		int parent = (place - 1)/2;
		
		while ( (parent >= 0) && (items[place].getKey().compareTo(items[parent].getKey()) )>0) {
			KeyedItem temp = items[parent];
			items[parent] = items[place];
			items[place] = temp; place = parent;
			parent = (place - 1)/2; 
		}
		++size;
	}
	
	public KeyedItem heapDelete() {
		KeyedItem rootItem = null;
		if (!heapIsEmpty()) {
			rootItem = items[0]; 
			items[0] = items[--size]; 
			heapRebuild(0);
		}
		return rootItem; 
	}
	
	protected void heapRebuild(int root) {

		int child = 2 * root + 1;
		
		if ( child < size ) { 
			int rightChild = child + 1; 
		
		if ( (rightChild < size) && (items[rightChild].getKey().compareTo(items[child].getKey()) )>0)
			child = rightChild;
		
		// if the root's value is smaller than the value in the larger child, swap values 
		if ( items[root].getKey().compareTo( items[child].getKey())<0 ){
			KeyedItem temp = items[root];
			items[root] = items[child];
			items[child] = temp;
			heapRebuild(child);
		}
	
	} 
}
	
	
	
	
	
	
	public static void main(String[] args) {
		Heap heap = new Heap();
//		KeyedItem ki = new KeyedItem();
		
//		heap.heapInsert(KeyedItem);
	}
}