package com.practice.jdsa.backtracking;

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
        backtrack("", 0, 0, n); // create a basic rule parameters
    }

    /**
     * Backtracking function to generate parentheses
     * base case: if the current string length is equal to N * 2, print the string
     * add open: if the number of open parentheses is less than N, add an open parenthesis
     * add closed: if the number of close parentheses is less than open, add a close parenthesis
     */
    private static void backtrack(String current, int open, int close, int N) {
        if (current.length() == N * 2) {
            System.out.println(current);
            return;
        }

        if (open < N) {
            backtrack(current + "(", open + 1, close, N);
        }
        if (close < open) {
            backtrack(current + ")", open, close + 1, N);
        }
    }
}
