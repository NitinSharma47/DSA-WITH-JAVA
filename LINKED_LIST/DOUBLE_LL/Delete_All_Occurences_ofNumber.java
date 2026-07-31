/*                     Given the head of a doubly linked list and an integer target. Delete all nodes in the linked list with the value target 
                        and return the head of the modified linked list 

                        Input: head -> 1 <-> 2 <-> 3 <-> 1 <-> 4, target = 1
                        Output: head -> 2 <-> 3 <-> 4

                        Input: head -> 2 <-> 3 <-> -1 <-> 4 <-> 2, target = 2
                        Output: head -> 3 <-> -1 <-> 4
*/

package LINKED_LIST.DOUBLE_LL;

public class Delete_All_Occurences_ofNumber {
    static class Node {
        int data;
        Node prev;
        Node next;

        // Constructor to initialize node with a value
        Node(int val) {
            data = val;
            prev = null;
            next = null;
        }
    }
    public Node deleteTargetNodes(Node head, int target) {
        // Start from the head node
        Node current = head;

        // Traverse the entire list
        while (current != null) {
            // Store next node before possibly deleting current
            Node nextNode = current.next;

            // If current node matches the target value
            if (current.data == target) {
                // If not the head, link previous node to next
                if (current.prev != null)
                    current.prev.next = current.next;
                else
                    // If it's the head, move head forward
                    head = current.next; 

                // If not the tail, link next node to previous
                if (current.next != null)
                    current.next.prev = current.prev;
            }

            // Move to the next node
            current = nextNode;
        }

        // Return updated head
        return head;
    }
    
}
