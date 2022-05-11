package com.company;

import com.company.modle.Node;

public class LeetCode117 {
    public static Node connect(Node root) {
        if (root == null) return root;
        Node head = new Node(0);
        Node headCur = head;
        Node cur = root;
        while (true) {
            while (cur != null) {
                if (cur.left != null) {
                    headCur.next = cur.left;
                    headCur = headCur.next;
                }
                if (cur.right != null) {
                    headCur.next = cur.right;
                    headCur = headCur.next;
                }
                cur = cur.next;
            }
            cur = head.next;
            head.next = null;
            headCur = head;
            if (cur == null) {
                break;
            }
        }

        return root;
    }

    public static void main(String[] args) {
        Node n1 = new Node(2);
        Node n2 = new Node(1);
        Node n3 = new Node(3);
        n1.left = n2;
        n1.right = n3;
        Node n4 = new Node(0);
        Node n5 = new Node(7);
        Node n6 = new Node(9);
        Node n7 = new Node(1);
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        Node n8 = new Node(2);
        Node n9 = new Node(1);
        Node n10 = new Node(0);
        Node n11 = new Node(8);
        Node n12 = new Node(8);
        n4.left = n8;
        n5.left = n9;
        n5.right = n10;
        n7.left = n11;
        n7.right = n12;
        Node n13 = new Node(7);
        n10.left = n13;
        connect(n1);


    }
}
