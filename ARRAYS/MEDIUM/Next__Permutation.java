/*                       Next_permutation : find next lexicographically greater permutation
    Given an array Arr[] of integers, rearrange the numbers of the given array into the lexicographically next greater permutation of numbers.
    If such an arrangement is not possible, it must rearrange to the lowest possible order (i.e., sorted in ascending order).
 */
package ARRAYS.MEDIUM;

public class Next__Permutation {
    public static int[] perm(int arr[]){
        int n =  arr.length ;
        int pivot = -1 ;

        for(int i = n-2 ; i >= 0 ; i --){      // finding the pivot element , means the index from which the next greater permutation can start..
            if(arr[i] < arr[i + 1]){
                pivot = i ;
                break;
            }
        }
        if(pivot  == -1){                   // if pivot element not found , means if the array or number is already in descending order
            reverse(arr, 0, n-1);       //*  (then no greater permutation exists)
            return arr;                      
        }

        // *now, to  find the next greater element , the suffix array ->  from pivot to end.. is always in descending order
                // *so , if a single elememt is found that is greater than the pivot, then we can consider it as the next greater..
                // *because after that element all predecceing elements are more bigger(not next greater)

        for(int j = n -1 ; j > pivot ; j --){          // finding the next greater element....to swap from pivot
            if(arr[j] > arr[pivot]){
                swap(arr, j, pivot);
                break ;
            }
        }
        // *Reversing the remaining , suffix part of array(because after the pivot index -> all elements are always in descending order)
        // *So , reversing them make it in ascending order..and in correct lexicographical order

        reverse(arr, pivot + 1, n-1);               // reversing from after the pivot element
        return arr;
    }
    private static void swap( int arr[] , int i , int j){                // function to swap the numbers
        int temp = arr[i] ; 
        arr[i] = arr[j];
        arr[j] = temp ;
    }
    private static void reverse(int arr[], int start , int end){         // function to reverse
        while(start < end){
            swap(arr, start, end);
            start ++ ;
            end -- ;
        }        
    }
    public static void main(String[] args) {
        int arr[] = { 1,3,2 } ;
        int result [] = perm(arr);
        for( int num : result){
            System.out.print(num +  " ");
        }
    }   
}
