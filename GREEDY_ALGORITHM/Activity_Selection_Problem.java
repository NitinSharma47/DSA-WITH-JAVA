/* 
    You are given N activities. Each activity has a start time and a finish time.
    Only one activity can be performed at a time. 

    An activity can be selected if its start time is greater than or equal to the finish time of the previously selected activity.
    Your task is to select the maximum number of non-overlapping activities.

*                                    Greedy rule  :  Select the activity that finishes earliest.(First Do that activity)
-   Input
    First line: An integer N, representing the number of activities.
    Second line: N integers representing the start times.
    Third line: N integers representing the finish times.

-   Output
    Print the maximum number of activities that can be performed without overlapping.

-   Input:
        6
        1 3 0 5 8 5
        2 4 6 7 9 9

-   Output:    4

*                                    SAME PROBLEM LIKE JOB SEQUENCING WITH DEADLINE

*/

import java.util.*;

public class Activity_Selection_Problem {
    public static int activitySelection(int[][] activities) {

        Arrays.sort(activities, (a, b) -> Integer.compare(a[1], b[1]));             // Sort activities by their finishing time
        int count = 1;
        int lastFinish = activities[0][1];                                          // Finish time of the first selected activity

        for (int i = 1; i < activities.length; i++) {                               // Check remaining activities
            if (activities[i][0] >= lastFinish) {           // *Activity can be selected if it starts after or exactly when the previous one finishes
                count++;
                lastFinish = activities[i][1];              // UPDATE
            }
        }

        return count;
    }

    public static void main(String[] args) {

        int[][] activities = {
            {1, 2},
            {3, 4},
            {0, 6},
            {5, 7},
            {8, 9},
            {5, 9},
            {8, 11},
            {12, 14}
        };
        System.out.println(activitySelection(activities));
    }
}
