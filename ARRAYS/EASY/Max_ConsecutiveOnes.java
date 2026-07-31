/* Given an array that contains only 1 and 0 return the count of maximum consecutive ones in the array.. */

package ARRAYS.EASY;

public class Max_ConsecutiveOnes {
    public static int maximum(int arr[]){
        int n = arr.length ;

        int frequency = 0 ;
        int count = 0 ;

        for( int i = 0 ; i < n  ; i ++){
            if(arr[i] == 1 ){
                frequency ++ ;
            }
            else{
                frequency = 0 ;
            }
            count = Math.max(count, frequency) ;
        }

        return count ;

    }
    public static void main(String[] args) {
        int arr [] = { 0,1,1,0,0,0,0,1,1,0,1,1,1,1,0,1,0};
        System.out.println(maximum(arr));

    }
}
