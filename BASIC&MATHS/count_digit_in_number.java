import java.util.Scanner;

public class count_digit_in_number {
    public static int digit(int n){
        int count = 0;
         while ( n != 0){
            count += 1;
            n = n/10;
         }
         return count;
    }
    public static void main(String[] args) {
        Scanner cs = new Scanner(System.in);
        System.out.println("enter the number : " );
        int n = cs.nextInt();
        cs.close();
            
        int num_of_digit = digit(n);
        System.out.println(num_of_digit);
        

    }
    
    
}
