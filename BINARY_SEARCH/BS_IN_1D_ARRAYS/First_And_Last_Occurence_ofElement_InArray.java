/*          Given a sorted array of N integers, write a program to find the index of the last occurrence of the target key.
                            If the target is not found then return -1. Note: Consider 0 based indexing
 */

package BINARY_SEARCH. BS_IN_1D_ARRAYS;

public class First_And_Last_Occurence_ofElement_InArray {
    public static int first(int arr[], int target){         // function to find first occurence

        // * CODE IS SAME AS LOWER BOUND CODE
        int low = 0 , high = arr.length - 1 ;

        int firstoccurrence = -1 ;               // variable to store index 

        while( low <= high){
            int mid = low + (high - low) / 2 ;

            if(arr[mid] == target){
                firstoccurrence = mid ;
                high = mid - 1;        //  because, when occurence found then, eliminates the whole part of array which is after the occurence, so onlly fist occurence index is returned
            }
            else if (arr[mid] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1 ;
            }
        }
        return firstoccurrence ;
    }
    public static int last(int arr[], int target){          // function to find last occurence

        // * CODE IS SAME AS UPPER BOUND CODE
        int low = 0 , high = arr.length - 1 ;
        int lastoccurrence = -1 ;

        while( low <= high){
            int mid = low + (high - low) / 2 ;

            if(arr[mid] == target){
                lastoccurrence = mid ;
                low = mid + 1 ;     // because, when occurence found then, eliminates the half part of array which is before the occurence, and start from next element to find last occurence
            }
            else if (arr[mid] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1 ;
            }
        }
        return lastoccurrence ;
    }
    public static int [] occurrence(int arr[] , int target){            // function to return both first and last occurence together

        int F = first(arr, target) ;                    // storing result of first occurence in f
        if(F == -1 ){return new int[]{-1,-1} ;}   // when target is not in array and ,  its occurences is not found 

        int L = last(arr, target) ;             //  storing result of last occurence in L
        return new int[] {F , L}; 
    }
        public static void main(String[] args) {

        int arr[] = new int [] { 1,2,3,4,5,5,5,5,6,7} ;
        int target = 5 ;
        
        int res[] = occurrence(arr, target);
        for(int num : res){
            System.out.print(num + " ");
        }
    }
}
