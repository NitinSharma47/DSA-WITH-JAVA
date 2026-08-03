/* 
*                                               <<  BRUTE FORCE  >>
        A line of N kids is standing there. The rating values listed in the integer array ratings are assigned to each kid. 
        These kids are receiving candy according to the following criteria ->

        There must be at least one candy for every child.
        Kids whose scores are higher than their neighbours receive more candies than their neighbours.
        Return the minimum number of candies needed to distribute among children.

*   APPROACH ->
        The objective is to ensure that each child receives at least one candy. 
        Additionally, any child with a higher rating than their adjacent neighbor must receive strictly more candies than that neighbor.

-       Initialize an array to track candies for each child and assign 1 candy to each child (minimum required).
        Iterate repeatedly until no updates are needed in a complete traversal

-       Traverse from left to right:
        For each child, if their rating is greater than the previous child’s and their current candy count is not greater, 
        update it to one more than the previous child's candy count.

-       Traverse from right to left:
        For each child, if their rating is greater than the next child’s and their current candy count is not greater, 
        update it to one more than the next child's candy count.
        Continue alternating left-to-right and right-to-left traversals until no modifications occur in a full pass.

-       Then , select the maximum candy each student have out of(left traversal & right traversal)
        Return the total number of candies by summing up the final values in the array.
 */

public class Candy {
    public static int candies(int ratings[]){

        int minCandy = 0 ;                                                  // variable to store total minCandy required
        int leftMinCandy [] = new int [ratings.length] ;                    // To store the left traversal Min candies for each student
        int rightMinCandy [] = new int [ratings.length] ;                   // To store right

        for(int i = 0 ; i < ratings.length ; i ++){                         // Comparing from Left Neighbour 
            if(i == 0){                                                     // for 1st student , there is no left..
                leftMinCandy[i] = 1 ;
                continue ;
            }
            if(ratings[i] > ratings[i - 1]){                                // if current rating is higher than previous
                leftMinCandy[i] = leftMinCandy[i-1] + 1;                    // give more candies
            }
            else{
                leftMinCandy[i] =  1 ;                                      // if ratings lower , give only 1 candy (minimum)
            }
        }

        for(int i = ratings.length - 1 ; i >= 0 ; i --){                    // Comparing from Right Neighbour 
            if(i == ratings.length - 1){                                    // for last element, there is no right..
                rightMinCandy[i] = 1 ;                                      
                continue ;
            }
            if(ratings[i] > ratings[i + 1]){                                // if current rating is higher than previous one , give more candies
                rightMinCandy[i] = rightMinCandy[i + 1] + 1 ;                   
            }
            else{
                rightMinCandy[i] = 1;                                       // if lower, then give only 1 candy (minimum)
            }
        }
        int left = 0 , right = 0 ;

        while(left < leftMinCandy.length && right < rightMinCandy.length){                  // Now , traverse in Both Arrays
            minCandy += Math.max(leftMinCandy[left], rightMinCandy[right]) ;                // Take the maximum for every student, & add to minCandy
            left ++ ;
            right ++ ;
        }
        return minCandy ;

    }
    public static void main(String[] args) {
        int ratings[] = {0,2,4,3,2,1,1,3,5,6,4,0,0} ;
        System.out.println(candies(ratings));
    }
}

// *                                               T & S COMPLEXITY -> O(3N) ~ O(N) , O(2N) ~ O(N)