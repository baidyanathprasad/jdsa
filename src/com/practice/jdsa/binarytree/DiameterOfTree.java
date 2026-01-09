package com.practice.jdsa.binarytree;

/**
 * Same philosophy as of Maximum Depth of Binary Tree
 * Diameter of Binary Tree
 * case1: Including me -> leftDepth + rightDepth
 * case2: Excluding me -> 1 + max(leftDiameter, rightDiameter)
 * 1 is added because we are counting edges!
 */
public class DiameterOfTree {

    int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        calculateDiameter(root);
        return maxDiameter;
    }

    public int calculateDiameter(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = calculateDiameter(root.left);
        int rightDepth = calculateDiameter(root.right);

        // case 1: Including me
        int diameterThroughRoot = leftDepth + rightDepth;
        maxDiameter = Math.max(maxDiameter, diameterThroughRoot);

        // case 2: Excluding me
        return 1 + Math.max(leftDepth, rightDepth);
    }

    public static void main(String[] args) {
        DiameterOfTree diameterFinder = new DiameterOfTree();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(5);

        int result = diameterFinder.diameterOfBinaryTree(root);
        System.out.println("Diameter of the Binary Tree: " + result); // Output: 4
    }
}
