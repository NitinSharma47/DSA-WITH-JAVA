import java.util.Scanner;

public class check_prime {
    public static boolean prime(int num) {
        int count = 0 ;
        for (int i = 1; i <= num ; i ++){
            if( num % i == 0){
                count = count + 1 ;
            }

        }
        // // If the number of factors is exactly 2 (1 and the number itself), it's prime
        return count == 2;
    }
    public static void main(String[] args) {
        Scanner sc = new  Scanner (System.in);
        System.out.println("Enter the number : ");
        int num = sc.nextInt();
        sc.close();
        boolean isPrime = prime(num);
        if (isPrime) {
            System.out.println(num + " is a prime number.");
        }else {
            System.out.println(num + " is not a prime number.");
        }
       
        
    }
    
}
