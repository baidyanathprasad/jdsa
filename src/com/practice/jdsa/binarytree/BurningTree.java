package com.practice.jdsa.binarytree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * A classical problem for a Binary Tree when a given node is given and find out amount
 * of time required to burn the full tree.
 * For any node there are three connected node can be burned simultaneously in a single
 * unit of time.
 * A hack: This mix of the Graph problem as you are not given the parent pointer in the
 * Binary tree. So, you need to create a mapping of child to parent first using DFS or BFS.
 */
public class BurningTree {

    // Helper function to find the given node and create a parent map<TreeNode, TreeNode>
    // Key: Child Node, Value: Parent Node
    private static TreeNode findGivenNodeAndCreateParentMap(TreeNode root, int data, Map<TreeNode, TreeNode> map) {
        if (root == null) {
            return null;
        }

        // save the result if found
        TreeNode result = null;
        if (root.data == data) {
            result = root;
        }

        // Left Subtree
        if (root.left != null) {
            map.put(root.left, root);
            TreeNode left = findGivenNodeAndCreateParentMap(root.left, data, map);
            if (left != null) {
                result = left;
            }
        }

        // Right Subtree
        if (root.right != null) {
            map.put(root.right, root);
            TreeNode right = findGivenNodeAndCreateParentMap(root.right, data, map);
            if (right != null) {
                result = right;
            }
        }

        return result;
    }

    private static int burnTree(TreeNode root, int target) {
        if (root == null) {
            return 0;
        }

        // Create a map to store parent pointers
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        TreeNode targetNode = findGivenNodeAndCreateParentMap(root, target, parentMap);

        if (targetNode == null) {
            System.out.println("Target Node not found in the tree");
            return -1;
        } else {
            System.out.println("Target Node found: " + targetNode.data);
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(targetNode);
        int burningTime = 0;
        Set<TreeNode> visited = new HashSet<>();
        visited.add(targetNode);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            boolean newLevelFound = false;

            System.out.println("Current Level Size " + levelSize);

            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();

                // Add left child
                if (current != null && current.left != null && !visited.contains(current.left)) {
                    queue.add(current.left);
                    visited.add(current.left);
                    newLevelFound = true;
                }

                // Add right child
                if (current != null && current.right != null && !visited.contains(current.right)) {
                    queue.add(current.right);
                    visited.add(current.right);
                    newLevelFound = true;
                }

                // Add parent
                if (parentMap.containsKey(current) && !visited.contains(parentMap.get(current))) {
                    queue.add(parentMap.get(current));
                    visited.add(parentMap.get(current));
                    parentMap.remove(current);
                    newLevelFound = true;
                }
            }

            if (newLevelFound) {
                burningTime++;
            }
        }

        return burningTime;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);

        int target = 5;
        int timeToBurn = burnTree(root, target);
        System.out.println("Time required to burn the tree from node " + target + " is: " + timeToBurn);
    }
}
