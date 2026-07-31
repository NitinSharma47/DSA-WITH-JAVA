/*                           Given an array of numbers, you need to return the count of reverse pairs. 
*                                Reverse Pairs are those pairs where i<j and arr[i]>2*arr[j]. 
*/

package ARRAYS.HARD;

public class Count_Reverse_Pairs_Optimal{
    public static void merge(int arr[] , int low , int mid , int high){        // making merge function to merge the divided arrays while sorting

                        // * WHOLE FUNCTION IS SAME AS MERGE SORT FUNCTION
        int left = low ; 
        int right = mid + 1 ;
        
        int temp[] = new int [high - low + 1] ;         // temporary array to store sorted elements
        int k = 0 ;

        while(left <= mid && right <= high) {
            
            if(arr[left] <= arr[right]){
                temp[k++] = arr[left++] ;
            }
            else{
                temp[k++] = arr[right ++] ;
            }
        }
        while( left <= mid){                // when right part is exhausted, then add all left elements to array
            temp[k++] = arr[left++] ;
        }
        while(right <= high){               // while left part is exhausted , then add all right elements to array
            temp[k++] = arr[right++] ;
        }

        for( int i = low ; i <= high ; i ++){       // copy all sorted elements back to the original array, from temp array
            arr[i] = temp[i - low] ;
        }
    }
    
    public static int count_pairs(int arr[] , int low , int mid, int high){         // function to find the reverse pairs ;
        int count = 0 ;                                                                     // variable to track total pairs
        int right = mid + 1 ;

        for( int i = low ; i <= mid ; i ++){                        // counting reverse pairs
            while(right <= high && arr[i] > 2 *arr[right]){         // when i >  2*right element

                right ++ ;
                count += (right - (mid + 1)) ;          // increase count 
            }
        }
        return count ;
    }

    public static int mergesort(int arr[] , int low , int high){    // function to divide the array in parts(using mid) & later merge them all in sorted manner
                        // *  EXCEPT COUNT AND COUNT_PAIRS, WHOLE FUNCTION IS SAME AS MERGE SORT FUNCTION

        int count  = 0 ;
        if(low >= high){return count ;}         // when low reaches high,  return count

        int mid = ( high + low) / 2 ;

        count += mergesort(arr,low, mid);               // taking all counts from first part of array
        count += mergesort(arr,mid + 1 , high);         // taking all counts from second part of array
        count += count_pairs(arr, low, mid , high) ;    // Now, taking counnts from whole array

        merge(arr, low, mid, high);                     // calling the sorting array function

        return count ;                          // return count 
    }       

    public static int Count_Reverse_Pairs(int arr [] , int n){          //  function to give total counts in whole array from 0 to n-1
        return mergesort(arr , 0 , n - 1) ;                         // *assingning low and high of arrays
    }
    public static void main ( String[] args){
        int arr[] = {4,1,2,3,1};
        int n = arr.length ;
        System.out.println(Count_Reverse_Pairs(arr , n)) ;
    }
}