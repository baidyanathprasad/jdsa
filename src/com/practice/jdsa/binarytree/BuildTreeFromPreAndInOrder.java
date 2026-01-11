package com.practice.jdsa.binarytree;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Build Tree from Preorder and Inorder Traversal
 * Given two arrays: preorder = arr[int] and inorder = arr[int]
 * Construct the binary tree and return its root.
 * Mental Model:
 * 1. The first element in preorder is the root of the tree.
 * 2. Find the index of this root in inorder array to separate left and right subtrees.
 * 3. Recursively apply the same logic to construct left and right subtrees.
 */
public class BuildTreeFromPreAndInOrder {

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        AtomicInteger preIndex = new AtomicInteger(0);
        return buildTreeRec(preorder, inorder, preIndex, 0, inorder.length - 1);
    }

    private static TreeNode buildTreeRec(int[] preorder, int[] inorder, AtomicInteger preIndex, int left, int right) {
        if (left > right) {
            return null; // No nodes to construct
        }

        // The first element in preorder is the root
        int rootValue = preorder[preIndex.get()];
        TreeNode root = new TreeNode(rootValue);
        preIndex.incrementAndGet();

        // Find the index of the root in inorder
        int inIndex = search(inorder, left, right, rootValue);

        // Construct left and right subtrees
        root.left = buildTreeRec(preorder, inorder, preIndex, left, inIndex - 1);
        root.right = buildTreeRec(preorder, inorder, preIndex, inIndex + 1, right);

        return root;
    }

    private static int search(int[] arr, int start, int end, int value) {
        for (int i = start; i <= end; i++) {
            if (arr[i] == value) {
                return i;
            }
        }

        return -1; // Value not found
    }

    private static void printTree(TreeNode root) {
        if (root == null) return;
        System.out.println(root.data + " ");
        if (root.left != null) printTree(root.left);
        if (root.right != null) printTree(root.right);
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        TreeNode root = buildTree(preorder, inorder);
        printTree(root);
    }
}
