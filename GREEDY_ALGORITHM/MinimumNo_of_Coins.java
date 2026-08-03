/* 
        Given some denominations of coins and a target amount, find the minimum number of coins/notes required to make that amount.
*       Number of Coins are Unlimited

        For example:    Denominations = {1, 2, 5, 10}  ,  Amount = 18
                        We want to use the minimum number of coins/notes.

        The best selection is:  10 + 5 + 2 + 1 = 18   ->    Number of coins/notes:  4

*       The greedy strategy is:   Always choose the largest denomination that does not exceed the remaining amount.
        For:    Amount = 18 ,   Denominations = 10, 5, 2, 1
        We proceed:
                        18
                        ↓
                        Take 10  -> Remaining = 8

                        8
                        ↓
                        Take 5  ->  Remaining = 3

                        3
                        ↓
                        Take 2  ->  Remaining = 1

                        1
                        ↓
                        Take 1  ->  Remaining = 0

                        Therefore:  10 + 5 + 2 + 1 = 18
*                       Answer: Minimum coins/notes = 4
-----------------------------------------------------------------------------------------------------------------------------------------------------

*   Greedy Does NOT Always Work : it does not work for every possible set of denominations  ->>
    Consider:   Denominations = {1, 3, 4}  ,   Amount = 6
    Greedy approach  :  Take the largest possible:

    Amount ->   6
                ↓
           Take 4  ,  Remaining = 2
                ↓
           Take 1  ,  Remaining = 1
                ↓
           Take 1  ,  Remaining = 0

    Greedy gives:   4 + 1 + 1
    Number of coins:  3

    But the optimal solution is:  3 + 3 = 6
    Number of coins:  2

*   So greedy is not universally correct for arbitrary denominations.

*/

import java.util.Arrays;

public class MinimumNo_of_Coins {
    public static int minimum(int coins[], int amount) {

        int minCoins = 0;
        Arrays.sort(coins);

        for (int i = coins.length - 1; i >= 0; i--) {
            while (amount >= coins[i]) {
                amount = amount - coins[i];
                minCoins++;
            }
            if (amount == 0) {
                return minCoins;
            }
        }

        return -1;
    }
}
