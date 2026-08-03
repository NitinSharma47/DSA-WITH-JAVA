/* 
    Insert Interval is a common Greedy Algorithm problem. 
    The main idea is to insert a new interval into an already sorted list of non-overlapping intervals and merge it with any intervals that overlap.

    Given a list of intervals sorted by their start time:   [1,3], [6,9]
    and a new interval: [2,5]

    Insert the new interval and merge overlapping intervals.
    Answer ->   [1,5], [6,9]

*/

import java.util.ArrayList;
import java.util.List;

public class Insert_Interval {
    public static int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> result = new ArrayList<>();                                     // List to store all intervals after insert

        int i = 0;
        int n = intervals.length;

        while (i < n && intervals[i][1] < newInterval[0]) {                         // *Add intervals that come before newInterval
            result.add(intervals[i]);
            i++;
        }
        while (i < n && intervals[i][0] <= newInterval[1]) {                        // *Merge overlapping intervals
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);             // *Taking minimum Starting point
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);             // *Taking maximum of Ending Point

            i++;
        }
        result.add(newInterval);                                                    // Add the merged interval

        while (i < n) {                                                             // *Add remaining intervals
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);                            // Returning result as Array
    }
    public static void main(String[] args) {
        int[][] intervals = {
            {1, 2},
            {3, 5},
            {6, 7},
            {8, 10},
            {12, 16}
        };

        int[] newInterval = {4, 8};
        int[][] result = insert(intervals, newInterval);
        System.out.println("Result:");

        for (int[] interval : result) { System.out.println( "[" + interval[0] + ", " + interval[1] + "]" );
        }
    }
}
