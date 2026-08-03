/*                           EDIT DISTANCE ->

    We are given two strings ‘S1’ and ‘S2’. We need to convert S1 to S2. 
        The following three operations are allowed:-

       - Deletion of a character.
       - Replacement of a character with another one.
       - Insertion of a character.

    ->>  We have to return the minimum number of operations required to convert S1 to S2 as our answer.


 */
public class Edit_Distance {
    public static int distance( String a , String b){      // we have to covert string a to string b

        int m = a.length();         // defining the length of a and b
        int n = b.length();

        int dp[][] = new int [m+1][n+1];            // creating a 2 dimensional DP array Table to store, string a and string b,  of length m and n
                                                    //  [i] is row , and [j] is column
        for(int i = 0 ; i <= m ; i ++){             //filling the first row in table , i.e -> empty string
            dp[i][0] = i ;
        }
        for ( int j = 0 ; j <= n ; j ++){           // filling the first column in table ,  i.e -> empty string
            dp[0][j] = j ;
        }

        for( int i = 1 ; i <= m ; i ++){
            for ( int j = 1 ; j <= n ; j ++){
                if( a.charAt(i-1) == b.charAt(j-1)){                    // when characters are same
                    dp[i][j] = dp[i-1][j-1];                        // then , copy the previous answer in current block
                }
                else{                                               // when characters are not same ,  then we have three choice ->
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1] , Math.min(dp[i-1][j] , dp[i][j-1]));    // took minimmum of three choiices and add by 1...
                }                    //       (replace)              (delete)       (insert)
            }
        }
        return dp[m][n];            // return last block of table
    }

    public static void main(String[] args) {
        System.out.println(distance("horse","ros"));
    }
    
}
