// Second way to reverse the number

import java.util.Scanner;

public class rev2_num {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number : ");
        int num = sc.nextInt();
        
        sc.close();

        // converting integer to string

        String s = Integer.toString(num);

        //making string to strringbuilder
        StringBuilder s1 = new StringBuilder(s);
        // using in built function of string builder to reverse the reverse the number
        s1.reverse();
        System.out.println(s1);

        // the code is end here  , but u can convert the string back from stringbuilder....


        


        
        
    }
        

}
