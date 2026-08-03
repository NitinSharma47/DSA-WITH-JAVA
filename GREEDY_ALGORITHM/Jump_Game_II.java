/* 
    You are given a 0-indexed array nums of length n representing your maximum jump capability from each index.

    You start at index 0. Each element nums[i] represents the maximum number of steps you can jump forward from index i.
*   Your goal is to reach the last index of the array (nums[n - 1]) using the minimum number of jumps
    Return the minimum number of jumps required to reach the last index.
    You can assume that it is always possible to reach the last index.

*           WE ONLY AIM FOR COUNT THE MINIMUM STEPS TO REACH THE LAST INDEX(DESTINATION)
*/
public class Jump_Game_II {
    public static int step(int jump[]){

        int minJumps = 0 ;
        int maxCoverage = 0 ;                                   // to store the maximum Coverage made by Elements(i) till now
        int LastJumpEnd = 0 ;                                 // we only count the jump , when we are at the index where the maximum coverage is..

        for( int i = 0 ; i < jump.length -1 ; i ++){
            maxCoverage = Math.max(maxCoverage, i + jump[i]) ;

            if(i == LastJumpEnd){                             // we have reach the previous elements Maxcoverage
                LastJumpEnd = maxCoverage ;                   // now update it to current maxcoverage
                minJumps++ ;                                    // Make a jump
            }
            if( maxCoverage >= jump.length - 1){
                return minJumps ;
            }
        }
        return - 1 ;

    }
    public static void main(String[] args) {
        int jump[] = {2, 2, 0, 1, 4} ;
        System.out.println(step(jump));
    }
}
