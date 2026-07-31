/* 
    Given heads of k sorted linked lists as an array called heads, merge them into one single sorted linked list and return the head of that list.

            Suppose we have:

            List 1: 1 → 4 → 7
            List 2: 2 → 5 → 8
            List 3: 3 → 6 → 9

We want:    1 → 2 → 3 → 4 → 5 → 6 → 7 → 8 → 9

        *Our approach is:

            K sorted lists
                ↓
            Put first node of every list into Min Heap
                ↓
            Remove smallest node
                ↓
            Add it to result
                ↓
            Add the next node from the same list
                ↓
            Repeat
*/

import java.util.PriorityQueue;

class Node {

    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Merge_K_Sorted_Lists {
    public static Node mergeKLists(Node[] lists) {  

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.data - b.data);        // Min Heap based on node data
        for (Node node : lists) {                   // Add first node of every list

            if (node != null) {
                pq.add(node);
            }
        }
        Node dummy = new Node(0);               // Dummy node helps in building result
        Node tail = dummy;
        
        while (!pq.isEmpty()) {                       // Process heap
            Node current = pq.poll();                 // Get smallest node

            tail.next = current;                      // Add it to result
            tail = current;

            if (current.next != null) {               // Add next node from same list
                pq.add(current.next);
            }
        }

        return dummy.next;
    }

    public static Node createList(int[] arr) {      // Create linked list from array

        if (arr.length == 0) {
            return null;
        }

        Node head = new Node(arr[0]);
        Node current = head;

        for (int i = 1; i < arr.length; i++) {
            current.next = new Node(arr[i]);
            current = current.next;
        }

        return head;
    }


    // Print linked list
    public static void printList(Node head) {
        Node current = head;

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {

        Node[] lists = new Node[3];                 // Create K sorted lists
        lists[0] = createList(new int[]{1, 4, 7});
        lists[1] = createList(new int[]{2, 5, 8});
        lists[2] = createList(new int[]{3, 6, 9});

        Node result = mergeKLists(lists);           // Merge all lists
        System.out.println("Merged List:");

        printList(result);
    }
}
