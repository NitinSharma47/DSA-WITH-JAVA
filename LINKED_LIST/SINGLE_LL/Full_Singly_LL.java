// *                                                    ALL OPERATIONS ON SINGLE LINKED LIST
/* 
*                        We can make Head as a global variable , to reduce the passing of it as parameter in each function , 
*                            but not making it as global variable is generally a good way to use in DSA problems..
*/

package LINKED_LIST.SINGLE_LL;

public class Full_Singly_LL {

    static class LinkedList {

        static class Node {
            int data;
            Node next;

            Node(int data, Node next) {                  // Constructor with data and next pointer & when next can be null
                this.data = data;
                this.next = next;
            }

            Node(int data) {                            // Constructor with only data
                this.data = data;
                this.next = null;
            }
        }

        public Node insertAtFront(Node head, int data) {     // defining head explicitly because it is better, when using a particular function to solve any problem in DSA

            Node newnode = new Node(data);                  // Making the node which is going to add
            newnode.next = head;                            // Making the reference from newnode to head
            head = newnode;

            return head;
        }

        public Node insertAtLast(Node head, int data) {
            Node newnode = new Node(data);

            if (head == null) {
                head = newnode;
                return head;
            }

            Node current = head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = newnode;

            return head;
        }

        public Node insertAtposition(Node head, int data, int position) {           // to insert node at any specific position

            if (position < 1) {       // position should be start from 1
                System.out.println("Can't insert!! " + data);
                return head;
            }
            Node newnode = new Node(data);

            if (position == 1) {         // add at front
                newnode.next = head;
                head = newnode;

                return head;
            }

            Node curr = head;              // node to traverse in LL

            for (int i = 1; i < position - 1 && curr != null; i++) {      // reach the node previous to position && while being in LL
                curr = curr.next;
            }

            if (curr == null) {
                System.out.println("position does not exist in LL");
                return head;
            }

            newnode.next = curr.next;          // making the next reference of new node to position node(which is already exists at position)
            curr.next = newnode;               // making the reference of curr with new node..and adding it at position

            return head;
        }

        public Node DeleteFromFront(Node head) {

            if (head == null) {
                System.out.println("LL is empty ! we cant delete anything");
                return head;
            }
            head = head.next;

            return head;
        }

        public Node DeleteFromLast(Node head) {

            if (head == null) {
                System.out.println("LL is empty ! we cant delete anything");
                return head;
            }
            if (head.next == null) {    // If there is only one node
                return null;
            }
            Node temp = head;

            while (temp.next.next != null) {
                temp = temp.next;
            }
            temp.next = null;

            return head;
        }

        public Node DeleteByValue(Node head, int value) {      // delete any node by its value

            if (head == null) {
                System.out.println("LL is empty ! we cant delete anything");
                return head;
            }
            if (head.data == value) {
                head = head.next;
                return head;
            }
            Node temp = head;

            while (temp.next != null && temp.next.data != value) {        // reach to the previous node, of the value node
                temp = temp.next;
            }

            if (temp.next == null) {
                System.out.println("No value exist! Nothing to delete");
                return head;
            }
            temp.next = temp.next.next;

            return head;
        }

        public boolean search(int value, Node head) {       // to search an element in LL

            Node curr = head;
            while (curr != null) {

                if (curr.data == value) {
                    return true;
                }

                curr = curr.next;
            }
            return false;
        }

        public int countNodes(Node head) {       // to count the total Nodes in LL

            int totalNodes = 0;
            Node curr = head;

            while (curr != null) {
                totalNodes++;
                curr = curr.next;
            }

            return totalNodes;
        }

        public Node reverseLL(Node head) {           // to reverse the Singly LL

            Node previous = null;
            Node current = head;

            while (current != null) {
                Node nextNode = current.next;
                current.next = previous;

                previous = current;
                current = nextNode;
            }

            head = previous;

            return head;
        }

        public void printLL(Node head) {        // Printing the whole LL

            Node curr = head;
            while (curr != null) {
                System.out.print(curr.data + " -> ");
                curr = curr.next;
            }

            System.out.println("null");
        }

//----------------------------------------------------------------------------------------------------------------------------------------------------

        public static void main(String[] args) {

            LinkedList list = new LinkedList();

            Node head = null;                         // Insert at Front

            // Insert at Front
            head = list.insertAtFront(head, 30);
            head = list.insertAtFront(head, 20);
            head = list.insertAtFront(head, 10);

            System.out.println("After inserting at front:");
            list.printLL(head);

            // Insert at Last
            head = list.insertAtLast(head, 40);
            head = list.insertAtLast(head, 50);

            System.out.println("\nAfter inserting at last:");
            list.printLL(head);

            // Insert at Position
            head = list.insertAtposition(head, 25, 3);

            System.out.println("\nAfter inserting 25 at position 3:");
            list.printLL(head);

            // Count Nodes
            System.out.println("\nNumber of nodes: " + list.countNodes(head));

            // Search
            System.out.println("\nSearching for 40: " + list.search(40, head));
            

            // Delete from Front
            head = list.DeleteFromFront(head);

            System.out.println("\nAfter deleting from front:");
            list.printLL(head);

            // Delete from Last
            head = list.DeleteFromLast(head);

            System.out.println("\nAfter deleting from last:");
            list.printLL(head);

            // Delete by Value
            head = list.DeleteByValue(head, 25);

            System.out.println("\nAfter deleting value 25:");
            list.printLL(head);

            // Reverse
            head = list.reverseLL(head);

            System.out.println("\nAfter reversing:");
            list.printLL(head);
        }
    }
}

