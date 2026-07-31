/*      Given an integer array nums of size n containing values from [1, n] and each value appears exactly once in the array, 
        except for A, which appears twice and B which is missing.

        Return the values A and B, as an array of size 2, where A appears in the 0-th index and B in the 1st index.

Note: You are not allowed to modify the original array.
                                        *The array start from 1 and goes to n..
 */


package ARRAYS.HARD;

import java.util.Arrays;

public class Find_Repeating_And_Missing_No {
    public static int[] find(int arr[]){      
        int A = 0 ;             // missing number 
        int B = 0 ;             // repeating number

        Arrays.sort(arr);

        if(arr[0] != 1){        //  if first index or element is the missing number
            A = 1; 
        }
        for(int i = 0 ; i < arr.length -1 ; i++){
            if(arr[i + 1] - arr[i] > 1) {
                A = arr[i] + 1 ;
            }
            if(arr[i] == arr[i + 1]){
                B = arr[i];
            }
        }
        if(A == 0 && arr[arr.length - 1] != arr.length) {  // if last index[n] element is the missinng number
            A = arr.length ;
        }
        return new int[] {A , B} ;

    }
    public static void main(String[] args) {
        int arr[] = {3, 5, 4, 1, 1} ;
        int res[] = find(arr);

        for(int num : res){
            System.out.println(num + " " );
        }
    }
}
