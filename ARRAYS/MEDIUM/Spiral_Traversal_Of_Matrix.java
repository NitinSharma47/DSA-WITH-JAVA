/*                  Given a Matrix, print the given matrix in spiral order.
        Matrix ->
                    1   2   3   4
                    5   6   7   8
                    9   10  11  12
                    13  14  15  16

        outupt ->   Spiral traversal is:

                    1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10

                    Step 1: Top Row →
                    Step 2: Right Column ↓
                    Step 3: Bottom Row ←
                    Step 4: Left Column ↑
                    Move to the Inner Matrix..And do so until every element is visited..
 */
package ARRAYS.MEDIUM;

import java.util.ArrayList;
import java.util.List;

public class Spiral_Traversal_Of_Matrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        
        List<Integer> result = new ArrayList<>();           // list to store the spiral order

        // Initialize boundaries

        int top = 0;                        // Starting row
        int bottom = matrix.length - 1;     // Ending row
        int left = 0;                       // Starting column
        int right = matrix[0].length - 1;   // Ending column

        // Loop until all elements are traversed

        while (top <= bottom && left <= right) {

            // Traverse the top row from left to right ->

            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);             //Add all elements of first row
            }
            top++; // Move the top boundary downward

            // Traverse the right column from top to bottom
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--; // Move the right boundary leftward

            // Traverse the bottom row from right to left (only if rows remain)
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--; // Move the bottom boundary upward
            }

            // Traverse the left column from bottom to top (only if columns remain)
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++; // Move the left boundary rightward
            }
        }
        return result;
    }
    public static void main(String[] args) {

        // Input matrix
        int[][] matrix = {
            { 1,  2,  3,  4 },
            { 5,  6,  7,  8 },
            { 9, 10, 11, 12 },
            { 13,14, 15, 16 }
        };
        System.out.println(spiralOrder(matrix));
    }

    
}
