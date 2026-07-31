/*      Given an array arr[] of size n-1 with distinct integers in the range of [1, n].
            This array represents a permutation of the integers from 1 to n with one element missing. 
            Find the missing element in the array. 
                    
            TIME & SPACE COMPLEXITY - O(N LOG N ) && O(1)
*/

package ARRAYS.EASY;
import java.util.Arrays ;

public class Finding_MissingNumber {
    public static int missing(int arr[]){

        Arrays.sort(arr);
        if(arr[0] != 1){                // when starting index 1 is miising
            return 1 ;
        }
        int n  = arr.length;

        for (int i = 0 ; i < n-1 ; i ++){
            if( arr[i]+1 != arr[i+1]){          // if value of [i] + 1 is not equal to next element of i, then means the number after i is missing
                return arr[i]+1 ;                 // so the number is [i] + 1 or valuee of next element - current element
            }
        }
        return -1;              // whenn no number is missing
    }
    public static void main(String[] args) {
        int arr[] = {5,6,1,8,3,7,4,2,9};
        System.out.println(missing(arr));
    }
}
