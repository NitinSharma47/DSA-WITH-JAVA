/*                          
*                                                       << OPTIMAL APPROACH >>


                            Given an array where each element represents the height of a histogram bar  
                                        Find the largest rectangular area that can be formed.

                                EX  ->     heights = [2, 1, 5, 6, 2, 3]
                                    ->     Largest rectangle = 10     ->    (formed by bars 5 and 6 → 2 × 5 = 10)

           *Approach ->
                    This approach is a single pass approach instead of a two-pass approach. When we traverse the array by finding the next greater element, we found that some elements were inserted into the stack which signifies that after them the smallest element is themselves
                    So we can find the area of the rectangle by using -> 

*   FORMULA ->      arr[i] * (next smaller element index   - previous smaller element index -1 ).


*                   For an current element , the area that it can made , is found by finding the next smaller value && its previous smaller value
*                   So, current element width become =   next smaller element index - previous smaller element index - 1

*                   And we know that area of the rectangle is ->   Height * width                   ; height is bar[i] , value of current element

                    So, area  = bar[i] * width  ....for every element..
                    By this process , store the area and maximize it untill every element..

*/ 

package STACK_QUEUE ;
import java.util.*;

public class LargestRectangle_InHistogram2 {
    public static int largestRectangle(int[] bar) {

        Stack<Integer> stack = new Stack<>();                               // making stack to store indices
        int maxArea = 0;                                                    // variable to store Maximum area of rectangle 

        int n = bar.length;

        for (int i = 0; i <= n; i++) {                                      // Traverse in the Array
            int curr = (i == n) ? 0 : bar[i];                               // if i is at last element , then current element is 0 , otherwise bar[i]

            while (!stack.isEmpty() && curr < bar[stack.peek()]) {          //if Current height is smaller than previous bar,then it can never be the 
                                                                            // previous smalller , so remove it

                int height = bar[stack.pop()];                              //Take height of bar we are processing

                int width;                      
                if (stack.isEmpty()) {                                      // when there is no previous smaller element for i
                    width = i;                                              // All previous were taller
                } 
                else {
                    width = i - stack.peek() - 1;               // i is the next smaller value & top(stack.peek) element is previous smaller  valeue
                }

                maxArea = Math.max(maxArea, height * width);        // calculate area and maximize it
            }
            stack.push(i);
        }
        return maxArea;
    }
    public static void main(String[] args) {

        int[] bar = {2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangle(bar)); // 10
    }
}