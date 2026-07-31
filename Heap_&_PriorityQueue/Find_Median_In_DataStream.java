/* 
*   PROBLEM
    Implement a class that finds the median from a data stream. The median is the middle value in an ordered integer list. 
    If the size of the list is even, there is no middle value, and the median is the mean of the two middle values.

    Implement the MedianFinder class as follows:
-   MedianFinder() initializes the MedianFinder object.
-   void addNum(int num) adds the integer num to the data structure.
-   double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.

*   1. The Main Idea — Two Heaps

                    We divide the numbers into two halves:

                                All Numbers
                                   |
                            ┌──────┴──────┐
                            ↓             ↓
                        Left Half     Right Half
                            ↓             ↓
                        Max Heap       Min Heap

*   Left Half → Max Heap    The largest element of the left half is available at the top.
*   Right Half → Min Heap   The smallest element of the right half is available at the top.

    For example:
    Numbers = [1, 3, 5, 15]         Left half:   [1, 3]         Right half:  [5, 15]

    So:
    left.peek()  = 3 ,  right.peek() = 5
    Median: (3 + 5) / 2 = 4


*   2. Why Two Heaps?
    Because the median is located around in the middle of sorted data.

    Suppose:    [1, 3, 5, 7, 9]         Median: 5
    If we divide it->   Left:   [1, 3, 5]   Right:  [7, 9]

    We need quick access to the boundary between the two halves.
    That's exactly what the heaps provide:

    Max Heap → largest of left half
    Min Heap → smallest of right half

*   3. Rules We Maintain
        There are two important rules.

-   Rule 1: Size difference should be at most 1
    |maxHeap.size() - minHeap.size()| <= 1

    For example:  Max Heap = 3 elements   Min Heap = 2 elements     is valid.
    But:          Max Heap = 5            Min Heap = 2              is invalid.

-   Rule 2: Every element in Max Heap ≤ every element in Min Heap
    Conceptually:

    Max Heap                  Min Heap
    [1, 3, 5]    |           [7, 9, 10]
                 ↑
            boundary

    So: maxHeap.peek() <= minHeap.peek()

*   4. Then Balance the Heaps

    After insertion, one heap might become too large.

    If: maxHeap.size() > minHeap.size() + 1
    Move the largest element from Max Heap to Min Heap:
    minHeap.add(maxHeap.poll());

    If: minHeap.size() > maxHeap.size() + 1
    Move the smallest element from Min Heap to Max Heap
    maxHeap.add(minHeap.poll());


        *                                   <<  FULL APPROACH >>
                                            FIND MEDIAN FROM DATA STREAM

                                            Use TWO HEAPS:

                                            1. Max Heap → Left Half
                                            2. Min Heap → Right Half

                                            Rules:
                                            - Size difference ≤ 1
                                            - MaxHeap.peek() ≤ MinHeap.peek()

                                            For insertion:
                                                if num <= maxHeap.peek()
                                                    add to Max Heap
                                                else
                                                    add to Min Heap

                                            Then balance:

                                            if maxHeap.size() > minHeap.size() + 1
                                                move maxHeap.poll() → minHeap

                                            if minHeap.size() > maxHeap.size() + 1
                                                move minHeap.poll() → maxHeap

                                            For median:

                                            if maxHeap.size() > minHeap.size()
                                                maxHeap.peek()

                                            else if minHeap.size() > maxHeap.size()
                                                minHeap.peek()

                                            else
                                                (maxHeap.peek() + minHeap.peek()) / 2.0


*   <<      Median of a stream = Max Heap for the left half + Min Heap for the right half.      >>
    
*/

import java.util.PriorityQueue;
import java.util.Collections;

public class Find_Median_In_DataStream {

    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());     // Max Heap → left half (stores the smaller half of numbers)
    static PriorityQueue<Integer> minHeap = new PriorityQueue<>();                               // Min Heap → right half (stores the larger half.)

    public static void addNumber(int num) {                     // To Add a number to the data stream

        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {        // Decide which heap gets the number
            maxHeap.add(num);
        } 
        else {
            minHeap.add(num);
        }

        if (maxHeap.size() > minHeap.size() + 1) {              // Balance the heaps
            minHeap.add(maxHeap.poll());
        }
        else if (minHeap.size() > maxHeap.size() + 1) {
            maxHeap.add(minHeap.poll());
        }
    }

    public static double findMedian() {                                // Function to return the current median

        if (maxHeap.size() == minHeap.size()) {                 // If equal sizes, return average of them
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }

        return maxHeap.peek();                                  // Otherwise, return top of maxHeap
    }


    public static void main(String[] args) {

        int[] stream = {5, 15, 1, 3};
        for (int num : stream) {
            addNumber(num);
            System.out.println("Added: " + num + " | Median: " + findMedian());
        }
    }
}