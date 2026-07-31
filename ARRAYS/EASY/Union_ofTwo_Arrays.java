/*              The union of two arrays can be defined as the common and distinct elements in the two arrays.
                NOTE: Elements in the union should be in ascending order.

                << OPTIMAL APPROACH >>
                Using two pointers...


*/

package ARRAYS.EASY;

import java.util.Arrays ;

public class Union_ofTwo_Arrays {
    public static int [] union(int arr1 [] , int arr2 []){

        int m = arr1.length; int n = arr2.length ;
        int s = m + n ;
                            
        int uni [] = new int [s] ;          // making a new array of length s
        int k = 0 ;                         // varaible to trace the indexes in uni array
        
        int end1 = m-1; int end2 = n-1 ;        // initialsing pointers on the last index of both arrays
        int m1 = 0 ; int n1 = 0 ;               // making starting pointer on both arrays

        Arrays.sort(arr1);                      // sorting both arrays
        Arrays.sort(arr2);

        while (m1 <= end1 && n1 <= end2){       // till when the start indexes reach the end indexes in both arrays

            if (arr1[m1] <= arr2[n1]){          // when element of arr1 is smaller than element of arr2..add it first to uni array
                uni[k] = arr1[m1];
                m1 ++ ;                         // move start pointer to next element in arr1
            }else{
                uni[k] = arr2[n1];              // when element of arr2 is smaller than element of arr1..add it first to uni array
                n1 ++ ;
            }
            k++;                                // move to next index in uni array
        }  
        while(m1 <= end1){                      // Add remaining elements of Arr1 to uni Array , when arr2 elements are exhausted
            uni[k] = arr1[m1] ;
            k ++ ;
            m1 ++ ;
        } 
        while(n1 <= end2){                      // Add remaining elements of Arr2 to uni Array , when arr1 elements are exhausted
            uni[k] = arr2[n1];
            k++ ;
            n1++ ;
        }   
    
    
    return uni ;
    
    }  
    public static void printArray(int uni []){                  // Function to Print Uni Array
        for (int num:uni){
            System.out.print(num);
        }
    }  
    public static void main(String[] args) {
        int arr1 [] = {3,4,5,6};
        int arr2 [] = {2,1,3,7,99,3,2,8};
         
        printArray(union(arr1, arr2));
    }
}
