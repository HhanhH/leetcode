package com.company;

import com.company.modle.TreeNode;

public class LeetCode97 {

    public static boolean isInterleave1(String s1, String s2, String s3) {
        if (s1.length() == 0 && s2.length() == 0 && s3.length() == 0) {
            return true;
        }
        if (s1.length() + s2.length() != s3.length())
            return false;

        return backtrace(s1, 0, s2, 0, s3, 0);
    }

    private static boolean backtrace(String s1, int start1, String s2, int start2, String s3, int start3) {

        if (start3 == s3.length()) {
            return true;
        }
        if (start1 < s1.length() && s1.charAt(start1) == s3.charAt(start3)) {
            if (backtrace(s1, start1 + 1, s2, start2, s3, start3 + 1)) return true;
        }
        if (start2 < s2.length() && s2.charAt(start2) == s3.charAt(start3)) {
            if (backtrace(s1, start1, s2, start2 + 1, s3, start3 + 1)) return true;
        }
        return false;
    }

    public static boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if (len1 + len2 != len3) {
            return false;
        }
        s1 = " " + s1;
        s2 = " " + s2;
        s3 = " " + s3;

        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        dp[0][0] = true;
        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if (i > 0 && s1.charAt(i) == s3.charAt(i + j)) {
                    dp[i][j] = dp[i - 1][j];
                }
                if (j > 0 && s2.charAt(j) == s3.charAt(i + j)) {
                    dp[i][j] =  dp[i][j]||dp[i][j - 1];
                }
            }
        }
        return dp[len1][len2];
    }

    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        System.out.println(isInterleave(s1, s2, s3));
    }
}
