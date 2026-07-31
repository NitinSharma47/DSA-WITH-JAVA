/*      You are given a strictly increasing array ‘vec’ and a positive integer 'k'. Find the 'kth' positive integer missing from 'vec'.
Example 1:
Input Format: vec[]={4,7,9,10}, k = 1
Result: 1
Explanation: The missing numbers are 1, 2, 3, 5, 6, 8, 11, 12, ……, and so on. Since 'k' is 1, the first missing element is 1.

Example 2:
Input Format: vec[]={4,7,9,10}, k = 4
Result: 5
Explanation: The missing numbers are 1, 2, 3, 5, 6, 8, 11, 12, ……, and so on. Since 'k' is 4, the fourth missing element is 5.
*/

package BINARY_SEARCH.BS_IN_ANS;

public class Kth_Missing_Number {
    public static int miss(int arr[] , int k){

        int low = 0 , high = arr.length -1 ;
        if(arr[0] != 1 && k == 1 ){ return  1 ; }            // when first element is not 1 , and kth element(which we are finding) is 1..

        while (low <= high) {
            int mid = (low + high) / 2;

            // Number of missing elements before index mid
            int missing = arr[mid] - (mid + 1);                     //*  formula to find missing numbers brfore index mid..

            if (missing < k) {
                low = mid + 1;  // Move right
            } else {
                high = mid - 1; // Move left
            }
        }
        // Final result after binary search
        return k + high + 1;                                    // * formula to return answer
    }
    public static void main(String[] args) {
        int vec[]={4,7,9,10} ;
        int k = 4 ;
        System.out.println(miss(vec, k));
    }
}
