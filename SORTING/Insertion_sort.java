/* 
Insertion Sort is a sorting algorithm where:

We take one element at a time
and place it at its correct position 
in the sorted part of the array. 

Core Logic-

For every element:-

Store current element
Compare with previous elements
Shift larger elements
Insert at correct position

*/


package SORTING;
public class Insertion_sort {

    public static void insertionSort(int arr[]) {

        int n = arr.length;

        for (int i = 1; i < n; i++) {

            int key = arr[i];
            int j = i - 1;                 // j points to previous element(i-1) for comparison

            // Shift elements greater than key
            while (j >= 0 && arr[j] > key) {

                arr[j + 1] = arr[j];
                j--;
            }

            // Insert key at correct position
            arr[j + 1] = key;
        }
    }

    public static void printArray(int arr[]) {

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void main(String[] args) {

        int arr[] = {5, 3, 4, 1, 2};

        insertionSort(arr);

        System.out.println("Sorted Array:");

        printArray(arr);
    }
}