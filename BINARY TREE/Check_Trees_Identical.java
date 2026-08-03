/* 
    Given two Binary Trees, retur true if the two trees are identical, otherwise return false..

    Two trees are said to be identical if these three conditions are met for every pair of nodes :-

        Value of a node in the first tree is equal to the value of the corresponding node in the second tree.
        Left subtree of this node is identical to the left subtree of the corresponding node.
        Right subtree of this node is identical to the right subtree of the corresponding node.

-   The idea is to traverse both trees simultaneously, comparing the values of corresponding nodes at each step. 
    We need to ensure that the left subtree of each node in the first tree is identical to the left subtree of the corresponding node 
    in the second tree, and similarly for the right subtrees.

*   Base Case: 
    The base case for recursion is reached when both nodes are null, indicating the end of the subtree. In this case, return true.
    If only one of the nodes is null while the other is not, return false since they cannot be identical.

*   Recursive Function:
    Check if the values of the current nodes in both trees are equal. If not, return false.
    Recursively check if the left subtree of both the trees is identical.
    Recursively check if the right subtree of both the trees is identical.
    If all recursive calls return true, the trees are identical.

*/
package TREES;

public class Check_Trees_Identical {
    static class Node {                                                            // Node class represents a single node in the binary tree
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static boolean isIdentical(Node node1, Node node2) {
        
        if (node1 == null && node2 == null) {                   // BASE CASE 1 : If both nodes are NULL, they are identical
            return true;
        }

        if (node1 == null || node2 == null) {                   // BASE CASE 2 : If only one of the nodes is NULL, they are not identical
            return false;
        }

        // *Check if the current nodes have the same data value and recursively check their left and right subtrees

        return (node1.data == node2.data) && isIdentical(node1.left, node2.left) && isIdentical(node1.right, node2.right) ;
    }
    public static void main(String[] args) {
        // Creating the first binary tree (Node1)
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);

        // Creating the second binary tree (Node2)
        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);
        root2.left.left = new Node(4);

        // Check if the two binary trees are identical and output the result
        if (isIdentical(root1, root2)) {
            System.out.println("The binary trees are identical.");
        } else {
            System.out.println("The binary trees are not identical.");
        }
    }

    
}
