/*
*                                               <<  OPTIMAL APPROACH  >>
Given a string s containing only the characters '(', ')', and '*', determine whether the string can be considered valid.
*       A '*' can be treated as:    '('  ,    ')'   ,   An empty string ''

        A valid parenthesis string must satisfy:

        Every opening '(' has a corresponding closing ')'.
        Every closing ')' has a corresponding opening '('.
        Parentheses must be properly nested.
*       Return true if the string can be made valid by replacing each '*' appropriately; otherwise, return false.
*       We can replace the '*' character into an open bracket '(' or an closing bracket ')'  or we can also take it as '' empty/null too

        Examples:
                    Input:  s = "()"    ,    Output: true
                    Input:  s = "(*)"   ,    Output: true
                    Input:  s = "(*))"  ,    Output: true
                    Input:  s = "())"   ,    Output: false

*       APPROACH ->             
            Instead of checking every combination (which is slow), we use a greedy technique that tracks the possible number of unmatched opening brackets:
            We maintain a range [minOpen, maxOpen] to represent the minimum and maximum possible open brackets at each point in the string.

            If we see a '(', both minOpen and maxOpen increase by 1.
            If we see a ')', both minOpen and maxOpen decrease by 1.
            If we see '*', it can behave like '(', ')' or be empty:
            minOpen decreases by 1 (assuming '*'' acts like ')')
            maxOpen increases by 1 (assuming '*' acts like '(')
            If at any point maxOpen becomes negative, return false — means too many closing brackets.
            We also make sure minOpen doesn’t drop below 0 — because you can't have negative opening brackets.

            If after processing the whole string, minOpen is 0, it means a valid configuration exists.
*/

public class Valid_Parenthesis_Checker {
    public static boolean checkValidString(String s) {

        int minOpen = 0;                                    // minOpen = minimum possible number of unmatched '('
        int maxOpen = 0;                                    // maxOpen = maximum possible number of unmatched '('

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                minOpen++;
                maxOpen++;
            }
            else if (ch == ')') {
                minOpen--;
                maxOpen--;
            }
            else {                                          // when '*'
                minOpen--;
                maxOpen++;
            }

            if (maxOpen < 0) {                              // Even the maximum possible '(' count is negative
                return false;
            }

            minOpen = Math.max(0, minOpen);               // Minimum cannot be negative
        }
        return minOpen == 0;
    }

    public static void main(String[] args) {
        String s = "((*)" ;
        System.out.println(checkValidString(s)) ;
    }
    
}
