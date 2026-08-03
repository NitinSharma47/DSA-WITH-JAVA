/* 
        Given a set of coins and a Target Amount..find the minimum number of coins combination to make the target Amount
        
        APPROACH  ->
                make a dp array , to store the minimum coins till [i] amount..
                to find the minimum coins at a amount[i]..  ->
                    check which coins are less than the amount[i]  ...only those are eligible
                    for every eligible coin ,  subtract the coin from the amount [i]..
                    then take the result and check in that -> amount[result], how many coins are needed to make that amounnt..
                    now add the 1 to the answer
                    now, take minimum of the all for every eligible coin...
*/

import java.util.Arrays;

public class MinimumCoin_Change {
    public static void main(String[] args) {
        int coins[] = { 1,2,5} ;
        int amount = 11 ;

        int dp[] = new int [amount + 1] ;       // we took size of array (amount + 1) , beacause it then become 12 (11 + 1)..so, it works as infinity
        Arrays.fill(dp, amount + 1);            // we fill [12] at every index of DP array..
        dp[0] = 0 ;                             // when amount is 0.. then minimum coins also 0

        for( int i = 1 ; i <= amount ; i ++ ){              // from amount 1 to original amount target
            for (int coin : coins) {                       // to traverse every coin in coin array
                if(coin <= i){              // only when the coin is lesser than the amount , means it  is eligible to use
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1) ;    // take minimum of dp[i] which is 12(11+1) and denomination of coin
                }
            }
        }
        System.out.println(dp[amount] > amount ? -1 : dp[amount]);   // if amount in dp is greater than real amount then return -1 because it means no output can be make, 
                                                        // else return amount in dp
    }
    
}
