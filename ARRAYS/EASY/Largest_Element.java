package ARRAYS.EASY;
import java.util.Arrays;

public class Largest_Element {
    public static int large(int arr[]){
        int n = arr.length;
        Arrays.sort(arr);
        
        return arr[n - 1] ;
    }
    public static void main(String[] args) {
        int arr[] = { 4,6,7,3,7,8,42,22};
        System.out.println(large(arr));
    }
}
