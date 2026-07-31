package ARRAYS.MEDIUM;

import java.util.HashMap;

class Two_Sum_optimal {
    
    public String twoSumExists(int[] arr, int target) {         // Variant 1: Check if two numbers sum to target using hashing

        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < arr.length; i++) {
            int otherelement = target - arr[i];             // if firstelement  is [i], then second must be ->> target - [i]
           
            if (map.containsKey(otherelement)) {         // Check if otherelement exists in map
                return "YES";  // Pair found
            }
            
            map.put(arr[i], i);                     // if not found , then Store current element and its index for future uses
        }
        return "NO";
    }

    
    public int[] twoSumIndices(int[] arr, int target) {       // Variant 2: Return indices of two numbers that sum to target using hashing

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];
            
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };            // returning indices of both element
            }
           
            map.put(arr[i], i);
        }
        
        return new int[] { -1, -1 };
    }
}
class Main {
    public static void main(String[] args) {
        Two_Sum_optimal sol = new Two_Sum_optimal();
        int[] arr = {2, 6, 5, 8, 10};
        int target = 12;

        System.out.println(sol.twoSumExists(arr, target));
        int[] res = sol.twoSumIndices(arr, target);
        System.out.println("[" + res[0] + ", " + res[1] + "]");
    }
}
