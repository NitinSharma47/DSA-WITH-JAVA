/*                                      <<  OPTIMAL APPROACH  >>

                    To optimize it , we have to rotate this in-place matrix array..
                                which reduce the Space Complexity

                                            *Approach ->
            1. Transpose the matrix   (it makes the rows into columns or columns into rows) means -> [i][j] = [j][i]
            2. Reverse each row      (this step stimulates the clockwise 90 degree rotation )

 */

package ARRAYS.MEDIUM ;
public class Rotate_Matrix_by_90_Optimal{
    public static int[][] matrix(int arr[][]){
        int m = arr.length ;            // here row & column are same ... so single variable is enough

         // Step 1: Transpose the matrix
        for(int i  = 0 ; i < m ; i ++){
            for(int j = i + 1 ; j < m ; j ++){

                int temp = arr[i][j] ;         // Transposing the matrix (SWAP)
                arr[i][j] = arr[j][i];
                arr[j][i] = temp ;
            }
        }
        // Step 2: Reverse the row
        for(int i = 0 ; i < m ; i ++ ){
            int left = 0 , right = m - 1 ;

            while(left < right) {           // Swaping the first and last elements..until all are swapped
                int temp = arr[i][left] ;
                arr[i][left] = arr[i][right];
                arr[i][right] = temp ;

                left ++ ;
                right -- ;
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        int arr [][] = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        int ans[][] = matrix(arr);

        // Print the rotated matrix
        for(int num[] : ans){
            for( int val : num){
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

}