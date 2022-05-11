package com.company;

public class LeetCode115 {
    public int numDistinct(String s, String t) {

        int ls = s.length();
        int lt = t.length();
        if (ls == 0 || lt == 0) return ls == 0 ? 0 : 1;
        if (ls < lt) return 0;
        if (ls == lt) return s.equals(t) ? 1 : 0;

        long[][] dp = new long[ls + 1][lt + 1];
        s = ' ' + s;
        t = ' ' + t;
        for (int i = 0; i <= ls; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= ls; i++) {
            for (int j = 1; j <= lt; j++) {
                //跳过第i个字符,则为i-1中j个字符匹配的个数

                dp[i][j] = dp[i - 1][j];
                if (s.charAt(i) == t.charAt(j)) {
                    //第i个字符=第j个字符，则个数为跳过第i个字符+使用第i个字符（i-1,j-1）

                    dp[i][j] += dp[i - 1][j - 1];
                }
            }

        }
        return (int) dp[ls][lt];

    }
}
