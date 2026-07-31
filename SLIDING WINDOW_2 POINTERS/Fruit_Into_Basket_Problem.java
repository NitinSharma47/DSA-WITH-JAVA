/*
*                                   <<  THIS IS A FULL VISUALIZATION & IMAGINATION CODE MADE BY ME  >>
*                                                         <<  NITIN SHARMA  >>

Problem Statement: There is only one row of fruit trees on the farm, oriented left to right. 
An integer array called fruits represents the trees, where fruits[i] denotes the kind of fruit produced by the ith tree.
todo:         The goal is to gather as much fruit as possible, adhering to the owner's stringent rules :

*Rules
1. There are two baskets available, and each basket can only contain one kind of fruit. The quantity of fruit each basket can contain is unlimited.
2. Start at any tree, but as you proceed to the right, select exactly one fruit from each tree, including the starting tree.
   One of the baskets must hold the harvested fruits.
3. Once reaching a tree with fruit that cannot fit into any basket, stop.

Return the maximum number of fruits that can be picked.
*           You can start from any tree, But if u started , then you have to pick one fruit from all trees on right..

Examples
Input :fruits = [1, 2, 1]
Output :3
Explanation : We will start from first tree.
The first tree produces the fruit of kind '1' and we will put that in the first basket.
The second tree produces the fruit of kind '2' and we will put that in the second basket.
The third tree produces the fruit of kind '1' and we have first basket that is already holding fruit of kind '1'. So we will put it in first basket.
Hence we were able to collect total of 3 fruits.


Input : fruits = [1, 2, 3, 2, 2]
Output : 4
Explanation : we will start from second tree.
The first basket contains fruits from second , fourth and fifth.
The second basket will contain fruit from third tree.
Hence we collected total of 4 fruits.

*                               TIME COMPLEXITY = O(N^2)
*                               SPACE COMPLEXITY = O(N)

*                               NOT OPTIMAL , BUT WORTH IT BUILDING.....MAKES ME HAPPY 
*/

import java.util.*;

public class Fruit_Into_Basket_Problem {
    public static int khet(int tree[]){

        int fruit = 0;

        List <Integer> basket1 = new ArrayList<>();   
        List <Integer> basket2 = new ArrayList<>() ;  

        int left = 0 ;

        for(int right = 0 ; right < tree.length ; right ++){
            
            if(basket1.contains(tree[right])){              // if basket 1 contains , current type of fruit
                basket1.add(tree[right]) ;
                
            }
            else if(basket2.contains(tree[right])){         // if baasket 2 contains , current type of fruit
                basket2.add(tree[right]) ;
            }
            else if (basket1.isEmpty()) {                   // if basket 1 is empty , in case of 1st tree (right = 0)
                basket1.add(tree[right]);
            }
            else if (basket2.isEmpty()) {                   // Basket 2 is empty , in case of 2nd tree( right = 1)
                basket2.add(tree[right]);
            }
            else{                                           // When none basket contain current fruit , means this is the third type of fruit
                if(right == tree.length - 1){                   // if right is on last tree ,  then no benefit by adding it / or shrinking the window
                    continue ;
                }
                else{                                   
                    while (!basket1.isEmpty() && !basket2.isEmpty()) {      // Keep removing from left until one fruit type completely disappears
                        int leftFruit = tree[left];

                        if (basket1.contains(leftFruit)) {                      // empty the basket 1 , if it contains the current fruit type
                            basket1.remove(Integer.valueOf(leftFruit)) ;
                        } 
                        else {                                                  // empty the basket 2 , if it contains the current fruit type
                            basket2.remove(Integer.valueOf(leftFruit));
                        }
                        left++;                                                 // shrink the window by moving left forward
                    }
                    if (basket1.isEmpty()) {                                     // *Put the new/current fruit into the empty basket
                        basket1.add(tree[right]) ;
                    } 
                    else {
                        basket2.add(tree[right]);
                    }
                }
            }
            
            fruit = Math.max(fruit, right - left + 1) ;
        }
        return fruit ;
    }
    public static void main(String[] args) {
        int tree[] = {1, 2, 3, 2, 2} ;
        System.out.println(khet(tree));
    }
}
