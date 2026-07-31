/*                                                                      
*                                                              << OPTIMAL APPROACH  >>
*       APPROACH ->
                Start from 0 and make a window of size k , then find the maximum element in window
                Then , add the next element in window & remove the frontest(first) element from window...This maintains the size of window K
                Also Use deque to only store the maximum elements out of every window only
                Do this process till the last element.. and find/add the maximum elements from every window

*       IDEA ->

            ❌ Remove out-of-window indices ..... check by using -> is front == i - k ? means if front is outside the window, then remove it
            ❌ Remove smaller elements from back    
            ✅ Front always = maximum 

            *ONLY STORES USEFUL ELEMENTS IN DEQUE


*       Full Story ->

        we use a double-ended queue (deque) to maintain elements in a way that always keeps track of the current maximum efficiently.
        When a new element enters, we push it to the back of the deque, but before that, we remove all smaller elements from the back 
        since they're not useful anymore. Also, if the element at the front is outside the window's range, we remove it. 
*       This ensures that the element at the front of the deque always represents the maximum of the current window.

*       IF CANT UNDERSTAND !! THEN DO DRY RUN WITH CODE.. U WILL UNDERSTAND IT EASILY FUTURE NITIN >>
            
*/

package STACK_QUEUE;
import java.util.*;

class Sliding_WindowMAX {

    public static int[] maxSlidingWindow(int[] arr, int k) {

        int n = arr.length;
        int[] res = new int[n - k + 1];             //  The size of result array is till the starting index of last window

        Deque<Integer> dq = new ArrayDeque<>();    // use to stores the index , to compare the window elements with array elements

        for (int i = 0; i < n; i++) {

            if (!dq.isEmpty() && dq.peekFirst() == i - k) {         //  If front index is outside window → remove it ... ** dq stores the index 
                dq.pollFirst();                                     //  *pollfirst means --> REMOVE ELEMENT FROM FRONT
            }

            while (!dq.isEmpty() && arr[dq.peekLast()] < arr[i]) {      //  If current element is bigger ? Remove all smaller elements from back(last)
                dq.pollLast();                                          //  polllast means --> REMOVE ELEMENT FROM END
            }

            // add current index
            dq.offerLast(i);                            // offerlast means --> ADD ELEMENT AT END

            // Now deque is in - decreasing order (big → small)                

            // 4. store result
            if (i >= k - 1) {                               //  When first window forms -->  
                res[i - k + 1] = arr[dq.peekFirst()];       //store front (because,front = maximum element)
            }
        }

        return res;
    }
    public static void main(String[] args) {

        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] result = maxSlidingWindow(arr, 3);

        // print result
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}

