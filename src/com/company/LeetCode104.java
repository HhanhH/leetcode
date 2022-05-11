package com.company;

import com.company.modle.TreeNode;

public class LeetCode104 {
    public static int maxDepth(TreeNode root) {
        return dpth(root);
    }

    private static int dpth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return Math.max(1 + dpth(root.left), 1 + dpth(root.right));
    }

    public static void main(String[] args) {
        TreeNode n3 = new TreeNode(3);
        TreeNode n9 = new TreeNode(9);
        TreeNode n20 = new TreeNode(20);
        TreeNode n15 = new TreeNode(15);
        TreeNode n7 = new TreeNode(7);
        n3.left = n9;
        n3.right = n20;
        n20.left = n15;
        n20.right = n7;
        System.out.println(maxDepth(n3));
    }
}
