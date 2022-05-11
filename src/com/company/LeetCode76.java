package com.company;

import java.util.HashMap;
import java.util.Map;

public class LeetCode76 {
    public static String minWindow(String s, String t) {

        Map<Character, Integer> charMap = new HashMap<>();
        int missingCount = 0;
        for (Character c : t.toCharArray()) {
            Integer count = charMap.get(c);
            if (charMap.get(c) == null) {
                count = 0;
                missingCount++;
            }
            charMap.put(c, ++count);
        }

        int left = 0;
        int right = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;


        for (; right < s.length(); right++) {
            char cur = s.charAt(right);
            if (charMap.get(cur) != null) {
                int count = (charMap.get(cur).intValue()) - 1;
                charMap.put(cur, count);
                if (count == 0) {
                    missingCount--;
                }
            }
            while (missingCount == 0) {
                int len = right - left + 1;
                if (len < minLen) {
                    minLen = len;
                    start = left;
                }
                char lc = s.charAt(left);
                if (charMap.get(lc) != null) {

                    charMap.put(lc, charMap.get(lc) + 1);
                    if (charMap.get(lc) > 0) {
                        missingCount++;
                    }
                }

                left++;
            }

        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "H"));
    }
}
