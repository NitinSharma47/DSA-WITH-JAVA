/*                         Slow & Fast Pointer method can also be used to find the middle of linkedlist..
                Move fast with 2 steps and slow with 1 step , when fast reaches null , -> Slow is standing on middle NOde
                                                Then , you can return it 

*/


package LINKED_LIST.SINGLE_LL;

public class Finding_middle_Node {
    
    class Node {
        public int data;
        public Node next;

        Node()
        {
            this.data = 0;
            this.next = null;
        }
        Node(int data)
        {
            this.data = data;
            this.next = null;
        }
        Node(int data, Node next)
        {
            this.data = data;
            this.next = next;
        }
    }


    public class Solution {
        public static Node findMiddle(Node head) {
            Node temp = head ;
            int count = 0 ; 

            while(temp != null){
                count ++ ;
                temp = temp.next ;
            }
            int mid ;
            if (count % 2 == 0){
                mid = (count / 2) + 1 ;
            }
            else{
                mid = (count + 1) / 2 ; 
            }
            Node newnode = head ;
            for(int i = 1 ; i < mid ; i++ ){
                newnode = newnode.next ;

            }
            return newnode ;

        }
    }
    public class Main{
        public static void main(String[] args) {
            
        }

    }
    
}
