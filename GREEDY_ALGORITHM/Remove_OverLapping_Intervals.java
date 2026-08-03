/* 
Given an array of N intervals in the form of (start[i], end[i]), where start[i] is the starting point of the interval and end[i] 
is the ending point of the interval, return the minimum number of intervals that need to be removed to make the remaining intervals non-overlapping. .

Input: Intervals = [ [1, 2], [2, 3], [3, 4], [1, 3] ]  
Output: 1  
Explanation: You can remove the interval [1, 3] to make the remaining intervals non-overlapping.

*   APPROACH ->
    To keep the maximum number of non-overlapping intervals, we need to remove the minimum number of overlapping ones.
*   We sort intervals by their end times and always pick the next interval that starts after the last selected one ends.The rest need to be removed

*   STEPS ->
    Sort all intervals based on their end time in ascending order.
    Initialize a variable to store the end time of the last non-overlapping interval (e.g., set to the end of the first interval).
    Initialize a counter to track how many intervals need to be removed.
    Traverse the remaining intervals:

*   If the start of the current interval is greater than or equal to the end time of the last added interval, update the end time.
    Else, it overlaps increment the removal counter.
    Return the counter at the end as the minimum number of intervals to remove.
 
*/

import java.util.*;

public class Remove_OverLapping_Intervals {
    public static int eraseOverlapIntervals(int[][] intervals) {
       
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);                                  // Sort intervals by their end time
        int count = 0;                                                                  // Counter for how many intervals we need to remove

        int prevEnd = intervals[0][1];                                                  // Track end time of last non-overlapping interval,
                                                                                        // currently initialize with end time of 0 index.... 
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < prevEnd) {                                      // *If current interval overlaps with previous(start < end of prev)
                count++;                                                          // Increment count to remove this interval
            } 
            else {
                prevEnd = intervals[i][1];                                        // Update previous end time to current Interval's  end time
            }
        }
        return count;
    }

    public static void main(String[] args) {

        int[][] intervals = { {1, 3}, {2, 4}, {3, 5}, {1, 2} };
        System.out.println("Minimum number of intervals to remove: " + eraseOverlapIntervals(intervals));
    }
}

