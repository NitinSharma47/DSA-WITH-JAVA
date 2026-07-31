/*              Given an input string, containing upper-case and lower-case letters, digits, and spaces( ' ' ).
                A word is defined as a sequence of non-space characters. The words in s are separated by at least one space.
                Return a string with the words in reverse order, concatenated by a single space.

                Input: s = "welcome to the jungle"
                Output: "jungle the to welcome"

*/

package STRING;

public class Reverse_Words_In_String {
    public static String rev(String s){

        //split function divides the string , whenever a space(or anything you specify) comes , by the help of it we can make words 
        String words [] = s.split(" ") ;                // creating words array to store the string(divided by _ at every index)
        StringBuilder result = new StringBuilder() ;            // to store reversed words

        for(int i = words.length - 1 ; i >= 0 ; i --){          // *Reverse Loop
            result.append(words[i] );                           // adding from last word from words

            if( i != 0){                                        // add space between every word.. but not after last word
                result.append(" ") ;
            }
        }
        return result.toString() ;                              // return after converting to string
    
    }
    public static void main(String[] args) {
        String s = "welcome to the jungle" ;
        System.out.println(rev(s));
    }    
}
