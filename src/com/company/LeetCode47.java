package com.company;

import javax.accessibility.AccessibleHyperlink;
import java.util.*;

public class LeetCode47 {

    static Set<Integer> visited = new HashSet<>();
    static List<List<Integer>> res;

    public static List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        if (nums.length == 1) {
            res.add(Arrays.asList(nums[0]));
            return res;
        }
        Arrays.sort(nums);
        component(nums, new ArrayList<>());
        return res;
    }

    private static void component(int[] nums, List<Integer> path) {

        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited.contains(i)) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !visited.contains(i - 1))
                continue;
            path.add(nums[i]);
            visited.add(i);
            component(nums, path);
            path.remove(path.size() - 1);
            visited.remove(i);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2};

        List<List<Integer>> res = permute(nums);
        for (List<Integer> list : res) {
            System.out.println(Arrays.toString(list.toArray()));
        }

    }
}
