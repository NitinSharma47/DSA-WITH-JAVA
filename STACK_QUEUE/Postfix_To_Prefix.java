/* 
*       Algorithm
        Traverse the postfix expression from left to right.
        Use a stack to store operands.
        For each operator, pop two operands, combine them with the operator in prefix order, and push the result back.
        The final item in the stack will be the prefix expression. 
*/


package STACK_QUEUE;

import java.util.*;

class PostfixToPrefix {
    
    public String postfixToPrefix(String postfix) {

        Stack<String> s = new Stack<>();
        int n = postfix.length();
        
        for (int i = 0; i < n; i++) {                                   // Traverse the postfix expression from left to right
            char c = postfix.charAt(i);
            
            if (Character.isLetterOrDigit(c)) {                         // If the character is an operand, push it to the stack
                s.push(String.valueOf(c));
            } 
            else {
                String op2 = s.pop();                                   // Pop two operands from the stack
                String op1 = s.pop();
                
                s.push(c + op1 + op2);                                  // Form the new prefix expression and push back to stack
            }
        }
        return s.peek();                                                 // The final element in the stack is the result
    
}

    public static void main(String[] args) {
        PostfixToPrefix converter = new PostfixToPrefix();
        String postfix = "ABC/-AK/L-*";
        System.out.println("Prefix Expression: " + converter.postfixToPrefix(postfix));
    }
}

