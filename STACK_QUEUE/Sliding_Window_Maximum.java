/*
*                                               <<  BRUTE FORCE APPRAOCH  >>

Given an array of integers arr, there is a sliding window of size k which is moving from the very left of the array to the very right.
You can only see the k numbers in the window. Each time the sliding window moves right by one position. 
Return the maximum element from each sliding window..

*/

package STACK_QUEUE;

public class Sliding_Window_Maximum {
    public static int [] win(int arr[] , int k){
        int max [] = new int[arr.length - k + 1] ;

        for(int i = 0 ; i <= arr.length - k ; i ++){
            int maxi = 0;

            for(int j = i ; j < i + k ; j ++){  
                maxi = Math.max(maxi, arr[j]) ;
            }
            max[i] = maxi ;
        }
        return max ;
    }
    public static void main(String[] args) {
        int arr[] = {4,0,-1,3,5,3,6,8} ;
        int k = 3 ;

        int res[] = win(arr, k);
        for(int num : res){
            System.out.println(num);
        }
    }
    
}
