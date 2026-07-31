/*          Given an array of length N, peak element is defined as the element greater than both of its neighbors. 
    Formally, if arr[i] is the peak element, arr[i - 1] < arr[i] and arr[i + 1] < arr[i]. Find the index(0-based) of a peak element in the array. 
                        If there are multiple peak numbers, return the index of any peak number.

    APPROACH -> 
    The left half of the peak element has an increasing order whereas the right half of the peak element has a decreasing order.
    Thus we know that if current element is greater than its left neighbour, we are in the left half 
    and if our current element is greater than its right neighbour then we are in the right half. 
    If we know the half that we are in currently, we can eliminate it to find our peak element.
 */
package BINARY_SEARCH.BS_IN_1D_ARRAYS;

public class Peak_Element {
    public static int peak(int arr[] ){

        int n = arr.length ;
        if (n == 0){ return arr[0] ;}           // when array have only 1 single element

        int low = 0 , high = arr.length - 1 ;

        while ( low <= high){
            int mid = low + (high - low) / 2 ;

            if (arr[mid] > arr[mid + 1]) {          // means we are in right half now..eliminate it
                // Move to left half
                high = mid;
            } else {
                // Move to right half
                low = mid + 1;
            }
        }
        return low ;
    }
}
