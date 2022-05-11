package com.company.two;

import java.util.HashMap;
import java.util.Map;

public class LeetCode130 {
    int M = 0;
    int N = 0;

    public void solve(char[][] board) {
        int m = board.length;
        if (m == 0) return;
        int n = board[0].length;
        if (n <= 2) return;
        M = m;
        N = n;

        for (int y = 0; y < m; y++) {
            dfs(board, 0, y);
            dfs(board, n - 1, y);
        }

        for (int x = 0; x < n; x++) {
            dfs(board, x, 0);
            dfs(board, x, m - 1);
        }

        Map<Character, Character> map = new HashMap<>();
        map.put('G', 'O');
        map.put('O', 'X');
        map.put('X', 'X');
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = map.get(board[i][j]);
            }
        }

    }

    public void dfs(char[][] board, int x, int y) {
        if (x < 0 || x >= N || y < 0 || y >= M || board[y][x] != 'O') return;
        board[y][x] = 'G';
        dfs(board, x - 1, y);
        dfs(board, x + 1, y);
        dfs(board, x, y - 1);
        dfs(board, x, y + 1);
    }

    public static void main(String[] args) {
        char[][] board =   {{'O', 'O', 'X', 'X', 'X'},
                            {'X', 'O', 'X', 'X', 'X'},
                            {'X', 'X', 'O', 'O', 'X'},
                            {'X', 'X', 'X', 'X', 'O'},
                            {'X', 'X', 'X', 'X', 'O'}};
        LeetCode130 leetCode130 = new LeetCode130();
        leetCode130.solve(board);
    }
}
