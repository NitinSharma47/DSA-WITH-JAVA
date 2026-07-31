/*  
        Given two sorted integer arrays nums1 and nums2, merge both the arrays into a single array sorted in non-decreasing order.
            The final sorted array should be stored inside the array nums1 and it should be done in-place.
    Array nums1 has a length of m + n, where the first m elements denote the elements of nums1 and rest are 0s whereas nums2 has a length of n.

    *       Here , we have already given extra space in arr1 , to store arr2 elements..
 */
package ARRAYS.HARD;

import java.util.Arrays;

public class MergTwo_Sorted_ArraysWithout_ExtraSpace {
    public static int[] merge(int arr1[] , int arr2 [] ){
        int p2 = 0 ;
        int k = arr1.length - arr2.length ;       // k points to the next index from arr1's element, means start filling after arr1 elements

        while(p2 < arr2.length){            // filll arr2 elements in arr1
            arr1[k] = arr2[p2] ;
            k++ ;
            p2 ++ ;
        }
        Arrays.sort(arr1) ;             // sort the array

        return arr1 ;
    }
    public static void main(String[] args) {
        
        int arr2 [] = {4,5,2} ;
        int arr1[] = {1,4,2,0,0,0};
        
        int res [] = merge(arr1, arr2) ;
        for(int num : res){
            System.out.print(num + " ");
        }
        
    }
}
