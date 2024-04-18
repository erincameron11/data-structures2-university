package testheap;

public class TestPQHeap {

	public static void main(String[] args) throws ClassCastException, HeapException {
		PriorityQueue<Integer> link = new PriorityQueue<Integer>();
		Heap<Integer> heap = new Heap<Integer>();
		
		heap.heapInsert((Integer)16);
		heap.heapInsert((Integer)56);
		heap.heapInsert((Integer)1);
		heap.heapInsert((Integer)6);
		System.out.println(heap.heapIsEmpty());
		heap.print();
		
//		System.out.println(pq.equals(pq));
		heap.heapDelete();
		heap.print();
		
		
		

	}

}
