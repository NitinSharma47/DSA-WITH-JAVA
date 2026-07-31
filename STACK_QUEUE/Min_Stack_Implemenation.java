/* 
*               A Min Stack is a stack that supports normal stack operations plus getting the minimum element in O(1) time.

todo                            Operation	                Time
                                push(x)	                    O(1)
                                pop()	                    O(1)
                                top()	                    O(1)
                                getMin()	                O(1)

*           The key idea is to maintain two stacks:

            st → stores all elements normally.
            minSt → stores the minimum value seen at each relevant point.

            Example
            Suppose we push:

            5 → 3 → 7 → 2  ->  The stacks become:
                                st:     [5, 3, 7, 2]
                                minSt:  [5, 3, 3, 2                 // *it doesnot store 7 , because it is not smaller than  2 , 
                                                                         Min stack always store minimum elements, by comparison only

*            So minSt.top() always gives the current minimum in O(1).

    What I have to design > 
    Design a stack that supports the following operations in constant time: push, pop, top, and retrieving the minimum element.

    Implement the MinStack class:

    MinStack(): Initializes the stack object.
    void push(int val): Pushes the element val onto the stack.
    void pop(): removes the element on the top of the stack.
    int top(): gets the top element of the stack.
    int getMin(): retrieves the minimum element in the stack.


*IDEA  ->       Anytime , you have/get  a current value , which is going to replace the mini (current  value <  mini) then ->
*                       do not push that value in Stack , instead of it Push the Modified Value of it...in stack
*               && At the same time , replace/update  the mini with current value..

*              ( MODIFIED VALUE  =  2 * value - mini )

*                   Modified value is always smaller than mini value

                    Ex ->  value = 10 , pewvious mini = 12 
                      so , value < mini          ..mini needs to update

                      modified value = 2 * 10 - 12  =  20 - 12  = 8 Ans..
                      Hence  8 < 10


*/
package STACK_QUEUE;

import java.util.Stack;

// Class to implement Minimum Stack
class MinStack {

    private Stack<Integer> st;                  // take an stack 
    private int mini;                           // variable to store minimum value

    public MinStack() {                         // Empty Constructor
        st = new Stack<>();
    }
   
    public void push(int value) {
        
        if (st.isEmpty()) {                             // If stack is empty
            mini = value;                               // *Update the minimum value , first element is always minimum

            st.push(value);                             // Push current value as minimum
            return;
        }

        if (value > mini) {                                // If current value is greater than the minimum, then it won't change mini
            st.push(value);
        } 
        else {                                          // when value is lesser than mini, means mini needs to update then..
            st.push(2 * value - mini);                      // *Add the modified(Encoded) value to stack (IMPORTANT FORMULA)
            mini = value;                                   // Update the minimum
        }
    }

    public void pop() {
        
        if (st.isEmpty()) return;                   // Base case
        
        int x = st.pop();                           // Get the top
        
        if (x < mini) {                             // If the modified value was added to stack
            mini = 2 * mini - x;                    // *Update the minimum
        }
    }

    public int peek() { 
        if (st.isEmpty()) return -1;            // Base case
        
        int x = st.peek();                      // Get the top
        if (mini < x) return x;                 // Return top if minimum is less than the top

       
        return mini;                           // Otherwise return mini
    }
    
    public int getMin() {                       // *Method to get/return the minimum in stack
        return mini;                            // Just Direct return the mini
    }

    public static void main(String[] args) {
        MinStack s = new MinStack();

        // Function calls
        s.push(-2);
        s.push(0);
        s.push(-3);
        System.out.println(s.getMin() + " ");
        s.pop();
        System.out.println(s.peek() + " ");
        s.pop();
        System.out.println(s.getMin());
    }
}