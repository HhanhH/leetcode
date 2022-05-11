package com.company;

import java.util.*;

public class LeetCode90 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        res.add(new ArrayList<>());
        dfs(0, nums);
        return res;

    }

    private void dfs(int start, int[] nums) {
        if (start > nums.length - 1) {
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;
            path.add(nums[i]);
            res.add(new ArrayList<>(path));
            dfs(i + 1, nums);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        LeetCode90 leetCode90 = new LeetCode90();
        int[] nums = {1, 2, 2};
        List<List<Integer>> res = leetCode90.subsets(nums);
        for (List<Integer> item : res) {
            System.out.println(item.toString());
        }
    }
}
