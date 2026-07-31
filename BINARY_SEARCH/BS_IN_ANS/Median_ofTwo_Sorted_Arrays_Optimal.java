// *                                      <<  BINARY SEARCH OPTIMAL APPROACH  >>

package BINARY_SEARCH.BS_IN_ANS;

public class Median_ofTwo_Sorted_Arrays_Optimal {
    
    public static double findMedianSortedArrays(int[] arr1, int[] arr2) {
        // Ensure nums1 is the smaller array to optimize runtime to O(log(min(m, n)))
        if (arr1.length > arr2.length) {
            return findMedianSortedArrays(arr2, arr1);
        }

        int m = arr1.length;
        int n = arr2.length;
        int low = 0;
        int high = m;

        while (low <= high) {
            int partition1 = low + (high - low) / 2;
            int partition2 = (m + n + 1) / 2 - partition1;

            // Handle edge conditions when partition index is at the boundary
            int maxLeft1 = (partition1 == 0) ? Integer.MIN_VALUE : arr1[partition1 - 1];
            int minRight1 = (partition1 == m) ? Integer.MAX_VALUE : arr1[partition1];

            int maxLeft2 = (partition2 == 0) ? Integer.MIN_VALUE : arr2[partition2 - 1];
            int minRight2 = (partition2 == n) ? Integer.MAX_VALUE : arr2[partition2];

            // Valid partition found
            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                // If total number of elements is odd
                if ((m + n) % 2 == 1) {
                    return Math.max(maxLeft1, maxLeft2);
                } 
                // If total number of elements is even
                else {
                    return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2.0;
                }
            } 
            // Too far right in nums1, move left
            else if (maxLeft1 > minRight2) {
                high = partition1 - 1;
            } 
            // Too far left in nums1, move right
            else {
                low = partition1 + 1;
            }
        }

        return 0.0 ;
    }
    public static void main(String[] args) {
        int arr1[] = {2,4,7,8} ;
        int arr2[] = {5,6,7,8} ;

        System.out.println(findMedianSortedArrays(arr1, arr2));
        
    }


}
