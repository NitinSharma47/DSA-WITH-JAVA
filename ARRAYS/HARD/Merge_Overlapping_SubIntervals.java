/*              Given an array of intervals where intervals[i] = [starti, endi], 
        merge all overlapping intervals and return an array of the non-overlapping intervals that cover all the intervals in the input.

Input : intervals=[[1,3],[2,6],[8,10],[15,18]]
Output : [[1,6],[8,10],[15,18]]
Explanation : Since intervals [1,3] and [2,6] are overlapping we can merge them to form [1,6] intervals.

Input : [[1,4],[4,5]]
Output :  [[1,5]]
Explanation :  Since intervals [1,4] and [4,5] are overlapping we can merge them to form [1,5].
 */

package ARRAYS.HARD;
import java.util.* ;

public class Merge_Overlapping_SubIntervals {
    public static List<List<Integer>> intervals(int arr[][]){

        // Sort intervals based on starting point
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        List<List<Integer>> ans = new ArrayList<>();

        int n = arr.length;
        int i = 0;

        // Loop through intervals
        while (i < n) {
            // Start of merged interval
            int start = arr[i][0];
            int end = arr[i][1];

            int j = i + 1;

            // Check all overlapping intervals
            while (j < n && arr[j][0] <= end) {
                // Extend the end of current interval
                end = Math.max(end, arr[j][1]);
                j++;
            }

            // Add merged interval to result
            ans.add(Arrays.asList(start, end));

            // Move to next non-overlapping interval
            i = j;
        }

        return ans;
    }

    public static void main(String[] args) {
        int arr[][] = {{1,3},{2,6},{8,10},{15,18}} ;
        System.out.println(intervals(arr));
    }
}
