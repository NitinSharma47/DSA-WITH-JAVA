/* Problem Statement: Implement the function myAtoi(s) which converts the given string s to a 32-bit signed integer

Steps to Implement :-
1. First, ignore any leading whitespace characters ' ' until the first non-whitespace character is found.
2. Check the next character to determine the sign. If it’s a '-', the number should be negative. If it’s a '+', the number should be positive. 
    If neither is found, assume the number is positive.
3. Read the digits and convert them into a number. Stop reading once a non-digit character is encountered or the end of the string is reached.
     Leading zeros should be ignored during conversion.
4. The result should be clamped within the 32-bit signed integer range: [-2147483648, 2147483647]. If the computed number is outside this range,
     return -2147483648 if the number is less than -2147483648, or return 2147483647 if the number is greater than 2147483647.
5. Finally, return the computed number after applying all the above steps.
 */

package STRING;

public class Implementation_of_Myatoi {
     public static int myAtoi(String s) {

        int i = 0;                                               // Pointer to traverse the string

        while (i < s.length() && s.charAt(i) == ' ') {           // Skip all leading spaces
            i++;
        }

        int sign = 1;           // Assume the number is positive
        if (i < s.length() && s.charAt(i) == '-') {     // If '-' is found, make the number negative
            sign = -1;
            i++;
        }
        else if (i < s.length() && s.charAt(i) == '+') {        // If '+' is found, simply skip it
            i++;
        }

        return solve(s, i, sign, 0);        // Recursively convert the digits into an integer
    }

    private static int solve(String s, int i, int sign, int result) {

        if (i == s.length() || s.charAt(i) < '0' || s.charAt(i) > '9') {        // Stop if we reach the end or find a non-digit character
            return sign * result;
        }

        int digit = s.charAt(i) - '0';         // Convert character digit to integer digit

        if (result > (Integer.MAX_VALUE - digit) / 10) {        // * Check if adding the next digit will cause overflow (Most Important)

            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;       // Return the correct 32-bit limit
            
            //*  when sign = 1 , then return Integer.MAX_VALUE(2147483647) else return Integer.MIN_VALUE(-2147483647)
            //*  Integer.MAX_VALUE means the maximum capacity of (int) data type
        }

        result = result * 10 + digit;       // Add the current digit to the result

        return solve(s, i + 1, sign, result);       // Recursively process the next character
    }
    public static void main(String[] args) {
        String s = "   -123abc" ;
        System.out.println(myAtoi(s));
    }
    
}
