 /*            Given an array containing both positive and negative integers, 
            we have to find the length of the longest subarray with the sum of all elements equal to zero       */
package ARRAYS.EASY ;
import java.util.*;

class longest_subarray_with_zeroSum{
    public static int subarray(int arr[] ){

        HashMap<Integer , Integer > map = new HashMap<>() ;
        
        int sum = 0 , length = 0 ;
        for(int i = 0 ; i < arr.length; i ++){
            sum += arr[i] ;

            if (sum == 0){                  // whenever the sum is zero , means the sum of sub-array is 0
                length = i + 1 ;        //so length of sub array is till i..(+1 because starting is from zero index)
            }
            else {
                if( map.containsKey(sum)){
                    length = Math.max(length  , i - map.get(sum)) ;
                }
                else{
                    map.put(sum,i);
                }
            }
        }
        return length ;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{9, -3, 3, -1, 6, -5};
        System.out.println(subarray(arr));
    }
}