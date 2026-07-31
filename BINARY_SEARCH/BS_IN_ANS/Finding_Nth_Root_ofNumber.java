/*                          Given two numbers N and M, find the Nth root of M.
                            The nth root of a number M is defined as a number X when raised to the power N equals M.
                            If the 'nth root is not an integer, return -1.

Examples
Input: N = 3, M = 27
Output: 3
Explanation: The cube root of 27 is equal to 3.
Input : N = 4, M = 69
Output: -1
Explanation : The 4th root of 69 does not exist. So, the answer is -1.

*/

package BINARY_SEARCH.BS_IN_ANS ;

public class Finding_Nth_Root_ofNumber{
    public static int root(int m,int n){

        int low = 1 ; int high = m ;

        while(low <= high){
            int mid = (low + high)  / 2 ;
            long ans = 1 ;

            for(int i = 0; i < n ; i ++){
                ans *= mid ;
                
                if(ans > m ){ break ;}
            }
            if(ans == m) {
                return mid ;
            }
            if(ans > m){
                high = mid - 1 ;
            }
            else{
                low = mid + 1 ;
            }
        }
        return -1 ;
    }
    public static void main(String[] args) {
        int m = 27 ;
        int n = 3 ;
        System.out.println(root(m, n));
    }

}