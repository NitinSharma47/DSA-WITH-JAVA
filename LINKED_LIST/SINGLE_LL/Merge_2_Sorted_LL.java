            // *            THIS CODE IS MADE USINNG IN BUILT LINKED LIST FROM COLLECTION FRAMEWORK, IT USES QUEUE TOO IN IT


package LINKED_LIST.SINGLE_LL;

import java.util.LinkedList;

public class Merge_2_Sorted_LL {
    static class Node {
        int data ;
        Node next ;

        Node(int data){
            this.data = data ;
            this.next = null;
        }
        Node(int data , Node next){
            this.data = data;
            this.next = null ;
        }
    }

    static LinkedList<Integer> mergeTwoLists(LinkedList<Integer> list1, LinkedList<Integer> list2) {

        LinkedList<Integer> merged = new LinkedList<>();        // making merged list

        while (!list1.isEmpty() && !list2.isEmpty()) {

            if (list1.peekFirst() <= list2.peekFirst()) {           // when list1 element is less than list2 element
                merged.addLast(list1.pollFirst());                 // add it to list first(atlast)
            } 
            else {
                merged.addLast(list2.pollFirst());
            }
        }

        while (!list1.isEmpty()) {                      // adding remaining elements of list1 , when list2 is exhausted
            merged.addLast(list1.pollFirst());
        }

        while (!list2.isEmpty()) {
            merged.addLast(list2.pollFirst());
        }

        return merged;
    }

    public static void main(String[] args) {

        LinkedList<Integer> list1 = new LinkedList<>();

        list1.add(1);
        list1.add(3);
        list1.add(5);

        LinkedList<Integer> list2 = new LinkedList<>();
        
        list2.add(2);
        list2.add(4);
        list2.add(6);

        System.out.println("List 1: " + list1);
        System.out.println("List 2: " + list2);

        LinkedList<Integer> merged = mergeTwoLists(list1, list2);

        System.out.println("Merged List: " + merged);
    }
    
}
