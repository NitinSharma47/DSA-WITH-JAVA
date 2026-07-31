/*           Given a string s, find the longest substring of s that is a palindrome.
            Return the longest palindromic substring.
*A palindrome reads the same from left to right and right to left.

Examples:
"aba", "racecar", "bb"   → palindrome

Example 1
Input:  s = "babad"
Output: "bab"

"bab" is a palindrome. 
*/

package STRING;

public class Longest_Palindromic_Substring {

    public static String longestPalindrome(String s) {

        String ans = "";

        // Try every character as a possible center
        for (int i = 0; i < s.length(); i++) {

            // Odd-length palindrome: center is i
            String odd = expand(s, i, i);

            // Even-length palindrome: center is between i and i + 1
            String even = expand(s, i, i + 1);

            // Keep the longer palindrome
            if (odd.length() > ans.length()) {
                ans = odd;
            }

            if (even.length() > ans.length()) {
                ans = even;
            }
        }

        return ans;
    }
    // Expand from the center while characters are equal
    
    public static String expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {

            left--;
            right++;
        }
        // Return the palindrome found
        return s.substring(left + 1, right);
    }
    public static void main(String[] args) {

        String s = "babad";
        System.out.println(longestPalindrome(s));
    }
}
   
    

