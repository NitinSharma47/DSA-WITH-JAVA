package BINARY_SEARCH.BS_IN_1D_ARRAYS ;

public class Check_Element {
    public static boolean check( int arr[] , int target){

        int low = 0 , high = arr.length - 1 ;
        int ans = -1 ;

        while ( low <= high){
            int mid = low + (high - low) / 2 ;          

            if(arr[mid] > target){  // when target is lesser than the mid , so we check in 0 to mid - 1
                high = mid - 1 ;
            }
            else if( arr[mid] < target) {   //when target is greater than the mid , so we check in mid + 1 to high
                low = mid + 1;
            }
            else{       // only 1 condition remain now , when target is equal to mid
                ans = mid ;                 // store the index where target is found
                System.out.println(ans);
                return true ;               // means the target is present ,and is found in array
            }
        }
        return false ;          // when target is not found in array
    }
    public static void main(String[] args) {
        int arr[] = {2,3,4,5,6,7,8,9};
        int target = 7 ;
        System.out.println(check(arr, target));
    }
}