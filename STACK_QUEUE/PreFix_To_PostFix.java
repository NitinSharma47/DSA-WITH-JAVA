/* 
                You are given a valid prefix expression consisting of binary operators and single-character operands. 
                Your task is to convert it into a valid postfix expression.

*               Prefix (Polish) notation places the operator before operands.
                Postfix (Reverse Polish) notation places the operator after operands.

*   Approach ->
        Traverse the prefix expression from right to left.
        Use a stack to store operands.
        For each operator, pop two operands from the stack, combine them with the operator, and push the result back.
        The final item in the stack will be the postfix expression. 

*/

package STACK_QUEUE;
import java.util.*;

class PrefixToPostfix {
    
    public String prefixToPostfix(String prefix) {

        Stack<String> s = new Stack<>();
        int n = prefix.length();

        for (int i = n - 1; i >= 0; i--) {                                  // Traverse the prefix expression from right to left                
            char c = prefix.charAt(i);
            
            if (Character.isLetterOrDigit(c)) {                             // *If the character is an operand, push it to the stack
                s.push(String.valueOf(c));
            } 
            else {                                                          // But if the character is an operator ,Pop two operands from the stack
                String op1 = s.pop();
                String op2 = s.pop();

                s.push(op1 + op2 + c);                                      // Form the new postfix expression and push back to stack
            }
        }
        return s.peek();                                                    // The final element in the stack is the result
    
}


    public static void main(String[] args) {
        PrefixToPostfix converter = new PrefixToPostfix();
        String prefix = "*-A/BC-/AKL";
        System.out.println("Postfix Expression: " + converter.prefixToPostfix(prefix));
    }
}

