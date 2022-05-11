package com.company;

import com.company.modle.Node;

import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode116 {
    public static Node connect(Node root) {

        if (root == null) return root;
        Deque<Node> deque = new ArrayDeque<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                Node p = deque.removeFirst();
                if (p.left != null) deque.addLast(p.left);
                if (p.right != null) deque.addLast(p.right);
                if (i == size - 1) {
                    p.next = null;
                    break;
                }
                Node right = deque.peekFirst();
                p.next = right;

            }
        }
        return root;
    }

    public static Node connect1(Node root) {
        if (root == null || root.left == null) return root;
        root.left.next = root.right;

        if (root.next!=null)
            root.right.next = root.next.left;
        connect(root.left);
        connect(root.right);
        return root;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        connect(n1);

    }
}
