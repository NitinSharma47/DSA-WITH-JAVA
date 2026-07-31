/*          Given a sorted array of N integers and an integer x, write a program to find the upper bound of target.

                    The upper bound algorithm finds the first or the smallest index in a sorted array 
                    where the value at that index is greater than the given key i.e. x.
The upper bound is the smallest index, ind, where arr[ind] > x.

*                       Upper Bound , wo pehla index hai jo target se bada hai..
*->            only difference from lower bound -> yeh target ke equal nai hota bas usse bada hota hai

Example 1:
Input Format: N = 4, arr[] = {1,2,2,3}, x = 2
Result: 3
Explanation: Index 3 is the smallest index such that arr[3] > x.

Example 2:
Input Format: N = 6, arr[] = {3,5,8,9,15,19}, x = 9
Result: 4
Explanation: Index 4 is the smallest index such that arr[4] > x. */

package BINARY_SEARCH.BS_IN_1D_ARRAYS;

public class Upper_Bound {
    public static int lower_bound(int arr[] , int target){

        int ans = 0 ;               // variable to return lower bound 
        int low = 0 , high = arr.length - 1 ;

        while ( low <= high){
            int mid = low + (high - low) / 2 ;          

            //*  same code as lower bound , just remove = from here ...
            if(arr[mid] > target){  // when target is lesser than mid , so ans = mid & we check in 0 to mid - 1
                ans = mid ;
                high = mid - 1 ;
            }
            else {                  //when target is greater than the mid , so we check in mid + 1 to high
                low = mid + 1;
            }
        }
        return ans ;
    }
    public static void main(String[] args) {
        int arr[] = {3,5,8,9,9,10,15,19} ;
        int target = 9 ;
        System.out.println(lower_bound(arr, target));   
    }
}
