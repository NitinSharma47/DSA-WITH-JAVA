/*                                  Longest Increasing Subsequence (LIS):

                Find the length of the longest subsequence in an array such that all elements are in increasing order. 
            Means - we have to find that longest subsequence which have all elements in increasing order

        ex- {1,4,2,5,3}    -> the longest subsequence can be ->
                        1,2,3    &&   1,4,5
                        but not ->  1,4,2,5  or  2,5,3  (because the elements here are not in increasing order)
        APPROACH ->
                First make  a DP array, which stores the longest subsequence till[i] index..
                And initialise whole array with 1 , because there is atleast 1 length of subsequence for every element of arr
                We take two pointers i & j -> 
                j will goes from 0 till i.. and if arr[j] is less than arr[i] ->
                then , the value at j index is added by 1 , and then write at i index..
 */

import java.util.Arrays;

public class Longest_Increasing_Subsequence {
    public static int lis(int arr[]){
        int n = arr.length;

        int dp[] = new int [n+1];
        Arrays.fill(dp,1);

        int maxlength = 1 ;             // vaariable to store maximmum length of subsequence & atleast the length is 1

        for( int i = 1 ; i < n ; i++){
            for ( int j = 0 ; j < i ; j ++ ){
                if( arr[j] < arr[i] ) {             // when j is smaller than i
                    dp[i] = Math.max(dp[i] , dp[j] + 1 ) ;  // heree dp[i] is 1..because whole dp array is filled by 1 
                }
            }
            maxlength = Math.max(maxlength, dp[i]) ;                // for every i in dp .. which is greater than maxlength, maxlength is updated

        }
        return maxlength ;
    }
    public static void main(String[] args) {
        int arr[] = { 3,4,-1,0,6,2,3};
        System.out.println(lis(arr));
    }
    
}


