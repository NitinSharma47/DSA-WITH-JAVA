// fibonacci number are those number , which gives the sum of previous two values to make the next value..
// ex - 0,1,1,2,3,5,8,13,21,34,55......

import java.util.Scanner;
public class fibonacci {

    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        System.out.println("enter the number, till you want the series :");
        int n = sc.nextInt();
        sc.close();

        // Edge case: if n is 0, print only 0
        if (n == 0) {
            System.out.println(0);
        }
        // Special case: if n is 1, print first two Fibonacci numbers
        else if (n == 1) {
            System.out.println("0 1");
        }
        // General case: compute and print Fibonacci series
        else {
            int[] fib = new int[n + 1];  // Array to hold Fibonacci numbers
            fib[0] = 0;
            fib[1] = 1;

            // Compute Fibonacci numbers from index 2 to n
            for (int i = 2; i <= n; i++) {
                fib[i] = fib[i - 1] + fib[i - 2];
            }

            System.out.println("The Fibonacci Series up to " + n + "th term:");
            for (int i = 0; i <= n; i++) {
                System.out.print(fib[i] + " ");
            }
        }
    }
}

