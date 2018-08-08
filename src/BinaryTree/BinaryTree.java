package BinaryTree;

// https://en.wikipedia.org/wiki/Binary_search_tree
// http://cslibrary.stanford.edu/110/BinaryTrees.html#java

public class BinaryTree {

    // Root node pointer. Will be null for an empty tree.
    private Node root;

    /**
     * --Node-- The binary tree is built using this nested node class. Each node
     * stores one data element, and has left and right sub-tree pointer which may be
     * null. The node is a "dumb" nested class -- we just use it for storage; it
     * does not have any methods.
     */
    private static class Node {
        Node left;
        Node right;
        int data;

        Node(int newData) {
            left = null;
            right = null;
            data = newData;
        }
    }

    /**
     * Creates an empty binary tree -- a null root pointer.
     */
    public void BinaryTree() {
        root = null;
    }

    /**
     * Returns true if the given target is in the binary tree. Uses a recursive
     * helper.
     */
    public boolean lookup(int data) {
        return (lookup(root, data));
    }

    /**
     * Recursive lookup -- given a node, recur down searching for the given data.
     */
    private boolean lookup(Node node, int data) {
        if (node == null) {
            return (false);
        }

        if (data == node.data) {
            return (true);
        } else if (data < node.data) {
            return (lookup(node.left, data));
        } else {
            return (lookup(node.right, data));
        }
    }

    /**
     * Inserts the given data into the binary tree. Uses a recursive helper.
     */
    public void insert(int data) {
        root = insert(root, data);
    }

    /**
     * Recursive insert -- given a node pointer, recur down and insert the given
     * data into the tree. Returns the new node pointer (the standard way to
     * communicate a changed pointer back to the caller).
     */
    private Node insert(Node node, int data) {
        if (node == null) {
            node = new Node(data);
        } else {
            if (data <= node.data) {
                node.left = insert(node.left, data);
            } else {
                node.right = insert(node.right, data);
            }
        }

        return (node); // in any case, return the new pointer to the caller
    }

    /**
     * Returns the size of the binary tree using recursion
     */

    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        } else {
            return (size(node.left) + 1 + size(node.right));
        }
    }

    /**
     * Prints the node values in the "inorder" order. Uses a recursive helper to do
     * the traversal.
     */
    public void printTree() {
        printTree(root);
        System.out.println();
    }

    private void printTree(Node node) {
        if (node == null)
            return;

        // left, node itself, right
        printTree(node.left);
        System.out.print(node.data + " ");
        printTree(node.right);
    }

    /**
     * Deletes specified int value -- and all of its children. Uses recursive helper
     */
    public void delete(int data) {
        delete(root, data);
    }

    private Node delete(Node node, int data) {
        // if (node.data == data) {
        // node = null;
        // return node;
        // }

        if (node.left.data == data) {
            node.left = null;
            return node;
        }
        if (node.right.data == data) {
            node.right = null;
            return node;
        }

        // Go from left to right
        if (data < node.left.data) {
            return delete(node.left, data);
        } else if (data > node.left.data) {
            return delete(node.right, data);
        } else if (data < node.right.data) {
            return delete(node.left, data);
        } else if (data > node.right.data) {
            return delete(node.right, data);
        } else {
            return node;
        }
    }

    public void convert(int from, int to) {
        convert(root, from, to);

    }

    public Node convert(Node node, int from, int to) {

        if (node.data == from) {
            node.data = to;
        } else if (from > node.data) {
            return convert(node.right, from, to);
        } else {
            return convert(node.left, from, to);
        }
        return node;
    }

    /**
     * Prints the binary tree from top to bottom, left to right
     */
    public void traverse() {
        traverse(root);
    }

    public void traverse(Node node) {
        if(node == null)
            return;

        System.out.println(node.data);
        traverse(node.left);
        traverse(node.right);
    }

    /**
     * Returns the max root-to-leaf depth of the tree. Uses a recursive helper that
     * recurs down to find the max depth.
     */
    public int maxDepth() {
        return (maxDepth(root));
    }

    private int maxDepth(Node node) {
        if (node == null) {
            return (0);
        } else {
            final int lDepth = maxDepth(node.left);
            final int rDepth = maxDepth(node.right);

            // use the larger + 1
            return (Math.max(lDepth, rDepth) + 1);
        }
    }

    /**
     * Returns the min value in a non-empty binary search tree. Uses a helper method
     * that iterates to the left to find the min value.
     */
    public int minValue() {
        return (minValue(root));
    }

    /**
     * Finds the min value in a non-empty binary search tree.
     */
    private int minValue(Node node) {
        Node current = node;
        while (current.left != null) {
            current = current.left;
        }

        return (current.data);
    }


    /**
     * Returns the max value in a non-empty binary search tree. Uses a helper method
     * that iterates to the left to find the max value.
     */
    public int maxValue() {
        return (maxValue(root));
    }

    /**
     * Finds the max value in a non-empty binary search tree.
     */
    private int maxValue(Node node) {
        Node current = node;
        while (current.right != null) {
            current = current.right;
        }

        return (current.data);
    }

    /**
     * Tests if a tree meets the conditions to be a binary search tree (BST).
     */
    public boolean isBST() {
        return (isBST(root));
    }

    /**
     * Recursive helper -- checks if a tree is a BST using minValue() and maxValue()
     * (not efficient).
     */
    private boolean isBST(Node node) {
        if (node == null)
            return (true);

        // do the subtrees contain values that do not
        // agree with the node?
        if (node.left != null && maxValue(node.left) > node.data)
            return (false);
        if (node.right != null && minValue(node.right) <= node.data)
            return (false);

        // check that the subtrees themselves are ok
        return (isBST(node.left) && isBST(node.right));
    }

}
