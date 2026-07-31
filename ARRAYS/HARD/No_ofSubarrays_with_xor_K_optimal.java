package ARRAYS.HARD;

import java.util.HashMap;
import java.util.Map;

public class No_ofSubarrays_with_xor_K_optimal {
    public int countSubarrays(int[] A, int k) {
       
        Map<Integer, Integer> freq = new HashMap<>();
       
        freq.put(0, 1);     // initialising 0, because prefixXor ^ k == 0..(same elements xor is always zero)

        int prefixXor = 0;
        int count = 0;

        for (int num : A) {

            prefixXor ^= num;
            int target = prefixXor ^ k;         // it will give answer -> 0

            // If target exists in map, add its frequency
            if (freq.containsKey(target)) {
                count += freq.get(target);
            }
            // Store current prefix XOR in map
            freq.put(prefixXor, freq.getOrDefault(prefixXor, 0) + 1);
        }
        return count;
    }
    
}
