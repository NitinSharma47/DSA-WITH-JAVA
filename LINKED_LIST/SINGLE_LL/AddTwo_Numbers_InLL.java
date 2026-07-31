// *                                  <<    ONE OF THE MOST IMPORTANT PROBLEM    >>
/*                                      
        Problem Statement -->>  Add two numbers represented as Linked Lists.

*           In this Problem , the numbers (which we have to add) are give in reverse order..
*           And the result ,is also comes in reverse order, but we dont have to make it straight original..
*           we just have to return the head of the sum list....

        Example 1:-
        Input: num1 = 243, num2 = 564
        Output:sum = 807; L = [7,0,8]
        Explanation: Since the digits are stored in reverse order, reverse the numbers first to get the or original number
                     and then add them as → 342 + 465 = 807. 

        Example 2:-
        Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
        Output: Result: [8,9,9,9,0,0,0,1]
        Explanation: Since the digits are stored in reverse order, reverse the numbers first to get the original number
                    and then add them as → 9999999 + 9999 = 8999001. Refer to the image below.

*   ALGORITHM ->

    Create a dummy node that will act as the starting point of the new linked list.
    Create a temporary pointer and set it to the dummy node.
    Start with a carry value of 0.
    Loop through both linked lists until you reach the end of both, or until there is no carry left.
    At each step, add the values of the current nodes and the carry.
    Update the carry by dividing the total by 10.
    Create a new node with the last digit of the total (total % 10) and attach it to the next of the temporary pointer, then move the temporary pointer forward.
    Move both list pointers to their next nodes.
    After the loop ends, return the next node of the dummy (this is the head of the result list).
    The dummy node is used to make the code easier. Without it, extra conditions would be needed to handle the first node.
 */
package LINKED_LIST.SINGLE_LL;

public class AddTwo_Numbers_InLL {

    static class Node {
        int val;
        Node next;
        Node() {}
        Node(int val) { this.val = val; }
        Node(int val, Node next) { 
        this.val = val; 
        this.next = next; 
    }
}

    static Node addTwoNumbers(Node l1, Node l2) {

        Node dummy = new Node();                                           // Initialize a dummy node to start the result(sum) list
        Node temp = dummy; 
        int carry = 0;                                                   // Make carry variable to store carries of sum
        
        while (l1 != null || l2 != null || carry != 0) {               // Iterate till the end of both the lists
            int sum = carry;                                          // Node to store sum

            if (l1 != null) {                                       // Add the value of L1 's current Node in sum
                sum += l1.val;
                l1 = l1.next;                                     // update to L1 's nexter Node
            }
            if (l2 != null) {                                   // Add the value of L2 's current Node in sum
                sum += l2.val;
                l2 = l2.next;                                 // update to L2 's nexter Node
            }
            temp.next = new Node(sum % 10);                 // Make new node(Result Node),Attach to temp -> put data of sum 
            carry = sum / 10;                              // If sum throughs a carry(two digit number), then add its first digit to carry

            temp = temp.next;                            // Update temp to next node(which is attached curently above)
        }       

        return dummy.next;                            // Return the head of sumlist
    }

    static Node createList(int[] arr) {            // Converting Array(of number) to LL
        Node head = new Node(arr[0]);
        Node temp = head;
        for (int i = 1; i < arr.length; i++) {
            temp.next = new Node(arr[i]);
            temp = temp.next;
        }
        return head;
    }

    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] num1 = {2, 4, 3}; // represents 342
        int[] num2 = {5, 6, 4}; // represents 465
        Node l1 = createList(num1);
        Node l2 = createList(num2);

        Node result = addTwoNumbers(l1, l2);
        printList(result); // Output: 7 -> 0 -> 8
    }
}
