package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode40 {

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
                break;
            }
            if (i > start && nums[i] == nums[i - 1])
                continue;
            re.add(nums[i]);
            buc(nums, remain - nums[i], re, i+1);
            re.remove(re.size() - 1);
        }


    }

    public static void main(String[] args) {
        int[] nums = {10,1,2,7,6,1,5};
        List<List<Integer>> res = slo(nums, 8);
        for (List<Integer> item : res) {
            for (Integer integer : item) {
                System.out.print(integer + "  ");
            }
            System.out.println("-----------");
        }
    }

}
