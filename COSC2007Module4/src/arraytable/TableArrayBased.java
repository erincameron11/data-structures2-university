package arraytable;

public class TableArrayBased {
	
	final int MAX_TABLE = 100; // maximum size of table 
	protected String [] items; //table item
	private int size; // table size

	// No-arg constructor
	public TableArrayBased() {
		items = new String[MAX_TABLE];
		size = 0;
	}

	
	public boolean tableIsEmpty() {
		return size == 0;
	}
	
	
	public void tableInsert(String newItem) throws TableException { // Note: Insertion is unsuccessful if the table is full,
		// that is, if the table already contains MAX_TABLE items. // Calls: position.
		if (size == MAX_TABLE)
			throw new TableException("TableException: Table full");
		// there is room to insert; locate the position where newItem belongs 
		int spot = position(newItem);
		if ((spot < size) && (items[spot]).compareTo(newItem) == 0) { // duplicate key
			throw new TableException("TableException: Duplicate Key item");
		} else {
			// shift up to make room for the new item
			for (int index = size - 1; index >= spot; --index)
				items[index + 1] = items[index];
			// make the insertion 
			items[spot] = newItem;
			++size;
		}
	}
	

	public boolean tableDelete(String SearchKey) {
		// locate the position where SearchKey exists/belongs 
		int spot = position(SearchKey);
		
		// is SearchKey present in the table? 
		boolean success = (spot <= size) && (items[spot].compareTo(SearchKey)==0);
		if (success) // SearchKey in Table {
			--size; // delete the item & shift down to fill the gap
		
		for (int index = spot; index < size; ++index) {
			items[index] = items[index+1];
		}
			return success;

	}

	
	public String tableRetrieve(String searchKey) {
		// locate the position where SearchKey exists/belongs
		int spot = position(searchKey); // Calls: position.
		
		// is searchKey present in table? 
		boolean success = (spot <= size) && (items[spot].compareTo(searchKey) == 0);
		
		if (success)
			return items[spot]; // item present; retrieve it
		else
			return null;
	}

	
	protected int position(String searchKey) {
		// find the position of a table item or insertion point
		int pos = 0;
		while ((pos < size) && (searchKey.compareTo(items[pos]) > 0))
			pos++;
		return pos;
	}
	
	
	public void print() {
		System.out.print("TablePrint: ");
		for (int i = 0; i < size; i++) {
			System.out.print(items[i] + ", ");
		}
	}
	
	
	public static void main(String[] args) throws TableException {
		TableArrayBased tab = new TableArrayBased();
		
		System.out.println("Is the table empty? " + tab.tableIsEmpty());

		
		tab.tableInsert("Toronto");
		tab.tableInsert("Vancouver");
		tab.tableInsert("Halifax");
		tab.tableInsert("Montreal");
		tab.tableInsert("Quebec City");
		tab.tableInsert("Saskatoon");
		tab.tableInsert("Regina");
		tab.tableInsert("Selkirk");
		
		System.out.print("\nDoes the table contain 'Tofino'? " + tab.tableRetrieve("Tofino"));
		
		System.out.println("\n");
		tab.print();
		
		System.out.println("\n\nDeleting 'Regina': " + tab.tableDelete("Regina"));
		
		System.out.println();
		tab.print();
		
	}
}