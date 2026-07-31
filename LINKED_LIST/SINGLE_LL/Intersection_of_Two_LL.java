/*            APPROACH ->

              *Take two dummy nodes for each list. Point each to the head of the lists.
              *Iterate over them. If anyone becomes null, point them to the head of the opposite lists and continue iterating until they collide.
 */
package LINKED_LIST.SINGLE_LL;

public class Intersection_of_Two_LL {
    static class Node{
        int data ;
        Node next ;

        Node(int data){
            this.data= data ;
            this.next = null;

        }
    }
    static Node Intersection(Node head1 , Node head2){

        if (head1 == null || head2 == null) {
            return null;
        }

        Node dummy1 = head1 ;               // To traverse through  list 1 *(A Head repreents its list)
        Node dummy2 = head2 ;               // To traverse through list2

        while(dummy1 != dummy2){                // Untill when they do not meet at same Node

            if (dummy1 == null){                // *dummy1 reaches last of list1 , then start it fromm head of second list(head2)
                dummy1 = head2 ;
            }
            else{
                dummy1 = dummy1.next ;              // else,just traverse by moving to next node
            }

            if (dummy2 == null){                // *Same
                dummy2 = head1 ;
            }
            else{
                dummy2 = dummy2.next ;
            }
        }

        return dummy1 ;                     // *Here , dummy1 can be used to show -> 1. if intersection founds -> then return the Intersection Node
                                        //  *&& if intersection not founds ->> then returns null..because it will only stop when reaches null of head2
    }
    public static void main(String[] args) {

        Node common = new Node(4);                                          // * Making common node
        common.next = new Node(3);
        common.next.next = new Node(7);

        Node head1 = new Node (1);
        head1.next = new Node(2);
        head1.next.next = common ;                                              // *Making Intersection Node

        Node head2 = new Node(7);
        head2.next = new Node(2);
        head2.next.next = common ;


        Node result = Intersection(head1 , head2) ;                             // *Result Node to print the result

        if (result != null) {
            System.out.println("Intersection Node: " + result.data);
        } else {
            System.out.println("No Intersection");
        }
        
    }   
}
