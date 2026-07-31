/* Remove common characters from two strings , and concatenate the leftovers */

package STRING ;

public class Remove_Common_characters {
   public static String common(String n, String t) {

    StringBuilder result = new StringBuilder();

    for (int i = 0; i < n.length(); i++) {
        if (t.indexOf(n.charAt(i)) == -1) {     //* means, for current character of n string , check the index of that character in t string...

        //* means ,it checking by character in t string ,if index is not found(character is not present),then the t string return -1 ,and then -1 == -1 (becomes true)

            result.append(n.charAt(i));     // so ,then we can add character of n string in result
        }
    }

    for (int i = 0; i < t.length(); i++) {          //* same for t string
        if (n.indexOf(t.charAt(i)) == -1) {   //* checking current character of String t ,is present at any index in String n, if no, then returns -1

            result.append(t.charAt(i));
        }
    }

    return result.toString();       // convert Stringbuilder result to String
}
    public static void main(String[] args) {

        String n = "nvbbac" ;
        String t = "mxbbtd" ;
        System.out.println(common(n, t));
    }
}
