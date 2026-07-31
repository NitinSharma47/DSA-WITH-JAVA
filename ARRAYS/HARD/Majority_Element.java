/*                      Find all the element which appears more than n/3 times in the array , and return them

*                         There can be 1 or 2 elements which can be major..or none..
                Three or more major elements are not possible because -  for elements A,B,C   ->
                        frequency of A + frequency of B + frequency of C  >  n/3 + n/3 + n/3 = n.
                                            So,it is not possible...
*/

package ARRAYS.HARD;
import java.util.*;

public class Majority_Element {
    public static List<Integer > major(int arr[]){

        int n = arr.length ;
        List < Integer > res = new ArrayList<>() ;

        for(int i = 0 ; i < n ; i ++){
            if(!res.contains(arr[i])){          // if arr[i] is not added before or if it is unique

                int frequency = 0 ;
                for( int j = 0 ; j < n ; j ++){
                    if( arr[i] == arr[j]){
                        frequency ++ ;
                    }
                }
                if( frequency >  n / 3){
                    res.add(arr[i]);
                }
            }
            if(res.size() == 2){            // when size of res list reaches 2, then break the loop
                break ;
            }
        }
        return res ;
    }
    public static void main(String[] args) {
        int arr[] = { 1,2,2,2,1,3,1,1,2,2,1,2,3,3,3,3,3,3} ;
        System.out.println(major(arr));
    }
}
