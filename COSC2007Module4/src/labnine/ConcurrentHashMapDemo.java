package labnine;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {

	public static void main(String[] args) {
		// Create a concurrent hashmap object
		ConcurrentHashMap<Integer, String> concurr = new ConcurrentHashMap<Integer, String>();
		
		// Insert pet names
		concurr.put(0, "Spot");
		concurr.put(1, "Patches");
		concurr.put(6, "Spike");
		concurr.put(3, "Bailey");
		concurr.put(4, "Ginger");
		concurr.put(2, "Coco");
		concurr.put(5, "Reggie");
		concurr.put(7, "Penny");
		concurr.put(8, "Tia");
		concurr.put(10, "Tiger");
		

		// Display the hashmap
		System.out.println("Original\nHash Map: " + concurr);

		// Attempting to insert the name "Spot" if it's absent in the list
		concurr.putIfAbsent(11, "Spot");
		
		// Attempting to insert into index 11 again with another name
		concurr.putIfAbsent(11, "Gia");

		// Display the hashmap
		System.out.println("\nAttempted to putIfAbsent into 11 'Spot', and then again into 11 'Gia': ");
		System.out.println("Hash Map: " + concurr);

		// Remove the name Spike from the list
		concurr.remove(6, "Spike");

		// Display the hashmap
		System.out.println("\nRemoved 'Spike': ");
		System.out.println("Hash Map: " + concurr);

		// Replace 10 from "Tiger" to a different pet name
		concurr.replace(10, "Tiger", "Zoey");

		// Display the hashmap
		System.out.println("\nReplaced 10 'Tiger' with 'Zoey': ");
		System.out.println("Hash Map: " + concurr);

	}

}
