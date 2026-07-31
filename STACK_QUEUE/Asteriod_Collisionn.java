/*  
        Given an array of integers asteroids, where each integer represents an asteroid in a row,
        determine the state of the asteroids after all collisions. 
        In this array, the absolute value represents the size of the asteroid,and the sign represents its direction 
        (positive meaning right and negative meaning left). All asteroids move at the same speed.

        When two asteroids meet, the smaller one will explode. If they are the same size, both will explode.
        Asteroids moving in the same direction will never meet.

        &, The asteriods , who have shortest distance between them will collide first

        Example 1:
        asteroids = [2, -2]
        Output:     []
        Explanation:
                The asteroid with size 2 and the one with size -2 collide, exploding each other.

        Example 2:
        asteroids =  [10, 20, -10]
        Output:      [10, 20]
       *Explanation:
                The asteroid with size 20 and the one with size -10 collide, resulting in the remaining asteroid with size 20. 
                The asteroids with sizes 10 and 20 never collide.

        Example 3 — Negative asteroid wins
        asteroids = [10, 2, -5]
        output:     [10]
       *Explanation:
                First 2 & 5 collides...5 > 2 , so 5 wins
                then , 10 & 5 collides....10 > 5 , so 10 wins

*/
package STACK_QUEUE;
import java.util.Stack;

public class Asteriod_Collisionn {
    public static int[] explosion(int asteroid[]) {

        int n = asteroid.length;
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            int current = asteroid[i];              // storing current element

            if (st.isEmpty()) {                     // If stack is empty, simply push
                st.push(current);
                continue;
            }

            // *Collision can happen only when: stack top is moving right (+) current asteroid is moving left (-)

            while (!st.isEmpty() && st.peek() > 0 && current < 0) {                 // when peek is positive and current element is negative

                if (Math.abs(current) > st.peek()) {            // *Current asteroid is bigger , Math.abs ignores the sign (-) & compares the value
                    st.pop();
                }

                else if (Math.abs(current) == st.peek()) {              // Both asteroids have same size, then both will explode
                    st.pop();
                    current = 0;                                        // current asteroid also explodes
                    break;
                }

                else {                                      // Stack asteroid is bigger
                    current = 0;                            // current asteroid explodes
                    break;
                }
            }
            
            if (current != 0) {                             // *If current asteroid survived, push it
                st.push(current);
            }
        }

        int[] ans = new int[st.size()];                         // Convert stack to array

        for (int i = 0; i < st.size(); i++) {
            ans[i] = st.get(i);
        }

        return ans;
    }

    public static void main(String[] args) {

        int asteroid[] = {10, 2, -5};
        int ans[] = explosion(asteroid);

        for (int x : ans) {
            System.out.print(x + " ");
        }
    }
}
