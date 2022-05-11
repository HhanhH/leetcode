package com.company.two;

import java.util.*;

public class LeetCode128 {
    public static int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int n : nums) {
            if (map.containsKey(n)) continue;
            int l = map.getOrDefault(n - 1, 0);
            int r = map.getOrDefault(n + 1, 0);
            int t = l + r + 1;
            max = Math.max(max, t);
            map.put(n - l, t);
            map.put(n + r, t);
            map.put(n, t);
        }
        return max;
    }

    public static int slo(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int n : nums) {
            set.add(n);
        }
        int max = 0;
        for (int n : nums) {
            //如果n-1存在，那当前n已经计算过了
            while (!set.contains(n - 1)) {
                int l = 0;
                while (set.contains(n++)) l++;
                max = Math.max(max, l);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 0, 1};
        System.out.println(longestConsecutive(nums));
    }
}
