package com.company;

public class LeetCode64 {


    public int dp(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int j = 1; j < m; j++) {
            dp[j][0] = dp[j - 1][0] + grid[j][0];
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
            }

        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        LeetCode64 leetCode62 = new LeetCode64();
        int[][] nums = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(leetCode62.dp(nums));
    }
}
