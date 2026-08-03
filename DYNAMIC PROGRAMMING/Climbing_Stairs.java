/*                      You are climbing a staircase on N length. It takes some steps to reach the top.
                    Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?..

    APPROACH ->
                First make a DP array which stores the total no. of ways till (i) stair..at i index
    FORMULA ->  The total number of ways to reach any stair (i) is =  Total no. of ways to reach(i-1)  +  Total no. of ways to reach (i-2) stair

    BUT, the ways to reach till the second stair is ->
                        first stair = 1 
                        second stair = 2 

 */
 
public class Climbing_Stairs {
    public static int way(int N){

        if( N == 1){                    // when there is only 1 stair
            return 1 ;
        }

        int dp[] = new int [N + 1];         
        dp[1] = 1 ;                         // when only 1 stair -> then only 1 way
        dp[2] = 2 ;                         // when 2 stair -> then only 2 way

        for(int i = 3 ; i <= N ; i ++ ){
            dp[i] = dp[i-1] + dp[i-2] ;
        }
        
        return dp[N];
    }
    public static void main(String[] args) {
        System.out.println(way(4));
    }
}
