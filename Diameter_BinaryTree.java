/*     
    Given the root of the Binary Tree, return the length of its diameter. 
    The Diameter of a Binary Tree is the longest distance between any two nodes of that tree. 
    This path may or may not pass through the root. 

*   Example ->

             1
            / \
           2   3
          / \
         4   5

        The longest path is:  4 → 2 → 1 → 3
        There are 3 edges in this path.

*   The key observation
        At every node, a path can pass through that node like this:

            node
            /  \
            /    \
        left      right

        The longest path passing through this node is:  left subtree height + right subtree height

        So if:  leftHeight = 2 ,  rightHeight = 3
        then the path through this node has:  2 + 3 = 5 edges
        We check this at every node and keep the maximum.

?       Why height is needed ?
        To calculate diameter, we need the height of the left and right subtrees.
*       So our recursion does two things :
            i) Calculate height
            ii) Update the maximum diameter
*/
package TREES;

public class Diameter_BinaryTree {
    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static int diameter = 0;                        // Stores the maximum diameter found

    public static int height(Node node){
        if(node == null){
            return 0 ;
        }

        int leftTreeHeight = height(node.left) ;
        int rightTreeHeight = height(node.right) ;

        diameter = Math.max(diameter, leftTreeHeight + rightTreeHeight) ;       //* Maximize diameter with every calculation
    
        return Math.max(leftTreeHeight, rightTreeHeight) + 1;                   // Return height to parent Node
    }
    public static void main(String[] args) {

        Diameter_BinaryTree tree = new Diameter_BinaryTree();
        Node root = tree.new Node(1);

        root.left = tree.new Node(2);
        root.right = tree.new Node(3);

        root.left.left = tree.new Node(4);
        root.left.right = tree.new Node(5);

        // Calculate height and diameter
        height(root);
        System.out.println("Diameter of Binary Tree = " + diameter);
    
    }
    
}
