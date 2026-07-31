/*              Write a function to find the longest common prefix string amongst an array of strings. 
                If there is no common prefix, return an empty string "". 

        APROACH ->
    
        The common prefix across all strings must exist between the smallest and largest string when sorted lexicographically.
        Sorting the array helps bring these boundary strings to the extremes.
        By comparing only the first and last strings, we can determine the full common prefix shared by the entire array.
        Character-wise comparison from the beginning allows us to identify where the prefix stops.
        The point at which the characters start differing marks the end of the shared prefix.
        The portion before this mismatch is the longest common prefix among all strings.
*/

package STRING;

import java.util.Arrays;

public class Longest_Common_Prefix {
    public static String common (String s []){

        Arrays.sort(s);          // * sorting because the maximum common prefix, can be of smallest string only && 
                                // *we can find LCP by compsring only smallest and larget strings,rather than comparing each string(increases time)
        int n = s.length;
        StringBuilder sb = new StringBuilder() ;

        String startingString = s[0] ;              // smallest string
        String endingString = s[n - 1] ;            // largest string

        // finding which string is shortest, so that we can run loop until that string's length
        int minLength = Math.min(startingString.length(), endingString.length()) ;

        for(int i = 0 ; i < minLength ; i ++){
            if(startingString.charAt(i) == endingString.charAt(i)){             // when characters are same
                sb.append(startingString.charAt(i)) ;                   // add them to sb(we can use any string for fetching characters)
            }
            else{                   // when characters starts mismatched , then break the loop to prevent from waste running
                break ;
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String s [] = { "flower", "flow", "flight" } ;
        System.out.println(common(s));
    }
}
