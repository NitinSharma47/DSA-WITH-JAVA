// *                                                     OPTIMAL APPROACH

/* 

Given an integer array A, return the next greater element for every element in A. 
The next greater element for an element x is the first element greater than x that we come across while traversing the array in a clockwise manner.
If it doesn't exist, return -1 for this element.

*           HERE WE USE MONOTONIC STACK  ----->

    Initialize an empty stack and a result array of the same length as input.
    Traverse the array from the last element to the first (right to left).
    For each element, pop elements from the stack while the stack top is less than or equal to the current element.
    If the stack becomes empty, no greater element exists, assign -1 in the result.
    Otherwise, the top of the stack is the next greater element for the current element.
    Push the current element onto the stack for use in future comparisons.



*/

package STACK_QUEUE ;
import java.util.*;

public class Next_GreaterElement {
    public static int[] nextgreater(int[] arr) {

        int n = arr.length;
        int res [] = new int[n];                                                 // *Array to store the Next Greater Element for every element

        Stack <Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {                                      // Traverse from right to left

            // top(peek) represents the next greater element
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {                // remove all smaller or equal elements..when top of stack is smaller
                                                                                // then it can never be the next greater of i..
                stack.pop();
            }
            if (stack.isEmpty()) {                                              // If stack is empty, then there is NO greater element
                res[i] = -1;
            } 
            else {                                                              // Else top of the stack is the answer
                res[i] = stack.peek();
            }

            stack.push(arr[i]);                                                 // push current element
        }   
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 25};

        int[] res = nextgreater(arr);           // calling the function

        for (int x : res) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}