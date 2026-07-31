/*       Given an integer array nums, sorted in ascending order (with distinct values) and a target value k. 
        The array is rotated at some pivot point that is unknown. Find the index at which k is present and if k is not present return -1. 
*/

package BINARY_SEARCH.BS_IN_1D_ARRAYS;

public class Check_Element_InRotatedArray {
    public static int search(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            if (nums[mid] == target)
                return mid;

            // If left part is sorted
            if (nums[low] <= nums[mid]) {

                if (nums[low] <= target && target < nums[mid]) {   // If target lies within sorted left part
                    high = mid - 1;
                }
                else {                      // Else, search in right half
                    low = mid + 1;
                }
            }
            // Else, right part is sorted
            else {

                if (nums[mid] < target && target <= nums[high]) {   // If target lies within sorted right part
                    low = mid + 1;
                }
                else {                                  // Else, search in left half
                    high = mid - 1;
                }
            }
        }
        return -1 ;
    }
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(search(nums,target));
    }
}
