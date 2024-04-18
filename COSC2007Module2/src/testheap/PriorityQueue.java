package testheap;

import java.util.Comparator;

public class PriorityQueue<T> { 
	private Heap<T> h;

	public PriorityQueue() { 
		h = new Heap<T>();
	} 

	public PriorityQueue(Comparator<? super T> comparator) { 
		h = new Heap<T>(comparator);
  
	} 

	public boolean pqIsEmpty() {
		return h.heapIsEmpty(); 
	} 
	
	public void pqInsert(T newItem) throws PriorityQueueException { 
		try {
			h.heapInsert(newItem); 
		} 
		catch (HeapException e) {
			throw new PriorityQueueException("PQueueException: Problem inserting to Priority Queue");
	    } 
	  }
	
	public T pqDelete() { 
		return h.heapDelete();
	} 
} 