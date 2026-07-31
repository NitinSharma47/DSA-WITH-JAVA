package BINARY_SEARCH.BS_IN_1D_ARRAYS
;

public class Lower_Bound {
    public static void main(String[] args) {
        int arr [] = {3,5,8,15,19} ;
        int target = 9 ;

        for( int i = 0 ; i < arr.length ; i ++){
            if( arr[i] >= target){     // this returns the first element which is equal or greater than target
                System.out.println("The lower Bound is :" + i);
                break;
            }
        }
    }
}
