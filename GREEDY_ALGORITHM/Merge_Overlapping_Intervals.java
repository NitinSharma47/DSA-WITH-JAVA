/* 
        Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals and 
        return an array of the non-overlapping intervals that cover all the intervals in the input.

*       OverLapping Condition = When start of current Interval is Less than the End of Previous Interval , -> means it is coming b/w 

        Input : intervals=[[1,3],[2,6],[8,10],[15,18]]
        Output : [[1,6],[8,10],[15,18]]
        Explanation : Since intervals [1,3] and [2,6] are overlapping we can merge them to form [1,6] intervals.

 */
import java.util.*;

public class Merge_Overlapping_Intervals {
    public static int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));               // Sort intervals by starting point
        ArrayList<int[]> result = new ArrayList<>();                                 // Array list to store merged Intervals

        for (int i = 0; i < intervals.length; i++) {
            
// If result is empty && starting of current interval is greater than ending of previous interval -> means Both intervals are different, No overLap

            if (result.isEmpty() || intervals[i][0] > result.get(result.size() - 1)[1]) {       // intervals[i][0]  means start of current
                                                                                // result.get(result.size() - 1)[1]  means last interval's endTime[1]
                result.add(new int[]{intervals[i][0], intervals[i][1]});
            } 
            else {                                                                     // Overlapping intervals → merge
                result.get(result.size() - 1)[1] = Math.max(result.get(result.size() - 1)[1], intervals[i][1]);
        // get the last interval to update its endtime , then choose the maximum from -> endTime of Last Interval && end time of current Intervals
            }
        }
        return result.toArray(new int[result.size()][]);            // return ArrayList as array
    }

    public static void main(String[] args) {

        int[][] intervals = {
            {1, 3},
            {2, 6},
            {8, 10},
            {9, 12}
        };

        int[][] ans = merge(intervals);

        for (int[] interval : ans) {
            System.out.println(
                "[" + interval[0] + ", " + interval[1] + "]"
            );
        }
    }
}
