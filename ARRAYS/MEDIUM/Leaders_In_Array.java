/*                      Given an array of integers, find all the leaders in the array.
                An element is called a leader if it is greater than or equal to all the elements to its right.
                The last element is always a leader because there are no elements on its right. */

package ARRAYS.MEDIUM ;

import java.util.ArrayList;

public class Leaders_In_Array{
    public static ArrayList <Integer> leader(int arr[]){

        int n = arr.length ;
        ArrayList<Integer> list = new ArrayList<Integer>() ;            // making a list to store leaders

        for(int i = 0 ;  i < n  ; i ++){
            boolean leaderr = true ;                    // making a leader variable to check , element is leader or not
            for( int j = i + 1 ; j < n ; j ++){
                if(arr[j] >= arr[i]){               // if there is any other element after the current, which is greater than current element
                    leaderr = false ;               //then it is not leader
                    break;
                }
            }
            if(leaderr){            // if cuurent elemet (arr[i]) is leader(true), then addd it to the list
                list.add(arr[i]);
            }
        }
        return list ;
    }
    public static void main(String[] args) {
        int arr [] = {10, 22, 12, 3, 0, 6} ;
        System.out.println(leader(arr));
    }
}