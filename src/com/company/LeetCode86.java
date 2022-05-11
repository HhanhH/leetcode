package com.company;

import com.company.modle.ListNode;

import javax.swing.plaf.SliderUI;

public class LeetCode86 {

    public static ListNode partition(ListNode head, int x) {

        if (head == null || head.next == null)
            return head;

        ListNode moreHead = new ListNode(0);
        ListNode lessHead = new ListNode(0);

        ListNode more = moreHead;
        ListNode less = lessHead;

        ListNode p = head;
        while (p != null) {
            if (p.val >= x) {

                ListNode no = new ListNode(p.val);
                more.next = no;
                more = more.next;

            } else {

                ListNode no = new ListNode(p.val);
                less.next = no;
                less = less.next;

            }
            p = p.next;
        }

        less.next = moreHead.next;

        return lessHead.next;
    }

    public static ListNode slo(ListNode head, int x) {

        if (head == null) return head;
        ListNode newHead = new ListNode(0);
        newHead.next = head;

        ListNode less = newHead;
        ListNode p = head;
        ListNode pre = null;

        while (p != null) {
            if (p.val < x) {
                if (pre == null) {
                    less = p;
                } else {
                    ListNode tmp = new ListNode(p.val);
                    tmp.next = less.next;
                    less.next = tmp;
                    less = tmp;
                    pre.next = p.next;
                }
                p = p.next;
            } else {
                pre = p;
                p = p.next;
            }
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(0);
        ListNode n5 = new ListNode(2);
        ListNode n6 = new ListNode(5);
        ListNode n7 = new ListNode(2);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

        ListNode res = slo(n1, 3);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
