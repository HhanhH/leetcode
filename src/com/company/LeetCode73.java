package com.company;

public class LeetCode73 {

    public static void setZeroes(int[][] matrix) {
        int l1 = matrix.length;
        int l2 = matrix[0].length;

        boolean r_z = false;
        boolean c_z = false;
        for (int i = 0; i < l1; i++) {
            if (matrix[i][0] == 0)
                c_z = true;
        }
        for (int i = 0; i < l1; i++) {
            if (matrix[0][i] == 0)
                r_z = true;
        }

        for (int i = 1; i < l1; i++) {
            for (int j = 1; j < l2; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 0; i < l1; i++) {
            for (int j = 0; j < l2; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0)
                    matrix[i][j] = 0;
            }
        }

        if (r_z) {
            for (int c = 0; c < l2; c++) {
                matrix[0][c] = 0;
            }
        }
        if (c_z) {
            for (int c = 0; c < l2; c++) {
                matrix[c][0] = 0;
            }
        }
    }
}
