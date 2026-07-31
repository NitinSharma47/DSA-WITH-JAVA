/*                        Given an array of numbers, you need to return the count of reverse pairs. 
*                                Reverse Pairs are those pairs where i<j and arr[i]>2*arr[j].

Example 1:
            Input:
            N = 5, array[] = {1,3,2,3,1)
            Output
            : 2 
            Explanation:
            The pairs are (3, 1) and (3, 1) as from both the pairs the condition arr[i] > 2*arr[j] is satisfied.
Example 2:
            Input:
            N = 4, array[] = {3,2,1,4}
            Output:
            1
            Explaination: 
            There is only 1 pair  ( 3 , 1 ) that satisfy the condition arr[i] > 2*arr[j]                */

package ARRAYS.HARD ;

import java.util.*;

public class Count_Reverse_Pairs{
    public static  List < List < Integer >>  pairs(int arr[]){

        List < List < Integer >> result = new ArrayList<>() ;       // list to store the results

        for(int i = 0 ; i < arr.length  ; i ++){
            for (int j = i+1 ; j < arr.length ; j ++) {             // when i < j

                if(arr[i] > 2 * arr[j] && i < j){                  // check i is greater than twice of j or not
                    result.add(Arrays.asList(arr[i] , arr[j])) ;   // if yes, then make a list of (arr[i] , arr[j] ) , then add it to the result list
                }
            }
        }
        return result ;
    }
    public static void main(String[] args) {
        int arr[] = { 3,2,1,4} ;
        System.out.println(pairs(arr));
    }
}