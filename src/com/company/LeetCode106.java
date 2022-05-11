package com.company;

import com.company.modle.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode106 {

    Map<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        if (inorder == null || inorder.length == 0) return null;
        if (inorder.length == 1) return new TreeNode(inorder[0]);
        int len = inorder.length;

        for (int i = 0; i < len; i++) {
            inorderMap.put(inorder[i], i);
        }

        return buildTreeee(postorder, 0, len - 1, inorder, 0, len - 1);

    }

    private TreeNode buildTreeee(int[] postorder, int s1, int e1, int[] inorder, int s2, int e2) {
        if (s1 > e1 || s2 > e2) return null;
        int k = e2 - inorderMap.get(postorder[e1]);
        TreeNode root = new TreeNode(postorder[e1]);
        root.left = buildTreeee(postorder, s1, e1 - k - 1, inorder, s2, e2 - k - 1);
        root.right = buildTreeee(postorder, e1 - k, e1 - 1, inorder, s2 - k + 1, e2);
        return root;
    }
}
