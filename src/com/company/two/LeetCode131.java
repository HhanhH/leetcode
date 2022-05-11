package com.company.two;

import java.util.ArrayList;
import java.util.List;

public class LeetCode131 {
    List<List<String>> res = new ArrayList<>();
    boolean[][] dp;

    public List<List<String>> partition(String s) {

        if (s.length() == 0)
            return res;

        dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++)
            dp[i][i] = true;
        for (int j = 1; j < s.length(); j++) {
            for (int i = 0; i < j; i++) {
                dp[i][j] = (s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]));
            }
        }

        backTrack(s, 0, new ArrayList<>());
        return res;

    }

    private void backTrack(String s, int start, ArrayList<String> path) {
        if (start == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (dp[start][i]) {
                path.add(s.substring(start, i + 1));
                backTrack(s, i + 1, path);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPartition(String ss) {
        int l = 0;
        int r = ss.length() - 1;
        while (l < r) {
            if (ss.charAt(l) != ss.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }
}
