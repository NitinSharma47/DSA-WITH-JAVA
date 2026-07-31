/* 
                Given a string, S. Find the length of the longest substring without repeating characters.
            *   This Problem is done using Two Pointers Approach

                Input:
                S = "abcddabac"  
                Output:
                4  
                Explanation:
                            The longest substring with distinct characters is "abcd", which has a length of 4.

                Input:
                S = "aaabbbccc"  
                Output:
                2  
                Explanation:
                            The longest substrings with distinct characters are "ab" and "bc", both having a length of 2.
                            
    *NOTE  -> right expands the window, lastIndex detects duplicates, left jumps past duplicates, and maxLen stores the largest valid window.
*/

import java.util.Arrays;

public class Longest_Substring_without_Repeating_Characters {
    public static int longestNonRepeatingSubstring(String s) {

        int[] lastIndex = new int[256];
        Arrays.fill(lastIndex, -1);                                 // initially fill all indexes with -1 in array

        int left = 0;
        int maxLen = 0;                                             // variable to storre maxlen

        for (int right = 0; right < s.length(); right++) {          
            char ch = s.charAt(right);

            if (lastIndex[ch] >= left) {                            // when the cuurent character is repeated ,or already in the subsstring 
                left = lastIndex[ch] + 1;                           // *then move left to the previous occurence of current character
            }

            maxLen = Math.max(maxLen, right - left + 1);            // calculate the maxlength of substring/window
            lastIndex[ch] = right;                                  // store latest index of character in array
        }
        return maxLen;
    }

    public static void main(String[] args) {

        String s = "cadbzabcd";
        System.out.println(longestNonRepeatingSubstring(s)) ;
    }
}