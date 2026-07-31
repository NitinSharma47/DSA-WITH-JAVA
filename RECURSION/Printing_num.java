// Printing numbers from 1 to n

public class Printing_num{
    public static void number(int current ,int n){

        if  ( current > n){
            return;
        }

        System.out.println(current + " ");

        number(current+1, n);

    }
    public static void main(String[] args) {
        
        System.out.println();
        number(1, 5);
    }
    
    
}
