/*          A monkey Koko is given ‘n’ piles of bananas, whereas the 'ith' pile has ‘a[i]’ bananas. 
            An integer ‘h’ is also given, which denotes the time (in hours) for all the bananas to be eaten.

            Each hour, the monkey chooses a non-empty pile of bananas and eats ‘k’ bananas.
            If the pile contains less than ‘k’ bananas, then the monkey consumes all the bananas and won’t eat any more bananas in that hour.

*           Find the minimum number of bananas ‘k’ to eat per hour so that the monkey can eat all the bananas within ‘h’ hours.

Examples

Input: N = 4, a[] = {7, 15, 6, 3}, h = 8
Output: 5
Explanation:  If Koko eats 5 bananas/hr, he will take 2, 3, 2, and 1 hour to eat the piles accordingly.
              So, he will take 8 hours to complete all the piles.  

Input: N = 5, a[] = {25, 12, 8, 14, 19}, h = 5
Output: 25
Explanation: If Koko eats 25 bananas/hr, he will take 1, 1, 1, 1, and 1 hour to eat the piles accordingly. 

*/

package BINARY_SEARCH.BS_IN_ANS;

public class KOKO_Eating_Banana {
    public static int koko(int banana[] , int hour){

        int low = 1 ; int high = maxElement_in_banana(banana) ;         // the answer must lie in the range [1....maxElement] in banana
        int ans = maxElement_in_banana(banana) ;

        while(low <= high){
            int mid = (low + high) / 2 ;
            double totalhours = 0 ;

            for(int i = 0 ; i < banana.length ; i ++){

                if(banana[i] % mid == 0){                   // when banana[i] is divisible by mid
                    totalhours +=  banana[i] / mid ;
                }else{
                    totalhours += (banana[i] / mid ) + 1 ;      // +1 because of (waste time)koko waits, when it already eats all bananas in a pile
                }
            }
            if(totalhours <= hour){
                ans = mid ;
                high = mid - 1 ;
            }
            else{
                low = mid + 1 ;
            }
        }
        return ans ;

    }
    public static int maxElement_in_banana(int banana[]){           // function to count the maximum element in banana

        int max = Integer.MIN_VALUE ;
        for(int i = 0 ; i < banana.length-1 ; i ++ ) {
            if(banana[i] > banana[i+1]){
                max = Math.max(max , banana[i]) ;
            }
            else{
                max = Math.max(max , banana[i+1]) ;
            }
        }
        return max ;
    }
    public static void main(String[] args) {
        int banana [] = {7, 15, 6, 3} ;
        int hour = 8 ;
        System.out.println(koko(banana,hour)) ;
    }
}
