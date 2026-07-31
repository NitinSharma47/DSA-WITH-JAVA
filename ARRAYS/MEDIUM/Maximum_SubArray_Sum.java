/*                                 Kadane's Algorithm : Maximum Subarray Sum in an Array
                            *<< OPTIMAL APPROACH >>

Problem Statement: Given an integer array nums, find the subarray with the largest sum 
                    and return the sum of the elements present in that subarray.

                    A subarray is a contiguous non-empty sequence of elements within an array. 
*/

package ARRAYS.MEDIUM ;

public class Maximum_SubArray_Sum{
    public static int max(int[] arr) {
        
        // Maximum sum
        int maxi = 0 ;
        
        // Current sum of subarray 
        int sum = 0; 
        
        for (int i = 0; i < arr.length; i++) {
            
            // Add current element to the sum
            sum += arr[i]; 
            
            // Update maxi if current sum is greater
            maxi = Math.max(maxi, sum);
            
            // Reset sum to 0 if it becomes negative
            if (sum < 0) {
                sum = 0; 
            }
        }
        
        // Return the maximum subarray sum found
        return maxi;
    }
    public static void main(String[] args) {
        int arr [] = { 2,3,4,-1,4};
        System.out.println(max(arr));
    }
    
}
