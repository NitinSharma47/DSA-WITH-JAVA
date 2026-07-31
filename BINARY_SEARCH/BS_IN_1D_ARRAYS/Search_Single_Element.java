/* Given an array of N integers. Every number in the array except one appears twice. Find the single number in the array. 

    APROACH ->  The array is sorted, and all elements except one appear exactly twice. 
            If we observe carefully, every pair starts at even index and ends at odd index when the array is still balanced 
                        (i.e., before the unique element is encountered).

 ->    But once the unique element is inserted, this pairing pattern breaks and the shift happens after that unique element.
                So we can use this pattern to cut the search space in half using binary search:

If the pairing is proper (i.e., arr[mid] == arr[mid ^ 1]), then the unique (non-duplicate) element lies in the right half.
If the pairing breaks (i.e., arr[mid] != arr[mid ^ 1]), then the unique element lies in the left half.

*/
package BINARY_SEARCH.BS_IN_1D_ARRAYS;

public class Search_Single_Element {
    public static int sr(int arr[],int single){

        int n = arr.length ;
        if (n == 0){ return arr[0] ;}           // when array have only 1 single element

        if( arr[0] != arr[1]){ return arr[0] ;}         // when first element is single

        int low = 0 , high = arr.length - 1 ;

        while ( low <= high){
            int mid = low + (high - low) / 2 ;

            if (arr[mid] != arr[mid + 1] && arr[mid] != arr[mid - 1]) {         // when middle element is the unique one
                return arr[mid];
            }
            if ((mid % 2 == 1 && arr[mid] == arr[mid - 1]) || (mid % 2 == 0 && arr[mid] == arr[mid + 1])) {     // means every element till mid is twice..(correct)
                // Move to the right half
                low = mid + 1;                                              // so , the single element must lie in right part(after mid)
            }
            else {
                // Move to the left half
                high = mid - 1;
            }
        }
        return -1 ;                 // if not such single element exists

    }
    
}
