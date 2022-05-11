package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LeetCode57 {

    public int[][] slo(int[][] intervals, int[] newInsert) {
        if (intervals.length == 0) {
            int[][] res = new int[1][2];
            res[0][0] = newInsert[0];
            res[0][1] = newInsert[1];
            return res;
        }


        List<List<Integer>> res = new ArrayList<>();
        int left = 0;
        int right = 0;

        int newLeft = newInsert[0];
        int newRight = newInsert[1];

        while (left < intervals.length && intervals[left][1] < newLeft) {
            res.add(Arrays.asList(intervals[left][0], intervals[left][1]));
            left++;
        }
        if (left == intervals.length) {
            res.add(Arrays.asList(newLeft, newRight));
        } else {
            int leftBound = Math.min(intervals[left][0], newLeft);
            while (left < intervals.length && intervals[left][1] <= newRight) {
                left++;
            }
            int rightBound = newRight;

            if (left<intervals.length&&intervals[left][0] <= newRight) {
                rightBound = intervals[left][1];
                left++;
            }
            res.add(Arrays.asList(leftBound, rightBound));

            while (left < intervals.length) {
                res.add(Arrays.asList(intervals[left][0], intervals[left][1]));
                left++;
            }
        }

        int[][] r = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            r[i][0] = res.get(i).get(0);
            r[i][1] = res.get(i).get(1);
        }
        return r;
    }

    public static void main(String[] args) {
        int[][] nums = {{1, 5}};
//                {{2, 3}, {4, 6}, {8, 10}, {15, 16}};
        int[] insert = {2, 7};
        LeetCode57 leetCode56 = new LeetCode57();
        int[][] res = leetCode56.slo(nums, insert);
        for (int[] item : res) {
            System.out.println(Arrays.toString(item));
        }

    }
}
