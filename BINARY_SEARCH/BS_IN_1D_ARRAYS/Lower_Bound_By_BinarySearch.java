/*       Given a sorted array of N integers and an integer x, write a program to find the lower bound of x.

*                The lower bound algorithm finds the first or the smallest index in a sorted array 
*                   where the value at that index is greater than or equal to a given key i.e. x.

The lower bound is the smallest index, ind, where arr[ind] >= x. But if any such index is not found,
 the lower bound algorithm returns n i.e. size of the given array.

Example :->
Input Format: N = 5, arr[] = {3,5,8,15,19}, x = 9
Result: 3
Explanation: Index 3 is the smallest index such that arr[3] >= x.

*          lower bound, wo pehla index hai jo target se bada ya uske equal hai
*/

package BINARY_SEARCH.BS_IN_1D_ARRAYS;

public class Lower_Bound_By_BinarySearch {
    public static int lower_bound(int arr[] , int target){

        int ans = 0 ;               // variable to return lower bound 

        int low = 0 , high = arr.length - 1 ;

        while ( low <= high){
            int mid = low + (high - low) / 2 ;          

            if(arr[mid] >= target){  // when target is lesser than or equaL to the mid , so we check in 0 to mid - 1
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
        int arr[] = {3,5,8,15,19} ;
        int target = 9 ;
        System.out.println(lower_bound(arr, target));   
    }
}

/* 
*               ALSO THIS ABOVE CODE IS ALSO SAME FOR THE OTHER PROBLEM GIVEN BELOW    ->
                    You are given a sorted array arr of distinct values and a target value x. 
                        You need to search for the index of the target value, like where it should be placed in the array.
Example 1:
Input Format: arr[] = {1,2,4,7}, x = 6
Result: 3
Explanation: 6 is not present in the array. So, if we will insert 6 in the 3rd index(0-based indexing), the array will still be sorted. {1,2,4,6,7}.

Example 2:
Input Format: arr[] = {1,2,4,7}, x = 2
Result: 1
Explanation: 2 is present in the array and so we will return its index i.e. 1.

*/
