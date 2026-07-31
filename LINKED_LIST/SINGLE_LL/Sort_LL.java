/*                                  This Linked list is sorted using the Merge sort technique

              *       To find Middle Node & TO sort the two Linked lists -> The codes of these problemss i also done before, 
              *                                     so the codes below are same..
*/

package LINKED_LIST.SINGLE_LL;

public class Sort_LL{

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    
    public static Node sortList(Node head) {                // Function to sort the linked list

        if (head == null || head.next == null) {             // Base case
            return head;
        }
        Node mid = getMiddle(head);                         // Find the middle of the linked list
   
        Node rightHead = mid.next;                          // Split the list into two halves
        mid.next = null;

        Node left = sortList(head);                     // Sort both halves
        Node right = sortList(rightHead);

        
        return merge(left, right);                  // Merge the sorted halves
    }

   
    public static Node getMiddle(Node head) {        // *Find middle node using slow and fast pointers , 

        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;                                // Slow is standing at the middle....
    }   

    
    public static Node merge(Node left, Node right) {                       // * Code for Merge two sorted linked lists ,
                                                             // * which is used recursively to sort the both parts of our linked List too
        Node dummy = new Node(-1);
        Node current = dummy;

        while (left != null && right != null) {

            if (left.data <= right.data) {

                current.next = left;
                left = left.next;
            } 
            else {
                current.next = right;
                right = right.next;
            }

            current = current.next;
        }

        
        if (left != null) {                         // Attach remaining nodes of left , if right got exhausted
            current.next = left;
        } 
        else {
            current.next = right;
        }

        return dummy.next;
    }

    // Print linked list
    public static void printList(Node head) {

        Node current = head;

        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }

        System.out.println("null");
    }

    // Main function
    public static void main(String[] args) {

        Node head = new Node(4);
        head.next = new Node(2);
        head.next.next = new Node(1);
        head.next.next.next = new Node(3);

        System.out.println("Original Linked List:");
        printList(head);

        head = sortList(head);

        System.out.println("Sorted Linked List:");
        printList(head);
    }
}