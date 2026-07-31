/*        You are given an array of integers, your task is to move all the zeros in the array to the end of the array
            & move non-negative integers to the front by maintaining their order.
 */

package ARRAYS.EASY;

public class Move_zeroes_toend {
    public static void move(int arr[]){
        int n = arr.length;

        // making an pointer j which points to the next non-zero element always
        int j = 0 ;             // initialising at 0 index

        for( int i = 0 ; i < n ; i ++){
            // when element is non-zero
            if(arr[i] != 0){            // change the postions of i & j
                int temp = arr[i] ;
                arr[i] = arr[j] ;
                arr[j] = temp ;
                j ++ ;

                // by this the non-zero elements comes to front & zeroes moves backward
                // i & j swaps onlly when, i is non zero.
            }
        }
    }
    public static void main(String[] args) {
        int arr[] = { 1,2,0,0,5,5,0,20,6,0,1,0};
        move(arr);
        for(int num : arr){
            System.out.print(num);
        }
    }
}
