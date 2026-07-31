/*      There’s an array ‘A’ of size ‘N’ with an equal number of positive and negative elements. 
            Without altering the relative order of positive and negative elements, 
            you must return an array of alternately positive and negative values.

Example :
Input:
arr[] = {1,2,-4,-5}, N = 4
Output:
1 -4 2 -5
Explanation: 
Positive elements = 1,2
Negative elements = -4,-5
To maintain relative ordering, 1 must occur before 2, and -4 must occur before -5.

*/

package ARRAYS.MEDIUM ;

public class Rearranging_Elements_BySign {
    public static int[] arrange(int arr[]){
        int n = arr.length ;
        int positive =  0 , negative = 1 ;              // assigning the indexes to start filling negative & postive elements from..

        int result [] = new int[n];

        for (int i = 0 ; i < n ; i++){
            if(arr[i] > 0){
                result[positive] = arr[i] ;
                positive += 2 ;                 // positive = 2 + positive    ( increasing the posoitive variable by 2)
            }else{
                result[negative] = arr[i];
                negative += 2 ;
            }
        }
        return result ;
    }
    public static void main(String[] args) {
        int arr [] = {1, 2, -4, -5};
        int resultarray [] = arrange(arr) ;
        for(int num : resultarray){
            System.out.print(num + " ");
        }
    }
}
