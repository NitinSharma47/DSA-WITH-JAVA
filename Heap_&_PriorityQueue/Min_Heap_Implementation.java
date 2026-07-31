/*
 *                                           <<  MIN HEAP IMPLEMENTATION  >>

!               BUT ALWAYS IN HEAP PROBLEMS/QUESTIONS WE USE IT THROUGH ->   IMPORTING PRIORITY QUEUE
                             PriorityQueue < DataType > pq = new PriorityQueue<>()

*               && Priority queue is always in Min heap by default..so the smallest elements have higgher priority to peek() & remove()

*               & To create a Max Priority Queue: ->
                            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());



            * Min Heap:

            1. It is a Complete Binary Tree.
            2. Parent is always <= its children.
            3. Therefore, the smallest element is always at root (index 0).
        
            * Example:
*                                         Array representation:    [5, 10, 20, 30, 40, 50]
            *              5
            *            /   \
            *           10    20
            *          / \    /
            *         30 40  50                                      

 *                                  IMPORTANT FORMULAS:

 *                                  Parent          =   (i - 1) / 2
 *                                  Left Child      =   2 * i + 1
 *                                  Right Child     =   2 * i + 2
*/

public class Min_Heap_Implementation {

    private int[] heap;                         // Array used to store the heap
    private int size;

    public Min_Heap_Implementation() {                          // Constructor with no parameters
        heap = new int[10];                   // initially the capacity is 10
        size = 0;   
    }

    public Min_Heap_Implementation(int capacity) {              // Creates a Min Heap with given capacity.

        heap = new int[capacity];
        size = 0;
    }

    public void insert(int value) {
        if (size == heap.length) {                       // If array is full, increase its size
            resize();
        }

        heap[size] = value;                      //  New element is always inserted at the end. Because Heap must remain a Complete Binary Tree.
        heapifyUp(size);

        size++;                                     // Now increase the number of elements
    }

    private void heapifyUp(int index) {     //*Used to Restores Min Heap property after insertion.(When the child inserted is smaller than its parent)
        while (index > 0) {                 // means not root

            int parent = (index - 1) / 2;       // Find parent of current element.
            if (heap[parent] <= heap[index]) { // If parent is already smaller or equal to current element, Min Heap property is already satisfied.
                break;
            }

            swap(parent, index);            // when Parent is greater than child, swap them.
            index = parent;             // After swapping, the element has moved to the parent position
        }
    }

    public int peek() {                         // used to get minimum index (root)
        if (size == 0) {                        // Heap cannot be empty
            throw new RuntimeException("Heap is empty");
        }

        return heap[0];
    }

    public int remove() {                      // Removes and returns the minimum element.

        if (size == 0) {
            throw new RuntimeException("Heap is empty");
        }
        int minimum = heap[0];                   //  Root contains minimum element. Store it because we have to return it.
        heap[0] = heap[size - 1];                // *Move last element to root. Because We cannot simply remove root because 
                                                // then the Complete Binary Tree structure  would be disturbed.

        size--;                     // One element has been removed.

        if (size > 0) {
            heapifyDown();                      // restore Min Heap property.
        }
        return minimum;
    }

    private void heapifyDown() {            // to Restores Min Heap property after deletion. From Top -> Bottom
        int index = 0;                  // We start from root because after deletion the last element was moved to root.

        while (true) {

            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int smallest = index;           // Initially assume current element is smallest.

            if (left < size && heap[left] < heap[smallest]) {         //  Check whether left child exists. 
                smallest = left;
            }

//         We compare with heap[smallest], NOT heap[index]. This makes sure that we select the smallest among current, left and right.
            if (right < size && heap[right] < heap[smallest]) {        // Check whether right child exists.
                smallest = right;
            }

            if (smallest == index) {
                break;
            }

            swap(index, smallest);          // if Current element is greater than one of its children. Swap it with the smallest child.
            index = smallest;               //  Move downward to the position where the element was moved.
        }
    }

    public int deleteAtIndex(int index) {

        if (index < 0 || index >= size) {                                // if index is not valid
            throw new IndexOutOfBoundsException("Invalid index");
        }
        int deletedValue = heap[index];                     // Store value that we are going to delete
        heap[index] = heap[size - 1];                       // Replace deleted element with last element. This keeps the tree complete.
        size--;                                             // Decrease size

        if (index >= size) {                    // If we deleted the last element, there is nothing left to fix.
            return deletedValue;
        }
        int parent = (index - 1) / 2;          //  Find parent of the replaced element.

        if (index > 0 && heap[index] < heap[parent]) {          // If current element is smaller than parent,it violates Min Heap property.
            heapifyUp(index);                                   // Therefore, move it UP.
        }
        else {                                      // Otherwise, it may violate the property with its children.
            heapifyDownFrom(index);                 // Therefore, move it DOWN.
        }

        return deletedValue;
    }

    private void heapifyDownFrom(int index) {       // Same logic as heapifyDown(),but it starts from a particular index instead of root.

        while (true) {
            int left = 2 * index + 1;           // Find left child & right child
            int right = 2 * index + 2;

            int smallest = index;               
            if (left < size && heap[left] < heap[smallest]) {           // Check left child
                smallest = left;
            }
            if (right < size && heap[right] < heap[smallest]) {         // Check right child
                smallest = right;
            }

            if (smallest == index) {
                break;
            }

            swap(index, smallest);                          // Swap current with smaller child
            index = smallest;                               // Continue from new position                       
        }
    }

    public void buildHeap(int[] arr) {                              // * Converts an UNSORTED array into a Min Heap.

        heap = new int[arr.length];                         // Create heap array with same size as input array.
        size = arr.length;

        for (int i = 0; i < arr.length; i++) {              // Copy array elements into heap
            heap[i] = arr[i];
        }

        int start = (size / 2) - 1;                     // leaf node
        for (int i = start; i >= 0; i--) {    // Start from last non-leaf node and move towards root, Because Leaf nodes already satisfy Heap property
            heapifyDownFrom(i);
        }
    }

    public int size() {                             // Returns number of elements in Heap.
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void display() {                         // Displays Heap in array form.
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }

        System.out.println();
    }

    private void swap(int i, int j) {               // swap function

        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private void resize() {                     // Doubles the array size when it becomes full. This allows our Heap to grow dynamically.
        int[] newHeap = new int[heap.length * 2];       // Create array twice the old size

        for (int i = 0; i < size; i++) {                // Copy old elements
            newHeap[i] = heap[i];
        }

        heap = newHeap;                                // Make new array the active heap array
    }


    public static void main(String[] args) {

        
        Min_Heap_Implementation heap = new Min_Heap_Implementation();               // Create Min Heap

        heap.insert(40);
        heap.insert(20);
        heap.insert(10);
        heap.insert(30);
        heap.insert(5);
        heap.insert(15);

        System.out.println("Min Heap:");
        heap.display();

        System.out.println("Minimum element: " + heap.peek());

        System.out.println("Removed: " + heap.remove());
        System.out.println("After removing minimum:");

        heap.display();

        System.out.println("Size: " + heap.size());
        System.out.println("Is empty: " + heap.isEmpty());

        int[] arr = {40, 10, 30, 5, 20, 15};                            // *BUILD HEAP FROM ARRAY

        Min_Heap_Implementation heap2 = new Min_Heap_Implementation();
        heap2.buildHeap(arr);

        System.out.println("\nHeap built from array:");
        heap2.display();

        System.out.println("Deleted element: " + heap2.deleteAtIndex(2) );
        System.out.println("After deletion:");
        heap2.display();
    }
}