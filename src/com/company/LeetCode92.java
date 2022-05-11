package com.company;

import com.company.modle.ListNode;

import java.util.List;

public class LeetCode92 {
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head.next == null) {
            return head;
        }
        ListNode newhead = new ListNode(0);
        newhead.next = head;
        ListNode tmp = newhead;
        int count = 1;
        while (tmp.next != null && count< left) {
            tmp = tmp.next;
            count++;
        }


        ListNode lef = tmp.next;
        ListNode le = tmp.next;
        ListNode behand = le.next;

        while (behand != null && count+1 <= right) {
            ListNode t = behand.next;
            behand.next = le;
            le = behand;
            behand = t;
            count++;
        }
        tmp.next = le;
        lef.next = behand;
        return newhead.next;
    }

    public static void main(String[] args) {
        ListNode p1 = new ListNode(1);
        ListNode p2 = new ListNode(2);

        ListNode p3 = new ListNode(3);

        ListNode p4 = new ListNode(4);

        ListNode p5 = new ListNode(5);
        ListNode p6 = new ListNode(6);
        ListNode p7 = new ListNode(7);
        ListNode p8 = new ListNode(8);

        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        p4.next = p5;
        p5.next = p6;
        p6.next = p7;
        p7.next = p8;
        ListNode head = reverseBetween(p1, 1, 2);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }

    }
}
