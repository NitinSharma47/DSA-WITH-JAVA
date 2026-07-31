package LINKED_LIST.DOUBLE_LL;

public class Remove_Duplicates {
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
    static Node removeDuplicates(Node head) {
        // If the list is empty, return null
        if (head == null) return null;

        Node current = head;

        // Traverse the list until the second last node
        while (current != null && current.next != null) {
            Node nextDistinct = current.next;

            // Skip and unlink all nodes with the same value as current
            while (nextDistinct != null && nextDistinct.data == current.data) {
                nextDistinct = nextDistinct.next;
            }

            // Connect current node to the next distinct node
            current.next = nextDistinct;
            if (nextDistinct != null) {
                nextDistinct.prev = current;
            }

            // Move to the next node
            current = current.next;
        }

        return head;
    }

}
