/*
    Given a Binary Tree, return true if it is a Balanced Binary Tree else return false.
*   A Binary Tree is balanced if, for all nodes, the difference between the height of the left and right subtrees is not more than 1.
*/

package TREES;

public class Check_Balanced_BinaryTree {
    class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static Node root;

    public int checkHeight(Node node) {
        if (node == null) {
            return 0;
        }                                    

        int leftHeight = checkHeight(node.left);                

         if (leftHeight == -1) {                                // Left subtree is already unbalanced
            return -1;          
        }

        int rightHeight = checkHeight(node.right);

        if (rightHeight == -1) {                                // Right subtree is already unbalanced
            return -1;
        }

        if (Math.abs(leftHeight - rightHeight) > 1) {           // *If the difference in heights is greater than 1, the tree is not balanced
            return -1;                                          // Math.abs() is used to get the absolute/positive value of the difference between leftHeight and rightHeight
        }

        return Math.max(leftHeight, rightHeight) + 1;           // *Return the height of the current node
    }

    public boolean isBalanced(Node node) {
        return checkHeight(node) != -1;                         // *If the height is -1, the tree is not balanced; otherwise, it is balanced
    }
}


/* 
*           EXAMPLE ->

        Let's take this tree:

                10
                / \
               5   20
               / \
               3  7

        And focus on:
        int leftHeight = checkHeight(node.left);
        int rightHeight = checkHeight(node.right);

    1. We start here

        When you call: isBalanced(root) ->  you have: root = 10
        Then: checkHeight(10)
        Inside checkHeight(10) ->  int leftHeight = checkHeight(10.left);
        So it becomes: checkHeight(5)

    2. Now we're at node 5
        For node 5 -> int leftHeight = checkHeight(5.left);
        becomes  =  CheckHeight(3)

    3. Now we're at node 3
        Node 3 has no children:
                    3
                /   \ 
                null null

        So: checkHeight(3.left)
        becomes: checkHeight(null)
        And: We have base case -> 
            if (node == null) {
                return 0;
            }
        returns 0.
        Then the right side also returns 0.

        So at node 3     ->
        leftHeight = 0;
        rightHeight = 0;

        Then: return Math.max(0, 0) + 1;
        returns: 1
        So: checkHeight(3) → 1


    4. We return to node 5
        Remember this line? int leftHeight = checkHeight(5.left);

        It was waiting for the answer.
        Now it gets:  leftHeight = 1
        Then it executes:
        int rightHeight = checkHeight(5.right);
        which means: checkHeight(7)

        Node 7 is also a leaf.
        So: checkHeight(7) → 1

        Now node 5 has:  leftHeight  = 1 ,   rightHeight = 1

        Check:  Math.abs(1 - 1) > 1  =>  0 > 1 → false
        So it's balanced.
        Then: return Math.max(1, 1) + 1;
        returns: 2
        Therefore:  checkHeight(5) → 2


    5. We return to node 10
        Remember: int leftHeight = checkHeight(node.left);

        at node 10? It was waiting for checkHeight(5).

        Now it receives:  leftHeight = 2
        Then it executes: int rightHeight = checkHeight(10.right);

        which means: checkHeight(20)
        20 is a leaf, so:   checkHeight(20) → 1

        Now node 10 has:    leftHeight  = 2 ,   rightHeight = 1
        Check:  |2 - 1| = 1
        Balanced.

        Then:
        return Math.max(2, 1) + 1;  returns: 3

        Therefore:  checkHeight(10) → 3
        Finally: return checkHeight(node) != -1;
        becomes: return 3 != -1;

        *   which is:   true

*/