//      Given an array that contains both negative and positive integers, find the maximum product subarray.

package ARRAYS.HARD;

public class Maximum_Product_SubArray {
    public static int pro(int arr[]){

        int maxProduct = Integer.MIN_VALUE ;

        for(int i = 0 ; i < arr.length ; i ++){
            int product = 1 ;       // to store current product && to reset product to 1 after each i

            for( int j = i ; j < arr.length ; j ++){
                product *= arr[j] ;
                maxProduct = Math.max(maxProduct, product) ;   
            }
        }
        return maxProduct ;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,-3,0,-4,-5} ;
        System.out.println(pro(arr));
    }
}
