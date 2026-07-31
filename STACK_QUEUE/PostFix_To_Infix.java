/* 
        Given a postfix expression (a string), convert it into an equivalent infix expression. 
        The postfix expression is evaluated from left to right. 
        The infix expression should have the proper parentheses to ensure correct operator precedence.

        Write a function to perform this conversion.

        *Algorithm
        Traverse the postfix expression from left to right.
        Use a stack to store operands.
        For each operator, pop two operands, combine them in infix order with parentheses, and push the result back. 
        The final item in the stack will be the infix expression.
*/


package STACK_QUEUE;

import java.util.*;

class PostfixToInfix {
    
    public String postfixToInfix(String postfix) {

        Stack<String> s = new Stack<>();
        int n = postfix.length();

        for (int i = 0; i < n; i++) {                               // Traverse the postfix expression from left to right
            char c = postfix.charAt(i);
            
            if (Character.isLetterOrDigit(c)) {                     // If the character is an operand, push it to the stack
                s.push(String.valueOf(c));
            } 
            else {                                                  // else,if the character is operator ,Pop two operands from the stack
                String op2 = s.pop();
                String op1 = s.pop();

                s.push("(" + op1 + c + op2 + ")");                  // Form the new infix expression and push back to stack
            }       
        }
        return s.peek();                                            // The final element in the stack is the result
}


    public static void main(String[] args) {
        PostfixToInfix converter = new PostfixToInfix();
        String postfix = "AB*C+";
        System.out.println("Infix Expression: " + converter.postfixToInfix(postfix));
    }
}

