// *                        This code is for if an Array is give , which we have to Reverse by using Linked List..

// *                If there is a direct Linked List given and , you are asked to reverse it , then skip the conversion function


package LINKED_LIST.SINGLE_LL;

public class Reversing_SLL {
    class Node {
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
    Node Conversion(int arr[] ){            // *Convert Array to SLL

        if (arr.length == 0) {
            return null;
        }

        Node head = new Node(arr[0]) ;                  // Making the Head Node
        Node curr = head ;

        for(int i = 1 ; i < arr.length ; i ++){         // starting from 1 because arr[0] is stored ad head
            Node nextNode = new Node (arr[i]) ;              // Create a new node containing the current array element.

            curr.next = nextNode ;                  //Making next pointer of curr to Nextnode
            curr = nextNode ;                       // updating(moving) the curr to nextnode
        }
        return head ;
    }
    Node reverseLL(Node head) {           // to reverse the Singly LL

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
    Node PrintLL(Node head){
        Node curr = head ;

        while(curr != null){
            System.out.print(curr.data + " -> " );
            curr = curr.next ;
        }
        System.out.println("null");
        return head ;

    }
    public static void main(String[] args) {
        int arr[] = {2,3,4,1,5} ;
        Node head = null ;
        Reversing_SLL list = new Reversing_SLL() ;

        head = list.Conversion(arr) ;
        head = list.reverseLL(head) ;
        list.PrintLL(head) ;
    }
}
