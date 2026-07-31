/*              Given an N * N 2D integer matrix, rotate the matrix by 90 degrees clockwise. 
            The rotation must be done in place, meaning the input 2D matrix must be modified directly..

example ->
            Input :-    matrix = [[1, 2, 3],  
                                  [4, 5, 6],
                                  [7, 8, 9]]

            Output :    matrix = [[7, 4, 1],  
                                  [8, 5, 2],
                                  [9, 6, 3]]

*   so, by rotating the matrix by 90 degree ->      1. The rows become columns          2. But , in reverse order()

                                                <<  BRUTE FORCE APPROACH  >>

                            
        *Tips by Observation ->
                1. after rotating the array , the current cell(element) [i][j] becomes ->  [j][n-i-1]
                    the position of the element changes in the way above..
                    * So , we can directly make any element's [i][j] to [j][n-i-1] , this will rotate the matrix array by 90 degres


 */
package ARRAYS.MEDIUM;

public class Rotate_Matrix_by_90_Degree {
    public static int[][] mat(int arr[][]){
        int m = arr.length ;
        int n = arr[0].length ;
        int rotated[][] = new int [m][n] ;

        for(int i = 0 ; i < m ; i ++){
            for( int j = 0 ; j < n ; j ++){
                rotated[j][n-i-1] = arr[i][j];
            }
        }
        return rotated ;
    }
    public static void main(String[] args) {
        int arr [][] = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        int ans[][] = mat(arr);

        // Print the rotated matrix
        for(int num[] : ans){
            for( int val : num){
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
