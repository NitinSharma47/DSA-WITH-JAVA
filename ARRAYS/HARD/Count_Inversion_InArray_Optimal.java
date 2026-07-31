package ARRAYS.HARD;

public class Count_Inversion_InArray_Optimal {
    public static int merge(int[] arr, int low, int mid, int high) {
        
        int[] temp = new int[high - low + 1];
       
        int left = low;
        int right = mid + 1;
        int k = 0;

        // Variable to count inversions
        int cnt = 0;

        // Merge elements in sorted order
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp[k++] = arr[left++];
            } else {
                temp[k++] = arr[right++];
                cnt += (mid - left + 1);            // Count inversions
            }
        }

        // Copy remaining elements of left half
        while (left <= mid) {
            temp[k++] = arr[left++];
        }

        // Copy remaining elements of right half
        while (right <= high) {
            temp[k++] = arr[right++];
        }

        // Copy back to original array
        for (int i = low; i <= high; i++) {
            arr[i] = temp[i - low];
        }

        return cnt;
    }

    // Merge sort function

    public static int mergeSort(int[] arr, int low, int high) {

        int cnt = 0 ;
        if (low >= high) return cnt;

        int mid = (low + high) / 2;
       
        cnt += mergeSort(arr, low, mid);         // Count inversions in left half
        cnt += mergeSort(arr, mid + 1, high);       // Count inversions in right half
        cnt += merge(arr, low, mid, high);      // Count inversions during merge

        return cnt;
    }
    // Function to get number of inversions

    public static int numberOfInversions(int[] arr) {
        return mergeSort(arr, 0, arr.length - 1);
    }
    public static void main(String[] args) {
        // Input array
        int[] a = {5,3,2,1,4};
        System.out.println(  numberOfInversions(a));
    }
}


    

