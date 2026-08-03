/* 
*                                   << CONSTRUCTING BINARY TREE USING ITERATION >>
    This Java program implements a binary tree data structure and provides various methods to traverse the tree.

*   This program contains methods for ->
    Building a binary tree from an array (level order)
    Insertion
    Preorder Traversal
    Inorder Traversal   
    Postorder Traversal
    Level Order Traversal
    Height Calculation
    Size Calculation
    Leaf Count Calculation

 */
package TREES;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class BinaryTree_Implementation_Iterative {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    private Node root;                                              // Root node of the binary tree

    public BinaryTree_Implementation_Iterative() {
        root = null;                                                // Initialising root node with null
    }

    // Build tree from array like (level order)

    public void buildTree(int[] values) {
        if (values == null || values.length == 0) return;

        root = new Node(values[0]);                                 // Create the root node with the first value in the array
        Queue<Node> q = new ArrayDeque<>();                         // Create a queue to hold nodes for level order construction
        q.offer(root);

        int i = 1;
        while (!q.isEmpty() && i < values.length) {                 // Continue until all values in the array have been processed
            Node cur = q.poll();

            if (i < values.length) {                                // If there are more values/elements in the array, create a left child for the current node and add it to the queue
                cur.left = new Node(values[i++]);
                q.offer(cur.left);
            }

            if (i < values.length) {                                // If there are more values/elements in the array, create a right child for the current node and add it to the queue
                cur.right = new Node(values[i++]);
                q.offer(cur.right);
            }
        }
    }

    public void insert(int value) {                                                 // Insert one value
        if (root == null) {
            root = new Node(value);
            return;
        }

        Queue<Node> q = new ArrayDeque<>();
        q.offer(root);                                                 // Start with the root node

        while (!q.isEmpty()) {                                         // Continue until we find a place to insert the new value
            Node cur = q.poll();

            if (cur.left == null) {                                    // If the left child is null, insert the new value here
                cur.left = new Node(value);
                return;
            } 
            else {                                                      // *If the left child is not null, add it to the queue for further processing
                q.offer(cur.left);
            }

            if (cur.right == null) {                                    // If the right child is null, insert the new value here               
                cur.right = new Node(value);
                return;
            } 
            else {
                q.offer(cur.right);                                      // *If the right child is not null, add it to queue for further processing
            }
        }
    }

    // preorder traversal =  root -> left -> right

    public void preorder() {                                              // Preorder (iterative)
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }

        Deque<Node> stack = new ArrayDeque<>();                           // Create a stack to hold nodes for preorder traversal
        stack.push(root);                                                 // Start with the root node

        while (!stack.isEmpty()) {                                        // Continue until all nodes have been processed
            Node cur = stack.pop();                                       // Pop the top node from the stack and print its value
            System.out.print(cur.data + " ");

            if (cur.right != null) stack.push(cur.right);
            if (cur.left != null) stack.push(cur.left);
        }

        System.out.println();
    }

    // Inorder traversal = left -> root -> right

    public void inorder() {
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }

        Deque<Node> stack = new ArrayDeque<>();
        Node cur = root;

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {                                           // Traverse to the leftmost node of the current subtree
                stack.push(cur);                                            // Push the current node onto the stack and move to its left child
                cur = cur.left;
            }

            cur = stack.pop();                                              // Pop the top node from the stack and print its value
            System.out.print(cur.data + " ");
            cur = cur.right;                                                // Move to the right child of the popped node and repeat the process
        }

        System.out.println();
    }

    // Postorder traversal = left -> right -> root

    public void postorder() {
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }

        Deque<Node> stack = new ArrayDeque<>();
        Node cur = root, prev = null;                                   // Initialize the current node to the root and the previous node to null

        while (cur != null || !stack.isEmpty()) {                       // Continue until all nodes have been processed
            while (cur != null) {
                stack.push(cur);                                        // Push the current node onto the stack and move to its left child
                cur = cur.left;
            }

            cur = stack.peek();                                         // Peek at the top node of the stack without removing it 

            if (cur.right != null && prev != cur.right) {               // If the right child of the current node is not null and has not been processed yet, move to the right child
                cur = cur.right;
            } 
            else {                                                      // If the right child is null or has already been processed, pop the current node from the stack and print its value
                System.out.print(cur.data + " ");
                prev = stack.pop();
                cur = null;
            }
        }

        System.out.println();
    }

    // Level order traversal = level by level from top to bottom and left to right

    public void levelOrder() {
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }

        Queue<Node> q = new ArrayDeque<>();
        q.offer(root);                                                  // Start with the root node

        while (!q.isEmpty()) {
            Node cur = q.poll();                                        // Pop the front node from the queue and print its value
            System.out.print(cur.data + " ");                           

            if (cur.left != null) q.offer(cur.left);                    // If the left child is not null, add it to the queue for further processing
            if (cur.right != null) q.offer(cur.right);                  // If the right child is not null, add it to the queue for further processing
        }

        System.out.println();
    }

    // Height of tree = the number of edges in the longest path from the root to a leaf node. A tree with only one node has a height of 0.

    public int height() {
        if (root == null) return 0;

        Queue<Node> q = new ArrayDeque<>();
        q.offer(root);                                                  // Start with the root node
        int h = 0;                                                      

        while (!q.isEmpty()) {                                          // Continue until all levels of the tree have been processed
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node cur = q.poll();                              // Pop the front node from the queue and add its children to the queue for further processing

                if (cur.left != null) q.offer(cur.left);          // If the left child is not null, add it to the queue for further processing
                if (cur.right != null) q.offer(cur.right);        // If the right child is not null, add it to the queue for further processing
            }

            h++;                                                  // *Increment height after processing each level of the tree
        }

        return h;
    }

    // Size of tree = the total number of nodes in the tree

    public int size() {
        if (root == null) return 0;

        Queue<Node> q = new ArrayDeque<>();
        q.offer(root);
        int count = 0;

        while (!q.isEmpty()) {
            Node cur = q.poll();                                   // Pop the front node from the queue and increment the count of nodes in the tree
            count++;

            if (cur.left != null) q.offer(cur.left);               // If the left child is not null, add it to the queue for further processing
            if (cur.right != null) q.offer(cur.right);             // If the right child is not null, add it to the queue for further processing
        }

        return count;
    }

    // Leaf count = the number of nodes that do not have any children

    public int leafCount() {
        if (root == null) return 0;

        Queue<Node> q = new ArrayDeque<>();
        q.offer(root);
        int count = 0;

        while (!q.isEmpty()) {
            Node cur = q.poll();                                   // Pop the front node from the queue

            if (cur.left == null && cur.right == null) count++;    // *If the node is a leaf, increment the count

            if (cur.left != null) q.offer(cur.left);               // If the left child is not null, add it to the queue
            if (cur.right != null) q.offer(cur.right);             // If the right child is not null, add it to the queue
        }

        return count;
    }

    public static void main(String[] args) {
        BinaryTree_Implementation_Iterative tree = new BinaryTree_Implementation_Iterative();

        int[] values = {1, 2, 5, -1, -1, 4, 6, 5};
        tree.buildTree(values);

        System.out.println("Preorder:");
        tree.preorder();

        System.out.println("Inorder:");
        tree.inorder();

        System.out.println("Postorder:");
        tree.postorder();

        System.out.println("Level Order:");
        tree.levelOrder();

        System.out.println("Height: " + tree.height());
        System.out.println("Size: " + tree.size());
        System.out.println("Leaf Count: " + tree.leafCount());
    }
}
