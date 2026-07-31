/*              Given two sorted arrays arr1 and arr2 of sizes n and m, find the median of the combined sorted array.
                You must combine the elements conceptually while maintaining sorted order.
*                                      MEDIAN CAN BE IN DECIMAL , AND ALSO CAN BE OUTSIDE OF ARRAY ELEMENTS TOO
*                                        MEDIAN means LEFT ELEMENTS AND RIGHT ELEMENTS AROUND MEDIAN IS EQUAL 
*/

package BINARY_SEARCH.BS_IN_ANS;

public class Median_ofTwo_Sorted_Arrays {
    public static double med(int arr1[] , int arr2[]){

        int temp[] = new int [arr1.length + arr2.length] ;              // temp array to store both sorted array
        int k = 0 ;                                                     // variable to track index in temp

        int low1 = 0 ; int low2 = 0;

        while(low1 < arr1.length && low2 < arr2.length){                    // merge the both arrays, while maintaining its sorting order
  
            if(arr1[low1] <= arr2[low2] ){
                temp[k++] = arr1[low1++]  ;
            }
            else{
                temp[k++] = arr2[low2++]  ;
            }
        }
        while(low1 < arr1.length){                                                  // when arr2 is exhausted
            temp[k++] = arr1[low1++]  ;
        }
        while (low2 < arr2.length) {                                                // when arr1 is exhausted
            temp[k++] = arr2[low2++]  ;
            
        }
        int totalElement = temp.length ;                                  // calculating total elements in both arrays
        double median = 0 ;                                               // of double type , because to store decimal values too

        if(totalElement % 2 == 0){                    // when total elements are even, then there are two midvalues,and final median is between them
            int median1 = (totalElement / 2 ) - 1;                          
            int median2 = totalElement / 2 ;

            median = (temp[median1] + temp[median2] ) / 2.0 ;       // finding final median value, dividing by 2.0 to maintain its double behaviour
        }
        else{                                                       // when total elements are odd,  then median is the half of length of array
            median = temp[temp.length / 2]   ;
        }
        return median ;

    }
    public static void main(String[] args) {
        int arr1[] = {2,4,7,8} ;
        int arr2[] = {5,6,7,8} ;

        System.out.println(med(arr1, arr2));
    }
}
