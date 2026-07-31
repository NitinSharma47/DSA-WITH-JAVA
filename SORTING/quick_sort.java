/*                           It is an Divide and Conqueor based Algorithm 
            It is one of the fastest algorithms

working-

1.    Choosing a pivot element
2.    Placing the pivot at its correct position
3.    Putting:
        smaller elements on left
        larger elements on right
4.    Recursively sorting left and right parts   
        (means ,for every pass there is always a pivot element is choosed and place it at correct position)

*/


package SORTING;

public class quick_sort {
    public static void quicksort( int arr [] ,int low , int high){

        if( low < high){

            int partition = quick(arr, low, high);       // partition is the index of pivot element, where it is placed after sort
            quicksort(arr, low, partition-1);
            quicksort(arr, partition + 1, high);

        }
    }

    public static int quick(int arr[], int low, int high ){
        
        int i = low ;                           //initialising pointers(i & j)..
        int j = high ;
        int pivot = arr[low];                   // initialising the pivot element 's position

        while(i < j){

            // finding bigger element than pivot--
            while(arr[i] <= pivot && i < high){        // i will find the bigger element than pivot from left
                i ++ ;
            }
            // finding lesser element than pivot--
            while( arr[j] > pivot && j > low){         // j will find the lesser element from pivot from right
                j --;
            }

            //swapping the lesser element and bigger element at pivot's left and right side respectively..
            if( i < j){
                int temp = arr[j];
                arr[j] = arr[i] ;
                arr[i] = temp;
                
            }        
        }

    // placing the pivot element at its correct position according to its left and right side, after swapping
        int temp = arr[low];
        arr[low] = arr[j];              // swapping from j because, when i & j cross each other then the next elements starting from j+1 are always bigger than pivot...
        arr[j] = temp ;

        return j;                       //  returning j , because index of j is coorect position for pivot element (the left side is lesser and the right side is bigger)
    }
        
    public static void main(String[] args) {
        int arr[] = { 5,6,7,2,4,1};
        quicksort(arr, 0, arr.length - 1);
        for ( int nm : arr){
            System.out.print(nm + " ");
        }   
    }
    
}
