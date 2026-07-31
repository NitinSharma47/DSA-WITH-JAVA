//  This code contains both functions to find K largest element or k smallest element.. Use that accordingly to problem..

import java.util.Collections;
import java.util.PriorityQueue;

public class K_Largest_Or_Smallest_Element {

    public static int kthLargest(int[] arr, int k) {                    // * function for K Largest Element
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num : arr) {                   // pq always add the smallest elements first then goes to leaf (larger elements) necause of min heap
            pq.add(num);
            
            if (pq.size() > k) {                // Keep only K elements , then remove the root node -> this process let pq removes all the smaller elements
                pq.poll();                      // while all elementss added in pq , then the root of it only conntain the Kth element(which is already the larger)
            }
        }
        return pq.peek();                       // Root is the Kth largest
    }

    public static int kthSmallest(int[] arr, int k) {                   // * function for K Smallest Element
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());            // Making a max heap

        for (int num : arr) {
            pq.add(num);
            if (pq.size() > k) {                    // Keep only K smallest elements
                pq.poll();
            }
        }
        return pq.peek();                           // Root is the Kth smallest
    }   

    public static void main(String[] args) {

        int[] arr = {3, 2, 1, 5, 6, 4};
        int k = 2;

        System.out.println("Kth Largest = " + kthLargest(arr, k));
        System.out.println("Kth Smallest = " + kthSmallest(arr, k));
    }
}