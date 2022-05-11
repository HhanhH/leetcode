package com.company;

import com.company.modle.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode95 {

    public static List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        return dfs(1, n);
    }

    public static List<TreeNode> dfs(int lo, int hi) {
        List<TreeNode> res = new LinkedList<>();
        if (lo > hi) {
            res.add(null);
            return res;
        }
        for (int i = lo; i <= hi; i++) {
            List<TreeNode> left = dfs(lo, i - 1);
            List<TreeNode> right = dfs(i + 1, hi);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode no = new TreeNode(i);
                    no.left = l;
                    no.right = r;
                    res.add(no);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<TreeNode> root = generateTrees(4);
        LeetCode94 leetCode94 = new LeetCode94();
        for (TreeNode node:root){
            System.out.println(leetCode94.inorderTraversal(node).toString());
        }
    }
}
