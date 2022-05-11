package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * N皇后
 */
public class LeetCode52 {
    int N = 0;
    boolean[][] board;
    int count = 0;
    Set<Integer> col = new HashSet<>();
    Set<Integer> pie = new HashSet<>();
    Set<Integer> na = new HashSet<>();

    private int slo(int n) {
        N = n;
        board = new boolean[n][n];
        dfs(0);
        return count;
    }

    private void dfs(int level) {
        if (level == N) {
            count++;
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


    public static void main(String[] args) {
            System.out.println((new LeetCode52()).slo(4));
    }
}
