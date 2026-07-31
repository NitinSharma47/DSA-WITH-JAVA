/* Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

* Algorithm

We can optimize the standard sliding window approach by eliminating the inner while-loop. 
Instead of using an explicit loop to shrink the window when the number of zeros exceeds the allowed flips (K), 
we can use a single conditional check to move the left pointer forward only when needed. 
This ensures that each pointer moves in a controlled and efficient manner without unnecessary loop nesting. 
The logic remains similar to the standard sliding window, but this structure can make the code slightly faster and cleaner in certain languages.

*Process ->

Initialize two pointers, left and right, both set to 0, and a variable zerocount to keep track of the number of zeros in the current window.
Traverse the array using the right pointer.
If the current element is 0, increment zerocount.
If zerocount exceeds k, check if the element at the left pointer is 0, and if so, decrement zerocount. Then increment the left pointer.
At each step, calculate the current window size and update the maximum length if it's greater than the previously recorded maximum.
Continue this process until the right pointer has traversed the entire array.
Return the maximum window size found.

 */


class Maximum_Consecutive_ones {
    public int longestOnes(int[] nums, int k) {

        int left = 0;
        int zerocount = 0;      // Counter for zeros in the window

        int maxlen = 0;              // Variable to store maximum window length
        for (int right = 0; right < nums.length; right++) {             // Right pointer expands the window

            if (nums[right] == 0) {                                 // If current element is zero, increment zerocount
                zerocount++;
            }
            if (zerocount > k) {                                    // If zerocount exceeds k, move left and adjust zerocount
                if (nums[left] == 0) {
                    zerocount--;
                }
                left++;                                             // Shrink window from left, no matter nums[left] is 0 or not
            }
            maxlen = Math.max(maxlen, right - left + 1);            // Update maximum window size
        }

        return maxlen;                          // Return the final result
    }

    public static void main(String[] args) {
        Maximum_Consecutive_ones sol = new Maximum_Consecutive_ones();
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 3;
        
        System.out.println(sol.longestOnes(nums, k));
    }
}

