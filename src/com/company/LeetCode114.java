package com.company;

import com.company.modle.TreeNode;
import sun.reflect.generics.tree.Tree;

import javax.xml.ws.handler.HandlerResolver;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LeetCode114 {

    public static void flatten(TreeNode root) {
        if (root == null) return;
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left != null) {
                TreeNode p = cur.left;
                while (p.right != null) {
                    p = p.right;
                }
                p.right = cur.right;
                cur.right = cur.left;
                cur.left = null;
                cur = cur.right;
            }
        }
    }

    List<TreeNode> res = new ArrayList<>();

    public void flatten2(TreeNode root) {
        if (root == null) return;
        pre(root);
        TreeNode last = root;
        for (int i = 1; i < res.size(); i++) {
            last.right = res.get(i);
            last.left = null;
            last = last.right;
        }
    }

    public void pre(TreeNode root) {
        if (root == null) return;
        res.add(root);
        pre(root.left);
        pre(root.right);
    }


    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        n1.left = n2;
        n1.right = n5;
        n2.left = n3;
        n2.right = n4;
        n5.right = n6;

        System.out.println("1");

    }
}
