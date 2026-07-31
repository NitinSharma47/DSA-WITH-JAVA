/* 
Merge Sort is a divide and conquer sorting algorithm.
It works by:

Dividing the array into two halves
Sorting each half recursively
Merging the two sorted halves into one sorted array         */


package SORTING;

public class Merge_sort {
    public static void mergesort(int arr[] , int low ,int high){
        
        if ( low >= high){ return ;}                    // BASE CASE

        int mid  = (low + high)/2 ;
        mergesort(arr, low, mid);                               // dividing the arrayy...
        mergesort(arr, mid + 1, high);
        merge(arr, low, mid , high);                             // now, its time to merge..

    }
    public static void merge( int arr[] , int low , int mid , int high){            // to merge the array in sorting manner

        int temp [] = new int[high - low + 1] ;                         // used to store the sorted elements
        int k = 0;                                                      // used to fill the sorted elements in temp from 0th index..

// left and right are the pointers used in both parts of divided array, to compare the elements from  both parts pf arrays and place them accordingly to sorted manner 
        int left = low ; int right = mid + 1 ;                          
        while (left <= mid && right <= high ){
            if ( arr[left] < arr[right]){
                temp[k]= arr[left];                         // placing the sorted element in temp array
                left ++ ;
            }else{
                temp[k] = arr[right];
                right ++ ;
            }
            k ++ ;
        }
        while ( left <= mid){             //adding remaining left elements to temp directly, if right side of the array is exhausted or finished
            temp[k]= arr[left];
            left ++ ;
            k ++ ;
        }
        while ( right <= high) {          // adding remaining right elemennts to temp directly, if left side of the array is exhausted or finished
            temp[k] = arr[right];
            right ++ ;
            k ++ ;
        }
        for (int  i = 0 ; i < temp.length ; i ++){    // adding all elements to  original Array from temp
            arr[ low + i ] = temp [ i ];              // low + i , because merging not always started from 0th index... so to place elementss correctly at position , low is used
        }
    }


    
    public static void main(String[] args) {
        int arr [] = { 4,6,2,7,1,4};
       
        mergesort(arr, 0, arr.length - 1);           // initialsing values of low and high in arr..
        for ( int num : arr){
            System.out.print(num + " ");
        }
       
    }
    
}
