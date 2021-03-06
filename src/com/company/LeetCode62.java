package com.company;

public class LeetCode62 {


    public int dp(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 0;
        for (int j = 1; j < m; j++) {
            dp[j][0] = 1;
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }

        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        LeetCode62 leetCode62 = new LeetCode62();
        System.out.println(leetCode62.dp(3, 7));
    }
}
