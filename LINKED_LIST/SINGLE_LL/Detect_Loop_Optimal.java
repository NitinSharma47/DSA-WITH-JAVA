package LINKED_LIST.SINGLE_LL;

public class Detect_Loop_Optimal {
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
    Boolean DetectCycle(Node head){
        Node slow = head ;
        Node fast = head ;

        while(fast != null && fast.next != null){
            slow = slow.next ;
            fast = fast.next.next ;


            if(slow == fast){
                return true ;
            }
        }
        return false;
    }
    
}
