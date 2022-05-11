package com.company;

import com.company.modle.TreeNode;

/**
 * 中序遍历递增
 */
public class LeetCode98 {
    static long lastVal = Long.MIN_VALUE;

    public static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) return false;
        //递增
        if (root.val < lastVal) {
            return false;
        }
        lastVal = root.val;
        return isValidBST(root.right);

    }


}
