/* Given an array of integers, rotating array of elements by k elements either left or right.


TRICK ->
            For Right Rotation by k steps:

                Reverse the entire array
                Reverse the first k elements
                Reverse the remaining n - k elements

            For Left Rotation by k steps:

                Reverse the first k elements
                Reverse the remaining n - k elements
                Reverse the entire array 
                
*/

package ARRAYS.EASY;

public class Right_Rotateby_Kplaces {
    public static void reverse(int arr [] , int start , int  end) {             //  making the reverse function using two pointers technique
        
        while ( start < end){
            int temp = arr[start]; 
            arr[start] = arr[end] ; 
            arr[end] = temp ;

            start++ ; end -- ;
        }

    }
    public static void rotate(int arr [] , int k){
        int n = arr.length ;
        reverse(arr, 0, n-1);           // reversing the whole array
        reverse(arr, 0, k-1);           // reversing the first K elements
        reverse(arr, k, n-1);                  // reversing the remaining elements

    }
    public static void main(String[] args) {
        int arr [] = { 4,5,6,7,8,9,1,2};
        rotate(arr, 3);
        for(int num : arr) {
            System.out.print(num);
        }
    }
}
