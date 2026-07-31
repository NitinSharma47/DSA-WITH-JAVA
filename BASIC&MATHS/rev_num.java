//program to reverse the number

import java.util.Scanner;

public class rev_num {
    public static int reverse(int num){
        int rev = 0;
        
        while ( num != 0){
            int digit = num % 10 ; // this will extract the final digit of the number 
            rev = rev*10 + digit; //  adding the extracted digit back  to reverse variable by multiplying by 10...
            num = num/10; // this removes the last digit from the original number

        }
        System.out.println(rev);
        return rev;
            

        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        System.out.println("enter your number : ");
        int num = sc.nextInt();
       
        sc.close();
        reverse(num);
        


    }
}
