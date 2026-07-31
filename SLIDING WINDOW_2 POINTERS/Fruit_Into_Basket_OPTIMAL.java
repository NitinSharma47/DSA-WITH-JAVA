/*
*   Problem Statement: 
    There is only one row of fruit trees on the farm, oriented left to right. An integer array called fruits represents the trees, 
    where fruits[i] denotes the kind of fruit produced by the ith tree.
    The goal is to gather as much fruit as possible, adhering to the owner's stringent rules :

    There are two baskets available, and each basket can only contain one kind of fruit. The quantity of fruit each basket can contain is unlimited.
    Start at any tree, but as you proceed to the right, select exactly one fruit from each tree, including the starting tree. 
    One of the baskets must hold the harvested fruits.
    Once reaching a tree with fruit that cannot fit into any basket, stop.
    Return the maximum number of fruits that can be picked.
*           You can start from any tree, But if u started , then you have to pick one fruit from all trees on right..


*                                                      <<  APPROACH  >>
    In this optimal approach, we keep track of just the last two fruit types seen and their last positions. 
    This allows us to avoid using any auxiliary space like a hash map. The idea is simple: we maintain a sliding window that only contains 
    two types of fruits and expand it as long as the new fruit belongs to either of those two types. If a new third type appears, 
    we shrink the window to start right after the last occurrence of the second last fruit type.

*                                                       <<  WORKING >>
    Initialize two variables to store the two recent fruit types seen and their last positions.
    Traverse the array while expanding the window to include current fruits as long as they match the two types.
    If a third fruit type appears, update the window to start just after the last occurrence of one of the older fruit types.
    Track the maximum length of valid windows throughout the traversal.

*   Examples
            Input :fruits = [1, 2, 1]
            Output :3

            Input : fruits = [1, 2, 3, 2, 2]
            Output : 4

*/

class Solution {
    public int totalFruit(int[] fruits) {
        int maxlen = 0;                                                     // Variables to track max window size

        int lastFruit = -1, secondLastFruit = -1;                           // Variables to track max window size
        int currCount = 0, lastFruitStreak = 0;                             // Count of current window and streak of last frui

        for (int fruit : fruits) {                                          // Traverse through each fruit
            
            if (fruit == lastFruit || fruit == secondLastFruit) {           // If fruit matches last two fruits , expand window
                currCount++;
            } 
            else {
                currCount = lastFruitStreak + 1;                             // Reset window size to streak + 1
            }
            
            if (fruit == lastFruit) {                                        // Update lastFruit streak and fruit types
                lastFruitStreak++;
            } 
            else {
                lastFruitStreak = 1;
                secondLastFruit = lastFruit;
                lastFruit = fruit;
            }
            
            maxlen = Math.max(maxlen, currCount);                            // Update max window size
        }
        return maxlen;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] fruits = {1,2,1,2,3};
        System.out.println(sol.totalFruit(fruits));
    }
}

