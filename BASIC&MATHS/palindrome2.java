import java.util.Scanner;

class palindrome2 {

    public static int digit(int n){
        int count = 0;
        while(n != 0){
            n = n / 10;
            count++;
        }
        return count;
    }

    public static void odd(int num, int digits){
        int mid = digits / 2;

        String s = Integer.toString(num);

        for(int i = mid - 1, j = mid + 1; i >= 0 && j < digits; i--, j++){
            if(s.charAt(i) != s.charAt(j)){
                System.out.println("NOT PALINDROME");
                return;
            }
        }

        System.out.println("PALINDROME");
    }

    public static void even(int num, int digits){
        int mid = digits / 2;

        String s = Integer.toString(num);

        for(int i = mid - 1, j = mid; i >= 0 && j < digits; i--, j++){
            if(s.charAt(i) != s.charAt(j)){
                System.out.println("NOT PALINDROME");
                return;
            }
        }

        System.out.println("PALINDROME");
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number:");
        int n = sc.nextInt();
        sc.close();

        int d = digit(n);

        if(d % 2 == 0){
            even(n, d);
        } else {
            odd(n, d);
        }
    }
}