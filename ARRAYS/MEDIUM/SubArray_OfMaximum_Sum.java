/*          Given an integer array nums, find the subarray with the largest sum ..
                print the subarray that has the maximum sum..
 */

package ARRAYS.MEDIUM;

public class SubArray_OfMaximum_Sum {
    public static int sub(int arr[]){
        int n =  arr.length ; 
        int sum = 0 ;
        
        long max = Integer.MIN_VALUE ;     // long datatype because the number can be too big , and can exceed the limit of (int datatype (2^31 - 1))
        int start =0 ;                      // to track the starting index of sub array ..

        int subarrStart = -1 , subarrEnd = - 1 ;            // variables to store the index of maximum sum subarray..

        for( int i = 0 ; i < n ; i ++){
            if(sum == 0) {          // means when i = 0(starting) , or in-case any negative value makes sum 0
                start = i ;           // storing the curent starting index
            }
            sum += arr[i] ;

            if( sum > max) {
                max = sum ;
                subarrStart = start ;               // putting the value of start(currrent subarray's starting index) 
                subarrEnd = i ;                      // putting the current i (index of arr[]) 
            }
            
            if(sum < 0 ){           // means whenever the sum becomes negative, then update the sum to 0 
                sum = 0 ;
            }
            // this loop gives the starting subarray index & ending subarray index
        }
        
        // printing the subarray
        System.out.print("[");
        
        for(int j = subarrStart ; j <= subarrEnd ; j ++){
            System.out.print(arr[j] + " ");
        }
        System.out.println("]");
        
        System.out.println("The maximum sum is :") ;
        return (int) max ;          // type casting long (max) to (int) ,because of the return type of function is (int)
    }
    public static void main(String[] args) {
        int arr [] = new int [] {2,3,4,-1,4};
        System.out.println(sub(arr));
    }
}
