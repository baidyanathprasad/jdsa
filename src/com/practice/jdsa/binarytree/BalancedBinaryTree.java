package com.practice.jdsa.binarytree;

/**
 * Balanced Binary Tree is a binary tree in which the depth of the two
 * subtrees of every node never differs by more than one.
 * Use the same approach as Maximum Depth of Binary Tree
 * but return -1 if the tree is unbalanced at any node.
 * Consider this as virus to remember.
 */
public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        return checkBalance(root) != -1;
    }

    private int checkBalance(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftDepth = checkBalance(node.left);
        if (leftDepth == -1) {
            return -1; // left subtree is unbalanced
        }

        int rightDepth = checkBalance(node.right);
        if (rightDepth == -1) {
            return -1; // right subtree is unbalanced
        }

        if (Math.abs(leftDepth - rightDepth) > 1) {
            return -1; // current node is unbalanced
        }

        return 1 + Math.max(leftDepth, rightDepth); // return the depth
    }

    public static void main(String[] args) {
        BalancedBinaryTree balancedTreeChecker = new BalancedBinaryTree();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(6);

        boolean result = balancedTreeChecker.isBalanced(root);
        System.out.println("Is the Binary Tree Balanced? " + result); // Output: false
    }
}
