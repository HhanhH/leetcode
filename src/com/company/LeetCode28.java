package com.company;

import java.util.Arrays;

public class LeetCode28 {
    private static int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0)
            return 0;
        int[] next = getNextTable(needle);
        int j = 0;
        int i = 0;
        while (i < haystack.length()) {

            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                if (j - 1 < 0) {
                    i++;
                    continue;
                }
                j = next[j - 1];
            }
            if (j == needle.length()) {
                return i - j;
            }
        }
        return -1;
    }

    private static int[] getNextTable(String needle) {
        int[] next = new int[needle.length()];
        next[0] = 0;
        int j = 0;
        int i = 1;
        while (i < needle.length()) {
            if (needle.charAt(j) == needle.charAt(i)) {
                next[i++] = ++j;
            } else {
                if (j == 0) {
                    next[i++] = j;
                    continue;
                } else {
                    j = next[j-1];
                }
            }
        }
        return next;
    }

    public static void main(String[] args) {
        String needle = "a";
        String bu = "a";
        int index = strStr(needle, bu);
        System.out.println("index = " + index);
        int[] next = getNextTable(needle);
        System.out.println(Arrays.toString(next));
    }
}
