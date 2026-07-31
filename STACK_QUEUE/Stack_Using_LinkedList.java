// *                                       IMPLEMENTING STACK USING LINKED LIST
//          STACK AND LINKED LIST BOTH ARE OF DYNAMC SIZE , SO THE PROBLEM OF STACK OVERFLOW IS SOLVED HERE......

// *                                         Here , Head acts as Top of stack
package STACK_QUEUE;

public class Stack_Using_LinkedList {    
    class Node{
        int data ;
        Node next ;

        Node(int data){
            this.data = data ;
            this.next = null;
        }
    }

    public static Node head;

    boolean isempty(){
        return head == null ;
    }

    void push(int value){

        Node newnode = new Node(value) ;
        newnode.next = head ;
        head = newnode ;
    }

    int pop(){
        if(isempty()){
            System.out.println("Stack underflow");
            return -1;
        }

        int top = head.data ;
        head = head.next ;              //  move head to next Node
        return top ;                    // return the data of head
    }

    int peek(){
        if(isempty()){
            System.out.println("Nothing to peek !!");
        }
        int top = head.data ;
        return top ;
    }

    boolean search(int value){
        Node curr = head ;
        while(curr != null){
            if(curr.data == value){
                return true ;
            }
            curr = curr.next ;
        }
        return false ;
    }

    void reverse() {                         // *  The Process is exactly same as to Reverse Linked List

        Node prev = null;
        Node curr = head;

        while (curr != null) {

            Node next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }
        head = prev;
    }

    void printStackLL(){
        Node curr = head ;

        while(curr != null){
            System.out.println(curr.data);
            curr = curr.next ;
        }
        System.out.println();
    }
    

    public static void main(String[] args) {

        Stack_Using_LinkedList stack = new Stack_Using_LinkedList();
        

        // Push elements
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        // Print stack
        System.out.println("Stack:");
        stack.printStackLL();

        // Peek
        System.out.println("Top element: " + stack.peek());

        // Pop
        System.out.println("Popped: " + stack.pop());

        // Print after pop
        System.out.println("Stack after pop:");
        stack.printStackLL();

        // Search
        System.out.println("Is 20 present? " + stack.search(20));
        System.out.println("Is 50 present? " + stack.search(50));
        stack.reverse();
        stack.printStackLL();
            
    }
      
}
