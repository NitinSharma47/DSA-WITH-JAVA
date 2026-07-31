/*                                                 <<  OPTIMAL APPROACH  >>

STEPS  ->

Traverse the array from left to right (prefix) to build cumulative product.
Traverse the array from right to left (suffix) to catch subarrays ending at the back (helpful when max product is at the end or due to even negatives).
Reset the product to 1 whenever a zero is found, as it breaks the subarray continuity.
By comparing products in both directions at each step, we ensure we don’t miss any possible maximum.

*/

package ARRAYS.HARD;

public class Maximum_Product_SubArray_Optimal {
    public static int maxPro(int[] arr) {
       
        int n = arr.length;       
        int pre = 1, suff = 1;          // Initialize prefix and suffix product

        int maxProduct = Integer.MIN_VALUE;

        // Traverse from both left and right
        for (int i = 0; i < n; i++) {
            
            if (pre == 0) pre = 1;          // Reset prefix if zero comes (product becomes 0)
            if (suff == 0) suff = 1;        // Reset suffix if zero comes

            pre *= arr[i];              // calculate prefix Product from front
            suff *= arr[n - i - 1];     // calculate suffix Product from back

            maxProduct = Math.max(maxProduct, Math.max(pre, suff));               // Update maximum product value so far
        }
        return maxProduct;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,-3,0,-4,-5};
        System.out.println(maxPro(arr));
    }
}
