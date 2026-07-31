// Given an integer N, return all divisors of N.

import java.util.Scanner;

public class All_Divisor_num {
    public static int divisor( int num){
        int n = 0;
        for ( int i = 1 ; i < num ; i++){
            if ( num % i == 0){
                n = i ;
                System.out.println(n);


            
            }
        }

        return n ;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number : ");
        int num =  sc.nextInt();
        sc.close();
        divisor(num);

        
    }
}