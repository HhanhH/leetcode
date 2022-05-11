package com.company;

public class LeetCode123 {
    public int maxProfit(int[] prices) {
        if (prices.length == 1) return 0;
        int days = prices.length;
        int k = 2;
        if (k > days / 2)
            k = days / 2;
        int[][][] dp = new int[days + 1][k + 1][2];
        for (int i = 0; i < k + 1; i++) {
            dp[0][i][0] = 0;
            dp[0][i][1] = Integer.MIN_VALUE;
        }

        int max = 0;
        for (int i = 1; i < days + 1; i++) {
            for (int nk = 1; nk < k + 1; nk++) {
                dp[i][nk][0] = Math.max(dp[i - 1][nk][0], dp[i - 1][nk][1] + prices[i - 1]);
                //买入的时候算作增加一次交易，上一天完成nk-1次交易（不持有股票）-当天价格
                dp[i][nk][1] = Math.max(dp[i - 1][nk][1], dp[i - 1][nk - 1][0] - prices[i - 1]);
                max = Math.max(max, dp[i][nk][0]);
            }
        }
        return max;

    }
}
