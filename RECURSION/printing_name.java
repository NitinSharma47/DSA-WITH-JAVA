// printing name n times using recursion


public class printing_name{
    public static void name( int n){
        if ( n == 0){
            return;
        }
        System.out.println("NITIN PANDATT");

        name(n-1);

    }
    public static void main(String[] args) {
         name(5);
    }

}