package com.company;

import com.company.modle.TreeNode;

import java.util.Stack;

public class LeetCode99 {
    static TreeNode errorOne = null;
    static TreeNode errorTwo = null;

    public static void recoverTree(TreeNode root) {
        findError(root);
        int tmp = errorOne.val;
        errorOne.val = errorTwo.val;
        errorTwo.val = tmp;
    }

    public static void findError(TreeNode root) {
        TreeNode pre = null;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pre != null && pre.val > root.val) {
                if (errorOne == null) {
                    errorOne = pre;
                    errorTwo = root;
                } else {
                    errorTwo = root;
                    return;
                }
            }
            pre = root;
            root = root.right;
        }
    }

    public static void slo(TreeNode root) {
        TreeNode last = null;
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left == null) {
                //检查当前节点与上一个节点
                check(last, cur);
                last = cur;
                cur = cur.right;
            } else {
                //存在左孩子，找到前驱结点
                TreeNode p = cur.left;
                while (p.right != null && p.right != cur) {
                    p = p.right;
                }

                if (p.right == null) { //cur的前驱结点
                    p.right = cur; //cur作为p的right
                    cur = cur.left;
                } else {
                    p.right = null;
                    check(last, cur);
                    last = cur;
                    cur = cur.right;
                }
            }
        }

        int tmp = errorOne.val;
        errorOne.val = errorTwo.val;
        errorTwo.val = tmp;
    }

    public static void check(TreeNode last, TreeNode cur) {
        if (last != null && last.val > cur.val) {
            if (errorOne == null) {
                errorOne = last;
                errorTwo = cur;
            } else {
                errorTwo = cur;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode n3 = new TreeNode(3);
        root.left = n3;
        TreeNode n1 = new TreeNode(1);
        n3.left = n1;
        TreeNode n6 = new TreeNode(6);
        n1.right = n6;
        TreeNode n4 = new TreeNode(4);
        n3.right = n4;
        TreeNode n7 = new TreeNode(7);
        root.right = n7;
        TreeNode n2 = new TreeNode(2);
        n7.left = n2;
        TreeNode n8 = new TreeNode(8);
        n7.right = n8;
        slo(root);
    }
}
