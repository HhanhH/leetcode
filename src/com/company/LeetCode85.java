package com.company;

public class LeetCode85 {
    public static int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = 1;
                }
            }
        }

        for (int i = 1; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (dp[i][j] == 1) {
                    dp[i][j] = dp[i - 1][j] + 1;
                }
            }
        }

        int area = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (dp[i][j] == 0)
                    continue;
                int height = dp[i][j];
                for (int k = j; k >= 0&&dp[i][k]!=0; k--) {
                    int width = j - k + 1;
                    //取最小高度
                    height = Math.min(height, dp[i][k]);
                    area = Math.max(area, width * height);
                }

            }
        }
        return area;
    }

    public static void main(String[] args) {
        char[][] nums = {{'1', '0', '1', '0', '1'},
                        {'1', '0', '1', '1', '1'},
                        {'1', '1', '1', '1', '1'},
                        {'1', '0', '0', '1', '0'}};
        System.out.println( maximalRectangle(nums));
    }
}
