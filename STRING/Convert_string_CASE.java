/*                                   convert string case from lower to upper & upper to lower
              *BASIC FORMULA USED -> 
                                From Lower to upper = character - 32            (for current character which you want to convert)
                                From Upper to Lower = character + 32 
 */
package STRING;

public class Convert_string_CASE {


    public static String toUpperCase(String s) {                    // *to change String from lower case to upper case
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);                               // take the current character of string

            if (ch >= 'a' && ch <= 'z') {                                   // charcater must lie between A to Z
                ch = (char) (ch - 32);                                          // *subtract 32 from character and get the answer in char
            }

            result.append(ch);
        }
        return result.toString();
    }

    public static String toLowerCase(String s) {                // *to change the string from upper case to lower case
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch >= 'A' && ch <= 'Z') {
                ch = (char) (ch + 32);
            }
            result.append(ch);

        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s = "Hello World";

        System.out.println(toUpperCase(s));
        System.out.println(toLowerCase(s));
    }
}
