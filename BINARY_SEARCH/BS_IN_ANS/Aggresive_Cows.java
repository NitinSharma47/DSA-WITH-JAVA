package BINARY_SEARCH.BS_IN_ANS;

import java.util.Arrays;

public class Aggresive_Cows {
    public static boolean canweplace(int stall[] , int k , int d){

        int count = 0  ;            // variable to count the number of cows placed till..
        int lastPosition = stall[0] ;         // variable to store where the last cow is placed..& first cow is always placed at first position, 
                                                    //  so we initialise it by arr[0].
        for(int i = 0 ; i < stall.length ; i ++){

            if(stall[i] - lastPosition >= d ) {         // checking the distance between the last cow & current position, 
                                                                // if it is greater than the distance d then 
                count ++ ;                                          // the cow can be placed
                lastPosition = stall[i] ;               // now the last cow is at arr[i] place
            }
            if(count >= k){                 // when count becomes more than the number of cow ,means all cows is placed successfully, at distance d
                return true ;
            }
        }
        return false;       // when cows can't placed at distance of d
    }
    public static int answer(int stall [] , int k){

        Arrays.sort(stall);

        int low = 1 ;
        int high = stall[stall.length - 1] - stall [0]  ;     //  high should be the maximum element - minimum element of stall, 
                                                                // becuase the answer can lie in this low to high range only
        while ( low <= high){
            int mid = (low + high) / 2 ;
            
            if(canweplace(stall, k, mid)) {      // initialising the distance d as mid,and checking whether we can place cow at mid distance or not
                low = mid + 1 ;
            }
            else{
                high = mid - 1 ;
            }
        }
        return high ;
    }
    public static void main(String[] args) {
        int stall [] = {1, 2, 8, 4, 9} ;
        int k = 3 ;                            // number of cows

        System.out.println(answer(stall, k));
    }
}
