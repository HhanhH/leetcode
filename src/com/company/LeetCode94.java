package com.company;

import com.company.modle.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode94 {
    static List<Integer> res = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        midPrint(root);
        return res;
    }

    public static void midPrint(TreeNode root) {
        if (root == null) {
            return;
        }
        midPrint(root.left);
        res.add(root.val);
        midPrint(root.right);
    }
}
