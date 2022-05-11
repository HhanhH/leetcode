package com.company;

import com.company.modle.TreeNode;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class LeetCode105 {

    Map<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) return null;
        if (preorder.length == 1) return new TreeNode(preorder[0]);
        int len = inorder.length;

        for (int i = 0; i < len; i++) {
            inorderMap.put(inorder[i], i);
        }

        return buildTreeee(preorder, 0, len - 1, inorder, 0, len - 1);

    }

    private TreeNode buildTreeee(int[] preOrder, int s1, int e1, int[] inorder, int s2, int e2) {
        if (s1 > e1 || s2 > e2) return null;
        int k = inorderMap.get(preOrder[s1]) - s2;
        TreeNode root = new TreeNode(preOrder[s1]);
        root.left = buildTreeee(preOrder, s1 + 1, s1 + k, inorder, s2, s2 + k - 1);
        root.right = buildTreeee(preOrder, s1 + k + 1, e1, inorder, s2 + k + 1, e2);
        return root;
    }
}
