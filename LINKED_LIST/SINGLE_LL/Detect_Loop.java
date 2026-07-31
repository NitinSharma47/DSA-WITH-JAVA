package LINKED_LIST.SINGLE_LL;

import java.util.HashSet;

public class Detect_Loop {
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
    Boolean DetectLoop(Node head){
        HashSet < Node > set = new HashSet<>() ;

        Node temp = head ;
        while(temp != null){
            
            if(set.contains(temp)){
                System.out.println(temp.data);
                return true ;
            }
            set.add(temp) ;
            
            temp = temp.next ;
        }
        return false ;

    }
}
