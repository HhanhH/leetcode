package com.company;

import java.util.ArrayList;
import java.util.List;

public class LeetCode78 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        int len = nums.length;
        res.add(new ArrayList<>());
        for (int i = 1; i <= len; i++) {
            sub(i, new ArrayList<>(), 0, nums);
        }
        return res;

    }

    private void sub(int count, List<Integer> path, int start, int[] nums) {
        if (count == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            sub(count - 1, path, i + 1, nums);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> res = new LeetCode78().subsets(nums);
        for (List<Integer> item : res) {
            System.out.println(item.toString());
        }
    }
}
