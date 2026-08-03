/*                  Given a string, Find the longest palindromic subsequence length in given string.

        A palindrome is a sequence that reads the same backwards as forward.
          -> A subsequence is a sequence that can be derived from another sequence by deleting some or no elements 
                        without changing the order of the remaining elements. 

        APPROACH -> 
            Reverse the given string
            Then find, the all subsequences from both (original and reversed)
            find the longest susequence from all subsequence in both string
            If the Subsequqnce is same in both strings , then that is the answer....
                        
                                    <<    CODE KA RATTA MARR..  >>
*/

public class Longest_Palindromic_Subsequence {
    public static int lps(String s){
        
        String rev = new StringBuilder(s).reverse().toString();     //reversing the string
        int n = s.length();             // defining the size of string

        int dp [][] = new int [n+1][n+1] ;              // putting n+1 size, because the subsequence can be empty also " " , so +1

        for(int i = 1 ; i <= n ; i ++){                 // starting from first character of orginal string
            for( int j = 1 ; j <= n ; j ++){                // from first character of reverse string

                if( s.charAt(i - 1) == rev.charAt(j - 1)){      // if the current charcters are equal (dont focus at i-1 or j-1 , it is beacuse of that empty string )
                    dp[i][j] = dp[i-1][j-1] + 1 ;               // then store the prevoius, answer added by 1
                }
                else{                                           // when the charaacters are not equal
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);           // then choose the max from , top cell & left cell
                }
            }
        }
        return dp[n][n];                                // returnn bottom right cell value

    }
    public static void main(String[] args) {
        System.out.println(lps("bbbab"));
    }
    
}
