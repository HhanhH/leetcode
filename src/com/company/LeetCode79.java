package com.company;

public class LeetCode79 {
    int row, col;
    //              向下    向右      向上     向左
    int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public boolean exist(char[][] board, String word) {
        row = board.length;
        col = row == 0 ? 0 : board[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean[][] visited = new boolean[row][col];
                    visited[i][j] = true;
                    if (backtrack(board, word, 0, i, j, visited))
                        return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, String word, int progress, int i, int j, boolean[][] visited) {

        if (progress == word.length() - 1) return word.charAt(progress) == board[i][j];

        if (word.charAt(progress) == board[i][j]) {
            progress++;
            for (int k = 0; k < 4; k++) {
                int newX = i + dir[k][0];
                int newY = j + dir[k][1];
                if (isInRange(newX, newY) && !visited[newX][newY] && board[newX][newY] == word.charAt(progress)) {
                    visited[newX][newY] = true;
                    if (backtrack(board, word, progress, newX, newY, visited))
                        return true;
                    visited[newX][newY] = false;
                }
            }
        }
        return false;
    }

    private boolean isInRange(int i, int j) {
        return i >= 0 && j >= 0 && i < row && j < col;
    }

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        LeetCode79 leetCode79 = new LeetCode79();
        System.out.println(leetCode79.exist(board, "ABCCED"));
    }
}
