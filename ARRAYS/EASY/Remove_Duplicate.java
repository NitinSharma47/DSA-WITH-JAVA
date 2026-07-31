/*      Removing duplicate elements from the sorted Array       */

package ARRAYS.EASY;
import java.util.Arrays;

public class Remove_Duplicate {
    public static int[] dup(int arr[]) {
        int n = arr.length;
        Arrays.sort(arr);

        int temp[] = new int[n];
        int k = 0;

        temp[k++] = arr[0];

        for(int i = 1; i < n; i++) {            // starting from i = 1 because , 0 is already stored
            if(arr[i] != arr[i - 1]) {        // when the element is not same as the previous one(i.e,- unique)
                temp[k++] = arr[i];
            }
        }

        return temp;     // we can also return ->(return Arrays.copyOf(temp, k); it is useful when we dont want unwanted zeroes at last of th array
    }
    public static void main(String[] args) {
        int arr [] = { 4,4,4,5,5,6,7,7,7,7,8,9};
        int result[] = dup(arr);
        for ( int j : result){
            System.out.print(j + " ");

        }
    }
}