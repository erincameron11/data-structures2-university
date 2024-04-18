package labnine;

import java.util.LinkedHashMap;

public class LinkHashMapDemo {

	public static void main(String[] args) {
        // Create a linked hashmap object
		LinkedHashMap<Integer, String> link = new LinkedHashMap<Integer, String>();
       
		// Inserting index values and corresponding telephone numbers in string format
		link.put(0, null);  // Testing inserting a null value
		link.put(1, "9054348978");
        link.put(2, "7058897654");
        link.put(3, "4897634524");
        link.put(4, "4897634524");
        link.put(6, "4165567343");
        link.put(9, "8002662001");
        link.put(7, "1234567890");
        link.put(8, "7896654132");
   
        // Display the link hashmap 
        System.out.println(link);
   
        // Check if there is a value at index 5
        System.out.println("Contains key 5? " + link.containsKey(5));
        
        // Remove key 8
        System.out.println("Remove key 8: " + link.remove(8));
        
        // Display elements again
        System.out.println(link);
        
        // Check if the map is empty
        System.out.println("Is the map empty? " + link.isEmpty());
        
        // Check the size of the map
        System.out.println("Size of the map: " + link.size());
        
        // Get the value for key 6
        System.out.println("Value of key 6? " + link.get(6));
        
        // Check if contains value null
        System.out.println("Contains value 'null'? " + link.containsValue(null));
        
    }

}
