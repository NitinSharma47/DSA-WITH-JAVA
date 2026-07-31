package STRING;

public class Reverse_Words_In_String_Optimal {
    public static String reverseWords(String s) {

        StringBuilder result = new StringBuilder();

        int i = s.length() - 1;     // placing pointer i at last character
        while (i >= 0) {                // moving in reverse

            while (i >= 0 && s.charAt(i) == ' ') {          // if  last character is space, move backward
                i--;                                    
            }
            if (i < 0) {                // when i goes negative
                break;
            }

            int end = i;                // marking the end character of current word
            while (i >= 0 && s.charAt(i) != ' ') {          // until the space not comes, move backward
                i--;
            }

            if (result.length() > 0) {          //  putting space between each word
                result.append(" ");
            }
            result.append(s, i + 1, end + 1);       // appending the whole word from its starting character to ending character
        }

        return result.toString();
    }
    
}
