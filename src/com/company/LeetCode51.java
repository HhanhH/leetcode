package com.company;

import java.util.*;

/**
 * N皇后
 */
public class LeetCode51 {
    List<List<String>> res = new ArrayList<>();
    int N = 0;
    boolean[][] board;

    Set<Integer> col = new HashSet<>();
    Set<Integer> pie = new HashSet<>();
    Set<Integer> na = new HashSet<>();

    private List<List<String>> slo(int n) {
            N = n;
            board = new boolean[n][n];
            dfs(0);
            return res;
        }

        private void dfs(int level) {
            if (level == N) {
                res.add(genRes());
            }

            for (int i = 0; i < N; i++) {
                if (col.contains(i) || pie.contains(level + i) || na.contains(level - i)) {
                    continue;
                }
                board[level][i] = true;
                col.add(i);
                pie.add(level + i);
                na.add(level - i);
                dfs(level + 1);
                board[level][i] = false;
                col.remove(i);
                pie.remove(level + i);
                na.remove(level - i);
            }
        }

        private List<String> genRes() {
            List<String> result = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                StringBuilder bu = new StringBuilder();
                for (int j = 0; j < N; j++) {
                    bu.append(board[i][j] ? "Q" : ".");
                }
                result.add(bu.toString());
            }
            return result;
    }

    public static void main(String[] args) {
        List<List<String>> res = (new LeetCode51()).slo(4);
        for (List<String> tem : res) {
            System.out.println(tem.toString());
        }
    }
}
