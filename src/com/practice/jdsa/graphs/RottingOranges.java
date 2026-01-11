package com.practice.jdsa.graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * This is veery similar to the multi source bfs problem, example Burning Tree
 * The only difference is that here instead of left, right and parent there is
 * Grid and current pointer can move in 4 directions.
 */
public class RottingOranges {

    private static int findTotalTime(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshOranges = 0;

        // Find all the rotten oranges and count fresh oranges
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) {
                    queue.offer(new int[] {r, c});
                } else if (grid[r][c] == 1) {
                    freshOranges++;
                }
            }
        }

        if (freshOranges == 0) {
            return 0; // No fresh oranges to rot
        }

        int totalTime = 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // Up, Down, Left, Right
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rottenThisRound = false;

            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int r = current != null ? current[0] : 0;
                int c = current != null ? current[1] : 0;

                for (int[] dir : directions) {
                    int newRow = r + dir[0];
                    int newCol = c + dir[1];

                    // Check bounds and if the orange is fresh
                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2; // Rot the fresh orange
                        queue.offer(new int[] {newRow, newCol});
                        freshOranges--;
                        rottenThisRound = true;
                    }
                }
            }

            // Increment time only if at least one orange rotted this round
            if (rottenThisRound) {
                totalTime++;
            }
        }

        return freshOranges == 0 ? totalTime : -1; // If there are still fresh oranges, return -1
    }

    public static void main(String[] args) {
        int[][] grid = {
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 1}
        };

        int result = findTotalTime(grid);
        System.out.println("Total time to rot all oranges: " + result); // Output: 4
    }
}
