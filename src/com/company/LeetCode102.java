package com.company;

import com.company.modle.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LeetCode102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root==null){
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.addLast(root);
        while (!stack.isEmpty()) {
            int size = stack.size();
            List<Integer> path = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode p = stack.removeFirst();
                path.add(p.val);
                if (p.left != null) stack.addLast(p.left);
                if (p.right != null) stack.addLast(p.right);
            }
            res.add(path);
        }
        return res;
    }
}
