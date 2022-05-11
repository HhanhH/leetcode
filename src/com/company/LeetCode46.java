package com.company;

import java.util.*;

public class LeetCode46 {

    static Set<Integer> visited = new HashSet<>();
    static List<List<Integer>> res;

    public static List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        if (nums.length == 1) {
            res.add(Arrays.asList(nums[0]));
            return res;
        }
        component(nums, new ArrayList<>());
        return res;
    }

    private static void component(int[] nums, List<Integer> path) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited.contains(nums[i])) {
                continue;
            }
            path.add(nums[i]);
            visited.add(nums[i]);
            component(nums, path);
            path.remove(path.size()-1);
            visited.remove(nums[i]);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};

        List<List<Integer>> res = permute(nums);
        for (List<Integer> list: res){
            System.out.println(Arrays.toString(list.toArray()));
        }

    }
}
