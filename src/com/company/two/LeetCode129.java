package com.company.two;

import com.company.modle.TreeNode;

public class LeetCode129 {
    static int sum = 0;

    public static int sumNumbers(TreeNode root) {
        cal(root, 0);
        return sum;
    }

    public static void cal(TreeNode root, int s1) {
        if (root.left == null && root.right == null) {
            sum += s1*10+ root.val;
            return;
        }
        s1 = s1 * 10 + root.val;
        if (root.left != null) cal(root.left, s1);
        if (root.right != null) cal(root.right, s1);
    }

    public static void main(String[] args) {
        TreeNode r1 = new TreeNode(1);
        TreeNode r2 = new TreeNode(2);
        TreeNode r3 = new TreeNode(3);
        r1.left = r2;
        r1.right = r3;
        sumNumbers(r1);
    }
}
