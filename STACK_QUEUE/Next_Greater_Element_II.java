/* Given a circular integer array arr, return the next greater element for every element in arr.
The next greater element for an element x is the first element greater than x that we come across while traversing the array in a clockwise manner.
If it doesn't exist, return -1 for that element element.

*               Here the Array is circular, so after the last element it goes back to starting element..
                Also , becuase it is circular -> if the last element is not the greatest element of whole array , 
                    then its value is not also -1 , because afte circulating again in array it finds its next greater 
 */
package STACK_QUEUE;

import java.util.*;

class Next_Greater_II {

    public static int[] nextGreaterElements(int[] arr) {
        int n = arr.length;

        int[] ans = new int[n];                         // To store the next greater elements

        Stack<Integer> st = new Stack<>();
        
        for (int i = 2 * n - 1; i >= 0; i--) {          // Traverse the array twice in reverse to simulate circular array

            int ind = i % n;                        // when i goes > than length of arr , so to define the index again by circulation , this statement is used
            int currEle = arr[ind];
           
            while (!st.isEmpty() && st.peek() <= currEle) {      // Pop all elements from stack that are less than or equal to current
                st.pop();
            }

            if (i < n) {                // Only fill result in the first pass (i < n)

                if (st.isEmpty()) {
                    ans[ind] = -1;
                } else {
                    ans[ind] = st.peek();
                }
            }

            st.push(currEle);               // Push current element to stack
        }
        return ans;
    }
    
    public static void main(String[] args) {
        int[] arr = {5, 7, 1, 7, 6, 0};

        int[] ans = nextGreaterElements(arr);                     // Call the function

        System.out.print("The next greater elements are: ");
        for (int num : ans) {
            System.out.print(num + " ");
        }
    }
}
