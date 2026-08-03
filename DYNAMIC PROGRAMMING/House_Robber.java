/*
 You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, 
the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected 
and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house,
    return the maximum amount of money you can rob tonight without alerting the police.(dont rob adjacent houses)

        APPROACH ->
                Make a DP table which store the total money robbed till (i) house..(it already stores the previous houses robbed money)
                Now, to Robb any house you have FORMULA ->  which is used in DP array

                Total Money Robbed till (i) house = MAX(total loot till (i-2) + loot at (i) house , Total loot till (i-1) House )..
        
        BUT, for houses at 0 and 1 index , we have to rob only the which have maximum money..
*/


public class House_Robber {
    public static int rob(int arr[]){

        int m = arr.length ;
        if(m < 2){              // if there are only one house
            return arr[0];
        }

        int dp[] = new int [m]; 

        dp[0] = arr[0] ;                        // for [0] index house 
        dp[1] = Math.max(arr[0], arr[1]);       // for [1] index house, maximum of first and second house..

        for(int i = 2; i < m ; i ++){                       // from third house [2] to last 
            dp[i] = Math.max(dp[i-2] + arr[i], dp[i-1]);      
        }

        return dp[m-1];                             // return last index value of DP array
    }
    public static void main(String[] args) {
        int arr[] = { 2,7,3,1,4,2,1,8};
        System.out.println(rob(arr));
    }
    
}
