package com.company;

public class LeetCode72 {

    public static int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= len2; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                int cu = 0;
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    cu = dp[i - 1][j - 1];
                } else {
                    cu = Math.min(dp[i - 1][j - 1] + 1, Math.min(dp[i][j - 1], dp[i - 1][j]) + 1);
                }
                dp[i][j] = cu;
            }
        }
        return dp[len1][len2];
    }

    public static void main(String[] args) {
        System.out.println(minDistance("intention", "execution"));
    }
}
