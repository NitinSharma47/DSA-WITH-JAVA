/*                  Given two integers m and n, representing the number of rows and columns of a 2d array named matrix. 
            Return the number of unique ways to go from the top-left cell (matrix[0][0]) to the bottom-right cell (matrix[m-1][n-1]).

            Movement is allowed only in two directions from a cell: right and bottom. 

    FORMULA  -> Add the upper cell and left cell's ways(value) to get the , total number of unique ways at any givenn cell [i][j]
        
*/

public class unique_Path {
    public static int unique(int m , int n){
        
        int dp[][] = new int [m][n];
        for(int i = 0 ; i < m ; i ++ ){
            for ( int j = 0 ; j < n ; j ++ ){

                if(i == 0 || j == 0 ){                  // when row and column iss 1
                    dp[i][j] = 1 ;             // then ,there is only a single way to reach any cell there, so fill 1 in every cell there (of row, column = 1)
                }
                else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-1] ;          // add the upper and left cell's ways to get the , total number of unique ways at any givenn cell
                }
            }
        }
        return dp[m-1][n-1] ;               // because the last cell is [m-1][n-1]  -> [2][7]
    }
    public static void main(String[] args) {
        System.out.println(unique(3, 7));
    }
}
