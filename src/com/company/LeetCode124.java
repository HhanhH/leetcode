package com.company;

import com.company.modle.TreeNode;
import sun.reflect.generics.tree.Tree;

public class LeetCode124 {

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        postOrder(root);
        return max;
    }

    public int postOrder(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(postOrder(root.left), 0);
        int right = Math.max(postOrder(root.right), 0);
        max = Math.max(max, root.val + left + right);
        return root.val + Math.max(left, right);
    }
}
