package SORTING;

public class recursive_Insertionsort {
    public static void insertionSort(int arr[], int n) {

        // Base condition
        if (n <= 1) {
            return;
        }

        // Sort first n-1 elements
        insertionSort(arr, n - 1);

        // Last element to insert
        int last = arr[n - 1];

        int j = n - 2;

        // Shift greater elements
        while (j >= 0 && arr[j] > last) {

            arr[j + 1] = arr[j];
            j--;
        }

        // Insert element at correct position
        arr[j + 1] = last;
    }

    public static void main(String[] args) {

        int arr[] = {5, 3, 4, 1, 2};
        insertionSort(arr, arr.length);

        for( int num :arr){
            System.out.print(num + " ");
        }
    }
}
    
