package arraytable;

public interface TableInterface {

	public boolean tableIsEmpty(); // Determines whether a table is empty public int tableLength( ); // Determines the number of items in a table public void tableInsert(KeyedItem newItem) throw TableException; public boolean tableDelete(Comparable searchKey);

	public KeyedItem tableRetrieve(Comparable SearchKey) ; 
	
} //end TableInterface