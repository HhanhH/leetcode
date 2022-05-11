package com.company;


import com.company.modle.TreeNode;
import sun.reflect.generics.tree.Tree;

public class LeetCode112 {

    int SUM = 0;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        SUM = targetSum;
        return has(root, 0);
    }

    public boolean has(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && root.val + sum == SUM)
            return true;
        return has(root.left, sum + root.val) || has(root.right, sum + root.val);

    }

}
