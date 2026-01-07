package com.practice.jdsa.binarytree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Maximum Width of Binary Tree
 * Given a binary tree, write a function to get the maximum width of the given tree.
 * The width of a tree is the maximum width among all levels. The binary tree has the
 * same structure as a full binary tree, but some nodes are null.
 * The width of one level is defined as the length between the end-nodes
 * (the leftmost and rightmost non-null nodes in the level, where the null nodes
 * between the end-nodes are also counted into the length calculation.
 */
public class MaximumWidth {

    public static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    public static class Pair<U, V> {
        public U first;
        public V second;

        public Pair(U first, V second) {
            this.first = first;
            this.second = second;
        }

        public U getFirst() {
            return first;
        }

        public V getSecond() {
            return second;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int maxWidth = 0;
        Deque<Pair<TreeNode, Integer>> deque = new ArrayDeque<>();
        deque.offer(new Pair<>(root, 1));

        while (!deque.isEmpty()) {
            int levelSize = deque.size();
            int leftIndex = deque.getFirst().second;
            int rightIndex = deque.getLast().second;

            for (int i = 0; i < levelSize; i++) {
                int currentIndex = deque.getFirst().second;
                TreeNode currentNode = deque.getFirst().first;
                deque.pollFirst();
                if (currentNode.left != null) {
                    deque.offerLast(new Pair<>(currentNode.left, currentIndex * 2));
                }
                if (currentNode.right != null) {
                    deque.offerLast(new Pair<>(currentNode.right, currentIndex * 2 + 1));
                }
            }

            maxWidth = Math.max(maxWidth, rightIndex - leftIndex + 1);
        }

        return maxWidth;
    }

    public static void main(String[] args) {
        MaximumWidth maxWidthFinder = new MaximumWidth();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);

        int maxWidth = maxWidthFinder.widthOfBinaryTree(root);
        System.out.println("Maximum Width of the Binary Tree is: " + maxWidth);
    }
}
