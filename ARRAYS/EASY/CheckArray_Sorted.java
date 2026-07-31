package ARRAYS.EASY;

public class CheckArray_Sorted {
    public static boolean check ( int arr[]){
        int n = arr.length;
        for( int i = 0; i < n ; i ++){
            for (int j = i+1 ; j < n ; j ++){
                if( arr[i] > arr[j]){
                    return false ;
                }
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        int arr[] = { 4,5,2,8,9,10};
        System.out.println(check(arr));

    }
    
}
