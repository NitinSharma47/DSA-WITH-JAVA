/* 
                Given the root of a Binary Tree, return the height of the tree. 
                The height of the tree is equal to the number of nodes on the longest path from root to a leaf.
*/

package TREES ;

public class Maximum_Depth_Of_BinaryTree {
    class Node{
        int data ;
        Node left ;
        Node right ;

        Node(int data , Node left , Node right){
            this.data = data ;
            this.left = null ;
            this.right=  null ;
        }
    }
    public static Node root ;

    public static int height (Node current ){
        if(root == null){
            return 0 ;
        }
        int leftnode = height(current.left) ;
        int rightNode = height(current.right) ;

        return 1 +  Math.max(leftnode, rightNode)  ;
    }
}
