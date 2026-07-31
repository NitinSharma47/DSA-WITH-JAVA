package ARRAYS.EASY;

public class Searching_AnElement {
    public static int linearSearch(int arr[] , int num ){
        int n = arr.length;

        for(int i = 0 ; i < n; i ++){
            if( arr[i] == num){
                System.out.println("yes at position : " + i);
            }
        }
        return -1 ;
    }
    public static void main(String[] args) {
        int arr[] = { 2,3,4,6,8,9,5,2,44,4,12} ;
        linearSearch(arr, 44) ;

    }
    
}
