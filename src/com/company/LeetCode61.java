package com.company;

import com.company.modle.ListNode;

public class LeetCode61 {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||head.next == null){
            return head;
        }
        int count = 0;
        ListNode p = head;
        ListNode tail = head;
        while (p != null) {
            count++;
            tail=p;
            p = p.next;
        }

        int mod = k % count;
        if (mod == 0) {
            return head;
        }

        int fk = 0;
        ListNode q = head;
        ListNode pre = null;
        while (fk + k < count) {
            pre = q;
            q = q.next;
            fk++;

        }

        pre.next = null;
        tail.next = head;
        head = q;

        return head;
    }
}
