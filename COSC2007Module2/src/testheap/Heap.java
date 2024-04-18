package testheap;

import java.util.ArrayList; 
import java.util.Comparator;

public class Heap<T> {

	private ArrayList<T> items;
	private Comparator<? super T> comparator;
	
	public Heap() {
		items = new ArrayList<T>();
	}

	public Heap(Comparator<? super T> comparator) { 
		items = new ArrayList<T>();
		this.comparator = comparator;
  }


	public boolean heapIsEmpty() {
		return items.size()==0; 
	}
	
	public void heapInsert(T newItem) throws HeapException, ClassCastException {
	
		if (!items.add(newItem)) {
			throw new HeapException("HeapException: heapInsert failed");
		
		} else {
		// trickle new item up to its proper position 
			int place = items.size()-1;
			int parent = (place - 1)/2;
			while ((parent >= 0) && (compareItems(items.get(place), items.get(parent))) < 0) { // swap items[place] and items[parent]
				T temp = items.get(parent);
				items.set(parent, items.get(place));
				items.set(place, temp);
			    place = parent;
			    parent = (place - 1)/2; 
			} 
		}
		  
	}
	
	
	public T heapDelete() {
	
		T rootItem = null; 
		int loc;
	
		if (!heapIsEmpty()) {
			rootItem = items.get(0);
			loc = items.size()-1;
			items.set(0, items.get(loc));
			items.remove(loc);
			heapRebuild(0);
		} // end if
		return rootItem; 
	} // end heapDelete
	
	
	
	protected void heapRebuild(int root) {
		int child = 2 * root + 1;
		
		if ( child < items.size() ) {
			int rightChild = child + 1; // index of right child,
		
			if ((rightChild < items.size()) && (compareItems(items.get(rightChild),items.get(child))) < 0) {
				child = rightChild;    // index of larger child
			}
			
			
			if (compareItems(items.get(root), items.get(child)) > 0) {
				T temp = items.get(root); 
				items.set(root, items.get(child)); 
				items.set(child, temp);
				heapRebuild(child);
			}
		
		}
	  }

	
	@SuppressWarnings("unchecked")
	private int compareItems(T item1, T item2) {
		if (comparator == null) {
			return ((Comparable <T>)item1).compareTo(item2); 
		} else {
			return comparator.compare(item1, item2); 
		}
	}

	
	public void print() {
		System.out.println(items.toString());
	}
	
	
}