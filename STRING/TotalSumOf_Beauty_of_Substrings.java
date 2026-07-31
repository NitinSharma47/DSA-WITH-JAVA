/*                The beauty of a string is defined as the difference between the frequency of the most frequent character 
                    and the least frequent character (excluding characters that do not appear) in that string.

                    Given a string s, return the sum of beauty values of all possible substrings of s.

    * substrings like -> a, b, c, aa, bb, cc, aabb, aacc, bbcc .... or the substrings which have same characters in it 
    *                                                               or all the characterss in substring are occuring same timee..
    * Then the beauty of that substrings are always zero, because the characters present are explicitly most and least frequent itself
    *       example -> aabb : a = 2, b = 2 ->  most frequent is 2 && least frequent is also 2  ->  2-2 = 0 ;
*/


package STRING;

import java.util.* ;

public class TotalSumOf_Beauty_of_Substrings {
    public static int beauty(String s){

        int sum = 0 ;

        for(int i = 0 ; i < s.length() ; i ++ ){
            Map< Character , Integer > freq = new HashMap<>() ;         //* Map to add character with their frequency for every substring
            // This map is reset after every iteration of i completion, so it can store only current substring characters with their frequencies

            for(int j = i ; j < s.length() ; j ++){

                // putting all characters of current substring in map , with it maximum frequency
                freq.put(s.charAt(j), freq.getOrDefault(s.charAt(j) , 0) + 1 ) ;        

                int maxi = Integer.MIN_VALUE;           // variables to store maximum and minimum frequency of characters in substring
                int mini = Integer.MAX_VALUE;

                // Calculate max and min frequency
                for (int val : freq.values()) {         // run a loop in all values of current substring to find out maxi and mini
                    mini = Math.min(mini, val);
                    maxi = Math.max(maxi, val);
                }
                
                sum += (maxi - mini);           // Get && Update sum
            }
        }
    return sum ;
    }
    public static void main( String args []){
        String s = "aabcbaa" ;
        System.out.println(beauty(s));
    }
    
}
