package labten;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetDemo {

	public static void main(String[] args) {
		// Create a linked hashset object
		HashSet<String> hash = new HashSet<String>();
		
		// Insert values
		hash.add("Ontario");
		hash.add("British Colombia");
		hash.add("Alberta");
		hash.add("Manitoba");
		
		// Display the hashset
		System.out.println("HashSet after insertion: " + hash);
		
		// Check if Alberta is present
		System.out.println("\nDoes the hashset contain 'Alberta'? " + hash.contains("Alberta"));
		
		// Attempt to insert duplicate
		hash.add("Ontario");
		System.out.println("\nHashSet after inserting a duplicate: " + hash);
				
		// Remove Manitoba
		hash.remove("Manitoba");
		
		// Display the hashset again
		System.out.println("\nHashSet after removing 'Manitoba': " + hash);
		
		// Iterator to iterate over list
		Iterator<String> it = hash.iterator();
		System.out.print("\nIterating over the list: ");
		while (it.hasNext()) {
			System.out.print(it.next() + ", ");
		}

	}

}
