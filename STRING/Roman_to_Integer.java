/*  Roman numerals are represented by seven different symbols: I = 1, V = 5, X = 10, L = 50, C = 100, D = 500, M = 1000
For example: 2 is written as II, 12 is written as XII, 27 is written as XXVII.
Roman numerals are usually written largest to smallest from left to right. But in six special cases, subtraction is used instead of addition:
I before V or X → 4 and 9,
X before L or C → 40 and 90,
C before D or M → 400 and 900
Given a Roman numeral, convert it to an integer. */


package STRING;
import java.util.* ;

public class Roman_to_Integer {
    public int romanToInt(String s) {
        int res = 0;
        
        // Create a map of Roman numerals to integers
        Map<Character, Integer> roman = new HashMap<>();
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);

        for (int i = 0; i < s.length() - 1; i++) {
           
            if (roman.get(s.charAt(i)) < roman.get(s.charAt(i + 1))) {       // Subtract if current value is less than next value
                res -= roman.get(s.charAt(i));
            } 
            else {        
                res += roman.get(s.charAt(i));      // Otherwise, add the value
            }
        }
        // Add the value of the last character
        return res + roman.get(s.charAt(s.length() - 1));
    }
}
