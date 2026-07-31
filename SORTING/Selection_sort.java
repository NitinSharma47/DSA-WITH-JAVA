package SORTING;

/*              Selection Sort is a simple sorting algorithm in which:-

                We repeatedly find the smallest element
                And place it at its correct position in the array.                                   */

/*                  At every iteration:-

            Pick the minimum element from the unsorted part
            Swap it with the first unsorted index                                                 */

public class Selection_sort{
    public static void sort(int arr[]){
        int n = arr.length;
        int small ;
        for (int i = 0 ; i < n ; i ++){
            small = i;                                  // let's consider the smallest elemennt is  i
            for (int j = i + 1 ; j < n ; j ++ ){
                if ( arr[small] > arr[j]){              // if i is greater than j
                    small = j ;      
                }
            }
            int temporary = arr[i];         //  
            arr[i] = arr[small];
            arr[small] = temporary;
        }
    }
    public static void printarr(int arr[]){
        for ( int k : arr){
            System.out.print(k + " ");
        }
    }
    public static void main(String[] args) {
        int arr[] = { 1,3,7,3,2,4,8,3,9,0};
        sort(arr);
        printarr(arr);
    }
}