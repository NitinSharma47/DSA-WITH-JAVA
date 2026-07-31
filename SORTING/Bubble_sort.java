package SORTING;

/* Here In bubble sort , Adjacent elements are compared and swapped (if they are in the wrong order)
The largest element “bubbles up” to the end after every pass. */


public class Bubble_sort {
    public static void sort( int arr[]){
        int n = arr.length;
         
        for ( int i = 0 ; i < n-1 ; i ++){
            for( int j = 0; j < n-i-1 ; j ++){
                if ( arr[j] > arr[j+1]){

                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp ;

                }
            }       
        }
        
    }
    public static void print_arr(int arr[]) {
        for( int k : arr){
            System.out.print(k + " ");
        }
       
    }
    public static void main(String args[]){

        int arr[] = {2,5,1,6,3,4,2,7};
        sort(arr);
        print_arr(arr);

    }
    
}
