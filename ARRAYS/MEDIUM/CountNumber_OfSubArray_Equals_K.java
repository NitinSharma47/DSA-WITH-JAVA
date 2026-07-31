/*          Given an array of integers and an integer k,  return the total number of subarrays whose sum equals k. 
                    A subarray is a contiguous non-empty sequence of elements within an array.

            *   we have to find the total no. of subarrays , whose sum is k

                                 <<<  BRUTE FORCE APPROACH  >>>
 */

package ARRAYS.MEDIUM;

public class CountNumber_OfSubArray_Equals_K {

    public static int sub(int arr[], int k){
        int n = arr.length ;
        int count = 0 ;

        for( int i = 0 ; i < n ; i ++){
            for( int j = i ; j < n ; j ++){
                int sum = 0 ;
            
                for (int m = i ; m <= j ; m ++){        // loop to calculate the sum of subarray from i to
                    sum += arr[m];
                }
                if(sum == k){
                    count ++ ;
                }
            }
        }

        return count ;
    }
    public static void main(String[] args) {
        int arr[] = {3,1,2,4};
        int k = 6 ;
        System.out.println(sub(arr, k));
    }
    
}
