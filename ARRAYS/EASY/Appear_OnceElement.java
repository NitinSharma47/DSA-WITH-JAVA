/*  Given a non-empty array of integers arr, every element appears twice except for one element. Find that single one element.   */

package ARRAYS.EASY;

public class Appear_OnceElement {
    public static int num(int arr[]){
        
        for(int i = 0 ; i < arr.length ; i ++){
            int frequency = 0  ;

            for(int j = 0 ; j < arr.length ; j ++){
                if (arr[j] == arr[i]){
                    frequency ++ ;
                }
            }
            if ( frequency == 1) {
                return arr[i];
            }
        }
        return -1 ;
    }
    public static void main(String[] args) {
        int arr[] = { 2,3,1,3,5,3,2,2,1,3,4,5,6,5,6};
        System.out.println(num(arr));
    }
}
