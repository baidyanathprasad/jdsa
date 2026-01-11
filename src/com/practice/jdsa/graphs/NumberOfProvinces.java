package com.practice.jdsa.graphs;

import java.util.Arrays;

/**
 * Number of Provinces: This similar to number of islands problem.
 * The differences is that we are given an adjacency matrix instead of a grid.
 * Example:
 * Consider P1, P2 and P3 are three states and the adjacency matrix is given for defining
 * relationship between them.
 * Goal: Find number of provinces (connected components)
 * Mental Model: Iterate through each row and use DFS a destroyer to mark all connected
 * states as visited. Increase the province count when a new unvisited state is found.
 */
public class NumberOfProvinces {

    private static int findProvinces(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int numProvinces = 0;
        int n = matrix.length; // No of states(Rows)
        boolean[] visited = new boolean[n];

        // Iterate through each state
        for (int i = 0; i < n; i++) {
            System.out.println("Outer Loop I: " + i);
            System.out.println("-------------------");
            if (!visited[i]) {
                numProvinces++;
                System.out.println("dfs(M: " + Arrays.deepToString(matrix) + "V: " + Arrays.toString(visited) + "I: " + i + ")");
                dfs(matrix, visited, i);
            }
        }

        return numProvinces;
    }

    private static void dfs(int[][] matrix, boolean[] visited, int i) {
        visited[i] = true;

        for (int j = 0; j < matrix[i].length; j++) {
            // System.out.println("   -----> Inner Loop J: " + j);
            if (matrix[i][j] == 1 && !visited[j]) {
                // System.out.println("     dfs(M: " + Arrays.deepToString(matrix) + "V: " + Arrays.toString(visited) + "I: " + j + ")");
                dfs(matrix, visited, j);
            } else {
                // System.out.println("     Skip J: " + j + " as M[i][j]: " + matrix[i][j] + " V[j]: " + visited[j]);
            }
        }
    }

    public static void main(String[] args) {

        // define 4 x 4 adjacency matrix
        int [][] adjacencyMatrix = {
            {1, 1, 0, 0},
            {1, 1, 0, 0},
            {0, 0, 1, 0},
            {0, 0, 0, 1}
        };

        int result = findProvinces(adjacencyMatrix);
        System.out.println("Number of Provinces: " + result); // Output: 4
    }
}
