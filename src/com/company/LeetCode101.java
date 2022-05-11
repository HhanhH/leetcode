package com.company;

import com.company.modle.TreeNode;

public class LeetCode101 {
    public boolean isSymmetric(TreeNode root) {
        return check(root.left, root.right);
    }

    public boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null) return false;
        if (q == null) return false;
        if (p.val == q.val) {
            return check(p.left, q.right) && check(p.right, q.left);
        }
        return false;
    }


}
