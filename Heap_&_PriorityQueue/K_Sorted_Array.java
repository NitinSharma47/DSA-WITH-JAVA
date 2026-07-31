/* 
An array is called K-sorted (or nearly sorted) if every element is at most K positions away from its correct position in the sorted array.

Given an array arr[] and a number k . The array is sorted in a way that every element is at max k distance away from it sorted position.
It means if we completely sort the array, then the index of the element can go from i - k to i + k where i is index in the given array. 
Our task is to completely sort the array.

*   Idea ->
            K-Sorted Array
                ↓
            Min Heap
                ↓
            Insert K+1 elements
                ↓
            Remove minimum
                ↓
            Put it in answer
                ↓
            Add next array element
                ↓
            Repeat

*   Why Min Heap?

    Suppose:
    arr = [6, 5, 3, 2, 8, 10, 9]
    K = 3

    The first element of the sorted array must be the smallest among:
    [6, 5, 3, 2]

    Why only these 4?   Because K = 3, so the correct first element can be at most 3 positions away.
    Therefore:  Window size = K + 1

    Put these elements into a Min Heap:
    Min Heap:   2
    So 2 must be the first sorted element. 

    Continue this process
*/

import java.util.PriorityQueue;

public class K_Sorted_Array {
    public static void sortKSorted(int[] arr, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();      // Min Heap
        int index = 0;

        for (int i = 0; i <= k && i < arr.length; i++) {        // Add first K+1 elements
            pq.add(arr[i]);
        }

        for (int i = k + 1; i < arr.length; i++) {              // Process remaining elements
            arr[index++] = pq.poll();                           // Smallest element is in correct position(root) , Remove it 
            pq.add(arr[i]);                                     // Add next element
        }

        while (!pq.isEmpty()) {                                 // Empty remaining heap
            arr[index++] = pq.poll();                           // add the popped small elements(root)
        }
    }

    public static void main(String[] args) {

        int[] arr = {6, 5, 3, 2, 8, 10, 9};
        int k = 3;

        sortKSorted(arr, k);
        System.out.println("Sorted Array:");

        for (int x : arr) {
            System.out.print(x + " ");
        }
    }

    
}
