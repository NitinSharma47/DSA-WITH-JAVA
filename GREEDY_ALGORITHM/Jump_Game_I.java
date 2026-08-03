/* 
    Given an array where each element represents the maximum number of steps you can jump forward from that element, 
    return true if we can reach the last index starting from the first index. Otherwise, return false.

    Example 1:
    Input:nums = [2, 3, 1, 0, 4]
    Output: True           
    Explanation: 
    We start at index 0, with value 2 this means we can jump to index 1 or 2.
    From index 1, with value 3, we can jump to index 2, 3, or 4. However, if we jump to index 2 with value 1, we can only jump to index 3.
    So we jump to index 1 then index 4 reaching the end of the array.
    Hence, we return true.
 */

class Jump_Game_I {
    public static boolean jumpy(int jump[]){

        int n = jump.length ;
        int destination = n - 1 ;                               // last index
        int maxCoverage  = 0 ;                                  // the max index from where we can reach from all (i)elements

        for(int i = 0 ; i < n ; i ++){
            if(i > maxCoverage) {                               // if current element is not reachable
                return false;
            }
            maxCoverage = Math.max(maxCoverage , jump[i] + i) ;         // calculating max coverage
            
            if(maxCoverage >= destination){
                return true ;
            }
        }
        return false ;
    }

    public static void main(String[] args) {
        int jump [] = {2, 3, 1, 0, 4} ;
        System.out.println(jumpy(jump));
    }
    
}
