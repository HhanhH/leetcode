package com.company;

import com.company.modle.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode111 {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        int dh = 1;
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = deque.removeFirst();
                if (cur.left == null && cur.right == null) return dh;
                if (cur.left != null) deque.addLast(cur.left);
                if (cur.right != null) deque.addLast(cur.right);
            }
            dh++;
        }
        return dh;
    }
}
