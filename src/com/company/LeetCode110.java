package com.company;

import com.company.modle.TreeNode;

public class LeetCode110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int res = getDepth(root);
        if (res == -1) return false;
        return true;
    }

    /**
     * 后序遍历
     *
     * @param root
     * @return -1表示不平衡
     * 其他表示树的高度
     */
    private int getDepth(TreeNode root) {
        if (root == null) return 0;
        int left = getDepth(root.left);
        if (left == -1) return -1;
        int right = getDepth(root.right);
        if (right == -1) return -1;
        if (Math.abs(left - right) > 1) return -1;
        return Math.max(left, right) + 1;

    }
}
