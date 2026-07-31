/*                  In a normal singly linked list: ->>    10 → 20 → 30 → null

                    In a circular linked list, the last node points back to the first node:
                    10 → 20 → 30
                    ↑         ↓
                    └─────────┘
                    So:

*                   tail.next = head;

*                   There is no null at the end.

*/
package LINKED_LIST.CIRCULAR_LL;

public class Circular_LL_Implementation {

    static class Node {                 // Node class
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    static Node tail = null;                   // Tail pointer

    static void insertAtBeginning(int data) {

        Node newNode = new Node(data);
        
        if (tail == null) {                 // Empty list
            tail = newNode;
            tail.next = tail;
        }
        else {
            newNode.next = tail.next;
            tail.next = newNode;
        }
    }

    static void insertAtEnd(int data) {
        Node newNode = new Node(data);

        // Empty list
        if (tail == null) {
            tail = newNode;
            tail.next = tail;
        }
        else{
            newNode.next = tail.next;
            tail.next = newNode;
            tail = newNode;
        }
    }

    static void insertAtPosition(int data, int position) {
        
        if (position < 1) {
            System.out.println("Invalid position");
            return;
        }

        // Insert at beginning
        if (position == 1) {
            insertAtBeginning(data);
            return;
        }

        // Empty list
        if (tail == null) {
            System.out.println("Position out of range");
            return;
        }

        Node newNode = new Node(data);
        Node current = tail.next;                // head

        for (int i = 1; i < position - 1; i++) {                // Move to node before required position

            current = current.next;

            if (current == tail.next) {                         // We have completed one round
                System.out.println("Position out of range");
                return;
            }
        }
        newNode.next = current.next;
        current.next = newNode;

        if (current == tail) {                          // If inserted after tail
            tail = newNode;
        }
    }

    static void deleteFromBeginning() {

        // Empty list
        if (tail == null) {
            System.out.println("List is empty");
            return;
        }

        if (tail.next == tail) {                     // Only one node
            tail = null;
        }
        else {                                      // More than one node
            tail.next = tail.next.next;
        }
    }

    static void deleteFromEnd() {

        // Empty list
        if (tail == null) {
            System.out.println("List is empty");
            return;
        }

        if (tail.next == tail) {                // Only one node
            tail = null;
            return;
        }

        Node current = tail.next; // head

        while (current.next != tail) {              // Find node before tail
            current = current.next;
        }

        current.next = tail.next;
        tail = current;
    }

    static void deleteByValue(int value) {

        // Empty list
        if (tail == null) {
            System.out.println("List is empty");
            return;
        }

        Node current = tail.next;                   // head
        Node previous = tail;

        do {
            if (current.data == value) {                                // Found value

                if (current == tail && current.next == tail) {          // Only one node
                    tail = null;
                }
                else if (current == tail) {                             // Deleting tail
                    previous.next = tail.next;
                    tail = previous;
                }
                else {                                                  // Deleting head or middle
                    previous.next = current.next;
                }

                return;
            }

            previous = current;
            current = current.next;

        } while (current != tail.next);
            System.out.println("Value not found");
    }

    static boolean search(int value) {

        if (tail == null) {
            return false;
        }
        Node current = tail.next;                   // head

        do {

            if (current.data == value) {
                return true;
            }
            current = current.next;

        } while (current != tail.next);

        return false;
    }

    static void display() {

        if (tail == null) {
            System.out.println("List is empty");
            return;
        }
        Node current = tail.next; // head

        do {

            System.out.print(current.data + " ");
            current = current.next;

        } while (current != tail.next);

        System.out.println();
    }

    static int size() {

        if (tail == null) {
            return 0;
        }

        int count = 0 ;
        Node current = tail.next;

        do {
            count++;
            current = current.next;
        } while (current != tail.next);

        return count;
    }

    public static void main(String[] args) {

        // Insert at beginning
        insertAtBeginning(30);
        insertAtBeginning(20);
        insertAtBeginning(10);

        System.out.println("After inserting at beginning:");
        display();

        // Insert at end
        insertAtEnd(40);
        insertAtEnd(50);

        System.out.println("After inserting at end:");
        display();

        // Insert at position
        insertAtPosition(25, 3);

        System.out.println("After inserting 25 at position 3:");
        display();

        // Size
        System.out.println("Size: " + size());

        // Search
        System.out.println("Search 40: " + search(40));
        System.out.println("Search 100: " + search(100));

        // Delete beginning
        deleteFromBeginning();

        System.out.println("After deleting from beginning:");
        display();

        // Delete end
        deleteFromEnd();

        System.out.println("After deleting from end:");
        display();

        // Delete by value
        deleteByValue(25);

        System.out.println("After deleting 25:");
        display();

        // Final size
        System.out.println("Final size: " + size());
    }
}