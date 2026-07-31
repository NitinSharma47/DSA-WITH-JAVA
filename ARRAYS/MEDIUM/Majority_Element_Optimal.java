/*                     <<  OPTIMAL APPROACH >> 
*/

package ARRAYS.MEDIUM ;

import java.util.HashMap;
import java.util.Map;

public class Majority_Element_Optimal{
    public static int majority(int[] nums) {
        
        // Size of the given array
        int n = nums.length;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Count occurrences of each element
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        /* Iterate through the map to find the majority element */
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > n / 2) {
                return entry.getKey();
            }
        }
        
        // Return -1 if no majority element is found
        return -1;
    }
    public static void main(String[] args) {
        int nums[] = new int[] { 2,3,4,5,2,2,3,2,2,3,2};
        System.out.println(majority(nums));
    }
}