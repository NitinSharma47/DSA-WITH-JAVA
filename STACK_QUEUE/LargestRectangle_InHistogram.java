/*        
*                           <<  NOT OPTIMAL APPROACH AND NOT USING STACK  >>

        <<  Given an array where each element represents the height of a histogram bar  >>
                        Find the largest rectangular area that can be formed.

        EX  ->     heights = [2, 1, 5, 6, 2, 3]
                    ->     Largest rectangle = 10     ->    (formed by bars 5 and 6 → 2 × 5 = 10)

        Idea:-    For every bar  ->   expand left and right
                                    find how far we can go where height ≥ current bar
                                        calculate area

        Complexity ->  Time → O(n²)
 */

package STACK_QUEUE ;

public class LargestRectangle_InHistogram {

    public static int largestRectangle(int[] heights) {
        int n = heights.length;
        int maxArea = 0;                                // variable to store Area of rectanngle

        for (int i = 0; i < n; i++) {                           //  takes each bar one by one

            int left = i, right = i;                    // start from current index and then expand in left and right

            while (left >= 0 && heights[left] >= heights[i]) {          //move left until boundary(0 index) or when you find smallerr heights
                left--;
            }

            while (right < n && heights[right] >= heights[i]) {      //move right until boundary(n index) or when you find smaller heights
                right++;
            }

            int width = right - left - 1;          // calculating width , why -1 ? -> because, left and right are OUTSIDE valid range
            int area = heights[i] * width;

            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
    public static void main(String[] args) {
        int heights [] = { 2,1,5,6,2,3};                                    // output 10
        System.out.println(largestRectangle(heights));
    }
}
