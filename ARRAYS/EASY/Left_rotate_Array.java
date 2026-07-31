/*                          Given an integer array arr, rotate the array to the left by one.
    
*/
package ARRAYS.EASY;

public class Left_rotate_Array{
    public static void main(String [] args){
        int arr [] = { 5,6,7,8,9,4,3,5,6,77,7,72,2,3,4} ;
        int n = arr.length;
        int temp = arr[0] ;
        for( int i = 1 ; i < n ; i ++ ){
            arr[i-1] = arr [i] ;

        }
        arr[n-1] = temp ;

        for( int num : arr){
            System.out.print(num);
        }

    }
}