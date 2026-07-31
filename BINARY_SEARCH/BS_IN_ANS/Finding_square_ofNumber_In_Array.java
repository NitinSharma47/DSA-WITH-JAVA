        // finding sqrt of number in array ..

package BINARY_SEARCH.BS_IN_ANS ;

public class Finding_square_ofNumber_In_Array {
    public static int find(int arr[] , int N){

        if(N < 2){ return N ;}          // when N is 1

        int low = 0 , high = arr.length - 1 ;
        int sq = 0 ;

        while(low <= high ){
            int mid = low + (high - low) /2 ;

            if(arr[mid] == N*N){
                sq  = mid ;
            }
            if(arr[mid] > N*N){
                high = mid - 1 ;
            }
            else{
                low = mid + 1;
            }
        }
        return arr[sq] ;
    }
    public static void main(String[] args) {
        int arr[] = {2,4,8,16,22,25,36,50,81,100 } ;
        int N = 9 ;
        System.out.println(find(arr, N));
    }
}