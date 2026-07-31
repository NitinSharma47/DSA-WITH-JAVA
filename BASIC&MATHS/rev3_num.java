// Third way to reverse any number
import java.util.Scanner;

public class rev3_num {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number :");
        int n = sc.nextInt();
        sc.close();
// Converting integer to string
        String s = Integer.toString(n);
        String rev = "";

        for( int i = s.length()-1 ; i >= 0 ; i--){ // iterating loop in reverse (from last index to first index)
            rev = rev + s.charAt(i); // returning the values in new variable reverse
            
        }
        System.out.println(rev);
    }
}
