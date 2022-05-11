package com.company;

import java.util.HashSet;

/**
 * 有效数独
 */
public class LeetCode36 {
    private static boolean slo(char[][] s) {
        HashSet<String> set = new HashSet<>();
        boolean[][] r = new boolean[9][9];
        boolean[][] c = new boolean[9][9];
        boolean[][] b = new boolean[9][9];
        int index;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char ss = s[i][j];
                if (ss == '.') continue;
                int box = i / 3 * 3 + j / 3;
                index = ss - '1';
                int cu = ss - '1';
                if (r[i][cu] || c[j][cu] || b[box][cu]) {
                    return false;
                }
                r[i][cu] = true;
                c[j][cu] = true;
                b[box][cu] = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] s = {{'8', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println(slo(s));
    }
}
