// *                                       IMPLEMENTING STACK USING ARRAY
//                                     means implementing features of stack in array

package STACK_QUEUE;

public class Stack_using_Array { 

    static class Stack{                        // Stack class

        private int stackArr [] ;               // making a Array , to store the elements of stack
        private int top ;                  // * making top variable , which shows the top element of stack and use to traverse in stack
        private int size ;

        Stack(int size ){
            this.size = size ;
            stackArr = new int [size] ;     // *making the array as the size of the stack *because arrays are of fixed size, so we intital se the stack's size

            top = -1 ;                      // initialising top at -1 ;
        }
    
        void push (int value) {               // Function to add the values in array from stack
            
            if(top == size - 1) {
                System.out.println("stack overflow");
                return ;
            }
            stackArr[++top] = value ;                           // * [++top] means increment the current value of top, before adding value
            System.out.println("pushed");
        }

        int pop(){                                  // Function to delete/remove Top element

            if(top == -1){
                System.out.println("Stackk underflow");
                return -1 ;
            }
            return stackArr[top--] ;                    // *Top is removed
        }

        int peek(){                             // Used to return the element at stack 
            if(top == -1){
                System.out.println("No element to return!!");
                return -1 ;
            }
            return stackArr[top] ;
        }
        
        boolean isEmpty(){
            return top == -1 ;                      // *returns true, when list is empty. i.e, top == -1
        }

        boolean search(int value){

            for (int i = top; i >= 0; i--) {        // *moving from top to ground

                if (stackArr[i] == value) {
                    return true;
                }
            }
            return false;

        }
        void reverse() {

            int[] temp = new int[top + 1];          // take a temporary array of size of the stack

            int j = 0;                          // variavble to traverse in temp

            while (top >= 0) {                      // *pop the elements from current stackArr, and add in temp arr
                temp[j++] = pop();
            }

            for (int i = 0; i < temp.length; i++) {         // Now put back the elements from temp to stackarr..
                push(temp[i]);
            }
        }

        void display() {

            if (isEmpty()) {
                System.out.println("Stack is empty");
                return;
            }

            System.out.println("Stack elements:");

            for (int i = top; i >= 0; i--) {
                System.out.println(stackArr[i]);
            }
        }

        void clear() {                           // *To clear the whole stack

            top = -1;
            System.out.println("Stack cleared");
        }
    
   
        public static void main(String[] args) {
            Stack stack = new Stack(5) ;

            stack.push(5);
            stack.push(4);
            stack.push(3);
            stack.push(2);
            stack.push(1);

            stack.display();

            stack.pop() ;

            System.out.println(stack.peek());
            stack.display();

            System.out.println(stack.search(4)) ;
            stack.display();
            stack.clear();
            stack.display();



            
        }
    }

    
}
