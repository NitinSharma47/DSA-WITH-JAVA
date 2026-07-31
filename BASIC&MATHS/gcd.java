// this code is for finding the greatest common factor of any two integers

import java.util.Scanner ;

public class gcd {
    public static  int factor(int n1 , int n2){
        int gcd1 = 1;
        for ( int  i = 1 ; i < Math.min(n1, n2) ; i ++ ){
            if (n1 != 0 && n2 != 0 ){
                if ( n1 % i == 0 && n2 % i == 0){
                gcd1 = i ;
                }
            }
            else{
                System.out.println("Enter a value more than 0!!");
            }
        }
        return gcd1;       
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter the first number  : ");
        int n1= sc.nextInt();
        System.out.println("Enter the second Number  : ");
        int n2 = sc.nextInt();
        sc.close();
        System.out.println(factor(n1, n2));
    }
}

