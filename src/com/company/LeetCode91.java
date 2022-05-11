package com.company;

import java.util.HashMap;
import java.util.Map;

public class LeetCode91 {
    static Map<Integer, Integer> map = new HashMap<>();

    public static int numDecodings(String s) {
        if (s == null || s.charAt(0) == '0') return 0;
        return ways(s, 0, s.length() - 1);
    }

    public static int ways(String s, int l, int r) {
        if (l > r) {
            return 1;
        }
        if (map.containsKey(l)) {
            return map.get(l);
        }
        if (s.charAt(l) == '0') {
            return 0;
        }


        int w = ways(s, l + 1, r);
        if (l < r) {
            int pre = (s.charAt(l) - '0') * 10 + (s.charAt(l + 1) - '0');
            if (pre <= 26) {
                w += ways(s, l + 2, r);
            }
        }
        map.put(l, w);
        return w;
    }


    public static int dp(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') return 0;

        int[] dp = new int[s.length()+1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '0' && !isValid(s.charAt(i-1), s.charAt(i))) {
                return 0;
            }
            if (s.charAt(i) != '0') {
                dp[i + 1] = dp[i];
            }
            if (isValid(s.charAt(i-1), s.charAt(i ))) {
                dp[i + 1] += dp[i - 1];
            }
        }
        return dp[s.length()];
    }

    private static boolean isValid(char c1, char c2) {
        int p = (c1 - '0') * 10 + (c2 - '0');
        return p >= 10 && p <= 26;
    }

    public static void main(String[] args) {
        System.out.println(dp("10"));
    }
}
