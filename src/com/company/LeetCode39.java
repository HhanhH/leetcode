package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LeetCode39 {

    static List<List<Integer>> res;

    private static List<List<Integer>> slo(int[] nums, int target) {
        res = new ArrayList<>();
        //将数组排序
        Arrays.sort(nums);
        buc(nums, target, new ArrayList<>(), 0);
        return res;
    }

    private static void buc(int[] nums, int remain, List<Integer> re, int start) {
        if (remain == 0) {
            res.add(new ArrayList<>(re));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            //第一个数不大于remain
            if (nums[i] > remain) {
                return;
            }
            if (i > start && nums[i] == nums[i - 1])
                continue;
            re.add(nums[i]);
            buc(nums, remain - nums[i], re, i);
            re.remove(re.size() - 1);
        }


    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> res = slo(nums, 3);
        for (List<Integer> item : res) {
            for (Integer integer : item) {
                System.out.print(integer + "  ");
            }
            System.out.println("-----------");
        }
    }

}
