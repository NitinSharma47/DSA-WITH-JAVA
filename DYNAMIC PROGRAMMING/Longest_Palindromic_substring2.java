//           MARK FOR REVIEW


public class Longest_Palindromic_substring2 {


    public static boolean isPalindrome(String s) {                  // for checking string is palindrome or not
        int left = 0, right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;    
            left++;
            right--;
        }

        return true;
    }

    public static String longestPalindrome(String s) {
        String result = "";

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String sub = s.substring(i, j + 1);

                if (isPalindrome(sub) && sub.length() > result.length()) {
                    result = sub;
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        String s  = "abcddcnt";
        System.out.println(longestPalindrome(s));
    }
}