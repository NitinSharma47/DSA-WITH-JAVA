/*
                           Given an array of integers A and an integer k.
            Find the total number of subarrays having bitwise XOR of all elements equal to k. */

package ARRAYS.HARD;

public class No_ofSubarrays_with_xor_K {
    public static int total ( int arr[] , int k){
        
        int count = 0; 

        for( int i = 0 ; i < arr.length ; i ++){
            int xor = 0 ;
            for( int j = i ; j < arr.length ; j ++ ){
                xor ^= arr[j] ;             // taking xor of every element and storing it

                if(xor == k){
                    count ++ ;
                }
            }
        }
        return count ;
    }
    public static void main(String[] args) {
        int arr[] = {4, 2, 2, 6, 4} ;
        int k = 6 ;
        System.out.println(total(arr, k));
    }
    
}
