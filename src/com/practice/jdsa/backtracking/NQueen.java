package com.practice.jdsa.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * N-Queen Problem
 * The N-Queen problem is a classic backtracking problem where the goal is to place N queens on an N x N chessboard
 * such that no two queens threaten each other.
 * This means that no two queens can be placed in the same row, column, or diagonal.
 */
public class NQueen {
    public static void main(String[] args) {
        int n = 4; // Size of the chessboard and number of queens
        char[][] board = new char[n][n]; // define board
        int row = 0;
        List<List<Character>> result = new ArrayList<>();

        solveNQueens(board, row, n, result);
        printOutput(result, n);
    }

    public static void solveNQueens(char[][] board, int row, int n, List<List<Character>> result) {
        // base case: if all queens are placed
        if (row == n) {
            List<Character> currentSolution = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    currentSolution.add(board[i][j]);
                }
                result.add(currentSolution);
                currentSolution = new ArrayList<>();
            }
            return;
        }

        // place queen in each column of the current row
        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col, n)) {
                board[row][col] = 'Q'; // Place queen
                solveNQueens(board, row + 1, n, result);
                board[row][col] = '.'; // Backtrack
            }
        }
    }

    public static boolean isSafe(char[][] board, int row, int col, int n) {
        // check horizontal
        for (int j = 0; j < col; j++) {
            if (board[row][j] == 'Q') {
                return false;
            }
        }

        // check vertical
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // check upper left diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // check upper right diagonal
        for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public static void convertAndAddSolution(char[][] board, int n, List<List<Character>> result) {
        List<Character> currentSolution = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                currentSolution.add(board[i][j]);
            }
            currentSolution = new ArrayList<>();
        }

        result.add(currentSolution);
    }

    public static void printOutput(List<List<Character>> result, int n) {
        int row = 0;
        for (List<Character> solution : result) {
            for (Character character : solution) {
                if (character == 'Q') {
                    System.out.print(character + " ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
            row++;

            if (n == row) {
                System.out.println();
                row = 0;
            }
        }
    }
}
