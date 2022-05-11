package com.company;


import com.company.modle.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode113 {

    int SUM = 0;

    List<List<Integer>> res = null;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) return new ArrayList<>();
        SUM = targetSum;
        res = new ArrayList<>();
        has(root, 0, new ArrayList<>());
        return res;
    }

    public void has(TreeNode root, int sum, List<Integer> path) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null && root.val + sum == SUM) {
            path.add(root.val);
            res.add(new ArrayList<>(path));
            path.remove(path.size()-1);
            return;
        }
        path.add(root.val);
        has(root.left, sum + root.val, path);
        has(root.right, sum + root.val, path);
        path.remove(path.size()-1);
    }

}
