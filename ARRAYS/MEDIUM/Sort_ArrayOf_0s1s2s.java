/*              Given an array nums consisting of only 0, 1, or 2. Sort the array in non-decreasing order. 
                    The sorting must be done in-place, without making a copy of the original array. 
*/

package ARRAYS.MEDIUM;

public class Sort_ArrayOf_0s1s2s {
    public static void main(String[] args) {
        int arr[] = { 2,2,1,1,0,0,1,1,2,2,0,2,1,2,0,1,2};
        int n = arr.length ;
        for (int i = 0 ; i < n ; i ++){
            for( int j = i+1 ; j < n ; j ++){
                if(arr[i] < arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j] ; 
                    arr[j] = temp ;
                }

            }
        }
        for(int num : arr){
            System.out.print(num);
        }

    }
    
}
