package com.company;

import com.company.modle.ListNode;

public class LeetCode82 {
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode tmp = head;
        ListNode nh = null;

        ListNode p = head;

        while (p != null) {
            boolean dup = false;
            while (p != null && p.next != null && p.val == p.next.val) {
                p = p.next;
                dup = true;
            }

            if (dup) {
                p = p.next;
                continue;
            }
            if (nh == null) {
                tmp.val = p.val;
                nh = tmp;
            } else {
                tmp.next.val = p.val;
                tmp = tmp.next;
            }
            p = p.next;
            dup = false;
        }
        tmp.next =null;
        return nh;

    }

    public static void main(String[] args) {
        ListNode p1 = new ListNode(1);
        ListNode p2 = new ListNode(2);
        ListNode p3 = new ListNode(2);
        ListNode p4 = new ListNode(3);
        ListNode p5 = new ListNode(4);
        ListNode p6 = new ListNode(4);
        ListNode p7 = new ListNode(5);
        p1.next = p2;
        p2.next = p3;
//        p3.next = p4;
//        p4.next = p5;
//        p5.next = p6;
//        p6.next = p7;

        ListNode node = deleteDuplicates(p1);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
