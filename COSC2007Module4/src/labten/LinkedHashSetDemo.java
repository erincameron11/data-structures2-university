package labten;

import java.util.LinkedHashSet;

public class LinkedHashSetDemo {

	public static void main(String[] args) {
		// Create a linked hashset object
		LinkedHashSet<String> link = new LinkedHashSet<String>();
		
		// Insert values
		link.add("Ontario");
		link.add("British Colombia");
		link.add("Alberta");
		link.add("Manitoba");
		
		// Display the size
		System.out.println("The size of the linked hashset after insertion: " + link.size());
		
		// Display the linked hashset
		System.out.println("\nLinked HashSet: " + link);
		
		// Try to add duplicates
		link.add("Ontario");
		
		// Display the size
		System.out.println("\nThe size of the linked hashset after attempt to insert duplicate: " + link.size());
		
		// Display the linked hashset
		System.out.println("\nLinked HashSet: " + link);
		
		// Check if Alberta is present
		System.out.println("\nDoes the link hashset have 'Alberta'? " + link.contains("Alberta"));
		
		// Remove Manitoba
		link.remove("Manitoba");
		
		// Display the linked hashset
		System.out.println("\nLinked HashSet after removal of 'Manitoba': " + link);
		
		
	}

}
