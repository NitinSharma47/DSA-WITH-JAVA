/*              Given an integer array of size n, return the majority element of the array.
            The majority element of an array is an element that appears more than n/2 times in the array. 
                    The array is guaranteed to have a majority element.

                    << BRUTE FORCE APPROACH >>
 */

package ARRAYS.MEDIUM;

public class Majority_Element {
    public static int major(int arr[]){
        int n =  arr.length ;
    
        for(int i = 0 ; i < n ; i ++){
            int frequency = 0 ;

            for( int j = 0 ; j < n ; j++){
                if(arr[i] == arr[j]){
                    frequency ++ ;
                }
            }
            if(frequency > n/2){
               return arr[i] ;
            }
        }
        return -1 ;
    }
    public static void main(String[] args) {
        int arr[] = new int[] { 2,3,4,5,2,2,3,2,2,3};
        System.out.println(major(arr));
    }
}
