/*      Check Balanced Parentheses -
        Given string str containing just the characters '(', ')', '{', '}', '[' and ']', 
        check if the input string is valid and return true if the string is balanced otherwise return false. 

        Note:
        Open brackets must be closed by the same type of brackets.
*       Open brackets must be closed in the correct order.
        There are no extra opening or closing brackets left
*/

package STACK_QUEUE;
import java.util.* ;

public class Valid_Parenthesis {
    public static boolean valid(String s){
        Stack < Character > st = new Stack<>();

        for( char ch : s.toCharArray()) {               // for every character in String

            if(ch == '(' || ch == '{' || ch == '[') {               // push to stack when open bracket comes
                st.push(ch) ;
            }
            else {                                  // *when there is close bracket

                if (st.isEmpty()) {                 // when stack is empty , no matching opening bracket
                    return false;
                }

                char top = st.pop();

                if(top == '(' && ch == ')' || top == '{' && ch == '}'  || top == '[' && ch == ']'){     // *if top matches
                    continue ;                                                                         // check till last character
                }
                else{                               // when top doesn't match , return false
                    return false ;
                }
            }
            

        }
        return st.size() == 0 ;
    }
    
}
