// TWO POINTER METHOD 
import java.util.Scanner;

public class palindrome3 {
    public static void pal(int num){
        
        String s = Integer.toString(num); // converting to string
        int start = 0; 
        int end = s.length()-1 ;
        
        while( start < end ){
            if( s.charAt(start) != s.charAt(end)){
                    System.out.println("not palindrome");
                    return;
            }
            start++;
            end--;
        }
        System.out.println("PALINDROME"); 
        num = Integer.parseInt(s)  ;
    }    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number : ");
        int num = sc.nextInt();
        sc.close();
        pal(num);
        
    }
}
