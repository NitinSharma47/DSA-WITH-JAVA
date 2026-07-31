// An Amrstrong number is a number that is equal to the sum of its own digits each raised to the power of the number of digits.

import java.util.Scanner;
public class Armstrong_No {

    // Static method to check if a number is an Armstrong number
    public static boolean isArmstrong(int num) {

        // converting integer to string & also getting size of number
        
        int k = String.valueOf(num).length();   // Get number of digits
        int sum = 0;                            // variable for storing the resultant value 
        int n = num;

        while (n > 0) {
            int ld = n % 10;             // Last digit of number
            sum += Math.pow(ld, k);      // multiplying each digit till total no. of digits in number
            n /= 10;                     // Removing last digit  from orginal number till 0
        }

        return sum == num;               // return if original number is same as armstrong number 
    }

    public static void main(String[] args) {
        Scanner sc  = new Scanner (System.in);
        System.out.println("Enter the number : ");
        int number = sc.nextInt();
        sc.close();


        // Use class method to check
        if (isArmstrong(number)) {
            System.out.println(number + " is an Armstrong number.");
        } else {
            System.out.println(number + " is not an Armstrong number.");
        }
    }
}
