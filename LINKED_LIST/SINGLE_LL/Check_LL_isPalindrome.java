/*              APPROACH ->
                            Move fast 2 steps & slow 1 step at a time
                            When fast reaches null(end of LL) , Slow is standing at mid
                            Now reverse the Second Half of the linked list
                            Then , Compare the First  Half  to the Second Half
                            If , any mismatch occurs, then return false -> Not Palindrome
                            Else ,  Return True
                        *   Before returning , Must reverse again the second Half , to change that in original form

*/

package LINKED_LIST.SINGLE_LL;

public class Check_LL_isPalindrome {
    static class Node {
        int data ;
        Node next ;

        Node(int data){
            this.data = data ;
            this.next = null;
        }
        Node(int data , Node next){
            this.data = data;
            this.next = null ;
        }
    }
    static Boolean isPalindrome(Node head){
        if (head == null || head.next == null) return true;

        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){                   // find starting of second half
            fast = fast.next.next ;
            slow = slow.next ;
        }
        Node newHead = reverseSecondHalf(slow) ;                   // Reverse the second half by calling function

        Node temp = head ;                                              // Initialise temp at head (at first half)
        Node Rev = newHead ;                                            // for storing the result node of newHead ( it changes for each reversed node) 

        while(temp != slow && Rev != null) {                         // Traverse temp till slow & compare the nodes with second half reverse nodes at every iteration
            if(temp.data != Rev.data){               // if Mismatch occurs -> return false

                reverseSecondHalf(newHead) ;        // * But , must make the second Half in its origjnal form ( by reversing it again)
                return false ;
            }
            temp = temp.next ;                      // Update temp & Rev , to there next Nodes
            Rev = Rev.next ;

        }
        reverseSecondHalf(newHead) ;                // * Reverse the function again to  , make that it in its original form
        
        return true;
    }

    static Node reverseSecondHalf(Node head) {          // here, head is representing slow

        Node prev = null;
        Node curr = head;

        while (curr != null) {

            Node nextnode = curr.next;
            curr.next = prev;

            prev = curr;
            curr = nextnode;
        }

        return prev;  // head of reversed second half
    }
    public static void printLinkedList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {

        // Create a linked list with values 1, 5, 2, 5, and 1 (15251, a palindrome)
        Node head = new Node(1);
        head.next = new Node(5);
        head.next.next = new Node(2);
        head.next.next.next = new Node(5);
        head.next.next.next.next = new Node(1);

        // Print the original linked list
        System.out.print("Original Linked List: ");
        printLinkedList(head);

        // Check if the linked list is a palindrome
        if (isPalindrome(head)) {
            System.out.println("The linked list is a palindrome.");
        } else {
            System.out.println("The linked list is not a palindrome.");
        }
    }
}
