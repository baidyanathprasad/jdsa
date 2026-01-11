package com.practice.jdsa.graphs;

/**
 * Same as Number of Islands but instead of counting number of islands,
 * But here goal is to find the maximum area of an island.
 * An island is surrounded by water and is formed by connecting adjacent lands
 * Mental Model:
 * Consider yourself a one cell(land) and if asked how many cells are connected:
 * Area = 1(me) + area(top) + area(bottom) + area(left) + area(right)
 */
public class MaxAreaOfIslands {

    private static int maxAreaOfIslands(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int maxArea = 0;
        int rows = grid.length;

        for (int i = 0; i < rows; i++) {
            int cols = grid[0].length;
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    int area = dfs(grid, i, j);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }

    // This is destroyer of the island so that it won't be counted again
    private static int dfs(int[][] grid, int i, int j) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Boundary checks
        if (i < 0 || j < 0 || i >= rows || j >= cols || grid[i][j] == 0) {
            return 0;
        }

        // Mark the cell as visited
        grid[i][j] = 0;

        // Calculate area recursively
        return 1 + dfs(grid, i + 1, j) // down
                + dfs(grid, i - 1, j) // up
                + dfs(grid, i, j + 1) // right
                + dfs(grid, i, j - 1); // left
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0,0,1,0,0,0,1,1,0,0,0,0,0},
                {0,0,1,0,1,1,0,1,0,1,1,0,0},
                {0,1,1,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,1,1,0,0,1,1,0,0,0},
                {1,1,0,0,0,0,0,1,0,0,0,1,1},
                {0,0,0,1,1,1,0,0,0,0,1,1,0},
                {0,1,1,1,0,0,0,1,1,1,0,0,0}
        };

        int maxArea = maxAreaOfIslands(grid);
        System.out.println("Maximum area of islands is: " + maxArea);
    }
}
