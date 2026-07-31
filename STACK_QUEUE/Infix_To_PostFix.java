
package STACK_QUEUE;
import java.util.* ;

class Solution {

    public static int prec(char c) {                                        // *Making priority of operators
        if (c == '^')                                                       // Exponent operator has highest precedence
            return 3;
        else if (c == '/' || c == '*')                                      // Multiplication and division have higher precedence than addition
            return 2;
        else if (c == '+' || c == '-')                                      // Addition and subtraction have lowest precedence
            return 1;
        else
            return -1;
    }

    // *Function to convert infix expression to postfix expression

    public static void infixToPostfix(String s) {

        Stack<Character> st = new Stack<>();                                // Stack to hold operators and parentheses
        StringBuilder result = new StringBuilder();                         // StringBuilder to hold the resulting postfix expression

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isLetterOrDigit(c)) {                             // If the scanned character is an operand, add it to the result string
                result.append(c);
            }
            else if (c == '(') {                                            // If the scanned character is an ‘(‘, push it to the stack
                st.push('(');
            }

            else if (c == ')') {                                    // If the scanned character is a ‘)’, pop from stack until an ‘(‘ is encountered

                while (st.peek() != '(') {
                    result.append(st.pop());
                }
                st.pop();                                                        // Pop the ‘(‘ from the stack
            }

            else {                                                               // If an operator is scanned
                while (!st.isEmpty() && prec(c) <= prec(st.peek())) {
                    result.append(st.pop());
                }
                st.push(c);                                                      // Push the current operator to the stack
            }
        }

        while (!st.isEmpty()) {                                                  // Pop all the remaining elements from the stack
            result.append(st.pop());
        }

        System.out.println("Postfix expression: " + result.toString());          // Output the result
    }
}

class Main {

    public static void main(String[] args) {
        String exp = "(p+q)*(m-n)";                                             // Infix expression
        System.out.println("Infix expression: " + exp);
        Solution.infixToPostfix(exp);                                           // Convert the infix expression to postfix
    }
}
