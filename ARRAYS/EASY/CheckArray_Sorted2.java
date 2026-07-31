package ARRAYS.EASY;

public class CheckArray_Sorted2 {
    public static boolean check2( int arr[]){
        int n = arr.length;

        int i = 0 ; int j = i + 1 ;
        while ( i < n-1) {
            if( arr[i] > arr[j]){
                return  false ;
            }
            i++ ; j ++ ;
        }
        return true ;

    }
    public static void main(String[] args) {
        int arr[] = { 3,4,5,2,7,8,9};
        System.out.println(check2(arr));
    }
    
}
