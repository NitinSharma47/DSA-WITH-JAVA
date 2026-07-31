/*                               << OPTIMAL APPROACH >>

*                   Using HashSet , because the property of hashset is ->
*              it  removes the duplicate elements from array or list..amd stores only the unique elements
*                    & also have other build-in functions like to search elements in it..
 */

package ARRAYS.MEDIUM;

import java.util.HashSet;
import java.util.Set;

public class Longest_Consecutive_Sequence_Optimal {
    public static int longestConsecutive(int[] nums) {
        
        int n = nums.length;
        if (n == 0) return 0;

        // Variable to store the longest sequence length found
        int longest = 1; 
        Set<Integer> set = new HashSet<>();          // HashSet to store unique elements for O(1) lookup

        for (int i = 0; i < n; i++) {            // Adding all elements to set to remove all duplicates
            set.add(nums[i]);
        }

        // Loop through each element in the set to find the starting point of consecutive sequences 

        for (int it : set) {
            if (!set.contains(it - 1)) {            // If there is no number before (it) then, (it) is the start of a sequence
                int cnt = 1;                    // Start the count for this sequence
                int current = it;         // Store the current number

                while (set.contains(current + 1)) {             //check if the set contains current + 1, if yes then it execeutes..
                    current = current + 1; 
                    cnt = cnt + 1; 
                }

                // Update the longest sequence length if needed
                longest = Math.max(longest, cnt);
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        
        int[] nums = {100, 4, 200, 1, 3, 2}; 
        System.out.println(longestConsecutive(nums)); 
    }
    
}
