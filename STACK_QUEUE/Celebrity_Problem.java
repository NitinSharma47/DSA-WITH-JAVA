/* 
        A celebrity is a person who is known by everyone else at the party but does not know anyone in return.
        Given a square matrix M of size N x N where M[i][j] is 1 if person i knows person j, and 0 otherwise, 
        determine if there is a celebrity at the party. Return the index of the celebrity or -1 if no such person exists.

        Note that M[i][i] is always 0.

*       By Observation in MATRIX ,we can determine which is celebrity ->
        Celebrity = That row which contains all cells as 0s AND column contains all 1s (except the diagonal, which is normally 0).

*/
package STACK_QUEUE;

public class Celebrity_Problem {
    public static int celebrity(int M[][]) {

        int n = M.length;

        // Step 1: Find possible celebrity
        int candidate = 0;

        for (int i = 1; i < n; i++) {

            if (M[candidate][i] == 1) {
                candidate = i;
            }
        }

        // Step 2: Verify candidate
        for (int i = 0; i < n; i++) {

            if (i == candidate) {
                continue;
            }

            // Candidate should know nobody
            // Everyone else should know candidate
            if (M[candidate][i] == 1 || M[i][candidate] == 0) {
                return -1;
            }
        }

        return candidate;
    }
    public static void main(String[] args) {
        int matrix [][] =   { 
                                {0, 1, 1, 0} ,
                                {0, 0, 0, 0} ,
                                {1, 1, 0, 0} ,
                                {0, 1, 1, 0} 
                            } ;
        System.out.println(celebrity(matrix));
    }
    
}
