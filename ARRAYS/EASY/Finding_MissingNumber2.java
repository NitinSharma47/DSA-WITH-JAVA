/* 
                    << OPPTIMAL APPROACH >>
                TIME & SPACE COMPLEXITY - O(N) & O(1)

            APPROACH - 
                    Took sum of all numbers in the array,
                    then take the Expected sum from 1 to N , N is the length of the array
                    now subtract the = Expected sum - original sum
                    --> the result is the missing number 
        
*/

package ARRAYS.EASY;

public class Finding_MissingNumber2 {
    public static int miss(int arr[], int n){
        n = arr.length + 1;                 // +1 because one number is missing

        int Expectedsum = n*(n+1) / 2 ;             // now the n is 8
        int actualSum = 0;

        for( int num : arr){
            actualSum += num ;
        }

        return Expectedsum - actualSum ;
    }
    public static void main(String[] args) {
        int arr [] = { 1,2,6,3,8,5,4} ;
        int n = 7 ;
        System.out.println(miss(arr, n));
    }
    
}
