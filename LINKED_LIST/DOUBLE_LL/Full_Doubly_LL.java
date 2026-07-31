package LINKED_LIST.DOUBLE_LL;

public class Full_Doubly_LL {

    static class DLL {

        static class Node{
            int data ;
            Node next ;
            Node prev ;

            Node(int data){
                this.data = data ;
                this.next = null ;
                this.prev = null ;
            }
            Node(int data, Node next , Node prev) {                  // Constructor with data and next pointer & when next can be null
                this.data = data;
                this.next = next;
                this.prev = prev ;
            }
        }
        

        Node InsertAtFront(Node head , int data){
            Node newnode = new Node(data) ;
            newnode.next = head ;
            newnode.prev = null ;
            if(head != null) {
                head.prev = newnode;
            }
            head = newnode ;

            return head ;
        }

        Node InsertAtLast(Node head , int data){

            Node newnode = new Node(data) ;
            if( head == null){
                return newnode ;
            }
            Node curr = head ;

            while(curr.next != null){
                curr = curr.next ;
            }

            curr.next = newnode ;
            newnode.prev = curr ;

            return head ;

        }
        Node InsertAtPosition (Node head, int Position , int data){

            if (Position < 1) {       // position should be start from 1
                System.out.println("Can't insert!! " + data);
                return head;
            }

            if (Position == 1) {         // add at front
                return InsertAtFront(head, data);
            }

            Node curr = head ;

            for(int i = 1 ; i < Position - 1 && curr != null ; i++){
                curr = curr.next ;
            }
            if (curr == null) {
                System.out.println("position does not exist in LL");
                return head;
            }

            Node newnode = new Node(data);

            newnode.next = curr.next ;
            newnode.prev = curr ;
            if (curr.next != null) {
                curr.next.prev = newnode;
            }
            curr.next = newnode ;

            return head ;
        }

        Node deletefromfront(Node head){
            if(head == null){
                System.out.println("Nothing to delete");
                return null ;
            }
            if(head.next == null){
                return null ;
            }
            head = head.next ;
            head.prev = null ;

            return head ;
        }
        Node deletefromLast(Node head){
            if (head == null) {
                System.out.println("Nothing to delete");
                return null;
            }
            if (head.next == null) {
                return null;
            }

            Node curr = head ;

            while(curr.next != null){
                curr = curr.next ;
            }
            curr.prev.next = null ;

            return head ;

        }
        Node DeleteByValue(Node head, int value){

            if (head == null) {
                return null;
            }
            if (head.data == value) {
                return deletefromfront(head);
            }
            Node temp = head ;

            while(temp != null && temp.data != value){
                temp = temp.next ;
            }
            if (temp == null){
                System.out.println("No value exist! Nothing to delete");
                return head;
            }
            temp.prev.next = temp.next ;

            if(temp.next != null) {
                temp.next.prev = temp.prev ;
            }
            
            return head ;

        }
        Boolean search(Node head , int data ){
            Node temp = head ;

            while(temp != null){
                if(temp.data == data){
                    return true ;
                }
                temp = temp.next ;
            }
            return false;
        }

        Node reverseDLL(Node head) {

            Node current = head;
            Node newHead = null;

            while (current != null) {

                // Swap next and prev
                Node nextNode = current.next;

                current.next = current.prev;
                current.prev = nextNode;

                // This node becomes the new head
                newHead = current;

                // Move to the original next node
                current = nextNode;
            }

            return newHead;
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
            DLL list = new DLL() ;
            Node head = null ;

            // Insert at Front
            head = list.InsertAtFront(head, 30);
            head = list.InsertAtFront(head, 20);
            head = list.InsertAtFront(head, 10);

            System.out.println("After inserting at front:");
            list.printDLL(head);

            // Insert at Last
            head = list.InsertAtLast(head, 40);
            head = list.InsertAtLast(head, 50);

            System.out.println("\nAfter inserting at last:");
            list.printDLL(head);

            // Insert at Position
            head = list.InsertAtPosition(head, 2, 15);

            System.out.println("\nAfter inserting 25 at position 3:");
            list.printDLL(head);

            // Search
            System.out.println("\nSearching for 30: " + list.search(head , 30));
            

            // Delete from Front
            head = list.deletefromfront(head);

            System.out.println("\nAfter deleting from front:");
            list.printDLL(head);

            // Delete from Last
            head = list.deletefromLast(head);

            System.out.println("\nAfter deleting from last:");
            list.printDLL(head);

            // Delete by Value
            head = list.DeleteByValue(head, 25);

            System.out.println("\nAfter deleting value 25:");
            list.printDLL(head);

            // Reverse
            head = list.reverseDLL(head);

            System.out.println("\nAfter reversing:");
            list.printDLL(head);
            
        }
    }
}
