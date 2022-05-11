package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeetCode93 {
    static List<String> res = new ArrayList<>();

    public static List<String> restoreIpAddresses(String s) {
        dfs(s, 0, 1, new ArrayList<>());
        return res;
    }

    public static void dfs(String s, int start, int seg, List<String> path) {
        if (seg > 4) {
            res.add(String.join(".", path));
            return;
        }
        int maxSize = 3;
        if (s.length()<=start)
            return;
        for (int i = 1; i <= maxSize; i++) {
            if (s.charAt(start) == '0') {
                maxSize = 1;
            }
            if (s.length() >= (start + i) && isValid(s.substring(start, start + i)) && (s.length() - (start + i)) <= (4 - seg) * 3) {
                path.add(s.substring(start, start + i));
                dfs(s, start + i, seg + 1, path);
                path.remove(path.size() - 1);
            }
        }

    }

    private static boolean isValid(String str) {
        int num = 0;
        for (char c : str.toCharArray()) {
            num = num * 10 + (c - '0');
        }
        return num <= 255;
    }

    public static void main(String[] args) {
        String s = "101023";
        System.out.println(restoreIpAddresses(s).toString());
    }

}
