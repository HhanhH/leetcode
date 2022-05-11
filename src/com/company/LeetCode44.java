package com.company;

public class LeetCode44 {
    private static boolean isMatch(String s, String p) {
        int l1 = s.length();
        int l2 = p.length();

        if (l2 == 0) {
            return l1 == 0;
        }

        boolean dp[][] = new boolean[l1 + 1][l2 + 1];
        for (int i = l1; i >= 0; i--) {
            for (int j = l2; j >= 0; j--) {
                if (i == l1 && j == l2) {
                    dp[l1][l2] = true;
                    continue;
                }

                boolean firstMatch = i != l1 && j != l2 && (
                        s.charAt(i) == p.charAt(j) || p.charAt(j) == '?' || p.charAt(j) == '*');

                if (j != l2 && p.charAt(j) == '*') {
                    //*匹配""(i,j+1) || *匹配多个 （i+1,j）
                    dp[i][j] = dp[i][j + 1] || (firstMatch && dp[i + 1][j]);
                } else {
                    dp[i][j] = firstMatch && dp[i + 1][j + 1];
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        System.out.println(isMatch("aa", "a"));
        System.out.println(isMatch("aa", "*"));

        System.out.println(isMatch("cb", "?a"));
        System.out.println(isMatch("adceb", "*a*b"));
        System.out.println(isMatch("acdcb", "a*c?b"));


    }
}

