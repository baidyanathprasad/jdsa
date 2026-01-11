package com.practice.jdsa.graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * Connected Network Operations
 * Number of operations = No of Provinces - 1
 * Mental Model:
 * 1. Create a adjacency list from the given connections
 * 2. Use DFS to find number of connected components (provinces)
 * 3. Return number of operations as (provinces - 1)
 */
public class ConnectedNetworkOperations {

    private static int findNumberOfOperations(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1; // Not enough connections to connect all nodes
        }

        // Create adjacency list
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] conn : connections) {
            adjList.get(conn[0]).add(conn[1]); // add 0 -> 1
            adjList.get(conn[1]).add(conn[0]); // add 1 -> 0
        }

        boolean[] visited = new boolean[n];
        int provinces = 0;

        // DFS to find connected components
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                provinces++;
                dfs(adjList, visited, i);
            }
        }

        return provinces - 1; // Number of operations needed
    }

    private static void dfs(List<List<Integer>> adjList, boolean[] visited, int node) {
        visited[node] = true;
        for (int neighbor : adjList.get(node)) {
            if (!visited[neighbor]) {
                dfs(adjList, visited, neighbor);
            }
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] connections = {
            {0, 1},
            {0, 2},
            {1, 2}
        };

        int result = findNumberOfOperations(n, connections);
        System.out.println("Minimum number of operations to connect all nodes: " + result);
    }
}
