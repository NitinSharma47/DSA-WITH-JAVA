/* 
*                                       <<  CONSTRUCTING A BINARY TREE USING RECURSION  >>
    This Java program implements a binary tree data structure and provides various methods to manipulate and traverse the tree. 
    The binary tree is constructed using a nested Node class, which represents individual nodes in the tree. Each node contains an integer value, 
    as well as references to its left and right child nodes.

*   This code contains methods for ->

    Insertion
    Inorder Traversal 
    Preorder Traversal
    Postorder Traversal
    Level Order Traversal
    Height Calculation
    Size Calculation
    Leaf Count Calculation

 */
package TREES;

public class BinaryTree_Implementation_Recursive {

    class Node {                                                            // Node class represents a single node in the binary tree
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;                                                      // Root node of the binary tree

    public BinaryTree_Implementation_Recursive() {                                    // Constructor initializes the binary tree with an empty root
        root = null;
    }

    public void insert(int value) {                                         // Public method to insert a new value into the binary tree
        root = insertRec(root, value);
    }

    private Node insertRec(Node current, int value) {                       // Private recursive method to insert a new value into the binary tree
        if (current == null) {
            return new Node(value);
        }

        if (value < current.data) {
            current.left = insertRec(current.left, value);
        } else if (value > current.data) {
            current.right = insertRec(current.right, value);
        }

        return current;
    }

    public void preorder() {                                        
        preorderRec(root);
        System.out.println();
    }

    private void preorderRec(Node current) {                           // Private recursive method to perform preorder traversal of the binary tree
        if (current == null) {                                         // *preorder traversal visits -> root node -> left subtree -> right subtree
            return;
        }

        System.out.print(current.data + " ");
        preorderRec(current.left);
        preorderRec(current.right);
    }

    public void inorder() {
        inorderRec(root);
        System.out.println();
    }

    private void inorderRec(Node current) {                             // Private recursive method to perform inorder traversal of the binary tree
        if (current == null) {                                          //*inorder traversal visits -> left subtree -> root node -> right subtree
            return;
        }

        inorderRec(current.left);
        System.out.print(current.data + " ");
        inorderRec(current.right);
    }

    public void postorder() {
        postorderRec(root);
        System.out.println();
    }

    private void postorderRec(Node current) {                           // Private recursive method to perform postorder traversal of the binary tree
        if (current == null) {                                          // *postorder traversal visits -> left subtree -> right subtree -> root node
            return;
        }

        postorderRec(current.left);
        postorderRec(current.right);
        System.out.print(current.data + " ");
    }

    // *Level order traversal visits nodes level by level from top to bottom and left to right

    public void levelOrder() {                                         // Public method to perform level order traversal of the binary tree
        if (root == null) {                                            // If the tree is empty, return without printing anything
            return;
        }

        Node[] queue = new Node[100];                                   // Create a queue to hold nodes for level order traversal
        int front = 0;
        int rear = 0;

        queue[rear++] = root;                            // *Enqueue the root node to start the traversal , we add the elements from the rear of the queue and remove them from the front of the queue

        while (front < rear) {
            Node current = queue[front++];                              // Dequeue the front node from the queue and print its data
            System.out.print(current.data + " ");

            if (current.left != null) {                                 // If the current node has a left child, enqueue it to the queue
                queue[rear++] = current.left;
            }
            if (current.right != null) {
                queue[rear++] = current.right;
            }
        }

        System.out.println();
    }

    public int height(Node current) {                                   // Public method to calculate the height of the binary tree
        if (current == null) {
            return 0;
        }

        int leftHeight = height(current.left);
        int rightHeight = height(current.right);

    // *The height of a binary tree is defined as the number of edges on the longest path from the root node to a leaf node.

        if (leftHeight > rightHeight) {                   // If the left subtree is taller, return its height plus one for the current node
            return leftHeight + 1;
        } 
        else {                                            // If the right subtree is taller or equal, return its height plus one for the current node
            return rightHeight + 1;
        }
    }

    // *The size of a binary tree is defined as the total number of nodes present in the tree. 
    // *It can be calculated by recursively counting the nodes in the left and right subtrees and adding one for the root node.

    public int size(Node current) {                     // Public method to calculate the size of the binary tree
        if (current == null) {
            return 0;
        }

        return 1 + size(current.left) + size(current.right);
    }

    // *The leaf count of a binary tree is defined as the number of nodes that do not have any children. 
    // *Leaf nodes are the terminal nodes of the tree, and they can be counted by recursively checking if a node has no left or right child 
    // *and summing up the counts from the left and right subtrees.

    public int leafCount(Node current) {
        if (current == null) {
            return 0;
        }

        if (current.left == null && current.right == null) {
            return 1;
        }

        return leafCount(current.left) + leafCount(current.right);
    }

    public static void main(String[] args) {
        BinaryTree_Implementation_Recursive tree = new BinaryTree_Implementation_Recursive();

        int[] values = {50, 30, 20, 40, 70, 60, 80};
        for (int value : values) {
            tree.insert(value);
        }

        System.out.println("Preorder:");
        tree.preorder();

        System.out.println("Inorder:");
        tree.inorder();

        System.out.println("Postorder:");
        tree.postorder();

        System.out.println("Level Order:");
        tree.levelOrder();

        System.out.println("Height: " + tree.height(tree.root));
        System.out.println("Size: " + tree.size(tree.root));
        System.out.println("Leaf Count: " + tree.leafCount(tree.root));
    }
}
