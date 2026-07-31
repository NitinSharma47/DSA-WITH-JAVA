/*                      <<  OPTIMAL APPROACH  >>
                USING DUTCH NATIONAL FLAG ALGORITHM */

package ARRAYS.MEDIUM;

public class Sort_ArrayOf_0s1s2s_optimal {
    public void sortZeroOneTwo(int[] nums) {

    // Initialize three pointers - low and mid at 0, high at the end
        int low = 0, mid = 0, high = nums.length - 1;                  // low runs for zero , mid runs for one , high runs for two

        // Traversing mid from 0 to high(last index)
        while (mid <= high) {
           
            if (nums[mid] == 0) {                // If current element is 0, swap with low and move both low and mid forward
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            }

            else if (nums[mid] == 1) {          // If current element is 1, just move mid forward
                mid++;
            }

            else {                              // If current element is 2, swap with high and move only high backward
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
    }
    public static void main(String[] args) {
        Sort_ArrayOf_0s1s2s_optimal obj = new Sort_ArrayOf_0s1s2s_optimal();
        int[] nums = {2, 0, 2, 1, 1, 0};

        obj.sortZeroOneTwo(nums);

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
    
}
