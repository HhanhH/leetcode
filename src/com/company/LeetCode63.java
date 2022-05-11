package com.company;

public class LeetCode63 {


    public int dp(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int j = 1; j < m; j++) {
            if (obstacleGrid[j][0] == 1) {
                dp[j][0] = 0;
            } else {
                dp[j][0] = dp[j - 1][0];
            }

        }
        for (int j = 1; j < n; j++) {
            if (obstacleGrid[0][j] == 1) {
                dp[0][j] = 0;
            } else {
                dp[0][j] = dp[0][j - 1];
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }

        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        LeetCode63 leetCode62 = new LeetCode63();
        int[][] nums = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println(leetCode62.dp(nums));
    }
}
