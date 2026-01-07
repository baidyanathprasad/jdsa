package com.practice.jdsa.binarytree;

/**
 * Lowest Common Ancestor in a Binary Tree
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q
 * as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 */
public class LowestCommonAncestor {

    public static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            // System.out.println("Returning Root: " + (root != null ? root.data : "null"));
            return root;
        }

        System.out.println("lcs(" + root.data + "): Traversing Left");
        TreeNode left = lowestCommonAncestor(root.left, p, q);

        System.out.println("lcs(" + root.data + "): Traversing Right");
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            // System.out.println("Lowest Common Ancestor Found at Root: " + root.data);
            return root;
        }

        // System.out.println("Returning Node: " + (left != null ? left.data : (right != null ? right.data : "null")) + " for Root: " + root.data);
        return left != null ? left : right;
    }

    public static void main(String[] args) {
        LowestCommonAncestor lcaFinder = new LowestCommonAncestor();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        TreeNode p = root.left.left; // Node with value 6
        TreeNode q = root.right.right; // Node with value 8

        TreeNode lca = lcaFinder.lowestCommonAncestor(root, p, q);
        System.out.println("Lowest Common Ancestor of " + p.data + " and " + q.data + " is: " + lca.data);
    }
}
