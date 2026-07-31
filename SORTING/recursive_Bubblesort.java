package SORTING;

public class recursive_Bubblesort {
    public static void bubbleSort(int arr[], int n) {

    // Base condition
        if (n == 1) {
            return;
        }

    // One pass of bubble sort
        for (int i = 0; i < n - 1; i++) {

            if (arr[i] > arr[i + 1]) {

                // Swap
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }   
        }

        // Recursive call
        bubbleSort(arr, n - 1);
    }
        
    
    public static void print_arr(int arr[]) {
        for( int k : arr){
            System.out.print(k + " ");
        }
       
    }
    public static void main(String args[]){

        int arr[] = {2,5,1,6,3,4,2,7};
        bubbleSort(arr, arr.length-1);
        print_arr(arr);

    }
    
}
    

