package com.practice.jdsa.binarytree;

/**
 * Philosophy:
 * Consider yourself as a node so you have two choices
 * 1. You can extend the path to your parent node [ you + max(leftPathSum, rightPathSum) ]
 * 2. You can choose to not extend the path to your parent node [ leftPathSum + rightPathSum + you ]
 * only for updating the global maximum path sum
 */
public class MaximumPathSum {
    int[] maxSum = new int[]{ Integer.MIN_VALUE };

    // Function to calculate the maximum path sum
    public int calculateMaxPathSum(TreeNode root) {
        maxPathSum(root);
        return maxSum[0];
    }

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = Math.max(0, maxPathSum(root.left)); // handle the negative path sums
        int right = Math.max(0, maxPathSum(root.right)); // handle the negative path sums

        // update the global maximum path sum
        maxSum[0] = Math.max(maxSum[0], left + right + root.data);

        return Math.max(left, right) + root.data;
    }

    public static void main(String[] args) {
        MaximumPathSum maxPathSumFinder = new MaximumPathSum();

        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int result = maxPathSumFinder.calculateMaxPathSum(root);
        System.out.println("Maximum Path Sum: " + result); // Output: 42
    }
}
