/*                                       << OPTIMAL APPROACH USING XOR >>
         ** This approach only works if there is only one single element in array & other elements are twice times only,
                because the XOR operatio cancels duplicates elements , it doesnt work on thrice or more frequency elements..

    Two important properties of XOR are the following:
        1. XOR of two same numbers is always 0 i.e. a ^ a = 0. 
        2. XOR of a number with 0 will result in the number itself i.e. 0 ^ a = a. 

    Approach ->
        We will just perform the XOR of all elements of the array using a loop and the final XOR will be the answer. 

*/

package ARRAYS.EASY;

public class Appear_OnceElement2 {
    public static int appear(int arr[]){

        int xor = 0 ;

        // XOR all elements — duplicates cancel each other out
        for(int num : arr){
            xor ^= num ;
        }
        return xor ;
    }
    public static void main(String[] args) {
        int arr[] = { 4, 1, 2, 1, 2};
        System.out.println(appear(arr));
    }
    
}
