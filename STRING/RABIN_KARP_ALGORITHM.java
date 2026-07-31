/*      You are given two strings: String A and String B 
        The goal is to find whether String A exists as a subset or substring within String B. 

* FORMULA TO MAKE HASHCODE OF A PATTERN/STRING =   (s[0] × p^(m-1) + s[1] × p^(m-2) + ...+ s[m-1] × p^(0) ) % mod 

* ROLLING HASH FORMULA  =  [ newHash = (oldHash - oldChar × p^(m-1)) × p + newChar ]
 */

package STRING;
import java.util.*;

public class RABIN_KARP_ALGORITHM {

    public static List<Integer> search(String text, String pattern) {

        List <Integer>  result = new ArrayList<>() ;        //  used to store all occurences where pattern comes in Text
            

        int n = text.length();
        int m = pattern.length();

        if (m > n) {
            return result;
        }

        long p = 31;                       // *BASE VALUE , generally can take 31 
        long mod = 1_000_000_007L;          // *large value to prevent hash collisions

        long patternHash = 0;
        long windowHash = 0;

        long highestPower = 1;           // *used to calculate, value of p^(m-1)...first character's value 

        // highestPower = base^(m - 1) % mod
        for (int i = 0; i < m - 1; i++) {
            highestPower = (highestPower * p) % mod;
        }

        // Calculate initial hash
        for (int i = 0; i < m; i++) {

            // this is represeting formula( (s[0] × p^(m-1) + s[1] × p^(m-2) + ...+ s[m-1] × p^(0) ) % mod )  in horner's form..

            patternHash = (p * patternHash + pattern.charAt(i)) % mod;          // (C × 10^3 + D × 10^2 + D × 10^1 + A × 10^0) % 10
            windowHash = (p * windowHash + text.charAt(i)) % mod;
        }

        // Slide window
        for (int i = 0; i <= n - m; i++) {

            // If hash matches
            if (patternHash == windowHash) {

                boolean match = true;                   // *important variable

                for (int j = 0; j < m; j++) {

                    if (text.charAt(i + j) != pattern.charAt(j)) {          // comparing each character
                        match = false;
                        break;
                    }
                }

                if (match) {                // if character matching is true
                    result.add(i);
                }
            }

            // Calculate next window hash
            if (i < n - m) {                // till index of last window

                windowHash = ((windowHash - text.charAt(i) * highestPower) * p + text.charAt(i + m)) % mod;  // calculating rolling hash for new window

                // Make hash positive...hash value can be negative after taking modulo
                if (windowHash < 0) {
                    windowHash += mod;
                }
            }
        }
        return result ;
    }
    public static void main(String[] args) {
        String text = "ABCCDDAEFG" ;
        String pattern = "CDD" ;
        System.out.println(search(text, pattern));
    }
}
    

