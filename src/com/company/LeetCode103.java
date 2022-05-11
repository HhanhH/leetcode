package com.company;

import com.company.modle.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LeetCode103 {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.addLast(root);
        int layer = 1;
        while (!stack.isEmpty()) {
            int size = stack.size();
            List<Integer> path = new ArrayList<>();
            if (layer % 2 == 1) {
                for (int i = 0; i < size; i++) {
                    TreeNode p = stack.removeFirst();
                    path.add(p.val);
                    if (p.left != null) stack.addLast(p.left);
                    if (p.right != null) stack.addLast(p.right);
                }
            } else {
                for (int i = 0; i < size; i++) {
                    TreeNode p = stack.removeLast();
                    path.add(p.val);
                    if (p.right != null) stack.addFirst(p.right);
                    if (p.left != null) stack.addFirst(p.left);
                }
            }
            layer++;
            res.add(path);
        }
        return res;
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
        levelOrder(n3);
    }
}
