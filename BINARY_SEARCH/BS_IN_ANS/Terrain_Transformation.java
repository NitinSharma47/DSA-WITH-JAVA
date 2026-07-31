/*      You are given an array of terrain heights, You need to transform it into a strictly decreasing sequence:
        You have a digging team.
        On day D, if you choose any segment, you can reduce(dig) its height by:  
*        2^(D-1)

        You can:-

        Dig multiple segments on the same day.
        Dig the same segment on multiple days.
        Choose which segments to dig each day.

*        The goal is:-     Find the minimum number of days required to make the terrain strictly decreasing.

        Example
        Suppose:    L = [1, 1, 1, 1]

        We need:    L[0] > L[1] > L[2] > L[3]               (Strictly decreasing sequence)

        One possible transformation is:

        Day 1:-   2^(1-1) = 1           subtract 1 from segment 1 and segment 4
                                        [1, 1, 1, 1]
                                         ↓        ↓
                                        [0, 1, 1, 0]

        Day 2:-   2^(2-1) = 2       subtract 2 from segment 3 and segment 4
                                    [0, 1, 1, 0]
                                        ↓  ↓
                                    [0, 1, -1, -2]

        Day 3:    2^(3-1) = 4       subtract 4 from segment 2, 3, and 4
                                    [0, 1, -1, -2]
                                        ↓   ↓    ↓
                                    [0, -3, -5, -6]

                                    Now:  0 > -3 > -5 > -6

*                                   So the answer is: 3

        This example is from the original-style problem statement.
 */
package BINARY_SEARCH.BS_IN_ANS;

public class Terrain_Transformation {

    public static boolean canTransform(long[] terrain, int days) {  //Checks whether the terrain can be made strictly decreasing using at most 'days' days.

        // calculating at max , how much can we dig at particular
        long maxReduction = (1L << days) - 1;       // calculating maximum digging, this (1L << days) - 1 , is equivalent to ->  2^days - 1
        long previous = terrain[0];                 // Keep the first terrain unchanged

        for (int i = 1; i < terrain.length; i++) {          // start with 2 element

            //*  now , we need current value lesser than previous value, so doing previous - 1 , which gives finalvalue(current value) less
            long finalValue = Math.min(terrain[i], previous - 1);       // Current value must be strictly smaller than previous

            long requiredReduction = terrain[i] - finalValue;   //How much do we need to reduce the current terrain?(used to calculate required digging)

            if (requiredReduction > maxReduction) {     // * Check if the required digging is possible ?  if (req >  max)  ->  NO
                return false;
            }

            previous = finalValue;          // update previous index to finalvalue wala index
        }

        return true;
    }

    public static int minimumDays(long[] terrain) {         // function to count minimum days

        int low = 0;                // we are looking for the answer(minimum days) between 0 to 62 days
        int high = 62;          // Why 62? Because 2^62 , is already extremely large for the constraints.

        while (low < high) {
            int mid = low + (high - low) / 2;

            // calling function and checking whether the terrain can be made as decreasing in mid days 
            if (canTransform(terrain, mid)) {          // Approach flow : Try D(mid) days -> Can terrain become strictly decreasing? -> 
                high = mid;                           // Yes → try fewer days
            } 
            else {                             //  No  → 
                low = mid + 1;                //    try more days
            }
        }

        return low;
    }
    public static void main(String[] args) {

        long[] terrain = {-1, 1, 1, 1};
        System.out.println(minimumDays(terrain));
    }
}

/*                                             **    The entire algorithm in one picture    **

                                                            Find minimum D
                                                                    │
                                                                    ▼
                                                            Binary Search on D
                                                                    │
                                                                    ▼
           TRY MORE DAYS (Low = mid + 1) <---- NO <---- Is D days sufficient? ----->  YES ----->  TRY FEWER DAYS (High = mid)
                                                                    │
                                                                    ▼
                                                            maxDigging = 2^D - 1
                                                                    │
                                                                    ▼
                                                        Traverse terrain left → right
                                                                    │
                                                                    ▼
                                                    Choose largest possible value < previous
                                                                    │
                                                                    ▼
                                                        Calculate required reduction
                                                                    │
                                                        ┌───────────┴───────────┐
                                                        ▼                       ▼
                                                    required > max           required <= max
                                                        │                       │
                                                        ▼                       ▼
                                                      false                  continue

*/
