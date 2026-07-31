/*              Given an integer array arr of size N, sorted in ascending order (with distinct values), 
                the array is rotated at any index which is unknown. Find the minimum element in the array. 
*/

package BINARY_SEARCH.BS_IN_1D_ARRAYS;

public class Find_Minimum_InRotatedArray {
    public int findMin(int[] nums) {

        int low = 0, high = nums.length - 1;

        while (low < high) {

            int mid = low + (high - low) / 2;

            // Check which half to discard
            if (nums[mid] > nums[high]) {           // means the minimum is in right half

                // Minimum lies in right half
                low = mid + 1;
            } else {

                // Minimum lies in left half (including mid)
                high = mid;
            }
        }
        // Return the minimum element
        return nums[low];
    }
}
