package STRING;

public class Check_Palindrome {
    public static void main(String[] args) {
        String s = "racecar" ;

        int left = 0 ; int right = s.length() - 1 ;

        while(left < right) {
            if(s.charAt(left) == s.charAt(right)) {
                left ++ ; right -- ;
            }
            if(s.charAt(left) != s.charAt(right)) {
                System.out.println("String is not Palindrome");
                break ;
            }
            
        }
        System.out.println("String is palindrome");
    }
}
