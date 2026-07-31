/*                      Given an array of integers arr[] and an integer target.
            1st variant: Return YES if there exist two numbers such that their sum is equal to the target. Otherwise, return NO.
            2nd variant: Return indices of the two numbers such that their sum is equal to the target. Otherwise, we will return {-1, -1}. 
            
                            << BRUTE FORCE APPROACH >>
            */

package ARRAYS.MEDIUM ;

public class Two_Sum_Brute {
    public static String twoexist(int arr[] , int target){          // 1st variant

        for( int i = 0 ; i < arr.length - 1 ; i ++ ){
            for( int j = arr.length-1 ; j >= 0 ; j --){

                if(arr[i] + arr[j] == target){
                    return "yes" ;
                }
            }
        }
        return "No" ;
    }
    public static int[] twoindices(int arr[] , int target){              // 2nd variant 
        
        for( int i = 0 ; i < arr.length - 1 ; i ++ ){
            for( int j = arr.length-1 ; j >= 0 ; j --){

                if(arr[i] + arr[j] == target){
                    return new int[]{i,j} ;
                }
            }
        }
    return new int[]{-1,-1} ; 
    }
    public static void main(String[] args) {
        int arr[] = new int[]{2,3,4,5,6,12};
        int target = 10 ;
        System.out.println(twoexist(arr, target));
        int result[] = twoindices(arr, target); 
        System.out.println(result[0] + "," + result[1]);
    }
    
}
