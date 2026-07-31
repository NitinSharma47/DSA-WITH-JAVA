/*                               Given an array containing both positive and negative integers, 
                we have to find the length of the longest subarray with the sum of all elements equal to zero.
 */

package ARRAYS.HARD;
import java.util.HashMap;

public class Length_ofLongest_subarray_withSum_zero {
    public static int zero(int arr[]){

        int n = arr.length ;
        int sum = 0 ;
        int length = 0 ;         // variable to  store the length of subarray

        HashMap < Integer , Integer > map = new HashMap<>() ;

        for(int i = 0 ; i < n ; i ++ ){
            sum += arr[i] ;                     // calculate sum till currennt element
           
            if(sum == 0){
                length = i + 1 ;                 // it stores the length of the subarray(0....i) , which have total sum = 0 
            }else{
                if(map.containsKey(sum)){                      
                // if sum is already stored in map ,i.e now prefix sum is appeared twice, so there is a observation note ->

     // *    when the same prefix sum appears twice, the elements between those indexes(between first sum and second sum indexes) have sum 0.
                // so, maximize the length
                    length = Math.max(length, i - map.get(sum)) ;   // in map, sum is store as key and its value is index, so(map.get(sum) will get the index)
                }
                else{                                               // else store sum (if it was seen first time)
                    map.put(sum,i) ;
                }
            }
        }
        return length ;
    }
    public static void main(String[] args) {
        int arr[] = {9, -3, 3, -1, 6, -5} ;
        System.out.println(zero(arr));
    }
    
}
