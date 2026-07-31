/*              
*                Operations In Java Interface  ->
                        Offer =  Insert element 
                        poll  =  Remove element and Return it
                        peek  =  Look and return the element
                        poolfirst  = Remove the first element
                        poollast  =  Remove the last element

*/

package STACK_QUEUE;

class QueueLL {
    class Node{
        int data ;
        Node next ;

        Node(int data){
            this.data = data ;
            this.next = null ;
        }
        
    }

    Node front = null ;
    Node rear = null ;

    void enqueue(int value){
        Node newNode = new Node(value);

        if (rear == null) {
            front = rear = newNode;
            return;
        }

        // Add new node at rear   //* we can Trace the front & rear Both in Queue...like we can trace head in LL

        rear.next = newNode;
        rear = newNode;
    }

    int dequeue (){
        if(front == null ){
            System.out.println("No element to remove");
            return -1;
        }
        int value = front.data ;
        front = front.next ;

        return value ;
    }

    int peek() {
        if(front == null){
            return -1 ;
        }

        return front.data ;
    }

    boolean isempty(){
        return front == null ;
    }

    boolean search(int value){
        Node curr = front ;

        while(curr != rear){
            if(curr.data == value){
                return true ;
            }
            curr = curr.next ;
        }
        return false ;
    }

    void printQ(){

        if(front == null){
            System.out.println("Queue is empty ");
            return ;
        }
        Node curr = front ;

        while(curr != null){
            System.out.print(curr.data + "->");
            curr = curr.next ;
        }
        System.out.println();

    }

    public static void main(String[] args) {
        QueueLL q = new QueueLL() ;
         // Enqueue
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);

        System.out.println("Queue:");
        q.printQ();

        // Peek
        System.out.println("Front element: " + q.peek());

        // Dequeue
        System.out.println("Removed: " + q.dequeue());

        System.out.println("Queue after dequeue:");
        q.printQ();

        // Search
        System.out.println("Search 30: " + q.search(30));
        System.out.println("Search 100: " + q.search(100));

        // Empty
        System.out.println("Is queue empty? " + q.isempty());
    }
}
