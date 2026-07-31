package LINKED_LIST.DOUBLE_LL;

public class Converting_Array2DLL {
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
        Node Conversion(int arr[] ){
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
        void printDLL(Node head){
            Node temp = head ;
            while(temp != null){
                System.out.print(temp.data + " -> ");
                temp = temp.next ;
            }
            System.out.println("null");
        }
         
        public static void main(String[] args) {
            int arr[] = {2,3,4,1,5} ;
            DLL list = new DLL() ;
            
            DLL.Node head = list.Conversion(arr);
            list.printDLL(head) ;
        }
    }
}
