package com.company.two;

import java.util.Arrays;

public class LeetCode132 {
    public int minCut(String s) {

        if (s.length() == 0 || s.length() == 1) return 0;

        boolean[][] valid = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            valid[i][i] = true;
        }

        for (int j = 1; j < s.length(); j++) {
            for (int i = 0; i < j; i++) {
                valid[i][j] = (s.charAt(i) == s.charAt(j) && (valid[i + 1][j - 1] || j - i < 3));
            }
        }

        int[] dp = new int[s.length()];
        Arrays.fill(dp, s.length());
        for (int i = 0; i < s.length(); i++) {
            if (valid[0][i]) {
                dp[i] = 0;
                continue;
            }
            for (int j = 0; j < i; ++j) {
                if (valid[j + 1][i])
                    dp[i] = Math.min(dp[i], dp[j] + 1);

            }
        }
        return dp[s.length() - 1];
    }

    private int slo2(String s) {
        int len = s.length();
        int[] dp = new int[len];
        Arrays.fill(dp, len);
        for (int m = 0; m < len; m++) {
            for (int d = 0; d <= 1; d++) {
                for (int i = m, j = m + d; i >= 0 && j < len && s.charAt(i) == s.charAt(j); --i, ++j)
                    dp[j] = Math.min(dp[j], i > 0 ? dp[i - 1] + 1 : 0);
            }
        }
        return dp[len - 1];
    }

    public static void main(String[] args) {
        String s = "aab";
        LeetCode132 leetCode132 = new LeetCode132();
        leetCode132.minCut(s);
    }
}
