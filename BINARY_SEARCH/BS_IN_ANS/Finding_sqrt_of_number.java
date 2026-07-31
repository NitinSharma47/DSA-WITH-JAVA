package BINARY_SEARCH.BS_IN_ANS;

public class Finding_sqrt_of_number {
    public static int find(int N){

        if(N < 2){ return N ;}          // when N is 1

        int low = 0 , high = N/2 ;        // n/2 because , for any number sqrt is always less than the half 
        long sqrt = 0 ;

        while (low <= high) {
            
            long mid = low + (low) / 2;
           
            if (mid * mid <= N) {        // Check if mid*mid is less than or equal to x

                sqrt = (int) mid;       // store mid as sqrt for potential answer
                low = (int) mid + 1;        // Move to right half
            } 
            else {
                high = (int) mid - 1;       // Move to left half
            }
        }
        return (int)sqrt;
    }
    public static void main(String[] args) {
        int N = 9;
        System.out.println(find(N));
    }
}
