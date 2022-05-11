package com.company;

import com.company.modle.TreeNode;

import java.util.*;

public class LeetCode107 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Deque<TreeNode>  deque = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        deque.addLast(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> path = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode p = deque.removeFirst();
                path.add(p.val);
                if (p.left != null) deque.addLast(p.left);
                if (p.right != null) deque.addLast(p.right);
            }
            res.add(path);
        }
        Collections.reverse(res);
        return res;
    }
}
