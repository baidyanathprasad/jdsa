package com.practice.jdsa.graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Shortest Path in a Graph is identical to the Rotten Oranges problem.
 * The differences are:
 * 1. Once the target is achieved we can stop the traversal.
 * 2. There will 8 directions(left, right, up, down + diagonals) instead of 4 directions.
 */
public class ShortestPath {

    private static int find(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return -1;
        }

        // edge cases for start and end blocked
        if(grid[0][0] == 1 || grid[grid.length - 1][grid[0].length - 1] == 1) {
            return -1; // Start or end is blocked
        }

        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0});
        grid[0][0] = 1; // mark as visited
        int[][] directions = {
                {-1, -1}, {-1, 0}, {-1, 1},
                {0, -1},          {0, 1},
                {1, -1}, {1, 0}, {1, 1}
        };
        int distance = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            distance++;
            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                int row = cell != null ? cell[0] : 0;
                int col = cell != null ? cell[1] : 0;

                // Check if we reached the target
                if (row == rows - 1 && col == cols - 1) {
                    return distance;
                }

                // Explore all 8 directions
                for (int[] dir : directions) {
                    int nr = row + dir[0];
                    int nc = col + dir[1];

                    // Check bounds and if the cell is not blocked
                    if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == 0) {
                        queue.offer(new int[] {nr, nc});
                        grid[nr][nc] = 1; // mark as visited
                    }
                }
            }
        }

        return distance;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 0},
                {1, 0, 1},
                {0, 0, 0}
        };
        int result = find(grid);
        System.out.println("Shortest path length: " + result); // Expected output: 3
    }
}
