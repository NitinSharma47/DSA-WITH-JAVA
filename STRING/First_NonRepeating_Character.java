// Given a string, find the first character that appears only once in the string.

package STRING;
import java.util.*;

public class First_NonRepeating_Character {
    public static Character rep(String s){
        
        Map < Character , Integer > map = new HashMap<>() ;

        for(int i = 0 ; i < s.length() ; i ++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1) ;

        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return s.charAt(i) ;
            }
        }
        return null ;

    }
    public static void main(String[] args) {
        String s = "aabbcde" ;
        System.out.println(rep(s)) ;
    }
}
