package LINKED_LIST.SINGLE_LL;

public class Starting_Pointof_Loop {
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
    Node detectCycle(Node head) {

        Node slow = head;
        Node fast = head;
        
        while (fast != null && fast.next != null) {     // Detect whether a cycle exists

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                slow = head;                // Step 2: Reset one pointer to head
                
                while (slow != fast) {      // Step 3: Move both one step at a time
                    slow = slow.next;
                    fast = fast.next;
                }

                return slow;                // They meet at the starting point of the cycle
            }
        }
        return null;                // No cycle
    }
}
