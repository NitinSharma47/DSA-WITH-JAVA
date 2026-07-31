// *                   Just convert the string to Character array .. and then you can use ->  **  Arrays.sort() function  **

package STRING;
import java.util.* ;

public class Sorting_Characters_In_String {
    public static void main(String[] args) {

        String s = "dcba";
        char[] arr = s.toCharArray();

        Arrays.sort(arr);
        String sorted = new String(arr);

        System.out.println(sorted);
    }
}

