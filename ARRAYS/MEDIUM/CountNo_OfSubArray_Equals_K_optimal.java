
/*                             <<<<  OPTIMAL APPROACH  >>>> */
package ARRAYS.MEDIUM;

import java.util.HashMap;

public class CountNo_OfSubArray_Equals_K_optimal {

    public static int subarraySum(int[] arr, int k) {

        int n = arr.length;
        HashMap<Integer, Integer> prefixSumCount = new HashMap<>();     // Map to store frequency of prefix sums

        int prefixSum = 0;
        int count = 0;
       
        prefixSumCount.put(0, 1);            // Base case: prefix sum 0 has occurred once

        for (int i = 0; i < n; i++) {
            prefixSum += arr[i];            // calculating prefixSum

            // Calculate the prefix sum that needs to be removed
            int remove = prefixSum - k;         // to get the key(0) which we initialize before

            if (prefixSumCount.containsKey(remove)) {    // checking if prefixsum have the key remove(means 0)
                count += prefixSumCount.get(remove);        // getting all the subarrays, which sum equal to remove..and increaing count
            }

            // Update the frequency of the current prefix sum
            prefixSumCount.put(prefixSum, prefixSumCount.getOrDefault(prefixSum, 0) + 1);      // it means -> prefixSumCount.put(prefixSum,(current prefixsum value) + 1

        //What does getOrDefault() mean?        It means: Get the value associated with this key. If the key does not exist, return the default value.
        }

        // Return the total count of subarrays
        return count;
    }
    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4};

        // Target sum
        int k = 0;
        System.out.println(subarraySum(arr , k));
    }
    
}
