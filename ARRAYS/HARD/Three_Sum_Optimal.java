/*                                         <<  OPTIMAL APPROACH  >>

This is an improved version of the previous solution.

         We remove the extra set (used for unique triplets) and HashSet (used for quick searching) -> 
*                                    By sorting the array first ,we can :->

            -    Easily skip repeated numbers by checking if the current number is the same as the previous one.
            -    Ensure all triplets are unique without storing them in a set.
            -    Instead of using a HashSet to find triplets, we use the two-pointer method:

            ->    One pointer moves forward from the left, the other backward from the right.
                We adjust their positions depending on whether the total is greater than, less than, or equal to the target.

 */
package ARRAYS.HARD;
import java.util.*;

public class Three_Sum_Optimal {
    public static List<List<Integer>>  Threesum(int arr[]) {

        Arrays.sort(arr);               // * Sort the Array
        int n = arr.length ;

        List <List <Integer>> result = new ArrayList<>() ;

        for (int i = 0; i < n; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) continue;        // for first index or element , Skip duplicates

            // Two pointers
            int left = i + 1, right = n - 1;

            // Find pairs for current arr[i]                
            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];

                if (sum == 0) {

                    result.add(Arrays.asList(arr[i], arr[left], arr[right]));   //* Create a List containing three values(i,left,right), then add that list to ans.
                    left++;
                    right--;

                    
                    while (left < right && arr[left] == arr[left - 1]) left++;          // Skip duplicates for left
                    while (left < right && arr[right] == arr[right + 1]) right--;       // Skip duplicates for right
                }

                else if (sum < 0) left++;               // when sum is lesser than zero, then increase left pointer on sorted array
                else right--;                           // when sum is greater than zero , then decrease right pointer 
            }
        }
        return result;
    }
    public static void main(String[] args) {
        
        int arr[] = { -1,0,1,2,-1,-4 } ;
        System.out.println(Threesum(arr));
    }
}
