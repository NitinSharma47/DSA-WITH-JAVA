/*              Given two strings, check if two strings are anagrams of each other or not.

       Checking whether two strings are anagrams means checking whether they contain the same characters with the same frequencies,
        but possibly in a different order

  Example
    String 1: "listen"
    String 2: "silent"

Simple definition -> Two strings are anagrams if one string can be rearranged to form the other,
                        using every character exactly the same number of times.                                                 */  
/*
*        MY APPROACH ->
        FOR String 1 :  i put all characters in map with their max fequencies 
        FOR String 2 :  i check that the current character is present in map or not -
                        if character is not present then its obvious that the strings are not valid anagrams 

                        but when characters is present , then i fetch the frequency of string1's current character
                        & update the frequency by decreasing it by 1..
                        Then, At last of the Day, if the frequencies 's count is 0.. 
                        means all characters of String 2 eliminates the Frequencies of characters of String 1. Hence they are same
                        HENCE , The Strings are Valid AnagRams..
*/
package STRING;

import java.util.HashMap;

public class Check_Anagram {
    public static boolean Ana(String s1 , String s2){

        if(s1.length() != s2.length()){     // when if length of both strings are not same , then obviously they are not anagrams
            return false ;
        }
        HashMap < Character , Integer > map = new HashMap<>() ;

        for(int i = 0 ; i < s1.length() ; i ++ ){       // adding string 1 characters to map with their frequency
            if(map.containsKey(s1.charAt(i))){          // if any character is repeated and , already in map from previous iterations

                int freq = map.get(s1.charAt(i)) ;      // then update its frequency by 1
                map.put(s1.charAt(i),freq + 1) ;
            }
            else{                                       // when the character is seen first time, add it with frequency 1
                map.put(s1.charAt(i), 1) ;
            }
        }

        for(int j = 0 ; j < s2.length() ; j ++ ){           // for characters of string 2, checking they are already in map or not
            char ch = s2.charAt(j) ;                        // for better readability and understanding

            if(!map.containsKey(ch)){            // when any character of string 2 is not present in map, then obviously the strings are not anagrams
                return false ;
            }

            map.put(ch, map.get(ch) - 1) ;       // if present, update & decrease their frequency by 1
            
        }

        for (int frequency : map.values()){         // check frequency is 0 or not, if 0 means frequency is same of every character, hence Anagram..
            if(frequency != 0){
                return false ;
            }
        }

        return true ;
    }
    public static void main(String[] args) {
        String s1 = "CAT" ;
        String s2 = "ACT" ;
        System.out.println(Ana(s1, s2));
    }
    
}
