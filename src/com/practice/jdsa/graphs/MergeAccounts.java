package com.practice.jdsa.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Account Merge
 * Same as Number of provinces but with costume changes.
 */
public class MergeAccounts {

    List<List<String>> merge(List<List<String>> accounts) {
        // create adjacency map
        Map<String, List<String>> map = new HashMap<>();
        Map<String, String> emailToNameMap = new HashMap<>(); // email to name mapping

        // initialize the adjacency map
        for (List<String> account : accounts) {
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                map.putIfAbsent(email, new ArrayList<>());
            }
        }

        // fill the adjacency map
        for (List<String> account : accounts) {
            String name = account.get(0);

            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                emailToNameMap.put(email, name);

                String firstEmail = account.get(1);
                // bidirectional connection
                map.get(email).add(firstEmail);
                map.get(firstEmail).add(email);
            }
        }

        // DFS to find connected components
        List<List<String>> result = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        for (String email : map.keySet()) {
            if (!visited.contains(email)) {
                List<String> mergedAccount = new ArrayList<>();
                dfs(map, visited, email, mergedAccount);
                // sort the emails
                mergedAccount.sort(String::compareTo);
                // add the name at the beginning
                mergedAccount.add(0, emailToNameMap.get(email));
                result.add(mergedAccount);
            }
        }
        return result;
    }

    private void dfs(Map<String, List<String>> map, Set<String> visited,
                     String email, List<String> mergedAccount) {
        visited.add(email);
        mergedAccount.add(email);

        for (String neighbor : map.get(email)) {
            if (!visited.contains(neighbor)) {
                dfs(map, visited, neighbor, mergedAccount);
            }
        }
    }

    public static void main(String[] args) {
        // Inputs
        List<List<String>> accounts = new ArrayList<>();
        accounts.add(List.of("John", "john@work.com", "john@gmail.com"));
        accounts.add(List.of("John", "john@gmail.com", "john@work1.com"));

        MergeAccounts mergeAccounts = new MergeAccounts();
        List<List<String>> mergedAccount = mergeAccounts.merge(accounts);

        // print the merged account
        for (List<String> account : mergedAccount) {
            System.out.println(account);
        }
    }
}
