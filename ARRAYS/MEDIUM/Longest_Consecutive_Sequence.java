/*      Given an array nums of n integers....Return the length of the longest sequence of consecutive integers.
             The integers in this sequence can appear in any order 
        *consecutive = "Lagatar"

    Example 1:
    nums = [100, 4, 200, 1, 3, 2]  
    Output:
     4  
    Explanation:
    The longest sequence of consecutive elements in the array is [1, 2, 3, 4], which has a length of 4. 
    This sequence can be formed regardless of the initial order of the elements in the array.

*/

package ARRAYS.MEDIUM;
import java.util.ArrayList;

public class Longest_Consecutive_Sequence {
    public static boolean search(int arr[], int num) {          // search function
        
        for (int x : arr) {
            if (x == num)
                return true;
        }
        return false;           // return false ny default, if the num is not in arr
    }

    public static ArrayList<Integer> longest(int arr[]) {
        int n = arr.length;
        int longestt = 0;                               // variable to track the longest sequence
        ArrayList< Integer > list = new ArrayList<>();      // list to store the sequence elements

        for (int i = 0; i < n; i++) {

            int current = arr[i];               
            int count = 1;                          // variable to track current sequence length

            while (search(arr, current + 1)) {   // checkk if, the array contains the successor of current element or not , while true then executes..
                if(!list.contains(current)){        // checking if the current element is already stored or not in list (to avoid duplicacy)
                    list.add(current) ;
                    list.add(current + 1);          // adding current + 1 also , beacuse the last consecutive element wont't be added then
                }
                current++;              // move current variable to its consecutive + 1 (element)
                count++;        // increase count (whenever consectve found)
            }

            longestt = Math.max(longestt, count);           // finding the longest sequence
        }
        System.out.println("The Longest Consecutive Sequence is : " + longestt);

        return list;
    }

    public static void main(String[] args) {

        int arr[] = {100, 4, 200, 1, 3, 2};
        System.out.println(longest(arr));
    }

}
