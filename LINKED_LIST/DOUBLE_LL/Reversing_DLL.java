// *                        This code is for if an Array is give , which we have to Reverse by using Linked List..

// *                If there is a direct Linked List given and , you are asked to reverse it , then skip the conversion function

package LINKED_LIST.DOUBLE_LL;

public class Reversing_DLL {
    static class DLL{

        class Node{
            int data ;
            Node next ;
            Node prev ;

            Node(int data){
                this.data = data ;
                this.next = null ;
                this.prev = null ;
            }
        }

        Node Conversion(int arr[] ){                    // *Conversion of array to DLL
            Node head = new Node(arr[0]) ;                  // Making the Head Node
            Node previi = head ;                              // Make a Node previi to make previous pointer references

            for(int i = 1 ; i < arr.length ; i ++){         // starting from 1 because arr[0] is stored ad head
                Node temp = new Node (arr[i]) ;              // Make a newnode temp to store the current element of arr

                temp.next = null ;                             // making the next pointer reference of temp
                temp.prev = previi ;                           // making the prev pointer reference 
                previi.next = temp ;                           // updating the next reference of previi node

                previi = temp ;                                // move previi to temp
            }
            return head ;
        }  
        Node ReverseDLL(Node head) {

            Node curr = head ;
            Node newHead = null ;

            while(curr != null){            //* Main Point is , u just have to change the pointers of curr node (next -> prev ) && ( prev -> next )

                // Swap next and prev
                Node nextNode = curr.next ;
                
                curr.next = curr.prev ;
                curr.prev = nextNode ;

                // (Move newHead forward)
                newHead = curr;

                // Move curr forward
                curr = nextNode;
            }
            return newHead ;
        } 
        void printDLL(Node head){
            Node temp = head ;
            while(temp != null){
                System.out.print(temp.data + " -> ");
                temp = temp.next ;
            }
            System.out.println("null");
        }
        public static void main(String[] args) {
            int arr [] = {3,6,7,4,3,2,5,1} ;
            DLL list = new DLL();

            Node head = null ;
            head = list.Conversion(arr) ;
            head = list.ReverseDLL(head) ;

            list.printDLL(head);
        }
    }
}
