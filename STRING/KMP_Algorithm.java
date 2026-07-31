package STRING;

import java.util.*;

public class KMP_Algorithm {
    public static int[] BuildingLPS(String pattern , int lps[]){   // LPS TAble is made using Pattern String

        int i = 1 ;             // i = 1 , because lps[0] = 0, it starts from 1
        int len = 0 ; 

        while(i < pattern.length()){
            if(pattern.charAt(i) == pattern.charAt(len)){

                len++ ;         // move len forward 
                lps[i] = len;               //  the index of len is store in array
                i ++ ;
            }else{                  // when len have some stored value , then move to that index
                if(len != 0){
                    len = lps[len-1] ;       //    move len
                }
                else{              // when len is at index 0, then we can't move it back further , So - move i to next & store 0 for that index in lps
                    lps[i] = 0 ;
                    i ++ ;
                }
            }
        }
        return lps ;
        
    }
    public static List<Integer> kmp (String text , String pattern){

        List<Integer> result = new ArrayList<>() ;          // to store all the occurrence of pattern stored in Text

        int lps [] = new int [pattern.length()] ;
        BuildingLPS(pattern, lps) ;             // call the function & get the lps array table for this pattern

        int i = 0 ; 
        int j = 0 ;

        while(i < text.length()) {
            
            if(text.charAt(i) == pattern.charAt(j)){
                i ++ ;                                      // if both charcaters matches , then check next characters 
                j ++ ;
            }
            if( j == pattern.length() ) {            // when j reaches the last index of pattern, means all pattern characters found
                result.add(i - j) ;        // *becuase in text string , if pattern is found.. then the starting index from where patern is matchig is i-j
                j = lps[j-1] ;      // *it means when 1 occurrence is found , move j to its second last index , to match other occureneces of pattern
                           // *too..by not checking pattern from j = 0 (again), check from directly last second character..to prevernt doing extra work 
            }     
            else if( i < text.length() && text.charAt(i) != pattern.charAt(j)) {        // charcters doesn't match

                if(j != 0){                     // and j is not at startinf idex 0
                    j = lps[j-1] ;              // then move j to its previous value in lps array
                }
                else{                       // when j = 0 , means we cannot move j back further
                    i ++ ;                      // so , move i to next
                }
            }
        }
        return result ;
    }
    public static void main(String[] args) {
        String text = "abracadabra" ;
        String pattern = "abra" ;
        System.out.println(kmp(text, pattern));
    }
    
}
