package com.practice.jdsa.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Generate all combinations of n pairs of balanced parentheses.
 * Example:
 * Input: n = 3
 * Output:
 * "((()))"
 * "(()())"
 * "(())()"
 * "()(())"
 * "()()()"
 */
public class NParentheses {

    public static void main(String[] args) {
        int n = 3;
        generateParenthesis(n);
    }

    public static void generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        // create a basic rule parameters
        backtrack("", 0, 0, n, result);

        for (String item : result) {
            System.out.println(item);
        }
    }

    /**
     * Backtracking function to generate parentheses
     * base case: if the current string length is equal to N * 2, print the string
     * add open: if the number of open parentheses is less than N, add an open parenthesis
     * add closed: if the number of close parentheses is less than open, add a close parenthesis
     */
    private static void backtrack(String current, int open, int close, int N, List<String> result) {
        if (current.length() == N * 2) {
            result.add(current);
            return;
        }

        if (open < N) {
            backtrack(current + "(", open + 1, close, N, result);
        }
        if (close < open) {
            backtrack(current + ")", open, close + 1, N, result);
        }
    }
}
