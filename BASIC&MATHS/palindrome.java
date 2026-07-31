import java.util.Scanner;

public class palindrome {
    static int rev = 0; // making global variable to use it across inside all functions
    public static int reverse(int n) {
        
        while ( n != 0 ){
            int digit = n%10 ;
            rev = rev*10 + digit;
            n= n/10 ; 
        }
        return rev;
    }
    public static int check( int n) {
        if (  n == rev){
        
            System.out.println("yes this number is a palindrome");
            

        }else{
            System.out.println("NOT PALINDROME");
        }
        return  1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter the number : ");
        int n = sc.nextInt();
        sc.close();
        reverse(n);
        check(n);
        

    }
}
