/*
*                                                   <<    OPTIMAL APPROACH    >>
*   APPROACH ->
        Treat the ratings as a combination of increasing and decreasing slopes. 
        At every peak (where the slope changes from increasing to decreasing), we need to give the maximum number of candies. 
        For valleys (local minima), the child should always get 1 candy. The idea is to simulate the shape of the slope: while going up, 
        increase candies; while going down, also increase a counter (valley depth). 
        To avoid double-counting the peak (which is counted from both sides), we subtract the smaller of the two slope heights.

*   STEPS ->
        Start with giving 1 candy to each child, so initialize total candies with size of ratings.
        Iterate through the ratings from left to right using an index.
        If current rating equals the previous one, move ahead (as each already has 1 candy).
        If there's an increasing slope (current rating > previous rating):
        Count the increasing slope length (peak height).
        For each step up, add increasing value of candies to total.
        If there's a decreasing slope (current rating < previous rating):
        Count the decreasing slope length (valley depth).
        For each step down, add increasing value of candies to total.
        After one increasing and decreasing slope, subtract the smaller of the peak and valley (as the peak child was double-counted).
        Continue this process until the end of the array.
        Return the total candies at the end.
*/
class Candy {
    public static int candy(int[] ratings) {

        int n = ratings.length;
        int candies = n;                                                        // Initially give 1 candy to each child
        int i = 1;                                                              // Start from second child

        while (i < n) {
            if (ratings[i] == ratings[i - 1]) {                                 // Skip equal ratings, already provided 1 rating to each
                i++;
                continue;
            }

            int peak = 0;                                                       // *Initialize increasing slope counter
            while (i < n && ratings[i] > ratings[i - 1]) {                      // Traverse strictly increasing ratings
                peak++;
                candies += peak;
                i++;
            }

            int valley = 0;                                                     // *Initialize decreasing slope counter
            while (i < n && ratings[i] < ratings[i - 1]) {                      // Traverse strictly decreasing ratings
                valley++;
                candies += valley;
                i++;
            }
            candies -= Math.min(peak, valley);                                  // *Remove overlapping candy at the peak
        }

        return candies;
    }

    public static void main(String[] args) {
        int ratings[] = {0,2,4,3,2,1,1,3,5,6,4,0,0} ;
        System.out.println(candy(ratings));
    }
    
}

// *                                    T & S COMPLEXITY ->  O(N)  ,  O(1)