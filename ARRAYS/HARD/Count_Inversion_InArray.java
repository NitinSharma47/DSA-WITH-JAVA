/*                              << BRUTE FORCE APPROACH  >>
              Given an array of N integers, count the inversion of the array (using merge-sort).
*       Inversion of an array: for all i & j < size of array, if i < j then you have to find pair (A[i],A[j]) such that A[j] < A[i].
Example 1:
Input Format: N = 5, array[] = {1,2,3,4,5}
Result: 0
Example 2:
Input Format: N = 5, array[] = {5,4,3,2,1}
Result: 10
Example 3:
Input Format: N = 5, array[] = {5,3,2,1,4}
Result: 7 */

package ARRAYS.HARD;

public class Count_Inversion_InArray {
    public static int inversion(int arr[]){

        int count = 0 ;

        for(int i = 0 ; i < arr.length ; i ++){
            for( int j = i + 1 ; j < arr.length ; j ++){
                if(arr[j] < arr[i]){
                    count ++ ;
                }
            }
        }
        return count ;
    }
    public static void main(String[] args) {
        int arr[] = {5,3,2,1,4} ;
        System.out.println(inversion(arr));
    }
}
