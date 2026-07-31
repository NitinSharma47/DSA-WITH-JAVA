/*                      Given a matrix if an element in the matrix is 0 
        then you will have to set its entire column and row to 0 and then return the matrix.. */

/*          
*               In matrix,  Always -> rows represents the size of the matrix array..
*                  & columns represents the size of each element of matrix array..   

            APPROACH ->
                1. traverse in whole array and check which cell is 0 
                2. Then do not change it directly to zeero , because this step can change the future elements 's (row & columns) to zero ,,
                    which are not initiallly zero
                3. so, change the curreent element to -1 insteead..
                4. then after traversing to whole array ,Traverse again in array 
                5. And find out which element is  -1 , then change its row & column to zero..
*/


package ARRAYS.MEDIUM;          

public class Set_Matrix_Zero {
    public static int[][] matrixx(int arr[][]){

        int m = arr.length ;                    // Getting number of rows
        int n = arr[0].length ;                 // Getting number of columns

        for(int i = 0 ; i < m ; i ++){              // loop for row
            for(int j = 0 ; j < n ; j ++){              // for column

                if( arr [i][j] == 0){               // when the cell is 0
                    for( int col = 0 ; col < n ; col ++){  // run a loop to change whole row to -1(when changing row,row is always same only column number varies)
                        
                        // this loop changes the whole row elements to -1 , in which zero comes

                        if(arr[i][col] != 0){           //when in any row ,the element is not 0..
                            arr[i][col] = -1 ;          // then change it to -1 
                        }
                    }
                    for( int row = 0 ; row < m ; row ++){     // run a loop to change column(when changing column,column is always same only row number varies)
                        // this loop changes the whole colum elements to -1 , in which zero comes

                        if(arr[row][j] != 0){                //when in any column ,the element is not 0..
                            arr[row][j] = -1 ;              // then change it to -1 first
                        }
                    }
                }
            }
        }
         for (int i = 0; i < m; i++) {              // now change the cell from -1 to zero..
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == -1){           // when the cell is -1 , then change it to zero..this changes all -1 elements to 0
                    arr[i][j] = 0;                                              // making whole row & column to 0
                }   
            }
        }
        return arr ;
    }
    public static void main(String[] args) {
        int matrix[][] = {
            {0,1,2,0},
            {3,4,5,2},
            {1,3,1,5}
        } ;
        matrixx(matrix) ;

        // Print result
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
