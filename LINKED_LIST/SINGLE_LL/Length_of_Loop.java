package LINKED_LIST.SINGLE_LL;

public class Length_of_Loop {
    class Node{
        int data ;
        Node next ;

        Node(){}
        Node(int data){
            this.data = data ;
            this.next = null ;
        }
        Node(int data , Node next) {
            this.data = data ;
            this.next = null ;
        }
    }
    int lengthOfLoop(Node head) {

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {     // Detect cycle

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {

                int length = 1;                      // Count cycle length
                Node curr = slow.next;                  // set curr node to nexter node of slow

                while (curr != slow) {                  // traverse curr in loop until it does not reach slow again
                    length++;                           // count the steps of traversing , that is your length
                    curr = curr.next;
                }

                return length;
            }
        }
        return 0;
    }   
}
