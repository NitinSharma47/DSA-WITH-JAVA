/* 
    You are given n gas stations arranged in a circular route.
    Two arrays are given:
        gas[i]  → amount of gas available at station i
        cost[i] → gas required to travel from station i to station (i + 1)

    You have an empty tank initially.
    You need to determine the starting gas station index from which you can travel around the entire circuit in clockwise direction 
    exactly once and return to the starting station.

    If it is impossible, return:  -1

*   APPROACH ->

*           Check if the Total gas of Circuit can Make you travel around all gas stations.. if (Total gas >= total Cost) then, Travel is possible
            if total gas < total cost , then it is impossible to travel whole circuit, whether you start from any station

            IF POSSIBLE ->
                Then take a starting Point (u can start from first station)..then , if at any moment in travelling, the current gas < 0 , then not possible
                Now , Try from next starting Point , if possible -> return it

*   IMPORTANT NOTE ->
            If my Current gas becomes negative at station i, I can't start from any station before or at i; Because they all will also gives negative 
            therefore, I start fresh from i + 1. 
            If the total gas is at least the total cost, that final candidate is guaranteed to complete the circuit.

-   Suppose:
    gas  =  [1, 2, 3, 4, 5]
    cost =  [3, 4, 5, 1, 2]

    Let's calculate:

    Station:    0   1   2   3   4
    Gas:        1   2   3   4   5
    Cost:       3   4   5   1   2

-   We need to find a starting station.
    The answer is:  3

    Starting at station 3(index) ->
    Start at 3
    current Gas = 0

    Take 4 gas → 4
    Travel cost = 1 → remaining 3

-   Go to 4
    Take 5 gas → 8
    Travel cost = 2 → remaining 6

-   Go to 0
    Take 1 gas → 7
    Travel cost = 3 → remaining 4

-   Go to 1
    Take 2 gas → 6
    Travel cost = 4 → remaining 2

-   Go to 2
    Take 3 gas → 5
    Travel cost = 5 → remaining 0

    Back to station 3

-   So: Answer = 3

 */

public class Gas_Station {
    public static int circuit(int[] gas, int[] cost) {

        int totalGas = 0;
        int totalCost = 0;

        int currGas = 0;                                        // Gas remaining for the current attempted journey
        int startPoint = 0;                                     // Current candidate starting station

        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];                                 // Total gas available at all stations
            totalCost += cost[i];                               // Total cost required for all stations

            currGas += gas[i] - cost[i];

            if (currGas < 0) {                        // If Current starting point cannot work
                startPoint = i + 1;                   // *Then , the next start Point is after i , not next of previous starting point(key of optimal SOLn)
                currGas = 0;                          // Update it to 0, because now we are moving from different station
            }
        }

        if (totalGas < totalCost) {         // *If the entire system doesn't have enough gas to cover the entire journey, then no starting point can work
            return -1;
        }

        return startPoint;                  // if current startPoint can work , return it
    }

    public static void main(String[] args) {

        int gasStation[] = {1, 2, 3, 4, 5};
        int cost[] = {3, 4, 5, 1, 2};
        System.out.println(circuit(gasStation, cost));
    }
}
