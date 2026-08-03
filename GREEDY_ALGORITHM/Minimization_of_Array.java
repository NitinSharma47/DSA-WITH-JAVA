/*
*                                                   <<  MOST IMPORTANT PROBLEM  >>

You are given an array A of N numbers, and two operations:

Operation 1 (Subarray Decrement): Pick any continuous section (subarray) and subtract 1 from every element in that section.
Cost: X per operation.

Operation 2 (Single Element Zero-Out): Pick any single element and set it directly to 0.
Cost: Y per operation.

*               X works in range , Y works to the single element
Goal: Find the minimum total cost to make all elements in the array equal to 0 (or less than 0).

*   WORKING ->
    Single Pass Loop: We iterate through array A from index 0 to N - 1 exactly once.
    State Variable (currentCoverage): Represents the height of active range decrements carried over from previous elements.

    At each element num:
    If num <= currentCoverage, it costs 0 extra because it is already reduced by existing decrements.
    If num > currentCoverage, we calculate needed = num - currentCoverage.
    If needed * X < Y, we pay needed * X using Operation 1 and update currentCoverage = num (helping future elements).
    Otherwise, we pay Y using Operation 2 and keep currentCoverage unchanged.

*/
public class Minimization_of_Array {
    public static long getMinCostLinear(int[] A, long X, long Y) {

        if (A == null || A.length == 0) {
            return 0;
        }
        long totalCost = 0;
        long currentCoverage = 0;                               // Tracks the decrement by X operation till current element

        for (int num : A) {
            if (num <= currentCoverage) {                       // Already covered by active range decrements from the left
                continue;                                       // *means the current num is already been decreased by X operation to 0 , so 0 cost will add
            }
            long needed = num - currentCoverage;                // extra decrements needed to make num 0..
            long costOperation1 = needed * X;                   // total cost make , to apply operation 1(X) on current num/element

            if (costOperation1 < Y) {                           // check if cost operation of X is lesser than cost operation of Y(Not calculating total of Y cost , because y can make a single element to 0 only)
                totalCost += costOperation1;                    // Operation 1 is cheaper: Make X operation & add its cost
                currentCoverage = num;                          // update current covergae to current num
            } 
            else {                                              // Operation 2 is cheaper: Make Y operation & add its cost
                totalCost += Y;                                   
                                                                // currentCoverage remains same
            }
        }

        return totalCost;
    }

    public static void main(String[] args) {
        int[] A1 = {5, 1, 5};
        System.out.println("Cost: " + getMinCostLinear(A1, 2, 3)); // Output: 8

        int[] A2 = {2, 3, 2};
        System.out.println("Cost: " + getMinCostLinear(A2, 2, 5)); // Output: 6
    }
}

