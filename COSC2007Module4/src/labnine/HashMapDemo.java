package labnine;

import java.util.HashMap;

public class HashMapDemo {

    /** Method that will create a hashmap from an array */
    static void newHashMap(int[] array) {

    	// Create a hashmap with 2 integer values
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
 
        // Traverse through the given array
        for (int i = 0; i < array.length; i++) {
 
            Integer count = hash.get(array[i]);
 
            if (hash.get(array[i]) == null) {
            	hash.put(array[i], 1);
            
            // Duplicate value - instead of adding, just increase the count
            } else {
            	count++;
            	hash.put(array[i], count);
            }
        }
 
        // Display the HashMap
        System.out.println(hash);
    }
 
    /** Main Method */
    public static void main(String[] args) {
        int[] array = {23, 45, 6, 89, 5, 23, 5, 6};
        newHashMap(array);
    }

}
