package com.company;

import com.company.modle.ListNode;

public class LeetCode83 {
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode tmp = head;
        ListNode nh = tmp;

        ListNode p = head;

        while (p != null) {
            while (p != null && p.val == tmp.val) {
                p = p.next;
            }
            if (p==null)
                break;

            tmp.next = p;
            tmp = p;

            p = p.next;
        }
        tmp.next = null;
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
        p3.next = p4;
        p4.next = p5;
        p5.next = p6;
        p6.next = p7;

        ListNode node = deleteDuplicates(p1);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
