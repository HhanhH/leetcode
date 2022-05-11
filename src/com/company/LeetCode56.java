package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LeetCode56 {

    public int[][] slo(int[][] intervals) {
        if (intervals.length == 1) {
            return intervals;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        List<List<Integer>> res = new ArrayList<>();
        int left = 0;
        int right = 0;


        while (right<intervals.length){
            int leftBound = intervals[left][0];
            int rightBound = intervals[right][1];
            while (right<intervals.length&&intervals[right][0]<=rightBound){
                rightBound = Math.max(rightBound,intervals[right][1]);
                right++;
            }
            res.add(Arrays.asList(leftBound,rightBound));
            left= right;
        }
        int[][] r = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            r[i][0] = res.get(i).get(0);
            r[i][1] = res.get(i).get(1);
        }
        return r;
    }

    public static void main(String[] args) {
        int[][] nums = {{1, 3}, {2, 6}, {8, 10}, {15, 16}};
        LeetCode56 leetCode56 = new LeetCode56();
        int[][] res = leetCode56.slo(nums);
        for (int[] item : res) {
            System.out.println(Arrays.toString(item));
        }
    }
}
