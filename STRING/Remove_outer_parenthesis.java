package STRING ;

public class Remove_outer_parenthesis {
    public static String removeOuterParentheses(String s) {

        StringBuilder result = new StringBuilder();  
        int counter = 0;  

        for (int i = 0 ; i < s.length() ; i ++) {       // converting string to character array
            char ch = s.charAt(i) ;                    // character variable to store , the character at i index in String s,(to improves readability)

            if (ch == '(') {
                counter++;
                
                if (counter > 1) {
                    result.append(ch);           // If we're inside a primitive, add '(' to result
                    
                }    
            } 
            else if (s.charAt(i) == ')') {               // If we encounter ')', decrease the level 
                if (counter > 1) {
                    result.append(ch);   // If we're inside a primitive, add ')' to result
                }
                counter--;
            }
        }

        // Return the result as a string after removing the outer parentheses
        return result.toString();
    }
    public static void main(String[] args) {
        String s = "()(()())(())" ;
        System.out.println(removeOuterParentheses(s)) ;
    }
}