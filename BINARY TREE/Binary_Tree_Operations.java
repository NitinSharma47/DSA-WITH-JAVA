/* 

*   This program contains methods for ->
        Insertion
        Deletion
        Searching
        Minimum Value
        Maximum Value
 */

package TREES;

public class Binary_Tree_Operations {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    private Node root;

    public Binary_Tree_Operations() {
        root = null;
    }

    public boolean isEmpty() {                                                  // Check if tree is empty
        return root == null;
    }

    public boolean isFull() {                                                   // Check if tree is full
        return isFullRec(root); 
    }

    private boolean isFullRec(Node current) {                                   // Private recursive method to check if the binary tree is full
        if (current == null) {
            return true;
        }

        if ((current.left == null) ^ (current.right == null)) {
            return false;
        }

        return isFullRec(current.left) && isFullRec(current.right);
    }

    public void insert(int value) {                                             // Insert a value 
        if (root == null) {
            root = new Node(value);
            return;
        }

        insertRec(root, value);
    }

    private boolean insertRec(Node current, int value) {
        if (current.left == null) {
            current.left = new Node(value);
            return true;
        }

        if (current.right == null) {
            current.right = new Node(value);
            return true;
        }

        return insertRec(current.left, value) || insertRec(current.right, value);       // Recursively insert in left or right subtree
    }

    public boolean search(int key) {                                                 // Search a value
        return searchRec(root, key);
    }

    private boolean searchRec(Node current, int key) {
        if (current == null) {
            return false;
        }

        if (current.data == key) {
            return true;
        }

        return searchRec(current.left, key) || searchRec(current.right, key);           // *Recursively search in left or right subtree
    }

    public boolean delete(int key) {                                                // Delete a value
        deleted = false;                                                            // Reset the deleted flag before starting the deletion process
        root = deleteRec(root, key);
        return deleted;
    }

    private boolean deleted = false;                                  // Flag to indicate whether a node has been deleted during the deletion process

    private Node deleteRec(Node current, int key) {
        if (current == null) {
            return null;
        }

        if (current.data == key) {                                   // If the current node's data matches the key, mark it as deleted and return the new subtree after deletion
            deleted = true;
            return deleteNode(current);
        }

        current.left = deleteRec(current.left, key);                // Recursively search and delete in the left subtree
        current.right = deleteRec(current.right, key);              // Recursively search and delete in the right subtree
        return current;                                            
    }

    private Node deleteNode(Node node) {                            // Private method to delete a node and return the new subtree after deletion
        if (node.left == null) {                                    // If the node has no left child, return its right child (which may be null)
            return node.right;
        }

        if (node.right == null) {                                   // If the node has no right child, return its left child (which may be null)
            return node.left;
        }

        Node left = node.left;                                      // If the node has both left and right children, find the rightmost node in the left subtree and attach the right subtree to it
        Node right = node.right;                                    // Store the right subtree of the node to be deleted

        Node temp = left;   
        while (temp.right != null) {                                // Traverse to the rightmost node in the left subtree
            temp = temp.right;                                      // This node will be the new root of the subtree after deletion 
        }

        temp.right = right;                                         // Attach the right subtree to the rightmost node of the left subtree
        return left;
    }

    public int findMin() {                                          // *Minimum value   (WORKS ONLY FOR BINARY SEARCH TREE(BST) )
        if (root == null) {
            throw new IllegalStateException("Tree is empty");           // Throw an exception if the tree is empty
        }
        return findMinRec(root);
    }

    private int findMinRec(Node current) {
        if (current.left == null) {
            return current.data;                                        // If the current node has no left child, it is the minimum value in the subtree
        }
        return findMinRec(current.left);
    }

    public int findMax() {                                              // *Maximum value   (WORKS ONLY FOR BINARY SEARCH TREE(BST) )
        if (root == null) {
            throw new IllegalStateException("Tree is empty");
        }
        return findMaxRec(root);
    }

    private int findMaxRec(Node current) {
        if (current.right == null) {
            return current.data;                                        // If the current node has no right child, it is the maximum value in the subtree
        }
        return findMaxRec(current.right);
    }

    public static void main(String[] args) {
        Binary_Tree_Operations tree = new Binary_Tree_Operations();

        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);

        System.out.println("Empty? " + tree.isEmpty());
        System.out.println("Full? " + tree.isFull());

        System.out.println("Search 30: " + tree.search(30));
        System.out.println("Search 99: " + tree.search(99));

      
        System.out.println("Min: " + tree.findMin());
        System.out.println("Max: " + tree.findMax());

        System.out.println("Delete 20: " + tree.delete(20));

    }
}
