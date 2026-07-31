/* 
Given a string s and an integer k.Find the length of the longest substring with at most k distinct characters

    Examples

    Input :s = "aababbcaacc" , k = 2
    Output :6
    Explanation :The longest substring with at most two distinct characters is "aababb".
    The length of the string 6


    Input : s = "abcddefg" , k = 3
    Output : 4
    Explanation : The longest substring with at most three distinct characters is "bcdd".
    The length of the string 4.

    *IDEA ->
            right → expand window
            HashMap → stores frequency
            map.size() > k → shrink window
            left → removes characters
            right - left + 1 → current length
*/

import java.util.HashMap;

public class Longest_Substring_WithAt_Most_KDistinct_Characters {
    public static int sub(String s , int k){

        int longest = 0 ;
        HashMap < Character , Integer > map = new HashMap<>(k) ;

        int left = 0 ; 
        for (int right = 0 ; right < s.length() ; right ++){

            map.put(s.charAt(right), map.getOrDefault(s.charAt(right),0) + 1);  //*Put the current character in map & update its value whenever repeat

            while(map.size() > k ){                                             // when map size exceeds k 
                map.put(s.charAt(left) , map.get(s.charAt(left)) -1) ;          // *then put the character at left in map with value decrease by 1 

                if (map.get(s.charAt(left)) == 0) {                             // if the value of left character becomes 0 , then remove it from map
                    map.remove(s.charAt(left));
                }

                left ++ ;                                               // shrink the window by moving left pointer forward
            }
            longest = Math.max(longest, right - left + 1);              // update & store the longest substring each time
        }
        return longest ;

    }

    public static void main(String[] args) {

        String s = "eceba";
        int k = 2;

        System.out.println(
            "Longest substring length: " + sub(s, k)
        );
    }
}
