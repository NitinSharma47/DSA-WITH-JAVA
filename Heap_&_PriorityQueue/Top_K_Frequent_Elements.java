/* 
        Given an integer array arr and an integer k, return the K elements that occur most frequently.
        Example:

        arr = [1, 1, 1, 2, 2, 3]
        k = 2

        Frequency:
        1 → 3 times
        2 → 2 times
        3 → 1 time

        Therefore:  Top 2 frequent = [1, 2]
        The order of the answer generally doesn't matter unless the problem specifically says it does.

        *APPROACH ->
                        Top K Frequent
                            ↓
                        Count frequency
                            ↓
                        HashMap
                            ↓
                        Need K highest frequencies
                            ↓
                        Min Heap of size K 
*/
import java.util.*;

public class Top_K_Frequent_Elements {
    public static int[] topKFrequent(int[] arr, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();                        // Step 1: Count frequency

        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));     // Step 2: Min Heap based on frequency

// *Means, compare priority (smallest) b/w two numbers ,based on map.get(a) and map.get(b), which of both of them have small value(frequency) 
// *will be added first to pq
        
        for (int num : map.keySet()) {                  // Step 3: Keep only K most frequent elements
            pq.add(num);

            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[] result = new int[k];                      // Step 4: Store answer

        for (int i = 0; i < k; i++) {
            result[i] = pq.poll();
        }

        return result;
    }

    public static void main(String[] args) {

        int[] arr = {1, 1, 1, 2, 2, 3};
        int k = 2;

        int[] result = topKFrequent(arr, k);
        System.out.println(Arrays.toString(result));
    }
}
    

