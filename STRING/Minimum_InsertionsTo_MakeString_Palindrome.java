//                  *   ALTHOUGH , THIS PROBLEM CAN BE EFFECTIVELY SOLVED BY DP[] ONLY.. BUT, HERE IS A "KAAMCHALAU" CODE  *

package STRING;

public class Minimum_InsertionsTo_MakeString_Palindrome {
    public static int ins(String s) {

        StringBuilder str = new StringBuilder(s);

        int count = 0;
        int left = 0;
        int right = str.length() - 1;               

        while (left < right) {

            if (str.charAt(left) == str.charAt(right)) {        //* Comparing left characters with right ones

                left++;
                right--;

            } else {                                // * when left characters are not equal to right characters

                // *Insert a copy of the right character at left index in stringbuilder
                str.insert(left, str.charAt(right));      

                count++ ;           // increase count

                left++ ;
                right-- ;
            }
        }

        return count;
    }
    public static void main(String[] args) {
        String s = "nitn" ;
        System.out.println(ins(s));
    }
    
}
