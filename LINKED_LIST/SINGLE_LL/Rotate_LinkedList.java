package LINKED_LIST.SINGLE_LL;

public class Rotate_LinkedList {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node rotateRight(Node head, int k) {

        // Edge cases
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        
        int length = 1;                                     // Find length and last node
        Node tail = head;                           

        while (tail.next != null) {                         // Move tail to last Node and also count length of list
            tail = tail.next;
            length++;
        }

        // Step 2: Reduce unnecessary rotations
        k = k % length;                         // *because if k = 7 , and length of list is 5 -> then rotating 7 times = rotating 2 times..

        if (k == 0) {
            return head;
        }
        
        tail.next = head;                   // *Make the list circular -> to make shifting of Nodes easy
        int stepsToNewTail = length - k;        // Find the new tail (till where the nodes have to shift)

        Node newTail = head;

        for (int i = 1; i < stepsToNewTail; i++) {          // Move the newTail to Kth Node
            newTail = newTail.next;
        }

        Node newHead = newTail.next;                // Make New head after new tail , now new Head is at After the shifting Position

        // Break the circular link
        newTail.next = null;

        return newHead;     
    }

    static void printList(Node head) {

        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        int k = 2;

        head = rotateRight(head, k);

        printList(head);
    }
}
