package LINKED_LIST.SINGLE_LL;

public class Merge_two_Sorted_LL {
     static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node mergeTwoLists(Node list1, Node list2) {
        Node dummy = new Node(-1);                              // * Making a dummy node to store -1 represents null
        Node temp = dummy;                                      // *Temp Node to show starting of Merge List

        while (list1 != null && list2 != null) {
            if (list1.data <= list2.data) {                     //  When list1 Node is smaller

                temp.next = list1;                          // Make it to the nexter node of temp (Add that first)
                list1 = list1.next;                         // *Move list1 to its next node
            } 
            else {
                temp.next = list2;
                list2 = list2.next;
            }

            temp = temp.next;                               // update temp to nexter step
        }

        if (list1 != null) temp.next = list1;                   // *Add all Nodes of list1 if , list2 Nodes are exhausted
        if (list2 != null) temp.next = list2;                   // Same..

        return dummy.next;                                  // * Return head of MergeList
    }

    static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // List 1: 1 -> 3 -> 5
        Node list1 = new Node(1);
        list1.next = new Node(3);
        list1.next.next = new Node(5);

        // List 2: 2 -> 4 -> 6
        Node list2 = new Node(2);
        list2.next = new Node(4);
        list2.next.next = new Node(6);

        System.out.print("List 1: ");
        printList(list1);

        System.out.print("List 2: ");
        printList(list2);

        Node mergedHead = mergeTwoLists(list1, list2);

        System.out.print("Merged List: ");
        printList(mergedHead);
    }
    
}
